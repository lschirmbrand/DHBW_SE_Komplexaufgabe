package utillity.csvTools;

import packagingElements.boxes.Box;
import packagingElements.packages.Package;
import packagingElements.pallets.Pallet;
import vehicle.lkw.LKW;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVWriter implements ICSVWriter {

    @Override
    public void writePackage(List<Package> packages) {
        StringBuilder sb = new StringBuilder();
        for (Package pack : packages) {
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
    public void writeBox(List<Box> boxes) {
        StringBuilder sb = new StringBuilder();
        for (Box box : boxes) {
            sb.append(box.getId());
            sb.append(",");
            sb.append(getPackageIDs(box.getPackages()));
            sb.append('\n');
        }

        try (PrintWriter writer = new PrintWriter("base_box.csv")) {
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writePallet(List<Pallet> pallets) {
        String str = String.join("\n", getPalletStrings(pallets));

        try (PrintWriter writer = new PrintWriter("base_pallet.csv")) {
            writer.write(str);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writeLKW(List<LKW> lkwList) {
        StringBuilder sb = new StringBuilder();

        for (LKW lkw : lkwList) {
            List<String> lines = lkwCargoToString(lkw.getTrailer().getCargo());

            for (String line : lines) {
                sb.append(lkw.getId());
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

    private List<String> getPalletStrings(List<Pallet> pallets) {
        List<String> lines = new ArrayList<>();
        for (Pallet pallet : pallets) {
            Box[][][] boxes = pallet.getBoxes();
            for (int i = 0; i < boxes.length; i++) {
                for (int j = 0; j < boxes[i].length; j++) {
                    String pos = "(" + i + "/" + j + ")";
                    for (int k = 0; k < boxes[i][j].length; k++) {
                        lines.add(pallet.getId() + "," + pos + "," + k + "," + boxes[i][j][k].getId());
                    }
                }
            }
        }
        return lines;
    }

    public List<String> lkwCargoToString(Pallet[][] cargo) {
        List<String> palletStrings = new ArrayList<>();
        for (int i = 0; i < cargo.length; i++) {
            for (int h = 0; h < cargo[i].length; h++) {
                StringBuilder sb = new StringBuilder();
                //Append Position
                if (i == 0) {
                    sb.append("left");
                } else {
                    sb.append("right");
                }

                //Append Level
                sb.append(",");
                sb.append(h);
                sb.append(",");
                sb.append(cargo[i][h].getId());
                palletStrings.add(sb.toString());
            }
        }
        return palletStrings;
    }
}
