package Chapter2;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnotationEx {
}

/*
Первое правило: Аннотации как интерфейсы, мы маркируем класс как ZooAnimal без изменения его наследования
@ZooAnimal public class Lion extends Mammal {}
@ZooAnimal public class Peacock extends Bird {}

Второе правило: аннотация устанавливает взаимоотношения, которые делают легче управления данными
 @ZooAnimal(habitat="Infirmary") private Lion sickLion;
 @ZooAnimal(habitat="Safari") private Lion healthyLion;


// третье правило: аннотации описывают КОНКРЕТНУЮ инфу в зависимости от того, где они указаны
public class Lion {
 @ZooSchedule(hours={"9am","5pm","10pm"}) void feedLions() {
 System.out.print("Time to feed the lions!");
 }
}
public class Peacock {
 @ZooSchedule(hours={"4am","5pm"}) void cleanPeacocksPen() {
 System.out.print("Time to sweep up!");
 }

// пятое правило: аннотации - опциональная метаинформация, которая ничего сама по себе не делает
 */

// Creating Custom Annotations - может быть public или default
@interface Exercise {}

@Exercise() class Cheetah {}  // можно со скобками

@Exercise               // можно над классом
class ZooEmployee {}


// Specifying a Required Element
@interface Exercise1 {
    int hoursPerDay();
}

// Let's see how this new element changes our usage:
@Exercise1(hoursPerDay=3) class Cheetah1 {}

//@Exercise1 hoursPerDay=0 public class Sloth {} // DOES NOT COMPILE
    // - missing parentheses around the annotation parameters, parentheses are optional only if no values are included.
//@Exercise1 public class ZooEmployee {} // DOES NOT COMPILE -
    // When declaring an annotation, any element without a default value is considered required.

// Providing an Optional Element
// For an element to be optional, rather than required, it must include a default value. Let's update our
//annotation to include an optional value.
@interface Exercise2 {
    int hoursPerDay();   // обязательный
    int startHour() default 6; // дефолтное значение
}

// Next, let's apply the updated annotation to our classes.
@Exercise2(startHour=5, hoursPerDay=3) class Cheetah2 {}
@Exercise2(hoursPerDay=0) class Sloth2 {}   // startHour=6 по дефолту
//@Exercise2(hoursPerDay=7, startHour="8") // DOES NOT COMPILE, неверный тип
class ZooEmployee2 {}

// Defining a Default Element Value
// the default value of an annotation must be a non- null constant expression.
@interface BadAnnotation {
//    String name() default new String(""); // DOES NOT COMPILE - it is not a constant expression
      String address() default "";
//    String title() default null; // DOES NOT COMPILE
}

// Selecting an Element Type (тип переменной в аннотации)
// It must be a primitive type, a String, a Class, an enum,
// another annotation, or an array of any of these types.

class Bear3 {}
enum Size {SMALL, MEDIUM, LARGE}
@interface Panda {
//    Integer height();   // Integer нельзя
//    String[][] generalInfo(); // 2d array нельзя
    Size size() default Size.SMALL;         // enum ок
    Class piu();          // Class  ок
//    Bear3 friendlyBear();                    //  The type of friendlyBear() is Bear (not Class).
    Exercise2 exercise() default @Exercise2(hoursPerDay=2);  // аннотация ок

    // the new keyword is never used to create an annotation.
}


// Applying Element Modifiers
// Like abstract interface methods, annotation elements are implicitly abstract and public

@interface Material {}  // implicitly public and abstract
@interface Fluffy {
    int cuteness();     // abstract and public
    public abstract int softness() default 11;  // abstract and public
//    protected Material material(); // DOES NOT COMPILE public + protected - нельзя
//    private String friendly(); // DOES NOT COMPILE public + private - нельзя
//    final boolean isBunny(); // DOES NOT COMPILE abstract + final - нельзя
}

// Adding a Constant Variable
// Annotations can include constant variables that can be accessed by other classes (public, static, and final)
// without actually creating the annotation.
@interface ElectricitySource {
    public int voltage();
    int MIN_VOLTAGE = 2;
    public static final int MAX_VOLTAGE = 18;
}
// Yep, just like interface variables, annotation variables are implicitly public, static, and final.


// Reviewing Annotation Rules
@interface Hazard {  // или public или default access
    int danger(); // Required element. Implicitly public and abstract
    public String description() default "Hello"; // Опциональный и дефолтный
    public static final int UNKNOWN = -1; // Constant
}

// декларирование аннотации
@Hazard(danger = 100, description = "Wind damage") // danger - обязательно, description - опционально
    // разделитель - запятая

// Applying Annotations
// Using Annotations in Declarations
//  Can be applied to any Java declaration including the following:
// * Classes, interfaces, enums, and modules
// * Variables (static, instance, local)
// * Methods and constructors
// * Method, constructor, and lambda parameters
// * Cast expressions
// * Other annotations

/*
The following compiles, assuming the annotations referenced in it exist:
@FunctionalInterface interface Speedster {
void go(String name);
}
@LongEars
@Soft @Cuddly public class Rabbit {
@Deprecated public Rabbit(@NotNull Integer size) {}

@Speed(velocity="fast") public void eat(@Edible String input) {
@Food(vegetarian=true) String m = (@Tasty String) "carrots";

Speedster s1 = new @Racer Speedster() {
public void go(@FirstName @NotEmpty String name) {
System.out.print("Start! "+name);
}
};

Speedster s2 = (@Valid String n) -> System.out.print(n);
}
}
 */


// Mixing Required and Optional Elements
// Given the following annotation:
@interface Swimmer {
    int armLength = 10;
    String stroke();
    String name();
    String favoriteStroke() default "Backstroke";
}

// which of the following compile?
//@Swimmer class Amphibian {} // отсутвуют обязательные  stroke() и name()
//@Swimmer(favoriteStroke="Breaststroke", name="Sally") class Tadpole {}  // отсутвуют обязательные  stroke() и name()
@Swimmer(stroke="FrogKick", name="Kermit") class Frog {}        // ok
//@Swimmer(stroke="Butterfly", name="Kip", armLength=1) class Reptile {}    // armLength константа, нельзя переопределять
@Swimmer(stroke="", name="", favoriteStroke="") class Snake {}  // ok

// Creating a value() Element
// the following is valid syntax under the right condition:
@Injured("Broken Tail") class Monkey {}

// An annotation must adhere to the following rules to be used without a name:
// анотация должна содержать элемент value(), который может быть опциональным или обязтельным
// анотация не должна содержать другие элементы, которые обязательные
// использование анотации не должно содержать установку других элементов

// Let's create an annotation that meets these requirements.
@interface Injured {
    String veterinarian() default "unassigned";
    String value() default "foot";      // это ок
    int age() default 1;
}

 abstract class Elephant {
    @Injured("Legs") public void fallDown() {}  // так можно, т.к. выполняются требования
    @Injured(value="Legs") public abstract int trip(); // так можно, т.к. выполняются требования
    @Injured String injuries[];  // тут ок, т.к. value() дефолтная, а других обязательных нет
}


// the following annotation declarations
// cannot be used with a shorthand annotation:
@interface Sleep {  // contains two required elements,
    int value();
    String hours();
}
@interface Wake {  //  does not include an element named value().
    String hours();
}

// @Injured("Fur",age=2) public class Bear {} // DOES NOT COMPILE
// it provides more than one value


// Passing an Array of Values
// provide only one value to the array
@interface Music {
    String[] genres();
}

class Giraffe {
    @Music(genres={"Rock and roll"}) String mostDisliked;   // только одно значение
    @Music(genres="Classical") String favorite;             // {} можно опускать
}

 class Reindeer {
//    @Music(genres="Blues","Jazz") String favorite; // DOES NOT COMPILE - 2 нельзя
//    @Music(genres=) String mostDisliked; // DOES NOT COMPILE - ни одного
//    @Music(genres=null) String other; // DOES NOT COMPILE - null, List, Collection - нельзя
    @Music(genres={}) String alternate;  // это ок, пустой массив
}


// Combining Shorthand Notations
@interface Rhythm {
    String[] value();
}
// Each of the following four annotations is valid:
class Capybara {
    @Rhythm(value={"Swing"}) String favorite;
    @Rhythm(value="R&B") String secondFavorite;
    @Rhythm({"Classical"}) String mostDisliked;
    @Rhythm("Country") String lastDisliked;
}

// Declaring Annotation-Specific Annotations
// Limiting Usage with @Target

//Values for the @Target annotation - limits the types the annotation can be applied to
// ElementType value  : Applies to
/*
TYPE:               Classes, interfaces, enums, annotations
FIELD:              Instance and static variables, enum values
METHOD:             Method declarations
PARAMETER:          Constructor, method, and lambda parameters
CONSTRUCTOR:        Constructor declarations
LOCAL_VARIABLE:     Local variables
ANNOTATION_TYPE:    Annotations
PACKAGE * :         Packages declared in package-info.java
TYPE_PARAMETER * :  Parameterized types, generic declarations
TYPE_USE:           Able to be applied anywhere there is a Java type declared or used
MODULE * :          Modules

* Applying these with annotations is out of scope for the exam.

 */

// Default compiler behavior (if annotation not present)
// Annotation able to be applied to all locations except TYPE_USE and TYPE_PARAMETER

// Consider the following annotation:
/*
import java.lang.annotation.ElementType; // java.lang.annotation package is not import automatically
 */

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@interface ZooAttraction {}

// Based on this annotation, which of the following lines of code will compile
//@ZooAttraction class RollerCoaster {}  // нельзя, аннотация не для класса (ElementType.TYPE)
class Events {
@ZooAttraction String rideTrain() {  // на метод можно нотацию
    return (/*@ZooAttraction*/ String) "Fun!"; // not permitted on a cast operation
    }
@ZooAttraction Events(/*@ZooAttraction*/ String description) { // На конструктор можно.
    //  is not marked for use in a constructor parameter (ElementType.PARAMETER)
        super();
        }
//@ZooAttraction int numPassengers;  // на переменную класса нельзя (ElementType.FIELD)
}

// Understanding the TYPE_USE Value (can be used anywhere there is a Java type)
// There are a few exceptions; for example, it can be used only on a method that returns a value.
// Methods that return void would still need the METHOD value defined in the annotation

// It also allows annotations in places where types are used, such as cast operations, object creation with new,
//inside type declarations, etc. These might seem a little strange at first, but the following are valid TYPE_USE
//applications:

@Target(ElementType.TYPE_USE)
@interface Technical {}

class NetworkRepair {
    class OutSrc extends @Technical NetworkRepair {} // при extend
    public void repair() {
        var repairSubclass = new @Technical NetworkRepair() {}; // при new
        var o = new @Technical NetworkRepair().new @Technical OutSrc();
        int remaining = (@Technical int)10.0;  // при касте
    }
}

// Storing Annotations with @Retention

// Аннотация @Retention позволяет указать жизненный цикл аннотации: будет она присутствовать
// только в исходном коде, в скомпилированном файле, или она будет также видна и в процессе выполнения.
// Выбор нужного типа зависит от того, как вы хотите использовать аннотацию, например,
// генерировать что-то побочное из исходных кодов, или в процессе выполнения стучаться
// к классу через reflection.
/*
RetentionPolicy value    :     Description
SOURCE:     Used only in the source file, discarded by the compiler
CLASS:      Stored in the .class file but not available at runtime
                    (default compiler behavior)
RUNTIME:    Stored in the .class file and available at runtime
 */

// Using it is pretty easy.
@Retention(RetentionPolicy.CLASS) @interface Flier2 {} // Stored in the .class file but not available at runtime
@Retention(RetentionPolicy.RUNTIME) @interface Swimmer2 {} // Stored in the .class file and available at runtime

// Generating Javadoc with @Documented
@Documented @interface Hunter {} // Маркет, не надо параметров
@Hunter class Lion {}
//  the @Hunter annotation would be published with the Lion Javadoc information because it's
// marked with the @Documented annotation.

/*
@deprecated  is a Javadoc annotation used inside a comment
@Deprecated is a Java annotation applied to a class
 */

// inheriting Annotations with @Inherited (маркер)
// When this annotation is applied to a class, subclasses will inherit the
// annotation information found in the parent class.

@Inherited @interface Vertebrate {}

@Vertebrate class Mammal {}

class Dolphin extends Mammal {} // если наследуешь Mammal, то и наследуешь аннотацию @Vertebrate

/*
In this example, the @Vertebrate annotation will be applied to both Mammal and Dolphin objects.
Without the @Inherited annotation, @Vertebrate would apply only to Mammal instances.
 */


// Supporting Duplicates with @Repeatable
// The @Repeatable annotation is used when you want to
// specify an annotation more than once on a type.

// Let's assume we have a repeatable annotation @Risk, which assigns a set of risk values to a zoo animal.
//We'll show how it is used and then work backward to create it.
@Repeatable(Risks.class) // to declare a @Repeatable annotation, you must define a containing annotation type value
    // A containing annotation type is a separate annotation that defines a value() array element.
@interface Risk {
    String danger();
    int level() default 1;
}

@interface Risks {  // . By convention, the name of the annotation is often the plural form of the repeatable annotation
    Risk[] value();
}

class Zoo {
    public static class Monkey {}
    @Risk(danger="Silly")   // without the @Repeatable annotation, an annotation can be applied only once.
    @Risk(danger="Aggressive",level=5)
    @Risk(danger="Violent",level=10)
    private Monkey monkey;
}

// The following summarizes the rules for declaring a repeatable annotation, along with its associated
// containing type annotation:
// * The repeatable annotation must be declared with @Repeatable and contain a value that refers to the
// containing type annotation.
// * The containing type annotation must include an element named value(), which is a primitive array of
// the repeatable annotation type.


// Reviewing Annotation-Specific Annotations
// Надо знать:
// @Target
// @Retention
// @Documented
// @Inherited
// @Repeatable

// Using Common Annotations

// Marking Methods with @Override
/* From your 1Z0-815 studies, you should know that
the overriding method must have the same signature, the same or broader access modifier, and a covariant
return type, and not declare any new or broader checked exceptions. */

// Let's take a look at an example:

interface Intelligence {
    int cunning();
}
class Canine implements Intelligence {
    @Override public int cunning() { return 500; }
    void howl() { System.out.print("Woof!"); }
}
class Wolf extends Canine {
    @Override
    public int cunning() { return Integer.MAX_VALUE; }
    @Override void howl() { System.out.print("Howl!"); }
}
// public class Dog extends Canine {
//    @Override public boolean playFetch() { return true; } // DOES NOT COMPILE - нет такого метода
//    @Override void howl(int timeOfDay) {} // DOES NOT COMPILE - howl не должен ничего принимать (overloaded )
// }




// Declaring Interfaces with @FunctionalInterface (маркер)
@FunctionalInterface interface Intelligence2 {
    int cunning();
}

/*

@FunctionalInterface abstract class Reptile { // нельзя к классу
    abstract String getName();
}

@FunctionalInterface interface Slimy {}  // отсутствует абстрактный метод

@FunctionalInterface interface Scaley {  // ок
    boolean isSnake();
}

@FunctionalInterface interface Rough extends Scaley { // 2 SAM
    void checkType();
}

@FunctionalInterface interface Smooth extends Scaley { // ок 1 SAM
    boolean equals(Object unused);  // этот не учитывается
}

*/


// Retiring Code with @Deprecated
// The @Deprecated annotation can be applied to nearly any Java declaration, such as classes,
// methods, or variables.

/*
@Deprecated(since="1.8", forRemoval=true)
public class ZooPlanner { … }
*/


// Ignoring Warnings with @SuppressWarnings - it requires a String[] value() parameter.
// Common @SuppressWarnings values
// "deprecation" : Ignore warnings related to types or methods marked with the @Deprecated annotation.
// "unchecked"   : Ignore warnings related to the use of raw types, such as List instead of List<String>.
// @SuppressWarnings("deprecation") - игнорирует все

class SongBird {
    @Deprecated static void sing(int volume) {}
    static Object chirp(List<String> data) { return data.size(); }
}
class Nightingale {
    public void wakeUp() {
        SongBird.sing(10);
    }
    public void goToBed() {
        SongBird.chirp(new ArrayList());
    }
    public static void main(String[] args) {
        var birdy = new Nightingale();
        birdy.wakeUp();
        birdy.goToBed();
    }
}

/*
This code compiles and runs but produces two compiler warnings.
Nightingale.java uses or overrides a deprecated API. -
    The first warning is because we are using a method SongBird.sing() that is deprecated.
Nightingale.java uses unchecked or unsafe operations. -
    is triggered by the call to new ArrayList(), which does not define a generic type.
 */


/* Как поправить. Now our code compiles, and no warnings are generated.
 @SuppressWarnings("deprecation") public void wakeUp() {
    SongBird.sing(10);
 }

 @SuppressWarnings("unchecked") public void goToBed() {
    SongBird.chirp(new ArrayList());
 }

 */


// Protecting Arguments with @SafeVarargs
// indicates that a method does not perform any potential unsafe operations on its varargs parameter.
// It can be applied only to constructors or methods that cannot be overridden
//  (ОБЯЗАТЕЛЬНО methods marked private, static, or final).

// In the following example, thisIsUnsafe() performs an unsafe operation using its varargs parameter:

class NeverDoThis {
    @SafeVarargs final int thisIsUnsafe(List<Integer>... carrot) {
        Object[] stick = carrot;
        stick[0] = Arrays.asList("nope!");
        return carrot[0].get(0); // ClassCastException at runtime
        }
public static void main(String[] a) {
        var carrot = new ArrayList<Integer>();
        new NeverDoThis().thisIsUnsafe(carrot);
        }
}

// the following do not compile:
/*
@SafeVarargs
public static void eat(int meal) {} // DOES NOT COMPILE   - не varargs
@SafeVarargs
protected void drink(String… cup) {} // DOES NOT COMPILE        not marked static, final, or private
@SafeVarargs void chew(boolean… food) {} // DOES NOT COMPILE    not marked static, final, or private
 */


// Reviewing Common Annotations
// что нужно знать: @Override, @FunctionalInterface, @Deprecated(не маркер), @SuppressWarnings(не маркер), @SafeVarargs


// какие вызывает ошибки:
/*
@Override - Method signature does not match the signature of an inherited method
@FunctionalInterface - Interface does not contain a single abstract method
@Deprecated -
@SuppressWarnings -
@SafeVarargs - Method or constructor does not contain a varargs parameter or is
    applied to a method not marked private, static, or final
 */





