public class Alphabet {
    public static final String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    public static final String numbers = "1234567890";
    public static final String symbols = "!@#$%^&*()-_=+\\/~?";
    private final StringBuilder res;

    public Alphabet (boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean symbolsIncluded){
        res = new StringBuilder();

        if (uppercaseIncluded)
            res.append(alphabetUpper);
        if (lowercaseIncluded)
            res.append(alphabetLower);
        if (numbersIncluded)
            res.append(numbers);
        if (symbolsIncluded)
            res.append(symbols);
    }

    public String getAlphabet(){
        return res.toString();
    }

}