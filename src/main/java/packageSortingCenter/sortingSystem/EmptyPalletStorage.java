package packageSortingCenter.sortingSystem;

import packagingElements.pallets.Pallet;

import java.util.Stack;

public class EmptyPalletStorage {
    private final Stack<Pallet> emptyPallets;

    public EmptyPalletStorage() {
        emptyPallets = new Stack<>();
    }

    public void store(Pallet pallet) {
        this.emptyPallets.push(pallet);
    }
}
