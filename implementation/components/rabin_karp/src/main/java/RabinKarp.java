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
        int d = 30; // number of chars in alphabet
        int q = 101; // a prime number
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == m)
                    return i;
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
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