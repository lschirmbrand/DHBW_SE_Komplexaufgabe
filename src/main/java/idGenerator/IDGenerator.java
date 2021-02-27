package idGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class IDGenerator {
    public String generateID(int numberOfDigits){
        char[] id = new char[numberOfDigits];
        for (int i = 0; i < id.length; i++) {
            int numOrChar = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            if (numOrChar == 0) {
                //Interpret as Char
                int numToChar = ThreadLocalRandom.current().nextInt(97, 122 + 1);
                id[i] = (char) (numToChar);
            } else {
                //Interpret as Number
                int number = ThreadLocalRandom.current().nextInt(0, 9 + 1);
                id[i] = (char) (number + '0');
            }
        }

        String idString = new String(id);

        return idString;
    }
}
