package utillity.csvTools;


import configuration.Configuration;
import packagingElements.boxes.Box;
import packagingElements.packages.Package;
import packagingElements.packages.PackageType;
import packagingElements.pallets.Pallet;
import vehicle.lkw.LKW;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader implements ICSVReader {

    @Override
    public Map<String, Package> readPackages() {
        List<String[]> fileContent = readCSV("base_package.csv");

        Map<String, Package> packages = new HashMap<>();

        fileContent.forEach(line -> {
            String id = line[0];
            String[][] content = parsePackageContent(line[1]);
            int zipCode = Integer.parseInt(line[2]);

            PackageType packageType = switch (line[3]) {
                case "NORMAL" -> PackageType.NORMAL;
                case "EXPRESS" -> PackageType.EXPRESS;
                case "VALUE" -> PackageType.VALUE;
                default -> throw new IllegalStateException("Unexpected value: " + line[3]);
            };

            double weight = Double.parseDouble(line[4]);

            packages.put(id, new Package(id, content, zipCode, packageType, weight));
        });

        return packages;
    }

    @Override
    public Map<String, Box> readBoxes() {
        List<String[]> fileContent = readCSV("base_box.csv");
        Map<String, Package> packageMap = readPackages();

        Map<String, Box> boxMap = new HashMap<>();

        fileContent.forEach(line -> {
            String id = line[0];

            Package[][][] packs = new Package[5][2][4];

            String[] layers = line[1].substring(1, line[1].length() - 1).split("\\]\\[");

            for (int i = 0; i < layers.length; i++) {
                String[] sides = layers[i].split("\\|\\|");
                for (int j = 0; j < sides.length; j++) {
                    String[] packIDs = sides[j].split("\\|");
                    for (int k = 0; k < packIDs.length; k++) {
                        packs[i][j][k] = packageMap.get(packIDs[k]);
                    }
                }
            }


            boxMap.put(id, new Box(id, packs));
        });
        return boxMap;
    }

    @Override
    public Map<Integer, Pallet> readPallets() {
        Map<String, Box> boxMap = readBoxes();
        Map<Integer, Box[][][]> boxesOnPallet = new HashMap<>();
        Map<Integer, Pallet> palletMap = new HashMap<>();

        List<String[]> fileContent = readCSV("base_pallet.csv");

        fileContent.forEach(line -> {
            int id = Integer.parseInt(line[0]);
            String posStr = line[1];
            int x = Character.getNumericValue(posStr.charAt(1));
            int y = Character.getNumericValue(posStr.charAt(3));
            int level = Integer.parseInt(line[2]);
            String boxID = line[3];

            if (!boxesOnPallet.containsKey(id)) {
                boxesOnPallet.put(id, new Box[2][2][3]);
            }

            boxesOnPallet.get(id)[x][y][level] = boxMap.get(boxID);
        });

        boxesOnPallet.forEach((id, boxes) -> {
            palletMap.put(id, new Pallet(id, boxes));
        });

        return palletMap;
    }

    @Override
    public List<LKW> readLKW() {
        Map<Integer, Pallet> palletMap = readPallets();

        List<String[]> fileContent = readCSV("base_lkw.csv");

        Map<String, Pallet[][]> cargoMap = new HashMap<>();
        List<LKW> lkwList = new ArrayList<>();

        fileContent.forEach(line -> {
            String id = line[0];
            int side = switch (line[1]) {
                case "left" -> 0;
                default -> 1;
            };
            int pos = Integer.parseInt(line[2]);
            int palletID = Integer.parseInt(line[3]);

            if (!cargoMap.containsKey(id)) {
                cargoMap.put(id, new Pallet[2][5]);
            }

            cargoMap.get(id)[side][pos] = palletMap.get(palletID);
        });

        cargoMap.forEach((id, pallets) -> {
            LKW lkw = new LKW(id);
            lkw.loadTrailer(pallets);
            lkwList.add(lkw);
        });

        return lkwList;
    }

    private List<String[]> readCSV(String filename) {
        List<String[]> fileContent = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    private String[][] parsePackageContent(String raw) {
        String[][] content = new String[Configuration.instance.packageHeight][Configuration.instance.packageWidth];
        for (int i = 0; i < Configuration.instance.packageHeight; i++) {
            // remove '['
            raw = raw.substring(1);
            for (int j = 0; j < Configuration.instance.packageWidth; j++) {
                content[i][j] = raw.substring(0, Configuration.instance.packageLength);
                // remove content and '|' or ']'
                raw = raw.substring(Configuration.instance.packageLength + 1);
            }
        }
        return content;
    }
}
