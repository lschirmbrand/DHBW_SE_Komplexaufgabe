package configuration;

public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public String commonPathToJavaArchive = userDirectory + fileSeparator + "components" + fileSeparator;

    public String pathToBoyerMooreArchive = archivePath("boyer_moore");
    public String pathToRabinKarpArchive = archivePath("rabin_karp");


    public int numberOfPackages = 24000;
    public int numberOfBoxes = 600;
    public int numberOfPallets = 50;
    public int numberOfLKWS = 5;

    public int packageHeight = 10;
    public int packageWidth = 10;
    public int packageLength = 25;

    public int numberOfPackagesInBox = 8;
    public int numberOfBoxLayers = 3;


    public int numberOfUnloadingZones = 7;
    public int numberOfAutonomousVehicles = 5;

    public String nameOfAdministrator = "Gustav Admin";


    public String superPin = "superPinKlasse";

    public EncryptionStrategy encryptionStrategy = EncryptionStrategy.AES;

    public String secretKey = "dhbw";

    private String archivePath(String name) {
        return commonPathToJavaArchive + name + fileSeparator + "build" + fileSeparator + "libs" + fileSeparator + name + ".jar";
    }
}
