package Chapter7;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MethodsAndEncapsulation {
}

class AccessModifierEx {
    public void walk11() {
    }

    //    default void walk2() {} // DOES NOT COMPILE - default не используется как модификатор доступа
    void walk22() {
    }

    //    void public walk3() {} // DOES NOT COMPILE - return type не может быть перед модификатором доступа
    public void walk33() {
    }

    void walk44() {
    }


    //

    public void walk1() {
    }

    public final void walk2() {
    }

    public static final void walk3() {
    }

    public final static void walk4() {
    }

    //    public modifier void walk5() {} // DOES NOT COMPILE - modifier такого резервного слова нет
//    public void final walk6() {} // DOES NOT COMPILE - final может быть между public и void
    static public void walk7() {
    }        // опциональные модификаторы могут быть перед доступом


}

class ReturnTypeEx {
    public void walk1() {
    }

    public void walk2() {
        return;
    }

    public String walk3() {
        return "";
    }
//    public String walk4() {} // DOES NOT COMPILE - нет return
//    public walk5() {} // DOES NOT COMPILE - нет void
//    public String int walk6() { } // DOES NOT COMPILE - 2 возвращаемых типа
//    String walk7(int a) { if (a == 4) return ""; } // DOES NOT COMPILE - если else, то что возвращать? Компилятор ругаестся

    int integer() {
        return 9;
    }
//    int longMethod() {
//        return 9L; // DOES NOT COMPILE
//    }

    int integerExpanded() {
        int temp = 9;
        return temp;
    }
//    int longExpanded() {
//        int temp = 9L; // DOES NOT COMPILE
//        return temp;
//    }
}

class MethodNameEx {
    // an identifier may only contain letters, numbers, $, or _.
    // the first character is not allowed to be a number, and reserved words are not allowed.
    // the single underscore character is not allowed.
    public void walk1() {
    }

    //    public void 2walk() {} // DOES NOT COMPILE
//    public walk3 void() {} // DOES NOT COMPILE - название метода перед возвращаемым типов
    public void Walk_$() {
    }
//    public _() {} // DOES NOT COMPILE
//    public void() {} // DOES NOT COMPILE
}

class ParameterListEx {
    public void walk1() {
    }

    //    public void walk2 {} // DOES NOT COMPILE  - отсутствует лист переменных
    public void walk3(int a) {
    }

    //    public void walk4(int a; int b) {} // DOES NOT COMPILE - ;
    public void walk5(int a, int b) {
    }
}

class OptionalExceptionListEx {
    public void zeroExceptions() {
    }

    public void oneException() throws IllegalArgumentException {
    }

    public void twoExceptions() throws
            IllegalArgumentException, InterruptedException {
    }
}

class WorkingWithVarargs {
    public void walk1(int... nums) {
    }

    public void walk2(int start, int... nums) {
    }
//    public void walk3(int... nums, int start) {} // DOES NOT COMPILE
//    public void walk4(int... start, int... nums) {} // DOES NOT COMPILE




    public static void walk(int start, int... nums) {
        System.out.println(nums.length);
    }

    public static void main(String[] args) {
        walk(1); // 0
        walk(1, 2); // 1
        walk(1, 2, 3); // 2
        walk(1, new int[]{4, 5}); // 2
    }
}

// Static examples
class Koala {
    public static int count = 0; // static variable
    public static void main(String[] args) { // static method
        System.out.println(count);       // 0
        System.out.println();


        Koala k = new Koala();
        System.out.println(k.count); // k is a Koala            // 0
        k = null;
        System.out.println(k.count); // k is still a Koala      // 0
        System.out.println();

        Koala.count = 4;
        Koala koala1 = new Koala();
        Koala koala2 = new Koala();
        koala1.count = 6;
        koala2.count = 5;
        System.out.println(Koala.count);    // 5

    }
}
        // A static member cannot call an instance member without referencing an instance of the class.
        class StaticVsInstance {
            private String name = "Static class";
            public static void first() { }
            public static void second() { }
            public void third() { System.out.println(name); }
            public static void main(String args[]) {
                first();
                second();
//                third(); // DOES NOT COMPILE - это метод не статичный
                new StaticVsInstance().third(); // - так можно
            }
        }





 class Gorilla {
    public static int count;
    public static void addGorilla() { count++; }
    public void babyGorilla() { count++; }
    public void announceBabies() {          // обычный метод может вызывать обычный и статичный метод
        addGorilla();
        babyGorilla();
        }
    public static void announceBabiesToEveryone() {
            addGorilla();
    //        babyGorilla(); // DOES NOT COMPILE    // статичный метод не может вызывать нестатичный метод
            }
    public int total;
    //public static double average = total / count; // DOES NOT COMPILE  // статичная переменная не может ссылаться на настатичую переменную
}

// использование статик переменной
class Counter {
    private static int count;
    public Counter() { count++; }
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        System.out.println(count); // 3
    }
}

// константа
class Initializers {
    private static final int NUM_BUCKETS = 45;
    private static final ArrayList<String> values = new ArrayList<>();

    public static void main(String[] args) {
//        NUM_BUCKETS = 5; // DOES NOT COMPILE
        values.add("changed");  // values - ссылка, поэтому норм скомпилируется
    }
}

// Static Initialization
// static keyword to specify they should be run when the class is first loaded.

class StaticBlockEx {
    private static final int NUM_SECONDS_PER_MINUTE;
    private static final int NUM_MINUTES_PER_HOUR;
    private static final int NUM_SECONDS_PER_HOUR;
    static {
        NUM_SECONDS_PER_MINUTE = 60;
        NUM_MINUTES_PER_HOUR = 60;
    }
    static {
        NUM_SECONDS_PER_HOUR
                = NUM_SECONDS_PER_MINUTE * NUM_MINUTES_PER_HOUR;
    }
}

class StaticBlockEx2{
    private static int one;
    private static final int two;
    private static final int three = 3;
//    private static final int four; // DOES NOT COMPILE - не заасайнили значение
    static {
        one = 1;
        two = 2;
//        three = 3; // DOES NOT COMPILE  - асайним второй раз
//        two = 4; // DOES NOT COMPILE      - асайним второй раз
        }
}

class StaticImportEx {
    /*
    import static java.util.Arrays; // DOES NOT COMPILE  - это не статичный метод/переменная, а класс
    import static java.util.Arrays.asList;
    static import java.util.Arrays.*; // DOES NOT COMPILE - static import
    public class BadStaticImports {
        public static void main(String[] args) {
        Arrays.asList("one"); // DOES NOT COMPILE   - мы не импортировали java.util.Arrays, будет ошибка компиляции
    } }

    // одинаковые имена статических переменных нельзя импортировать через статик
    import static statics.A.TYPE;
    import static statics.B.TYPE; // DOES NOT COMPILE
     */
}

class PassingDataAmongMethods {
    public static void main(String[] args) {
        int num = 4;
        newNumber(num);
        System.out.println(num); // 4
        }
public static void newNumber(int num) {
        num = 8;        // это изменение останется внутри метода
    }

}
class PassingDataAmongMethods2 {
    public static void main(String[] args) {
        String name = "Webby";
        speak(name);
        System.out.println(name); // "Webby"
    }
    public static void speak(String name) {
        name = "Sparky";
    }
}

class PassingDataAmongMethods3 {  // SgtringBuilder возвращает ссылку
    public static void main(String[] args) {
        StringBuilder name = new StringBuilder();
        speak(name);
        System.out.println(name); // Webby
    }
    public static void speak(StringBuilder s) {
        s.append("Webby");
    }
}



class ReturningValues {
public static void main(String[] args) {
        int number = 1; // number=1
        String letters = "abc"; //  letters=abc
    number(number); // number=1
    letters = letters(letters); // letters=abcd
    System.out.println(number + letters); // 1abcd
    }
public static int number(int number) {
        number++;
        return number;
        }
public static String letters(String letters) {
        letters += "d";
        return letters;
        }
}


// `OverLoading
class OverloadingEx {
    // These are all valid overloaded methods:
    public void fly(int numMiles) {}
    public void fly(short numFeet) {}
    public boolean fly() { return false; }
    void fly(int numMiles, short numFeet) {}
    public void fly(short numFeet, int numMiles) throws Exception {}

}

class OverloadingEx2 {
    // Now let’s look at an example that is not valid overloading:
    //public int fly(int numMiles) {} // DOES NOT COMPILE - для перегрузки нельзя отличаться только возвращаемым типом
    public void fly(int numMiles) {}
}

class OverloadingEx3 {
    public void fly(int[] lengths) {}
//    public void fly(int... lengths) {} // DOES NOT COMPILE
}

// Autoboxing

class AutoboxingEx {
    public void fly(int numMiles) {}
    public void fly(Integer numMiles) {}

    public static void main(String[] args) {
        // если будет fly(3) - то вызовется int numMiles
        // если (int numMiles) не будет, то вызовется (Integer numMiles)
    }
}

class ReferenceTypes {
    public void fly(String s) {
        System.out.print("string");
    }
    public void fly(Object o) {
        System.out.print("object");
    }
    public static void main(String[] args) {
        ReferenceTypes r = new ReferenceTypes();
        r.fly("test");   // string
        System.out.print("-");
        r.fly(56);  // object  int->Integer->Object
    }
}

class AutoboxingEx2 {
    public static void print(Iterable i) {
        System.out.print("I");
    }
    public static void print(CharSequence c) {
        System.out.print("C");
    }
    public static void print(Object o) {
        System.out.print("O");
    }
    public static void main(String[] args){
        print("abc");   // "C"  String implement CharSequence
        print(new ArrayList<>());   // "I"  ArrayList implement Iterable
        print(LocalDate.of(2019, Month.JULY, 4));  // "O"  LocalDate -> Object
    }
}

// primitive in methods
class Plane {
    public void fly(int i) {
        System.out.print("int");
    }
    public void fly(long l) {
        System.out.print("long");
    }
    public static void main(String[] args) {
        Plane p = new Plane();
        p.fly(123); // int
        System.out.print("-");
        p.fly(123L);    // long
    }
}

class Plane2 {
    public void fly(long l) {
        System.out.print("long");
    }
    public static void main(String[] args) {
        Plane2 p = new Plane2();
        p.fly(123); // long - инт может вызвать метод с большим значением (даже long и double). В меньшую сторону не работает
        System.out.print("-");
        p.fly(123L);    // long
    }
}

// Generics
class GenericsEx {
    public void walk(List<String> strings) {}
    // public void walk(List<Integer> integers) {} // DOES NOT COMPILE

    // Дженерики затираются и при компиляции будет следующий код:
    // public void walk(List strings) {}
    // public void walk(List integers) {} // DOES NOT COMPILE
}

// Arrays
class ArraysEx {
    // тут все норм. Это будет перегрузка
    public static void walk(int[] ints) {}
    public static void walk(Integer[] integers) {}
}


class Glider2 {
    public static String glide(String s) {
        return "1";
    }
    public static String glide(String... s) {
        return "2";
    }
    public static String glide(Object o) {
        return "3";
    }
    public static String glide(String s, String t) {
        return "4";
    }
    public static void main(String[] args) {
        System.out.print(glide("a"));           // 1
        System.out.print(glide("a", "b"));    // 4
        System.out.print(glide("a", "b", "c")); // 2
    }
}

class TooManyConversions {
    public static void play(Long l) {}
    public static void play(Long... l) {}


    public static void main(String[] args) {
//        play(4); // DOES NOT COMPILE  int можно только в long. Или int в Integer. int в Long нельзя. Если был бы (Long l) , то скомпилировалось
        play(4L); // calls the Long version
    }
}

// Encapsulating Data
