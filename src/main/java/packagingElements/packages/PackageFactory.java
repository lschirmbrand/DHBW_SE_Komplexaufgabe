package packagingElements.packages;

import utillity.idGenerator.IDGenerator;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PackageFactory {

    private static final IDGenerator idGenerator = new IDGenerator();

    private static final int contHeight = 10;
    private static final int contWidth = 10;
    private static final int contLength = 25;

    public static Package buildPackage() {
        // id
        String id = idGenerator.generateID(6);

        // content
        List<Character> pool = IntStream.range(97, 123).mapToObj(value -> (char) value).collect(Collectors.toList());
        pool.addAll(List.of('.', ':', '-', '!'));

        String [][] content = new String[contHeight][contWidth];
        for (int h = 0; h < contHeight; h++) {
            for (int w = 0; w < contWidth; w++) {
                content[h][w] = "";
                for (int l = 0; l < contLength; l++) {
                    content[h][w] += pool.get(ThreadLocalRandom.current().nextInt(0, pool.size()));
                }
            }
        }

        // zip-code
        int zip = ThreadLocalRandom.current().nextInt(1067, 99998 + 1);

        // package type
        double rand = ThreadLocalRandom.current().nextDouble();
        Package.PackageTypeE packageType;
        if (rand < 0.8) {
            packageType = Package.PackageTypeE.NORMAL;
        } else if (rand >= 0.8 && rand < 0.95) {
            packageType = Package.PackageTypeE.EXPRESS;
        } else {
            packageType = Package.PackageTypeE.VALUE;
        }

        // weight
        double weight = ThreadLocalRandom.current().nextInt(100, 500 + 1) / 100.0;

        return new Package(id, content, zip, packageType, weight);
    }

}
