package packageSortingCenter.sortingSystem.sortingTracks;

import packagingElements.packages.Package;
import packagingElements.packages.PackageType;

public class SortingTrackNormal extends SortingTrack {


    public SortingTrackNormal(SortingTrack nextTrack) {
        super(nextTrack);
    }

    @Override
    public void sortPackage(Package pack) {
        if (pack.getPackageType() != PackageType.NORMAL) {
            nextTrack.sortPackage(pack);
            return;
        }

        scan(pack);
    }
}
