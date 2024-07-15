import java.util.ArrayList;

public class FuzzySearch {
    public static void main(String[] args) {
        // Usage
        double sureness = 1.0;
        String testInput = "email";
        String testText = "I want to be able to see the emails you send but my inbox is always full of junk";
        String[] splitTestText = testText.split(" ");
        String[] results = search(testInput, splitTestText, sureness);
        if (results.length == 2) {
            System.out.printf("String '%s' found in text, found string '%s' with a sureness of '%f'", testInput, results[1], sureness);
        } else {
            System.out.printf("String '%s' not found in text", testInput);
        }
    }
    public static String[] search(String inputString, String[] testString, double sureness) {
        char[] splitInput = inputString.toCharArray();
        String found = "false";
        int index = 0;
        String[] result = new String[2];
        while (found != "true") {
            if (index > testString.length - 1) {
                result[0] = found;
                return result;
            }
            char[] currentSplit = testString[index].toCharArray();
             if (splitInput[0] == currentSplit[0]) {
                 int sameChar = 0;
                 for (int i = 0; i <= currentSplit.length; i++) {
                     if (i < splitInput.length) {
                         if (splitInput[i] == currentSplit[i]) {
                             sameChar += 1;
                         }
                     }
                 }
                 if (((double) sameChar / splitInput.length) == sureness) {
                     found = "true";
                     String foundString = testString[index];
                     result[0] = found;
                     result[1] = foundString;
                     return result;
                 }
             }
             index ++;
        }
        result[0] = found;
        return result;
    }
}