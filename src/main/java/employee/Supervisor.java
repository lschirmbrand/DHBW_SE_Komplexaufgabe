package employee;

import employee.idCard.IDCard;

public class Supervisor extends Employee {

    public Supervisor(int id, String name, boolean isSenior) {
        super(id, name, EmployeeRole.SUPERVISOR);
    }
}
