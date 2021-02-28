package boxes;

import configuration.Configuration;
import idGenerator.IDGenerator;
import packages.Package;

import java.util.ArrayList;

public class Box {
    private String id;
    private final BoxLayer[] layers = new BoxLayer[5];
    private final IDGenerator idGenerator = new IDGenerator();

    public Box() {
        generateID();
    }

    private void generateID() {
        final int numberOfDigits = 5;
        this.id = idGenerator.generateID(numberOfDigits);
    }

    public void fillBox(ArrayList<Package> packages) {
        for (int i = 0; i < layers.length; i++) {
            layers[i] = new BoxLayer(packages);
            if (Configuration.instance.numberOfPackagesInBox > 0) {
                packages.subList(0, Configuration.instance.numberOfPackagesInBox).clear();
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getPackageIDs() {
        StringBuilder sb = new StringBuilder();
        for (BoxLayer layer : layers) {
            sb.append(layer.idsToString());
        }
        return sb.toString();
    }
}
