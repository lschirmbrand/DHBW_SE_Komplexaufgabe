package employee;

import configuration.Configuration;
import employee.idCard.IDCard;

public class Administrator extends Employee {
    private final Profile Profile;

    public Administrator(int id, String name, IDCard idCard, String pin, Administrator.Profile profile) {
        super(id, name, idCard, pin, EmployeeRole.ADMINISTRATOR);
        Profile = profile;
    }

    public enum Profile {
        A, B, C
    }

}
