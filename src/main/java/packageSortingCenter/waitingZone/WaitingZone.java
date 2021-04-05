package packageSortingCenter.waitingZone;

import vehicle.lkw.LKW;

import java.util.ArrayDeque;
import java.util.Queue;

public class WaitingZone {
    private final Queue<LKW> lkwQueue = new ArrayDeque<>(5);

    public void add(LKW lkw) {
        lkwQueue.add(lkw);
    }

    public LKW getNext() {
        return lkwQueue.poll();
    }

    public boolean isEmpty() {
        return lkwQueue.isEmpty();
    }
}
