package packageSortingCenter.sortingSystem.sortingTracks;


import configuration.SearchAlgorithm;
import packagingElements.packages.Package;

public abstract class SortingTrack {
    protected SortingTrack nextTrack;
    private ScannerExplosives scanner;

    public SortingTrack(SortingTrack nextTrack) {
        this.nextTrack = nextTrack;
        this.scanner = new ScannerExplosives(SearchAlgorithm.BOYER_MOORE);
    }

    public abstract void sortPackage(Package pack);

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
}

