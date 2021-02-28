package vehicle.lkw;

import utillity.idGenerator.IDGenerator;
import packagingElements.pallets.Pallet;

import java.util.ArrayList;
import java.util.List;

public class LKW {

    LKWTrailer trailer;

    private String id;

    public LKW() {
        IDGenerator idGenerator = new IDGenerator();
        this.id = idGenerator.generateID(4);
        trailer = new LKWTrailer();
    }

    public void fillTrailer(ArrayList<Pallet> pallets) {
        trailer.loadTrailer(pallets);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LKWTrailer getTrailer() {
        return trailer;
    }

    public void fillTrailerFromList(List<String[]> lkwContent) {
        trailer.loadTrailerFromList(lkwContent);
    }
}
