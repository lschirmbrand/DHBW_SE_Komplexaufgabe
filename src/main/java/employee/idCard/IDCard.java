package employee.idCard;

import configuration.Configuration;
import utillity.encryption.*;
import employee.idCard.magnetStripe.MagnetStripe;
import employee.idCard.state.Active;
import employee.idCard.state.IIDCardState;

import java.util.Objects;

public class IDCard implements IIDCard {

    private final MagnetStripe magnetStripe = new MagnetStripe();
    private int numberWrongInputPin = 0;
    private int numberWrongInputSuper = 0;
    private IIDCardState idCardState;
    private String encryptionType = Configuration.instance.aesAlgorithm;
    public IDCard() {
        setIDCardState(new Active());
    }

    public MagnetStripe getMagnetStripe() {
        return magnetStripe;
    }

    public void encryptMagnetStripe(int id, String name, String role, String pin) {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(";");
        sb.append(name);
        sb.append(";");
        sb.append(role);
        sb.append(";");
        sb.append(pin);
        sb.append(";");
        sb.append(Configuration.instance.superPin);
        sb.append("#");
        String stripeToEncrypt = sb.toString();
        if(encryptionType.equals(Configuration.instance.aesAlgorithm)){
            try {
                magnetStripe.print(Objects.requireNonNull(AES256.encrypt(stripeToEncrypt)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                magnetStripe.print(Objects.requireNonNull(DES256.encrypt(stripeToEncrypt)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public IIDCardState getState() {
        return this.idCardState;
    }

    public void setIDCardState(IIDCardState idCardState) {
        this.idCardState = idCardState;
    }

    public int getNumberWrongInputPin() {
        return numberWrongInputPin;
    }

    public void setNumberWrongInputPin(int numberWrongInputPin) {
        this.numberWrongInputPin = numberWrongInputPin;
    }

    public int getNumberWrongInputSuper() {
        return numberWrongInputSuper;
    }

    public void setNumberWrongInputSuper(int numberWrongInputSuper) {
        this.numberWrongInputSuper = numberWrongInputSuper;
    }
}
