package employee.idCard;

import configuration.Configuration;
import employee.EmployeeRole;
import utillity.encryption.AESEncryption;
import utillity.encryption.DESEncryption;

public class IDCardFactory {

    public static IDCard create(String id, String name, EmployeeRole role, String pin, String superPin) {
        String text = String.join(";", id, name, role.name(), pin, superPin);

        String encryptionKey = Configuration.instance.secretKey;

        String magnetStripe = switch (Configuration.instance.encryptionStrategy) {
            case AES -> AESEncryption.encrypt(text, encryptionKey);
            case DES -> DESEncryption.encrypt(text, encryptionKey);
        };

        return new IDCard(magnetStripe);
    }
}
