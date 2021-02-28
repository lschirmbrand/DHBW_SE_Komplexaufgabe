package packages;


import boxes.idGenerator.IDGenerator;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Package {

    private final int contHeight = 10;
    private final int contWidth = 10;
    private final int contLength = 25;
    private final IDGenerator idGenerator = new IDGenerator();
    private String id;
    private String[][] content;
    private int zipCode;
    private PackageTypeE packageType;
    private double weight;

    public Package() {
        generateID();
        generateContent();
        generateZipCode();
        generateSendingType();
        generateWeight();
    }

    private void generateID() {
        final int numberOfDigits = 6;
        this.id = idGenerator.generateID(numberOfDigits);
    }

    private void generateContent() {
        List<Character> pool = IntStream.range(97, 123).mapToObj(value -> (char) value).collect(Collectors.toList());
        pool.addAll(List.of('.', ':', '-', '!'));

        content = new String[contHeight][contWidth];
        for (int h = 0; h < contHeight; h++) {
            for (int w = 0; w < contWidth; w++) {
                content[h][w] = "";
                for (int l = 0; l < contLength; l++) {
                    content[h][w] += pool.get(ThreadLocalRandom.current().nextInt(0, pool.size()));
                }
            }
        }
    }

    private void generateZipCode() {
        this.zipCode = ThreadLocalRandom.current().nextInt(1067, 99998 + 1);
    }

    private void generateSendingType() {
        double rand = ThreadLocalRandom.current().nextDouble();
        if (rand < 0.8) {
            this.packageType = PackageTypeE.NORMAL;
        } else if (rand >= 0.8 && rand < 0.95) {
            this.packageType = PackageTypeE.EXPRESS;
        } else {
            this.packageType = PackageTypeE.VALUE;
        }
    }

    private void generateWeight() {
        float temp = ThreadLocalRandom.current().nextInt(100, 500 + 1);
        this.weight = temp / 100;
    }

    public void addExplosive() {
        String exp = "exp|os!ve";
        int h = ThreadLocalRandom.current().nextInt(contHeight);
        int w = ThreadLocalRandom.current().nextInt(contWidth);
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
        for (int h = 0; h < contHeight; h++) {
            sb.append("[");
            for (int w = 0; w < contWidth; w++) {
                sb.append(this.content[h][w]);
                if (w != contWidth - 1) {
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
