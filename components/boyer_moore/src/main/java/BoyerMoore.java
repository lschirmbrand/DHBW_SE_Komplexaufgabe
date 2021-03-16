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
        int i = pattern.length() - 1;
        int j = pattern.length() - 1;

        do {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == 0) {
                    return 0;
                } else {
                    i--;
                    j--;
                }
            } else {
                i = i + pattern.length() - Math.min(j, 1 + last(text.charAt(i), pattern));
                j = pattern.length() - 1;
            }
        } while (i <= text.length() - 1);
        return -1;
    }

    private int last(char c, String pattern) {
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public class Port implements ISearchAlgorithm {

        @Override
        public int match(String pattern, String text) {
            return innerMatch(pattern, text);
        }
    }
}