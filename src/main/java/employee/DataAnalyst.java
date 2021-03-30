package employee;

import employee.idCard.IDCard;

public class DataAnalyst extends Employee {
    public DataAnalyst(int id, String name, IDCard idCard, String pin) {
        super(id, name, idCard, pin, EmployeeRole.DATA_ANALYST);
    }
}
