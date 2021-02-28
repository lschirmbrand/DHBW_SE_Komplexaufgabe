package configuration;

public enum Configuration {
    instance;
    public int numberOfPackages = 24000;
    public int numberOfBoxes = 600;
    public int numberOfPallets = 50;
    public int numberOfLKWS = 5;

    public int numberOfPackagesInBox = 8;
    public int numberOfBoxLayers = 3;


    public int numberOfUnloadingZones = 7;
    public int numberOfParkingZoneAutonom = 5;

    public String nameOfAdministrator = "Gustav Admin";


    public String superPin = "superPinKlasse";

    public String aesAlgorithm = "AES";
    public String desAlgorithm = "DES";

    public String secretKey = "dhbw";

    public String algorithmBM = "bm";
    public String algorithmRK = "rk";
}
