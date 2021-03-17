package packageSortingCenter.sortingSystem.sortingTracks;

import packagingElements.packages.Package;
import packagingElements.packages.PackageType;

public class SortingTrackNormal extends SortingTrack {


    public SortingTrackNormal(SortingTrack nextTrack) {
        super(nextTrack);
    }

    @Override
    public boolean sortPackage(Package pack) {
        if (pack.getPackageType() != PackageType.NORMAL) {
            return nextTrack.sortPackage(pack);
        }

        return scan(pack);
    }
}
