package Chapter4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Q4_0 {
}

// 1. What could be the output of the following?
/*
var stream = Stream.iterate("", (s) -> s + "1");  // есть еще аналог generate
System.out.println(stream.limit(2).map(x -> x + "2"));   212

    A. 12112
    B. 212
    C. 212112
    D. java.util.stream.ReferencePipeline$3@4517d9a3  // Correct
    E. The code does not compile.
    F. An exception is thrown.
    G. The code hangs.

    No terminal operation is called, so the stream never executes.
 */

// 2. What could be the output of the following?
/*
Predicate<String> predicate = s -> s.startsWith("g");
 var stream1 = Stream.generate(() -> "growl!");
 var stream2 = Stream.generate(() -> "growl!");
 var b1 = stream1.anyMatch(predicate);  // тут true, java не пойдет перебирать все значения
 var b2 = stream2.allMatch(predicate);  // тут программа сломается
 System.out.println(b1 + " " + b2);

 when allMatch() runs, it needs to keep going until the end of the stream
since it keeps finding matches. Since all elements continue to match, the program hangs.

A. true false
B. true true
C. java.util.stream.ReferencePipeline$3@4517d9a3
D. The code does not compile.
E. An exception is thrown.
F. The code hangs.    // Correct
 */

// 3.What could be the output of the following?
/*
Predicate<String> predicate = s -> s.length()> 3;
 var stream = Stream.iterate("-",
 s -> ! s.isEmpty(), (s) -> s + s);    // the condition is never false.
 var b1 = stream.noneMatch(predicate);  // тут false
 var b2 = stream.anyMatch(predicate);   // тут ошибка “stream has already been operated upon or closed.”
 System.out.println(b1 + " " + b2);


A. false false
B. false true
C. java.util.stream.ReferencePipeline$3@4517d9a3
D. The code does not compile.
E. An exception is thrown.  // Correct
F. The code hangs.

 */

class Q4_3 {
    public static void main(String[] args) {
        var stream = Stream.iterate("-", s -> ! s.isEmpty(), (s) -> s + s);
        stream.limit(5).forEach(x->System.out.println(x));

    }

    /*  вывод будет такой
-
--
----
--------
----------------
     */
}


/*
Which are true statements about terminal operations in a stream that runs successfully? (Choose all
that apply.)
A. At most, one terminal operation can exist in a stream pipeline.   // Correct
        Exactly one is required, because it triggers the execution of the entire stream pipeline.
B. Terminal operations are a required part of the stream pipeline in order to get a result. // Correct
        Exactly one is required, because it triggers the execution of the entire stream pipeline.
C. Terminal operations have Stream as the return type.  //  true of intermediate operations,
D. The peek() method is an example of a terminal operation. // peek() is an intermediate operation
E. The referenced Stream may be used after calling a terminal operation.
    once a stream pipeline is run, the Stream is marked invalid.
 */

// 5. Which of the following sets result to 8.0? (Choose all that apply.)
/*
A.
double result = LongStream.of(6L, 8L, 10L)  // примитивы long внутри
  .mapToInt(x -> (int) x)
  .collect(Collectors.groupingBy(x -> x))  // может работать только с обертками, не примитивами
  .keySet() - Set<Integers> 6, 8, 10
  .stream()
  .collect(Collectors.averagingInt(x -> x));

Отсутствует метод boxed()
IntStream boxed () возвращает поток, состоящий из элементов этого потока,
каждый из которых упакован в целое число.

Если он будет, то сначала получится так
Map<Integer, List<Integer>> collect = LongStream.of(6L, 8L, 10L)
        .mapToInt(x -> (int) x)
        .boxed()
        .collect(Collectors.groupingBy(x -> x));
System.out.println(collect);    // {6=[6], 8=[8], 10=[10]}


 B.
double result = LongStream.of(6L, 8L, 10L)
 .mapToInt(x -> x)                          // нельзя в mapToInt long без каста
 .boxed()
 .collect(Collectors.groupingBy(x -> x))
 .keySet()
 .stream()
 .collect(Collectors.averagingInt(x -> x));

C.                                              // Correct
double result = LongStream.of(6L, 8L, 10L)
 .mapToInt(x -> (int) x)
 .boxed()
 .collect(Collectors.groupingBy(x -> x))
 .keySet()
 .stream()
 .collect(Collectors.averagingInt(x -> x));

D. double result = LongStream.of(6L, 8L, 10L)
 .mapToInt(x -> (int) x)                // Отсутствует метод boxed()
 .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
 .keySet()
 .stream()
 .collect(Collectors.averagingInt(x -> x));

E.
double result = LongStream.of(6L, 8L, 10L)
 .mapToInt(x -> x)                      // Отсутствует каст к инту
 .boxed()
 .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
 .keySet()
 .stream()
 .collect(Collectors.averagingInt(x -> x));

 F.                                     // Correct
double result = LongStream.of(6L, 8L, 10L)
 .mapToInt(x -> (int) x)
 .boxed()
 .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))  // все норм, на выходе сет
 .keySet()
 .stream()
 .collect(Collectors.averagingInt(x -> x));
 */


// 6. Which of the following can fill in the blank so that the code prints out false? (Choose all that apply.)
    /*
    var s = Stream.generate(() -> "meow");
    var match = s.________________(String::isEmpty);
    System.out.println(match);

    A. allMatch     // Correct      // тут просто, первый не подошел, значит allMatch не сработает
    B. anyMatch     // false        While the code compiles, it runs infinitely.
    C. findAny      // false        do not take a Predicate parameter and do not return a boolean
    D. findFirst    // false        do not take a Predicate parameter and do not return a boolean
    E. noneMatch    // false        While the code compiles, it runs infinitely.
    F. None of the above
     */

// 7. We have a method that returns a sorted list without changing the original.
// Which of the following can replace the method implementation to do the same with streams?
/*
private static List<String> sort(List<String> list) {
     var copy = new ArrayList<String>(list);
     Collections.sort(copy, (a, b) -> b.compareTo(a));
     return copy;
 }

 a.compareTo(b):
Comparable interface : Compares values and returns an int which tells if the values compare
less than, equal, or greater than. If your class objects have a natural order, implement
the Comparable<T> interface and define this method. All Java classes that have a natural
ordering implement Comparable<T> - Example: String, wrapper classes, BigInteger

compare(a, b):
Comparator interface : Compares values of two objects. This is implemented as part of
the Comparator<T> interface, and the typical use is to define one or more small utility
classes that implement this, to pass to methods such as sort() or for use by sorting data
structures such as TreeMap and TreeSet.


НО!!! There is no Stream<T> method called compare() or compareTo()


A.
return list.stream()
 .compare((a, b) -> b.compareTo(a))
 .collect(Collectors.toList());

B.
return list.stream()
 .compare((a, b) -> b.compareTo(a))
 .sort();

C.
return list.stream()
 .compareTo((a, b) -> b.compareTo(a))
 .collect(Collectors.toList());

D.
return list.stream()
 .compareTo((a, b) -> b.compareTo(a))
 .sort();

E.
return list.stream()
 .sorted((a, b) -> b.compareTo(a))
 .collect();  // неполный тернарный оператор, нужен коллектор

 F.                     // Correct
return list.stream()
 .sorted((a, b) -> b.compareTo(a))
 .collect(Collectors.toList());
 */


// 8. Which of the following are true given this declaration? (Choose all that apply.)
/*
var is = IntStream.empty();

!!! The average() method returns an OptionalDouble since averages of any type
can result in a fraction.


A. is.average() returns the type int.
B. is.average() returns the type OptionalInt.
C. is.findAny() returns the type int.
D. is.findAny() returns the type OptionalInt.  // Correct
E. is.sum() returns the type int.               // Correct
F. is.sum() returns the type OptionalInt.
 */

// 9. Which of the following can we add after line 6 for the code to run without error
// and not produce any output? (Choose all that apply.)
/*
 4: var stream = LongStream.of(1, 2, 3);    // [1, 2, 3].
 5: var opt = stream.map(n -> n * 10)
 6: .filter(n -> n < 5).findFirst(); - findFirst() returns an empty Optional


 A.
    if (opt.isPresent())
     System.out.println(opt.get()); // get() вызывается над оберткой It would work for a Stream<T> object

B.                                      // Correct
     if (opt.isPresent())
     System.out.println(opt.getAsLong());  // .getAsLong() вызывается над примитивами

C.
    opt.ifPresent(System.out.println);   // нужно писать System.out:println

D.                                      // Correct
    opt.ifPresent(System.out::println);
E. None of these; the code does not compile.
F. None of these; line 5 throws an exception at runtime.
 */


// 10.  Given the four statements (L, M, N, O), select and order the ones that would
// complete the expression and cause the code to output 10 lines. (Choose all that apply.)

/*
Stream.generate(() -> "1")
 L: .filter(x -> x.length()> 1)
 M: .forEach(System.out::println)
 N: .limit(10)
 O: .peek(System.out::println)
 ;

// N, M

A. L, N
B. L, N, O
C. L, N, M
D. L, N, M, O
E. L, O, M
F. N, M   // Correct ( в конце должен быть M)
G. N, O
 */


// 11. What changes need to be made together for this code to print the string 12345?
// (Choose all that apply.)

/*
Stream.iterate(1, x -> x++)
 .limit(5).map(x -> x)
 .collect(Collectors.joining());


A. Change Collectors.joining() to Collectors.joining(",").
B. Change map(x -> x) to map(x -> "" + x).
C. Change x -> x++ to x -> ++x.
D. Add forEach(System.out::print) after the call to collect().
E. Wrap the entire line in a System.out.print statement.
F. None of the above. The code already prints 12345.

// B - чтобы сделать стрим строк
// С - изменить последовательность в map
// E - распечатать

As written, the code doesn't compile because the Collectors.joining() expects to get a
Stream<String>.  Option B fixes this. Option E fixes this and causes the output to be 11111.
Since the post-increment operator is used, the stream contains an infinite number of
the character 1. Option C fixes this and causes the stream to contain increasing numbers.

 */


// 12. Which functional interfaces complete the following code? For line 7, assume
// m and n are instances of functional interfaces that exist and have the same type as y. (Choose three.)
/*
 6: ________________ x = String::new;       // Supplier
 7: ________________ y = m.andThen(n);      // Consumer или  Function
 8: ________________ z = a -> a + a;

A. BinaryConsumer<String, String>           // don't actually exist.
B. BiConsumer<String, String>               // для 7. andThen есть у Consumer и Function
C. BinaryFunction<String, String>           // don't actually exist.
D. BiFunction<String, String>               //  BiFunction<T,U,R> takes three generic arguments, not two
E. Predicate<String>                        // некто не возвращает boolean
F. Supplier<String>             // для 6
G. UnaryOperator<String>        // для 8
H. UnaryOperator<String, String>                // должен быть только 1 параметр
 */

// 13. Which of the following is true?

/*
List<Integer> x1 = List.of(1, 2, 3);
List<Integer> x2 = List.of(4, 5, 6);
List<Integer> x3 = List.of();
Stream.of(x1, x2, x3).map(x -> x + 1)
  .flatMap(x -> x.stream())
  .forEach(System.out::print);

A. The code compiles and prints 123456.
B. The code compiles and prints 234567.  // Если вместо map() поставить  flatMap() то ок
C. The code compiles but does not print anything.
D. The code compiles but prints stream references.
E. The code runs infinitely.
F. The code does not compile.   // Correct
G. The code throws an exception.
 */

// 14. Which of the following is true? (Choose all that apply.)
/*
 4: Stream<Integer> s = Stream.of(1);  creates a Stream and uses autoboxing to put the Integer wrapper of 1 inside.
 5: IntStream is = s.boxed();
 6: DoubleStream ds = s.mapToDouble(x -> x); - converts to a double primitive,
            which works since Integer can be unboxed to a value that can be implicitly cast to a double.
 7: Stream<Integer> s2 = ds.mapToInt(x -> x); -примитивы нельзя через mapToInt + нужен явный каст от double к int
 8: s2.forEach(System.out::print);  // тут ок

 A. Line 4 causes a compiler error.
 B. Line 5 causes a compiler error. // Correct - boxed() is available only on primitive
                                       streams (IntStream) not Stream<Integer>.
 C. Line 6 causes a compiler error.
 D. Line 7 causes a compiler error. // Correct
 E. Line 8 causes a compiler error.
 F. The code compiles but throws an exception at runtime.
 G. The code compiles and prints 1.
 */


// 15. Given the generic type String, the partitioningBy() collector creates a Map<Boolean, List<String>>
// when passed to collect() by default. When a downstream collector is passed to
// partitioningBy(), which return types can be created? (Choose all that apply.)

/*
A. Map<boolean, List<String>>  // некорректно
B. Map<Boolean, List<String>>   // Correct
C. Map<Boolean, Map<String>>    // некорректно
D. Map<Boolean, Set<String>>    // Correct Set может быть кастомизован в любую коллекцию
E. Map<Long, TreeSet<String>>   // нет, т.к. partitioningBy - ключ - Boolean
F. None of the above
 */


// 16. Which of the following statements are true about this code? (Choose all that apply.)

/*
 20: Predicate<String> empty = String::isEmpty;
 21: Predicate<String> notEmpty = empty.negate();
 22:
 23: var result = Stream.generate(() -> "")
 24: .limit(10)
 25: .filter(notEmpty)
 26: .collect(Collectors.groupingBy(k -> k))
 27: .entrySet()
 28: .stream()
 29: .map(Entry::getValue)
 30: .flatMap(Collection::stream)
 31: .collect(Collectors.partitioningBy(notEmpty)); // Map<Boolean, List<String>>
 32: System.out.println(result);


A. It outputs: {}
B. It outputs: {false=[], true=[]}      // Correct
C. If we changed line 31 from partitioningBy(notEmpty) to groupingBy(n -> n), it would
output: {}          // Correct  - groupingBy() returns only keys that are actually needed
D. If we changed line 31 from partitioningBy(notEmpty) to groupingBy(n -> n), it would
output: {false=[], true=[]}
E. The code does not compile.
F. The code compiles but does not terminate at runtime.
 */

// 17. Which of the following is equivalent to this code? (Choose all that apply.)
/*
UnaryOperator<Integer> u = x -> x * x;

A. BiFunction<Integer> f = x -> x*x;                // BiFunction<T,U,R> - принимает 3 параметра
B. BiFunction<Integer, Integer> f = x -> x*x;       // BiFunction<T,U,R> - принимает 3 параметра
C. BinaryOperator<Integer, Integer> f = x -> x*x;   //  BinaryOperator<T> - принимает 1 параметр
D. Function<Integer> f = x -> x*x;                  // Function<T,R> - принимает 2 параметра
E. Function<Integer, Integer> f = x -> x*x;         // Correct  UnaryOperator actually extends Function
F. None of the above
 */

// 18. What is the result of the following?

/*
var s = DoubleStream.of(1.2, 2.4);
s.peek(System.out::println).filter(x -> x> 2).count()

A. 1
B. 2
C. 2.4
D. 1.2 and 2.4  // Correct
E. There is no output.
F. The code does not compile.
G. An exception is thrown.
 */


// 19. What does the following code output?
/*
 Function<Integer, Integer> s = a -> a + 4;
 Function<Integer, Integer> t = a -> a * 3;
 Function<Integer, Integer> c = s.compose(t);
 System.out.println(c.apply(1));

!!! a.compose(b) method calls the Function parameter b before the reference Function variable a.

A. 7            // Correct
B. 15
C. The code does not compile because of the data types in the lambda expressions.
D. The code does not compile because of the compose() call.
E. The code does not compile for another reason.
 */

// 20. Which of the following functional interfaces contain an abstract method that
// returns a primitive value? (Choose all that apply.)

/*
A. BooleanSupplier    // Correct
B. CharSupplier
C. DoubleSupplier    // Correct
D. FloatSupplier
E. IntSupplier      // Correct
F. StringSupplier

Java includes support for three primitive streams, along with numerous functional interfaces
to go with them: int, double, and long
There is one
exception to this rule. While there is no BooleanStream class, there is a BooleanSupplier functional
interface, making option A correct.
 */

// 21. What is the simplest way of rewriting this code?
/*
List<Integer> x = IntStream.range(1, 6)   // 1,2,3,4,5
 .mapToObj(i -> i)
 .collect(Collectors.toList());
 x.forEach(System.out::println);

A.              // не печатает
IntStream.range(1, 6);

B.              // Correct
IntStream.range(1, 6)
 .forEach(System.out::println);

C.                  // работает, но это не "неипростейший", см задачу
IntStream.range(1, 6)
 .mapToObj(i -> i)
 .forEach(System.out::println);

D. None of the above is equivalent.

E. The provided code does not compile.
 */

// 22. Which of the following throw an exception when an Optional is empty?
// (Choose all that apply.)

/*
A. opt.orElse("");      // Не выбросит, вернет пустую строку
B. opt.orElseGet(() -> ""); // Не выбросит, вернет пустую строку
C. opt.orElseThrow();           // Correct
D. opt.orElseThrow(() -> throw new Exception());
E. opt.orElseThrow(RuntimeException::new);  // Correct
F. opt.get();               // Correct
G. opt.get("");             //  does not compile  get() не принимает параметры


Option D looks correct but will compile only if the throw is removed.
Remember, the orElseThrow() should get a lambda expression or method reference that returns an
exception, not one that throws an exception.
 */

































