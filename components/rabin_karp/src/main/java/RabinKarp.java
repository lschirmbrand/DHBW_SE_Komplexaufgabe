public class RabinKarp {
    private static final RabinKarp instance = new RabinKarp();

    public Port port;

    private RabinKarp() {
        port = new Port();
    }

    public static RabinKarp getInstance() {
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