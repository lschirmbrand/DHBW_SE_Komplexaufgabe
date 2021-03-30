package employee;

import employee.idCard.IDCard;

public class Operator extends Employee {
    public Operator(int id, String name, IDCard idCard, String pin) {
        super(id, name, idCard, pin, EmployeeRole.OPERATOR);
    }
}
