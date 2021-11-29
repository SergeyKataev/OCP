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
        Movie.Popcorn in = new Movie().new Popcorn();  // так можно определять, даже если конструктор приватный
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

