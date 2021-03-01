package utillity.csvTools;


import configuration.Configuration;
import packagingElements.packages.Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader implements ICSVReader {
    @Override
    public List<String[]> readLKW() {
        return readCSV("base_lkw.csv");
    }

    @Override
    public List<Package> readPackages() {
        List<String[]> fileContent = readCSV("base_package.csv");

        return fileContent.stream().map(line -> {
            String id = line[0];
            String[][] content = parsePackageContent(line[1]);
            int zipCode = Integer.parseInt(line[2]);

            Package.PackageTypeE packageTypeE = switch (line[3]) {
                case "NORMAL" -> Package.PackageTypeE.NORMAL;
                case "EXPRESS" -> Package.PackageTypeE.EXPRESS;
                case "VALUE" -> Package.PackageTypeE.VALUE;
                default -> throw new IllegalStateException("Unexpected value: " + line[3]);
            };

            double weigth = Double.parseDouble(line[4]);

            return new Package(id, content, zipCode, packageTypeE, weigth);
        }).collect(Collectors.toList());
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
