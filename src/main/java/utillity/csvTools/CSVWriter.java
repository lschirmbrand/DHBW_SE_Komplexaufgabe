package utillity.csvTools;

import packagingElements.boxes.Box;
import vehicle.lkw.LKW;
import packagingElements.packages.Package;
import packagingElements.pallets.Pallet;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriter implements ICSVWriter {

    private ArrayList<Package> packageList;
    private ArrayList<Box> boxList;
    private ArrayList<Pallet> palletList;
    private ArrayList<LKW> lkwList;

    public void setPackageList(ArrayList<Package> packageList) {
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
        for (Package s : packageList) {
            sb.append(s.getId());
            sb.append(",");
            sb.append(s.getContentToString());
            sb.append(",");
            sb.append(s.getZipCode());
            sb.append(",");
            sb.append(s.getPackageType().toString());
            sb.append(",");
            sb.append(s.getWeight());
            sb.append(";");
            sb.append('\n');
        }

        try (PrintWriter writer = new PrintWriter("base_package.csv")) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writeBox() {
        StringBuilder sb = new StringBuilder();
        for (Box s : boxList) {
            sb.append(s.getId());
            sb.append(",");
            sb.append(s.getPackageIDs());
            sb.append(";");
            sb.append('\n');
        }

        try (PrintWriter writer = new PrintWriter("base_box.csv")) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writePallet() {
        StringBuilder sb = new StringBuilder();

        for (Pallet s : palletList) {
            String[] lines = s.palletBoxesToString();
            for (String line : lines) {
                sb.append(s.getId());
                sb.append(",");
                sb.append(line);
                sb.append(";");
                sb.append('\n');
            }
        }

        try (PrintWriter writer = new PrintWriter("base_pallet.csv")) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writeLKW() {

        StringBuilder sb = new StringBuilder();

        for (LKW s : lkwList) {
            String[] lines = s.getTrailer().lkwPalletsToString();

            for (String line : lines) {
                sb.append(s.getId());
                sb.append(",");
                sb.append(line);
                sb.append('\n');
            }
        }

        try (PrintWriter writer = new PrintWriter("base_lkw.csv")) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
