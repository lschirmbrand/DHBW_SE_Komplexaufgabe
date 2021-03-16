package vehicle.lkw;

import utillity.idGenerator.IDGenerator;

public class LKWFactory {
    private static final IDGenerator idGenerator = new IDGenerator();

    public static LKW build() {
        String id = idGenerator.generateID(4);

        return new LKW(id);
    }
}
