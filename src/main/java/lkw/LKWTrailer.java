package lkw;

import boxes.configuration.Configuration;
import boxes.layers.BoxLayer;
import pallets.Pallet;

import java.util.ArrayList;

public class LKWTrailer implements ILKW {

    private Pallet[][] trailerCargo = new Pallet[2][5];

    @Override
    public void loadTrailer(ArrayList<Pallet> pallets) {
        for (int i = 0; i < trailerCargo.length; i++) {
            for(int j = 0; j<trailerCargo[i].length; j++){
                trailerCargo[i][j] = pallets.get(0);
                pallets.remove(0);
            }
        }
    }
}
