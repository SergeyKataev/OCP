package Chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class GenericsAndCollections {
}

// Using Method References
@FunctionalInterface
interface LearnToSpeak {
    void speak(String sound);
}

class DuckHelper {
    public static void teacher(String name, LearnToSpeak trainer) {

        // exercise patience
        trainer.speak(name);
    }
}

class Duckling {
    public static void makeSound(String sound) {
        LearnToSpeak learner = s -> System.out.println(s);
        DuckHelper.teacher(sound, learner);
    }
}

// A method reference lets us remove that redundancy and instead write this:
// LearnToSpeak learner = System.out::println;

// Remember that :: is like a lambda, and it is used for deferred execution with a
// functional interface.

// There are four formats for method references:
// * Static methods
// * Instance methods on a particular instance
// * Instance methods on a parameter to be determined at runtime
// * Constructors


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
Type : Example
Static methods                            - Collections::sort
Instance methods on a particular object   - str::startsWith
Instance methods on a parameter           - String::isEmpty
Constructor                               - ArrayList::new
 */

// Using Wrapper Classes
// There are two tricks in the space of autoboxing and unboxing. The first has to do with null values. This
// innocuous-looking code throws an exception:

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
3: Set<Integer> set = new TreeSet<>();
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


// пример с компоратором
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































