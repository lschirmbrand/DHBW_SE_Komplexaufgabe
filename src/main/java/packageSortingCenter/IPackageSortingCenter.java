package packageSortingCenter;

public interface IPackageSortingCenter {
    void init();

    void next();

    void shutdown();

    void lock();

    void unlock();

    void showStatistics();

    void changeAlgorithm();
}
