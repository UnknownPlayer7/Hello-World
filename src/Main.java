import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        greetings();
        showAllVariablesType();
        showAllMethodsWithString();
    }

    public static void greetings() {
        System.out.println("Hi! I'm Dmitry Gudamov.");
        System.out.println("I work as a spare parts manager.");
    }

    public  static void showAllVariablesType() {
        byte byteVariable = 30;
        short shortVariable = 2025;
        int intVariable = 9_349_645;
        long longVariable = 8_230_000_000L;
        double doubleVariable = 3.141592653589793;
        float floatVariable = 3.141592f;
        char charVariable = '\u2740';
        String formattedMessage = """
                \nDECIMAL NUMBER:
                byte = %d;   short = %d;   int = %,d;   long = %,d;
                
                FLOATING-POINT NUMBER:
                float = %.6f;   double = %.15f;
                
                SYMBOL:
                char = %c.
                """;
        System.out.printf(formattedMessage, byteVariable, shortVariable, intVariable, longVariable,
                            doubleVariable, floatVariable, charVariable);
    }

    public static void showAllMethodsWithString() {
        String string = readConsole();
        if(string.isEmpty()) {
            System.out.println("The string is Empty. There's nothing to check and modify.");
            return;
        }
        System.out.println(checkStringRules(string));
        System.out.println(showWaysToModifyString(string));
    }

    private static String readConsole() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nType something...");

        return keyboard.nextLine();
    }

    private static String checkStringRules(String word) {
        StringBuilder stringBuilder = new StringBuilder("\nCheckout result:\n");
        stringBuilder.append("Contains word \"word\": ").append(word.contains("word")).append("\n")
                .append("Start with eng. letter A: ").append(word.startsWith("A")).append("\n")
                .append("End with eng. letter e: ").append(word.endsWith("e")).append("\n")
                .append("Length: ").append(word.length()).append("\n")
                .append("At the 0th position is: ").append(word.charAt(0)).append("\n")
                .append("The text equals to \"hello world\": ").append(word.equals("hello world")).append("\n")
                .append("The text equals to \"hello world\" ignored case: ").append(word.equalsIgnoreCase("hello world"));
        return stringBuilder.toString();
    }

    private static String showWaysToModifyString(String word) {
        StringBuilder stringBuilder = new StringBuilder("\nHere are several ways to modify the word:\n");
        stringBuilder.append("To lower case: ").append(word.toLowerCase()).append("\n")
                .append("To upper case: ").append(word.toUpperCase()).append("\n")
                .append("Change All letters to symbol \"*\": ").append(word.replaceAll(".","*"));
        return stringBuilder.toString();
    }

}