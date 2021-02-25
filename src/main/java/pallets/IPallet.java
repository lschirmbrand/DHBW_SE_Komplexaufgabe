package pallets;

import boxes.Box;

import java.util.ArrayList;

public interface IPallet {
    public void generateID(int id);
    public void fillPallet(ArrayList<Box> boxes);
}
