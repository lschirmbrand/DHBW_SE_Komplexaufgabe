package packageSortingCenter.sortingSystem.sortingTracks;

import configuration.SearchAlgorithm;
import packagingElements.packages.Package;

import java.lang.reflect.Method;

public class Scanner {
    private Object searchAlgorithmPort;

    public Scanner(SearchAlgorithm algorithm) {
        this.searchAlgorithmPort = SearchAlgorithmFactory.build(algorithm);
    }

    public boolean scanForExplosive(Package pack) {
        String pattern = "exp!os:ve";

        for (String[] lines : pack.getContent()) {
            for (String line : lines) {
                try {
                    Method match = searchAlgorithmPort.getClass().getDeclaredMethod("match", String.class, String.class);

                    int found = (int) match.invoke(searchAlgorithmPort, pattern, line);
                    if (found != -1) {
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public void setAlgorithm(SearchAlgorithm algorithm) {
        this.searchAlgorithmPort = SearchAlgorithmFactory.build(algorithm);
    }

    public void unloadComponent() {
        searchAlgorithmPort = null;
    }
}
