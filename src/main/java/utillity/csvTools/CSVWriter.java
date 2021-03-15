package utillity.csvTools;

import packagingElements.boxes.Box;
import vehicle.lkw.LKW;
import packagingElements.packages.Package;
import packagingElements.pallets.Pallet;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        for (Package pack : packageList) {
            sb.append(pack.getId());
            sb.append(",");
            sb.append(pack.getContentToString());
            sb.append(",");
            sb.append(pack.getZipCode());
            sb.append(",");
            sb.append(pack.getPackageType().toString());
            sb.append(",");
            sb.append(pack.getWeight());
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
        for (Box box : boxList) {
            sb.append(box.getId());
            sb.append(",");
            sb.append(getPackageIDs(box.getPackages()));
            sb.append(";");
            sb.append('\n');
        }

        try (PrintWriter writer = new PrintWriter("base_box.csv")) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getPackageIDs(Package[][][] packages) {
        StringBuilder str = new StringBuilder();
        for (Package[][] aPackage : packages) {
            str.append("[");
            for (int j = 0; j < aPackage.length; j++) {
                str.append(Arrays.stream(aPackage[j])
                        .map(Package::getId)
                        .collect(Collectors.joining("|"))
                );

                if (j != aPackage.length - 1) {
                    str.append("||");
                }
            }
            str.append("]");
        }
        return str.toString();
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
