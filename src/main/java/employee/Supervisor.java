package employee;

import employee.idCard.IDCard;

public class Supervisor extends Employee {

    public Supervisor(int id, String name, IDCard idCard, String pin, boolean isSenior) {
        super(id, name, idCard, pin, EmployeeRole.SUPERVISOR);
    }
}
