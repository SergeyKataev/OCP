package Chapter3;

import java.io.File;

public class Q {
    public void primitiveEx() {
        // примитивы нельзя использовать с !, - c булеаном
       // int pelican = !5; // DOES NOT COMPILE
       // boolean penguin = -true; // DOES NOT COMPILE
       // boolean peacock = !0; // DOES NOT COMPILE


        // не хватает скобок
        // long pigeon = 1 + ((3 * 5) / 3; // DOES NOT COMPILE
        // int blueJay = (9 + 2) + 3) / (2 * 4; // DOES NOT COMPILE
        // short robin = 3 + [(4 * 2) + 4]; // DOES NOT COMPILE
    }

    public static void main(String[] args) {
        int lion = 3;
        int tiger = ++lion * 5 / lion--;
        float a = 1;
        // int tiger = 4 * 5 / lion--; // lion assigned value of 4
        // int tiger = 4 * 5 / 4; // lion assigned value of 3
        // tiger = 5
        // lion = 3
        System.out.println("lion is " + lion);
        System.out.println("tiger is " + tiger);
    }

    //1. Numeric Promotion Rules If two values have different data
    //types, Java will automatically promote one of the values to the
    //larger of the two data types.
    //2. If one of the values is integral and the other is floating-point, Java
    //will automatically promote the integral value to the floating-point
    //value’s data type.
    //3. Smaller data types, namely, byte, short, and char, are first
    //promoted to int any time they’re used with a Java binary
    //arithmetic operator, even if neither of the operands is int.
    //4. After all promotion has occurred and the operands have the same
    //data type, the resulting value will have the same data type as its
    //promoted operands.

    /*
    What is the data type of x * y?
    int x = 1;
    long y = 33;
    var z = x * y; (long)

    What is the data type of x + y?
    double x = 39.21;
    float y = 2.1;     // Если число с десятичной точкой - должно присутствовать f. С целыми числами так не надо. Если бы она была - то результат был бы double
    var z = x + y;  (does not complete)

    What is the data type of x * y?
    short x = 10;
    short y = 3;
    var z = x * y; (int)

    short w = 14;
    float x = 13;
    double y = 30;
    var z = w * x / y;  (double)
    */

    public void castingEx() {
        int fur = (int)5;
        int hair = (short) 2;
        String type = (String) "Bird";
        short tail = (short)(4 + 10); // тут кастуется результат
        short tail2 = (short)4 + 10;  // тут кастуется 4 и потом прибавляется 10
        // long feathers = 10(long); // DOES NOT COMPILE

        // float egg = 2.0 / 9; // DOES NOT COMPILE справа будет double / int. Результат будет double и он во float без каста не поместится
        // float a = 2.0;  // DOES NOT COMPILE                float = double
        // int tadpole = (int)5 * 2L; // DOES NOT COMPILE     long к double
        // short frog = 3 - 2.0; // DOES NOT COMPILE            doble to short

        // int fish = 1.0; // DOES NOT COMPILE
        // short bird = 1921222; // DOES NOT COMPILE
        // int mammal = 9f; // DOES NOT COMPILE
        // long reptile = 192301398193810323; // DOES NOT COMPILE

        short mouse = 10;
        short hamster = 3;
        // short capybara = (short)mouse * hamster; // DOES NOT COMPILE
        // short gerbil = 1 + (short)(mouse * hamster); // DOES NOT COMPILE


        long goat = 10;
        int sheep = 5;
        // sheep = sheep * goat; // DOES NOT COMPILE
        sheep *= goat; // автоприсваивание сначала приведет оба операнда к long, а затем проведет умножение и приведет к int

        long wolf = 5;
        long coyote = (wolf=3);  // операция присваивания возвращает значение, которое присваивалось. Тут сразу и изменение значения wolf и возврат тройки
        System.out.println(wolf); // 3
        System.out.println(coyote); // 3


        boolean healthy = false;
        if(healthy = true)   // вернется true
            System.out.print("Good!");
    }

    public void equalityEx() {
        // The equality operators are used in one of three scenarios:
        // * Comparing two numeric or character primitive types. If the numeric values are of different data types, the values are
        //      automatically promoted. For example, 5 == 5.00 returns true since the left side is promoted to a double.
        // * Comparing two boolean values
        // * Comparing two objects, including null and String values


        // тут упадет
        // boolean monkey = true == 3; // DOES NOT COMPILE
        // boolean ape = false != "Grape"; // DOES NOT COMPILE
        // boolean gorilla = 10.2 == "Koko"; // DOES NOT COMPILE


        // тут не упадет
        boolean bear = false;
        boolean polar = (bear = true);
        System.out.println(polar); // true

        boolean bear1 = false;
        boolean polar1 = (bear1 == true);
        System.out.println(polar1); // false

        File monday = new File("schedule.txt");
        File tuesday = new File("schedule.txt");
        File wednesday = tuesday;
        System.out.println(monday == tuesday); // false
        System.out.println(tuesday == wednesday); // true

        System.out.print(null == null); // true
    }

    public void numericComparisonOperatorsEx() {
        int gibbonNumFeet = 2, wolfNumFeet = 4, ostrichNumFeet = 2;
        System.out.println(gibbonNumFeet < wolfNumFeet); // true
        System.out.println(gibbonNumFeet <= wolfNumFeet); // true
        System.out.println(gibbonNumFeet >= ostrichNumFeet); // true
        System.out.println(gibbonNumFeet > ostrichNumFeet); // false
    }


}

class InstanceOfEx{

    public static void main(String[] args) {
        Integer zooTime = Integer.valueOf(9);
        Number num = zooTime;
        Object obj = zooTime;
        System.out.println(zooTime instanceof Integer); //true
        System.out.println(zooTime instanceof Number); //true
        System.out.println(zooTime instanceof Object); //true
        // System.out.println(zooTime instanceof String); // DOES NOT COMPILE, компилятор умен

        System.out.print(null instanceof Object); // false
        Object noObjectHere = null;
        System.out.print(noObjectHere instanceof String); // false

        // System.out.print(null instanceof null); // DOES NOT COMPILE  если справа null то не скомпилируется

        int hour = 10;
        boolean zooOpen = true || (hour < 4);
        System.out.println(zooOpen); // true

        int rabbit = 6;
        boolean bunny = (rabbit >= 6) || (++rabbit <= 7);
        System.out.println("rabbit " + rabbit);
    }
}

class TernaryOperator {
    public static void main(String[] args) {
        int owl = 5;
        int food = owl < 2 ? 3 : 4;
        System.out.println(food); // 4
        int food2 = (owl < 2) ? 3 : 4; // можно со скобками

        int stripes = 7;
        System.out.print((stripes > 5) ? 21 : "Zebra"); // принту не важно что писать
        // int animal = (stripes < 9) ? 3 : "Horse"; // DOES NOT COMPILE к int присваивается String

        int sheep = 1;
        int zzz = 1;
        int sleep = zzz<10 ? sheep++ : zzz++;    // только одно действие выполнится, zzz не будет увеличен
        System.out.print(sheep+","+zzz); // 2,1
    }
}

/*
1. Which of the following Java operators can be used with boolean variables? (Choose all that apply.)
A. ==   (Correct)
B. +
C. --
D. !    (Correct)
E. %
F. <=
G. Cast with (boolean)

2. What data type (or types) will allow the following code snippet to compile? (Choose all that apply.)
byte apples = 5;
short oranges = 10;
_______ bananas = apples + oranges;
A. int      (Correct)
B. long     (Correct)
C. boolean
D. double   (Correct)
E. short
F. byte

3. What change, when applied independently, would allow the following code snippet to compile? (Choose all that apply.)
3: long ear = 10;
4: int hearing = 2 * ear;

A. No change; it compiles as is.
B. Cast ear on line 4 to int.                        (Correct)
C. Change the data type of ear on line 3 to short.   (Correct)
D. Cast 2 * ear on line 4 to int.                    (Correct)
E. Change the data type of hearing on line 4 to short.
F. Change the data type of hearing on line 4 to long. (Correct)

4. What is the output of the following code snippet?
3: boolean canine = true, wolf = true;
4: int teeth = 20;
5: canine = (teeth != 10) ^ (wolf=false);               // true
6: System.out.println(canine+", "+teeth+", "+wolf); // true, 20, false
A. true, 20, true
B. true, 20, false       (Correct)
C. false, 10, true
D. false, 20, false
E. The code will not compile because of line 5.
F. None of the above

5. Which of the following operators are ranked in increasing or the
same order of precedence? Assume the + operator is binary
addition, not the unary form. (Choose all that apply.)
A. +, *, %, --     (Correct)
B. ++, (int), *                 // обратный порядок
C. =, ==, !         (Correct)
D. (short), =, !, *
E. *, /, %, +, ==               // обратный порядок
F. !, ||, &
G. ^, +, =, +=

// Order
expression++
++expression
- ! + (type)      -(unary)
* / %
+-
<< >> >>>
< > , <=, >=, instanceof
== !=
&^!
&& ||
Ternary
=, +=,           -(assignment)


6. What is the output of the following program?
1: public class CandyCounter {
2: static long addCandy(double fruit, float vegetables) {
3: return (int)fruit+vegetables;   // тут только fruit будет кастоваться, а vegetables - float и вернется float. Будет ошибка компиляции
4: }
5:
6: public static void main(String[] args) {
7: System.out.print(addCandy(1.4, 2.4f) + "-");  // 3-
8: System.out.print(addCandy(1.9, (float)4) + "-"); // 3-5-
9: System.out.print(addCandy((long)(int)(short)2,
(float)4)); } }
A. 4-6-6.0
B. 3-5-6
C. 3-6-6
D. 4-5-6
E. The code does not compile because of line 9.
F. None of the above                        (Correct)


7. What is the output of the following code snippet?
int ph = 7, vis = 2;
boolean clear = vis > 1 & (vis < 9 || ph < 2); // clear = true
boolean safe = (vis > 2) && (ph++ > 1);  // ph= 8, safe = false
boolean tasty = 7 <= --ph;   // tasty = false
System.out.println(clear+"-"+safe+"-"+tasty); // true-false-false
A. true-true-true
B. true-true-false
C. true-false-true
D. true-false-false     (Correct)
E. false-true-true
F. false-true-false
G. false-false-true
H. false-false-false

8. What is the output of the following code snippet?
4: int pig = (short)4;
5: pig = pig++;          pig = 4
6: long goat = (int)2;   goat = 2
7: goat -= 1.0;          goat = 1
8: System.out.print(pig + " - " + goat); 4 - 1
A. 4 - 1    (Correct)
B. 4 - 2
C. 5 - 1
D. 5 - 2
E. The code does not compile due to line 7.
F. None of the above

9. What are the unique outputs of the following code snippet? (Choose all that apply.)
int a = 2, b = 4, c = 2;                            a = 2, b = 4, c = 2
System.out.println(a > 2 ? --c : b++);          4   a = 2, b = 5, c = 2    сначала печатается, потом увеличивается
System.out.println(b = (a!=c ? a : b++));       5   a = 2, b = 6, c = 2
System.out.println(a > b ? b < c ? b : 2 : 1);  1
A. 1                (Correct)
B. 2
C. 3
D. 4                (Correct)
E. 5                (Correct)
F. 6
G. The code does not compile.

10. What are the unique outputs of the following code snippet? (Choose all that apply.)
short height = 1, weight = 3;
short zebra = (byte) weight * (byte) height; zebra = 3   // обе переменные кастанутся в байт, но их сумма будет инт и она не зайдет в переменную.
double ox = 1 + height * 2 + weight;         ox=6
long giraffe = 1 + 9 % height + 1;      giraffe = 1 + 0 + 1
System.out.println(zebra);   3
System.out.println(ox);      6
System.out.println(giraffe); 2
A. 1
B. 2
C. 3
D. 4
E. 5
F. 6
G. The code does not compile.       (Correct)

11. What is the output of the following code?
1: public class ArithmeticSample {
2: public static void main(String[] args) {
3: int sample1 = (2 * 4) % 3; // sample1 = 2
4: int sample2 = 3 * 2 % 3;   // sample2 = 0
5: int sample3 = 5 * (1 % 2); // sample3 = 5
6: System.out.println(sample1+"-"+sample2+"-"+sample3);
7: }}
A. 0-0-5
B. 1-2-10
C. 2-1-5
D. 2-0-5       (Correct)
E. 3-1-10
F. 3-2-6
G. The code does not compile.

12. The ________ operator increases a value and returns the
original value, while the ________ operator decreases a value
and returns the new value.
A. post-increment, post-increment
B. pre-decrement, post-decrement
C. post-increment, post-increment
D. post-increment, pre-decrement        (Correct)
E. pre-increment, pre-decrement
F. pre-increment, post-decrement

13. What is the output of the following code snippet?
boolean sunny = true, raining = false, sunday = true;
boolean goingToTheStore = sunny & raining ^ sunday;    goingToTheStore = true
boolean goingToTheZoo = sunday && !raining;             goingToTheZoo = true
boolean stayingHome = !(goingToTheStore &&              stayingHome = false
goingToTheZoo);
System.out.println(goingToTheStore + "-" + goingToTheZoo
+ "-" +stayingHome);                // true-true-false
A. true-false-false
B. false-true-false
C. true-true-true
D. false-true-true
E. false-false-false
F. true-true-false              (Correct)
G. None of the above

14. Which of the following statements are correct? (Choose all that apply.)
A. The return value of an assignment operation expression can be void.
B. The inequality operator (!=) can be used to compare objects.                                              (Correct)
C. The equality operator (==) can be used to compare a boolean value with a numeric value.
D. During runtime, the && and | operators may cause only the left side of the expression to be evaluated.
E. The return value of an assignment operation expression is the value of the newly assigned variable.       (Correct)
F. In Java, 0 and false may be used interchangeably.
G. The logical complement operator (!) cannot be used to flip numeric values.                                (Correct)


15. Which operators take three operands or values? (Choose all that apply.)
A. =
B. &&
C. *=
D. ? : (Correct)
E. &
F. ++
G. /


16. How many lines of the following code contain compiler errors?
int note = 1 * 2 + (long)3;                             (Error)
short melody = (byte)(double)(note *= 2);
double song = melody;
float symphony = (float)((song == 1_000f) ? song * 2L : song);
A. 0
B. 1                                                (Correct)
C. 2
D. 3
E. 4

17. Given the following code snippet, what is the value of the variables after it is executed? (Choose all that apply.)
int ticketsTaken = 1;
int ticketsSold = 3;
ticketsSold += 1 + ticketsTaken++; // Sold = 3 + 1 + 1, Taken = 2
ticketsTaken *= 2;                  // Taken = 2 * 2; Taken = 4, Sold = 5;
ticketsSold += (long)1;             // Sold = 5 + 1
A. ticketsSold is 8
B. ticketsTaken is 2
C. ticketsSold is 6         (Correct)
D. ticketsTaken is 6
E. ticketsSold is 7
F. ticketsTaken is 4        (Correct)
G. The code does not compile.


18. Which of the following can be used to change the order of
operation in an expression? (Choose all that apply.)
A. [ ]
B. < >
C. ( )          (Correct)
D. \ /
E. { }
F. " "

19. What is the result of executing the following code snippet? (Choose all that apply.)
3: int start = 7;
4: int end = 4;
5: end += ++start;    end = 4 + 8 = 12, start = 8
6: start = (byte)(Byte.MAX_VALUE + 1);  // -128
A. start is 0
B. start is -128                (Correct)
C. start is 127
D. end is 8
E. end is 11
F. end is 12                   (Correct)
G. The code does not compile.
H. The code compiles but throws an exception at runtime


20. Which of the following statements about unary operators are true? (Choose all that apply.)
A. Unary operators are always executed before any surrounding binary or ternary operators.              (Correct)
B. The - operator can be used to flip a boolean value.
C. The pre-increment operator (++) returns the value of the variable before the increment is applied.
D. The post-decrement operator (--) returns the value of the variable before the decrement is applied.  (Correct)
E. The ! operator cannot be used on numeric values.                                                     (Correct)
F. None of the above

 */