package utillity.csvTools;

import configuration.Configuration;
import packagingElements.boxes.Box;
import packagingElements.boxes.BoxFactory;
import packagingElements.packages.Package;
import packagingElements.packages.PackageFactory;
import packagingElements.pallets.Pallet;
import packagingElements.pallets.PalletFactory;
import vehicle.lkw.LKW;
import vehicle.lkw.LKWFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CSVBuilder {
    public static void main(String[] args) {
        ICSVWriter csvWriter = new CSVWriter();

        // create packages
        List<Package> packages = new ArrayList<>();
        for (int i = 0; i < Configuration.instance.numberOfPackages; i++) {
            packages.add(PackageFactory.build());
        }

        // Add exp|os!ve to 4 random packages
        List<Integer> explosiveIndexes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int j;
            do {
                j = ThreadLocalRandom.current().nextInt(packages.size());
            } while (explosiveIndexes.contains(j));
            explosiveIndexes.add(j);
        }
        for (Integer explosiveIndex : explosiveIndexes) {
            addExplosive(packages.get(explosiveIndex));
        }

        // write packages to csv
        csvWriter.writePackage(packages);

        // boxes
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < Configuration.instance.numberOfBoxes; i++) {
            boxes.add(BoxFactory.build(packages.subList(i * 40, (i + 1) * 40)));
        }

        csvWriter.writeBox(boxes);

        // pallets
        List<Pallet> pallets = new ArrayList<>();
        for (int i = 0; i < Configuration.instance.numberOfPallets; i++) {
            pallets.add(PalletFactory.build(boxes.subList(i * 12, (i + 1) * 12)));
        }

        csvWriter.writePallet(pallets);

        // lkw
        ArrayList<LKW> lkws = new ArrayList<>();
        for (int i = 0; i < Configuration.instance.numberOfLKWS; i++) {
            LKW lkw = LKWFactory.build();
            lkws.add(lkw);
            lkw.loadTrailer(pallets.subList(i * 10, (i + 1) * 10));
        }

        csvWriter.writeLKW(lkws);

    }

    public static void addExplosive(Package pack) {
        String[][] content = pack.getContent();

        String exp = "exp!os:ve";
        int contHeight = content.length;
        int h = ThreadLocalRandom.current().nextInt(contHeight);
        int contWidth = content[0].length;
        int w = ThreadLocalRandom.current().nextInt(contWidth);
        int contLength = content[0][0].length();
        int l = ThreadLocalRandom.current().nextInt(contLength - exp.length() + 1);

        String line = content[h][w];
        line = line.substring(0, l) + exp + line.substring(l + exp.length());
        content[h][w] = line;

        pack.setContent(content);
    }
}
