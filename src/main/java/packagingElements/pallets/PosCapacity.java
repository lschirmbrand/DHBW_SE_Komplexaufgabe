package packagingElements.pallets;

import packagingElements.boxes.Box;

import java.util.ArrayList;

public class PosCapacity {
    private final Box[] layers = new Box[3];

    public PosCapacity(ArrayList<Box> boxes) {
        fillLayers(boxes);
    }

    public void fillLayers(ArrayList<Box> boxes) {
        for (int i = 0; i < layers.length; i++) {
            layers[i] = boxes.get(i);
        }
    }

    public String LayerToString(int i) {
        return layers[i].getId();
    }
}
