package packageSortingCenter.sortingSystem.sortingTracks;

import packagingElements.packages.Package;
import packagingElements.packages.PackageType;

public class SortingTrackExpress extends SortingTrack {
    public SortingTrackExpress(SortingTrack nextTrack) {
        super(nextTrack);
    }

    @Override
    public void sortPackage(Package pack) {
        if (pack.getPackageType() != PackageType.EXPRESS) {
            nextTrack.sortPackage(pack);
            return;
        }
        scan(pack);
    }
}
