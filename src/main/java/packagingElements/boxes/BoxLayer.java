package packagingElements.boxes;

import packagingElements.packages.Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        sb.append("[");

        for (int i = 0; i < layerContent.length; i++) {
            sb.append(Arrays.stream(layerContent[i])
                    .map(Package::getId)
                    .collect(Collectors.joining("|"))
            );

            if (i != layerContent.length - 1) {
                sb.append("||");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
