package Chapter4;

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
s.findAny().ifPresent(System.out::println); // monkey (usually)
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




















