package packagingElements.pallets;

import packagingElements.boxes.Box;

public class Pallet {

    private final int id;
    private final Box[][][] boxes;

    public Pallet(int id, Box[][][] boxes) {
        this.id = id;
        this.boxes = boxes;
    }

    public int getId() {
        return id;
    }

    public Box[][][] getBoxes() {
        return boxes;
    }
}
