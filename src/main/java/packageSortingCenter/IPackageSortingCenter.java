package packageSortingCenter;

import configuration.SearchAlgorithm;

public interface IPackageSortingCenter {
    void init();

    void next();

    void shutdown();

    void lock();

    void unlock();

    void showStatistics();

    void changeAlgorithm(SearchAlgorithm algorithm);
}
