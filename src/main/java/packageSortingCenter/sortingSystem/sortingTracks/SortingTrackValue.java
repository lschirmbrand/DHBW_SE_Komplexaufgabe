package packageSortingCenter.sortingSystem.sortingTracks;

import packagingElements.packages.Package;
import packagingElements.packages.PackageType;

public class SortingTrackValue extends SortingTrack {
    public SortingTrackValue(SortingTrack nextTrack) {
        super(nextTrack);
    }

    @Override
    public boolean sortPackage(Package pack) {
        if (pack.getPackageType() != PackageType.VALUE) {
            return nextTrack.sortPackage(pack);
        }
        return scan(pack);
    }
}
