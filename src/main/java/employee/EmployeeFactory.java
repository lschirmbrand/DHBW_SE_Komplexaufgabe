package employee;

import employee.idCard.IDCard;
import employee.idCard.IDCardFactory;

public class EmployeeFactory {
    private static int nextID = 0;

    public static Supervisor createSupervisor(String name, String pin, boolean isSenior) {
        Supervisor supervisor = new Supervisor(nextID++,name, isSenior);
        IDCard card = IDCardFactory.create(supervisor, pin);
        supervisor.setIdCard(card);
        return supervisor;
    }

    public static Administrator createAdministrator(String name, String pin, Administrator.Profile profile) {
        Administrator admin = new Administrator(nextID++, name, profile);
        IDCard card = IDCardFactory.create(admin, pin);
        admin.setIdCard(card);
        return admin;
    }

    public static Operator createOperator(String name, String pin) {
        Operator operator = new Operator(nextID++, name);
        IDCard card = IDCardFactory.create(operator, pin);
        operator.setIdCard(card);
        return operator;
    }

    public static DataAnalyst createDataAnalyst(String name, String pin) {
        DataAnalyst dataAnalyst = new DataAnalyst(nextID++, name);
        IDCard card = IDCardFactory.create(dataAnalyst, pin);
        dataAnalyst.setIdCard(card);
        return dataAnalyst;
    }
}
