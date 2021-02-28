package proxy;

import employee.Employee;
import employee.EmployeeRoles;

public class ProxyAccess implements IAccess {

    private Employee employee;
    private RealAccess realAccess;

    public ProxyAccess(Employee employee) {
        this.employee = employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void grantInit() {
        if ((employee.getRole() == EmployeeRoles.SUPERVISOR)) {
            realAccess = new RealAccess(this.employee);
            realAccess.grantInit();
        } else {
            System.out.println("Berechtigungsstufe nicht ausreichend");
        }
    }

    @Override
    public void grantNext() {
        if ((employee.getRole() == EmployeeRoles.SUPERVISOR)
                || (employee.getRole() == EmployeeRoles.OPERATOR)) {
            realAccess = new RealAccess(this.employee);
            realAccess.grantNext();
        } else {
            System.out.println("Berechtigungsstufe nicht ausreichend");
        }
    }

    @Override
    public void grantLock() {
        if ((employee.getRole() == EmployeeRoles.SUPERVISOR)) {
            realAccess = new RealAccess(this.employee);
            realAccess.grantLock();
        } else {
            System.out.println("Berechtigungsstufe nicht ausreichend");
        }
    }

    @Override
    public void grantUnlock() {
        if ((employee.getRole() == EmployeeRoles.SUPERVISOR)) {
            realAccess = new RealAccess(this.employee);
            realAccess.grantUnlock();
        } else {
            System.out.println("Berechtigungsstufe nicht ausreichend");
        }
    }

    @Override
    public void grantChangeAlgorithm() {
        if ((employee.getRole() == EmployeeRoles.SUPERVISOR)) {
            realAccess = new RealAccess(this.employee);
            realAccess.grantChangeAlgorithm();
        } else {
            System.out.println("Berechtigungsstufe nicht ausreichend");
        }
    }

    @Override
    public void grantShowStatistics() {
        if ((employee.getRole() == EmployeeRoles.SUPERVISOR)
                || (employee.getRole() == EmployeeRoles.ADMINISTRATOR)
                || (employee.getRole() == EmployeeRoles.OPERATOR)
                || (employee.getRole() == EmployeeRoles.DATAANALYST)) {
            realAccess = new RealAccess(this.employee);
            realAccess.grantShowStatistics();
        } else {
            System.out.println("Berechtigungsstufe nicht ausreichend");
        }
    }

    @Override
    public void grantShutdown() {
        if ((employee.getRole() == EmployeeRoles.SUPERVISOR)
                || (employee.getRole() == EmployeeRoles.ADMINISTRATOR)) {
            realAccess = new RealAccess(this.employee);
            realAccess.grantShutdown();
        } else {
            System.out.println("Berechtigungsstufe nicht ausreichend");
        }
    }
}
