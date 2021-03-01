package packagingElements.packages;


import java.util.concurrent.ThreadLocalRandom;

public class Package {

    private final String id;
    private final String[][] content;
    private final int zipCode;
    private final PackageTypeE packageType;
    private final double weight;


    public Package(String id, String[][] content, int zipCode, PackageTypeE packageType, double weight) {
        this.id = id;
        this.content = content;
        this.zipCode = zipCode;
        this.packageType = packageType;
        this.weight = weight;
    }

    public void addExplosive() {
        String exp = "exp|os!ve";
        int contHeight = 10;
        int h = ThreadLocalRandom.current().nextInt(contHeight);
        int contWidth = 10;
        int w = ThreadLocalRandom.current().nextInt(contWidth);
        int contLength = 25;
        int l = ThreadLocalRandom.current().nextInt(contLength - exp.length() + 1);

        String line = content[h][w];
        line = line.substring(0, l) + exp + line.substring(l + exp.length());
        content[h][w] = line;
    }

    public String getId() {
        return id;
    }

    public String[][] getContent() {
        return content;
    }

    public String getContentToString() {
        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < content.length; h++) {
            sb.append("[");
            for (int w = 0; w < content[h].length; w++) {
                sb.append(this.content[h][w]);
                if (w != content[h].length - 1) {
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

    public PackageTypeE getPackageType() {
        return packageType;
    }

    public double getWeight() {
        return weight;
    }

    public enum PackageTypeE {
        NORMAL, EXPRESS, VALUE
    }
}
