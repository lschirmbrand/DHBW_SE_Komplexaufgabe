package idCard;

import configuration.Configuration;
import encryption.AES256;
import idCard.magnetStripe.MagnetStripe;
import idCard.state.Active;
import idCard.state.IIDCardState;

import java.util.Objects;

public class IDCard implements IIDCard {

    public MagnetStripe getMagnetStripe() {
        return magnetStripe;
    }

    private MagnetStripe magnetStripe = new MagnetStripe();

    private int numberWrongInputPin = 0;
    private int numberWrongInputSuper = 0;
    private IIDCardState idCardState;

    public IDCard(){
        setIDCardState(new Active());
    }

    public void encryptMagnetStripe(int id, String name, String role, String pin){
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
        System.out.println(stripeToEncrypt);
        magnetStripe.print(Objects.requireNonNull(AES256.encrypt(stripeToEncrypt)));
    }

    public IIDCardState getState(){
        return this.idCardState;
    }

    public void setIDCardState(IIDCardState idCardState){
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
