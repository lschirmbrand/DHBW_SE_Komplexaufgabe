package employee;

import configuration.Configuration;
import employee.idCard.IDCard;

public class Operator extends Employee {
    private int id;
    private String name;
    private String pin;
    private EmployeeRoles role = EmployeeRoles.OPERATOR;
    private IDCard idCard;

    public Operator() {
        this.id = 1337;
        this.name = Configuration.instance.nameOfAdministrator;
        this.pin = "pincode";
        this.idCard = new IDCard();
        this.idCard.encryptMagnetStripe(id, name, role.toString(), this.pin);
    }

    public EmployeeRoles getRole() {
        return role;
    }
}
