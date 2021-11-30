package Chapter1;

public class C1_Q {
}

class Q1 {
    // Which statements about the final modifier are correct? (Choose all that apply.)
    // A. Instance and static variables can be marked final. // Correct
    // B. A variable is effectively final if it is marked final. // может быть effectively final даже без модификатора final
    // C. The final modifier can be applied to classes and interfaces. // интерфейс всегда public abstact и не может быть final
    // D. A final class cannot be extended.                             // Correct
    // E. An object that is marked final cannot be modified.            // можно модифицировать
    // F. Local variables cannot be declared with type var and the final modifier.  // Можно final var
}

class Q2 {
    // What is the result of the following program?
}
class FlavorsEnum {
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY;     // тут была ошибка не поставлена ;
        // When an enum contains only a list of values, the semicolon (;) after the list is optional.
        static final Flavors DEFAULT = STRAWBERRY;
//        final Flavors DEFAULT = STRAWBERRY; - так нельзя
        }
    public static void main(String[] args) {
        for(final var e : Flavors.values())
            System.out.print(e.ordinal()+" "); // 0 1 2
    }
}

// A. 0 1 2
//B. 1 2 3
//C. Exactly one line of code does not compile.     // Correct
//D. More than one line of code does not compile.
//E. The code compiles but produces an exception at runtime.
//F. None of the above


class Q3 {
    // What is the result of the following code? (Choose all that apply.)
}

class Movie {
    private int butter = 5;
    private Movie() {}
    protected class Popcorn {  // Inner класс может иметь любой уровень доступа
        private Popcorn() {}
        //         public static int butter = 10;  // Inner class не может определять static поля или методы.
                // Можно только static final переменные
        public void startMovie() {
            System.out.println(Movie.this.butter); // внутренний класс имеет доступ к внешней переменной.
                // если все ок, то напечатает 10
            // Чтобы обратиться к butter из Movie - Movie.this.butter
        }
    }


    public static void main(String[] args) {
        var movie = new Movie();
        Movie.Popcorn in = new Movie().new Popcorn() {};  // так можно определять, даже если конструктор приватный
        in.startMovie();
    } }

// A. The output is 5.
//B. The output is 10.
//C. Line 6 generates a compiler error. // Correct
//D. Line 12 generates a compiler error.
//E. Line 13 generates a compiler error.
//F. The code compiles but produces an exception at runtime.


class Q4 {
    // Which statements about default and private interface methods are correct? (Choose all that apply.)

    /*
    дефолный метод может или публичным, или дефолтным (нельзя private или default)
    дефолтный не может быть static/final/abstract

    приватный может быть только public
    приватный может вызываться только из дефолтного или приватного метода
    приватный не может быть абстрактным, т.к. не наследуется

    приватный статичный может быть вызван только в том же методе интерфейса

     */

    //A. A default interface method can be declared private.
    //B. A default interface method can be declared public.     // Correct
    //C. A default interface method can be declared static.
    //D. A private interface method can be declared abstract.
    //E. A private interface method can be declared protected.
    //F. A private interface method can be declared static.  // Correct
}

class Q5 {
    // Which of the following are valid lambda expressions? (Choose all that apply.)

    // A. (Wolf w, var c) -> 39   // если есть var, то везде var
    // B. (final Camel c) -> {}  // Correct, final modifier is permitted on variables in the parameter list
    // C. (a,b,c) -> {int b = 3; return 2;}  // если переменных больше 2х то НЕ надо указывать тип, тут косяк с переменной b, она уже определена
    // D. (x,y) -> new RuntimeException()   // Correct
    // E. (var y) -> return 0;              // Correct, () - опциональны
    // F. () -> {float r}                   // если есть {}, значит надо return. Или если это объявление переменной, то надо ;
    // G. (Cat a, b) -> {}                  // b без типа
}

class Q6 {
    /*
    You can reduce code duplication by moving shared code from default or static methods into
    a private or private static method

     */

    // What are some advantages of using private interface methods? (Choose all that apply.)
    // A. Improve polymorphism
    // B. Improve performance at runtime
    // C. Reduce code duplication    // Correct
    // D. Backward compatibility     // apply to default methods
    // E. Encapsulate interface implementation  // Correct  - users of the interface do not have access to them.
    // F. Portability
}

class Q7 {
    // What is the result of the following program?
    // public class IceCream {
    // enum Flavors {
    // CHOCOLATE, STRAWBERRY, VANILLA               // если только перечисления, то можно без ;
    // }
    // public static void main(String[] args) {
    // Flavors STRAWBERRY = null;
    // switch (STRAWBERRY) {
    // case Flavors.VANILLA: System.out.print("v");   // нельзя так делать перечисления. Нужно указывать только значение "VANILLA"
    // case Flavors.CHOCOLATE: System.out.print("c");
    // case Flavors.STRAWBERRY: System.out.print("s");
    // break;
    // default: System.out.println("missing flavor"); }
    // }
    // }

    // A. v
    // B. vc
    // C. s
    // D. missing flavor
    // E. Exactly one line of code does not compile.
    // F. More than one line of code does not compile.              // Correct
    // G. The code compiles but produces an exception at runtime.
}

class IceCream {
enum Flavors {
CHOCOLATE, STRAWBERRY, VANILLA               // если только перечисления, то можно без ;
}
public static void main(String[] args) {
Flavors STRAWBERRY = null;
switch (STRAWBERRY) {           // нельзя передавать null, будет NPE. Так можно Flavors STRAWBERRY = Flavors.STRAWBERRY;
case VANILLA: System.out.print("v");   // нельзя так делать перечисления. Нужно указывать только значение "VANILLA"
case CHOCOLATE: System.out.print("c");
case STRAWBERRY: System.out.print("s");
break;
default: System.out.println("missing flavor"); }
}
}


class Q8 {
    // Which statements about functional interfaces are true? (Choose all that apply.)

    // A. A functional interface can contain default and private methods. // Correct, может содердать, главное один SAM
                    // can contain any number of nonabstract methods including default, private, static, and private static.
    // B. A functional interface can be defined by a class or interface.  - только интерфейс
    // C. Abstract methods with signatures that are contained in public methods of java.lang.Object do
            // not count toward the abstract method count for a functional interface.  // Correct
    // D. A functional interface cannot contain static or private static methods.    // Может содержать, главное один SAM
    // E. A functional interface contains at least one abstract method.              // не at least, а ровно 1 SAM
    // F. A functional interface must be marked with the @FunctionalInterface annotation.   // не must, а желательно
}


class Q9 {
    //  Which lines, when entered independently into the blank, allow the code to print Not scared at
    //  runtime? (Choose all that apply.)
    // public class Ghost {
    // public static void boo() {
    // System.out.println("Not scared");
    // }
    // protected final class Spirit {  // внутренний класс может иметь любой access modifier. FINAL!!!!
    // public void boo() {
    // System.out.println("Booo!!!");
    // }
    // }
    // public static void main(String… haunt) {
    // var g = new Ghost().new Spirit() {};  // так можно писать
    // __________________________________ ;
    // }
    // }

    // A. g.boo()               // "Booo!!!"
    // B. g.super.boo()     // Calling a Hidden default Method - дефолтный метод вызывается: Run.super.getSpeed();
    // C. new Ghost().boo() - можно, через создание экземпляра
    // D. g.Ghost.boo()        - нельзя
    // E. new Spirit().boo()    - внутренний класс нельзя вызывать из статичного блока  psvm
    // F. Ghost.boo()   - можно, т.к. boo() статичный
    // G. None of the above     // Correct. Если все ок, то ответ C и F
}

class Ghost {
public static void boo() {
System.out.println("Not scared");
}
protected  class Spirit {  // внутренний класс может иметь любой access modifier. FINAL!!!!
public void boo() {
System.out.println("Booo!!!");
}
}
public static void main(String... haunt) {
//var g = new Ghost().new Spirit() {};  // используется анонимный внутренний класс, который наследуется от Ghost.
            // Spirit финальный и не может использовать в такой конструкции
    var g = new Ghost().new Spirit() {};

// __________________________________ ;
}
}

class Q10 {
    // The following code appears in a file named Ostrich.java. What is the result of compiling the source
    //file?

    // 1: public class Ostrich {
    // 2: private int count;
    // 3: private interface Wild {}
    // 4: static class OstrichWrangler implements Wild {
    // 5: public int stampede() {
    // 6: return count;
    // 7: } } }

    // A. The code compiles successfully, and one bytecode file is generated: Ostrich.class.
    //B. The code compiles successfully, and two bytecode files are generated: Ostrich.class and
    //OstrichWrangler.class.
    //C. The code compiles successfully, and two bytecode files are generated: Ostrich.class and
    //Ostrich$OstrichWrangler.class.
    //D. A compiler error occurs on line 4.
    //E. A compiler error occurs on line 6.         // Correct
}

class Q11 {
    // What is the result of the following code?
}
interface CanWalk {
     default void walk() { System.out.print("Walking"); }   // нужно переопределять.
     private void testWalk() {}                         // private и static не нужно переопределять
            // При extend не работают правила, как при implement
}
interface CanRun {
     abstract public void run();
     private void testWalk() {}     // private и static не нужно переопределять. ПРи extend не работают правила,
            // как при implement
     default void walk() { System.out.print("Running"); }
}
interface CanSprint extends CanWalk, CanRun {   // не переопределен walk() из CanWalk
     void sprint();
     default void walk(int speed) {
     System.out.print("Sprinting");
     }

     private void testWalk() {}

    default void walk(){}; // без этой строки не полетит
     }


// A. The code compiles without issue.
// B. The code will not compile because of line 6.
// C. The code will not compile because of line 8.
// D. The code will not compile because of line 10.   // Correct
// E. The code will not compile because of line 12.
// F. None of the above

class Q12 {
    // What is the result of executing the following program?
}


interface Sing {
    boolean isTooLoud(int volume, int limit);
}
class OperaSinger {
    public static void main(String[] args) {
//        check((h, l) -> h.toString(), 5); // m1    у Sing нет метода toString. Это не Object
    }
    private static void check(Sing sing, int volume) {
        if (sing.isTooLoud(volume, 10)) // m2  isToLoud будет выполняться логика из лямбды
            System.out.println("not so great");
        else System.out.println("great");
    }
}

// A. great
// B. not so great
// C. Compiler error on line m1         // Correct
// D. Compiler error on line m2
// E. Compiler error on a different line
// F. A runtime exception is thrown.

class Q13 {
    // Which lines of the following interface declaration do not compile? (Choose all that apply.)
}
//interface Herbivore {
// int amount = 10;   // обычный int может быть в интерфейсе. implicity public static final
// static boolean gather = true; // implicity public static final
// static void eatGrass() {}        // implicity public
// int findMore() { return 2; }   // Non-static methods within an interface must be explicitly marked private or default.
// default float rest() { return 2; } // implicity public
// protected int chew() { return 13; }  //  interfaces do not have protected members
// private static void eatLeaves() {}   // ок, ничего неявно не добавится
// }

class Q14 {
    // What is printed by the following program?
}

class Deer {
 enum Food {APPLES, BERRIES, GRASS}
 protected class Diet {           // inner class
 private Food getFavorite() {
 return Food.BERRIES;
 }
 }
 public static void main(String[] seasons) {
// switch(new Diet().getFavorite()) {  // нельзя дергать new Diew() без создания Deer. или сделать Diet static
switch(new Deer().new Diet().getFavorite()) {  // так полетит
         case APPLES: System.out.print("a");
 case BERRIES: System.out.print("b");
 default: System.out.print("c");
 }
 }
 }

 class Q15 {
    //Which of the following are printed by the Bear program? (Choose all that apply.)
 }


// class Bear {
// enum FOOD {
// BERRIES, INSECTS {
// public boolean isHealthy() { return true; }},
// FISH, ROOTS, COOKIES, HONEY;
// public abstract boolean isHealthy(); // it must be implemented in each enum value declaration
// }
// public static void main(String[] args) {
// System.out.print(FOOD.INSECTS);
// System.out.print(FOOD.INSECTS.ordinal());
// System.out.print(FOOD.INSECTS.isHealthy());
// System.out.print(FOOD.COOKIES.isHealthy());
// }
// }

// A. insects
//B. INSECTS
//C. 0
//D. 1
//E. false
//F. true
//G. The code does not compile.  // Correct

class Q16 {
    // Which of the following are valid functional interfaces? (Choose all that apply.)
    /*
    Функциональный интерфейс - только один SAM
     */
}
// public interface Transport {     // FI
// public int go();             // abstract
// public boolean equals(Object o); // abstract, но не считается
// }
// public abstract class Car {
// public abstract Object swim(double speed, int duration);
// }
// public interface Locomotive extends Train {
// public int getSpeed();  // в Train есть еще SAM, поэтому не подходит
// }
// public interface Train extends Transport {}  // FI
// abstract interface Spaceship extends Transport {
// default int blastOff(); // default method must provide a body.
// }
// public interface Boat {
// int hashCode();          // это из Object, не считается
// int hashCode(String input);  // это SAM, не явно public abstract
// }

// A. Boat          // Correct
// B. Car
// C. Locomotive
// D. Tranport       // Correct
// E. Train          // Correct
// F. Spaceship
// G. None of these is a valid functional interface.

class Q17 {
    // Which lambda expression when entered into the blank line in the following code causes the program
    // to print hahaha? (Choose all that apply.)
}

// import java.util.function.Predicate;
// public class Hyena {
// private int age = 1;
// public static void main(String[] args) {
// var p = new Hyena();
// double height = 10;
// int age = 1;
// testLaugh(p,___________________);
// age = 2;
// }
// static void testLaugh(Hyena panda, Predicate<Hyena> joke) {
// var r = joke.test(panda) ? "hahaha" : "silence";
// System.out.print(r);
// }
// }

// A. var -> p.age <= 10    // Correct. var можно использовать в lambda.  p -  effectively final in this method.
// B. shenzi -> age==1      //  age не  effectively final, поэтмому к ней нельзя обращаться в теле лямбды
// C. p -> true             // p ранее использовалось в методе
// D. age==1                // нужна стрелка
// E. shenzi -> age==2      //  age не  effectively final, поэтмому к ней нельзя обращаться в теле лямбды
// F. h -> h.age < 5        // Correct. h -> h
// G. None of the above, as the code does not compile.

class Q18 {
    // Which of the following can be inserted in the rest() method? (Choose all that apply.)
}

class Lion {
 class Cub {}
 static class Den {}
 static void rest() {   // статичный класс может обращаться только к статичным переменным/методам
// _______________;





 } }

// A. Cub a = Lion.new Cub()                // нельзя, так можно Cub a = new Lion().new Cub();
// B. Lion.Cub b = new Lion().Cub()         // нельзя, так можно Cub a = new Lion().new Cub();
// C. Lion.Cub c = new Lion().new Cub()     // Correct
// D. var d = new Den()                     //  Correct  correct way to create an instance of the static nested Den class
// E. var e = Lion.new Cub()                // нельзя, так можно var e = new Lion().new Cub();
// F. Lion.Den f = Lion.new Den()           // нельзя, так можно var e = new Lion().new Den();
// G. Lion.Den g = new Lion.Den()           // Correct, т.к. Den - static    correct way to create an instance of the static nested Den class
// H. var h = new Cub()                     // нельзя, если бы rest() был не статик, то можно









