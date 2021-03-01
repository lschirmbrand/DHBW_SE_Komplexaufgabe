package packageSortingCenter.sortingSystem.storage;

import packagingElements.pallets.Pallet;

import java.util.ArrayList;

public class StorageEmptyPallet {
    ArrayList<Pallet> emptyPallets;

    public StorageEmptyPallet(){
        emptyPallets = new ArrayList<>();
    }

    public void putPalletOn(Pallet pallet){
        this.emptyPallets.add(pallet);
    }
}
