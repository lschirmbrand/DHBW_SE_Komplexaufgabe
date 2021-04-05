package employee;

public class Supervisor extends Employee {

    private final boolean isSenior;

    public Supervisor(String name, String pin, boolean isSenior) {
        super(name, pin, EmployeeRole.SUPERVISOR);
        this.isSenior = isSenior;
    }

    public boolean isSenior() {
        return isSenior;
    }
}
