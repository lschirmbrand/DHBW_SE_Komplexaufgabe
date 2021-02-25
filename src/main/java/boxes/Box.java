package boxes;

import boxes.configuration.Configuration;
import boxes.idGenerator.IDGenerator;
import boxes.layers.BoxLayer;
import packages.Package;

import java.util.ArrayList;

public class Box implements IBox {
    private String id;
    private BoxLayer[] layers = new BoxLayer[5];

    private IDGenerator idGenerator = new IDGenerator();

    public Box() {
        generateID();
    }

    @Override
    public void generateID() {
        final int numberOfDigits = 5;
        this.id = this.id = idGenerator.generateID(numberOfDigits);
    }

    @Override
    public void fillBox(ArrayList<Package> packages) {
        for (int i = 0; i < layers.length; i++) {
            layers[i] = new BoxLayer(packages);
            for (int j = 0; j < Configuration.instance.numberOfPackagesInBox; j++) {
                packages.remove(0);
            }
        }
    }

    public String getId() {
        return id;
    }

    public BoxLayer[] getLayers() {
        return layers;
    }

    public String getPackageIDs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < layers.length; i++) {
            sb.append(layers[i].idsToString());
            sb.append("+");
        }
        sb.append("$");
        return sb.toString();
    }
}
