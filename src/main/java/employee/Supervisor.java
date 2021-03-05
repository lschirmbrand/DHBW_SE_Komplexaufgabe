package employee;

import configuration.Configuration;
import employee.idCard.IDCard;

public class Supervisor {
    private int id;
    private String name;
    private boolean isSenior;
    private String pin;
    private EmployeeRoles role = EmployeeRoles.SUPERVISOR;

    private IDCard idCard;

    public Supervisor() {
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
