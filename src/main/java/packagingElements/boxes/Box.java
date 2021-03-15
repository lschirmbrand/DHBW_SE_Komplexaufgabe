package packagingElements.boxes;

import configuration.Configuration;
import utillity.idGenerator.IDGenerator;
import packagingElements.packages.Package;

import java.util.ArrayList;

public class Box {
    private final String id;
    private final Package[][][] packages;

    public Box(String id, Package[][][] packages) {
        this.id = id;
        this.packages = packages;
    }

    public String getId() {
        return id;
    }

    public Package[][][] getPackages() {
        return packages;
    }

}
