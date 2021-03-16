package packageSortingCenter.sortingSystem.storage;

import packagingElements.pallets.Pallet;

import java.util.Stack;

public class StorageEmptyPallet {
    Stack<Pallet> emptyPallets;

    public StorageEmptyPallet() {
        emptyPallets = new Stack<>();
    }

    public void store(Pallet pallet) {
        this.emptyPallets.push(pallet);
    }
}
