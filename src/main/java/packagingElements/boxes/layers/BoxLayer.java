package packagingElements.boxes.layers;

import packagingElements.packages.Package;

import java.util.ArrayList;

public class BoxLayer {
    private final Package[][] layerContent = new Package[2][4];

    public BoxLayer(ArrayList<Package> packages) {
        int temp = 0;
        for (int i = 0; i < layerContent.length; i++) {
            for (int j = 0; j < layerContent[i].length; j++) {
                this.layerContent[i][j] = packages.get(temp);
                temp++;
            }
        }
    }

    public String idsToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < layerContent.length; i++) {
            for (int j = 0; j < layerContent[i].length; j++) {
                sb.append(layerContent[i][j].getId());
                sb.append("|");
            }
        }
        sb.append("#");

        return sb.toString();
    }
}
