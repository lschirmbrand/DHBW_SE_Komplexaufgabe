package terminal;

import employee.idCard.IDCard;

public interface ITerminal {
    void idCardSwipe(IDCard idCard);

    boolean confirmPin(IDCard idCard);

    boolean confirmSuperPin(IDCard idcard);

    String getEncryptedPin(IDCard idCard);
}
