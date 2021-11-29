package Chapter6;

import java.util.List;

public class Q {
}

class Q1 {
    // What is the result of the following class?
    // 1: import java.util.function.*;
    // 2:
    // 3: public class Panda {
    // 4: int age;
    // 5: public static void main(String[] args) {
    // 6: Panda p1 = new Panda();
    // 7: p1.age = 1;
    // 8: check(p1, p -> p.age < 5);
    // 9: }
    // 10: private static void check(Panda panda,
    // 11: Predicate<Panda> pred) {
    // 12: String result =
    // 13: pred.test(panda) ? "match" : "not match";
    // 14: System.out.print(result);
    // 15: } }
    // A. match                             // Correct
    // B. not match
    // C. Compiler error on line 8.
    // D. Compiler error on lines 10 and 11.
    // E. Compiler error on lines 12 and 13.
    // F. A runtime exception is thrown.
}

interface Climb {
    boolean isTooHigh(int height, int limit);
}

class Q2 {
    // What is the result of the following code?

    public static void main(String[] args) {
        //check((h, m) -> h.append(m).isEmpty(), 5);  // тип неподходит для append
    }

    private static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10))
            System.out.println("too high");
        else
            System.out.println("ok");
    }
}

// A. ok
// B. too high
// C. Compiler error on line 7.             // Correct
// D. Compiler error on line 10.
// E. Compiler error on a different line.
// F. A runtime exception is thrown.

class Q3 {
    // Which of the following lambda expressions can fill in the blank? (Choose all that apply.)
    // List<String> list = new ArrayList<>();
    // list.removeIf(___________________);
    // A. s -> s.isEmpty()              // Correct
    // B. s -> {s.isEmpty()}            // если {}, то надо return и ;
    // C. s -> {s.isEmpty();}           // если {}, то надо return и ;
    // D. s -> {return s.isEmpty();}    // Correct
    // E. String s -> s.isEmpty()       // Если указали тип, то нужны ()
    // F. (String s) -> s.isEmpty()     // Correct
}

class Q4{
    // Which lambda can replace the MySecret class to return the same value? (Choose all that apply.)
    // interface Secret {
    // String magic(double d);
    // }
    // class MySecret implements Secret {
    // public String magic(double d) {
    // return "Poof";
    // }
    // }

    // A. (e) -> "Poof"                             // Correct
    // B. (e) -> {"Poof"}                           // нет return и ;
    // C. (e) -> { String e = ""; "Poof" }          // переназначается е
    // D. (e) -> { String e = ""; return "Poof"; }  // переназначается е
    // E. (e) -> { String e = ""; return "Poof" }   // переназначается е
    // F. (e) -> { String f = ""; return "Poof"; }  // Correct
}

class Q5{
    // Which of the following lambda expressions can be passed to a function of Predicate<String> type? (Choose all that apply.)
    //A. () -> s.isEmpty()          - мало параметров, ожидается 1
    //B. s -> s.isEmpty()           // Correct
    //C. String s -> s.isEmpty()
    //D. (String s) -> s.isEmpty()  // Correct
    //E. (s1) -> s.isEmpty()
    //F. (s1, s2) -> s1.isEmpty()   - много параметров, ожидается 1
}

class Q6 {
    // Which of these statements is true about the following code?

    //public void method() {
    // x((var x) -> {}, (var x, var y) -> 0);
    // }
    // public void x(Consumer<String> x, Comparator<Boolean> y)
    // {
    // }

    //A. The code does not compile because of one of the variables named x.
    //B. The code does not compile because of one of the variables named y.
    //C. The code does not compile for another reason.
    //D. The code compiles, and the var in each lambda refers to the same type.
    //E. The code compiles, and the var in each lambda refers to a different type.      // Correct
}

class Q7 {
    // Which of the following will compile when filling in the blank? (Choose all that apply.)
    // List list = List.of(1, 2, 3);
    // Set set = Set.of(1, 2, 3);
    // Map map = Map.of(1, 2, 3, 4);
    // __________.forEach(x -> System.out.println(x));

    // A. list  // Correct
    // B. set   // Correct
    // C. map       - у map нет forEach
    // D. map.keys()
    // E. map.keySet()  // Correct
    // F. map.values()  // Correct
    // G. map.valueSet()
}

class Q8 {
    // Which statements are true?
    // A. The Consumer interface is best for printing out an existing value.    // Correct
    // B. The Supplier interface is best for printing out an existing value.    - нет. Supplier отдает значение
    // C. The Comparator interface returns an int.                              // Correct
    // D. The Predicate interface returns an int.                               - Predicate возвращает boolean
    // E. The Comparator interface has a method named test().                   - у компоратора метод compareTo
    // F. The Predicate interface has a method named test().                    // Correct
}

class Q9 {
    private static Object List;
    // Which of the following can be inserted without causing a compilation error? (Choose all that apply.)

    public static void main(String[] args) {

    }


        public void remove (java.util.List< Character > chars) {
            char end = 'z';
            chars.removeIf(c -> {
                char start = 'a';
                return start <= c && c <= end;
            });
        }

    // A. char start = 'a';  // Correct - менять переменные в самой лямбда можно
    // B. char c = 'x';     // Correct Можно менять
    // C. chars = null;     // нельзя менять значение, т.к. оно в методе лямбды. Нельзя менять локальные переменные метода и параметры метода
    // D. end = '1';        // нельзя менять значение, т.к. оно в методе лямбды. Нельзя менять локальные переменные метода и параметры метода
    // E. None of the above
}

class Q10{
    // How many lines does this code output?
    // Set<String> set = Set.of("mickey", "minnie");
    // List<String> list = new ArrayList<>(set);
    // set.forEach(s -> System.out.println(s));
    // list.forEach(s -> System.out.println(s));
    // A. 0
    // B. 2
    // C. 4                         // Correct
    // D. The code does not compile.
    // E. A runtime exception is thrown.
}

class Q11{
    // What is the output of the following code?
    // List<String> cats = new ArrayList<>();
    // cats.add("leo");
    // cats.add("Olivia");
    // cats.sort((c1, c2) -> -c1.compareTo(c2)); // line X
    // System.out.println(cats);

    // A. [leo, Olivia]                 // Correct - UpperCase всегда впереди lowerCase. А тут обратный порядок
    // B. [Olivia, leo]
    // C. The code does not compile because of line X.
    // D. The code does not compile for another reason.
    // E. A runtime exception is thrown.
}

class Q12 {
    // Which pieces of code can fill in the blanks? (Choose all that apply.)
    // ______________ first = () -> Set.of(1.23);  - тут должен быть Supplier
    // ______________ second = x -> true;          - тут Predicate
    // A. Consumer<Set<Double>>
    // B. Consumer<Set<Float>>
    // C. Predicate<Set<Double>>        // Correct
    // D. Predicate<Set<Float>>         // Correct
    // E. Supplier<Set<Double>>         // Correct
    // F. Supplier<Set<Float>>          // не подойдет, т.к. внутри 1.23 это double
}

class Q13 {
    // Which is true of the following code?
    // int length = 3;
    // for (int i = 0; i<3; i++) {
    // if (i%2 == 0) {
    // Supplier<Integer> supplier = () -> length; // A
    // System.out.println(supplier.get()); // B
    // } else {
    // int j = i;                                       - effectively final
    // Supplier<Integer> supplier = () -> j; // C
    // System.out.println(supplier.get()); // D      - у Supplier метод .get
    // }
    // }

    //A. The first compiler error is on line A.
    //B. The first compiler error is on line B.
    //C. The first compiler error is on line C.
    //D. The first compiler error is on line D.
    //E. The code compiles successfully.        // Correct
}

class Q14{
    // Which of the following can be inserted without causing a compilation error? (Choose all that apply.)
    // public void remove(List<Character> chars) {
    // char end = 'z';
    // // INSERT LINE HERE
    // chars.removeIf(c -> {
    // char start = 'a'; return start <= c && c <= end; });
    // }

    // A. char start = 'a';     // такая же переменная - нельзя
    // B. char c = 'x';         // с - нельзя переопределять
    // C. chars = null;         // Correct - но выбросит ошибку в рантайме
    // D. end = '1';            // нельзя менять параметры метода и класса
    // E. None of the above
}

class Q15 {
    // What is the output of the following code?
    // Set<String> cats = new HashSet<>();
    // cats.add("leo");
    // cats.add("Olivia");
    // cats.sort((c1, c2) -> -c1.compareTo(c2)); // line X Set - неупорядоченная коллекция, метода sort нет
    // System.out.println(cats);

    // A. [leo, Olivia]
    // B. [Olivia, leo]
    // C. The code does not compile because of line X.
    // D. The code does not compile for another reason.
    // E. A runtime exception is thrown.
}

class Q16 {
    // Which variables are effectively final? (Choose all that apply.)
// Method parameters and local variables are effectively final if they aren’t changed after initialization


    // public void isIt(String param1, String param2) {
    // String local1 = param1 + param2;
    // String local2 = param1 + param2;
    // param1 = null;
    // local2 = null;
    // }

    // A. local1    // Correct
    // B. local2
    // C. param1
    // D. param2    // Correct
    // E. None of the above
}

class Q17 {
    // What is the result of the following class?
    // 1: import java.util.function.*;
    // 2:
    // 3: public class Panda {
    // 4: int age;
    // 5: public static void main(String[] args) {
    // 6: Panda p1 = new Panda();
    // 7: p1.age = 1;
    // 8: check(p1, p -> {p.age < 5});          // если есть {}, значит должен быть return и ;
    // 9: }
    // 10: private static void check(Panda panda,
    // 11: Predicate<Panda> pred) {
    // 12: String result = pred.test(panda)
    // 13: ? "match" : "not match";
    // 14: System.out.print(result);
    // 15: } }
    // A. match
    // B. not match
    // C. Compiler error on line 8.         // Correct
    // D. Compiler error on line 10.
    // E. Compile error on line 12.
    // F. A runtime exception is thrown.
}

class Q18 {
    // Lambda parameters are not allowed to use the same name as another variable in the same scope.

    // How many lines does this code output?
    // Set<String> s = Set.of("mickey", "minnie");
    // List<String> x = new ArrayList<>(s);
    // s.forEach(s -> System.out.println(s));
    // x.forEach(x -> System.out.println(x));

    //A. 0
    //B. 2
    //C. 4
    //D. The code does not compile.
    //E. A runtime exception is thrown.

    public static void main(String[] args) {
        List<String> l = List.of("mickey", "minnie");
        // l.forEach(l -> System.out.println(l)); так нельзя
    }
}

class Q19 {
    // Which lambda can replace the MySecret class? (Choose all that apply.)
    // interface Secret {
    // String concat(String a, String b);
    // }
    // class MySecret implements Secret {
    // public String concat(String a, String b) {
    // return a + b;
    // }
    // }
    // A. (a, b) -> a + b                   // Correct
    // B. (String a, b) -> a + b            - так нельзя объявлять переменные в лямбде
    // C. (String a, String b) -> a + b     // Correct
    // D. (a, b) , a + b
    // E. (String a, b) , a + b
    // F. (String a, String b) , a + b
}

class Q20 {
    // Which of the following lambda expressions can be passed to a function of Predicate<String> type? (Choose all that apply.)
    // A. s -> s.isEmpty()          // Correct
    // B. s --> s.isEmpty()
    // C. (String s) -> s.isEmpty() // Correct
    // D. (String s) --> s.isEmpty()
    // E. (StringBuilder s) -> s.isEmpty()
    // F. (StringBuilder s) --> s.isEmpty()
}

