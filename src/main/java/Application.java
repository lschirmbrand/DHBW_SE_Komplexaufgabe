import boxes.Box;
import boxes.configuration.Configuration;
import csvWriter.CSVWriter;
import packages.Package;
import pallets.Pallet;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Package packet = new Package();
        CSVWriter csvWriter = new CSVWriter();
        ArrayList<Package> packages = new ArrayList<>();
        for(int i = 0; i< Configuration.instance.numberOfPackages; i++){
            packages.add(new Package());
        }

        csvWriter.setPackageList(packages);
        csvWriter.writePackage();

        ArrayList<Box> boxes = new ArrayList<Box>();
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
        int i = 0;
    }
}
