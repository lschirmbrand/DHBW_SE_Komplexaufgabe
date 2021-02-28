package packagingElements.boxes;

import packagingElements.packages.Package;

import java.util.ArrayList;

public interface IBox {
    void generateID();

    void fillBox(ArrayList<Package> packages);
}
