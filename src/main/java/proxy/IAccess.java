package proxy;

public interface IAccess {
    void grantInit();
    void grantNext();
    void grantLock();
    void grantUnlock();
    void grantChangeAlgorithm();
    void grantShowStatistics();
    void grantShutdown();
}
