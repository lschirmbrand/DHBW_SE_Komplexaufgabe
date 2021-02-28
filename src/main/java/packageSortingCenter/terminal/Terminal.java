package packageSortingCenter.terminal;

import utillity.encryption.AES256;
import employee.idCard.IDCard;
import employee.idCard.magnetStripe.MagnetStripe;
import employee.idCard.state.Active;
import employee.idCard.state.Invalid;
import employee.idCard.state.Locked;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Terminal implements ITerminal {

    @Override
    public void idCardSwipe(IDCard idcard) {
        if (idcard.getState() == new Active()) {
            if (confirmPin(idcard)) {

            } else {
                if (idcard.getNumberWrongInputPin() == 3) {
                    System.out.println("Falsche Eingabe. Durch 3malige falsche Eingabe gesperrt.");
                    idcard.setIDCardState(new Locked());
                } else {
                    System.out.println("Falsche Eingabe. " + (3 - idcard.getNumberWrongInputPin()) + " Versuche verbleibend.");
                }

            }
        } else if (idcard.getState() == new Locked()) {
            if (confirmSuperPin(idcard)) {
                idcard.setIDCardState(new Active());
            } else {
                if (idcard.getNumberWrongInputSuper() == 2) {
                    System.out.println("Falsche Eingabe. Durch 2malige falsche Eingabe Gültigkeit entfernt.");
                    idcard.setIDCardState(new Invalid());
                } else {
                    System.out.println("Falsche Eingabe. " + (2 - idcard.getNumberWrongInputSuper()) + " Versuche verbleibend.");
                }
            }
        } else {
            System.out.println("Karte ungültig. Bitte entfernen.");
        }

    }


    @Override
    public boolean confirmPin(IDCard idcard) {
        String decryptedPin = getEncryptedPin(idcard);
        Scanner scanner = new Scanner(System.in);
        if (decryptedPin.equals(scanner.nextLine())) {
            idcard.setNumberWrongInputPin(0);
            return true;
        } else {
            idcard.setNumberWrongInputPin(idcard.getNumberWrongInputPin() + 1);
            return false;
        }
    }

    @Override
    public boolean confirmSuperPin(IDCard idcard) {
        String decryptedSuperPin = getEncryptedSuperPin(idcard);
        Scanner scanner = new Scanner(System.in);
        if (decryptedSuperPin.equals(scanner.nextLine())) {
            idcard.setNumberWrongInputPin(0);
            return true;
        } else {
            idcard.setNumberWrongInputSuper(idcard.getNumberWrongInputSuper() + 1);
            return false;
        }
    }

    private String getEncryptedSuperPin(IDCard idcard) {
        MagnetStripe magnetStripe = idcard.getMagnetStripe();
        String stringEncrypted = Arrays.toString(magnetStripe.getEncryptedString()[0]);
        String decryptedString = Objects.requireNonNull(AES256.decrypt(stringEncrypted));
        String[] splitElements = decryptedString.split(";");
        return splitElements[4];
    }

    @Override
    public String getEncryptedPin(IDCard idcard) {
        MagnetStripe magnetStripe = idcard.getMagnetStripe();
        String stringEncrypted = Arrays.toString(magnetStripe.getEncryptedString()[0]);
        String decryptedString = Objects.requireNonNull(AES256.decrypt(stringEncrypted));
        String[] splitElements = decryptedString.split(";");
        return splitElements[3];
    }
}
