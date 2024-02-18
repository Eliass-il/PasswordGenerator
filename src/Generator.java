import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSymbols){
        alphabet = new Alphabet(includeUpper, includeLower, includeNumbers, includeSymbols);
    }

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public void mainLoop() {
        menu();

        String userOption = "-1";

        while (!userOption.equals("4")) {

            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    menu();
                }
                case "2" -> {
                    checkPassword();
                    menu();
                }
                case "3" -> printQuitMessage();
                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    menu();
                }
            }
        }
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

    public void requestPassword(){
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeNumbers = false;
        boolean includeSymbols = false;

        boolean correctParams;

        System.out.println();
        System.out.println("Password Generator. Answer"
                + " the following questions by Yes or No \n");

        do {
            String input;
            correctParams = false;
            do {
                System.out.println("Do you want Uppercase letters to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if (isInclude(input)) includeUpper = true;

            do {
                System.out.println("Do you want Lowercase letters to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if (isInclude(input)) includeLower = true;

            do {
                System.out.println("Do you want Numbers letters to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if (isInclude(input)) includeNumbers = true;

            do {
                System.out.println("Do you want Symbols letters to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if (isInclude(input)) includeSymbols = true;

            if (!includeUpper && !includeLower && !includeNumbers && !includeSymbols) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                correctParams = true;
            }
        } while (correctParams);

        System.out.println("Great! Now enter the length of the password");
        int length = keyboard.nextInt();

        final Generator generator = new Generator(includeUpper, includeLower, includeNumbers, includeSymbols);
        final Password password = generator.generatePassword(length);

        System.err.println("Your generated password -> " + password);
    }

    private void checkPassword() {
        String input;

        System.out.print("\nEnter your password:");
        input = keyboard.next();

        final Password password = new Password(input);

        System.out.println(password.calculateScore());
    }




    private void PasswordRequestError(String i) {
        if (!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")) {
            System.out.println("You have entered something incorrect let's go over it again \n");
        }
    }

    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void menu(){
        System.out.println();
        System.out.println("1 - Generate password");
        System.out.println("2 - Password strength");
        System.out.println("3 - Quit");
        System.out.println("Choice:");
    }

    private void printQuitMessage() {
        System.out.println("Closing the program bye bye!");
    }
}