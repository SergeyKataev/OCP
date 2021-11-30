package Chapter6;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasEx {
    // a -> a.canHop()
    // (Animal a) -> { return a.canHop(); }

    // s -> {}  - valid

    // a, b -> a.startsWith("test")  - пропустили скобки
    // a -> { a.startsWith("test"); }   - пропустили return
    // a -> { return a.startsWith("test") } - пропустили точку с запятой

}

class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String speciesName, boolean hopper, boolean
            swimmer) {
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

class PredicateSearch {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));

        print(animals, a -> a.canHop());
    }

    private static void print(List<Animal> animals,
                              Predicate<Animal> checker) {
        for (Animal animal : animals) {
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
        System.out.println();
    }
}

class PredicateEx {
    // public interface Predicate<T> {
    // boolean test(T t);
    // }
}

class ConsumerEx {
    // void accept(T t)
    public static void main(String[] args) {
        Consumer<String> consumer = x -> System.out.println(x);
        print(consumer, "Hello World");
    }

    private static void print(Consumer<String> consumer, String
            value) {
        consumer.accept(value);
    }
}

class SupplierEx {
    // T get()
    Supplier<Integer> number = () -> 42;
    Supplier<Integer> random = () -> new Random().nextInt();

    public static void main(String[] args) {
        Supplier<Integer> number = () -> 42;
        System.out.println(returnNumber(number));
    }

    private static int returnNumber(Supplier<Integer> supplier) {
        return supplier.get();
    }
}

class ComparatorEx {
}


class VariablesInLambdas {
    // Variables can appear in three places with respect to lambdas:
    // the parameter list,
    // local variables declared inside the lambda body,
    // variables referenced from the lambda body.

    // Parameter List
    Predicate<String> p1 = x -> true;
    Predicate<String> p2 = (var x) -> true;
    Predicate<String> p3 = (String x) -> true;

    // Can you figure out the type of x?
    public void whatAmI() {
        consume((var x) -> System.out.print(x), 123);
    }

    public void consume(Consumer<Integer> c, int num) {
        c.accept(num);
    }

    // Local Variables inside the Lambda Body
    // (a, b) -> { int c = 0; return 5;}
    // (a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE, We tried to redeclare a, which is not allowed.

    // How many syntax errors do you see in this method?
    /*

    public void variables(int a) {
        int b = 1;
        Predicate<Integer> p1 = a -> {  // переменная а уже определена как переменная метода - будет ошибка компиляции
            int b = 0;                  // переменная уже определена ранее
            int c = 0;
            return b == c;}             // нужна еще точка с запятой после самой лямбды
        }

     */


    // Variables Referenced from the Lambda Body
    // Lambda bodies are allowed to reference some variables from the
    // surrounding code. The following code is legal:

    public class Crow {
        private String color;

        public void caw(String name) {
            String volume = "loudly";
            Consumer<String> consumer = s ->
                    System.out.println(name + " says "
                            + volume + " that she is " + color);
        }
    }

    // у лямбды есть доступ к переменным класса, (параметрам метода и локальным переменным - если они effectively final)

    class Crow1 {
        private String color;

        public void caw(final String name) {
            final String volume = "loudly";
            Consumer<String> consumer = s ->
                    System.out.println(name + " says "
                            + volume + " that she is " + color);
        }
    }

    // тут будут ошибки компиляции (! относится только к локальным переменным и парамтрам метода. Они не должны меняться после назначения).
    // переменные класса, статические переменные, параметры лямбда могут спокойно меняться
    class Crow3 {
        private String color;

        public void caw(String name) {
            String volume = "loudly";
            name = "Caty";
            color = "black";

//            Consumer<String> consumer = s ->
//                    System.out.println(name + " says " // ошибка компилции - name не effectiveli final и не может использоваться в лямбде
//                            + volume + " that she is " + color); // ошибка компилции - volume не effectiveli final и не может использоваться в лямбде
            volume = "softly";
        }
    }
}


class LambdasApi {
    public static void main(String[] args) {
        //removeif()
        // List and Set declare a removeIf() method that takes a Predicate.
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies); // [long ear, floppy, hoppy]
        bunnies.removeIf(s -> s.charAt(0) != 'h');
        System.out.println(bunnies); // [hoppy]

        // sort()
        List<String> bunnies2 = new ArrayList<>();
        bunnies2.add("long ear");
        bunnies2.add("floppy");
        bunnies2.add("hoppy");
        System.out.println(bunnies2); // [long ear, floppy, hoppy]
        bunnies2.sort((b1, b2) -> b1.compareTo(b2));
        System.out.println(bunnies2); // [floppy, hoppy, long ear]

        //forEach() - with a Set or Map
        List<String> bunnies3 = new ArrayList<>();
        bunnies3.add("long ear");
        bunnies3.add("floppy");
        bunnies3.add("hoppy");

        bunnies3.forEach(b -> System.out.println(b));
        System.out.println(bunnies3);

        Map<String, Integer> bunnies4 = new HashMap<>();
        bunnies4.put("long ear", 3);
        bunnies4.put("floppy", 8);
        bunnies4.put("hoppy", 1);
        bunnies4.keySet().forEach(b -> System.out.println(b));
        bunnies4.values().forEach(b -> System.out.println(b));


    }
}



