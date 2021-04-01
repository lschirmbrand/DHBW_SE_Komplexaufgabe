package packageSortingCenter.sortingSystem.storage;

import packagingElements.pallets.Pallet;

import java.util.Stack;

public class StorageEmptyPallet {
    private final Stack<Pallet> emptyPallets;

    public StorageEmptyPallet() {
        emptyPallets = new Stack<>();
    }

    public void store(Pallet pallet) {
        this.emptyPallets.push(pallet);
    }
}
