import java.util.Arrays;

enum RomanNumerals {

    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    int arabicNumeral;

    RomanNumerals(int arabicNumeral) {
        this.arabicNumeral = arabicNumeral;
    }

    static boolean checkArgument(String argument) {
        return Arrays.toString(values()).contains(argument);
    }

    static int argumentsToArabic(String argument) {
        return valueOf(argument).arabicNumeral;
    }

    static void resultToRoman() {
        String result = String.valueOf(Calculator.result);

        switch (result.length()) {

            case 1:
                Calculator.result = numeralToRoman((int) Calculator.result);
                break;

            case 2:
                if (result.charAt(0) == '-') {
                    Calculator.result = null;
                } else {
                    int arabicNumeral1 = Character.getNumericValue(result.charAt(0));
                    int arabicNumeral2 = Character.getNumericValue(result.charAt(1));
                    concatResult(numeralToRoman(arabicNumeral1), numeralToRoman(arabicNumeral2));
                }
                break;

            case 3:
                Calculator.result = "C";
        }
    }

    static RomanNumerals numeralToRoman(int arabicNumeral) {
        for (RomanNumerals numeral : values()) {
            if (numeral.arabicNumeral == arabicNumeral) {
                return numeral;
            }
        }
        return null;
    }

    static void concatResult(RomanNumerals numeral1, RomanNumerals numeral2) {

        String romanNumeral1 = numeral1.name();
        romanNumeral1 = romanNumeral1.replace('X', 'C');
        romanNumeral1 = romanNumeral1.replace('V', 'L');
        romanNumeral1 = romanNumeral1.replace('I', 'X');

        String romanNumeral2 = (numeral2 == null) ? "" : numeral2.name();

        Calculator.result = romanNumeral1.concat(romanNumeral2);
    }
}
