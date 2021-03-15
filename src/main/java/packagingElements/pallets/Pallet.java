package packagingElements.pallets;

import packagingElements.boxes.Box;
import configuration.Configuration;

import java.util.ArrayList;

public class Pallet {

    private final Box[][][] boxes;
    private final int id;

    public Pallet(Box[][][] boxes, int id) {
        this.boxes = boxes;
        this.id = id;
    }


    public String[] palletBoxesToString() {
        String[] retString = new String[12];
        int index = 0;
        for (int i = 0; i < boxes.length; i++) {
            for (int h = 0; h < boxes[i].length; h++) {
                for (int j = 0; j < 3; j++) {
                    StringBuilder sb = new StringBuilder();
                    //Append Position
                    if (i == 0 && h == 0) {
                        sb.append(1);
                    } else if (i == 0 && h == 1) {
                        sb.append(2);
                    } else if (i == 1 && h == 0) {
                        sb.append(3);
                    } else {
                        sb.append(4);
                    }
                    //Append Level
                    sb.append(",");
                    sb.append(j + 1);
                    sb.append(",");
                    sb.append(boxes[i][h].LayerToString(j));
                    retString[index] = sb.toString();
                    index++;
                }

            }
        }
        return retString;
    }

    public int getId() {
        return id;
    }

}
