package homework2;

import java.util.Scanner;

public class BasicHomework {

    static void showMyGrade() {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter your score: ");
        } while (!printGrade(keyboard.nextInt()));
    }

    private static boolean printGrade(int score) {
        if (score < 0 || score > 100) {
            System.out.println("""
                          ERROR!
                     Incorrect enter!
                    PLEASE, TRY AGAIN!
                    """);
            return false;
        } else if (score < 50) {
            System.out.println("Your grade is F");
        } else if (score < 60) {
            System.out.println("Your grade is E");
        } else if (score < 70) {
            System.out.println("Your grade is D");
        } else if (score < 80) {
            System.out.println("Your grade is C");
        } else if (score < 90) {
            System.out.println("Your grade is B");
        } else {
            System.out.println("Your grade is A");
        }
        return true;
    }

    static void loopWithExit() {
        String text;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please, type something into the console: ");
        do {
            text = keyboard.nextLine();
        }while (!text.equalsIgnoreCase("EXIT"));
    }

    static void calculateSumUpTo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please, enter a number into the console: ");
        int number = keyboard.nextInt();
        int sum = 0;
        for (int i = 1; i <= Math.abs(number); i++) {
            sum += i;
        }
        sum = number < 0 ? sum * (-1) : sum;
        System.out.printf("Summary up to the number %d is %d\n", number, sum);
    }

    static void watchTV() {
        String[] channels = {"RESERVED", "Беларусь 1", "ОНТ", "СТВ", "РТР-Беларусь", "НТВ-Беларусь",
                                "Мир", "Беларусь 2", "Беларусь 3", "Беларусь 5"};
        Scanner keyboard = new Scanner(System.in);
        boolean isWork = true;

        while (isWork) {
            System.out.print("Enter channel number: ");
            int number = keyboard.nextInt();
            keyboard.nextLine();

            switch (number) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.println("On the screen: " + channels[number]);
                    break;
                case 0:
                    isWork = false;
                    break;
                default:
                    System.out.println("Incorrect enter! Please, try again!");
            }
        }
    }


}
