import boxes.Box;
import boxes.configuration.Configuration;
import csvWriter.CSVWriter;
import lkw.LKW;
import packages.Package;
import pallets.Pallet;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        CSVWriter csvWriter = new CSVWriter();
        ArrayList<Package> packages = new ArrayList<>();
        for(int i = 0; i< Configuration.instance.numberOfPackages; i++){
            packages.add(new Package());
        }

        csvWriter.setPackageList(packages);
        csvWriter.writePackage();

        ArrayList<Box> boxes = new ArrayList<>();
        for(int i = 0; i<Configuration.instance.numberOfBoxes; i++){
            boxes.add(new Box());
            boxes.get(i).fillBox(packages);
        }

        csvWriter.setBoxList(boxes);
        csvWriter.writeBox();

        ArrayList<Pallet> pallets = new ArrayList<>();
        for(int i = 0; i<Configuration.instance.numberOfPallets; i++){
            pallets.add(new Pallet(i));
            pallets.get(i).fillPallet(boxes);
        }

        csvWriter.setPalletList(pallets);
        csvWriter.writePallet();

        ArrayList<LKW> lkws = new ArrayList<>();
        for(int i = 0; i<Configuration.instance.numberOfLKWS; i++){
            lkws.add(new LKW());
            lkws.get(i).fillTrailer(pallets);
        }
        int i = 0;
    }
}
