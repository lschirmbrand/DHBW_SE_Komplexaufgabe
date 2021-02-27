package packages;


import boxes.idGenerator.IDGenerator;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Package implements IPackage {

    private final int contHeight = 2;
    private final int contWidth = 2;
    private final int contLength = 2;
    private String id;
    private char[][][] content;
    private int zipCode;
    private PackageTypeE packageType;
    private double weight;
    private IDGenerator idGenerator = new IDGenerator();

    public Package() {
        generateID();
        generateContent();
        generateZipCode();
        generateSendingType();
        generateWeight();
    }

    @Override
    public void generateID() {
        final int numberOfDigits = 6;
        this.id = idGenerator.generateID(numberOfDigits);
    }

    @Override
    public void generateContent() {
        List<Character> pool = IntStream.range(97, 123).mapToObj(value -> (char) value).collect(Collectors.toList());
        pool.addAll(List.of('.', ':', '-', '!'));

        content = new char[contHeight][contWidth][contLength];
        for (int h = 0; h < contHeight; h++) {
            for (int w = 0; w < contWidth; w++) {
                for (int l = 0; l < contLength; l++) {
                    this.content[h][w][l] = pool.get(ThreadLocalRandom.current().nextInt(0, pool.size()));
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
        int rand = ThreadLocalRandom.current().nextInt(3);

        packageType = switch(rand) {
          case 0 -> PackageTypeE.NORMAL;
          case 1 -> PackageTypeE.EXPRESS;
          case 2 -> PackageTypeE.VALUE;
            default -> throw new IllegalStateException("Unexpected value: " + rand);
        };
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
