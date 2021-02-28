package proxy;

import control.ControlUnit;
import employee.Employee;

public class RealAccess implements IAccess {

    private final Employee employee;
    private ControlUnit controlUnit;

    public RealAccess(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void grantInit() {

    }

    @Override
    public void grantNext() {

    }

    @Override
    public void grantLock() {

    }

    @Override
    public void grantUnlock() {

    }

    @Override
    public void grantChangeAlgorithm() {

    }

    @Override
    public void grantShowStatistics() {

    }

    @Override
    public void grantShutdown() {

    }
}
