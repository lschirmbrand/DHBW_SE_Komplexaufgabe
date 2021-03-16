package packageSortingCenter.sortingSystem.sortingTracks;


import packagingElements.packages.Package;

public abstract class SortingTrack {
    protected SortingTrack nextTrack;

    public SortingTrack(SortingTrack nextTrack) {
        this.nextTrack = nextTrack;
    }

    public abstract void sortPackage(Package pack);
}

