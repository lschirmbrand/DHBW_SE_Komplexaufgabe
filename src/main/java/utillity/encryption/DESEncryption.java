package utillity.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DESEncryption {

    public static String encrypt(String plainMessage, String key) {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(key.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted = cipher.doFinal(plainMessage.getBytes());
            strData = new String(encrypted);

        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.getMessage());
        }
        return strData;
    }

    public static String decrypt(String encryptedMessage, String key) {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(key.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted = cipher.doFinal(encryptedMessage.getBytes());
            strData = new String(decrypted);

        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.getMessage());
        }
        return strData;
    }
}

