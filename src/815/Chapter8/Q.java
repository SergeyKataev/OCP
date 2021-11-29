package Chapter8;

public class Q {
}

class Q1{
    // Which code can be inserted to have the code print 2?
    // public class BirdSeed {
    // private int numberBags;
    // boolean call;
    // public BirdSeed() {
    // // LINE 1
    // call = false;
    // // LINE 2
    // }
    // public BirdSeed(int numberBags) {
    // this.numberBags = numberBags;
    // }
    // public static void main(String[] args) {
    // BirdSeed seed = new BirdSeed();
    // System.out.print(seed.numberBags);
    // } }

    // A. Replace line 1 with BirdSeed(2);   // конструктор нельзя вызвать без new
    // B. Replace line 2 with BirdSeed(2);  // конструктор нельзя вызвать без new
    // C. Replace line 1 with new BirdSeed(2);      // просто создаст объект и никак не передаст наружу
    // D. Replace line 2 with new BirdSeed(2);      // просто создаст объект и никак не передаст наружу
    // E. Replace line 1 with this(2);          // Correct
    // F. Replace line 2 with this(2);          // родительский констуктор можно вызывать только в первой строке
    // G. The code prints 2 without any changes.
}

class Q2 {
    // Which of the following statements about methods are true? (Choose all that apply.)
    //A. Overloaded methods must have the same signature.   // перегрузка как раз имеет только одинаковое имя, возвращаемый тип и параметры отличаются
    //B. Overridden methods must have the same signature.   // Correct
    //C. Hidden methods must have the same signature.       // Correct - hidden это как overriden, только статичные
    //D. Overloaded methods must have the same return type. // перегрузка как раз имеет только одинаковое имя, возвращаемый тип и параметры отличаются
    //E. Overridden methods must have the same return type. // Overriden может иметь возвращаемое значение covariant
    //F. Hidden methods must have the same return type.     // Hidden может иметь возвращаемое значение covariant
}

class Q3 {
    // What is the output of the following program?
    // 1: class Mammal {
    // 2: private void sneeze() {}
    // 3: public Mammal(int age) {
    // 4: System.out.print("Mammal");
    // 5: } }
    // 6: public class Platypus extends Mammal {
    // 7: int sneeze() { return 1; }                // тут все ОК, это независимый от родителя метод
    // 8: public Platypus() {                       // в этом конструкторе первым делом будет вызван super(), в родителе отсутствует конструктор по умолчанию
    // 9: System.out.print("Platypus");
    // 10: }
    // 11: public static void main(String[] args) {
    // 12: new Mammal(5);
    // 13: } }
    // A. Platypus
    // B. Mammal
    // C. PlatypusMammal
    // D. MammalPlatypus
    // E. The code will compile if line 7 is changed.
    // F. The code will compile if line 9 is changed.   // Correct
}

class Q4 {
    // Which of the following complete the constructor so that this code prints out 50? (Choose all that apply.)
    //class Speedster {
    //int numSpots;
    //}
    //public class Cheetah extends Speedster {
    //int numSpots;                         // так можно, у каждого класса свой numSpots
    //public Cheetah(int numSpots) {
    //// INSERT CODE HERE
    //}
    //public static void main(String[] args) {
    //Speedster s = new Cheetah(50);   // ССылка на Speedster, у него свой numSpots, но нет конструктора с параметром
    //System.out.print(s.numSpots);
    //}
    //}
    //A. numSpots = numSpots;               // бессмысленно
    //B. numSpots = this.numSpots;          // бессмысленно
    //C. this.numSpots = numSpots;          // бессмысленно, мы асайним переменную у Cheetah, которая не вызывается в main
    //D. numSpots = super.numSpots;         // бессмысленно, 0 = 0
    //E. super.numSpots = numSpots;         // Correct, мы асайним переменную Speedster
    //F. The code does not compile, regardless of the code inserted into the constructor.
    //G. None of the above
}

class Q5 {
    // What is the output of the following code?
    //1: class Arthropod {
    //2: protected void printName(long input) {   // overriden
    //3: System.out.print("Arthropod");
    //4: }
    //5: void printName(int input) {                // overriden
    //6: System.out.print("Spooky");
    //7: } }
    //8: public class Spider extends Arthropod {
    //9: protected void printName(int input) {   // overriden с расширением доступа, поэтому будет всегда вызываться он, даже если ссылка Arthropod
    //10: System.out.print("Spider");
    //11: }
    //12: public static void main(String[] args) {
    //13: Arthropod a = new Spider();  // Ссылка Arthropod
    //14: a.printName((short)4);       // идем в класс Arthropod и short -> int. Печатаем  Spooky
    //15: a.printName(4);               // Spooky
    //16: a.printName(5L);              // Arthropod
    //17: } }
    //A. SpiderSpiderArthropod
    //B. SpiderSpiderSpider
    //C. SpiderSpookyArthropod
    //D. SpookySpiderArthropod
    //E. The code will not compile because of line 5.   // 5я скомпилируется, это перегрузку с разными параметрами
    //F. The code will not compile because of line 9.   // 9я скомпилируется, overriden с расширением доступа
    //G. None of the above
}

class Q6 {
    // Which of the following statements about overridden methods are true? (Choose all that apply.)
    //A. An overridden method must contain method parameters that are the same or covariant with the method parameters in the inherited method.
            // При overridden параметры должны быть 1 в 1, а вот return type может быть такой же или covariant
    //B. An overridden method may declare a new exception, (при условии) provided it is not checked.  // Correct
        // Overriden  метод должен не деклалировать новые checked exception или новые checked exception шире, чем у родителя
        // Overriden метод может декларировать новые непроверяемые исключения, проверяемые новые не должен декларировать.
    //C. An overridden method must be more accessible than the method in the parent class.  // такой же или шире. Но не строго шире.
    //D. An overridden method may declare a broader checked exception than the method in the parent class.
        // Overriden метод может декларировать новые непроверяемые исключения, проверяемые новые не должен декларировать.
    //E. If an inherited method returns void, then the overridden version of the method must return void.
        // Overriden может менять return type на covatiant, у void только void
    //F. None of the above
}

class Q7 {
    // Which of the following pairs, when inserted into the blanks, allow the code to compile? (Choose all that apply.)
    // 1: public class Howler {
    // 2: public Howler(long shadow) {
    // 3: _____________;
    // 4: }
    // 5: private Howler(int moon) {
    // 6: super();
    // 7: }
    // 8: }
    // 9: class Wolf extends Howler {
    // 10: protected Wolf(String stars) {
    // 11: super(2L);
    // 12: }
    // 13: public Wolf() {
    // 14: _____________;
    // 15: }
    // 16: }

    // A. this(3) at line 3, this("") at line 14            // Correct
    // B. this() at line 3, super(1) at line 14             // this() - сломается, т.к.нет нужного конструктора
    // C. this((short)1) at line 3, this(null) at line 14   // Correct this((short)1) -> int, this(null) - пойдет в String
    // D. super() at line 3, super() at line 14             // super() нечем обработать
    // E. this(2L) at line 3, super((short)2) at line 14    // this(2L) - рекурсия
    // F. this(5) at line 3, super(null) at line 14         // super(null) - нечем обработать в родителе
    // G. Remove lines 3 and 14.                            // нельзя, будут вызваны super(), что все равно сломается
}

class Q8 {
    // What is the result of the following?
    // 1: public class PolarBear {
    // 2: StringBuilder value = new StringBuilder("t");
    // 3: { value.append("a"); }
    // 4: { value.append("c"); }
    // 5: private PolarBear() {
    // 6: value.append("b");
    // 7: }
    // 8: public PolarBear(String s) {
    // 9: this();
    // 10: value.append(s);
    // 11: }
    // 12: public PolarBear(CharSequence p) {
    // 13: value.append(p);
    // 14: }
    // 15: public static void main(String[] args) {
    // 16: Object bear = new PolarBear();       // tb
    // 17: bear = new PolarBear("f");           // tacbf
    // 18: System.out.println(((PolarBear)bear).value);
    // 19: } }

    // A. tacb
    // B. tacf
    // C. tacbf     // Correct
                    // 1. Создали стрингбилдер, инициализировали блоки при создании объекта, дернули метод со строкой, дернули метод по дефолту, добавили f
    // D. tcafb
    // E. taftacb
    // F. The code does not compile.
    // G. An exception is thrown.
}

class Q9 {
    // Which of the following method signatures are valid overrides of the hairy() method in the Alpaca class? (Choose all that apply.)

    // import java.util.*;
    // public class Alpaca {
    // protected List<String> hairy(int p) { return null; }
    // }

    // A. List<String> hairy(int p) { return null; }                // default уже, чем protected
    // B. public List<String> hairy(int p) { return null; }         // Correct
    // C. public List<CharSequence> hairy(int p) { return null; }   // Дженерики в return type должны быть 1 в 1
    // D. private List<String> hairy(int p) { return null; }        // private уже, чем protected
    // E. public Object hairy(int p) { return null; }               // Object не covariant
    // F. public ArrayList<String> hairy(int p) { return null; }    // ArrayList может заменить List
    // G. None of the above
}

class Q10 {
    // How many lines of the following program contain a compilation error?
    // 1: public class Rodent {
    // 2: public Rodent(var x) {}    // 1. var нельзя
    // 3: protected static Integer chew() throws Exception {
    // 4: System.out.println("Rodent is chewing");
    // 5: return 1;
    // 6: }
    // 7: }
    // 8: class Beaver extends Rodent {                 // 2. тут будет super(), который отсутствует в  Rodent
                                                        // 3. Number - не covariant для Integer 4. наследуемый метод не статичный
    // 9: public Number chew() throws RuntimeException {
    // 10: System.out.println("Beaver is chewing on wood");
    // 11: return 2;
    // 12: } }

    // A. None
    // B. 1
    // C. 2
    // D. 3
    // E. 4
    // F. 5
}

// пример с исключениями
class FirstClass {
    public void method()  {

    }
}

class SecondClass extends FirstClass{
   public void method() throws RuntimeException {  // новые непроверяемые исклчения можно выбрасывать
//    public void method() throws IOException { - так нельзя, новые проверяемые эксепшены выбрасывать нельзя
        System.out.println("1");
    }
}


class Q11 {
    //Which of the following statements about polymorphism are true? (Choose all that apply.)

    //A. An object may be cast to a subtype without an explicit cast.
        //объект можно привести к суперклассу без каста, но чтобы привести к подклассу (сузить) нужно явно кастовать

    //B. If the type of a method argument is an interface, then a reference variable that implements the interface may be passed to the method. // Correct
            // Если тип аргумента метода - интерфейс, тогда ссылка, которая имплементирует этот интерфейс мржет быть передана в этот метод

    //C. A method that takes a parameter with type java.lang.Object can be passed any variable. // Correct
        // Если в методе параметр Object, то можно передавать любой параметр

    //D. All cast exceptions can be detected at compile-time.
        // не все проблемы с кастом возможно определить при компиляции

    //E. By defining a final instance method in the superclass, you guarantee that the specific method will be called in the parent class at runtime. // Correct
            // Финальный метод класса не может быть переопределен в подклассе, ты гарантируешь, что вызов такого в родителе будет именно этим, а не override.

    //F. Polymorphism applies only to classes, not interfaces.
        // Полиморфизм так же применим в интерфейсам
}

// Пример райтаймовой ошибки при касте

class CastEx {
    public static void main(String[] args) {
        // Casting from super class may work, so it is allowed (during compilation). Casting from a totally different class is not allowed, for example:
        Integer a = 1;
//        String b1 = (String)a; // compile error
        String b2 = (String)(Object)a; // runtime error
    }
}


class Rodent8 {}
class Capybara8 extends Rodent8 {
    public static void main(String[] args) {
        Rodent8 rodent = new Rodent8();
        Capybara8 capybara = (Capybara8)rodent; // ClassCastException в рантайме. Ты не можешь более широй класс загонять в узкий через такой каст.
        // Rodent не может быть скастован в Capybara, но не знает  о ее существовании
    }
}

class Q12 {
    // Which of the following statements can be inserted in the blank so that the code will compile successfully? (Choose all that apply.)
    // public class Snake {}
    // public class Cobra extends Snake {}
    // public class GardenSnake extends Cobra {}
    // public class SnakeHandler {
    // private Snake snake;
    // public void setSnake(Snake snake) { this.snake = snake;
    // }
    // public static void main(String[] args) {
    // new SnakeHandler().setSnake(___________);
    // }
    // }

    // A. new Cobra()           // Correct Можно, т.к. Cobra extends Snake
    // B. new Snake()           // Correct Можно, т.к. это как раз целевой параметр в методе
    // C. new Object()          //  Object суперкласс Snake, так нельзя
    // D. new String("Snake")   // String нельзя
    // E. new GardenSnake()     // Correct Cobra extends Snake, GardenSnake extends Cobra
    // F. null                  // Correct - можно передать, т/к/ аргумент ссылка
    // G. None of the above. The class does not compile, regardless of the value inserted in the blank.
}

class Q13 {
    // Which of these classes compile and will include a default constructor created by the compiler? (Choose all that apply.)
    // A.                       // Correct
    // public class Bird {}
    // B.                      // не скомпилируется, метод без return type
    // public class Bird {
    // public bird() {}
    // }
    // C.                       // не скомпилируется, метод без return type
    // public class Bird {
    // public bird(String name) {}
    // }
    // D.                   // уже есть конструктор
    // public class Bird {
    // public Bird() {}
    // }
    // E.                   // уже есть конструктор
    // public class Bird {
    // Bird(String name) {}
    // }
    // F.
    // public class Bird {  // уже есть конструктор
    // private Bird(int age) {}
    // }
    // G.
    // public class Bird {              // Correct
    // public Bird bird() {return null;}
    // }
}

class Q14 {
    // Which of the following statements about inheritance are correct? (Choose all that apply.)
    // A. A class can directly extend any number of classes.    // класс может наследовать только от одного класса
    // B. A class can implement any number of interfaces.       // Correct
    // C. All variables inherit java.lang.Object.               // примитивы не наследуются от Object
    // D. If class A is extended by B, then B is a superclass of A. // тогда B это subclass
    // E. If class C implements interface D, then C is subtype of D.                                // Correct
    // F. Multiple inheritance is the property of a class to have multiple direct superclasses.     // Correct
}

class Q15 {
    // What is the result of the following?
    // 1: class Arachnid {
    // 2: static StringBuilder sb = new StringBuilder();
    // 3: { sb.append("c"); }
    // 4: static
    // 5: { sb.append("u"); }
    // 6: { sb.append("r"); }
    // 7: }
    // 8: public class Scorpion extends Arachnid {
    // 9: static
    // 10: { sb.append("q"); }
    // 11: { sb.append("m"); }
    // 12: public static void main(String[] args) {
    // 13: System.out.print(Scorpion.sb + " "); // 1. дергается статичный инициализатор родителя - u, потомка q
    // 14: System.out.print(Scorpion.sb + " "); // 1. дергается статичный инициализатор родителя - u, потомка q
    // 15: new Arachnid();      1. статичные инициализаторы больше не вызываются, вызываются инициализаторы объекта cr
    // 16: new Scorpion();      1. статичные инициализаторы больше не вызываются, вызываются инициализаторы родителя, потом объекта crm
    // 17: System.out.print(Scorpion.sb);   // 1. дергается статичный инициализатор родителя - u, потомка q
    // 18: } }

    // A. qu qu qumrcrc
    // B. u u ucrcrm
    // C. uq uq uqmcrcr
    // D. uq uq uqcrcrm   // Correct
    // E. qu qu qumcrcr
    // F. qu qu qucrcrm
    // G. The code does not compile.
}

class Q16 {
    // Which of the following methods are valid overrides of the friendly() method in the Llama class? (Choose all that apply.)

    //import java.util.*;
    //public class Llama {
    //void friendly(List<String> laugh, Iterable<Short> s) {}
    //}

    //A. void friendly(List<CharSequence> laugh, Iterable<Short> s) {}
    //B. void friendly(List<String> laugh, Iterable<Short> s) {}            // Correct
    //C. void friendly(ArrayList<String> laugh, Iterable<Short> s) {}
    //D. void friendly(List<String> laugh, Iterable<Integer> s) {}
    //E. void friendly(ArrayList<CharSequence> laugh, Object s) {}
    //F. void friendly(ArrayList<String> laugh, Iterable... s) {}
    //G. None of the above

    //A valid override of a method with generic arguments must have
    //the same signature with the same generic types.

    // Remember, covariant types only apply to return values of
    //overridden methods, not method parameters.
}

class Q17 {
    // Which of the following statements about inheritance and variables are true? (Choose all that apply.)
    //A. Instance variables can be overridden in a subclass.
            // переменная может быть только скрыта (static), не overriden
    //B. If an instance variable is declared with the same name as an inherited variable, then the type of the variable must be covariant.
            // в таком случае типы переменных никак не свазяны
    //C. If an instance variable is declared with the same name as an inherited variable, then the access modifier must be
            // at least as accessible as the variable in the parent class.
            // к переменным это не относится
    //D. If a variable is declared with the same name as an inherited static variable, then it must also be marked static.
            // к переменным не относится, это относится к методам
    //E. The variable in the child class may not throw a checked exception that is new or broader than the class of any
            // exception thrown in the parent class variable.
            // переменные не выбрасывают исключения
    //F. None of the above     // Correct
}

class Q18 {
    // Which of the following are true? (Choose all that apply.)
    //A. this() can be called from anywhere in a constructor.               // только на первой строке
    //B. this() can be called from anywhere in an instance method.          // только на первой строке конструктора
    //C. this.variableName can be called from any instance method in the class.  //Correct
    //D. this.variableName can be called from any static method in the class.   // нет, если эта переменная не статичная
    //E. You can call the default constructor written by the compiler using this(). // если пользователь сам написал дефолтный конструктор, то вызовется пользовательский
    //F. You can access a private constructor with the main() method in the same class. // Correct
}

class Q19 {
    // Which statements about the following classes are correct? (Choose all that apply.)
    // 1: public class Mammal {
    // 2: private void eat() {}
    // 3: protected static void drink() {}
    // 4: public Integer dance(String p) { return null; }
    // 5: }
    // 6: class Primate extends Mammal {
    // 7: public void eat(String p) {}  // в классе Mammal eat() - приватный, поэтому он не может быть overriden или overload
    // 8: }
    // 9: class Monkey extends Primate {
    // 10: public static void drink() throws RuntimeException {}  // hiden, добаввлять unchecked можно + доступ шире, return тип такой же, параметры те же
    // 11: public Number dance(CharSequence p) { return null; }
    // 12: public int eat(String p) {}
    // 13: }

    //A. The eat() method in Mammal is correctly overridden on line 7.   // в классе Mammal eat() - приватный, поэтому он не может быть overriden или overload
    //B. The eat() method in Mammal is correctly overloaded on line 7.  // в классе Mammal eat() - приватный, поэтому он не может быть overriden или overload
    //C. The drink() method in Mammal is correctly hidden on line 10.   // Correct
    //D. The drink() method in Mammal is correctly overridden on line 10.   // он hidden, т.к. статичный
    //E. The dance() method in Mammal is correctly overridden on line 11.   // разные аргументы
    //F. The dance() method in Mammal is correctly overloaded on line 11.   // Correct, разные аргументы
    //G. The eat() method in Primate is correctly hidden on line 12.        // он не статичный, поэтому не hidden. Разные параметры int и void
    //H. The eat() method in Primate is correctly overloaded on line 12.    // Одинаковые параметры

    /*
    Корректно overriden метод -
    1. У переопределенного метода должны быть те же аргументы, что и у метода родителя.
    2. У переопределенного метода должны быть совместимый (наследник класса) тип возвращаемого значения, что и у метода родителя.
    3. Модификатор доступа у переопределенного метода не может быть уже «оригинального»:
    4. Нельзя добавлять новые checked exception
     */

        /*
    Корректно overload метод -
    1. У перегруженного метода должны отличаться методы (тип, последовательность)
    2. У перегруженного метода тип возвращаемого значения может отличаться от "оригинального".
    3. У перегруженного метода модификатор доступа может отличаться от "оригинального".
     */

    public static void sum(int a) {
        System.out.println("sum - a");
    }


    private static int sum(float f) {
        System.out.println("sum - f");
        return  1;
    }

    public static void main(String[] args) {
        sum(1);
//        sum(1.0);  // не скомпилируется. A float к double может подняться и зайти в метод
        sum(1.0f);
    }
}

class Q20 {
    // What is the output of the following code?
    // 1: class Reptile {
    // 2: {System.out.print("A");}
    // 3: public Reptile(int hatch) {}
    // 4: void layEggs() {                  //  будер вызываться overriden метод
    // 5: System.out.print("Reptile");
    // 6: } }
    // 7: public class Lizard extends Reptile {
    // 8: static {System.out.print("B");}
    // 9: public Lizard(int hatch) {}   // тут будет вызываться super(), которого нет в родителе
    // 10: public final void layEggs() {  // т.к. final, то вызывается этот метод, а не родителя
    // 11: System.out.print("Lizard");
    // 12: }
    // 13: public static void main(String[] args) {
    // 14: Reptile reptile = new Lizard(1);
    // 15: reptile.layEggs();
    // 16: } }

    // A. AALizard
    // B. BALizard
    // C. BLizardA
    // D. ALizard
    // E. The code will not compile because of line 10.
    //F. None of the above
}

// пример с ошибкой дефолтного конструктора
class R1 {
    R1(int q){

    }
}

//class R2 extends R1{      // будет создан дефолтный конструктор, который дернет super() и ошибется
//}

//class R2 extends R1{      // внутри конструктора будет super() , который ошибется
//    R2 (int q){
//
//    }
//}


class Reptile19 {
{System.out.print("A");}
public Reptile19(int hatch) {}
void layEggs() {
    System.out.print("Reptile");
 } }

 class Lizard extends Reptile19 {
 static {System.out.print("B");}
 public Lizard(int hatch) {
     super(1);
 }
 public final void layEggs() {
 System.out.print("Lizard");
 }
 public static void main(String[] args) {
     Reptile19 reptile = new Lizard(1);
 reptile.layEggs();
 } }


 class Q21 {
     // Which statement about the following program is correct?
     // 1: class Bird {
     // 2: int feathers = 0;
     // 3: Bird(int x) { this.feathers = x; }
     // 4: Bird fly() {
     // 5: return new Bird(1);
     // 6: } }
     // 7: class Parrot extends Bird {
     // 8: protected Parrot(int y) { super(y); }
     // 9: protected Parrot fly() {
     // 10: return new Parrot(2);
     // 11: } }
     // 12: public class Macaw extends Parrot {
     // 13: public Macaw(int z) { super(z); }
     // 14: public Macaw fly() {
     // 15: return new Macaw(3);
     // 16: }
     // 17: public static void main(String... sing) {
     // 18: Bird p = new Macaw(4);
     // 19: System.out.print(((Parrot)p.fly()).feathers); // 1.calls the overridden version of fly() defined in the Macaw class 2.Cast to Parrot
     // 20: } }

     //A. One line contains a compiler error.
     //B. Two lines contain compiler errors.
     //C. Three lines contain compiler errors.
     //D. The code compiles but throws a ClassCastException at
     //runtime.
     //E. The program compiles and prints 3.   // Correct
     //F. The program compiles and prints 0.

     /*
     method is correctly overridden in each subclass since the signature is the same, the access modifier is less restrictive,
     and the return types are covariant.
      */
 }

 class Q22 {
    // What does the following program print?
     // 1: class Person {
     // 2: static String name;
     // 3: void setName(String q) { name = q; } }
     // 4: public class Child extends Person {
     // 5: static String name;
     // 6: void setName(String w) { name = w; }
     // 7: public static void main(String[] p) {
     // 8: final Child m = new Child();
     // 9: final Person t = m;
     // 10: m.name = "Elysia";      // m - Child.name = "Elysia"
     // 11: t.name = "Sophia";      // t - Person.name = "Sophia"
     // 12: m.setName("Webby");     // overriden метод на строке 6 m - Child.name = "Webby"
     // 13: t.setName("Olivia");    // overriden метод на строке 6 m - Child.name = "Olivia"
     // 14: System.out.println(m.name + " " + t.name);
     // 15: } }

     // A. Elysia Sophia
     // B. Webby Olivia
     // C. Olivia Olivia
     // D. Olivia Sophia
     // E. The code does not compile.
     // F. None of the above
 }

 class Q23 {
    // What is the output of the following program?
     // 1: class Canine {
     // 2: public Canine(boolean t) { logger.append("a"); }
     // 3: public Canine() { logger.append("q"); }
     // 4:
     // 5: private StringBuilder logger = new StringBuilder();
     // 6: protected void print(String v) { logger.append(v); }
     // 7: protected String view() { return logger.toString(); }
     // 8: }
     // 9:
     // 10: class Fox extends Canine {
     // 11: public Fox(long x) { print("p"); }          // тут зашит super()
     // 12: public Fox(String name) {
     // 13: this(2);
     // 14: print("z");
     // 15: }
     // 16: }
     // 17:
     // 18: public class Fennec extends Fox {
     // 19: public Fennec(int e) {
     // 20: super("tails");
     // 21: print("j");
     // 22: }
     // 23: public Fennec(short f) {
     // 24: super("eevee");
     // 25: print("m");
     // 26: }
     // 27:
     // 28: public static void main(String... unused) {
     // 29: System.out.println(new Fennec(1).view());
                // 1. Вызываем конструктор на стр 19
                // 2. Вызываем конструктор на стр 12
                // 3. Вызываем конструктор на стр  11, перед тем как напечатать "p" будет вызван super()
                // 4. Вызываем конструктор на стр 3 и печатаем  "q"
                // 5. на стр 11 печатаем "p"
                // 6. на стр 14 печатаем "z"
                // 7. на стр 21 перечаем "j"

     // 30: } }

     //A. qpz
     //B. qpzj
     //C. jzpa
     //D. apj
     //E. apjm
     //F. The code does not compile.
     //G. None of the above
 }

 class Q24 {
    // Which statements about polymorphism and method inheritance are correct? (Choose all that apply.)
     //A. It cannot be determined until runtime which overridden method will be executed in a parent class. // Correct
     //B. It cannot be determined until runtime which hidden method will be executed in a parent class. // hidden определяется по ссылке
     //C. Marking a method static prevents it from being overridden or hidden.
     //D. Marking a method final prevents it from being overridden or hidden.  // Correct
     //E. The reference type of the variable determines which overridden method will be called at runtime.
     //F. The reference type of the variable determines which hidden method will be called at runtime. // Correct
 }

 class Q25 {
     // What is printed by the following program?
     // 1: class Antelope {
     // 2: public Antelope(int p) {
     // 3: System.out.print("4");
     // 4: }
     // 5: { System.out.print("2"); }
     // 6: static { System.out.print("1"); }
     // 7: }
     // 8: public class Gazelle extends Antelope {
     // 9: public Gazelle(int p) {
     // 10: super(6);
     // 11: System.out.print("3");
     // 12: }
     // 13: public static void main(String hopping[]) {
     // 14: new Gazelle(0);    //
     /*
     1. Статичные блоки родителя - 1
     2. Cтатичные блоки потомка - 8
     3. Нестатичные блоки родителя и констуктор - 24
     4. Нестатичные блоки потомка и конструктор- 93
      */

     // 15: }
     // 16: static { System.out.print("8"); }
     // 17: { System.out.print("9"); }
     // 18: }

     // A. 182640
     // B. 182943           // Correct
     // C. 182493
     // D. 421389
     // E. The code does not compile.
     // F. The output cannot be determined until runtime.
 }

 class Q26 {
    // How many lines of the following program contain a compilation error?
     //1: class Primate {
     //2: protected int age = 2;
     //3: { age = 1; }
     //4: public Primate() {
     //5: this().age = 3;   // так нельзя, не скомпилируется
     //6: }
     //7: }
     //8: public class Orangutan {
     //9: protected int age = 4;
     //10: { age = 5; }
     //11: public Orangutan() {
     //12: this().age = 6;  // так нельзя, не скомпилируется
     //13: }
     //14: public static void main(String[] bananas) {
     //15: final Primate x = (Primate)new Orangutan();  // ошибка каста при компиляции
     //16: System.out.println(x.age);
     //17: }
     //18: }

     // A. None, and the program prints 1 at runtime.
     //B. None, and the program prints 3 at runtime.
     //C. None, but it causes a ClassCastException at runtime.
     //D. 1
     //E. 2
     //F. 3         // Correct
     //G. 4
 }