package vehicle.lkw;

import packagingElements.pallets.Pallet;

import java.util.List;

public class LKWTrailer {

    private Pallet[][] cargo = new Pallet[2][5];

    public void load(List<Pallet> pallets) {
        for (int i = 0; i < pallets.size(); i++) {
            int side = i % 2;
            int pal = i / 2;

            cargo[side][pal] = pallets.get(i);
        }
    }

    public Pallet unloadNext() {
        int side = 1;
        int pos = 4;

        Pallet next;

        while ((next = cargo[side][pos]) == null) {
            side--;
            if (side < 0) {
                pos--;
                side = 1;
            }

            if (pos < 0) {
                return null;
            }
        }

        cargo[side][pos] = null;
        return next;
    }

    public Pallet[][] getCargo() {
        return cargo;
    }

    public void setCargo(Pallet[][] cargo) {
        this.cargo = cargo;
    }
}
