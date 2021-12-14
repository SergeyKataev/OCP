package Chapter2;

import java.lang.annotation.Documented;

public class C2_Q {
}

class Q2_1 {
/*
 What modifier is used to mark that an annotation element is required?
    A. optional
    B. default
    C. required
    D. *
    E. None of the above (Correct)

    optional element is specified with the default modifie
    the lack of the default term indicates the element is required
 */
}

class Q2_2 {
    // Which of the following lines of code do not compile? (Choose all that apply.)
}

enum Color {GREY, BROWN}
@Documented @interface Dirt {
    boolean wet();  // неявно public abstract, как в интерфейсе
//    String type() = "unknown"; - так не скомпилируется
    String type() default "unknown"; // так ок
    public abstract Color color();  //  тип enam можно, можно String и примитивы
//    private static final int slippery = 5; нельзя private, надо public static final
    public static final int slippery = 5; // так ок - константа
    }

    // A. Line 2
    //B. Line 3
    //C. Line 4
    //D. Line 5 // Correct
    //E. Line 6
    //F. Line 7 // Correct
    //G. All of the lines compile.

class Q2_3 {
    // Which built-in annotations can be applied to an annotation declaration? (Choose all that apply.)
    //A. @Override      // нельзя применить к другим аннотациям, только к методу
    //B. @Deprecated    // Correct
    //C. @Document      // не built-in
    //D. @Target        // Correct
    //E. @Repeatable    // Correct
    //F. @Functional    // не built-in
}

class Q2_4 {
    //  Given an automobile sales system, which of the following information is best stored using an
    // annotation?
    //A. The price of the vehicle
    //B. A list of people who purchased the vehicle
    //C. The sales tax of the vehicle
    //D. The number of passengers a vehicle is rated for (Correct)
            // Количество пассажиров, на которое рассчитано транспортное средство
    //E. The quantity of models in stock

    // Annotations should include metadata (data about data) that is relatively constant, as opposed to
    //attribute data, which is part of the object and can change frequently.
}

class Q2_5 {
    // Which of the following lines of code do not compile? (Choose all that apply.)
    // 1: import java.lang.annotation.*;
    // 2: class Food {}
    // 3: @Inherited public @interface Unexpected {
    // 4: public String rsvp() default null;   // null нельзя. Только Class, enum, String, примитивы, др аннотация
    // 5: Food food();                          // класс нельзя, только Class, enum, String, примитивы, др аннотация
    // 6: public String[] dessert();
    // 7: final int numberOfGuests = 5;
    // 8: long startTime() default 0L;
    // 9: }

    // A. Line 3
    // B. Line 4    // Correct
    // C. Line 5    // Correct
    // D. Line 6
    // E. Line 7
    // F. Line 8
    // G. All of the lines compile.
}

class Q2_6 {
    // Which annotations, when applied independently, allow the following program to compile?
    // (Choose all that apply.)

    // import java.lang.annotation.*;
    // @Documented @Deprecated
    // public @interface Driver {
    // int[] directions();
    // String name() default "";
    // }
    // ________________ class Taxi {}

    // A. @Driver           // не указан обязательный  directions()
    // B. @Driver(1)        // Driver declaration does not contain an element named value().
    // C. @Driver(3,4)      // Driver declaration does not contain an element named value().
    // D. @Driver({5,6})    // Driver declaration does not contain an element named value().
    // E. @Driver(directions=7) // ок - краткая форма на 1 элемент
    // F. @Driver(directions=8,9)   // не ок
    // G. @Driver(directions={0,1}) // ок

    // If directions() were renamed in Driver to value(), then options B and D would be correct.
}

class Q2_7 {
    // Annotations can be applied to which of the following? (Choose all that apply.)
    // A. Class declarations            // Correct
    //  B. Constructor parameters       // Correct
    //C. Local variable declarations    // Correct
    //D. Cast operations                // Correct
    //E. Lambda expression parameters   // Correct
    //F. Interface declarations         // Correct
    //G. None of the above

    // Annotations can be applied to all of the declarations listed.
}

class Q2_8 {
    //  Fill in the blanks with the correct answers that allow the entire program to compile.
    //  (Choose all that apply.)

    // @interface FerociousPack {
    // __________________; // m1
    // }
    // @Repeatable(_________________) // m2
    // public @interface Ferocious {}
    // @Ferocious @Ferocious class Lion {}

    // A. Ferocious value() on line m1.     // скомпилируется, но не Ferocious.
    // B. Ferocious[] value() on line m1.   // Correct массив повторяющейся аннотации value()
    // C. Object[] value() on line m1.      // неверный тип
    // D. @FerociousPack on line m2.
    // E. FerociousPack on line m2.
    // F. FerociousPack.class on line m2.   // Correct класс повторяющейся аннотации
    // G. None of the above. The code will not compile due to its use of the Lion class.

    //  Ferocious is the repeatable annotation
    //  FerociousPack is the containing type annotation
    //  (should contain a single value() array of the repeatable annotation type.)
}

class Q2_9 {
    // What properties must be true to use an annotation with an element value, but no element name?
    // (Choose all that apply.)

    // A. The element must be named values().   // value, а не values
    // B. The element must be required.         // Не обязательно, может быть дефолтным
    // C. The annotation declaration must not contain any other elements.   // может содержать,
    //          но должны быть дефолтными
    // D. The annotation must not contain any other values.                 // Correct
    // E. The element value must not be array.                              // Может быть array
    // F. None of the above
}

class Q2_10 {
    // Which statement about the following code is correct?

    // import java.lang.annotation.*;
    // @Target(ElementType.TYPE) public @interface Furry {  // Class, enum, interface, annotation
    // public String[] value();         // ок
    // boolean cute() default true;     // ок
    // }
    // class Bunny {
    // @Furry("Soft") public static int hop() { // нельзя к методу (ElementType.METHOD)
    // return 1;
    // }
    // }


    // A. The code compiles without any changes.
    // B. The code compiles only if the type of value() is changed to a String in the annotation
    // declaration. // Можно String[]
    // C. The code compiles only if cute() is removed from the annotation declaration.
    // D. The code compiles only if @Furry includes a value for cute().
    // E. The code compiles only if @Furry includes the element name for value.
    // F. The code compiles only if the value in @Furry is changed to an array.
    // G. None of the above     // Correct
}

class Q2_11 {
    // 11. What properties of applying @SafeVarargs are correct?
    // (Choose all that apply.)

    // A. By applying the annotation, the compiler verifies that all operations on parameters are safe. // нет
    // B. The annotation can be applied to abstract methods.    // нет, должен быть final
    // C. The annotation can be applied to method and constructor declarations. // Correct
    // D. When the annotation is applied to a method, the method must contain a varargs parameter.  // Correct
    // E. The annotation can be applied to method and constructor parameters.    // только к методу, не параметру
    // F. The annotation can be applied to static methods.                      // Correct

    // (ОБЯЗАТЕЛЬНО methods marked private, static, or final).
    // @SafeVarargs annotation can be applied to a constructor or private, static, or final
    // method that includes a varargs parameter
}

class Q2_12 {
    // Which of the following lines of code do not compile? (Choose all that apply.)

    // 1: import java.lang.annotation.*;
    // 2: enum UnitOfTemp { C, F }
    // 3: @interface Snow { boolean value(); }
    // 4: @Target(ElementType.METHOD) public @interface Cold {
    // 5: private Cold() {}  // Annotations cannot have constructors, so line 5 does not compile. pulic, abstract
    // 6: int temperature;  // так нельзя. если было бы значение - то ок. Константа int temperature = 5;
    // 7: UnitOfTemp unit default UnitOfTemp.C;  // missing parentheses  unit()
    // 8: Snow snow() default @Snow(true);  // ok
    // 9: }

    // A. Line 4
    // B. Line 5    // Correct
    // C. Line 6    // Correct
    // D. Line 7    // Correct
    // E. Line 8
    // F. All of the lines compile.
}

class Q2_13 {
    // Which statements about an optional annotation are correct? (Choose all that apply.)

    // A. The annotation declaration always includes a default value.
    // B. The annotation declaration may include a default value.   // Correct
    // C. The annotation always includes a value.
    // D. The annotation may include a value.                       // Correct
    // E. The annotation must not include a value.
    // F. None of the above
}

class Q2_14 {
//  Fill in the blanks:
//  The ____________ annotation determines whether annotations are discarded at
//  runtime, while the _______________ annotation determines whether they are discarded in generated
//  Javadoc.

//  A. @Target, @Deprecated
//  B. @Discard, @SuppressWarnings
//  C. @Retention, @Generated
//  D. @Retention, @Documented      // Correct
//  E. @Inherited, @Retention
//  F. @Target, @Repeatable
//  G. None of the above

// Storing Annotations with @Retention
// Аннотация @Retention позволяет указать жизненный цикл аннотации: будет она присутствовать
// только в исходном коде, в скомпилированном файле, или она будет также видна и в процессе выполнения.
// Выбор нужного типа зависит от того, как вы хотите использовать аннотацию, например,
// генерировать что-то побочное из исходных кодов, или в процессе выполнения стучаться
// к классу через reflection.

// RetentionPolicy value    :     Description
// SOURCE:     Used only in the source file, discarded by the compiler
// CLASS:      Stored in the .class file but not available at runtime
//                     (default compiler behavior)
// RUNTIME:    Stored in the .class file and available at runtime


// Generating Javadoc with @Documented.
// @Documented annotation determines whether annotations are discarded within generated Javadoc.

// @Documented @interface Hunter {} // Маркет, не надо параметров
// @Hunter class Lion {}
// the @Hunter annotation would be published with the Lion Javadoc information because it's
// marked with the @Documented annotation.
}

class Q2_15 {
    // What statement about marker annotations is correct?

    // A. A marker annotation does not contain any elements or constant variables.
    // B. A marker annotation does not contain any elements but may contain constant variables. // Correct
    // C. A marker annotation does not contain any required elements but may include optional elements.
    // D. A marker annotation does not contain any optional elements but may include required elements.
    // E. A marker annotation can be extended.

    // A marker annotation is an annotation with no elements.
    // Annotation can be extended.
}

class Q2_16 {
    // Which options, when inserted into the blank in the code, allow the code to compile without any
    // warnings? (Choose all that apply.)

    // import java.util.*;
    // import java.lang.annotation.*;
    // public class Donkey {
    // ________________________
    // public String kick(List… t) {
    // t[0] = new ArrayList();
    // t[0].add(1);
    // return (String)t[0].get(0);
    // }
    // }

    // A. @SafeVarargs - не влияет на ворнинги
    // B. @SafeVarargs("unchecked") // не влияет на ворнинги
    // C. @Inherited           // можно применить только к аннотации
    // D. @SuppressWarnings    // нужен параметр у этой аннотации
    // E. @SuppressWarnings("ignore")       // нет такого параметра
    // F. @SuppressWarnings("unchecked")    // Correct
    // G. None of the above

    // Protecting Arguments with @SafeVarargs
    // indicates that a method does not perform any potential unsafe operations on its varargs parameter.
    // It can be applied only to constructors or methods that cannot be overridden
    //  (ОБЯЗАТЕЛЬНО methods marked private, static, or final).

    // Ignoring Warnings with @SuppressWarnings - it requires a String[] value() parameter.
    // Common @SuppressWarnings values
    // "deprecation" : Ignore warnings related to types or methods marked with the @Deprecated annotation.
    // "unchecked"   : Ignore warnings related to the use of raw types, such as List instead of List<String>.
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
}


class Q2_17 {
    // What motivations would a developer have for applying the @FunctionalInterface annotation to an
    // interface? (Choose all that apply.)

    // A. To allow the interface to be used in a lambda expression
    // B. To provide documentation to other developers                  // Correct
    // C. To allow the interface to be used as a method reference
    // D. There is no reason to use this annotation.
    // E. To trigger a compiler error if the annotation is used incorrectly // Correct
}

class Q2_18 {
    // Which of the following lines of code do not compile? (Choose all that apply.)

    // 1: @interface Strong {
    // 2: int force(); }
    // 3: @interface Wind {
    // 4: public static final int temperature = 20;
    // 5: Boolean storm() default true;  // только Class, enum, String, примитивы, аннотации (или массив этих типов)
    // 6: public void kiteFlying();      // void лишнее
    // 7: protected String gusts();      // тут только public/abstract
    // 8: Strong power() default @Strong(10); // Strong annotation does not contain a value(), краткую форму нельзя
            //  If line 2 were changed from force() to value(), then line 8 would compile.
    // 9: }

    // A. Line 2
    // B. Line 4
    // C. Line 5    // Correct
    // D. Line 6    // Correct
    // E. Line 7    // Correct
    // F. Line 8
    // G. All of the lines compile.
}

class Q2_19 {
    // Which annotations can be added to an existing method declaration but could cause a compiler error
    // depending on the method signature? (Choose all that apply.)

    //A. @Override              // Correct
    //B. @Deprecated
    //C. @FunctionalInterface   // Cannot be applied to methods
    //D. @Repeatable            // Cannot be applied to methods
    //E. @Retention             // Cannot be applied to methods позволяет указать жизненный цикл аннотации
    //F. @SafeVarargs           // Correct

    // @SafeVarargs can be applied to a method but
    // will trigger a compiler error if the method does not contain a varargs parameter or is able to be
    // overridden (not marked private, static, or final).
}

class Q2_20 {
    // Given the Floats annotation declaration, which lines in the Birch class contain compiler errors?
    // (Choose all that apply.)

    // Floats.java
    // import java.lang.annotation.*;
    // @Target(ElementType.TYPE_USE)
    // public @interface Floats {
    // int buoyancy() default 2;
    // }

    // Birch.java
    // 1: import java.util.function.Predicate;
    // 2: interface Wood {}
    // 3: @Floats class Duck {}
    // 4: @Floats
    // 5: public class Birch implements @Floats Wood {
    // 6: @Floats(10) boolean mill() {          // нельзя не value()
    // 7: Predicate<Integer> t = (@Floats Integer a) -> a> 10;
    // 8: return (@Floats) t.test(12);          // нельзя кастовать к аннотации
    // 9: } }

    // A. Line 3
    // B. Line 4
    // C. Line 5
    // D. Line 6    // Correct
    // E. Line 7
    // F. Line 8    // Correct
    // G. None of the above. All of the lines compile without issue.
}

class Q2_21 {
    // Fill in the blanks: The ______________ annotation determines what annotations from a superclass or
    // interface are applied, while the _________________ annotation determines what declarations an
    // annotation can be applied to.

    // A. @Target, @Retention
    // B. @Inherited, @ElementType
    // C. @Documented, @Deprecated
    // D. @Target, @Generated
    // E. @Repeatable, @Element
    // F. @Inherited, @Retention
    // G. None of the above        // Correct

    // The @Inherited annotation determines whether or not annotations defined in a super type are
    // automatically inherited in a child type.
    // The @Target annotation determines the location or locations an annotation can be applied to.

    // Note that ElementType is an enum used by @Target, but it is not an annotation.
}

class Q2_22 {
    // 22. Which annotation can cancel out a warning on a method using the @Deprecated API at compile time?

    // A. @FunctionalInterface
    // B. @Ignore
    // C. @IgnoreDeprecated
    // D. @Retention
    // E. @SafeVarargs
    // F. @SuppressWarnings // Correct
    // G. None of the above

    // If @SuppressWarnings("deprecation") is applied to a method that is using a deprecated API,
    // then warnings related to the usage will not be shown at compile time

    // "deprecation" : Ignore warnings related to types or methods marked with the @Deprecated annotation.
}

class Q2_23 {
    // The main() method in the following program reads the annotation value() of Plumber at runtime on
    // each member of Team. It compiles and runs without any errors. Based on this, how many times is
    // Mario printed at runtime?

    // import java.lang.annotation.*;
    // import java.lang.reflect.Field;
    // @interface Plumber {
    // String value() default "Mario";
    // }
    // public class Team {
    // @Plumber("") private String foreman = "Mario"; // тут ""
    // @Plumber private String worker = "Kelly";        // тут Mario
    // @Plumber("Kelly") private String trainee;        // тут Kelly
    // public static void main(String[] args) {
    // var t = new Team();
    // var fields = t.getClass().getDeclaredFields();
    // for (Field field : fields)
    // if(field.isAnnotationPresent(Plumber.class))
    // System.out.print(field.getAnnotation(Plumber.class)
    // .value());
    // }
    // }

    // A. Zero // Correct
    // B. One
    // C. Two
    // D. Three
    // E. The answer cannot be determined until runtime.

    // The default retention policy for all annotations is RetentionPolicy.CLASS if
    // not explicitly stated otherwise. This means the annotation information is discarded at compile time
    // and not available at runtime.

    // If @Retention(RetentionPolicy.RUNTIME) were added to the declaration of Plumber, then the
    // worker member would cause the default annotation value(), Mario, to be printed at runtime, and
    // option B would be the correct answer.
}

class Q2_24 {
    // Which annotations, when applied independently, allow the following program to compile?
    // (Choose all that apply.)

    // public @interface Dance {
    // long rhythm() default 66;
    // int[] value();
    // String track() default "";
    // final boolean fast = true;
    // }
    // class Sing {
    // ____________________ String album;
    // }

    // A. @Dance(77)    // Correct
    // B. @Dance(33, 10)    // нельзя, так можно @Dance({33, 10})
    // C. @Dance(value=5, rhythm=2, fast=false) // нельзя переопределять константу
    // D. @Dance(5, rhythm=9)   // нельзя
    // E. @Dance(value=5, rhythm=2, track="Samba") // ок, value=5
    // F. @Dance()  // не определено value
    // G. None of the above
}

class Q2_25 {
    // When using the @Deprecated annotation, what other annotation should be used and why?
    // A. @repeatable, along with a containing type annotation
    // B. @retention, along with a location where the value should be discarded
    // C. @deprecated, along with a reason why and a suggested alternative  // Correct
    // D. @SuppressWarnings, along with a cause
    // E. @Override, along with an inherited reference

    // The Javadoc @deprecated annotation should be used, which provides a reason for the deprecation
    // and suggests an alternative.
}




