package packageSortingCenter.sortingSystem;

import packagingElements.boxes.Box;

import java.util.Stack;

public class EmptyBoxStorage {
    private final Stack<Box> emptyBoxes;

    public EmptyBoxStorage() {
        emptyBoxes = new Stack<>();
    }

    public void store(Box box) {
        emptyBoxes.push(box);
    }
}
