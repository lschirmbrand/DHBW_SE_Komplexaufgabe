package csvWriter;

import boxes.Box;
import lkw.LKW;
import packages.Package;
import pallets.Pallet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriter implements ICSVWriter {

    private ArrayList<Package> packageList;
    private ArrayList<Box> boxList;
    private ArrayList<Pallet> palletList;
    private ArrayList<LKW> lkwList;

    public void setPackageList(ArrayList<Package> packageList){
        this.packageList = packageList;
    }

    public void setBoxList(ArrayList<Box> boxList) {
        this.boxList = boxList;
    }

    public void setPalletList(ArrayList<Pallet> palletList) {
        this.palletList = palletList;
    }

    public void setLKWList(ArrayList<LKW> lkwList) {
        this.lkwList = lkwList;
    }

    @Override
    public void writePackage() {
        StringBuilder sb = new StringBuilder();
        for(Package s : packageList) {
            sb.append(s.getId());
            sb.append(",");
            sb.append(s.getContentToString());
            sb.append(",");
            sb.append(s.getZipCode());
            sb.append(",");
            //sb.append(s.getPackageType().toString());
            //sb.append(",");
            sb.append(s.getWeight());
            sb.append(";");
            sb.append('\n');
        }

        try (PrintWriter writer = new PrintWriter(new File("base_package.csv"))) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writeBox() {
        StringBuilder sb = new StringBuilder();
        for(Box s : boxList) {
            sb.append(s.getId());
            sb.append(",");
            sb.append(s.getPackageIDs());
            sb.append(";");
            sb.append('\n');
        }

        try (PrintWriter writer = new PrintWriter(new File("base_box.csv"))) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writePallet() {
        StringBuilder sb = new StringBuilder();

        for(Pallet s : palletList){
            
        }
    }

    @Override
    public void writeLKW() {

    }
}
