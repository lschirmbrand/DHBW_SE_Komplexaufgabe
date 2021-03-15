package packagingElements.boxes;

import packagingElements.packages.Package;
import utillity.idGenerator.IDGenerator;

import java.util.List;

public class BoxFactory {

    private static final IDGenerator idGenerator = new IDGenerator();

    public static Box build(List<Package> packages) {
        String id = idGenerator.generateID(5);

        Package[][][] layers = new Package[5][2][4];

        for (int i = 0; i < packages.size(); i++) {
            int layer = i / 8;
            int side = (i / 4) % 2;
            int pack = i % 4;

            layers[layer][side][pack] = packages.get(i);
            System.out.println(layer + " " + side + " " + pack);
        }
        return new Box(id, layers);
    }

}
