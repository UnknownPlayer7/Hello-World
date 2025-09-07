package homework2;

import java.util.*;

public class AdditionalHomework {

    private final static Scanner KEYBOARD = new Scanner(System.in);
    private static int[] firstTestArray = new int[10];
    private static int[][] secondTestArray = new int[10][10];
    private static int[][] thirdTestArray = new int[5][5];

    static {
        for (int i = 0; i < 10; i++) {
            firstTestArray[i] = (int)(Math.random() * 11);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                secondTestArray[i][j] = (int)(Math.random() * 11);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                thirdTestArray[i][j] = (int)(Math.random() * 11);
            }
        }
    }

    static void showConditions() {
        int firstNumber;
        int secondNumber;
        int thirdNumber;

        System.out.print("Введите число: ");
        firstNumber = KEYBOARD.nextInt();

        if(firstNumber > 10) {
            System.out.println("Число больше 10");
        } else if(firstNumber < 10) {
            System.out.println("Число меньше 10");
        } else {
            System.out.println("Число равно 10");
        }

        System.out.print("Введите два числа: ");
        firstNumber = KEYBOARD.nextInt();
        secondNumber = KEYBOARD.nextInt();
        if(firstNumber != secondNumber) {
            System.out.printf("Число %d больше числа %d\n", Math.max(firstNumber, secondNumber), Math.min(firstNumber, secondNumber));
        } else {
            System.out.println("Числа равны!");
        }

        System.out.print("Введите длины сторон треугольника: ");
        firstNumber = KEYBOARD.nextInt();
        secondNumber = KEYBOARD.nextInt();
        thirdNumber = KEYBOARD.nextInt();

        if (triangleExists(firstNumber, secondNumber, thirdNumber)) {
            if(firstNumber == secondNumber && firstNumber == thirdNumber) {
                System.out.println("Треугольник равносторонний");
            } else if (firstNumber == secondNumber || firstNumber == thirdNumber || secondNumber == thirdNumber) {
                System.out.println("Треугольник равноберенный");
            } else {
                System.out.println("Треугольник разносторонний");
            }
        } else {
            System.out.println("Такого треугольника не существует.");
        }

        System.out.print("Введите четыре числа: ");
        analyzeNumberSigns(KEYBOARD.nextInt(), KEYBOARD.nextInt(), KEYBOARD.nextInt(), KEYBOARD.nextInt());

        System.out.print("Введите три числа: ");
        firstNumber = KEYBOARD.nextInt();
        secondNumber = KEYBOARD.nextInt();
        thirdNumber = KEYBOARD.nextInt();
        System.out.printf("Наибольшее из трех чисел: %d\n", Math.max(Math.max(firstNumber, secondNumber), thirdNumber));

        System.out.print("Введите три числа: ");
        firstNumber = KEYBOARD.nextInt();
        secondNumber = KEYBOARD.nextInt();
        thirdNumber = KEYBOARD.nextInt();
        System.out.printf("Сумма наибольшего и наименьшего чисел: %d\n",
                (Math.max(Math.max(firstNumber, secondNumber), thirdNumber) +
                        Math.min(Math.min(firstNumber, secondNumber), thirdNumber)));


        System.out.print("Введите число: ");
        if(KEYBOARD.nextInt() % 2 > 0) {
            System.out.println("Число нечетное.");
        } else {
            System.out.println("Число четное.");
        }

        System.out.println("""
                \nМАГАЗИН
                СПИСОК ТОВАРОВ:
                1.Чай - 3.99 BYN
                2.Печеньки - 0.99 BYN
                3.Мороженое - 1.54 BYN
                """);
        System.out.print("Введите позицию, которую рассматриваете к покупке: ");
        firstNumber = KEYBOARD.nextInt();
        System.out.print("Введите вносимую сумму: ");
        double enteredMoney = KEYBOARD.nextDouble();
        System.out.println();

        switch (firstNumber) {
            case 1 -> checkMoney(enteredMoney, 3.99);
            case 2 -> checkMoney(enteredMoney, 0.99);
            case 3 -> checkMoney(enteredMoney, 1.54);

        }
    }

    private static boolean triangleExists(int x, int y, int z) {
        return ((x + y) > z) && ((x + z) > y) && ((y + z) > x);
    }

    private static void analyzeNumberSigns(int...numbers) {
        int amountPositiveNumbers = 0;
        int amountNegativeNumbers = 0;

        for (int number : numbers) {
            if (number > 0) {
                amountPositiveNumbers++;
            } else if (number < 0) {
                amountNegativeNumbers++;
            }
        }
        System.out.printf("Кол-во положительный чисел: %d; Кол-во отрицательный чисел: %d; Кол-во нулей: %d\n",
                amountPositiveNumbers, amountNegativeNumbers,
                (numbers.length - (amountNegativeNumbers + amountPositiveNumbers)));
    }

    private static void checkMoney(double enteredMoney, double requiredMoney) {
        if(enteredMoney == requiredMoney) {
            System.out.println("Спасибо за покупку!");
        }else if(enteredMoney > requiredMoney) {
            System.out.println("Ваша сдача: " + (enteredMoney - requiredMoney));
        } else {
            System.out.println("Денег не хватает!");
        }
    }

    static void showLoops() {
        showMultiplicationTable();

        System.out.print("Введите число: ");
        printAllEven(KEYBOARD.nextInt());

        int onlyPositiveNumber = requirePositiveNumber();
        System.out.print("Число Фибоначчи под этим индексом равно: " + findFibonacci(onlyPositiveNumber));

        onlyPositiveNumber = requirePositiveNumber();
        System.out.println("Факториал этого числа равен: " + factorial(onlyPositiveNumber));

        System.out.print("Введите сроку: ");
        KEYBOARD.nextLine();
        printChars(KEYBOARD.nextLine());


    }

    private static void showMultiplicationTable() {
        System.out.println("Таблица умножения на 4");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * 4 = %d\n", i, (i * 4));
        }
    }

    private static void printAllEven(int number) {
        System.out.printf("Список четных чисел от 0 до %d: ", number);

        for (int i = 0; i <= Math.abs(number); i++) {
            if(i % 2 == 0) {
                if(number < 0) {
                    System.out.print(i * (-1) + " ");
                } else {
                    System.out.print(i + " ");
                }

            }
        }
    }

    private static int findFibonacci(int index) {
        if(index <= 1) return 0;
        return switch (index) {
            case 2, 3 -> 1;
            default -> findFibonacci(index - 1) + findFibonacci(index - 2);
        };
    }

    private static int factorial(int number) {
        if(number == 0 || number == 1) return 1;
        return number * factorial(number - 1);
    }

    private static void printChars(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
    }

    private static int requirePositiveNumber() {
        System.out.print("\nВведите положительное число или ноль: ");
        int positiveNumber;
        while ((positiveNumber = KEYBOARD.nextInt()) < 0) {
            System.out.println("Вы ввели отрицательное число! Это недопустимо! Повторите ввод!");
        }
        return positiveNumber;
    }

    static void showArrays() {
        System.out.println("Дан одномерный массив: ");
        showOneDimensionalArray(firstTestArray);
        analyzeNumberSigns(firstTestArray);
        showNumbersSumWithEvenIndexes(firstTestArray);
        showEvenNumbersSum(firstTestArray);
        System.out.println("Наибольшее число в массиве: " + showMax(firstTestArray));
        showFrequentNumber(firstTestArray);
        System.out.println("Дан двумерный массив [10]x[10]: ");
        showTwoDimensionalArray(secondTestArray);
        showDiagonalSum(secondTestArray);
        System.out.println("Дан двумерный массив [5]x[5]: ");
        showTwoDimensionalArray(thirdTestArray);
        showMaxColumnSum(thirdTestArray);
    }

    private static void showOneDimensionalArray(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private static void showNumbersSumWithEvenIndexes(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if(i % 2 == 0) {
                sum += array[i];
            }
        }
        System.out.println("Сумма чисел с четными индексами: " + sum);
    }

    private static void showEvenNumbersSum(int[] array) {
        int sum = 0;

        for (int i : array) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("Сумма четных чисел: " + sum);
    }

    private static int showMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    private static void showFrequentNumber(int[] numbers) {
        ArrayList<Integer> arrayList = toArrayList(numbers);
        TreeMap<Integer, ArrayList<Integer>> frequentTable = createFrequentTable(arrayList);

        if(frequentTable.lastKey() == 1) {
            System.out.println("Повторов нет!");
        } else {
            Integer[] frequentNumbers = frequentTable.get(frequentTable.lastKey()).toArray(new Integer[0]);
            Arrays.sort(frequentNumbers);
            System.out.println("Наибольшее часто встречающееся число: " + frequentNumbers[frequentNumbers.length - 1]);
        }



    }

    private static ArrayList<Integer> toArrayList(int[] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer i : numbers) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private static TreeMap<Integer, ArrayList<Integer>> createFrequentTable(ArrayList<Integer> arrayList) {

        TreeMap<Integer, ArrayList<Integer>> frequentTable = new TreeMap<>();
        Integer number;
        int frequentAmount;

        while (!arrayList.isEmpty()) {
            number = arrayList.getFirst();
            frequentAmount = 0;
            while (arrayList.remove(number)) {
                frequentAmount++;
            }

            if(!frequentTable.containsKey(frequentAmount)) {
                frequentTable.put(frequentAmount, new ArrayList<>());
            }
            frequentTable.get(frequentAmount).add(number);
        }

        return frequentTable;
    }

    private static void showTwoDimensionalArray(int[][] array) {
        for (int[] i : array) {
            showOneDimensionalArray(i);
        }

    }

    private static void showDiagonalSum(int[][] array) {
        int[] result = new int[10];
        int j = 0;
        for (int i = 0; i < 10; i++) {
            result[i] = array[i][j];
            j++;
        }
        System.out.println("Все числа по диагонали от [0][0] до [10][10]: " + Arrays.toString(result));

        j = 9;
        for (int i = 0; i < 10; i++) {
            result[i] = array[i][j];
            j--;
        }
        System.out.println("Все числа по диагонали от [0][10] до [10][0]: " + Arrays.toString(result));
    }

    private static void showMaxColumnSum(int[][] array) {
        int[] sums = new int[array[0].length];
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                sums[i] += array[j][i];
            }
        }

        System.out.println("Максимальная сумма столбца: " + showMax(sums));
    }


}
