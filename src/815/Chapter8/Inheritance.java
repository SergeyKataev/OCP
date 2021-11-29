package Chapter8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inheritance {
}


// пример наследования
class BigCat {
    public double size;     // эту переменную наследует ягуар, т.к. она паблик
}

class Jaguar extends BigCat {
    public Jaguar() {
        size = 10.2;            // Есть доступ к переменной size
    }
    public void printDetails() {
        System.out.println(size);  // можем распечатать
    }
}

// ключевое слово this. Обращение к текущему объекту
class Flamingo {
    private String color;
    public void setColor(String color) {
        color = color;                  // присваиваем переменной метода - переменную метода this.color = color.
    }
    public static void main(String... unused) {
        Flamingo f = new Flamingo();
        f.setColor("PINK");
        System.out.println(f.color); // null
    }
}

// super
class Mammal {
    String type = "mammal";
}
class Bat extends Mammal {
    String type = "bat";
    public String getType() {
        return super.type + ":" + this.type;
    }
    public static void main(String... zoo) {
        System.out.print(new Bat().getType());  // mammal:bat
    }
}

// еще пример
class Insect {
    protected int numberOfLegs = 4;
    String label = "buggy";
}

class Beetle extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;
    public void printData() {
            System.out.println(this.label);           // buggy
            System.out.println(super.label);          // buggy
            System.out.println(this.age);             // 3
//            System.out.print(super.age);          // у Insect нет age
            System.out.println(numberOfLegs);         // 6
            }
            public static void main(String []n) {
            new Beetle().printData();
            }
}


// Constructor
class Bunny {
    public Bunny() {
        System.out.println("constructor");
//        public bunny() { } // DOES NOT COMPILE            - должно быть название такое же как класс
//        public void Bunny() { } // DOES NOT COMPILE       - нельзя return
//        public Bonobo(var food) { // DOES NOT COMPILE     - нельзя var в пераметрах метода
    }
}

// может быть несколько конструкторов с разными параметрами
class Turtle {
    private String name;
    public Turtle() {
        name = "John Doe";
    }
    public Turtle(int age) {}
    public Turtle(long age) {}
    public Turtle(String newName, String... favoriteFoods) {
        name = newName;
    }
}

// приватный конструктор
class Rabbit3 {
    private Rabbit3() {}
}
class RabbitFacture3 {
    public static void main(String[] args) {
//        Rabbit4 r4 = new Rabbit4(); // DOES NOT COMPILE - потому что конструктор приватный
    } }


    // Статичные методы имеют доступ к приватным полям и и методам, в т.е. конструкторам
class Rabbit4 {
    private Rabbit4() {}   // приватный конструктор
    String name = "bunny";

    static Rabbit4 staticConstuct() {
        return new Rabbit4();
    }
}
class RabbitFacture {
    public static void main(String[] args) {
//        Rabbit4 r4 = new Rabbit4(); // DOES NOT COMPILE - потому что конструктор приватный
        Rabbit4 r4 = Rabbit4.staticConstuct();
        System.out.println(r4.name);
        } }


        // Ошибки в работе с конструктором
        // циклический вызов конструктора

//class Gopher {
//    public Gopher(int dugHoles) {
//        this(5); // DOES NOT COMPILE
//    }
//}


// Тоже не скомпилируется, цикличность. Вызывают друг друга
/*
public class Gopher {
    public Gopher() {
        this(5); // DOES NOT COMPILE
    }
    public Gopher(int dugHoles) {
        this(); // DOES NOT COMPILE
    }
}
 */

/*
this - обращается к классу
this() - обращается к конструктору
 */


// super в конструкторе
class Animal3 {
    private int age;
    private String name;
    public Animal3(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    public Animal3(int age) {
        super();
        this.age = age;
        this.name = null;
        System.out.println("Gorilla(int age)");
    }
}
class Gorilla extends Animal3 {
    public Gorilla(int age) {
        super(age,"Gorilla");
    }
    public Gorilla() {
        super(5);
        System.out.println("Gorilla()");
    }

    public static void main(String[] args) {
        new Gorilla();
                            // Gorilla(int age)
                            // Gorilla()
    }
}

/*
super - обращается к классу
super() - обращается к конструктору
 */


// примеры с конструктором
class Mammal1 {
    public Mammal1(int age) {}
}
// class Elephant extends Mammal1 { // DOES NOT COMPILE
// }
// при компиляции у Elephant будет создан дефолтный конструктор и будет вызван super(). Но этого метода нет в Mamal1 - ошибка компиляции
// public class Elephant extends Mammal {
//      public Elephant() {
//      super(); // DOES NOT COMPILE
//  }
//}


// By the time the constructor completes, all final instance variables must be assigned a value. Let’s try this out in an example:
// удачный пример
class MouseHouse {
    private final int volume;
    private final String type;
    public MouseHouse() {
        this.volume = 10;
        type = "happy";
    }
}

// теперь с ошибкой
class MouseHouseWithError {
    private final int volume;
    private final String type;
    {
        this.volume = 10;
    }
    public MouseHouseWithError(String type) {   // можно асайнить через конструктор. В таком случае мы не создадим объект, не указав пемеренную
        this.type = type;
    }
//    public MouseHouseWithError() { // DOES NOT COMPILE
//        this.volume = 2; // DOES NOT COMPILE              -- попытка второй раз заасайнить финальную переменную
//                                                            -- так же в этой конструкторе не асайнится переменная type, будет ошибка компиляции
//    }

    public static void main(String[] args) {
        // new MouseHouseWithError(); - ошибка компиляции, т.к. не определен пустой конструктор.
    }
}
/*
Все финальные переменные должны быть определены:
* в момент создания
* в блоке инициализации
* в конструкторе
 */


// порядок инициализации
class Animal2 {
    static { System.out.print("A"); }  // сначала статичные поля родителя
}
class Hippo extends Animal2 {
    static { System.out.print("B"); }   // потом статичные поля класса
    public static void main(String[] grass) {
        System.out.print("C");          // потом все остальное
        new Hippo();
        new Hippo();
        new Hippo();   // ABC
    }
}

// пример, когда мы сначала печатаем, до вызова конструктора
class HippoFriend {
    public static void main(String[] grass) {
        System.out.print("C");
        new Hippo();        // СAB
    }
}


// simple example
class ZooTickets {
private String name = "BestZoo";        // 4. потом инициализируются нестатичные блоки
{ System.out.print(name+"-"); }         // 5. потом инициализируются нестатичные блоки
private static int COUNT = 0;           // 1. сначала инициализируются статические переменные или блоки в последовательности
static { System.out.print(COUNT+"-"); } // 2. сначала инициализируются статические переменные или блоки в последовательности
static { COUNT += 10; System.out.print(COUNT+"-"); } // 3. сначала инициализируются статические переменные или блоки в последовательности

public ZooTickets() {
        System.out.print("z-");         // 6. в завершении печатается конструктор
        }

        public static void main(String... patrons) {
        new ZooTickets(); // 0-10-BestZoo-z-
        }
}


// Next, let’s try a simple example with inheritance.
class Primate {
    public Primate() {
        System.out.print("Primate-");
    }
}
class Ape extends Primate {
    public Ape(int fur) {           // 1. перед работой конструктора всегда вызывается super().
        System.out.print("Ape1-");
    }
    public Ape() {
        System.out.print("Ape2-");
    }
}
class Chimpanzee extends Ape {
    public Chimpanzee() {
        super(2);
        System.out.print("Chimpanzee-");
    }
    public static void main(String[] args) {
        new Chimpanzee();  // Primate-Ape1-Chimpanzee-
    }
}

// The next example is a little harder. What do you think happens here?
// еще до main отрабатывают все статичные переменные и инициализаторы
class Cuttlefish {
    private String name = "swimmy";
    { System.out.println(name); }
    private static int COUNT = 0;
    static { System.out.println(COUNT); }
    { COUNT++; System.out.println(COUNT); }

        public Cuttlefish() {
        System.out.println("Constructor");
        }

        public static void main(String[] args) {
        System.out.println("Ready");   // 0 Ready swimmy 1 Constructor
        new Cuttlefish();
        }
}


// more example
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

        public static void main(String[] grass) {       // AFBECHG
                                                        // BECHG
        new Okapi(1);
        System.out.println();
        new Okapi(2);
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

// Пример на overriding
class Canine {
    public double getAverageWeight() {
        return 50;
    }
}
class Wolf extends Canine {
    public double getAverageWeight() {  // Overriding - такое же название, возвращаемое значение и такие же параметры методоа
        return super.getAverageWeight()+20;
    }


    public static void main(String[] args) {
        System.out.println(new Canine().getAverageWeight());   // 50
        System.out.println(new Wolf().getAverageWeight());      // 70
    }
}

// Перегрузка, перезагрузка
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
    public void eat(int food) {
        System.out.println("Bird is eating "+food+" units of food");
    }
}
class Eagle extends Bird {
    public int fly(int height) {   // перегрузка, т.к. разные параметры, а название одинаковое. У перегрузки могут быть разные возвращаемые значения.
        System.out.println("Bird is flying at "+height+" meters");
        return height;
    }

    @Override
    public void fly() {    // Overriding - такое же название, возвращаемое значение и такие же параметры методоа
        System.out.println("Override fly");
    }

    protected void eat() {  // перегрузка, т.к. разные параметры, а название одинаковое.

    }

    @Override
    public void eat(int food) { // Overriding - такое же название, возвращаемое значение и такие же параметры методоа
        System.out.println("Override eat");
    }

    //    public int eat(int food) { // DOES NOT COMPILE // одинаковые параметры метода, если хотели сделать overriding, то нужен такое же возвращаемое значение
//        System.out.println("Bird is eating "+food+" units of food");
//        return food;
//    }
}


// еще пример
class Camel7 {
    public int getNumberOfHumps() {
        return 1;
    }
}
class BactrianCamel extends Camel7 {
//    private int getNumberOfHumps() { // DOES NOT COMPILE, при Overriding нельзя сужать доступность
//        return 2;
//    }

    public int getNumberOfHumps() { // OK
        return 2;
    }
}
class Rider {
    public static void main(String[] args) {
        Camel7 c = new BactrianCamel();
//        System.out.print(c.getNumberOfHumps());
    }
}


// Исключения:
 class Reptile {
    protected void sleepInShell() throws IOException {}
    protected void hideInShell() throws NumberFormatException {}
    protected void exitShell() throws FileNotFoundException {}  // IOException
}
 class GalapagosTortoise extends Reptile {
    public void sleepInShell() throws FileNotFoundException {}
    public void hideInShell() throws IllegalArgumentException {}
//    public void exitShell() throws IOException {} // DOES NOT COMPILE  IOException is superclass of FileNotFoundException - так нельзя
     // Если ты наследуешься, то ты не можешь делать исключения шире. Можно только сужать.

}

//  The overriding method must use a return type that is covariant with the return type of the inherited method.
// covariant - можно использовать тип А, взамен типу B без явного каста
class Rhino {
    protected CharSequence getName() {
        return "rhino";
    }
    protected String getColor() {
        return "grey, black, or white";
    }

    protected Integer getInt() {
        return 1;
    }
}
class JavanRhino extends Rhino {
    public String getName() {
        return "javan rhino";
    }
//    public CharSequence getColor() { // DOES NOT COMPILE - используется возврашаемый тип Шире, а можно только уже
//        return "grey";
//    }

//    public Number getInt() {  // Аналогично, нельзя расширять return type
//        return 1;
//    }
}


// Дженерики при Overriding
class LongTailAnimal {
    // ошибка перегрузки
    protected void chew(List<Object> input) {}
//    protected void chew(List<Double> input) {} // DOES NOT COMPILE - типы затрутся и будут одинаковые методы
}

// так же нельзя перегружать методы с дженериками в наследниках
class LongTailAnimal2 {
    protected void chew(List<Object> input) {}
}
class Anteater extends LongTailAnimal2 {
    // protected void chew(List<Double> input) {} // DOES NOT COMPILE - так нельзя перегружать методы
    protected void chew(List<Object> input) {} // так можно
}

// Generic Method Parameters
// Можно overriding метод с дженериками в параметре, но должно быть 1 в 1 типы дженериков
// you can override a method with generic parameters, but you must match the signature including the generic type exactly.

 class LongTailAnimal3 {
    protected void chew(List<String> input) {}
}
class Anteater2 extends LongTailAnimal3 {
    protected void chew(List<String> input) {}  // Overriding. одинаковые типы дженериков
}



class LongTailAnimal6 {
    protected void chew(List<Object> input) {}
}
class Anteater6 extends LongTailAnimal6 {
    protected void chew(List<Object> input) {}
    //     protected void chew(List<String> input) {}  // Overriding.В МЕТОДЕ НЕ одинаковые типы дженериков
}

// пример перегрузки методов
class LongTailAnimal4 {
    protected void chew(List<Object> input) {}
}
class Anteater3 extends LongTailAnimal4 {
    protected void chew(List<Object> input) { super.chew(input); } // Overriding.

    protected void chew(ArrayList<Double> input) {}     // это перегрузка, т.к. принимается другой тип в методе, тут можно использовать сужение дженериков
}



class Mammal2 {
    public List<CharSequence> play() { return null; }
    public CharSequence sleep() {return null;}
}
class Monkey extends Mammal2 {
    public ArrayList<CharSequence> play() { return null; }  // тип возвращаемого элемента может быть подклассом. Дженерик должен соответствовать 1 в 1
//    public List<String> play() { return null; }     // Overriding. тип дженериков должен быть 1 в 1. Сужать сам return тип можно
}
class Goat extends Mammal2 {
    public String sleep() { return null; }  // Overriding. Сужать сам return тип можно
}


// работа с приватными методами
class Camel6 {
    private String getNumberOfHumps() {
        return "Undefined";
    }
}
class DromedaryCamel extends Camel6 {
    private String getNumberOfHumps() {  // независимый от Calem6 метод
        return "1";
    }

}


// Hiding Static Methods
// Hiding метод когда два метода маркированы как static и метод overriding.
// Если один из двух методов не статичный/статичный, то класс не скомпилируется


class Bear {
    public static void eat() {
        System.out.println("Bear is eating");
    }
}
class Panda extends Bear {
    public static void eat() {          // Oveddiding. Оба статичных и в родителе и в наследнике. Поэтому это hiding. Будет использован метод Panda.
        System.out.println("Panda is chewing");
    }

    public static void main(String[] args) {
        eat();  // Panda is chewing

    }
}


//  еще пример на hiding
class Bear6 {
    public static void sneeze() {
        System.out.println("Bear is sneezing");
    }
    public void hibernate() {
        System.out.println("Bear is hibernating");
    }
    public static void laugh() {
        System.out.println("Bear is laughing");
    }
}

class Panda6 extends Bear {
//    public void sneeze() { // DOES NOT COMPILE   - sneeze есть в родителе и он статичный
//        System.out.println("Panda sneezes quietly");
//    }
//    public static void hibernate() { // DOES NOT COMPILE  - hibernate есть в родителе и он не статичный
//        System.out.println("Panda is going to sleep");
//    }
//    protected static void laugh() { // DOES NOT COMPILE   - нельзя сущать доступ к методу. Правило Overriding
//        System.out.println("Panda is laughing");
//    }

/*
To override a method, you must follow a number of rules. The   compiler performs the following checks when you override a method:
1. The method in the child class must have the same signature as the method in the parent class.
2. The method in the child class must be at least as accessible as the method in the parent class.
3. The method in the child class may not declare a checked exception that is new or broader than the class of any exception declared in
the parent class method.
4. If the method returns a value, it must be the same or a subtype of the method in the parent class, known as covariant return types.
 */

}

// Creating final Methods
//Let’s take a look at an example:
class Bird4 {
    public final boolean hasFeathers() {   // финальный
        return true;
    }
    public final static void flyAway() {}  // финальный
}
class Penguin2 extends Bird4 {
//    public final boolean hasFeathers() { return false; } // DOES NOT COMPILE - нельзя перегружать финальные методы
//    public final static void flyAway() {} // DOES NOT COMPILE - нельзя перегружать финальные методы
}


// Hiding Variables
class Carnivore {
    protected boolean hasFur = false;
}
class Meerkat extends Carnivore {
    protected boolean hasFur = true;
    public static void main(String[] args) {
        Meerkat m = new Meerkat();  // true    - зависит от ссылки
        Carnivore c = m;            // false    - зависит от ссылки
        System.out.println(m.hasFur);   // true
        System.out.println(c.hasFur);   // false
    }
}


// polymorphism
class Primate2 {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {
    public abstract boolean isTailStriped();
}

class Lemur extends Primate2 implements HasTail {
    public boolean isTailStriped() {
        return false;
    }
    public int age = 10;
    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);  // 10
        HasTail hasTail = lemur;            // переменная интерфейс - так можно
        System.out.println(hasTail.isTailStriped());     // false - вызывается метод Lemur
        Primate2 primate = lemur;       // переменная - супер класс - так можно
        System.out.println(primate.hasHair());  // true - вызывается метод Primate2


        HasTail hasTail2 = lemur;
//        System.out.println(hasTail2.age); // DOES NOT COMPILE - по ссылке HasTail нет параметра age
        Primate2 primate2 = lemur;
//        System.out.println(primate2.isTailStriped()); // DOES NOT COMPILE - по ссылке Primate2 нет метода isTailStriped
    }
}

// Object vs. Reference
/*
1. Тип объекта определяется на основании созданного объекта в памяти.
2. Тип ссылки на объект определяет какие методы и переменные будут доступны. Эти методы и параметры доступны еще до определения ссылки.
 */

// Casting Objects

class Lemur2 extends Primate2 implements HasTail {
    public boolean isTailStriped() {
        return false;
    }
    public int age = 10;
    public static void main(String[] args) {
        Primate2 primate = new Lemur2(); // Implicit Cast
//        Lemur2 lemur2 = primate; // DOES NOT COMPILE нельзя присвоить ссылку Primate2 ссылке Lemur2 без явного каста
        Lemur2 primate3 = (Lemur2) primate; // так можно, явный каст
        System.out.println(primate3.age); // теперь можно вызвать переменную

    }
}

/*
We summarize these concepts into a set of rules for you to memorize
for the exam:
1. Casting a reference from a subtype to a supertype doesn’t require
an explicit cast.
2. Casting a reference from a supertype to a subtype requires an
explicit cast.
3. The compiler disallows casts to an unrelated class!!! с интерфейсами по другому.
4. At runtime, an invalid cast of a reference to an unrelated type
results in a ClassCastException being thrown.
 */

// rule #3

class Bird3 {}
class Fish3 {
    public static void main(String[] args) {
        Fish3 fish = new Fish3();
//        Bird bird = (Bird3)fish; // DOES NOT COMPILE - нельзя кастовать к несвязному классу
    }
}

class Rodent {}
class Capybara extends Rodent {
    public static void main(String[] args) {
        Rodent rodent = new Rodent();
        Capybara capybara = (Capybara)rodent; // ClassCastException в рантайме. Ты не можешь более широй класс загонять в узкий через такой каст.
        // Rodent не может быть скастован в Capybara, но не знает  о ее существовании
    }
}

class Rodent1 {}
class Capybara1 extends Rodent1 {
    public static void main(String[] args) {
        Capybara1 rodent = new Capybara1();
        Rodent1 capybara = rodent; // так можно
    }
}

// The instanceof Operator

class Rodent2 {}
class Capybara2 extends Rodent2 {
    public static void main(String[] args) {
        Capybara2 rodent = new Capybara2();
        if(rodent instanceof Capybara2) {
            Capybara2 capybara = (Capybara2)rodent;
            System.out.println("Capybara2 capybara = (Capybara2)rodent;");
        }

    }
}
// если классы ЯВНО не соответствуют друг другу, то компилятор будет ругаться
class Bird5 {}
class Fish5 {
    public static void main(String[] args) {
        Fish5 fish = new Fish5();
//        if (fish instanceof Bird5) { // DOES NOT COMPILE
//            Bird5 bird = (Bird5) fish; // DOES NOT COMPILE
//        }
    }
}

// Polymorphism and Method Overriding
class Penguin {
    public int getHeight() { return 3; }
    public void printInfo() {
        System.out.print(this.getHeight()); // this не обязателен. Тут идет вызов метода printInfo - EmperorPenguin
    }
}
class EmperorPenguin extends Penguin {
    public int getHeight() { return 8; }
    public static void main(String []fish) {
        new EmperorPenguin().printInfo();  // 8
    }
}


//Overriding vs. Hiding Members

class Penguin3 {
    public static int getHeight() { return 3; }     // статичный метод, спрятан
    public void printInfo() {
        System.out.println(this.getHeight());
    }
}
class CrestedPenguin3 extends Penguin3 {
    public static int getHeight() { return 8; }
    public static void main(String... fish) {
        new CrestedPenguin3().printInfo();
    }
}

// посложнее пример
class Marsupial {
    protected int age = 2;
    public static boolean isBiped() {
        return false;
    }
}
class Kangaroo extends Marsupial {
    protected int age = 6;
    public static boolean isBiped() {
        return true;
    }
    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();         // Создается только один объект
        Marsupial moey = joey;                  // Меньший Kangaroo передается в ссылку большего Marsupial - тут ок
        System.out.println(joey.isBiped());     // true   - отталкиваемся от ссылки, которая хранит объект
        System.out.println(moey.isBiped());     // false
        System.out.println(joey.age);           // 6
        System.out.println(moey.age);           // 2
    }
}



