package employee;

public class Administrator extends Employee {
    private final Profile Profile;

    public Administrator(String name, String pin, Administrator.Profile profile) {
        super(name, pin, EmployeeRole.ADMINISTRATOR);
        Profile = profile;
    }

    public Administrator.Profile getProfile() {
        return Profile;
    }

    public enum Profile {
        A, B, C
    }
}
