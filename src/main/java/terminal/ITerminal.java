package terminal;

import idCard.IDCard;

public interface ITerminal {
    void idCardSwipe(IDCard idCard);

    boolean confirmPin(IDCard idCard);

    boolean confirmSuperPin(IDCard idcard);

    String getEncryptedPin(IDCard idCard);
}
