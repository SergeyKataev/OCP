package Chapter3;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;

public class GenericsAndCollections {
}

// Using Method References
// 1. Есть функциональный интерфейс
@FunctionalInterface
interface LearnToSpeak {
    void speak(String sound);
}

// 2. есть класс хелпер, который принимает параметр интерфейс
class DuckHelper {
    public static void teacher(String name, LearnToSpeak trainer) {
        // exercise patience
        trainer.speak(name);
    }
}
// 3. класс, который реализует класс хелпер
class Duckling {
    public static void makeSound(String sound) {
        LearnToSpeak learner = s -> System.out.println(s);  // поместили лямбду в функциональный интерфейс
        DuckHelper.teacher(sound, learner); // передаем строку и лямбду (правила игры)
    }
}

// A method reference lets us remove that redundancy and instead write this:
// LearnToSpeak learner = System.out::println; - аналог лямбды

// Remember that :: is like a lambda, and it is used for deferred execution with a
// functional interface.

// There are four formats for method references:
// * Static methods
// * Instance methods on a particular instance
// * Instance methods on a parameter to be determined at runtime
// * Constructors

// Ниже про каждый из 4х форматов
/*
****
Calling Static Methods
The Collections class has a static method that can be used for sorting.
Consumer functional interface takes one parameter and does not return anything.

14: Consumer<List<Integer>> methodRef = Collections::sort;
15: Consumer<List<Integer>> lambda = x -> Collections.sort(x);

****
Calling Instance Methods on a Particular Object

Predicate is a functional interface that takes one parameter and returns a boolean

18: var str = "abc";
19: Predicate<String> methodRef = str::startsWith;
20: Predicate<String> lambda = s -> str.startsWith(s);

Supplier takes zero parameters and returns a value:

var random = new Random();
Supplier<Integer> methodRef = random::nextInt;
Supplier<Integer> lambda = () -> random.nextInt();

****
Calling Instance Methods on a Parameter

23: Predicate<String> methodRef = String::isEmpty;
24: Predicate<String> lambda = s -> s.isEmpty();

26: BiPredicate<String, String> methodRef = String::startsWith;
27: BiPredicate<String, String> lambda = (s, p) -> s.startsWith(p);

Since the functional interface takes two parameters, Java has to figure out what they represent. The first
one will always be the instance of the object for instance methods. Any others are to be method parameters.

****
Calling Constructors
It is common for a constructor reference to use a Supplier as shown here:

30: Supplier<List<String>> methodRef = ArrayList::new;
31: Supplier<List<String>> lambda = () -> new ArrayList();

Возвращает другой список
32: Function<Integer, List<String>> methodRef = ArrayList::new;
33: Function<Integer, List<String>> lambda = x -> new ArrayList(x);

 */


// Reviewing Method References
/*
Type                                      -  Example
Static methods                            - Collections::sort
Instance methods on a particular object   - str::startsWith
Instance methods on a parameter           - String::isEmpty
Constructor                               - ArrayList::new
 */

// Using Wrapper Classes
// There are two tricks in the space of autoboxing and unboxing.
// The first has to do with null values. This innocuous-looking code throws an exception:

// 15: var heights = new ArrayList<Integer>();
// 16: heights.add(null); - legal because a null reference can be assigned to any reference variable.
// 17: int h = heights.get(0); // NullPointerException - we try to unbox that null to an int primitive.

// Speaking of null, one advantage of a wrapper class over a primitive is that it can hold a null value.
// Also, be careful when autoboxing into Integer. What do you think this code outputs?

// 23: List<Integer> numbers = new ArrayList<Integer>();
// 24: numbers.add(1);
// 25: numbers.add(Integer.valueOf(3));
// 26: numbers.add(Integer.valueOf(5));  //  [1, 3, 5].
// 27: numbers.remove(1);     // удаляем элемент с индексом 1
        // The remove() method is overloaded. One signature takes an int as the
        //index of the element to remove. The other takes an Object that should be removed.
// 28: numbers.remove(Integer.valueOf(5));  // удаляем 5ку
// 29: System.out.println(numbers);     [1]

// It actually outputs [1].



// Using the Diamond Operator
// In the past, we would write code using generics like the following:

// List<Integer> list = new ArrayList<Integer>();
// Map<String,Integer> map = new HashMap<String,Integer>();

// The diamond operator cannot be used as the type in a variable declaration. It can be used only on the left
//side of an assignment operation

// List<> list = new ArrayList<Integer>(); // DOES NOT COMPILE
// Map<> map = new HashMap<String, Integer>(); // DOES NOT COMPILE
// class InvalidUse {
//  void use(List<> data) {} // DOES NOT COMPILE
// }


// var list = new ArrayList<Integer>();   - ArrayList<Integer>
// var list = new ArrayList<>();   - ArrayList<Object>


// Using Lists, Sets, Maps, and Queues
// There are four main interfaces in the Java Collections Framework.

// * List: A list is an ordered collection of elements that allows duplicate entries. Elements in a list can be
//   accessed by an int index.
// * Set: A set is a collection that does not allow duplicate entries.
// * Queue: A queue is a collection that orders its elements in a specific order for processing. A typical
//   queue processes its elements in a first-in, first-out order, but other orderings are possible.
// * Map: A map is a collection that maps keys to values, with no duplicate keys allowed. The elements in
//   a map are key/value pairs.

// Common Collections Methods

// add() - boolean add(E element)
// 3: Collection<String> list = new ArrayList<>();
// 4: System.out.println(list.add("Sparrow")); // true
// 5: System.out.println(list.add("Sparrow")); // true
// 6:
// 7: Collection<String> set = new HashSet<>();
// 8: System.out.println(set.add("Sparrow")); // true
// 9: System.out.println(set.add("Sparrow")); // false

// remove() - boolean remove(Object object)
// 3: Collection<String> birds = new ArrayList<>();
// 4: birds.add("hawk"); // [hawk]
// 5: birds.add("hawk"); // [hawk, hawk]
// 6: System.out.println(birds.remove("cardinal")); // false
// 7: System.out.println(birds.remove("hawk")); // true
// 8: System.out.println(birds); // [hawk]

// Java does not allow removing elements from a list while using the enhanced for loop.
// Collection<String> birds = new ArrayList<>();
// birds.add("hawk");
// birds.add("hawk");
// birds.add("hawk");
// for (String bird : birds) // ConcurrentModificationException
// birds.remove(bird);


// isEmpty() and size()  - boolean isEmpty(), int size()
// The following shows how to use these methods:

// Collection<String> birds = new ArrayList<>();
// System.out.println(birds.isEmpty()); // true
// System.out.println(birds.size()); // 0
// birds.add("hawk"); // [hawk]
// birds.add("hawk"); // [hawk, hawk]
// System.out.println(birds.isEmpty()); // false
// System.out.println(birds.size()); // 2

// clear() - void clear()

// The following shows how to use this method:
// Collection<String> birds = new ArrayList<>();
// birds.add("hawk"); // [hawk]
// birds.add("hawk"); // [hawk, hawk]
// System.out.println(birds.isEmpty()); // false
// System.out.println(birds.size()); // 2
// birds.clear(); // []
// System.out.println(birds.isEmpty()); // true
// System.out.println(birds.size()); // 0


// contains() - boolean contains(Object object)
// The contains() method calls equals() on elements of the ArrayList to see whether there are any matches
// The following shows how to use this method:

// Collection<String> birds = new ArrayList<>();
// birds.add("hawk"); // [hawk]
// System.out.println(birds.contains("hawk")); // true
// System.out.println(birds.contains("robin")); // false


// removeIf() - boolean removeIf(Predicate<? super E> filter)
// It uses a Predicate, which takes one parameter and returns a boolean. Let's take a look at an example:

//4: Collection<String> list = new ArrayList<>();
//5: list.add("Magician");
//6: list.add("Assistant");
//7: System.out.println(list); // [Magician, Assistant]
//8: list.removeIf(s -> s.startsWith("A"));
//9: System.out.println(list); // [Magician]

// Let's try one more example that does use a method reference.
// 11: Collection<String> set = new HashSet<>();
// 12: set.add("Wand");
// 13: set.add("");
// 14: set.removeIf(String::isEmpty); // s -> s.isEmpty()
// 15: System.out.println(set); // [Wand]

// forEach()  - void forEach(Consumer<? super T> action)
// Collection<String> cats = Arrays.asList("Annie", "Ripley");
// cats.forEach(System.out::println);
// cats.forEach(c -> System.out.println(c));

// Using the List Interface

//Creating a List with a Factory

/*
Arrays.asList(varargs) - Returns fixed size list backed by an array (Нельзя добавлять/удалять, можно replace)
List.of(varargs) - Returns immutable list  (нельзя добавлять, удалять, replace)
List.copyOf(collection) - Returns immutable list with copy of
    original collection's values  (нельзя добавлять, удалять, replace)

Let's take a look at an example of these three methods.
16: String[] array = new String[] {"a", "b", "c"};
17: List<String> asList = Arrays.asList(array); // [a, b, c]
18: List<String> of = List.of(array); // [a, b, c]
19: List<String> copy = List.copyOf(asList); // [a, b, c]
20:
21: array[0] = "z";
22:
23: System.out.println(asList); // [z, b, c]
24: System.out.println(of); // [a, b, c]
25: System.out.println(copy); // [a, b, c]
26:
27: asList.set(0, "x");
28: System.out.println(Arrays.toString(array)); // [x, b, c]
29:
30: copy.add("y"); // throws UnsupportedOperationException

 */


// Working with List Methods
/*
boolean add(E element)          : Adds element to end (available on all Collection APIs)
void add(int index, E element)  : Adds element at index and moves the rest toward the end
E get(int index)                : Returns element at index
E remove(int index)             : Removes element at index and moves the rest toward the front void
replaceAll(UnaryOperator<E> op) : Replaces each element in the list with the result of the operator
E set(int index, E e)           : Replaces element at index and returns original. Throws
                                  IndexOutOfBoundsException if the index is larger than the maximum
                                  one set
 */

// The following statements demonstrate most of these methods for working with a List:

// 3: List<String> list = new ArrayList<>();
// 4: list.add("SD"); // [SD]
// 5: list.add(0, "NY"); // [NY,SD]
// 6: list.set(1, "FL"); // [NY,FL]
// 7: System.out.println(list.get(0)); // NY
// 8: list.remove("NY"); // [FL]
// 9: list.remove(0); // []
// 10: list.set(0, "?"); // IndexOutOfBoundsException


// Now, let's look at using the replaceAll() method. It takes a UnaryOperator
// that takes one parameter and returns a value of the same type.

//List<Integer> numbers = Arrays.asList(1, 2, 3);
//numbers.replaceAll(x -> x*2);
//System.out.println(numbers); // [2, 4, 6]

// This lambda doubles the value of each element in the list. The replaceAll() method calls the lambda on
// each element of the list and replaces the value at that index.

// Iterating through a List
/*
Первый вариант
for (String string: list) {
    System.out.println(string);
}

Второй вариант
Iterator<String> iter = list.iterator();
while(iter.hasNext()) {
     String string = iter.next();
     System.out.println(string);
}
Pay attention to the difference between these techniques. The hasNext() method checks whether
there is a next value. In other words, it tells you whether next() will execute without throwing an
exception. The next() method actually moves the Iterator to the next element.
 */

// Using the Set Interface
// Working with Set Methods

// Like List, you can create an immutable Set in one line or make a copy of an existing one.
//Set<Character> letters = Set.of('z', 'o', 'o');
//Set<Character> copy = Set.copyOf(letters);

/*
You also have to know the differences between the types of sets. Let's start with HashSet:

3: Set<Integer> set = new HashSet<>();
4: boolean b1 = set.add(66); // true
5: boolean b2 = set.add(10); // true
6: boolean b3 = set.add(66); // false
7: boolean b4 = set.add(8); // true
8: set.forEach(System.out::println);

This code prints three lines:
66
8
10


// Now let's look at the same example with TreeSet.
3: Set<Integer> set = new TreeSet<>();   // TreeSet сортирует
4: boolean b1 = set.add(66); // true
5: boolean b2 = set.add(10); // true
6: boolean b3 = set.add(66); // false
7: boolean b4 = set.add(8); // true
8: set.forEach(System.out::println);

This time, the code prints the following:
8
10
66

// The elements are printed out in their natural sorted order.
// Numbers implement the Comparable interface in Java, which is used for sorting.

 */
// Using the Queue Interface
// Working with Queue Methods

//boolean add(E e) - Вставляет элемент в Queue. Если больше нет места для вставки, этот метод создает исключение.
//                   Метод возвращает true, если вставка выполнена успешно.
// boolean offer(Е оbj) - Вставляет элемент в Queue. Если в Queue больше нет пустого места
//                        или вставить не удалось, метод возвращает false.

// Е remove() - Возвращает первый элемент Queue и удаляет его из Queue.
//              Этот метод создает исключение, если в Queue нет элементов.
// Е роll() - озвращает первый элемент Queue и удаляет его из Queue.
//            Этот метод возвращает null, если в Queue нет элементов.

//E element()  - Возвращает первый элемент Queue, но не удаляет его из Queue.
//               Этот метод создает исключение, если в Queue нет элементов.
// Е peek() - Возвращает первый элемент Queue, но не удаляет его из Queue.
//            Этот метод возвращает null, если в Queue нет элементов.

// 12: Queue<Integer> queue = new LinkedList<>();
// 13: System.out.println(queue.offer(10)); // true
// 14: System.out.println(queue.offer(4)); // true
// 15: System.out.println(queue.peek()); // 10
// 16: System.out.println(queue.poll()); // 10
// 17: System.out.println(queue.poll()); // 4
// 18: System.out.println(queue.peek()); // null

// Using the Map Interface
// Map.of() and Map.copyOf()
// Map.of("key1", "value1", "key2", "value2");
// Map.of("key1", "value1", "key2"); // INCORRECT This code compiles but throws an error at runtime.

// Map.ofEntries(
// Map.entry("key1", "value1"),
// Map.entry("key1", "value1")
// );

// TreeMap – хранит элементы в порядке сортировки
// Класс LinkedHashMap расширяет HashMap. Он создает связный список элементов в карте,
// расположенных в том порядке, в котором они вставлялись.

// Working with Map Methods
/*
Method                                  : Description
void clear()                            : Removes all keys and values from the map.
boolean containsKey(Object key)         : Returns whether key is in map.
boolean containsValue(Object value)     : Returns whether value is in map.
Set<Map.Entry<K,V>> entrySet()          : Returns a Set of key/value pairs.
void forEach(BiConsumer(K key, V value))  : Loop through each key/value pair.
V get(Object key)                       : Returns the value mapped by key or null if none is mapped.
V getOrDefault(Object key, V defaultValue):  Returns the value mapped by the key or
                                              the default value if none is mapped.
boolean isEmpty()                       : Returns whether the map is empty.
Set<K> keySet()                         : Returns set of all keys.
V merge(K key, V value, Function(<V, V, V> func)) : Sets value if key not set.
                                                    Runs the function if the key is set to
                                                    determine the new value. Removes if null.
V put(K key, V value)                   : Adds or replaces key/value pair. Returns previous value or null.
V putIfAbsent(K key, V value)           : Adds value if key not present and returns null.
                                          Otherwise, returns existing value.
V remove(Object key)                    : Removes and returns value mapped to key. Returns null if none.
V replace(K key, V value)               : Replaces the value for a given key if the key is set. Returns the
                                          original value or null if none.
void replaceAll(BiFunction<K,V, V> func) : Replaces each value with the results of the function.
int size()                              : Returns the number of entries (key/value pairs) in the map.
Collection<V> values()                  : Returns Collection of all values.
 */


// Basic Methods

// Map<String, String> map = new HashMap<>();
// map.put("koala", "bamboo");
// map.put("lion", "meat");
// map.put("giraffe", "leaf");
// String food = map.get("koala"); // bamboo
// for (String key: map.keySet())
//  System.out.print(key + ","); // koala,giraffe,lion,


// Now let's look at TreeMap.

// Map<String, String> map = new TreeMap<>();
// map.put("koala", "bamboo");
// map.put("lion", "meat");
// map.put("giraffe", "leaf");
//  String food = map.get("koala"); // bamboo
//      for (String key: map.keySet())
//  System.out.print(key + ","); // giraffe,koala,lion,   // по алфавиту


// With our same map, we can try some boolean checks.
// System.out.println(map.contains("lion")); // DOES NOT COMPILE - нет такого метода у map, есть у Collection
// System.out.println(map.containsKey("lion")); // true
// System.out.println(map.containsValue("lion")); // false
// System.out.println(map.size()); // 3
// map.clear();
// System.out.println(map.size()); // 0
// System.out.println(map.isEmpty()); // true


// forEach() and entrySet()
// Map<Integer, Character> map = new HashMap<>();
//map.put(1, 'a');
//map.put(2, 'b');
//map.put(3, 'c');
//map.forEach((k, v) -> System.out.println(v));

// map.values().forEach(System.out::println); - распечатать только values

// map.entrySet().forEach(e ->
// System.out.println(e.getKey() + e.getValue()));  - перебор сета


// getOrDefault() - The get() method returns null if the requested key is not in map.

// 3: Map<Character, String> map = new HashMap<>();
//4: map.put('x', "spot");
//5: System.out.println("X marks the " + map.get('x'));
//6: System.out.println("X marks the " + map.getOrDefault('x', ""));
//7: System.out.println("Y marks the " + map.get('y'));
//8: System.out.println("Y marks the " + map.getOrDefault('y', ""));

// X marks the spot
// X marks the spot
// Y marks the null
// Y marks the


// replace() and replaceAll()

// These methods are similar to the Collection version except a key is involved.

// 21: Map<Integer, Integer> map = new HashMap<>();
// 22: map.put(1, 2);
// 23: map.put(2, 4);
// 24: Integer original = map.replace(2, 10); // 4 - вернул значение, которое заменили
// 25: System.out.println(map); // {1=2, 2=10}
// 26: map.replaceAll((k, v) -> k + v); // sets the value of each element of the map to the result of that function
// 27: System.out.println(map); // {1=3, 2=12}

// putIfAbsent()
// - The putIfAbsent() method sets a value in the map but skips it if the value
// is already set to a non- null value.
/*
Map<String, String> favorites = new HashMap<>();
favorites.put("Jenny", "Bus Tour");
favorites.put("Tom", null);
favorites.putIfAbsent("Jenny", "Tram");
favorites.putIfAbsent("Sam", "Tram");
favorites.putIfAbsent("Tom", "Tram"); // Tom was present as a key but had a null value.
System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
 */

// Comparing Collection Types
// Java Collections Framework types

/*
Type        duplicate?          ordered?        keys and values?      add/remove in specific order?
List        Yes                 Yes (by index)  No                    No
Map         Yes (for values)    No              Yes                   No
Queue       Yes                 Yes             No                    Yes
Set         No                  No              No                    No
 */

// Collection attributes
/*
Type        Java Collections Framework interface    Sorted?     Calls hashCode?     Calls compareTo?
ArrayList   List                                    No          No                  No
HashMap     Map                                     No          Yes                 No
HashSet     Set                                     No          Yes                 No
LinkedList  List, Queue                             No          No                  No
TreeMap     Map                                     Yes         No                  Yes
TreeSet     Set                                     Yes         No                  Yes

!!!     Next, the exam expects you to know which data structures allow null values.
        The data structures that involve sorting do not allow null values.
 */

// Sorting Data
//  Remember that numbers sort before letters, and uppercase letters sort before
//  lowercase letters.

// You can also sort objects that you create yourself. Java provides an interface called Comparable.
// If your class implements Comparable, it can be used in these data structures that require comparison.

// There is also a class called Comparator, which is used to specify that you want to use a different
// order than the object itself provides.



// Creating a Comparable Class
// The Comparable interface has only one method. In fact, this is the entire interface:
/*
    public interface Comparable<T> {
     int compareTo(T o);
    }
*/


// пример с Comparable
class Duck implements Comparable<Duck> {
    private String name;
    public Duck(String name) {
        this.name = name;
    }
    public String toString() { // use readable output
        return name;
    }
    public int compareTo(Duck d) {  // обязательно переопределить метод из Comparable
        return name.compareTo(d.name); // sorts ascendingly by name
    }
    public static void main(String[] args) {
        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        ducks.add(new Duck("Adolf"));
        Collections.sort(ducks); // sort by name
        System.out.println(ducks); // [Adolf, Puddles, Quack]
    }}
    // Without implementing that interface, all we have is a method named compareTo(),
// but it wouldn't be a Comparable object.

/*
We still need to know what the compareTo() method returns so that we can write our own. There are three
rules to know.
* The number 0 is returned when the current object is equivalent to the argument to compareTo().
* A negative number (less than 0) is returned when the current object is smaller than the argument to
compareTo().
* A positive number (greater than 0) is returned when the current object is larger than the argument to
compareTo().
 */
// Let's look at an implementation of compareTo() that compares numbers instead of String objects.
class Animal implements Comparable<Animal> {
private int id;
public int compareTo(Animal a) {
        return id - a.id; // sorts ascending by id
        }
    public static void main(String[] args) {
        var a1 = new Animal();
        var a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
} }

// Casting the compareTo() Argument
// When dealing with legacy code or code that does not use generics, the compareTo() method requires
// a cast since it is passed an Object.

class LegacyDuck implements Comparable {  // тут нет дженерика
    private String name;
    public int compareTo(Object obj) {  // поэтому тут Object
        LegacyDuck d = (LegacyDuck) obj; // cast because no generics
        return name.compareTo(d.name);
    }
}

// Checking for null
// When writing your own compare methods, you should check the data before
//comparing it if is not validated ahead of time.

class MissingDuck implements Comparable<MissingDuck> {
    private String name;
    public int compareTo(MissingDuck quack) {
        if (quack == null)
            throw new IllegalArgumentException("Poorly formed duck!");
        if (this.name == null && quack.name == null)
            return 0;
        else if (this.name == null) return -1;
        else if (quack.name == null) return 1;
        else return name.compareTo(quack.name);
    }
}

// Comparing Data with a Comparator
// Sometimes you want to sort an object that did not implement Comparable, or you want to sort objects in
//different ways at different times.


// import java.util.Comparator; - компоратор в этом (не дефолтном) пакете
// Comparable в java.lang (дефолтный пакет)

class Duck2 implements Comparable<Duck2> {
private String name;
private int weight;

    public Duck2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() { return name; }

        public int compareTo(Duck2 d) {
        return name.compareTo(d.name);
        }

        public static void main(String[] args) {
        // Сomparator using an inner class.
        Comparator<Duck2> byWeight = new Comparator<Duck2>() {
        public int compare(Duck2 d1, Duck2 d2) {  // тут метод compare
                return d1.getWeight()-d2.getWeight();
        }
        };
        // Comparator is a functional interface since there is only one abstract method to implement.
            // This means that we can rewrite the comparator on lines 18-22 using
            // a lambda expression, as shown here:
            // Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight()-d2.getWeight();

            // Alternatively, we can use a method reference and a helper method to specify we want to sort by weight.
            // Comparator<Duck> byWeight = Comparator.comparing(Duck::getWeight);

        var ducks = new ArrayList<Duck2>();
        ducks.add(new Duck2("Quack", 7));
        ducks.add(new Duck2("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]
        Collections.sort(ducks, byWeight);  // в sort вторым параметром - компоратор
        System.out.println(ducks); // [Quack, Puddles]
        }
}

// Comparison of Comparable and Comparator
/*
Difference                      Comparable              Comparator
Package name                    java.lang               java.util
Interface must be               Yes                     No
implemented by class
comparing?
Method name in interface        compareTo()             compare()
Number of parameters            1                       2
Common to declare using         No                      Yes
a lambda
 */

//  Do you see why this one doesn't compile?
    //var byWeight = new Comparator<Duck>() { // DOES NOT COMPILE
    // public int compareTo(Duck d1, Duck d2) { // must implement a method named compare().
    // return d1.getWeight()-d2.getWeight();
    // }
//};


// Comparing Multiple Fields
/*
Suppose that we have a Squirrel class, as shown here: (2 поля)

public class Squirrel {
 private int weight;
 private String species;
 // Assume getters/setters/constructors provided
}

We want to write a Comparator to sort by species name. If two squirrels are from the same species, we
want to sort the one that weighs the least first. We could do this with code that looks like this:

Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies)
 .thenComparingInt(Squirrel::getWeight);

 Suppose we want to sort in descending order by species.
 var c = Comparator.comparing(Squirrel::getSpecies).reversed();


 */

/*
Helper static! methods for building a Comparator

Method                          Description
comparing(function)           : Compare by the results of a function that returns any Object (or object
                              : autoboxed into an Object).
comparingDouble(function)     : Compare by the results of a function that returns a double.
comparingInt(function)        : Compare by the results of a function that returns an int.
comparingLong(function)       : Compare by the results of a function that returns a long.
naturalOrder()                : Sort using the order specified by the Comparable
                                implementation on the object itself.
reverseOrder()                : Sort using the reverse of the order specified by the Comparable
                                implementation on the object itself.
                                Comparator<MyObject> myComparator = Collections.reverseOrder();
 */

/*
Helper default methods for building a Comparator

Method                            Description

reversed()                      : Reverse the order of the chained Comparator.
thenComparing(function)         : If the previous Comparator returns 0, use this comparator that returns
                                  an Object or can be autoboxed into one.
thenComparingDouble(function)   : If the previous Comparator returns 0, use this comparator that returns
                                  a double. Otherwise, return the value from the previous Comparator.
thenComparingInt(function)      : If the previous Comparator returns 0, use this comparator that returns
                                  an int. Otherwise, return the value from the previous Comparator.
thenComparingLong(function)     : If the previous Comparator returns 0, use this comparator that returns
                                  a long. Otherwise, return the value from the previous Comparator.
 */




// Sorting and Searching
/*
public class SortRabbits {
    static class Rabbit{ int id; }
    public static void main(String[] args) {
    List<Rabbit> rabbits = new ArrayList<>();
    rabbits.add(new Rabbit());
    Collections.sort(rabbits); // DOES NOT COMPILE
} }

Java knows that the Rabbit class is not Comparable. It knows sorting will fail, so it doesn't even let the
code compile. You can fix this by passing a Comparator to sort().

public class SortRabbits {
static class Rabbit{ int id; }
public static void main(String[] args) {
List<Rabbit> rabbits = new ArrayList<>();
rabbits.add(new Rabbit());
Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
Collections.sort(rabbits, c);
} }
 */

// Reviewing binarySearch() - requests a binary search in !!!descending order
//The binarySearch() method requires a sorted List.

// 11: List<Integer> list = Arrays.asList(6,9,1,8);
// 12: Collections.sort(list); // [1, 6, 8, 9]
// 13: System.out.println(Collections.binarySearch(list, 6)); // 1
// 14: System.out.println(Collections.binarySearch(list, 3)); // -2


/*
Going back to our Rabbit that does not implement Comparable, we try to add it to a TreeSet.
public class UseTreeSet {
static class Rabbit{ int id; }
public static void main(String[] args) {
Set<Duck> ducks = new TreeSet<>();
ducks.add(new Duck("Puddles"));

Set<Rabbit> rabbits = new TreeSet<>();
rabbits.add(new Rabbit()); // ClassCastException
} }

// в TreeSet нужно вставлять компоратор

Set<Rabbit> rabbits = new TreeSet<>((r1, r2) -> r1.id-r2.id);
rabbits.add(new Rabbit());
 */


// Working with Generics
// Well, remember when we said that we had to hope the
// caller didn't put something in the list that we didn't expect? The following does just that:
/*
static void printNames(List list) {
    for (int i = 0; i < list.size(); i++) {
    String name = (String) list.get(i); // ClassCastException - ошибка StringBuilder -> String
                            // that java.lang .StringBuilder cannot be cast to java.lang.String.
    System.out.println(name);
    }
}
public static void main(String[] args) {
    List names = new ArrayList();
    names.add(new StringBuilder("Webby")); // добавить можно что угодно
    printNames(names);
}
 */

// Generic Classes

/*

For example, the following class named Crate has a generic type
variable declared after the name of the class.

public class Crate<T> {
    private T contents;
    public T emptyCrate() {
        return contents;
     }
 public void packCrate(T contents) {
 this.contents = contents;
 }
}
 */


/*
Naming Conventions for Generics
A type parameter can be named anything you want. The convention is to use single uppercase letters
to make it obvious that they aren't real class names. The following are common letters to use:
E for an element
K for a map key
V for a map value
N for a number
T for a generic data type
S, U, V, and so forth for multiple generic types
 */


/* пример использования дженерика
Elephant elephant = new Elephant();
Crate<Elephant> crateForElephant = new Crate<>();
crateForElephant.packCrate(elephant);
Elephant inNewHome = crateForElephant.emptyCrate();
 */


// Generic classes aren't limited to having a single type parameter. This class shows two generic parameters.
class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;
    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    } }


    // Generic Interfaces
    interface Shippable<T> {
        void ship(T t);
    }

    // There are three ways a class can approach implementing this interface.
// The first is to specify the generic type in the class.
    class ShippableRobotCrate implements Shippable<Robot> {
        public void ship(Robot t) { }
    }

// The next way is to create a generic class.
class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) { }
}

// The final way is to not use generics at all.
class ShippableCrate implements Shippable {
    public void ship(Object t) { }
}

// Generic Methods
// In this example, both methods use a generic parameter:
/*
public class Handler {
     public static <T> void prepare(T t) {
         System.out.println("Preparing " + t);
         }
         public static <T> Crate<T> ship(T t) {
         System.out.println("Shipping " + t);
         return new Crate<T>();
     }
}

// Before the return type, we declare the formal type parameter of <T>. In the ship() method,
// we show how you can use the generic parameter in the return type, Crate<T>, for the method.

2: public class More {
3: public static <T> void sink(T t) { } - formal parameter type immediately before the return type of void.
4: public static <T> T identity(T t) { return t; } - shows the return type being the formal parameter type.
5: public static T noGood(T t) { return t; } // DOES NOT COMPILE - omits the formal parameter type
6: }
 */

// криво, но так можно
// Box.<String>ship("package");
// Box.<String[]>ship(args);


/*
// When you have a method declare a generic parameter type, it is independent of the class generics.
// Take a look at this class that declares a generic T at both levels:
*/

class Crate<T> {   // - T is Robot because that is what gets referenced when constructing a Crate
   public <T> T tricky(T t) { // - T is String because that is what is passed to the method.
     return t;
   }
 }
/*
See if you can figure out the type of T on lines 1 and 2 when we call the code as follows:
*/

class TestG1 {
    public static void main(String[] args) {
        System.out.println(createName());
    }

    public static String createName() {
        Crate<Robot> crate = new Crate<>();
        return crate.tricky("bot");
    }
}

// Bounding Generic Types
// Types of bounds
/*
Type of bound                   Syntax                  Example
Unbounded wildcard              ?                       List<?> a = new ArrayList<String>();
Wildcard with an upper bound    ? extends type          List<? extends Exception> a = new
                                                        ArrayList<RuntimeException>();
Wildcard with a lower bound     ? super type            List<? super Exception> a = new ArrayList<Object>();
 */

// Unbounded Wildcards - represents any data type.
// Let's suppose that we want to write a method that looks through a list of any type.

/*

public static void printList(List<Object> list) {
    for (Object x: list)
        System.out.println(x);
    }
public static void main(String[] args) {
    List<String> keywords = new ArrayList<>();
    keywords.add("java");
    printList(keywords); // DOES NOT COMPILE
}

// так ок
public static void printList(List<?> list) {
for (Object x: list)
 System.out.println(x);
}
public static void main(String[] args) {
 List<String> keywords = new ArrayList<>();
 keywords.add("java");
 printList(keywords);
}


// еще пример
4: List<Integer> numbers = new ArrayList<>();
5: numbers.add(new Integer(42));
6: List<Object> objects = numbers; // DOES NOT COMPILE
7: objects.add("forty two");
8: System.out.println(numbers.get(1));


// Finally, let's look at the impact of var. Do you think these two statements are equivalent?

//  List<?> x1 = new ArrayList<>();
//  var x2 = new ArrayList<>();

// They are not. There are two key differences. First, x1 is of type List, while x2 is of type ArrayList.
 */

// Upper-Bounded Wildcards
// We've established that a generic type can't just use a subclass.
// ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
//Instead, we need to use a wildcard.
//List<? extends Number> list = new ArrayList<Integer>();

// The upper-bounded wildcard says that any class that extends Number or Number itself can be used as the
//formal parameter type:
/*
public static long total(List<? extends Number> list) {
 long count = 0;
 for (Number number: list)
 count += number.longValue();
 return count;
}
 */

// Lower-Bounded Wildcards
// Let's try to write a method that adds a string “quack” to two lists.
/*
List<String> strings = new ArrayList<String>();
strings.add("tweet");
List<Object> objects = new ArrayList<Object>(strings);
addSound(strings);
addSound(objects);

// The problem is that we want to pass a List<String> and a List<Object> to the same method.

не забудь, что метод addSound не может быть unbounded или upper-bounded, т.к. они неизменяемые


// To solve this problem, we need to use a lower bound.

public static void addSound(List<? super String> list) {
 list.add("quack");
}

// With a lower bound, we are telling Java that the list will be a list of String objects or a list of some objects
//that are a superclass of String.

 */

// Understand Generic Supertypes
// When you have subclasses and superclasses, lower bounds can get tricky.

// 3: List<? super IOException> exceptions = new ArrayList<Exception>();
// 4: exceptions.add(new Exception()); // DOES NOT COMPILE Exception родитель IOException
// 5: exceptions.add(new IOException());
// 6: exceptions.add(new FileNotFoundException());

// Line 3 references a List that could be List<IOException> or List<Exception> or List<Object>.
// Line 4 does not compile because we could have a List<IOException> and an Exception object
// wouldn't fit in there.
// Line 5 is fine. IOException can be added to any of those types. Line 6 is also fine.

// Putting It All Together
// Combining Generic Declarations
// Let's try an example. First, we declare three classes that the example will use.

class A {}
class B extends A {}
class C extends B {}

//Ready? Can you figure out why these do or don't compile? Also, try to figure out what they do.

class GenEx1 {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<A>(); // You can have ArrayList<A>,
                                    // ArrayList<B>, or ArrayList<C> stored in that reference
        List<? super A> list3 = new ArrayList<A>();
    }
    // Did you get those right? Let's try a few more.
//    List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE - все потомки B (B,C можно)
    List<? super B> list5 = new ArrayList<A>();  // все родители B (A,B можно)
//    List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE - так нельзя
}

// Passing Generic Arguments
/*
<T> T first(List<? extends T> list) {
 return list.get(0);
} // It takes a parameter of List<T>, or some subclass of T, and it returns a single object of that T type.

// так будет ошибка
<T> <? extends T> second(List<? extends T> list) { // DOES NOT COMPILE
 return list.get(0); //  return type isn't actually a type.
}
 */

/*
Now be careful—this one is extra tricky:
<B extends A> B third(List<B> list) {
 return new B(); // DOES NOT COMPILE
}

This method, third(), does not compile. <B extends A> says that you want to use B as a type parameter
just for this method and that it needs to extend the A class. Coincidentally, B is also the name of a class. It
isn't a coincidence. It's an evil trick. Within the scope of the method, B can represent class A, B, or C,
because all extend the A class. Since B no longer refers to the B class in the method, you can't instantiate it.
 */

/*
After that, it would be nice to get something straightforward.

void fourth(List<? super B> list) {}

We finally get a method, fourth(), which is a normal use of generics. You can pass the types List<B>,
List<A>, or List<Object>.

Finally, can you figure out why this example does not compile?

<X> void fifth(List<X super B> list) { // DOES NOT COMPILE
}
This last method, fifth(), does not compile because it tries to mix a method-specific type parameter with
a wildcard. A wildcard must have a ? in it.
 */


// merge
class MergeEx{
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("ID123", "Joe");
        System.out.println(map);
        String merge = map.merge("ID123", "addSome", (x, y) -> x + y);
        System.out.println(merge);  // JoeaddSome

        // Если такое значение отсутсвует, то просто добавиться пара в мапу
        map.merge("ID124", "Sasha", (x, y) -> x + y); // {ID123=JoeaddSome, ID124=Sasha}
        System.out.println(map);

        // если лямбда - null - будет удаление по ключу
        map.merge("ID124", "Sasha", (x, y) -> null);
        System.out.println(map);   // {ID123=JoeaddSome}

        map.merge(null, "Sasha", (x, y) -> null); // так можно
        System.out.println("key - null " + map);

        map.merge("ID124", null, (x, y) -> null); // так будет рантайм ошибка, map нельзя null
        System.out.println("value - null " + map);

        map.merge("ID124", "ID124", null);  // так нельзя NPE

        map.merge("ID124", "ID124", (x, y) -> map.put("1","2")); // не отработает, просто добавит "ID124"
        map.merge("ID124", "ID124", (x, y) -> map.put("1","2")); // вторая строка уже сломает
        // мы найдем "ID124" и попытаемся вставить в мапу налету, будет ошибка конкаренси
    }
}












