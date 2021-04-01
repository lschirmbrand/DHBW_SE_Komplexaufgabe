package packageSortingCenter.sortingSystem.sortingTracks;


import configuration.SearchAlgorithm;
import packagingElements.packages.Package;

public abstract class SortingTrack {
    protected final SortingTrack nextTrack;
    private final Scanner scanner;

    public SortingTrack(SortingTrack nextTrack) {
        this.nextTrack = nextTrack;
        this.scanner = new Scanner(SearchAlgorithm.BOYER_MOORE);
    }

    public abstract boolean sortPackage(Package pack);

    protected boolean scan(Package pack) {
        boolean res = scanner.scanForExplosive(pack);
        if (res) {
            System.out.println(pack.getId());
        }
        return res;
    }

    public void changeSearchAlgorithm(SearchAlgorithm algorithm) {
        this.scanner.setAlgorithm(algorithm);
    }

    public void unloadComponent() {
        scanner.unloadComponent();
    }
}

