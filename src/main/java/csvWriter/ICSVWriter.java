package csvWriter;

import java.util.ArrayList;

import boxes.Box;
import lkw.LKW;
import packages.Package;
import pallets.Pallet;

public interface ICSVWriter {
    public void writePackage();
    public void writeBox();
    public void writePallet();
    public void writeLKW();
}
