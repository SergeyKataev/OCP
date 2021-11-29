package Chapter9;

import java.util.Collections;
import java.util.List;

public class AdvancedClassDesign {
}

class CreatingAbstractClasses {
    // public class Egret { // DOES NOT COMPILE, абстрактрый метод в неадстрактном классе
    // public abstract void peck();
    // }

    /*
   Как и final modifier, abstract modifier может быть помещен до или после access modifier in class and method declarations,
     abstract public class Tiger {
        abstract public int claw();
     }

     // в класе abstract нельзя после слова class
     // к методе abstract нельзя после return type
     public class abstract Jackal { // DOES NOT COMPILE
        public int abstract howl(); // DOES NOT COMPILE
     }
     */
}



// Конструкторы в абстрактных классах
abstract class Bear2 {
    abstract CharSequence chew();
    public Bear2() {
        System.out.println(chew());
    }
}
class Panda extends Bear2 {   // тут будет дефолтный конструктор с вызовом super(). Когда вызывается super() - вызывается chew() из Panda
    String chew() { return "yummy!"; }
    public static void main(String[] args) {
        new Panda();
    }
}

// Invalid Abstract Method Declarations
abstract class Turtle {
//    public abstract long eat() // DOES NOT COMPILE -  отсутствует ;
//    public abstract void swim() {}; // DOES NOT COMPILE   - присутствует {}
//    public abstract int getAge() { // DOES NOT COMPILE    - присутствует реализация
//        return 10;
//    }
//    public void sleep; // DOES NOT COMPILE            - отсутствует ()
//    public void goInShell(); // DOES NOT COMPILE      - отсутствует {}
}



// abstract final - нельзя, компилятор ругается

//public abstract final class Tortoise { // DOES NOT COMPILE
//    public abstract final void walk(); // DOES NOT COMPILE
//}

// abstract private - нельзя, компилятор ругается
//abstract class Whale {
//    private abstract void sing(); // DOES NOT COMPILE
//}

abstract class Whale {
    protected abstract void sing();
}
//class HumpbackWhale extends Whale {
//    private void sing() { // DOES NOT COMPILE   - сужение типа при overriding
//        System.out.println("Humpback whale is singing");
//    }
//}

// abstract static - нельзя, компилятор ругается

//abstract class Hippopotamus {
//    abstract static void swim(); // DOES NOT COMPILE
//}



// Все абстрактные методы надо реализовывать в ПЕРВОМ наследнике

// public abstract class Animal {
//    public abstract String getName();
//}

//public class Walrus extends Animal { // DOES NOT COMPILE
//}



// еще пример

abstract class Mammal {
    abstract void showHorn();
    abstract void eatLeaf();
}
abstract class Rhino extends Mammal {
    void showHorn() {}              // этот метод уже реализован
}
class BlackRhino extends Rhino {   // первый неабстрактный класс
    void eatLeaf() {}               // реализовывает оставшийся метод
}

// еще пример

abstract class Animal {
    abstract String getName();
}
abstract class BigCat extends Animal {
    protected abstract void roar();
}
class Lion extends BigCat {
    public String getName() {
        return "Lion";
    }
    public void roar() {
        System.out.println("The Lion lets out a loud ROAR!");
    }
}

/*
Abstract Class Definition Rules
    1. Abstract classes cannot be instantiated.
    2. All top-level types, including abstract classes, cannot be marked protected or private.
    3. Abstract classes cannot be marked final.
    4. Abstract classes may include zero or more abstract and nonabstract methods.
    5. An abstract class that extends another abstract class inherits all of its abstract methods.
    6. The first concrete class that extends an abstract class must provide an implementation for all of the inherited abstract methods.
    7. Abstract class constructors follow the same rules for initialization as regular constructors, except they can be called only as part of
        the initialization of a subclass.


Abstract Method Definition Rules
    1. Abstract methods can be defined only in abstract classes or interfaces.
    2. Abstract methods cannot be declared private or final.
    3. Abstract methods must not provide a method body/implementation in the abstract class in which they are declared.
    4. Implementing an abstract method in a subclass follows the same rules for overriding a method, including covariant return types,
    exception declarations, etc.

 */




// Implementing Interfaces

// хороший пример
abstract interface WalksOnTwoLegs {}

// плохой пример
//public class Biped {
//    public static void main(String[] args) {
////        var e = new WalksOnTwoLegs(); // DOES NOT COMPILE - нельзя создавать объект интерфейса
//    }
//}
//public final interface WalksOnEightLegs {} // DOES NOT COMPILE    - интерфейс не может быть final


// Like a class, an interface can extend another interface using the extends keyword.
interface Nocturnal {}
interface HasBigEyes extends Nocturnal {}

/*
Привила интерфейсов

Interfaces are assumed to be abstract.
Interface variables are assumed to be public, static, and final.
Interface methods without a body are assumed to be abstract and public.

Эти 2 интерфейса одинаковы

public interface Soar {
    int MAX_HEIGHT = 10;
    final static boolean UNDERWATER = true;
    void fly(int speed);
    abstract void takeoff();
    public abstract double dive();
}

public abstract interface Soar {
    public static final int MAX_HEIGHT = 10;
    public final static boolean UNDERWATER = true;
    public abstract void fly(int speed);
    public abstract void takeoff();
    public abstract double dive();
}


// Пример ошибок компиляции

public interface Dance {
    private int count = 4; // DOES NOT COMPILE
    protected void step(); // DOES NOT COMPILE
}

private final interface Crawl {              // нельзя ни private, ни final
    String distance;                        // не инициализирована, в интерфейсах всегда должна быть инициализация
    private int MAXIMUM_DEPTH = 100;        // должны быть public
    protected abstract boolean UNDERWATER = false;  //  должны быть public
    private void dig(int depth);                    //  должны быть public
    protected abstract double depthh();              должны быть public
    public final void surface();                    // нельзя final
}

// У интерфейсов есть implicit modifiers, т.е. дописываются требуемые public, static, final и прочее
 */

abstract class Husky {
    abstract void play();
}
interface Poodle {
    void play();        // этот метод public
}

class Webby extends Husky {
    void play() {}
}
class Georgette implements Poodle {
    public void play() { }
//    void play() {}  - не скомпилируется, т.к. доступ стал уже. Метод в интерфейсе public, а тут дефолтный. Работают правила overriding
}


interface CanRun {}
//public class Cheetah extends CanRun {} // DOES NOT COMPILE  - интерфейс нельзя экстендить
class Hyena {}
//public interface HasFur extends Hyena {} // DOES NOT COMPILE  - интерфейс не можетт экстендить класс



// Если у двух интерфейсов повторяющийся метод и эти два интерфейса имплементит класс
interface Herbivore {
    public void eatPlants();
}
interface Omnivore {
    public void eatPlants();
    public void eatMeat();
}


// То достаточно переопределить только один раз метод
class Bear implements Herbivore, Omnivore {
    public void eatMeat() {
        System.out.println("Eating meat");
    }
    public void eatPlants() {
        System.out.println("Eating plants");
    }
}


// если бы методы были с разной сигнатурой (разные параметры метода), но нужно было override оба метода
/*
public interface Herbivore {
    public int eatPlants(int quantity);
}
public interface Omnivore {
    public void eatPlants();
}
public class Bear implements Herbivore, Omnivore {
    public int eatPlants(int quantity) {
        System.out.println("Eating plants: "+quantity);
        return quantity;
    }
    public void eatPlants() {
        System.out.println("Eating plants");
    }
}

 */



// What if the duplicate methods have the same signature but different return types?
interface Dances {
    String swingArms();
}
interface EatsFish {
    CharSequence swingArms();
}

class Penguin implements Dances, EatsFish {  // скомпилируется, т.к. оба метода в этих интерфейсах имеют covariant return type
    public String swingArms() {
        return "swing!";
    }
}

/*
тут типы не covariant
interface Dances {
    int countMoves();
}
interface EatsFish {
    boolean countMoves();
}
public class Penguin implements Dances, EatsFish { // DOES NOT  COMPILE ...
}



interface LongEars {
    int softSkin();
}
interface LongNose {
    void softSkin();
}
interface Donkey extends LongEars, LongNose {} // DOES NOT COMPILE  - внутри 2 метода, с не covariant возвращаемыми типами

abstract class Aardvark implements LongEars, LongNose {} // DOES NOT COMPILE - внутри 2 метода, с не covariant возвращаемыми типами

 */


// Abstract Reference Types

class Zoo {
    public void sortAndPrintZooAnimals(List<String> animals) {
        Collections.sort(animals);
        for (String a : animals) {
            System.out.println(a);
        }
        String lion = "Bert";
//        Long tiger = (Long)lion; - так нельзя кастовать.does not allow casts to unrelated types.
    }
}

interface Canine {}

class Dog implements Canine {}
class Wolf implements Canine {}

class BadCasts {
    public static void main(String[] args) {
        Canine canine = new Wolf();  // т.к. тут интерфейс, Java не понимает какой ТОЧНО класс в переменную помещен.
        // А не знает, котому что даже если тип Canine не имплементирует интефейс, какой то из его подкласса может имплементировать
        // Поэтому ниже Java позволяет такой каст. т.к. Dog имплементит Canine
        Canine badDog = (Dog)canine;  // нельзя кастовать, т.к. Dog и Wolf не соответствуют друг другу

//        Object badDog = (String)canine; // DOES NOT COMPILE, т.к. String не имплементит Canine, тут будет ошибка компиляции
        } }



//Interfaces and the instanceof Operator

/*
    Number tickets = 4;
    if(tickets instanceof String) {} // DOES NOT COMPILE - компилятор знает, что String и Number никак не связаны
 */

class InstanceOfEx {
    public static void main(String[] args) {
        Number tickets = 5;
        if(tickets instanceof List) {}
        // т.к. класс Number не финальный, возможно, что variable будет ссылкой на некий такой класс, который экстендит Number и имплементит List
        // public class MyNumber extends Number implements List

        // Но если класс финальный (Integer), то такого наследования делать нельзя и компилятор будет ругаться
//        Integer tickets = 6;
//        if(tickets instanceof List) {} // DOES NOT COMPILE - невозможно создать подкласс у Integer который будет неследовать List interface.
    }
}

// Reviewing Interface Rules
/*
1.Interface Definition Rules Interfaces cannot be instantiated.
2. All top-level types, including interfaces, cannot be marked protected or private.
3.  Interfaces are assumed to be abstract and cannot be marked final.
4. Interfaces may include zero or more abstract methods.
5. An interface can extend any number of interfaces.
6. An interface reference may be cast to any reference that inherits the interface, although this may produce an exception at runtime if the classes aren’t related.
7. The compiler will only report an unrelated type error for an instanceof operation with an interface on the right side if the
reference on the left side is a final class that does not inherit the interface.
8. An interface method with a body must be marked default, private, static, or private static (covered when studying for the 1Z0-816 exam).

 */

// abstract methods defined in interfaces.
/*
1. Abstract methods can be defined only in abstract classes or interfaces.
2. Abstract methods cannot be declared private or final.
3. Abstract methods must not provide a method body/implementation in the abstract class in which is it declared.
4. Implementing an abstract method in a subclass follows the same rules for overriding a method, including covariant return types, exception declarations, etc.
5. Interface methods without a body are assumed to be abstract and public.
 */

/*
Interface Variables Rules
1. Interface variables are assumed to be public, static, and final.
2. Because interface variables are marked final, they must be initialized with a value when they are declared.
 */


// Inner class
// The following is an example of an outer class Zoo with an inner class Ticket:

class Zoo1 {
    // у внутреннего класса доступность может быть любая (public, protected, default, private)
    class Ticket {}
}





    //We can expand this to include an interface.
class Zoo2 {
    private interface Paper {
        public String getId();
    }
    public class Ticket implements Paper {
        private String serialNumber;
        public String getId() { return serialNumber;}
    }
    public Ticket sellTicket(String serialNumber) {
        var t = new Ticket();
        t.serialNumber = serialNumber;
        return t;
    }

        public static void main(String... unused) {
            var z = new Zoo2();
            var t = z.sellTicket("12345");
            System.out.println(t.getId()+" Ticket sold!");
        }

}

