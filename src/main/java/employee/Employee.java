package employee;

import employee.idCard.IDCard;

public abstract class Employee {
    protected int id;
    protected String name;

    protected IDCard idCard;
    protected String pin;

    protected EmployeeRole role;

    public Employee(int id, String name, IDCard idCard, String pin, EmployeeRole role) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.pin = pin;
        this.role = role;
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
