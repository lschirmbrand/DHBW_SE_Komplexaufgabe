package packagingElements.packages;


import java.util.concurrent.ThreadLocalRandom;

public class Package {

    private final String id;
    private final String[][] content;
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

    public void addExplosive() {
        String exp = "exp|os!ve";
        int contHeight = content.length;
        int h = ThreadLocalRandom.current().nextInt(contHeight);
        int contWidth = content[0].length;
        int w = ThreadLocalRandom.current().nextInt(contWidth);
        int contLength = content[0][0].length();
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

}
