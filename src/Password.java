public class Password {
    String password;
    int length;

    public Password(String str){
        password = str;
        length = str.length();
    }

    public int charType(char chr){
        int val;
        if ((int)chr >= 65 && (int)chr <= 90)
            val = 1;
        else if ((int)chr >= 97 && (int)chr <= 122)
            val = 2;
        else if ((int)chr >= 48 && (int)chr <= 57)
            val = 3;
        else
            val = 4;
        return val;
    }

    public int passwordStrength(){
        String str = this.password;
        boolean Upper = false;
        boolean Lower = false;
        boolean number = false;
        boolean symbol = false;
        int Score = 0;
        int type;

        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            type = charType(chr);

            if (type == 1)
                Upper = true;
            if (type == 2)
                Lower = true;
            if (type == 3)
                number = true;
            if (type == 4)
                symbol = true;
        }

        if (Upper)
            Score += 1;
        if (Lower)
            Score += 1;
        if (number)
            Score += 1;
        if (symbol)
            Score += 1;
        if (str.length() >= 8)
            Score += 1;
        if (str.length() >= 16)
            Score += 1;

        return Score;
    }

    public String calculateScore() {
        int Score = this.passwordStrength();

        if (Score == 6) {
            return "Strong!";
        } else if (Score >= 4) {
            return "Good!";
        } else if (Score >= 3) {
            return "Medium!";
        } else {
            return "Weak!";
        }
    }

    @Override
    public String toString() {
        return password;
    }
}