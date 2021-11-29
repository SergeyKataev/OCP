package Chapter2;

public class Constructors {

    // нельзя обращаться к переменной до объявления
    // { System.out.println(name); } // DOES NOT COMPILE

    private String name = "Fluffy";

    {
        System.out.println("name = " + name);
        System.out.println("setting field");
    }

    public Constructors() {
        name = "Tiny";
        System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        Constructors constructor = new Constructors();
        System.out.println(constructor.name);
    }
}

// вопрос №2
class Egg {
    public Egg() {
        number = 5;
    }
    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number);
    }
    private int number = 3;
    { number = 4; } }

    // Ответ 5

// Переменные
// Переменные могут начинаться с $, _, символа
// могут включать цифры, но не могут с них начинаться
// нельзя использовать зарезервированные слова

// Prepare to be tested on these rules. The following examples are legal:
// long okidentifier;
// float $OK2Identifier;
// boolean _alsoOK1d3ntifi3r;
// char __SStillOkbutKnotsonice$;

// These examples are not legal:
// int 3DPointClass; // identifiers cannot begin with a number
// byte hollywood@vine; // @ is not a letter, digit, $ or _
// String *$coffee; // * is not a letter, digit, $ or _
// double public; // public is a reserved word
// short _; // a single underscore is not allowed


class Declaring {
    void sandFence() {
        String s1, s2;
        String s3 = "yes", s4 = "no";
        int i1, i2, i3 = 0;
        // int num, String value; // DOES NOT COMPILE
        boolean b1, b2;
        String s5 = "1", s6;
        // double d1, double d2; // DOES NOT COMPILE
        int i4; int i5;
        // int i3; i4; // DOES NOT COMPILE
    }
}


// переменные
class InitializingVariables {
    public void notValid() {
        int y = 10;
        int x;
        // int reply = x + y; // DOES NOT COMPILE
    }

    public void findAnswer(boolean check) {
        int answer;
        int otherAnswer;
        int onlyOneBranch;
        if (check) {
            onlyOneBranch = 1;
            answer = 1;
        } else {
            answer = 2;
        }
        System.out.println(answer);
        // System.out.println(onlyOneBranch); // DOES NOT COMPILE
    }

    public void checkAnswer() {
        boolean value;
        // findAnswer(value); // DOES NOT COMPILE
    }

    // You can only use this feature for local variables.
    public class VarKeyword {
        // var tricky = "Hello"; // DOES NOT COMPILE
    }

    public void reassignment() {
        var number = 7;
        number = 4;
        //number = "five"; // DOES NOT COMPILE

        var apples = (short)10;
        apples = (byte)5;
        // apples = 1_000_000; // DOES NOT COMPILE
        }


//    public void doesThisCompile(boolean check) {
//        var question;        должны быть объявлены в одной линии
//        question = 1;
//        var answer;          должны быть объявлены в одной линии
//        if (check) {
//            answer = 2;
//            } else {
//            answer = 3;
//            }
//        System.out.println(answer);
//        }

    public void twoTypes() {      //Java does not allow var in multiple variable declarations.
//        int a, var b = 3; // DOES NOT COMPILE
//        var n = null; // DOES NOT COMPILE
//        var a = 2, b = 3; // DOES NOT COMPILE

    var n = "myData";
    n = null;  // можно, т.к. ссылочный тип
    var m = 4;
    // m = null; // DOES NOT COMPILE нельзя, т.к. примитивный тип
        var o = (String)null; // тип определен, поэтому можно null
        }


//        public int addition(var a, var b) { // DOES NOT COMPILE, используем только как локальную переменную
//            return a + b;
//        }

}
// тут все нормально
class Var {
    public void var() {
        var var = "var";
    }
    public void Var() {
        Var var = new Var();
    }
}
//  var - нельзя называть классы
//class var { // DOES NOT COMPILE
//    public var() {
//    }


// Review of var Rules
// We complete this section by summarizing all of the various rules for
// using var in your code. Here’s a quick review of the var rules:
// 1. A var is used as a local variable in a constructor, method, or initializer block.
// 2. A var cannot be used in constructor parameters, method parameters, instance variables, or class variables.
// 3. A var is always initialized on the same line (or statement) where it is declared.
// 4. The value of a var can change, but the type cannot.
// 5. A var cannot be initialized with a null value without a type.
// 6. A var is not permitted in a multiple-variable declaration.
// 7. A var is a reserved type name but not a reserved word, meaning it
//can be used as an identifier except as a class, interface, or enum name.


// Managing Variable Scope

class CariablesEx {
    public void eatIfHungry(boolean hungry) {
        if (hungry) {
            int bitesOfCheese = 1;
        } // bitesOfCheese goes out of scope here
        // System.out.println(bitesOfCheese); // DOES NOT COMPILE
    }

    public void eatIfHungry2(boolean hungry) {
        if (hungry) {
            int bitesOfCheese = 1;
            {
                var teenyBit = true;
                System.out.println(bitesOfCheese);
            }
        }
        //System.out.println(teenyBit); // DOES NOT COMPILE
    }

    // Good example
    public void eatMore(boolean hungry, int amountOfFood) {
        int roomInBelly = 5;
        if (hungry) {
            var timeToEat = true;
            while (amountOfFood > 0) {
                int amountEaten = 2;
                roomInBelly = roomInBelly - amountEaten;
                amountOfFood = amountOfFood - amountEaten;
                }
            }
        System.out.println(amountOfFood);
        }

}

class Mouse {
    final static int MAX_LENGTH = 5;
    int length;
    public void grow(int inches) {
        if (length < MAX_LENGTH) {
            int newSize = length + inches;
            length = newSize;
            System.out.println(MAX_LENGTH);
        }
    }
}

// Reviewing Scope
// Local variables: In scope from declaration to end of block
// Instance variables: In scope from declaration until object eligible for garbage collection
// Class variables: In scope from declaration until program ends


class GC {
    public static void main(String[] args) {
        System.gc();
        // For the exam, you need to know that System.gc() is not guaranteed to
        // run or do anything, and you should be able to recognize when objects
        // become eligible for garbage collection

        // An object is no longer reachable when one of two situations occurs:
        // The object no longer has any references pointing to it.
        // All references to the object have gone out of scope
    }
}
class Scope {
    public static void main(String[] args) {
        String one, two;
        one = new String("a");
        two = new String("b");
        one = two;
        String three = one;
        one = null;
    } }

    // Review Questions

// 1. Which of the following are valid Java identifiers? (Choose all that apply.)
// A. _                                     // нельзя просто нижнее подчеркивание
// B. _helloWorld$   (Correct)              // можно начинать с нижнего подчеркивания
// C. true                                  // нельзя использовать резервные слова
// D. java.lang                             // нельзя использовать пакеты как переменную
// E. Public         (Correct)              // Public не зарезервированное слово
// F. 1980_s                                // нельзя начинать с цифр
// G. _Q2_           (Correct)              // можно использовать цифры и начинать с _

class Q1 {
    //int _ = 1;
    int _helloWorld$ = 1;
}

// 2. What lines are printed by the following program? (Choose all that apply.)
//1: public class WaterBottle {
//2:  private String brand;
//3:  private boolean empty;
//4:  public static float code;
//5:  public static void main(String[] args) {
//6:  WaterBottle wb = new WaterBottle();
//7:  System.out.println("Empty = " + wb.empty);
//8:  System.out.println("Brand = " + wb.brand);
//9:  System.out.println("Code = " + code);
//10: } }
//A. Line 8 generates a compiler error.
//B. Line 9 generates a compiler error.
//C. Empty =
//D. Empty = false                         (Correct)    // Boolean по умолчанию false
//E. Brand =
//F. Brand = null                          (Correct)    // String по умолчаанию null
//G. Code = 0.0                            (Correct)    // float и double по умолчанию 0.0
//H. Code = 0f

class WaterBottle {
    private String brand;
    private boolean empty;
    public static float code;
    public static void main(String[] args) {
    WaterBottle wb = new WaterBottle();
    System.out.println("Empty = " + wb.empty);
    System.out.println("Brand = " + wb.brand);
    System.out.println("Code = " + code);
        var day = 1/0;
        System.out.println("day = " + day);
}
}

//3. Which of the following code snippets about var compile without issue when used in a method? (Choose all that apply.)
//A. var spring = null;                                     // var нельзя определять как null
//B. var fall = "leaves";                  (Correct)        // можно
//C. var evening = 2; evening = null;                       // var нельзя множественно определять
//D. var night = new Object();             (Correct)        // можно определить как ссылку
//E. var day = 1/0;                        (Correct)        // можно определить как примитив, но сломается при запуске, компилятор не ругаеца
//F. var winter = 12, cold;                                 // var нельзя множественно определять
//G. var fall = 2, autumn = 2;                              // var нельзя множественно определять
//H. var morning = ""; morning = null;    (Correct)         // это 2 разные строки. Сначала как строка, а потом строку в null - так можно

class Q3 {
    void method3() {
        // var spring = null;
        var fall = "leaves";
       // var evening = 2; evening = null;
        var night = new Object();
        var day = 1/0;
       // var winter = 12, cold;
      // var fall = 2, autumn = 2;
      var morning = ""; morning = null;
    }
}

//4. Which of the following statements about the code snippet are true? (Choose all that apply.)
//4: short numPets = 5L;
//5: int numGrains = 2.0;
//6: String name = "Scruffy";
//7: int d = numPets.length();
//8: int e = numGrains.length;
//9: int f = name.length();
//A. Line 4 generates a compiler error.     (Correct)       // Long нельзя передать в short без каста
//B. Line 5 generates a compiler error.     (Correct)       // Double нельзя передать в int без каста
//C. Line 6 generates a compiler error.
//D. Line 7 generates a compiler error.     (Correct)      // у примитивов нет метода .length()
//E. Line 8 generates a compiler error.     (Correct)
//F. Line 9 generates a compiler error.

class Q4 {
    //short numPets = 5L;
    //int numGrains = 2.0;
    String name = "Scruffy";
    //int d = numPets.length();
    //int e = numGrains.length;
    int f = name.length();
}

//5. Which statements about the following class are true? (Choose all that apply.)
//1: public class River {
//2: int Depth = 1;
//3: float temp = 50.0;
//4: public void flow() {
//5: for (int i = 0; i < 1; i++) {
//6: int depth = 2;
//7: depth++;
//8: temp--;
//9: }
//10: System.out.println(depth);
//11: System.out.println(temp); }
//12: public static void main(String... s) {
//13: new River().flow();
//14: } }
//A. Line 3 generates a compiler error.      (Correct)  float temp = 50.0; - во float нужно явно указывать f.
//B. Line 6 generates a compiler error.
//C. Line 7 generates a compiler error.
//D. Line 10 generates a compiler error.      (Correct)  // из внешнего контура нет доступа к внутреннему
//E. The program prints 3 on line 10.
//F. The program prints 4 on line 10.
//G. The program prints 50.0 on line 11.
//H. The program prints 49.0 on line 11.

class River {
int Depth = 1;
//float temp = 50.0;
public void flow() {
for (int i = 0; i < 1; i++) {
int depth = 2;
depth++;
//temp--;
}
//System.out.println(depth);
//System.out.println(temp);
}
public static void main(String... s) {
new River().flow();
}}

//6. Which of the following are correct? (Choose all that apply.)
//A. An instance variable of type float defaults to 0.
//B. An instance variable of type char defaults to null.
//C. An instance variable of type double defaults to 0.0.         (Correct)
//D. An instance variable of type int defaults to null.
//E. An instance variable of type String defaults to null.        (Correct)
//F. An instance variable of type String defaults to the empty
//string "".
//G. None of the above

//7. Which of the following are correct? (Choose all that apply.)
//A. A local variable of type boolean defaults to null.             // локальные переменные не автоназначаются
//B. A local variable of type float defaults to 0.0f.
//C. A local variable of type double defaults to 0.
//D. A local variable of type Object defaults to null.
//E. A local variable of type boolean defaults to false.
//F. A local variable of type float defaults to 0.0.
//G. None of the above                                              (Correct)

//8. Which of the following are true? (Choose all that apply.)
//A. A class variable of type boolean defaults to 0.
//B. A class variable of type boolean defaults to false.             (Correct)
//C. A class variable of type boolean defaults to null.
//D. A class variable of type long defaults to null.
//E. A class variable of type long defaults to 0L.                  (Correct)
//F. A class variable of type long defaults to 0.
//G. None of the above


//9. Which of the following statements about garbage collection are correct? (Choose all that apply.)
//A. Calling System.gc() is guaranteed to free up memory by destroying objects eligible for garbage collection.
//B. Garbage collection runs on a set schedule.
//C. Garbage collection allows the JVM to reclaim memory for other objects.                                  (Correct)
//D. Garbage collection runs when your program has used up half the available memory.
//E. An object may be eligible for garbage collection but never removed from the heap.                       (Correct)
//F. An object is eligible for garbage collection once no references to it are accessible in the program.    (Correct)
//G. Marking a variable final means its associated object will never be garbage collected.


//10. Which statements about the following class are correct? (Choose all that apply.)
//1: public class PoliceBox {
//2: String color;
//3: long age;
//4: public void PoliceBox() {
//5: color = "blue";
//6: age = 1200;
//7: }
//8: public static void main(String []time) {
//9: var p = new PoliceBox();
//10: var q = new PoliceBox();
//11: p.color = "green";
//12: p.age = 1400;
//13: p = q;
//14: System.out.println("Q1="+q.color);
//15: System.out.println("Q2="+q.age);
//16: System.out.println("P1="+p.color);
//17: System.out.println("P2="+p.age);
//18: } }
//A. It prints Q1=blue.
//B. It prints Q2=1200.
//C. It prints P1=null.                 (Correct)
//D. It prints P2=1400.
//E. Line 4 does not compile.
//F. Line 12 does not compile.
//G. Line 13 does not compile.
//H. None of the above

class PoliceBox {
String color;
long age;
public void PoliceBox() {
color = "blue";
age = 1200;
}
public static void main(String []time) {
var p = new PoliceBox();
var q = new PoliceBox();
p.color = "green";
p.age = 1400;
p = q;
System.out.println("Q1="+q.color);
System.out.println("Q2="+q.age);
System.out.println("P1="+p.color);
System.out.println("P2="+p.age);
} }

// p = color: null. age 0L
// q = color: null. age 0L

//11. Which of the following legally fill in the blank so you can run the main() method from the command line? (Choose all that apply.)
//public static void main(_______________) {}
//A. String... var                      (Correct)
//B. String My.Names[]
//C. String[] 123
//D. String[] _names                    (Correct)
//E. String... $n                       (Correct)
//F. var names
//G. String myArgs

//12. Which of the following expressions, when inserted independently into the blank line, allow the code to compile? (Choose all that apply.)
//public void printMagicData() {
//double magic = _____;
//System.out.println(magic);
//}
//A. 3_1           (Correct)    // просто число
//B. 1_329_.0                   // _ рядом с точкой
//C. 3_13.0_                    // _ в конце нельзя
//D. 5_291._2                   // _ рядом с точкой
//E. 2_234.0_0     (Correct)
//F. 9___6         (Correct)
//G. _1_3_5_0                   // _ в начале нельзя
//H. None of the above

class Q12 {
    public void printMagic() {
        double magic = 3;
    }
}


//13. Suppose we have a class named Rabbit. Which of the following statements are true? (Choose all that apply.)
//1: public class Rabbit {
//2: public static void main(String[] args) {
//3: Rabbit one = new Rabbit();
//4: Rabbit two = new Rabbit();
//5: Rabbit three = one;
//6: one = null;
//7: Rabbit four = one;
//8: three = null;
//9: two = null;
//10: two = new Rabbit();
//11: System.gc();
//12: } }
//A. The Rabbit object created on line 3 is first eligible for garbage collection immediately following line 6.
//B. The Rabbit object created on line 3 is first eligible for garbage collection immediately following line 8.     (Correct)
//C. The Rabbit object created on line 3 is first eligible for garbage collection immediately following line 12.
//D. The Rabbit object created on line 4 is first eligible for garbage collection immediately following line 9.     (Correct)
//E. The Rabbit object created on line 4 is first eligible for garbage collection immediately following line 11.
//F. The Rabbit object created on line 4 is first eligible for garbage collection immediately following line 12.
//G. The Rabbit object created on line 10 is first eligible for garbage collection immediately following line 11.
//H. The Rabbit object created on line 10 is first eligible for garbage collection immediately following line 12.  (Correct)


//14. Which of the following statements about var are true? (Choose all that apply.)
//A. A var can be used as a constructor parameter.                                          // var может быть только в методе
//B. The type of var is known at compile time.                                  (Correct)   // вар определяется в одной строчке в моменте компиляции
//C. A var cannot be used as an instance variable.                              (Correct)   // var может быть только в методе, в классе не может быть
//D. A var can be used in a multiple variable assignment statement.                         // var не разрешает множественного определения
//E. The value of var cannot change at runtime.                                             // var можно менять, нельзя менять тип
//F. The type of var cannot change at runtime.                                  (Correct)
//G. The word var is a reserved word in Java.                                               // var не резервное слово, так можно назвать переменную



//15. Given the following class, which of the following lines of code can
// independently replace INSERT CODE HERE to make the code compile? (Choose all that apply.)
//public class Price {
//public void admission() {
//INSERT CODE HERE
//System.out.print(amount);
//} }
//A. int Amount = 0b11;             // naming the variable Amount will cause the System.out.print(amount)
//B. int amount = 9L;                           // long нельзя в int
//C. int amount = 0xE;              (Correct)
//D. int amount = 1_2.0;                       // double нельзя в int
//E. double amount = 1_0_.0;                // _ перед точкой
//F. int amount = 0b101;          (Correct)
//G. double amount = 9_2.1_2;        (Correct)
//H. double amount = 1_2_.0_0;              // _ перед точкой


//16. Which statements about the following class are correct? (Choose all that apply.)
//1: public class ClownFish {
//2: int gills = 0, double weight=2;   // нельзя подряд объявлять разные типы переменных
//3: { int fins = gills; }
//4: void print(int length = 3) {     // в переметре нельзя присваивать переменную
//5: System.out.println(gills);
//6: System.out.println(weight);
//7: System.out.println(fins);       // разные скоупы, будет ошибка
//8: System.out.println(length);
//9: } }
//A. Line 2 contains a compiler error.    (Correct)
//B. Line 3 contains a compiler error.
//C. Line 4 contains a compiler error.    (Correct)
//D. Line 7 contains a compiler error.    (Correct)
//E. The code prints 0.
//F. The code prints 2.0.
//G. The code prints 2.
//H. The code prints 3.



//17. Which statements about classes and its members are correct? (Choose all that apply.)
//A. A variable declared in a loop cannot be referenced outside the loop.      (Correct) // переменную объявленную в лупе нельзя использовать вне лупы
//B. A variable cannot be declared in an instance initializer block.                    // переменную можно определить в блоке инициализации
//C. A constructor argument is in scope for the life of the instance of the class for which it is defined. // переменная конструктора доступна только в конструкторе
//D. An instance method can only access instance variables declared before the instance method declaration. // метод может обращаться к переменным, которые написаны и до и после метода
//E. A variable can be declared in an instance initializer block but cannot be referenced outside the block.  (Correct) // переменные доступны только в своем скоупе
//F. A constructor can access all instance variables.                                                         (Correct) // конструктор имеет доступ ко всем переменным
//G. An instance method can access all instance variables.                                                    (Correct) // метод класса иммет доступ ко всем переменным

//18. Which statements about the following code snippet are correct? (Choose all that apply.)
//3: var squirrel = new Object();
//4: int capybara = 2, mouse, beaver = -1;
//5: char chipmunk = -1;
//6: squirrel = "";
//7: beaver = capybara;
//8: System.out.println(capybara);
//9: System.out.println(mouse);
//10: System.out.println(beaver);
//11: System.out.println(chipmunk);

//A. The code prints 2.
//B. The code prints -1.
//C. The code prints the empty String.
//D. The code prints: null.
//E. Line 4 contains a compiler error.
//F. Line 5 contains a compiler error.     (Correct)
//G. Line 9 contains a compiler error.     (Correct)
//H. Line 10 contains a compiler error.


//19. Assuming the following class compiles, how many variables defined in the class or method are in scope on the line marked
//SCOPE on line 14?
//1: public class Camel {
//2: { int hairs = 3_000_0; }                   // нет
    //3: long water, air=2;   // 1,2,3
    //4: boolean twoHumps = true; // 4
        //5: public void spit(float distance) {
        //6: var path = "";         // 5
        //7: { double teeth = 32 + distance++; } // нет
        //8: while(water > 0) {
            //9: int age = twoHumps ? 1 : 2;   // 6
            // 10: short i=-1;
                //11: for(i=0; i<10; i++) {
                //12: var Private = 2;          // 7
                //13: }
//14: // SCOPE
//15: }
//16: }
//17: }


//A. 2
//B. 3
//C. 4
//D. 5
//E. 6
//F. 7                      (Correct)
//G. None of the above


//20. What is the output of executing the following class?
//1: public class Salmon {
//2: int count;
//3: { System.out.print(count+"-"); }
//4: { count++; }
//5: public Salmon() {
//6: count = 4;
//7: System.out.print(2+"-");
//8: }
//9: public static void main(String[] args) {
//10: System.out.print(7+"-");
//11: var s = new Salmon();
//12: System.out.print(s.count+"-"); } }


/*
1. 7-
2. 7-0- (блок при создании класса Салмон)
3. 7-0-2- (из конструктора Салмон, у объекта каунт = 4)
4. 7-0-2-4-
 */


//A. 7-0-2-1-
//B. 7-0-1-
//C. 0-7-2-1-
//D. 7-0-2-4-               (Correct)
//E. 0-7-1-
//F. The class does not compile because of line 3.
//G. The class does not compile because of line 4.
//H. None of the above.

//21. Which statements about the following program are correct? (Choose all that apply.)
//1: public class Bear {
//2: private Bear pandaBear;
//3: protected void finalize() {}
//4: private void roar(Bear b) {
//5: System.out.println("Roar!");
//6: pandaBear = b;
//7: }
//8: public static void main(String[] args) {
//9: Bear brownBear = new Bear();
//10: Bear polarBear = new Bear();
//11: brownBear.roar(polarBear);
//12: polarBear = null;
//13: brownBear = null;
//14: System.gc(); } }

/*
1)
pandaBear =
brownBear = B1;
polarBear = B2;
11)
pandaBear = brownBear = B2
brownBear = B1;
polarBear = B2;
12)
pandaBear = brownBear = B2
brownBear = B1;
polarBear = null;
13)
pandaBear = null
brownBear = null;
polarBear = null;
 */



//A. The object created on line 9 is eligible for garbage collection after line 13.  (Correct)
//B. The object created on line 9 is eligible for garbage collection after line 14.
//C. The object created on line 10 is eligible for garbage collection after line 12.
//D. The object created on line 10 is eligible for garbage collection after line 13.  (Correct)
//E. Garbage collection is guaranteed to run.
//F. Garbage collection might or might not run.                               (Correct)
//G. Garbage collection is guaranteed not to run.
//H. The code does not compile.

//22. Which of the following are valid instance variable declarations? (Choose all that apply.)
//A. var _ = 6000_.0;       // var не может быть instance переменной, только переменной метода
//B. var null = 6_000;
//C. var $_ = 6_000;
//D. var $2 = 6_000f;
//E. var var = 3_0_00.0;
//F. var #CONS = 2_000.0;
//G. var %C = 6_000_L;
//H. None of the above       (Correct)