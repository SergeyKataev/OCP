package Chapter4;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalProgramming {
}

// Working with Built-in Functional Interfaces
// Common functional interfaces
/*
Functional interface    Return type     Method name         # of parameters
Supplier<T>             T               get()               0
Consumer<T>             void            accept(T)           1(T)
BiConsumer<T, U>        void            accept(T,U)         2(T, U)
Predicate<T>            boolean         test(T)             1(T)
BiPredicate<T, U>       boolean         test(T,U)           2(T, U)
Function<T, R>          R               apply(T)            1(T)
BiFunction<T, U, R>     R               apply(T,U)          2(T, U)
UnaryOperator<T>        T               apply(T)            1(T)
BinaryOperator<T>       T               apply(T,T)          2(T, T)
 */

// The convention here is to use the generic type T for the type parameter.
// If a second type parameter is needed, the next letter, U, is used. If a distinct return type is needed,
// R for return is used for the generic type


// Implementing Supplier - to generate or supply values without taking any input. : get()
/*
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
 */

/*
You can create a LocalDate object using the factory method now(). This example shows how to use a
Supplier to call this factory:
Supplier<LocalDate> s1 = LocalDate::now;
Supplier<LocalDate> s2 = () -> LocalDate.now();

LocalDate d1 = s1.get();
LocalDate d2 = s2.get();

System.out.println(d1); // 2020–02–20
System.out.println(d2); // 2020–02–20



A Supplier is often used when constructing new objects. For example, we can
print two empty StringBuilder objects.

Supplier<StringBuilder> s1 = StringBuilder::new;
Supplier<StringBuilder> s2 = () -> new StringBuilder();

System.out.println(s1.get());
System.out.println(s2.get());


// еще пример создания ArrayList<String>
Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
ArrayList<String> a1 = s3.get();
System.out.println(a1);

 */


// Implementing Consumer and BiConsumer
// - do something with a parameter but not return anything (BiConsumer takes two parameters)
/*
@FunctionalInterface
public interface Consumer<T> {
     void accept(T t);
     // omitted default method
}
@FunctionalInterface
public interface BiConsumer<T, U> {
     void accept(T t, U u);
     // omitted default method
}

Пример:
Consumer<String> c1 = System.out::println;
Consumer<String> c2 = x -> System.out.println(x);
c1.accept("Annie");  // Annie
c2.accept("Annie");  // Annie


// This example prints Annie twice. BiConsumer is called with two parameters. They don't have to be the
//same type.

var map = new HashMap<String, Integer>();
BiConsumer<String, Integer> b1 = map::put;
BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
b1.accept("chicken", 7);
b2.accept("chick", 1);
System.out.println(map);  //  {chicken=7, chick=1}

Еще пример:
var map = new HashMap<String, String>();
BiConsumer<String, String> b1 = map::put;
BiConsumer<String, String> b2 = (k, v) -> map.put(k, v);
b1.accept("chicken", "Cluck");
b2.accept("chick", "Tweep");
System.out.println(map);  // {chicken=Cluck, chick=Tweep},
 */

// Implementing Predicate and BiPredicate
/*
@FunctionalInterface
public interface Predicate<T> {
 boolean test(T t);
 // omitted default and static methods
}
@FunctionalInterface
public interface BiPredicate<T, U> {
 boolean test(T t, U u);
 // omitted default methods
}

Пример
Predicate<String> p1 = String::isEmpty;
Predicate<String> p2 = x -> x.isEmpty();

System.out.println(p1.test("")); // true
System.out.println(p2.test("")); // true

// More interesting is a BiPredicate. This example also prints true twice:
// BiPredicate<String, String> b1 = String::startsWith;
// BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
// System.out.println(b1.test("chicken", "chick")); // true
// System.out.println(b2.test("chicken", "chick")); // true
 */

// Implementing Function and BiFunction
// A Function is responsible for turning one parameter into a value
// of a potentially different type and returning it.
/*
@FunctionalInterface
public interface Function<T, R> {
     R apply(T t);
     // omitted default and static methods
}
@FunctionalInterface
public interface BiFunction<T, U, R> {
     R apply(T t, U u);
     // omitted default method
}

For example, this function converts a String to the length of the String:
Function<String, Integer> f1 = String::length;  // принимает String, отдает Integer
Function<String, Integer> f2 = x -> x.length();
System.out.println(f1.apply("cluck")); // 5
System.out.println(f2.apply("cluck")); // 5

Пример - на входе 2 строки, на выходе 1

BiFunction<String, String, String> b1 = String::concat;
BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
System.out.println(b1.apply("baby ", "chick")); // baby chick
System.out.println(b2.apply("baby ", "chick")); // baby chick


Можно создавать и свои функции с кастомным количеством параметров
@FunctionalInterface
 interface TriFunction<T,U,V,R> {
     R apply(T t, U u, V v);
 }

 */

// Implementing UnaryOperator and BinaryOperator
// UnaryOperator and BinaryOperator are a special case of a Function.
// They require all type parameters to be the same type.
// !!! A UnaryOperator transforms its value into one of the same type.
// For example, incrementing by one is a unary operation.
// A BinaryOperator merges two values into one of the same type.

/*
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> { }
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
 // omitted static methods
}

 signatures look like this:
 T apply(T t); // UnaryOperator
 T apply(T t1, T t2); // BinaryOperator


Пример UnaryOperator
UnaryOperator<String> u1 = String::toUpperCase;
UnaryOperator<String> u2 = x -> x.toUpperCase();
System.out.println(u1.apply("chirp")); // CHIRP
System.out.println(u2.apply("chirp")); // CHIRP

Пример BinaryOperator
BinaryOperator<String> b1 = String::concat;
BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
System.out.println(b1.apply("baby ", "chick")); // baby chick
System.out.println(b2.apply("baby ", "chick")); // baby chick

Notice that this does the same thing as the BiFunction example.
 */

// Checking Functional Interfaces
/*
What functional interface would you use in these three situations?

Returns a String without taking any parameters  // Supplier<String>
Returns a Boolean and takes a String            // Function<String,Boolean>
Returns an Integer and takes two Integers       // BinaryOperator<Integer> или BiFunction<Integer,Integer,Integer>



// What functional interface would you use to fill in the blank for these?
6: ____________<List> ex1 = x -> "".equals(x.get(0));           // Predicate
7: ____________<Long> ex2 = (Long l) -> System.out.println(l);  // Consumer
8: ____________<String, String> ex3 = (s1, s2) -> false;        // BiPredicate



Ошибки
6: Function<List<String>> ex1 = x -> x.get(0); // DOES NOT COMPILE
    - A Function needs to specify two generics.
7: UnaryOperator<Long> ex2 = (Long l) -> 3.14; // DOES NOT COMIPLE
    - returns the same type as it is passed in. Return double
8: Predicate ex4 = String::isEmpty; // DOES NOT COMPILE
        - missing the generic for Predicate. This makes the parameter that was passed an Object rather
        than a String.

 */

// Convenience Methods on Functional Interfaces
// Several of the common functional interfaces provide a number of helpful default methods.
// Convenience methods
/*
Interface instance      Method return type      Method name         Method parameters
Consumer                Consumer                andThen()           Consumer
Function                Function                andThen()           Function
Function                Function                compose()           Function
Predicate               Predicate               and()               Predicate
Predicate               Predicate               negate()            —
Predicate               Predicate               or()                Predicate

// The BiConsumer, BiFunction, and BiPredicate interfaces have similar methods available.

Допустим есть 2 предиката
Predicate<String> egg = s -> s.contains("egg");
Predicate<String> brown = s -> s.contains("brown");

Мы хотим следующую логику:
Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
Predicate<String> otherEggs = s -> s.contains("egg") && ! s.contains("brown");

Можно так
Predicate<String> brownEggs = egg.and(brown);
Predicate<String> otherEggs = egg.and(brown.negate());


еще пример с Consumer
Consumer<String> c1 = x -> System.out.print("1: " + x);
Consumer<String> c2 = x -> System.out.print(",2: " + x);

Consumer<String> combined = c1.andThen(c2);
combined.accept("Annie"); // 1: Annie,2: Annie

еще пример с Function
Function<Integer, Integer> before = x -> x + 1;
Function<Integer, Integer> after = x -> x * 2;

Function<Integer, Integer> combined = after.compose(before);
System.out.println(combined.apply(3)); // 8
 */

// Returning an Optional
// Creating an Optional
// Here's how to code our average method:
/*
10: public static Optional<Double> average(int... scores) {
11:   if (scores.length == 0) return Optional.empty();
                // returns an empty Optional when we can't calculate an average.
12:   int sum = 0;
13:   for (int score: scores) sum += score;
14:   return Optional.of((double) sum / scores.length);
15: }

// Calling the method shows what is in our two boxes.
System.out.println(average(90, 100));   // Optional[95.0]
System.out.println(average());          // Optional.empty

Normally, we want to check whether a value is there and/or get it out of the box. Here's one way to do that:
20: Optional<Double> opt = average(90, 100);
21: if (opt.isPresent())
22: System.out.println(opt.get()); // 95.0

What if we didn't do the check and the Optional was empty?
26: Optional<Double> opt = average();
27: System.out.println(opt.get()); // NoSuchElementException

When creating an Optional, it is common to want to use empty() when the value is null.
Optional o = (value == null) ? Optional.empty() : Optional.of(value);

Java provides a factory method to do the same thing.
Optional o = Optional.ofNullable(value);
 */

// static methods you need to know about Optional.
/*
Method                  When Optional is empty                  When Optional contains a value
get()                   Throws an exception                     Returns value
ifPresent(Consumer c)   Does nothing                            Calls Consumer with value
isPresent()             Returns false                           Returns true
orElse(T other)         Returns other parameter                 Returns value
orElseGet(Supplier s)   Returns result of calling Supplier      Returns value
orElseThrow()           Throws NoSuchElementException           Returns value
orElseThrow(Supplier s) Throws exception created by calling     Returns value
                        Supplier

Instead of using an if statement:
Optional<Double> opt = average(90, 100);
opt.ifPresent(System.out::println);

 */

// Dealing with an Empty Optional
// The remaining methods allow you to specify what to do if a value isn't present.
/*
30: Optional<Double> opt = average();
31: System.out.println(opt.orElse(Double.NaN));
32: System.out.println(opt.orElseGet(() -> Math.random()));
    // using a Supplier to generate a value at runtime to return instead.

This prints something like the following:
NaN
0.49775932295380165



Alternatively, we can have the code throw an exception if the Optional is empty.

30: Optional<Double> opt = average();
31: System.out.println(opt.orElseThrow());
Without specifying a Supplier for the exception, Java will throw a NoSuchElementException.

Alternatively, we can have the code throw a custom exception if the Optional is empty.
30: Optional<Double> opt = average();
31: System.out.println(opt.orElseThrow(
32: () -> new IllegalStateException()));

Ошибки
System.out.println(opt.orElseGet(
 () -> new IllegalStateException())); // DOES NOT COMPILE

 The opt variable is an Optional<Double>. This means the Supplier must return a Double. Since this
supplier returns an exception, the type does not match.

The last example with Optional is really easy. What do you think this does?
Optional<Double> opt = average(90, 100);
System.out.println(opt.orElse(Double.NaN));
System.out.println(opt.orElseGet(() -> Math.random()));
System.out.println(opt.orElseThrow());

It prints out 95.0 three times. Since the value does exist, there is no need to use the “or else” logic.
 */

// Using Streams
// In Java, the streams we have been talking about are represented by the Stream<T> interface,
// defined in the java.util.stream package.
// Creating Finite Streams
//For simplicity, we'll start with finite streams. There are a few ways to create them.
/*
11: Stream<String> empty = Stream.empty(); // count = 0
12: Stream<Integer> singleElement = Stream.of(1); // count = 1
13: Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3

Java also provides a convenient way of converting a Collection to a stream.
14: var list = List.of("a", "b", "c");
15: Stream<String> fromList = list.stream();

Creating Infinite Streams
So far, this isn't particularly impressive. We could do all this with lists. We can't create an infinite list,
though, which makes streams more powerful.
17: Stream<Double> randoms = Stream.generate(Math::random);
18: Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

What if you wanted just odd numbers less than 100? Java 9 introduced an overloaded version of
iterate() that helps with just that.

19: Stream<Integer> oddNumberUnder100 = Stream.iterate(
20: 1, // seed
21: n -> n < 100, // Predicate to specify when done
22: n -> n + 2); // UnaryOperator to get next value


Reviewing Stream Creation Methods
These are the ways of creating a source for streams, given a Collection instance coll.

Method                            Finite        Notes
                                  or
                                  infinite?

Stream.empty()                    Finite        Creates Stream with zero elements

Stream.of(varargs)                Finite        Creates Stream with elements listed

coll.stream()                     Finite        Creates Stream from a Collection

coll.parallelStream()             Finite        Creates Stream from a Collection
                                                where the stream can run in parallel

Stream.generate(supplier)         Infinite      Creates Stream by calling the Supplier
                                                for each element upon request

Stream.iterate(seed,              Infinite      Creates Stream by using the seed for the
unaryOperator)                                  first element and then calling the
                                                UnaryOperator for each subsequent element upon request

Stream.iterate(seed,              Finite or     Creates Stream by using the seed for the first
predicate, unaryOperator)         infinite      element and then calling the UnaryOperator for
                                                each subsequent element upon request.
                                                Stops if the Predicate returns false.


Using Common Terminal Operations

Terminal stream operations
Method              What happens for infinite streams           Return value        Reduction

count()             Does not terminate                          long                Yes

min()               Does not terminate                          Optional<T>         Yes
max()

findAny()           Terminates                                  Optional<T>         No
findFirst()

allMatch()          Sometimes terminates                        boolean             No
anyMatch()
noneMatch()

forEach()           Does not terminate                          void                No

reduce()            Does not terminate                          Varies              Yes

collect()           Does not terminate                          Varies              Yes


count() - long count()
This example shows calling count() on a finite stream:

Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
System.out.println(s.count()); // 3


min() and max()
The min() and max() methods allow you to pass a custom comparator and find the smallest or largest
value in a finite stream according to that sort order.

signature:
Optional<T> min(Comparator<? super T> comparator)
Optional<T> max(Comparator<? super T> comparator)

This example finds the animal with the fewest letters in its name:

Stream<String> s = Stream.of("monkey", "ape", "bonobo");
Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
min.ifPresent(System.out::println); // ape

// Если пустой стрим
Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
System.out.println(minEmpty.isPresent()); // false

findAny() and findFirst()
signature:
Optional<T> findAny()
Optional<T> findFirst()

This example finds an animal:
Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
Stream<String> infinite = Stream.generate(() -> "chimp");
s.findAny().ifPresent(System.out::println); // monkey
infinite.findAny().ifPresent(System.out::println); // chimp


allMatch(), anyMatch(), and noneMatch()
The method signatures are as follows:
boolean anyMatch(Predicate <? super T> predicate)
boolean allMatch(Predicate <? super T> predicate)
boolean noneMatch(Predicate <? super T> predicate)

This example checks whether animal names begin with letters:
var list = List.of("monkey", "2", "chimp");
Stream<String> infinite = Stream.generate(() -> "chimp");
Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
System.out.println(list.stream().anyMatch(pred)); // true
System.out.println(list.stream().allMatch(pred)); // false
System.out.println(list.stream().noneMatch(pred)); // false
System.out.println(infinite.anyMatch(pred)); // true
        If we called allMatch(), it would run until we killed the program.


Remember that allMatch(), anyMatch(), and noneMatch() return a boolean. By
contrast, the find methods return an Optional because they return an element of the stream.



forEach()
signature - void forEach(Consumer<? super T> action)

Пример
Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
s.forEach(System.out::print); // MonkeyGorillaBonobo

Remember that you can call forEach() directly on a Collection or on a
Stream. Don't get confused on the exam when you see both approaches.

Notice that you can't use a traditional for loop on a stream.
Stream<Integer> s = Stream.of(1);
for (Integer i : s) {} // DOES NOT COMPILE



reduce()
The reduce() method combines a stream into a single object. It is a reduction, which means it processes
all elements. The three method signatures are these:

1) T reduce(T identity, BinaryOperator<T> accumulator)

2) Optional<T> reduce(BinaryOperator<T> accumulator)

3) <U> U reduce(U identity,
 BiFunction<U,? super T,U> accumulator,
 BinaryOperator<U> combiner)


Think about how you would concatenate an array of String
objects into a single String without functional programming. It might look something like this:
var array = new String[] { "w", "o", "l", "f" };
var result = "";
for (var s: array) result = result + s;
System.out.println(result); // wolf


The identity is the initial value of the reduction, in this case an empty String. The accumulator combines
the current result with the current value in the stream. With lambdas, we can do the same thing with a
stream and reduction:
Stream<String> stream = Stream.of("w", "o", "l", "f");
String word = stream.reduce("", (s, c) -> s + c);
System.out.println(word); // wolf

We can even rewrite this with a method reference.
Stream<String> stream = Stream.of("w", "o", "l", "f");
String word = stream.reduce("", String::concat);
System.out.println(word); // wolf

Can you write a reduction to multiply all of the Integer objects in a stream? Try it.
Our solution is shown here:
Stream<Integer> stream = Stream.of(3, 5, 6);
System.out.println(stream.reduce(1, (a, b) -> a*b)); // 90


2) Optional<T> reduce(BinaryOperator<T> accumulator)
In many cases, the identity isn't really
necessary, so Java lets us omit it. When you don't specify an identity, an Optional is returned because
there might not be any data. There are three choices for what is in the Optional.
* If the stream is empty, an empty Optional is returned.
* If the stream has one element, it is returned.
* If the stream has multiple elements, the accumulator is applied to combine them.

The following illustrates each of these scenarios:
BinaryOperator<Integer> op = (a, b) -> a * b;
Stream<Integer> empty = Stream.empty();
Stream<Integer> oneElement = Stream.of(3);
Stream<Integer> threeElements = Stream.of(3, 5, 6);
empty.reduce(op).ifPresent(System.out::println); // no output
oneElement.reduce(op).ifPresent(System.out::println); // 3
threeElements.reduce(op).ifPresent(System.out::println); // 90


3) <U> U reduce(U identity,
 BiFunction<U,? super T,U> accumulator,
 BinaryOperator<U> combiner)
The third method signature is used when we are dealing with different types. It allows Java to create
intermediate reductions and then combine them at the end. Let's take a look at an example that counts the
number of characters in each String:

Stream<String> stream = Stream.of("w", "o", "l", "f!");
int length = stream.reduce(0, (i, s) -> i+s.length(), (a, b) -> a+b);
System.out.println(length); // 5

The first parameter (0) is the value for the initializer. If we had an empty stream, this would be the answer.
 */

/*
collect()
it lets us get data out of streams and into another form.

Stream<String> stream = Stream.of("w", "o", "l", "f");
StringBuilder word = stream.collect(
 StringBuilder::new,
 StringBuilder::append,
 StringBuilder::append)
System.out.println(word); // wolf

The first parameter is the supplier, which creates the object that will store the results as we collect data.
The second parameter is the accumulator, which is a BiConsumer that takes two parameters and doesn't
return anything.  It is responsible for adding one more element to the data collection. In this example, it
appends the next String to the StringBuilder. The final parameter is the combiner, which is another BiConsumer.
It is responsible for taking two data collections and merging them.


еще пример
Stream<String> stream = Stream.of("w", "o", "l", "f");
TreeSet<String> set = stream.collect(
 TreeSet::new,
 TreeSet::add,
 TreeSet::addAll);
System.out.println(set); // [f, l, o, w]

 или так

Stream<String> stream = Stream.of("w", "o", "l", "f");
TreeSet<String> set =
 stream.collect(Collectors.toCollection(TreeSet::new));
System.out.println(set); // [f, l, o, w]

If we didn't need the set to be sorted, we could make the code even shorter:
Stream<String> stream = Stream.of("w", "o", "l", "f");
Set<String> set = stream.collect(Collectors.toSet());
System.out.println(set); // [f, w, l, o]


Using Common Intermediate Operations

filter()
signature-
Stream<T> filter(Predicate<? super T> predicate)

For example, this filters all elements that begin with the letter m:

Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
s.filter(x -> x.startsWith("m"))
 .forEach(System.out::print); // monkey


distinct()
signature - Stream<T> distinct()

Here's an example:
Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
s.distinct()
 .forEach(System.out::print); // duckgoose


limit() and skip()
example

Stream<Integer> s = Stream.iterate(1, n -> n + 1);
s.skip(5)
 .limit(2)
 .forEach(System.out::print); // 67



map()
example
Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
s.map(String::length)
 .forEach(System.out::print); // 676


flatMap()
example

List<String> zero = List.of();
var one = List.of("Bonobo");
var two = List.of("Mama Gorilla", "Baby Gorilla");
Stream<List<String>> animals = Stream.of(zero, one, two);
animals.flatMap(m -> m.stream())
 .forEach(System.out::println);



sorted()
signature:

Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator)

Stream<String> s = Stream.of("brown-", "bear-");
s.sorted()
 .forEach(System.out::print); // bear-brown

Stream<String> s = Stream.of("brown bear-", "grizzly-");
s.sorted(Comparator.reverseOrder())
 .forEach(System.out::print); // grizzly-brown bear


 s.sorted(Comparator::reverseOrder); // DOES NOT COMPILE - не метод, без ()



 peek()
 Stream<T> peek(Consumer<? super T> action)

var stream = Stream.of("black bear", "brown bear", "grizzly");
long count = stream.filter(s -> s.startsWith("g"))
 .peek(System.out::println).count(); // grizzly
System.out.println(count); // 1



Danger: Changing State with peek()

var numbers = new ArrayList<>();
var letters = new ArrayList<>();
numbers.add(1);
letters.add('a');
Stream<List<?>> stream = Stream.of(numbers, letters);
stream.map(List::size).forEach(System.out::print); // 11


Now we add a peek() call and note that Java doesn't prevent us from writing bad peek code.
 Stream<List<?>> bad = Stream.of(numbers, letters);
 bad.peek(x -> x.remove(0))
 .map(List::size)
 .forEach(System.out::print); // 00
This example is bad because peek() is modifying the data structure that is used in the stream, which
causes the result of the stream pipeline to be different than if the peek wasn't present.


Now what do you think this prints?
 var infinite = Stream.iterate(1, x -> x + 1);
 infinite.limit(5)
 .peek(System.out::print)
 .filter(x -> x % 2 == 1)
 .forEach(System.out::print);  // 11233455

 Reversing the order of the intermediate operations changes the result.
 var infinite = Stream.iterate(1, x -> x + 1);
 infinite.filter(x -> x % 2 == 1)
 .limit(5)
 .forEach(System.out::print); // 13579


 Finally, what do you think this prints?
 var infinite = Stream.iterate(1, x -> x + 1);
 infinite.filter(x -> x % 2 == 1)
 .peek(System.out::print)
 .limit(5)
 .forEach(System.out::print);

The answer is 1133557799. Since filter() is before peek(), we see only the odd numbers.



Working with Primitive Streams

Stream<Integer> stream = Stream.of(1, 2, 3);
System.out.println(stream.reduce(0, (s, n) -> s + n)); // 6

Stream<Integer> stream = Stream.of(1, 2, 3);
System.out.println(stream.mapToInt(x -> x).sum()); // 6
This time, we converted our Stream<Integer> to an IntStream and asked the IntStream to calculate the
sum for us. An IntStream has many of the same intermediate and terminal methods as a Stream but
includes specialized methods for working with numeric data.

IntStream intStream = IntStream.of(1, 2, 3);
OptionalDouble avg = intStream.average();
System.out.println(avg.getAsDouble()); // 2.0

Creating Primitive Streams
Here are three types of primitive streams.
IntStream: Used for the primitive types int, short, byte, and char
LongStream: Used for the primitive type long
DoubleStream: Used for the primitive types double and float


When you see the word stream on the exam, pay attention to the case. With a capital
S or in code, Stream is the name of a class that contains an Object type. With a lowercase s, a stream
is a concept that might be a Stream, DoubleStream, IntStream, or LongStream.


Method                              Primitive stream        Description
OptionalDouble average()            IntStream               The arithmetic mean of the elements
                                    LongStream
                                    DoubleStream

Stream<T> boxed()                   IntStream               A Stream<T> where T is the wrapper class associated
                                    LongStream              with the primitive value
                                    DoubleStream

OptionalInt max()                   IntStream               The maximum element of the stream
OptionalLong max()                  LongStream              The maximum element of the stream
OptionalDouble max()                DoubleStream            The maximum element of the stream

OptionalInt min()                   IntStream               The minimum element of the stream
OptionalLong min()                  LongStream              The minimum element of the stream
OptionalDouble min()                DoubleStream            The minimum element of the stream

IntStream range(int a, int b)       IntStream               Returns a primitive stream from a (inclusive)
LongStream range(long a, long b)    LongStream              to b (exclusive)

IntStream rangeClosed(int           IntStream               Returns a primitive stream from a (inclusive)
a, int b)                                                   to b (inclusive)

LongStream rangeClosed(long         LongStream              Returns a primitive stream from a (inclusive)
a, int b)                                                   to b (inclusive)

int sum()                           IntStream               Returns the sum of the elements in the stream
long sum()                          LongStream              Returns the sum of the elements in the stream
double sum()                        DoubleStream            Returns the sum of the elements in the stream

IntSummaryStatistics                IntStream               Returns an object containing numerous stream
summaryStatistics()                                         statistics such as the average, min, max, etc.

LongSummaryStatistics               LongStream              Returns an object containing numerous stream
summaryStatistics()                                         statistics such as the average, min, max, etc.

DoubleSummaryStatistics             DoubleStream            Returns an object containing numerous stream
summaryStatistics()                                         statistics such as the average, min, max, etc.




You can create an empty stream with this:
DoubleStream empty = DoubleStream.empty();

Another way is to use the of() factory method from a single value or by using the varargs overload.

DoubleStream oneValue = DoubleStream.of(3.14);
oneValue.forEach(System.out::println);
DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
varargs.forEach(System.out::println);

This code outputs the following:
3.14
1.0
1.1
1.2


You can also use the two methods for creating infinite streams, just like we did with Stream.
var random = DoubleStream.generate(Math::random);
var fractions = DoubleStream.iterate(.5, d -> d / 2);
random.limit(3).forEach(System.out::println);
fractions.limit(3).forEach(System.out::println);

The output from when we ran this code was as follows:
0.07890654781186413
0.28564363465842346
0.6311403511266134
0.5
0.25
0.125



Mapping Streams

Mapping methods between types of streams
Source stream       To create       To create       To create       To create
class               Stream          DoubleStream    IntStream       LongStream

Stream<T>           map()           mapToDouble()   mapToInt()      mapToLong()

DoubleStream        mapToObj()      map()           mapToInt()      mapToLong()

IntStream           mapToObj()      mapToDouble()   map()           mapToLong()

LongStream          mapToObj()      mapToDouble()   mapToInt()      map()


Stream<String> objStream = Stream.of("penguin", "fish");
IntStream intStream = objStream.mapToInt(s -> s.length());
This function takes an Object, which is a String in this case. The function returns an int.


Function parameters when mapping between types of streams

Source stream       To create Stream        To create           To create           To create
class                                       DoubleStream        IntStream           LongStream

Stream<T>           Function<T,R>           ToDoubleFunction<T> ToIntFunction<T>    ToLongFunction<T>

DoubleStream        Double                  DoubleUnary         DoubleToInt         DoubleToLong
                    Function<R>             Operator            Function            Function

IntStream           IntFunction<R>          IntToDouble         IntUnary            IntToLong
                                            Function            Operator            Function

LongStream          Long                    LongToDouble        LongToInt           LongUnary
                    Function<R>             Function            Function            Operator









Using flatMap()
The flatMap() method exists on primitive streams as well. It works the same way as on a regular
Stream except the method name is different. Here's an example:
var integerList = new ArrayList<Integer>();
IntStream ints = integerList.stream()
    .flatMapToInt(x -> IntStream.of(x));

DoubleStream doubles = integerList.stream()
    .flatMapToDouble(x -> DoubleStream.of(x));
LongStream longs = integerList.stream()
    .flatMapToLong(x -> LongStream.of(x));


Additionally, you can create a Stream from a primitive stream. These methods show two ways of
accomplishing this:
private static Stream<Integer> mapping(IntStream stream) {
 return stream.mapToObj(x -> x);
}
private static Stream<Integer> boxing(IntStream stream) {
 return stream.boxed();
}


Using Optional with Primitive Streams

var stream = IntStream.rangeClosed(1,10);
OptionalDouble optional = stream.average()

The return type is not the Optional you have become accustomed to using. It is a new type called
OptionalDouble. Why do we have a separate type, you might wonder? Why not just use
Optional<Double>? The difference is that OptionalDouble is for a primitive and Optional<Double> is
for the Double wrapper class. Working with the primitive optional class looks similar to working with the
Optional class itself.
    optional.ifPresent(System.out::println); // 5.5
    System.out.println(optional.getAsDouble()); // 5.5
    System.out.println(optional.orElseGet(() -> Double.NaN)); // 5.5
The only noticeable difference is that we called getAsDouble() rather than get(). This makes it clear that
we are working with a primitive. Also, orElseGet() takes a DoubleSupplier instead of a Supplier.



As with the primitive streams, there are three type-specific classes for primitives. Table 4.10 shows the
minor differences among the three.

                                    OptionalDouble          OptionalInt             OptionalLong

Getting as a primitive              getAsDouble()           getAsInt()              getAsLong()

orElseGet() parameter type          DoubleSupplier          IntSupplier             LongSupplier

Return type of max() and min()      OptionalDouble          OptionalInt             OptionalLong

Return type of sum()                double                  int                     long

Return type of average()            OptionalDouble          OptionalDouble          OptionalDouble



Let's try an example to make sure that you understand this.
    5: LongStream longs = LongStream.of(5, 10);
    6: long sum = longs.sum();
    7: System.out.println(sum); // 15
    8: DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
    9: OptionalDouble min = doubles.min(); // runs infinitely


Summarizing Statistics

You've learned enough to be able to get the maximum value from a stream of int primitives. If the stream
is empty, we want to throw an exception.

private static int max(IntStream ints) {
 OptionalInt optional = ints.max();
 return optional.orElseThrow(RuntimeException::new);
}


Statistic is just a big word for a number that was calculated from data.
private static int range(IntStream ints) {
 IntSummaryStatistics stats = ints.summaryStatistics();
 if (stats.getCount() == 0) throw new RuntimeException();
 return stats.getMax()-stats.getMin();
}

Here we asked Java to perform many calculations about the stream. Summary statistics include the
following:
    Smallest number (minimum): getMin()
    Largest number (maximum): getMax()
    Average: getAverage()
    Sum: getSum()
    Number of values: getCount()

If the stream were empty, we'd have a count and sum of zero. The other methods would return an empty
optional.



Learning the Functional Interfaces for Primitives

Functional Interfaces for boolean
It works just as you've come to expect from functional interfaces. Here's an example:

12: BooleanSupplier b1 = () -> true;
13: BooleanSupplier b2 = () -> Math.random()> .5;
14: System.out.println(b1.getAsBoolean()); // true
15: System.out.println(b2.getAsBoolean()); // false


Functional Interfaces for double, int, and long

Common functional interfaces for primitives

Functional interfaces       # parameters        Return type         Single abstract method

DoubleSupplier              0                   double              getAsDouble
IntSupplier                                     int                 getAsInt
LongSupplier                                    long                getAsLong

DoubleConsumer              1 (double)          void                accept
IntConsumer                 1 (int)
LongConsumer                1 (long)

DoublePredicate             1 (double)          double              test
IntPredicate                1 (int)
LongPredicate               1 (long)

DoubleFunction<R>           1 (double)          R                   apply
IntFunction<R>              1 (int)
LongFunction<R>             1 (long)

DoubleUnaryOperator         1 (double)          double              applyAsDouble
IntUnaryOperator            1 (int)             int                 applyAsInt
LongUnaryOperator           1 (long)            long                applyAsLong

DoubleBinaryOperator        2 (double, double)  double              applyAsDouble
IntBinaryOperator           2 (int, int)        int                 applyAsInt
LongBinaryOperator          2 (long, long)      long                applyAsLong

 */



/*
Working with Advanced Stream Pipeline Concepts

Linking Streams to the Underlying Data
What do you think this outputs?

25: var cats = new ArrayList<String>();
26: cats.add("Annie");
27: cats.add("Ripley");
28: var stream = cats.stream();
29: cats.add("KC");
30: System.out.println(stream.count());  // 3

Chaining Optionals

Suppose that you are given an Optional<Integer> and asked to print the value,
but only if it is a threedigit number. Without functional programming, you could write the following:

private static void threeDigit(Optional<Integer> optional) {
     if (optional.isPresent()) { // outer if
         var num = optional.get();
         var string = "" + num;
         if (string.length() == 3) // inner if
         System.out.println(string);
     }
}

It works, but it contains nested if statements. That's extra complexity. Let's try this again with functional
programming.

private static void threeDigit(Optional<Integer> optional) {
     optional.map(n -> "" + n) // part 1
     .filter(s -> s.length() == 3) // part 2
     .ifPresent(System.out::println); // part 3
}


Now suppose that we wanted to get an Optional<Integer> representing the length of the String
contained in another Optional. Easy enough.

Optional<Integer> result = optional.map(String::length);

What if we had a helper method that did the logic of calculating something for us that returns

Optional<Integer>? Using map doesn't work.
Optional<Integer> result = optional
 .map(ChainingOptionals::calculator); // DOES NOT COMPILE

The problem is that calculator returns Optional<Integer>. The map() method adds another Optional,
giving us Optional<Optional<Integer>>. Well, that's no good. The solution is to call flatMap() instead.

Optional<Integer> result = optional
 .flatMap(ChainingOptionals::calculator);

This one works because flatMap removes the unnecessary layer. In other words, it flattens the result.
Chaining calls to flatMap() is useful when you want to transform one Optional type to another.




Collecting Results
Examples of grouping/partitioning collectors

Collector                               Description                     Return value when passed
                                                                        to collect

averagingDouble(ToDoubleFunction f)     Calculates the average for our  Double
averagingInt(ToIntFunction f)           three core primitive types
averagingLong(ToLongFunction f)

---
Stream<String> s = Stream.of("7", "8", "9", "10");
double ans = s.collect(Collectors.averagingDouble(num -> Double.parseDouble(num))); // 8.5
---

counting()                              Counts the number of elements   Long

---
Stream<String> s = Stream.of("1", "2", "3", "4");
long ans = s.collect(Collectors.counting());  // 4
---


groupingBy(Function f)                  Creates a map grouping by the   Map<K, List<T>>
groupingBy(Function f, Collector dc)    specified function with the
groupingBy(Function f, Supplier s,      optional map type supplier and
Collector dc)                           optional downstream collector

---
Чтобы сгруппировать данные по какому-нибудь признаку, нам надо использовать в связке
метод collect() объекта Stream и метод Collectors.groupingBy().

Stream<Phone> phoneStream = Stream.of(
            new Phone("iPhone X", "Apple", 600),
            new Phone("Pixel 2", "Google", 500),
            new Phone("iPhone 8", "Apple",450),
            new Phone("Galaxy S9", "Samsung", 440),
            new Phone("Galaxy S8", "Samsung", 340));

        Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany));

        for(Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()){

            System.out.println(item.getKey());
            for(Phone phone : item.getValue()){

                System.out.println(phone.getName());
            }
            System.out.println();
        }

Google
Pixel 2

Apple
iPhone X
iPhone 8

Samsung
Galaxy S9
Galaxy S8

Итак, для создания групп в метод phoneStream.collect() передается вызов функции Collectors.groupingBy(),
которая с помощью выражения Phone::getCompany группирует объекты по компании. В итоге будет создан
объект Map, в котором ключами являются названия компаний, а значениями - список связанных
с компаниями телефонов.

---

joining(CharSequence cs)                Creates a single String using  String
                                        cs as a delimiter between
                                        elements if one is specified

---
Метод joining () класса Collectors в Java используется для объединения различных элементов
символьного или строкового массива в один строковый объект.
char[] ch = { 'G', 'e', 'e', 'k', 's',

                      'f', 'o', 'r',

                      'G', 'e', 'e', 'k', 's' };


String chString = Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining());
System.out.println(chString); // GeeksforGeeks
---

maxBy(Comparator c)                     Finds the largest/smallest     Optional<T>
minBy(Comparator c)                     elements

---
Map<String, Optional<Phone>> phonesByCompany = phoneStream.collect(
        Collectors.groupingBy(Phone::getCompany,
                Collectors.minBy(Comparator.comparing(Phone::getPrice))));

for(Map.Entry<String, Optional<Phone>> item : phonesByCompany.entrySet()){

    System.out.println(item.getKey() + " - " + item.getValue().get().getName());
}

Консольный вывод:
    Google - Pixel 2
    Apple - iPhone 8
    Samsung - Galaxy S8
---

mapping(Function f, Collector dc)       Adds another level of           Collector
                                        collectors

---
Метод mapping позволяет дополнительно обработать данные и задать функцию отображения объектов
 из потока на какой-нибудь другой тип данных.

 Map<String, List<String>> phonesByCompany = phoneStream.collect(
    Collectors.groupingBy(Phone::getCompany,
        Collectors.mapping(Phone::getName, Collectors.toList())));

for(Map.Entry<String, List<String>> item : phonesByCompany.entrySet()){

    System.out.println(item.getKey());
    for(String name : item.getValue()){
        System.out.println(name);
    }
}

Выражение Collectors.mapping(Phone::getName, Collectors.toList()) указывает,
что в группу будут выделятся названия смартфонов, причем группа будет представлять объект List.
---


partitioningBy(Predicate p)             Creates a map grouping by the   Map<Boolean, List<T>>
partitioningBy(Predicate p,             specified predicate with the
Collector dc)                           optional further downstream
                                        collector

---

Метод Collectors.partitioningBy() имеет похожее действие, только он делит элементы на группы по принципу,
соответствует ли элемент определенному условию.

Map<Boolean, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.partitioningBy(p->p.getCompany()=="Apple"));

for(Map.Entry<Boolean, List<Phone>> item : phonesByCompany.entrySet()){

    System.out.println(item.getKey());
    for(Phone phone : item.getValue()){

        System.out.println(phone.getName());
    }
    System.out.println();
}

В данном случае с помощью условия p->p.getCompany()=="Apple" мы смотрим, принадлежит ли телефон компании Apple.
Если телефон принадлежит этой компании, то он попадает в одну группу, если нет, то в другую.

---

summarizingDouble(ToDoubleFunction      Calculates average, min, max,   DoubleSummaryStatistics
f)                                      and so on                       IntSummaryStatistics
summarizingInt(ToIntFunction f)                                         LongSummaryStatistics
summarizingLong(ToLongFunction f)

---

---

summingDouble(ToDoubleFunction f)       Calculates the sum for our      Double
summingInt(ToIntFunction f)             three core primitive types      Integer
summingLong(ToLongFunction f)                                           Long

toList()                                Creates an arbitrary type       List
toSet()                                 of list or set                  Set

toCollection(Supplier s)                Creates a Collection            Collection
                                        of the specified type


toMap(Function k, Function v)           Creates a map using functions   Map
toMap(Function k, Function v,           to map the keys, values,
BinaryOperator m)                       an optional merge function,
toMap(Function k, Function v,           and an optional map type supplier
BinaryOperator m, Supplier s)








 */


















