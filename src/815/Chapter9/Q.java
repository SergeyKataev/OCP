package Chapter9;

public class Q {
}

class Q1 {
    // What modifiers are implicitly applied to all interface methods that do not declare a body? (Choose all that apply.)
    // A. protected      - интерфейс не может быть protected
    // B. public        // Correct
    // C. static        - интерфейс может быть static, но тогда ему потребуется body
    // D. void          - это ruturn type, не модификатор доступа
    // E. abstract      // Correct
    // F. default       - интерфейс может быть default, но тогда ему потребуется body
}

class Q2 {
    // Which of the following statements can be inserted in the blank line so that the code will compile successfully? (Choose all that apply.)
    // interface CanHop {}
    // public class Frog implements CanHop {
    // public static void main(String[] args) {
    // ____________ frog = new TurtleFrog();
    // }
    // }
    // class BrazilianHornedFrog extends Frog {}
    // class TurtleFrog extends Frog {}
    // A. Frog          // Correct      - Frog is superclass of TurtleFrog
    // B. TurtleFrog    // Correct      - TurtleFrog is TurtleFrog
    // C. BrazilianHornedFrog           - BrazilianHornedFrog is not superclass TurtleFrog
    // D. CanHop            // Correct  - Frog implements CanHop
    // E. Object            // Correct  - All classes inherit Object
    // F. Long                          - unrelated class
    // G. None of the above; the code contains a compilation error.
}

class Q3 {
    // Which of the following is true about a concrete class? (Choose all that apply.)
    //A. A concrete class can be declared as abstract.                              -  по определению не абстрактный
    //B. A concrete class must implement all inherited abstract methods.            // Correct
    //C. A concrete class can be marked as final.                                   // Correct (может быть final, а может и не быть)
    //D. If a concrete class inherits an interface from one of its superclasses,    // должен имплементить только абстрактные классы из супер класса
    // then it must declare an implementation for all methods defined in that interface.
    //E. A concrete method that implements an abstract method must
    //match the method declaration of the abstract method exactly.  - не exactly, т.к. это overriding можно использовать covariant return type, или другие исключения
}

class Q4 {
    // Which statements about the following program are correct? (Choose all that apply.)
    // 1: interface HasExoskeleton {
    // 2: double size = 2.0f;                   // норм. при компилции допишется public static abstract
    // 3: abstract int getNumberOfSections();   // норм. при компилции допишется public
    // 4: }
    // 5: abstract class Insect implements HasExoskeleton {
    // 6: abstract int getNumberOfLegs();
    // 7: }
    // 8: public class Beetle extends Insect {                      // не имплементируется метод
    // 9: int getNumberOfLegs() { return 6; }                       // тут доступ default, а был public
    // 10: int getNumberOfSections(int count) { return 1; }         // в интерфейсе этот метод без параметров
    // 11: }
    // A. It compiles without issue.
    // B. The code will produce a ClassCastException if called at runtime.
    // C. The code will not compile because of line 2.
    // D. The code will not compile because of line 5.
    // E. The code will not compile because of line 8.      // Correct
    // F. The code will not compile because of line 10.
}

class Q5 {
    // What modifiers are implicitly applied to all interface variables? (Choose all that apply.)
        // public static final

    //A. private
    //B. nonstatic
    //C. final      // Correct
    //D. const
    //E. abstract
    //F. public     // Correct
    //G. default (package-private)
}

class Q6 {
    // Which statements about the following program are correct? (Choose all that apply.)
    //1: public abstract interface Herbivore {
    //2: int amount = 10;
    //3: public void eatGrass();
    //4: public abstract int chew() { return 13; }  // в интерфейсе нельзя писать реализацию
    //5: }
    //6:
    //7: abstract class IsAPlant extends Herbivore {    // интерфейс - implement
    //8: Object eatGrass(int season) { return null; }   // тут протой overload
    //9: }

    //A. It compiles and runs without issue.
    //B. The code will not compile because of line 1.
    //C. The code will not compile because of line 2.
    //D. The code will not compile because of line 4.   // Correct
    //E. The code will not compile because of line 7.   // Correct
    //F. The code will not compile because line 8 contains an invalid
    //method override.
}

class Q7 {
    // Which statements about the following program are correct? (Choose all that apply.)
    // 1: abstract class Nocturnal {    // + public
    // 2: boolean isBlind();            // не абстрактный класс, нужна реализация
    // 3: }
    // 4: public class Owl extends Nocturnal {
    // 5: public boolean isBlind() { return false; }
    // 6: public static void main(String[] args) {
    // 7: var nocturnal = (Nocturnal)new Owl();
    // 8: System.out.println(nocturnal.isBlind());
    // 9: } }

    // A. It compiles and prints true.
    // B. It compiles and prints false.
    // C. The code will not compile because of line 2.  // Correct
    // D. The code will not compile because of line 5.
    // E. The code will not compile because of line 7.
    // F. The code will not compile because of line 8.
    // G. None of the above
}

class Q8 {
    // Which statements are true about the following code? (Choose all that apply.)
    //interface Dog extends CanBark, HasVocalCords {
    //abstract int chew();
    //}
    //public interface CanBark extends HasVocalCords {
    //public void bark();
    //}
    //interface HasVocalCords {
    //public abstract void makeSound();
    //}

    // A. The CanBark declaration doesn’t compile.
    // B. A class that implements HasVocalCords must override the makeSound() method.   - если этот класс будет abstract, то не должен override
    // C. A class that implements CanBark inherits both the makeSound() and bark() methods.     // Correct
    // D. A class that implements Dog must be marked final. // может быть, но не должен
    // E. The Dog declaration does not compile because an interface cannot extend two interfaces.   // может экстендить 2 интерфейса
}

class Q9 {
    // Which access modifiers can be applied to member inner classes? (Choose all that apply.)
    // Все, кроме static

    //A. static
    //B. public                     // Correct
    //C. default (package-private)  // Correct
    //D. final
    //E. protected                  // Correct
    //F. private                    // Correct
}

class Q10 {
    // Which statements are true about the following code? (Choose all that apply.)
    //5: public interface CanFly {
    //6: int fly()                      // отсутствует ;
    //7: String fly(int distance);      // перегрузка метода
    //8: }
    //9: interface HasWings {
    //10: abstract String fly();        // конфликт с методом на стр. 6. Нельзя создать класс, с методом fly(), который возвращает и String и int
    //11: public abstract Object getWingSpan();
    //12: }
    //13: abstract class Falcon implements CanFly, HasWings {}

    //A. It compiles without issue.
    //B. The code will not compile because of line 5.
    //C. The code will not compile because of line 6.       // Correct
    //D. The code will not compile because of line 7.
    //E. The code will not compile because of line 9.
    //F. The code will not compile because of line 10.
    //G. The code will not compile because of line 13.      // Correct
}

class Q11 {
    // Which modifier pairs can be used together in a method declaration? (Choose all that apply.)
    //A. static and final           // Correcy
    //B. private and static         // Correct
    //C. static and abstract        // нельзя abstract вместе с static, final, private
    //D. private and abstract       // нельзя abstract вместе с static, final, private
    //E. abstract and final         // нельзя abstract вместе с static, final, private
    //F. private and final          // Correct
}

class Q12 {
    // Which of the following statements about the FruitStand program are correct? (Choose all that apply.)
    // Сложные случаи - если права интерфейс. В остальных случаях сравниваем классы и смотрим явное пересечение


    // 1: interface Apple {}
    // 2: interface Orange {}
    // 3: class Gala implements Apple {}
    // 4: class Tangerine implements Orange {}
    // 5: final class Citrus extends Tangerine {}
    // 6: public class FruitStand {
    // 7: public static void main(String... farm) {
    // 8: Gala g = new Gala();
    // 9: Tangerine t = new Tangerine();
    // 10: Citrus c = new Citrus();
    // 11: System.out.print(t instanceof Gala);         // ERROR
    // 12: System.out.print(c instanceof Tangerine);    // true
    // 13: System.out.print(g instanceof Apple);        // true
    // 14: System.out.print(t instanceof Apple);        // c e
    // 15: System.out.print(c instanceof Apple);        // ERROR
    // 16: } }

    // A. Line 11 contains a compiler error.            // Correct
    // B. Line 12 contains a compiler error.
    // C. Line 13 contains a compiler error.
    // D. Line 14 contains a compiler error.
    // E. Line 15 contains a compiler error.            // Correct
    // F. None of the above
}

 interface Apple {}
 interface Orange {}
 class Gala implements Apple {}
 class Tangerine implements Orange {}

 final class Citrus extends Tangerine {}
  class FruitStand {
 public static void main(String... farm) {
 Gala g = new Gala();
 Tangerine t = new Tangerine();
 Citrus c = new Citrus();
// System.out.print(t instanceof Gala);         // ERROR - классы точно разные
 System.out.println(c instanceof Tangerine);    // true       - Ссылка на класс instanceof Class
 System.out.println(g instanceof Apple);        // true       - компилируется, т.е. неизвестно может ли какой то подкласс g имплементить Apple
 System.out.println(t instanceof Apple);        // c e        - компилируется, т.е. неизвестно может ли какой то подкласс g имплементить Apple
// System.out.print(c instanceof Apple);        // ERROR      - yt компилируется, т.е. известно, что c - final
 } }



 class Q13 {
    // What is the output of the following code?
     //1: interface Jump {
     //2: static public int MAX = 3;
     //3: }
     //4: public abstract class Whale implements Jump {
     //5: public abstract void dive();
     //6: public static void main(String[] args) {              // в абстрактном классе можно вызывать main
     //7: Whale whale = new Orca();                             // можно неявно кастовать
     //8: whale.dive(3);                                        // вызывается метод через ссылку Whale. У него нет метода drive(int).Будет ошибка
     //9: }
     //10: }
     //11: class Orca extends Whale {
     //12: public void dive() {
     //13: System.out.println("Orca diving");
     //14: }
     //15: public void dive(int... depth) {
     //16: System.out.println("Orca diving deeper "+MAX);
     //17: } }

     // A. Orca diving
     //B. Orca diving deeper 3
     //C. The code will not compile because of line 2.
     //D. The code will not compile because of line 4.
     //E. The code will not compile because of line 11.
     //F. The code will not compile because of line 16.
     //G. None of the above                                 // Correct
 }

 class Q14 {
    // Which statements are true for both abstract classes and interfaces? (Choose all that apply.)
     //A. Both can be extended using the extends keyword.       // Correct
     //B. All methods within them are assumed to be abstract.   // В абстрактном классе могут быть неабстрактные методы и статичные методы
     //C. Both can contain public static final variables.       // Correct
     //D. The compiler will insert the implicit abstract modifier   // Если в абстрактном классе указать метод без тела, то надо явно сказать, что он абстрактный
                                                                    // В интерфейсе метод без тела - ок
     //automatically on methods declared without a body, if they are not marked as such.
     //E. Both interfaces and abstract classes can be declared with the     // Correct
     //abstract modifier.
     //F. Both inherit java.lang.Object.        // Интерфейсы не наследуют Object
 }

 class Q15 {
    // What is the result of the following code?
     // 1: abstract class Bird {
     // 2: private final void fly() {
     // System.out.println("Bird"); }
     // 3: protected Bird() { System.out.print("Wow-"); }
     // 4: }
     // 5: public class Pelican extends Bird {
     // 6: public Pelican() { System.out.print("Oh-"); }
     // 7: protected void fly() { System.out.println("Pelican");
     // }
     // 8: public static void main(String[] args) {
     // 9: var chirp = new Pelican();
     // 10: chirp.fly(); "Wow-Oh-Pelican
     // 11: } }

     // A. Oh-Bird
     // B. Oh-Pelican
     // C. Wow-Oh-Bird
     // D. Wow-Oh-Pelican
     // E. The code contains a compilation error.
     // F. None of the above


     /*
     сначала дергается конструктор на стр 6. Вставляется super() и дергается стр 3.
     Bird chirp = new Pelican(); - если было бы так, то ошибка компиляции, т.к. дергался бы метод void из Bird, который недоступен (private)
     если бы 2: private final void fly() { был не финальный - ошибка компиляции - ошибка overriding
      */
 }


abstract class Bird {
private final void fly() {
 System.out.println("Bird"); }
protected Bird() { System.out.print("Wow-"); }
}
class Pelican extends Bird {
public Pelican() { System.out.print("Oh-"); }
protected void fly() { System.out.println("Pelican");
}
public static void main(String[] args) {
var chirp = new Pelican();
chirp.fly();
} }



 // Последовательно вызова конструкторов и статичных инициализаторов:
 class GiraffeFamily {
     static { System.out.print("A"); }       // 1. всегда первым делом выполняется статические элементы родителя
     { System.out.print("B"); }              // 6. печатаем

     public GiraffeFamily(String name) {
         this(1);                // 4. Вызываем другой конструктор с агрументом 1
         System.out.print("C");          // 8. печатаем
     }

     public GiraffeFamily() {
         System.out.print("D");
     }

     public GiraffeFamily(int stripes) { // 5. тут будет создаваться элемент, поэтому выполняются все нестатические блоки класса
         System.out.print("E");              // 7. печатаем
     }
 }

class Okapi extends GiraffeFamily {
    static { System.out.print("F"); }   //2. После родителя выполняются статические элементы создаваемого класса

    public Okapi(int stripes) {
        super("sugar");         // 3. вызываем super("sugar");
        System.out.print("G");      // 10. печатаем
    }
    { System.out.print("H"); }          // 9 после вызова super, вызываются нестатические блоки класса

    public static void main(String[] grass) {

        new Okapi(1);   // AFBECHG
        System.out.println();
        new Okapi(2);   // BECHG
    }
}

// Overriding method
/*
Правила overriding. Компилятор выполняет эти проверки:
1. Метод в классе потомке должен иметь такую же сигнатуру (название, параметры) как и класс родитель.
2. Метод в классе потомке должен быть как минимум такой же в доступности, как и класс родитель. Не должен сужать родителя.
3. Метод в классе потомке может не декларировать исключения которые новые или шире, чем класс исключений в классе родителе.
4. Если метод возвращает значение, оно должно быть такое же или подтип как в классе родителе. Или Covariant - можно использовать этот тип без явного каста.
 */


class Q16 {
    // Which of the following statements about this program is correct?
    //1: interface Aquatic {
    //2: int getNumOfGills(int p);          // implicitly public
    //3: }
    //4: public class ClownFish implements Aquatic {
    //5: String getNumOfGills() { return "14"; }
    //6: int getNumOfGills(int input) { return 15; }  // default уже чем public
    //7: public static void main(String[] args) {
    //8: System.out.println(new
    //ClownFish().getNumOfGills(-1));
    //9: } }

    //A. It compiles and prints 14.
    //B. It compiles and prints 15.
    //C. The code will not compile because of line 4.
    //D. The code will not compile because of line 5.
    //E. The code will not compile because of line 6.       // Correct
    //F. None of the above
}

class Q17 {
    // Which statements about top-level types and member inner classes are correct? (Choose all that apply.)
    // A. A member inner class can be marked final.  // Correct (могут быть abstract или final)
    // B. A top-level type can be marked protected.     // Только public или default (class, interface, or enum)
    // C. A member inner class cannot be marked public since that would make it a top-level class.  // Могут быть внутриние и public
    // D. A top-level type must be stored in a .java file with a name that matches the class name.  // не обязательно
    // E. If a member inner class is marked private, then it can be referenced only in the outer class for which it is defined. // Correct
}


class Q18 {
    // What types can be inserted in the blanks on the lines marked X and Z that allow the code to compile? (Choose all that apply.)
    //interface Walk { public List move(); }
    //interface Run extends Walk { public ArrayList move(); }
    //public class Leopard {
    //public ______ move() { // X
    //return null;
    //}
    //}
    //public class Panther implements Run {
    //public ______ move() { // Z
    //return null;
    //}
    //}

    //A. Integer on the line marked X       // Correct
    //B. ArrayList on the line marked X     // Correct
    //C. List on the line marked Z          // - List is not a subtype of ArrayList
    //D. ArrayList on the line marked Z      // Correct
    //E. None of the above, since the Run interface does not compile.
    //F. The code does not compile for a different reason.
}

class Q19 {
    // Which statements about interfaces are correct? (Choose all that apply.)
    //A. A class cannot extend multiple interfaces.                 // Correct
        /*
A class cannot extend any interface, as a class can only extend other classes and interfaces can only extend other interfaces, making option A correct
         */
    //B. Java enables true multiple inheritance via interfaces.  // Java enables only limited multiple inheritance with interfaces,
    //C. Interfaces cannot be declared abstract.
    //D. If an interface does not contain a constructor, the compiler will insert one automatically. // нет конструктора
    //E. An interface can extend multiple interfaces.           // Correct
    //F. An interface cannot be instantiated.                   // Correct
}

class Q20 {
    //Which of the following classes and interfaces are correct and compile? (Choose all that apply.)
    // abstract class Camel {
    //void travel();            // должна быть реализация
    //}
    //interface EatsGrass {
    //protected int chew();     // должен быть public
    //}
    //abstract class Elephant {
    //abstract private class SleepsAlot {   // внутренний может быть приватным и абстрактым
    //abstract int sleep();
    //}
    //}
    //class Eagle {
    //abstract soar();  // абстрактный в неабстрактном нельзя
    //}
    //A. SleepsAlot     // Сorrect
    //B. Eagle
    //C. Camel
    //D. Elephant       // Сorrect
    //E. EatsGrass
    //F. None of the classes or interfaces compile.
}


