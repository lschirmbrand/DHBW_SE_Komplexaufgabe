package packageSortingCenter.sortingSystem.storage;

import packagingElements.boxes.Box;

import java.util.Stack;

public class StorageEmptyBox {
    private final Stack<Box> emptyBoxes;

    public StorageEmptyBox() {
        emptyBoxes = new Stack<>();
    }

    public void store(Box box) {
        emptyBoxes.push(box);
    }
}
