package packagingElements.boxes;

import packagingElements.packages.Package;

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
