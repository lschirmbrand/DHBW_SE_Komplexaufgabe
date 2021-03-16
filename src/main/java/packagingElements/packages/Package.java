package packagingElements.packages;


import java.util.concurrent.ThreadLocalRandom;

public class Package {

    private final String id;
    private String[][] content;
    private final int zipCode;
    private final PackageType packageType;
    private final double weight;


    public Package(String id, String[][] content, int zipCode, PackageType packageType, double weight) {
        this.id = id;
        this.content = content;
        this.zipCode = zipCode;
        this.packageType = packageType;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String[][] getContent() {
        return content;
    }

    public String getContentToString() {
        StringBuilder sb = new StringBuilder();
        for (String[] strings : content) {
            sb.append("[");
            for (int w = 0; w < strings.length; w++) {
                sb.append(strings[w]);
                if (w != strings.length - 1) {
                    sb.append("|");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public int getZipCode() {
        return zipCode;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public double getWeight() {
        return weight;
    }

    public void setContent(String[][] content) {
        this.content = content;
    }
}
