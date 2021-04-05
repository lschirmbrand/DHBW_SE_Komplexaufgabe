package employee;

import employee.idCard.IDCard;

public class Administrator extends Employee {
    private final Profile Profile;

    public Administrator(int id, String name, Administrator.Profile profile) {
        super(id, name, EmployeeRole.ADMINISTRATOR);
        Profile = profile;
    }

    public Administrator.Profile getProfile() {
        return Profile;
    }

    public enum Profile {
        A, B, C
    }
}
