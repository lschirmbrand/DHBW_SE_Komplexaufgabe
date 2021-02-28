package pallets;

import boxes.Box;
import configuration.Configuration;

import java.util.ArrayList;

public class Pallet {

    private final PosCapacity[][] position = new PosCapacity[2][2];
    private int id;

    public Pallet(int id) {
        generateID(id);
    }

    public void generateID(int id) {
        this.id = id + 1;
    }

    public void fillPallet(ArrayList<Box> boxes) {
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                position[i][j] = new PosCapacity(boxes);
                if (Configuration.instance.numberOfBoxLayers > 0) {
                    boxes.subList(0, Configuration.instance.numberOfBoxLayers).clear();
                }
            }

        }
    }

    public String[] palletBoxesToString() {
        String[] retString = new String[12];
        int index = 0;
        for (int i = 0; i < position.length; i++) {
            for (int h = 0; h < position[i].length; h++) {
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
                    sb.append(position[i][h].LayerToString(j));
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
