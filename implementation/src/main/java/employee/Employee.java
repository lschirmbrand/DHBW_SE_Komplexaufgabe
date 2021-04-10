package employee;

import employee.idCard.IDCard;
import employee.idCard.IDCardFactory;

public abstract class Employee {
    private static int nextID = 0;

    protected int id;
    protected String name;
    protected IDCard idCard;
    protected EmployeeRole role;

    public Employee(String name, String pin, EmployeeRole role) {
        this.id = nextID++;
        this.name = name;
        this.role = role;
        this.idCard = IDCardFactory.create(this, pin);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public EmployeeRole getRole() {
        return role;
    }
}
