package packageSortingCenter.sortingSystem.sortingTracks;

import packagingElements.packages.Package;
import packagingElements.packages.PackageType;

public class SortingTrackValue extends SortingTrack {
    public SortingTrackValue(SortingTrack nextTrack) {
        super(nextTrack);
    }

    @Override
    public void sortPackage(Package pack) {
        if (pack.getPackageType() != PackageType.VALUE) {
            nextTrack.sortPackage(pack);
            return;
        }
        scan(pack);
    }
}
