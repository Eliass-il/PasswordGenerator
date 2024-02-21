import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSymbols){
        alphabet = new Alphabet(includeUpper, includeLower, includeNumbers, includeSymbols);
    }
    public Generator(){
    }




    private Password generatePassword(int length){
        final StringBuilder password = new StringBuilder();
        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int)(Math.random() * range) + min;
            password.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(password.toString());
    }

    public Password requestPassword(int length){
        final Password password = this.generatePassword(length);
        return password;
    }

    public String checkPassword(String input) {

        final Password password = new Password(input);

        return password.calculateScore();
    }

}