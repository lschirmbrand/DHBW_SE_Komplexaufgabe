package packagingElements.pallets;

import packagingElements.boxes.Box;

import java.util.List;

public class PalletFactory {
    private static int nextID = 0;

    public static Pallet build(List<Box> boxList) {
        int id = nextID++;

        Box[][][] boxes = new Box[2][2][3];

        for (int i = 0; i < boxList.size(); i++) {
            int x = (i / 6) % 2;
            int y = (i / 3) % 2;
            int box = i % 3;

            boxes[x][y][box] = boxList.get(i);
        }

        return new Pallet(id, boxes);

    }
}
