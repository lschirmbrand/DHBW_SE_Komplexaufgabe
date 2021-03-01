package packageSortingCenter.sortingSystem.storage;

import packagingElements.boxes.Box;

import java.util.ArrayList;

public class StorageEmptyBox {
    ArrayList<Box> emptyBoxes;

    public StorageEmptyBox(){
        emptyBoxes = new ArrayList<>();
    }

    public void putBoxOn(Box box){
        emptyBoxes.add(box);
    }
}
