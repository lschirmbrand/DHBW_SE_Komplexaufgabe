package vehicle.lkw;

import packagingElements.pallets.Pallet;

import java.util.ArrayList;
import java.util.List;

public class LKWTrailer implements ILKW {

    private final Pallet[][] trailerCargo = new Pallet[2][5];



    @Override
    public void loadTrailer(ArrayList<Pallet> pallets) {
        for (int i = 0; i < trailerCargo.length; i++) {
            for (int j = 0; j < trailerCargo[i].length; j++) {
                trailerCargo[i][j] = pallets.get(0);
                pallets.remove(0);
            }
        }
    }

    public String[] lkwPalletsToString() {
        String[] retString = new String[10];
        int index = 0;
        for (int i = 0; i < trailerCargo.length; i++) {
            for (int h = 0; h < trailerCargo[i].length; h++) {
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
                sb.append(trailerCargo[i][h].getId());
                retString[index] = sb.toString();
                index++;
            }
        }
        return retString;
    }

    public void loadTrailerFromList(List<String[]> lkwContent) {
        for (int i = 0; i < trailerCargo.length; i++) {
            for (int j = 0; j < trailerCargo[i].length; j++) {
                trailerCargo[i][j] = new Pallet(Integer.parseInt(lkwContent.get(0)[3]) - 1);
                lkwContent.remove(0);
            }
        }
    }
}
