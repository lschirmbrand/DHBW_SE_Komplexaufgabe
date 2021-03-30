package packageSortingCenter;

import packagingElements.pallets.Pallet;

import java.util.Arrays;

public class StorageArea {
    private Pallet[][] positions = new Pallet[5][2];

    public StorageArea() {
        for (Pallet[] position : positions) {
            Arrays.fill(position, null);
        }
    }

    public void store(Pallet pallet) {
        int pos = 0;
        int level = 0;

        while (positions[pos][level] != null) {
            pos += level++;
            level %= 2;
        }

        positions[pos][level] = pallet;
    }

    public Pallet removeNext() {
        int pos = positions.length - 1;
        int level = positions[0].length - 1;

        Pallet pallet;

        while ((pallet = positions[pos][level]) == null) {
            level--;
            if (level < 0) {
                pos--;
                level = positions[0].length - 1;
            }
            if (pos < 0) return null;
        }

        positions[pos][level] = null;
        return pallet;
    }

    public Pallet[][] getPositions() {
        return positions;
    }
}
