package employee;

import employee.idCard.IDCard;

public class Operator extends Employee {
    public Operator(int id, String name) {
        super(id, name, EmployeeRole.OPERATOR);
    }
}
