package Chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DecisionMaking {
    public void switchEx() {

        // !!!!!!
        /* Со свичем можно использовать только byte, short, char, int и их обертки. + enum + String + var (если тип уже определен  и разрешен)

        boolean, long, float, double нельзя!!!
         */

        int month = 5;
//        switch month { // DOES NOT COMPILE
//            case 1: System.out.print("January");
//        }
//
//        switch (month) // DOES NOT COMPILE
//        case 1: System.out.print("January");
//
//        switch (month) {
//            case 1: 2: System.out.print("January"); // DOES NOT COMPILE
//        }
//
//        switch (month) {
//            case 1 || 2:
//                System.out.print("January"); // DOES NOT COMPILE
//        }
        switch (month) {
        }

    }

    // пример свича
    public static void main(String[] args) {
        int dayOfWeek = 5;
        switch (dayOfWeek) {
            default:
                System.out.println("Weekday");
                break;
            case 0:
                System.out.println("Sunday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
        }
    }
}

class anotherSwitch {
    public static void main(String[] args) {
        var dayOfWeek = 5;
        switch (dayOfWeek) {
            case 0:
                System.out.println("Sunday");
            default:
                System.out.println("Weekday");
            case 6:
                System.out.println("Saturday");
                break;
        }
        // Код не находит 5ки и уходит на дефолт, а затем все оставшиеся вниз
        // Weekday
        // Saturday

        // Если dayOfWeek = 0, то
        // Sunday
        // Weekday
        // Saturday
    }

    final int getCookies() {
        return 4;
    }

    void feedAnimals() {
        final int bananas = 1;
        int apples = 2;
        int numberOfAnimals = 3;
        final int cookies = getCookies();
        switch (numberOfAnimals) {// значения в свиче могут быть только литералы, энамы, финальные переменные.
            case bananas:           // финальная, установленная переменная
                // case apples: // DOES NOT COMPILES        // считается в рантайме - нельзя
                // case getCookies(): // DOES NOT COMPILE   // считается в рантайме - нельзя
                // case cookies : // DOES NOT COMPILE       // хоть и финальная, но считается в рантайме - нельзя
            case 3 * 5:  // выражения можно
        }
    }

    private int getSortOrder(String firstName, final String lastName) {
        String middleName = "Patricia";
        final String suffix = "JR";
        int id = 0;
        switch (firstName) {
            case "Test":     // литерал - ок
                return 52;
//            case middleName: // DOES NOT COMPILE  // не финальная, считается в рантайме
//                id = 5;
//                 break;
            case suffix:   // финальная, все ок
                id = 0;
                break;
//            case lastName: // DOES NOT COMPILE   // считается в рантайме - не подойдет
//                id = 8;
//                break;
//            case 5: // DOES NOT COMPILE           // интовое значение, а свиче - стринг
//                id = 7;
//                break;
//            case 'J': // DOES NOT COMPILE         // char, а в свиче - стринг
//                id = 10;
//                break;
//            case java.time.DayOfWeek.SUNDAY: // DOES NOT COMPILE  // enam даты, а в свиче - стринг
//                id=15;
//                break;
        }
        return id;
    }

    public void anotherEx() {
        short size = 4;
        final int small = 15;      // финальная переменная может кастануться в short. Не финальная-вызовет ошибку, т.к. будет обычный int
        final int big = 1_000_000; // финальная переменная может кастануться, но тут слишком большая переменная для short без явного каста
        switch (size) {
            case small:
            case 1 + 2:
                // case big: // DOES NOT COMPILE
        }
    }
}

class WhileLoop {
    void example1() {
        int counter = 0;
        while (counter < 10) {
            double price = counter * 10;
            System.out.println(price);
            counter++;
        }
    }

    int roomInBelly = 5;

    public void eatCheese(int bitesOfCheese) {
        while (bitesOfCheese > 0 && roomInBelly > 0) {
            bitesOfCheese--;
            roomInBelly--;
        }
        System.out.println(bitesOfCheese + " pieces of cheese left");
    }

    // The do/while Statement
    void doWhileEx() {
        int lizard = 0;
        do {
            lizard++;
        } while (false);
        System.out.println(lizard); // 1
    }

    // for loop
    void forLoopEx() {
        for (int i = 0; i < 10; i++)
            System.out.print("Value is: " + i);
        // System.out.println(i); // DOES NOT COMPILE - за скоупом
    }

    // так можно
    void forLoopEx2() {
        int x = 0;  // можно задекларировать переменную вне лупа и использовать ее в лупе
        for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
            System.out.print(y + " ");
        } // 0 1 2 3 4 5
        System.out.print(x + " ");
    }

    void forLoopEx3() {
        //  int x = 0;
        //  for(int x = 4; x < 5; x++) { // DOES NOT COMPILE - повторная инициализация
        //     System.out.print(x + " ");
        //  }

        // так заработает
        int x = 0;
        for (x = 0; x < 5; x++) {
            System.out.print(x + " ");
        }
    }

    void forLoopEx4() {
//        int x = 0;
//        for(long y = 0, int z = 4; x < 5; x++) { // DOES NOT COMPILE - нельзя объявлять разные типы переменных
//            System.out.print(y + " ");
//        }
    }

    void forLoopEx5() {
        for (long y = 0, x = 4; x < 5 && y < 10; x++, y++) {
            System.out.print(y + " ");
        }
//        System.out.print(x); // DOES NOT COMPILE // х - за скоупом
    }

    void forLoopEx6() {
        for (int i = 0; i < 10; i++)  // бесконечная лупа
            i = 0;
        for (int j = 1; j < 10; j++)  // бесконечная лупа
            j--;
        for (int k = 0; k < 10; )     // все норм
            k++;
    }


    public void printNames(String[] names) {   // for-each loop
        for (String name : names)
            System.out.println(name);
    }

    public static void main(String[] args) {    // for-each loop example
        final String[] names = new String[3];
        names[0] = "Lisa";
        names[1] = "Kevin";
        names[2] = "Roger";
        for (String name : names) {
            System.out.print(name + ", ");  // Lisa, Kevin, Roger,
        }
        System.out.println();

        List<String> values = new ArrayList<String>();
        values.add("Lisa");
        values.add("Kevin");
        values.add("Roger");
        for (var value : values) {
            System.out.print(value + ", "); // Lisa, Kevin, Roger,
        }
        System.out.println();

//        String names = "Lisa";
//        for(String name : names) { // DOES NOT COMPILE  - нельзя итерироваться по строке через for-each
//            System.out.print(name + " ");
//        }

        char[] namesArr = "Lisa".toCharArray();  // так можно строку представить ввиде массива символов
        for (Character name : namesArr) {
            System.out.print(name + " "); // L i s a
        }
        System.out.println();

//        String[] names = new String[3];
//        for(int name : names) { // DOES NOT COMPILE   - в String[] не инты
//            System.out.print(name + " ");
//        }


        String[] namesString = new String[3];   // так полетит/
        for (String name : namesString) {
            System.out.print(name + " ");  // null null null
        }
        System.out.println();

        // еще пример, чтобы не печатать последнюю запятую
        List<String> names2 = new ArrayList<String>();
        names2.add("Lisa");
        names2.add("Kevin");
        names2.add("Roger");
        for (int i = 0; i < names2.size(); i++) {  // Lisa, Kevin, Roger
            String name = names2.get(i);
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(name);
        }
    }


    void twoDimensionalArray1() {
        // 1
        int[][] myComplexArray = {{5, 2, 1, 3}, {3, 9, 8, 9}, {5, 7, 12, 7}};
        for (int[] mySimpleArray : myComplexArray) {
            for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
            }
            System.out.println();
        }


        // 2
        int hungryHippopotamus = 8;
        while (hungryHippopotamus > 0) {
            do {
                hungryHippopotamus -= 2;
            } while (hungryHippopotamus > 5);
            hungryHippopotamus--;
            System.out.print(hungryHippopotamus + ", "); // 3, 0,
        }
    }
}

class Labels {
    public static void main(String[] args) {
        int[][] myComplexArray = {{5, 2, 1, 3}, {3, 9, 8, 9}, {5, 7, 12, 7}};
        OUTER_LOOP:
        for (int[] mySimpleArray : myComplexArray) {
            INNER_LOOP:
            for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
            }
            System.out.println();
        }
    }
}

// пример с break
class FindInMatrix {
    public static void main(String[] args) {
        int[][] list = {{1, 13}, {5, 2}, {2, 2}};
        int searchValue = 2;
        int positionX = -1;
        int positionY = -1;
        PARENT_LOOP:
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] == searchValue) {
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;
                }
            }
        }
        if (positionX == -1 || positionY == -1) {
            System.out.println("Value " + searchValue + " not found");
        } else {
            System.out.println("Value " + searchValue + " found at: " +  // Value 2 found at: (1,1)
                    "(" + positionX + "," + positionY + ")");
        }
    }
}

class ContinueEx {
    public static void main(String[] args) {
        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue CLEANING;
                }
                System.out.println("Cleaning: "+stables+", "+leopard);
            }
        }
    }
}
// Cleaning: a,1
// Cleaning: c,1
// Cleaning: d,1

class InnerLoopEx1{
    // Использование break для выхода из вложенных циклов.
     public static void main(String[] args) {
            outer:
            for (int i = 0; i < 3; i++) {
                System.out.print("Итерация " + i + ": ");
                for (int j = 0; j < 100; j++) {

                    if (j == 10) {
                        break outer; // выйти из обоих циклов
                    }
                    System.out.print(j + " ");
                }
                System.out.println("Эта строка никогда не будет выведена");
            }
            System.out.println("Цикл завершен.");
        }
}

// Демонстрирует continue.
class Continue {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("");
        }
    }
}

// Использование continue с меткой.
class ContinueLabel {

    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(" " + (i * j));
            }
        }
        System.out.println();
    }
}

// Unreachable Code
class UnreachableCode{
    public static void main(String[] args) {
        int checkDate = 0;
        while(checkDate<10) {
            checkDate++;
            if(checkDate>100) {
                break;
//                checkDate++; // DOES NOT COMPILE весь код после break, continue, return не скомпилируется
            }
        }


        int minute = 1;
        WATCH: while(minute>2) {
            if(minute++>2) {
                continue WATCH;
                // System.out.print(minute); // DOES NOT COMPILE
            }
        }
        int hour = 2;
        switch(hour) {
//            case 1: return; hour++; // DOES NOT COMPILE
            case 2:
        }


    }
}