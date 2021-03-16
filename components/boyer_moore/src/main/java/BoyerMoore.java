public class BoyerMoore {
    private static final BoyerMoore instance = new BoyerMoore();

    public Port port;

    private BoyerMoore() {
        port = new Port();
    }

    public static BoyerMoore getInstance() {
        return instance;
    }

    public int innerMatch(String pattern, String text) {
        return 0;
    }

    public class Port implements ISearchAlgorithm {

        @Override
        public int match(String pattern, String text) {
            return innerMatch(pattern, text);
        }
    }
}