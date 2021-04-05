package employee;

import employee.idCard.IDCard;

public abstract class Employee {
    protected int id;
    protected String name;

    protected IDCard idCard;

    protected EmployeeRole role;

    public Employee(int id, String name, EmployeeRole role) {
        this.id = id;
        this.name = name;
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

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    public EmployeeRole getRole() {
        return role;
    }
}
