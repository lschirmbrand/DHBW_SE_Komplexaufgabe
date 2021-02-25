package pallets;

import boxes.Box;
import boxes.configuration.Configuration;
import boxes.idGenerator.IDGenerator;
import boxes.layers.BoxLayer;
import pallets.posCapacity.PosCapacity;

import java.util.ArrayList;

public class Pallet implements IPallet {

    private PosCapacity[][] position = new PosCapacity[2][2];
    private int id;

    private IDGenerator idGenerator = new IDGenerator();

    public Pallet(int id) {
        generateID(id);
    }

    @Override
    public void generateID(int id) {
        this.id = id;
    }

    @Override
    public void fillPallet(ArrayList<Box> boxes) {
        for (int i = 0; i < position.length; i++) {
            for(int j = 0; j<position[i].length; j++){
                position[i][j] = new PosCapacity(boxes);
                for(int d = 0; d< Configuration.instance.numberOfBoxLayers; d++){
                    boxes.remove(0);
                }
            }

        }
    }

    public PosCapacity[][] getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

}
