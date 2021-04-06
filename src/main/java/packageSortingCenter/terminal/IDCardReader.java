package packageSortingCenter.terminal;

import configuration.Configuration;
import employee.EmployeeRole;
import employee.idCard.IDCard;
import employee.idCard.IDCardState;
import utillity.encryption.AESEncryption;
import utillity.encryption.DESEncryption;

public class IDCardReader {

    private final Terminal terminal;

    private int pinTrialsLeft = 0;
    private int superPinTrialsLeft = 0;

    private IDCard card;
    private String correctPin;
    private String correctSuperPin;
    private EmployeeRole roleToAuthenticate;

    public IDCardReader(Terminal terminal) {
        this.terminal = terminal;
    }


    public String readCard(IDCard card) {
        if (card.getIdCardState() == IDCardState.INVALID) {
            return "Card is Invalid";
        }

        String key = Configuration.instance.secretKey;

        String plainStripe = switch (Configuration.instance.encryptionStrategy) {
            case AES -> AESEncryption.decrypt(card.getMagnetStripe(), key);
            case DES -> DESEncryption.decrypt(card.getMagnetStripe(), key);
        };

        assert plainStripe != null;
        String[] subStrings = plainStripe.split(";");

        roleToAuthenticate = switch (subStrings[2]) {
            case "ADMINISTRATOR" -> EmployeeRole.ADMINISTRATOR;
            case "SUPERVISOR" -> EmployeeRole.SUPERVISOR;
            case "OPERATOR" -> EmployeeRole.OPERATOR;
            case "DATA_ANALYST" -> EmployeeRole.DATA_ANALYST;
            default -> throw new IllegalStateException("Unexpected value: " + subStrings[2]);
        };
        correctPin = subStrings[3];
        correctSuperPin = subStrings[4];
        this.card = card;

        pinTrialsLeft = 3;
        superPinTrialsLeft = 3;

        return "Please enter PIN";
    }

    public String enterPin(String pin) {
        if (pinTrialsLeft == 0) {
            return "No trials Left, enter Super PIN";
        }

        if (pin.equals(correctPin)) {
            terminal.authenticateRole(roleToAuthenticate);
            return "Successfully authenticated as " + roleToAuthenticate;
        } else {
            if (--pinTrialsLeft == 0) {
                card.setIdCardState(IDCardState.LOCKED);
                return "Wrong PIN. No Trials Left, enter Super PIN";
            } else {
                return "Wrong PIN, " + pinTrialsLeft + " trials left";
            }
        }
    }

    public String enterSuperPin(String superPin) {
        if (superPinTrialsLeft == 0) {
            return "No trials Left";
        }

        if (superPin.equals(correctSuperPin)) {
            terminal.authenticateRole(roleToAuthenticate);
            card.setIdCardState(IDCardState.ACTIVE);
            return "Successfully authenticated as " + roleToAuthenticate;
        } else {
            if (--superPinTrialsLeft == 0) {
                card.setIdCardState(IDCardState.INVALID);
                return "Wrong Super PIN. No Trials Left. Card is now Invalid.";
            } else {
                return "Wrong Super PIN, " + pinTrialsLeft + " trials left";
            }
        }
    }
}
