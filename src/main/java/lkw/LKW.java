package lkw;

import idGenerator.IDGenerator;
import pallets.Pallet;

import java.util.ArrayList;

public class LKW {
    LKWTrailer trailer;
    private final String id;

    public LKW(){
        IDGenerator idGenerator = new IDGenerator();
        this.id = idGenerator.generateID(4);
        trailer = new LKWTrailer();
    }

    public void fillTrailer(ArrayList<Pallet> pallets){
        trailer.loadTrailer(pallets);
    }

}
