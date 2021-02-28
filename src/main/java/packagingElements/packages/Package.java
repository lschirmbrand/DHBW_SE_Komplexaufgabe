package packagingElements.packages;


import utillity.idGenerator.IDGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Package implements IPackage {

    private final int contHeight = 10;
    private final int contWidth = 10;
    private final int contLength = 25;
    private String id;
    private char[][][] content;
    private int zipCode;
    private PackageTypeE packageType;
    private double weight;
    private final IDGenerator idGenerator = new IDGenerator();

    public Package() {
        generateID();
        generateContent();
        generateZipCode();
        generateWeight();
    }

    @Override
    public void generateID() {
        final int numberOfDigits = 6;
        this.id = idGenerator.generateID(numberOfDigits);
    }

    @Override
    public void generateContent() {
        content = new char[contHeight][contWidth][contLength];
        for (int h = 0; h < contHeight; h++) {
            for (int w = 0; w < contWidth; w++) {
                for (int l = 0; l < contLength; l++) {
                    if (ThreadLocalRandom.current().nextInt(0, 1 + 1) == 0) {
                        //Alphabetic (a...z)
                        this.content[h][w][l] = (char) ThreadLocalRandom.current().nextInt(97, 122 + 1);
                    } else {
                        //Special Chars (".";":";"-";"!")
                        int temp = ThreadLocalRandom.current().nextInt(0, 3 + 1);
                        if (temp == 0) {
                            this.content[h][w][l] = '.';
                        } else if (temp == 1) {
                            this.content[h][w][l] = ':';
                        } else if (temp == 2) {
                            this.content[h][w][l] = '-';
                        } else {
                            this.content[h][w][l] = '!';
                        }
                    }
                }
            }
        }
    }

    @Override
    public void generateZipCode() {
        this.zipCode = ThreadLocalRandom.current().nextInt(1067, 99998 + 1);
    }

    @Override
    public void generateSendingType() {

    }

    @Override
    public void generateWeight() {
        float temp = ThreadLocalRandom.current().nextInt(100, 500 + 1);
        this.weight = temp / 100;
    }

    public String getId() {
        return id;
    }

    public char[][][] getContent() {
        return content;
    }

    public String getContentToString() {
        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < contHeight; h++) {
            for (int w = 0; w < contWidth; w++) {
                for (int l = 0; l < contLength; l++) {
                    sb.append(this.content[h][w][l]);
                    if (l == contLength - 1) {
                        sb.append("#");
                    } else {
                        sb.append("|");
                    }
                }
                if (w == contHeight - 1) {
                    sb.append("+");
                }
            }
            if (h == contHeight - 1) {
                sb.append("$");
            }
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
