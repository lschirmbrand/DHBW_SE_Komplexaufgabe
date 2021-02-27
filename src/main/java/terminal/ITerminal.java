package terminal;

import idCard.IDCard;

public interface ITerminal {
    public void idCardSwipe(IDCard idCard);
    public boolean confirmPin(IDCard idCard);
    public boolean confirmSuperPin(IDCard idcard);
    public String getEncryptedPin(IDCard idCard);
}
