package packagingElements.pallets;

import packagingElements.boxes.Box;

import java.util.ArrayList;

public interface IPallet {
    void generateID(int id);

    void fillPallet(ArrayList<Box> boxes);
}
