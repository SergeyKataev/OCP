import java.util.ArrayList;
import java.util.List;

public class Fundamentals {
}

// Applying the final Modifier
/*
final modifier can be applied to
- variables -the value cannot be changed after it is assigned.
- methods it cannot be overridden
- classes it cannot be extended
 */

// Declaring final Local Variables
class FinalEx1 {
    private void printZooInfo(boolean isWeekend) {
        final int giraffe = 5;
        final long lemur;
        if (isWeekend) lemur = 5;
        else lemur = 10;                //  надо определить до того, как будем распечатывать
        System.out.println(giraffe + " " + lemur);
    }

    private void printZooInfo2(boolean isWeekend) {
        final int giraffe = 5;
        final long lemur;
        if (isWeekend) lemur = 5;
//        giraffe = 3; // DOES NOT COMPILE  - финальная переменная, повторная инициализация
//        System.out.println(giraffe+" "+lemur); // DOES NOT COMPILE    - не инициализирована переменная.
//          Можем не попасть в if
//    }
    }
}

// Adding final to Instance and static Variables
// Instance and static class variables can also be marked final.

/* If an instance variable is marked final, then it must be assigned a value when it is
    declared or when the object is instantiated.*/
class PolarBear {
    final int age = 10;
    final int fishEaten;    // инициируется в блоке инициализации
    final String name;      // инициализируется в конструкторе

    {
        fishEaten = 10;
    }

    public PolarBear() {
        name = "Robert";
    }

    public PolarBear(int height) {
        this();
    }
}

// для статичных полей правила аналогичные, переменная должна быть инициализирована
class Panda {
    final static String name = "Ronda";
    static final int bamboo;

    //    static final double height; // DOES NOT COMPILE - не инициализирован
    static {
        bamboo = 5;
    }
}

// финальные методы не могут быть overriding в наследнике
abstract class Animal {
    abstract void chew();
}

class Hippo extends Animal {
    final void chew() {
    }
}

class PygmyHippo extends Hippo {
//    void chew() {} // DOES NOT COMPILE
}

// финальный класс нельзя наследовать
final class Reptile {
}
//class Snake extends Reptile {} // DOES NOT COMPILE

//public abstract final class Eagle {} // DOES NOT COMPILE - final и abstract нельзя
//public final interface Hawk {} // DOES NOT COMPILE    - interface всегда публичный и абстрактный


// Working with Enums
// Пример энама:
enum Season {
    WINTER, SPRING, SUMMER, FALL
}

class EnumEx1 {
    public static void main(String[] args) {
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER); // SUMMER
        System.out.println(s == Season.SUMMER); // true

        // перебор энама через .values()
        for (Season season : Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }
        // WINTER 0
        // SPRING 1
        // SUMMER 2
        // FALL 3

        // Получение значения
        Season s1 = Season.valueOf("SUMMER"); // SUMMER
//        Season t = Season.valueOf("summer"); // Throws an exception at runtime - IllegalArgumentException

        // нельзя экстендить энамы
//        public enum ExtendedSeason extends Season { } // DOES NOT COMPILE
    }
}

// you can use equals() or == to compare enums, т.к. значение энама инициализируются только 1 раз


// using enum
class EnumEx2 {
    // Enums can be used in switch statements
    public static void main(String[] args) {
        Season summer = Season.SUMMER;
        switch (summer) {  // Time for the pool!
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
//            case Season.FALL: // DOES NOT COMPILE - так нельзя писать
//                System.out.println("Rake some leaves!");
//                break;
//            case 0: // DOES NOT COMPILE - нет в энаме
//                System.out.println("Get out the sled!");
//                break;
            default:
                System.out.println("Is it summer yet?");
        }

        //
        Season2.WINTER.printExpectedVisitors();  // "Low"


    }
}

// Adding Constructors, Fields, and Methods
enum Season2 {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    // если кроме значений есть что то еще, то нужна ;
    private final String expectedVisitors; // т.к. энам шарится на всю jvm, то хорошей практикой будет
        // делать переменные энама приватными

    private Season2(String expectedVisitors) {       // All enum constructors are implicitly private.
        // An enum constructor will not compile if it contains a public or protected modifier.
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}

        /*
        How do we call an enum method?
        Season.SUMMER.printExpectedVisitors();
         */

// конструктор энама дергается только 1 раз
enum OnlyOne {
    ONCE(true);

    private OnlyOne(boolean b) {
        System.out.print("constructing,");
    }
}

class PrintTheOne {
    public static void main(String[] args) {
        System.out.print("begin,");
        OnlyOne firstCall = OnlyOne.ONCE; // prints constructing,
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
        System.out.print("end");
    }
}


// использование энама
// Методы и все остальное должны быть в конце. если  все начинается не с самих значений - будет ошибка компиляции.
enum Season3 {
    WINTER {
        public String getHours() {
            return "10am-3pm";
        }
    },
    SPRING {
        public String getHours() {
            return "9am-5pm";
        }
    },
    SUMMER {
        public String getHours() {
            return "9am-7pm";
        }
    },
    FALL {
        public String getHours() {
            return "9am-5pm";
        }
    };

    public abstract String getHours();  // The enum itself has an abstract method.
        // Каждое значение энама должно имплеметировать этот метод

    // не абстрактные методы не внутри самого энама нельзя
    // внутри энама можно писать не абстрактные методы
}


// Если не хотим для каждого значения энама рисовать свою реализацию,
// то можем начнать дефолтную реализацию и описать только специфические энамы
enum Season4 {
    WINTER {
        public String getHours() {
            return "10am-3pm";
        }
    },
    SUMMER {
        public String getHours() {
            return "9am-7pm";
        }
    },
    SPRING, FALL;

    public String getHours() {
        return "9am-5pm";
    }
}

// Creating Nested Classes
// A nested class can come in one of four flavors.

// Inner class: A non- static type defined at the member level of a class
// Static nested class: A static type defined at the member level of a class
// Local class: A class defined within a method body
// Anonymous class: A special case of a local class that does not have a name

// Declaring an Inner Class

// 1.Can be declared public, protected, package-private (default), or private
// 2.Can be marked abstract or final
// 3.Can access members of the outer class including private members
// 4.Cannot declare static fields or methods, except for static final fields
// 5.Can extend any class and implement interfaces


class Outer {
    private String greeting = "Hi";

    private void greetingMethod() {
        System.out.println("Hello");
    }

    static void hello() {
        System.out.println("static void hello()");
    }

    static int a = 0;

    protected class Inner {
        // Можно любые access modifier
        // Можно abstract или final
        // Can extend any class or implement any number of interfaces

        // декларирование:
//        static int a = 0; // 4.Cannot declare static fields or methods, except for static final fields
//       static void innerStaticMethod() { // нельзя декларировать static методы
//            go3();
//        }
        final static int a = 0; // Можно  final static  переменную

        // Доступ
        // к приватным нестатичным переменным! Без ссылки на класс родитель
        public void go() {
            for (int i = 0; i < 3; i++)
                // Can access instance members of enclosing class without a reference
                System.out.print(greeting + " ");   // доступ к Instance variables без ссылки
//            System.out.println(Outer.greeting);   // к нестатичной переменной нельзя обращаться через ссылку
            System.out.println(a);                  // к статичной переменной можно без ссылки
            System.out.println(Outer.a);            // к статичной переменной можно через ссылку
        }


        // к приватным нестатичным методам
        public void go2() {
            greetingMethod();                   // доступ к Instance methods без ссылки
        }

        // Можно вызывать статичные методы и переменные
        public void callStaticMethod() {
            hello();
        }

        public void callStaticVal() {
            System.out.println(a);
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        // 3.Can access members of the outer class including private members
        inner.go();         // Hi Hi Hi
        inner.go2();        // Hello
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();
    }
}

// OK, well maybe not just at first. This syntax isn't used often enough to get used to it:

// public static void main(String[] args) {
// Outer outer = new Outer();
// Inner inner = outer.new Inner(); // create the inner class
// inner.go();
// }

// Here is how to nest multiple classes and access a variable with the same name in each:

class A {
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println(x); // 30
                System.out.println(this.x); // 30
                System.out.println(B.this.x); // 20
                System.out.println(A.this.x); // 10
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }
}


// Inner Classes Require an Instance
class Fox {
    private class Den {
    }

    // если метод не статичый
    public void goHome() {
        new Den();  // goHome() is an instance method, and therefore the call is associated with the this instance.
    }

// если метод статичный
    public static void visitFriend() {
//        new Den(); // DOES NOT COMPILE - it is called inside a static method.
        new Fox().new Den(); // так можно, через создание объекта
    }
}

class Squirrel {
    public void visitFox() {
        // Вызываем из другого класса
//        new Den(); // DOES NOT COMPILE - нельзя вызывать внутренний класс без создания внешнего
//        new Fox().new Den(); - так тоже нельзя, потому что конструктор приватный, если будет public, то ок
        new Fox();
    }
}


// Creating a static Nested Class - it can't access instance variables or methods in the outer class directly

// * может использовать любой access modifier
// * внешний класс может вызывать внутренние переменные и методы.
// * внутренний класс не может дергать внешние нестатичные методы/переменные

class Enclosing {
    private String greeting = "Hi";

    private void greetingMethod() {
        System.out.println("Hello");
    }

    static void hello() {
        System.out.println("static void hello()");
    }

    static int a = 0;


    static class Nested {
        // Можно любые access modifier
        // Можно abstract или final

        // декларирование:
        // можно нестатичный и статичные методы
        static int a = 0; // можно статичные переменные
        static void innerStaticMethod() { // можно статичные методы
            hello();
        }
        final static int b = 0; // Можно  final static  переменную

        int c = 0;                                                      //можно обратиться через создание объекта
        String innetNonStaticMethod() {return "innetNonStaticMethod";} // можно обратиться через создание объекта

        // Доступ
        // к нестатичным переменным верхнего класса отсутствует!!!
        private void callMethods() {
            System.out.println(a);
            hello();
//            System.out.println(greetingMethod()); // нельзя доступ к нестатичным методы
//            System.out.println(greeting);         // нельзя доступ к нестатичным поля
            System.out.println(c);                       // можно к нестатичным, но внутренним(определенным во внутреннем статичным методе) переменным
            System.out.println(innetNonStaticMethod()); // можно к нестатичным, но внутренним(определенным во внутреннем статичным методе) методам
        }
    }


    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.callMethods();   // доступ к приватной переменной/методу внутреннего статичного класса
        nested.innerStaticMethod(); // доступ к статичному методы
        System.out.println(nested.a); // доступ к статичной переменной

        System.out.println(nested.c); // внутри статичного класса создал нестатичную переменную, к ней не обратиться
//        System.out.println(Nested.c); // по ссылке не обратиться, нужен экземпляр
        System.out.println(nested.innetNonStaticMethod()); //внутри статичного класса создал нестатичную переменную, к ней не обратиться
//        System.out.println(Nested.innetNonStaticMethod()); // по ссылке не обратиться, нужен экземпляр

    }
}


//    Writing a Local Class -  defined within a method.(can be declared inside constructors and initializers too)

// Local classes have the following properties:
// 1. They do not have an access modifier.
// 2. They cannot be declared static and cannot declare static fields or methods, except for final static fields.
// 3. They have access to all fields and methods of the enclosing class (when defined in an instance method).
// 4. They can access local variables (переменные метода) if the variables are final or effectively final.

/*  effectively final refers to a local variable whose value does not change after it is set. */

class PrintNumbers {
    private int length = 5;

    private void methodClass() {
    }

    public void calculate() {
        final int width = 20;
        class MyLocalClass {
            // 1. They do not have an access modifier.
            // 2. They cannot be declared static
            // может быть abstract или final
            // может экстендить и имплементить другие классы/интерфейсы

            // 3. They have access to all fields and methods of the enclosing class
            public void multiply() {
                System.out.print(length * width);   // доступ к приватной переменной класса без ссылки на класс
//                System.out.print(MyLocalClass.length * width);   // через ссылку нельзя
                methodClass();                      // доступ к приватному методу класса    без ссылки на класс
            }

            // 2. cannot declare static fields or methods
//            static int a = 1;
//            static void b() {};
            static final int c = 1; // static final можно
        }
        MyLocalClass local = new MyLocalClass();
        local.multiply();
    }

    public static void main(String[] args) {
        PrintNumbers outer = new PrintNumbers();
        outer.calculate();  // 100
    }

    // пример, когда не скомпилируется
    // доступ к локальным переменным (переменные метода)
    public void processData() {
        final int length = 5;           //  effectively final
        int width = 10;
        int height = 2;                 //  effectively final
        class VolumeCalculator {
            //            public int multiply() {
//                return length * width * height; // DOES NOT COMPILE - width не effectively final
//            }
            void tryIt() {
                System.out.println(length + height); // тут ок
            }
        }
        width = 2;
    }
}


// Defining an Anonymous Class - form of a local class that does not have a name.
class ZooGiftShop {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    int instanceParam = 1;

    void instanceMethod() {
    }

    public int admission(int basePrice) {
        // нет модификатора доступа
        // нельзя указать final или abstract
        SaleTodayOnly sale = new SaleTodayOnly() {
            final static int a = 0;
//            static int b = 0; - нельзя
//            static void b() {} - нельзя

            int dollarsOff() {
                // есть доступ к instance variable and method
                System.out.println(instanceParam);
                instanceMethod();

                int a = 1;
                return 3;
            }

        }; // Don't forget the semicolon!
        return basePrice - sale.dollarsOff();
    }
}

// анонимный класс через интерфейс
class ZooGiftShop1 {
    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            public int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }
}

// You can even define anonymous classes outside a method body.
class Gorilla {
    interface Climb {
    }

    Climb climbing = new Climb() {
    }; // the {} after the interface name indicates that this is an anonymous inner class implementing the interface
}


// rules
/*
Permitted Modifiers      |     Inner class   |  static nested class  |   Local class   |   Anonymous class   |
Access modifiers                All                   All                   None                None
abstract                        Yes                   Yes                   Yes                 No
Final                           Yes                   Yes                   Yes                 No
Instance methods                Yes                   Yes                   Yes                 Yes
Instance variables              Yes                   Yes                   Yes                 Yes
static methods                  No                    Yes                   No                  No
static variables                Yes (if final)        Yes                   Yes (if final)      Yes (if final)

 */


/*  Nested class access rules

                                            Inner class         static nested class         Local class                                     Anonymous class
Can extend any class or implement              Yes                  Yes                         Yes                         No—must have exactly one superclass or one interface
any number of interfaces

Can access instance members of                  Yes                 No                          Yes                                              Yes
enclosing class without a reference                                                    (if declared in an instance method)          (if declared in an instance method)


Can access local variables of                   N/A                 N/A                         Yes                                             Yes
enclosing method                                                                       (if final or effectively final)               (if final or effectively final)

 */



/*  Understanding Interface Members

                            Membership type             Required modifiers          Implicit modifiers          Has value or body?

Constant variable               Class                           -                   public static final         Yes

Abstract method                 Instance                        -                   public abstract             No

Default method                  Instance                    default                 public                      Yes

Static method                   Class                       static                  public                      Yes

Private method                  Instance                    private                 -                           Yes

Private static method           Class                       private static          -                           Yes

 */


// Relying on a default Interface Method
// The following is an example of a default method defined in an interface:

interface IsWarmBlooded {
    boolean hasScales();

    default double getTemperature() {
        return 10.0;
    }
}

/*
Default Interface Method Definition Rules
1. A default method may be declared only within an interface.
2. A default method must be marked with the default keyword and include a method body.
3. A default method is assumed to be public.
4. A default method cannot be marked abstract, final, or static.
5. A default method may be overridden by a class that implements the interface.
6. If a class inherits two or more default methods with the same method signature, then the class must override the method.
 */

/*
 interface Carnivore {
         public default void eatMeat(); // DOES NOT COMPILE
         public int getRequiredFoodAmount() { // DOES NOT COMPILE
         return 13;
    }
}
 */

// Inheriting Duplicate default Methods
interface Walk {
    public default int getSpeed() {
        return 5;
    }
}

interface Run {
    public default int getSpeed() {
        return 10;
    }
}
//public class Cat implements Walk, Run { // DOES NOT COMPILE - 2 интерфейса с одинаковой сигнатурой
//    public static void main(String[] args) {
//        System.out.println(new Cat().getSpeed());
//    }
//}

// надо делать так
class Cat implements Walk, Run {
    public int getSpeed() {
        return 1;
    }  // оверрайдим

    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }
}


// Calling a Hidden default Method - дефолтный метод вызывается: Run.super.getSpeed();

class Cat2 implements Walk, Run {
    public int getSpeed() {
        return 1;
    }

    public int getWalkSpeed() {
        return Run.super.getSpeed(); // Вызов дефолтного, не перезаписанного метода
    }

    public static void main(String[] args) {
        System.out.println(new Cat2().getWalkSpeed());
    }
}

// Using static Interface Methods
/*
Static Interface Method Definition Rules
    1. A static method must be marked with the static keyword and include a method body.
    2. A static method without an access modifier is assumed to be public.
    3. A static method cannot be marked abstract or final.
    4. A static method is not inherited and cannot be accessed in a class implementing the interface without a reference to the interface name.
 */

interface Hop {
    static int getJumpHeight() {  // implicitly public
        return 8;
    }
}

class Bunny implements Hop {
    public void printDetails() {
//        System.out.println(getJumpHeight()); // DOES NOT COMPILE - нужна ссылка на интерфейс Hop.getJumpHeight()
        //Java “solved” the multiple inheritance problem of static interface methods by not allowing them to be inherited.

        // For example, a class that implements two interfaces containing static methods with the same signature will still compile.
    }
}

// Introducing private Interface Methods
/*
Private Interface Method Definition Rules
    1. A private interface method must be marked with the private modifier and include a method body.
    2. A private interface method may be called only by default and private (non- static)
            methods within the interface definition.
    3. Сannot be declared abstract since they are not inherited.
 */

interface Schedule {
    default void wakeUp() {
        checkTime(7);
    }

    default void haveBreakfast() {
        checkTime(9);
    }

    default void haveLunch() {
        checkTime(12);
    }

    default void workOut() {
        checkTime(18);
    }

    private void checkTime(int hour) {
        if (hour > 17) {
            System.out.println("You're late!");
        } else {
            System.out.println("You have " + (17 - hour) + " hours left "
                    + "to make the appointment");
        }
    }
}



// Introducing private static Interface Methods
/*
Private Static Interface Method Definition Rules
    1. A private static method must be marked with the private and static modifiers and include a method body.
    2. A private static interface method may be called only by other methods within the interface definition.
 */
interface Swim {
    private static void breathe(String type) {
        System.out.println("Inhale");
        System.out.println("Performing stroke: " + type);
        System.out.println("Exhale");
        butterfly(); // можно вызвать статичный метод
//        backstroke(); // не статичный метод из статичного вызывать нельзя
    }

    static void butterfly() {
        breathe("butterfly");
    } // может быть вызван в static. т.к. сам статик

    public static void freestyle() {
        breathe("freestyle");
    }  // может быть вызван в static. т.к. сам статик

    default void backstroke() {
        breathe("backstroke");
    }        // because instance methods can access static methods within a class,
    // they can also be accessed by default and private methods.

    private void breaststroke() {
        breathe("breaststroke");
    }    // because instance methods can access static methods within a class,
    // they can also be accessed by default and private methods.
    // По аналогии, что в классе можно из метода вызывать другой метод

}


// Accessible from default and private methods within the interface definition?
interface One {
    final int a = 0;


    // в приватном методе внутри интерфейса доступны все типы методов
    private void privateTestMethod() {
        System.out.println(a); // доступны константы
        absMethod();    // доступен абстрактный метод
        defaultMethod();// доступен дефолтный метод
        privateMethod();// доступен приватный метод
        staticMethod();// доступен статичный метод - к статичным можно обращаться через One.
        staticPrivateMethod();// доступен статичный приватный метод - к статичным можно обращаться через One.
    }

    // в статичном методе внутри интерфейса доступны только статичные методы
    static void staticTestMethod() {
        System.out.println(a); // доступны константы
//        absMethod();    // не статичные методы недоступны
//        defaultMethod();// не статичные методы недоступны
//        privateMethod();// не статичные методы недоступны
        staticMethod();// доступен статичный метод - к статичным можно обращаться через One.
        staticPrivateMethod();// доступен статичный приватный метод - к статичным можно обращаться через One.
    }

    public void publicMethod();

    abstract void absMethod();

    default void defaultMethod() {
    }

    private void privateMethod() {
    }                  // не будут доступны при наследовании

    static void staticMethod() {
    }                    // не будут доступны при наследовании

    private static void staticPrivateMethod() {
    }     // не будут доступны при наследовании
}


// В классе, который имплементит интерфейс доступны только абстрактные и дофолтные классы + константа + публичные
// статичные и приватные - недоступны при наследовании
class TestInterface implements One {
    @Override
    public void publicMethod() {
        System.out.println(a);  // константа доступна
    }

    @Override
    public void absMethod() {
    }


    @Override
    public void defaultMethod() {
    }
}


// В любом классе, который не имплементит интерфейс - доступна только констанда и не приватный - статичный метод
class TestInterface2 {
    public static void main(String[] args) {
        System.out.println(One.a);          // доступна константа
        One.staticMethod();                 // доступен не приватный - статичный метод
    }
}

// Introducing Functional Programming

@FunctionalInterface //  it contains exactly one abstract method
interface Sprint {
    public void sprint(int speed);
}

class Tiger implements Sprint {
    public void sprint(int speed) {
        System.out.println("Animal is sprinting fast! " + speed);
    }
}


//  which of the following are functional interfaces?
interface Dash extends Sprint {
}  // функциональный, т.к. наследуется только 1 абстрактный метод sprint(int speed)

interface Skip extends Sprint {     //не функциональный, т.к. 2 абстрактным метода skip() и sprint(int speed)
    void skip(); // он неявно абстрактный
}

interface Sleep {       // не функциональный, нет ни одного абстрактного метода
    private void snore() {
    } // у приватного должно быть тело, он не абстрактный

    default int getZzz() {
        return 1;
    }  // это дефолтный и не абстрактный
}

interface Climb {  // функциональный, т.к. содержит только один абстрактный метод each()
    void reach();   // абстрактный, не явно

    default void fall() {
    }  // не абстрактный, дефолтный

    static int getBackUp() {
        return 100;
    } // статичный, не абстрактный

    private static boolean checkHeight() {
        return true;
    } // не абстрактынй
}


// Declaring a Functional Interface with Object Methods
// If a functional interface includes an abstract method with the same signature as a public
// method found in Object, then those methods do not count toward the single abstract method test.
/*
You also cannot declare an interface method that is incompatible with Object. For example, declaring an abstract method int
toString() in an interface would not compile since Object's version of the method returns a String.
 */
// example.
interface Soar {  // не функциональный интерфейс, т.к. метод из Object
    abstract String toString();
}

interface Dive {   // это функциональный интерфейс
    String toString();      // не SAM

    public boolean equals(Object o);    // не SAM

    public abstract int hashCode();     // не SAM

    public void dive();     // это SAM
}

// Implementing Functional Interfaces with Lambdas
interface Predicate<T> {
    boolean test(T t);
}
/*  any functional interface can be implemented as a lambda expression. */

//  goal is to print out all the animals in a list according to some criteria.
class Animal2 {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal2(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }

    public boolean canHop() {
        return canHop;
    }

    public boolean canSwim() {
        return canSwim;
    }

    public String toString() {
        return species;
    }
}


class TraditionalSearch {
    public static void main(String[] args) {
        // list of animals
        var animals = new ArrayList<Animal2>();
        animals.add(new Animal2("fish", false, true));
        animals.add(new Animal2("kangaroo", true, true));
        animals.add(new Animal2("rabbit", true, false));
        animals.add(new Animal2("turtle", false, true));

        // Pass lambda that does check
        print(animals, a -> a.canHop());
        // print(animals, a -> a.canSwim()); - простая замена условия печати
    }

    private static void print(List<Animal2> animals,
                              Predicate<Animal2> checker) {
        for (Animal2 animal : animals) {
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
    }
}

// Writing Lambda Expressions
/*
short form
a->a.canHop()

long form
(String g) -> { return a.canHop(); }

 s -> {} is a valid lambda


Let's take a look at some examples.

() -> new Duck()
d -> {return d.quack();}
(Duck d) -> d.quack()
(Animal a, Duck d) -> d.quack()


a, b -> a.startsWith("test") // DOES NOT COMPILE - должны быть скобки вначале - parentheses are optional
                                                            only when there is one parameter and it doesn't have a type declared
Duck d -> d.canQuack(); // DOES NOT COMPILE - должны быть скобки вначале
a -> { a.startsWith("test"); } // DOES NOT COMPILE - отсутствует return
a -> { return a.startsWith("test") } // DOES NOT COMPILE - отсутствует  ;
(Swan s, t) -> s.compareTo(t) != 0 // DOES NOT COMPILE - нельзя так объявлять переменные, нужно указать тип для t
 */

// Working with Lambda Variables
/*
Variables can appear in three places with respect to lambdas:
* the parameter list
* local variables declared
* inside the lambda body, and variables referenced from the lambda body
 */

// Parameter List
/*  Все 3 выражения ок
Predicate<String> p = x -> true;
Predicate<String> p = (var x) -> true;
Predicate<String> p = (String x) -> true;
 */


/*  Restrictions on Using var in the Parameter List
(var num) -> 1              // ок
var w -> 99                 // переменную нужно в скобки
(var a, var b) -> "Hello"   // ок
(var a, Integer b) -> true  // если определили var, то конкретный тип уже нельзя указывать
(String x, var y, Integer z) -> true // если определили var, то конкретный тип уже нельзя указывать
(var b, var k, var m) -> 3.14159 // ок
(var x, y) -> "goodbye"             // нужно указать тип для y
 */


// Local Variables Inside the Lambda Body
/*
(a, b) -> { int c = 0; return 5;}
(a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE - a передекларируется, нельзя

// сколько ошибок?
public void variables(int a) {
    int b = 1;
    Predicate<Integer> p1 = a -> {  // a - уже определена как параметр метода
        int b = 0;     // переропределяет переменную b
        int c = 0;
        return b == c;}   // предикат надо закрыть
}

 */


// Variables Referenced from the Lambda Body
// Lambda bodies are allowed to use static variables, instance variables, and local variables if they are final or effectively final.
class Crow {
private String color;
public void caw(String name) {
        String volume = "loudly";
        Predicate<String> p = s -> (name+volume+color).length()==10;  // Lambdas follow the same rules for access as local and anonymous classes!
        }
}

class Crow2 {
private String color;
public void caw(String name) {
        String volume = "loudly";
        color = "allowed";
        name = "not allowed";   // if the local variable is not final or effectively final, if the local variable is not final or effectively final,
        volume = "not allowed"; //if the local variable is not final or effectively final, will not compile
//        Predicate<String> p =
//                s -> (name+volume+color).length()==9; // DOES NOT COMPILE
        }
 }












