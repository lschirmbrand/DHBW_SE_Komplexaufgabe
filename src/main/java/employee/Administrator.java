package employee;

import configuration.Configuration;
import employee.idCard.IDCard;

public class Administrator extends Employee {

    private final int id;
    private final String name;
    private final String pin;
    private final EmployeeRoles role = EmployeeRoles.ADMINISTRATOR;
    private final ProfileTypeE profileType;
    private final IDCard idCard;

    public Administrator() {
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

    public enum ProfileTypeE {
        A, B, C
    }

}
