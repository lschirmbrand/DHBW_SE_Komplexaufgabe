package vehicle.lkw;

import packagingElements.pallets.Pallet;

import java.util.List;

public class LKW {

    private final LKWTrailer trailer;
    private final String id;

    public LKW(String id) {
        this.id = id;
        trailer = new LKWTrailer();
    }

    public void loadTrailer(List<Pallet> pallets) {
        trailer.load(pallets);
    }

    public void loadTrailer(Pallet[][] pallets) {
        trailer.setCargo(pallets);
    }

    public String getId() {
        return id;
    }


    public LKWTrailer getTrailer() {
        return trailer;
    }

}
