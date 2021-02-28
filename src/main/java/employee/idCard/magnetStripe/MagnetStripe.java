package employee.idCard.magnetStripe;

public class MagnetStripe {

    private char[][] encryptedString = new char[1][100];

    public void print(String encryptedString) {
        this.encryptedString[0] = encryptedString.toCharArray();
        char[][] tempArray = new char[1][100];
        for (int i = 0; i < this.encryptedString[0].length; i++) {
            tempArray[0][i] = this.encryptedString[0][i];
        }

        for (int i = this.encryptedString[0].length; i < 100; i++) {
            tempArray[0][i] = '0';
        }
        this.encryptedString = tempArray;
        System.out.println(this.encryptedString[0]);
    }

    public char[][] getEncryptedString() {
        return encryptedString;
    }

    public void setEncryptedString(char[][] encryptedString) {
        this.encryptedString = encryptedString;
    }
}
