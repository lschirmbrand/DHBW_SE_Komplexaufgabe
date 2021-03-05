package employee.idCard;


public class IDCard {
    private final String magnetStripe;
    private IDCardState idCardState;

    public IDCard(String magnetStripe) {
        this.magnetStripe = magnetStripe;
        this.idCardState = IDCardState.ACTIVE;
    }

    public String getMagnetStripe() {
        return magnetStripe;
    }

    public IDCardState getIdCardState() {
        return idCardState;
    }

    public void setIdCardState(IDCardState cardState) {
        this.idCardState = cardState;
    }
}
