package employee;

import configuration.Configuration;
import idCard.IDCard;

public class Administrator  extends Employee {

    public enum ProfileTypeE{
        A,B,C;
    }
    private int id;
    private String name;
    private String pin;

    private EmployeeRoles role = EmployeeRoles.ADMINISTRATOR;
    private ProfileTypeE profileType;

    private IDCard idCard;


    public Administrator(){
        this.id = 1337;
        this.name = Configuration.instance.nameOfAdministrator;
        this.profileType = ProfileTypeE.A;
        this.pin = "pincode";
        this.idCard = new IDCard();
        this.idCard.encryptMagnetStripe(id, name, role.toString(), this.pin);
    }

    public EmployeeRoles getRole() {
        return role;
    }

}
