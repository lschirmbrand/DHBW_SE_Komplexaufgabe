package utillity.encryption;

public interface IEncryptionStrategy {
    String encrypt(String plainMessage, String key);

    String decrypt(String encryptedMessage, String key);
}
