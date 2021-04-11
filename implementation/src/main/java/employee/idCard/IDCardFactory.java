package employee.idCard;

import configuration.Configuration;
import employee.Employee;
import utillity.encryption.AESEncryption;
import utillity.encryption.DESEncryption;

public class IDCardFactory {

    public static IDCard create(Employee employee, String pin) {
        String text = String.join(";", String.valueOf(employee.getId()), employee.getName(), employee.getRole().name(), pin, Configuration.instance.superPin);

        String encryptionKey = Configuration.instance.secretKey;

        String magnetStripe = switch (Configuration.instance.encryptionStrategy) {
            case AES -> AESEncryption.encrypt(text, encryptionKey);
            case DES -> DESEncryption.encrypt(text, encryptionKey);
        };

        return new IDCard(magnetStripe);
    }
}
