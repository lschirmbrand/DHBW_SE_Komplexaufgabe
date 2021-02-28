package control;

public interface IControlUnit {
    void init();

    void next();

    void shutdown();

    void lock();

    void unlock();

    void showStatistics();

    void changeAlgorithm();
}
