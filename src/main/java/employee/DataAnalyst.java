package employee;

import employee.idCard.IDCard;

public class DataAnalyst extends Employee {
    public DataAnalyst(int id, String name) {
        super(id, name, EmployeeRole.DATA_ANALYST);
    }
}
