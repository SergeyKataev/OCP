package Chapter3;

import java.util.*;

public class Q_3 {
}

class Q3_1 {
    // 1. Suppose that you have a collection of products for sale in a database and you need to display those
    // products. The products are not unique. Which of the following collections classes in the java.util
    // package best suits your needs for this scenario?

    // A. Arrays            // utility class
    // B. ArrayList         // Интерфейс
    // C. HashMap           //  Set
    // D. HashSet           //  Set
    // E. LinkedList  //  is both a List and a Queue - ArrayList is better
}

class Q3_2 {
    // Suppose that you need to work with a collection of elements that need to be sorted in their natural
    // order, and each element has a unique text id that you want to use to store and retrieve the record.
    // Which of the following collections classes in the java.util package best suits your needs for this
    // scenario?
    // A. ArrayList  // не дает уникальность
    // B. HashMap   // не дает натуральной сортировки
    // C. HashSet   // не дает натуральной сортировки
    // D. TreeMap   // Correct
    // E. TreeSet   // не позволяет хранить структуру id: record
    // F. None of the above
}

class Q3_3 {
    // 3. Which of the following are true? (Choose all that apply.)

    // 12: List<?> q = List.of("mouse", "parrot");  // List<Object>
    // 13: var v = List.of("mouse", "parrot");   // creates a List<String> -  type deduces from the context.
    // 14:
    // 15: q.removeIf(String::isEmpty);         //  isEmpty нет у Object
    // 16: q.removeIf(s -> s.length() == 4);    //  length() нет у Object
    // 17: v.removeIf(String::isEmpty);         UnsupportedOperationException if run (List.Of менять нельзя)
    // 18: v.removeIf(s -> s.length() == 4);    UnsupportedOperationException if run (List.Of менять нельзя)

    //A. This code compiles and runs without error.
    //B. Exactly one of these lines contains a compiler error.
    //C. Exactly two of these lines contain a compiler error.   // Correct
    //D. Exactly three of these lines contain a compiler error.
    //E. Exactly four of these lines contain a compiler error.
    //F. If any lines with compiler errors are removed, this code runs without throwing an exception.
    //G. If all lines with compiler errors are removed, this code throws an exception. // Correct
}

class Q3_4 {
    // 4. What is the result of the following statements?

    // 3: var greetings = new LinkedList<String>(); можно методы List и Queue
    // LinkedList содержит методы push and pop
    // push inserts the element at the front of the list.
    // pop removes and returns the first element of the list.
    // 4: greetings.offer("hello"); // offer = add
    // 5: greetings.offer("hi");
    // 6: greetings.offer("ola");
    // 7: greetings.pop();  // достает и удаляет первый элемент
    // 8: greetings.peek(); // peek = element - не удаляет
    // 9: while (greetings.peek() != null)
    // 10: System.out.print(greetings.pop());  // hiola

    //A. hello
    //B. hellohi
    //C. hellohiola
    //D. hiola                  // Correct
    //E. ola
    //F. The code does not compile.
    //G. An exception is thrown
}

class Q3_5 {
    // 5. Which of these statements compile? (Choose all that apply.)

    // A. HashSet<Number> hs = new HashSet<Integer>();  // нельзя, должны быть однаковые
            // HashSet<? extends Number> hs2 = new HashSet<Integer>();. - так норм
    // B. HashSet<? super ClassCastException> set = new HashSet<Exception>(); // Correct
    // C. List<> list = new ArrayList<String>();  <> нельзя
    // D. List<Object> values = new HashSet<Object>();  // List и HashSet нельзя
    // E. List<Object> objects = new ArrayList<? extends Object>();  <? extends Object> надо слева
    // F. Map<String, ? extends Number> hm = new HashMap<String, Integer>();  // Correct
    //      <String, ? extends Number> так можно
}

class Hello<T> {
    T t;
    public Hello(T t) { this.t = t; }
    public String toString() { return t.toString(); } // .toString() можно вызвать у кого угодно
    private <T> void println(T message) { // <T> указывает на то, с каким типом можно вызвать println
    System.out.print(t + "-" + message);
    }
    public static void main(String[] args) {
    new Hello<String>("hi").println(1);   // int в println -> autoboxed to Integer
     new Hello("hola").println(true); // true можно передавать в print
    // тут будет предупреждение, но не ошибка, что не используем generic
} }

class Q3_6 {
    // What is the result of the following code?

    // A. hi followed by a runtime exception
    // B. hi-1hola-true                 // Correct
    // C. The first compiler error is on line 1.
    // D. The first compiler error is on line 4.
    // E. The first compiler error is on line 5.
    // F. The first compiler error is on line 9.
    // G. The first compiler error is on line 10.
}

class Q3_7_ex {
    public static void main(String[] args) {
         var numbers = new HashSet<Number>();
         numbers.add(Integer.valueOf(86));
         numbers.add(75);
         numbers.add(Integer.valueOf(86));
         numbers.add(null);    // null нормально распечатется
         numbers.add(309L);
         Iterator iter = numbers.iterator();
         while (iter.hasNext())
         System.out.print(iter.next());
//        System.out.println(null); // так нельзя
        System.out.println((Number)null); // так можно
    }
}

class Q3_7 {
    // Which of the following statements are true? (Choose all that apply.)

    // 3: var numbers = new HashSet<Number>();
    // 4: numbers.add(Integer.valueOf(86));
    // 5: numbers.add(75);
    // 6: numbers.add(Integer.valueOf(86));
    // 7: numbers.add(null);
    // 8: numbers.add(309L);
    // 9: Iterator iter = numbers.iterator();
    // 10: while (iter.hasNext())
    // 11: System.out.print(iter.next());

    // A. The code compiles successfully.   // Correct
    // B. The output is 8675null309.
    // C. The output is 867586null309.
    // D. The output is indeterminate.      // Correct - HashSet не гарантирует последовательности
    // E. There is a compiler error on line 3.
    // F. There is a compiler error on line 9.
    // G. An exception is thrown.
}

class Q3_8 {
    // Which of the following can fill in the blank to print [7, 5, 3]? (Choose all that apply.)

    // 3: public class Platypus {
    // 4: String name;
    // 5: int beakLength;
    // 6:
    // 7: // Assume getters/setters/constructors provided
    // 8:
    // 9: public String toString() {return "" + beakLength;}
    // 10:
    // 11: public static void main(String[] args) {
    // 12: Platypus p1 = new Platypus("Paula", 3);
    // 13: Platypus p2 = new Platypus("Peter", 5);
    // 14: Platypus p3 = new Platypus("Peter", 7);
    // 15:
    // 16: List<Platypus> list = Arrays.asList(p1, p2, p3);
    // 17:
    // 18: Collections.sort(list, Comparator.comparing _______________ );
    // 19:
    // 20: System.out.println(list);
    // 21: }
    // 22: }


    // A.                           // ascending order by beakLength.
    // (Platypus::getBeakLength)    [3 5 7]

    // B.                           // Correct
    // (Platypus::getBeakLength).reversed()

    //C.                            // ascending order by beakLength.
    // (Platypus::getName)
    // .thenComparing(Platypus::getBeakLength)

    //D.                             // it sorts by name in ascending order and only reverses the beak length of
                                     //those with the same name. getName: [3 5 7] -> getBeakLength: [7 5 3]
    // (Platypus::getName)
    // .thenComparing(
    // Comparator.comparing(Platypus::getBeakLength)
    // .reversed())

    //E.            // there is no thenComparingNumber()
    // (Platypus::getName)
    // .thenComparingNumber(Platypus::getBeakLength)
    // .reversed()

    //F.           // Correct        // creates a comparator that sorts by name in ascending order and
                                    //then by beak size in ascending order
                                    // getName: [3 5 7] -> getBeakLength: [3 5 7]
    // (Platypus::getName)
    // .thenComparingInt(Platypus::getBeakLength)
    // .reversed()

    //G.     None of the above
}

class Q3_9 {
    // 9. Which of the answer choices are valid given the following code? (Choose all that apply.)

    // Map<String, Double> map = new HashMap<>(); // Map interface uses put() rather than add()

    //A. map.add("pi", 3.14159); // если put, то ОК
    //B. map.add("e", 2L);  2L нельзя к Double, без явного каста
    //C. map.add("log(1)", new Double(0.0));    // если put, то ОК
    //D. map.add('x', new Double(123.4));   Char нельзя к String
    //E. None of the above          // Correct
}

class Q3_10 {
    // 10. What is the result of the following program?

    // 3: public class MyComparator implements Comparator<String> {
    // 4: public int compare(String a, String b) {
    // 5: return b.toLowerCase().compareTo(a.toLowerCase()); // reverse order b.compareTo(a)
    // 6: }
    // 7: public static void main(String[] args) {
    // 8: String[] values = { "123", "Abb", "aab" };
    // 9: Arrays.sort(values, new MyComparator()); // 123 aab abb -> Abb aab 123
    // 10: for (var s: values)
    // 11: System.out.print(s + " ");
    // 12: }
    // 13: }

    // A. Abb aab 123           // Correct
    // B. aab Abb 123
    // C. 123 Abb aab
    // D. 123 aab Abb
    // E. The code does not compile.
    // F. A runtime exception is thrown
}

class Q3_11 {
    // What is the result of the following code?

    // 3: var map = new HashMap<Integer, Integer>(10);
    // 4: for (int i = 1; i <= 10; i++) {
    // 5: map.put(i, i * i); 1:1, 2:4, 3:3, 4:4
    // 6: }
    // 7: System.out.println(map.get(4));

    //A. 16              // Correct
    //B. 25
    //C. Compiler error on line 3.
    //D. Compiler error on line 5.
    //E. Compiler error on line 7.
    //F. A runtime exception is thrown.
}

class Q3_12 {
    // Which of these statements can fill in the blank so that the Helper class compiles successfully?
    //(Choose all that apply.)

    // 2: public class Helper {
    // 3: public static <U extends Exception>
    // 4: void printException(U u) {
    // 5:
    // 6: System.out.println(u.getMessage());
    // 7: }
    // 8: public static void main(String[] args) {
    // 9: Helper.________________________________;
    // 10: } }

    //A. printException(new FileNotFoundException("A"))  // Correct    FileNotFoundException extends Exception
    //B. printException(new Exception("B"))     // Correct    Exception можно
    //C. <Throwable>printException(new Exception("C"))  // Throwable супер класс, нельзя
    //D. <NullPointerException>printException(new NullPointerException ("D"))   // Correct, odd but correct
                        // FileNotFoundException extends IOException extends Exception
    //E. printException(new Throwable("E"))   // Throwable супер класс, нельзя
}

class Q3_13 {
    // Which of these statements can fill in the blank so that the Wildcard class compiles successfully?
    // (Choose all that apply.)

    // 3: public class Wildcard {
    // 4: public void showSize(List<?> list) {
    // 5: System.out.println(list.size());
    // 6: }
    // 7: public static void main(String[] args) {
    // 8: Wildcard card = new Wildcard();
    // 9: __________________________________;
    // 10: card.showSize(list);
    // 11: } }

    // A. List<?> list = new HashSet <String>() // List и HashSet нельзя
    // B. ArrayList<? super Date> list = new ArrayList<Date>() // Correct
    // C. List<?> list = new ArrayList<?>()         // слева нельзя ?
    // D. List<Exception> list = new LinkedList<java.io.IOException>()  // должны совпадать
    // E. ArrayList <? extends Number> list = new ArrayList <Integer>() // Correct
}

class Q3_14 {
    // 14. What is the result of the following program?

    // 3: public class Sorted
    // 4: implements Comparable<Sorted>, Comparator<Sorted> {
    // 5:
    // 6: private int num;
    // 7: private String text;
    // 8:
    // 9: // Assume getters/setters/constructors provided
    // 10:
    // 11: public String toString() { return "" + num; }
    // 12: public int compareTo(Sorted s) {
    // 13: return text.compareTo(s.text);
    // 14: }
    // 15: public int compare(Sorted s1, Sorted s2) {
    // 16: return s1.num - s2.num;
    // 17: }
    // 18: public static void main(String[] args) {
    // 19: var s1 = new Sorted(88, "a");
    // 20: var s2 = new Sorted(55, "b");
    // 21: var t1 = new TreeSet<Sorted>();
    // 22: t1.add(s1); t1.add(s2);
    // 23: var t2 = new TreeSet<Sorted>(s1);
    // 24: t2.add(s1); t2.add(s2);
    // 25: System.out.println(t1 + " " + t2);
    // 26: } }

    // A. [55, 88] [55, 88]
    // B. [55, 88] [88, 55]
    // C. [88, 55] [55, 88] // Correct
    // D. [88, 55] [88, 55]
    // E. The code does not compile.
    // F. A runtime exception is thrown.
}

class Q3_15_ex {
    public static void main(String[] args) {
        Comparator<Integer> c1 = (o1, o2) -> o2 - o1;
         var list = Arrays.asList(5, 4, 7, 2);
         Collections.sort(list,c1);
         System.out.println(Collections.binarySearch(list, 2)); // -1
    }
}


class Q3_15 {
    // What is the result of the following code? (Choose all that apply.)

    // Comparator<Integer> c1 = (o1, o2) -> o2 - o1;  // reverse order
    // Comparator<Integer> c2 = Comparator.naturalOrder();
    // Comparator<Integer> c3 = Comparator.reverseOrder();
    // var list = Arrays.asList(5, 4, 7, 2);
    // Collections.sort(list,_____________);
    // System.out.println(Collections.binarySearch(list, 2));

    // A. One or more of the comparators can fill in the blank so that the code prints 0. // Correct
    // B. One or more of the comparators can fill in the blank so that the code prints 1.
    // C. One or more of the comparators can fill in the blank so that the code prints 2.
    // D. The result is undefined regardless of which comparator is used.
    // E. A runtime exception is thrown regardless of which comparator is used.
    // F. The code does not compile.

    // The other two comparators sort in descending order. Therefore, the precondition
    //for binarySearch() is not met, and the result is undefined for those two
}


class Q3_16 {
    // 16. Which of the following statements are true? (Choose all that apply.)

    // A. Comparable is in the java.util package.  // java.lang - default
    // B. Comparator is in the java.util package. // Correct
    // C. compare() is in the Comparable interface. Comparable - CompareTo
    // D. compare() is in the Comparator interface. // Correct
    // E. compare() takes one method parameter.         // CompareTo - 1 параметр
    // F. compare() takes two method parameters.    // Correct
}

class Q3_17 {
    // 17. Which options can fill in the blanks to make this code compile? (Choose all that apply.)

    // 1: public class Generic____________{
    // 2: public static void main(String[] args) {
    // 3: Generic<String> g = new Generic_____________();
    // 4: Generic<Object> g2 = new Generic();
    // 5: }
    // 6: }

    // A. On line 1, fill in with <>. // нельзя
    // B. On line 1, fill in with <T>.  // Correct
    // C. On line 1, fill in with <?>.  // нельзя, для класса нужна буква
    // D. On line 3, fill in with <>.   // оставить открытым можно для класса
    // E. On line 3, fill in with <T>.  // это не класс, который тут должен быть
    // F. On line 3, fill in with <?>.      // нельзя, тут надо указать тип
}

class Q3_18 {
    // 18. Which of the following lines can be inserted to make the code compile? (Choose all that apply.)

    // class W {}
    // class X extends W {}
    // class Y extends X {}
    // class Z<Y> {
    // // INSERT CODE HERE
    // }

    // A. W w1 = new W();  // Correct
    // B. W w2 = new X();   // Correct
    // C. W w3 = new Y();   // Y нельзя использовать и воспринимать как класс
    // D. Y y1 = new W();   // Y нельзя использовать и воспринимать как класс
    // E. Y y2 = new X();   // Y нельзя использовать и воспринимать как класс
    // F. Y y1 = new Y();  // Y нельзя использовать и воспринимать как класс

    // Y is both a class and a type parameter. This means that within the class Z, when we refer to Y, it
    // uses the type parameter. All of the choices that mention class Y are incorrect because it no longer
    // means the class Y.
}

class Q3_19 {
    // Which options are true of the following code? (Choose all that apply.)

    // 3:_______________<Integer> q = new LinkedList<>(); // A LinkedList implements both List and Queue
    // 4: q.add(10);
    // 5: q.add(12);
    // 6: q.remove(1);
    // 7: System.out.print(q);

    //A. If we fill in the blank with List, the output is [10].     // Correct
    //B. If we fill in the blank with List, the output is [10, 12].
    //C. If we fill in the blank with Queue, the output is [10].
    //D. If we fill in the blank with Queue, the output is [10, 12].  // Correct
    //E. The code does not compile in either scenario.
    //F. A runtime exception is thrown.

    // The List interface has a method to remove by
    //index. Since this method exists, Java does not autobox to call the other method. Queue has only the
    //remove by object method, so Java does autobox there. Since the number 1 is not in the list, Java does
    //not remove anything for the Queue.
}

class Q3_20 {
    // What is the result of the following code?

    // 4: Map m = new HashMap();
    // 5: m.put(123, "456");
    // 6: m.put("abc", "def");
    // 7: System.out.println(m.contains("123")); // у Map нет contains. Только containsKey

    // A. false
    // B. true
    // C. Compiler error on line 4
    // D. Compiler error on line 5
    // E. Compiler error on line 7  // Correct
    // F. A runtime exception is thrown
}

class Q3_21 {
    // What is the result of the following code? (Choose all that apply.)

    // 48: var map = Map.of(1,2, 3, 6);
    // 49: var list = List.copyOf(map.entrySet());  List<Entry<Integer, Integer>>
                // error on line 56 since we can't multiply an Entry object by two
    // 50:
    // 51: List<Integer> one = List.of(8, 16, 2);   //  List<Integer>   неизменяемый
    // 52: var copy = List.copyOf(one);             //  List<Integer>   неизменяемый
    // 53: var copyOfCopy = List.copyOf(copy);      //  List<Integer>  неизменяемый
    // 54: var thirdCopy = new ArrayList<>(copyOfCopy); //  List<Integer>   is mutable
    // 55:
    // 56: list.replaceAll(x -> x * 2); list (List.copyOf) - нельзя replace
    // 57: one.replaceAll(x -> x * 2);  throws an UnsupportedOperationException
    // 58: thirdCopy.replaceAll(x -> x * 2);    // тут будет ок
    // 59:
    // 60: System.out.println(thirdCopy);

    //A. One line fails to compile.     // Correct
    //B. Two lines fail to compile.
    //C. Three lines fail to compile.
    //D. The code compiles but throws an exception at runtime.
    //E. If any lines with compiler errors are removed, the code throws an exception at runtime.    // Correct
    //F. If any lines with compiler errors are removed, the code prints [16, 32, 4].
    //G. The code compiles and prints [16, 32, 4] without any changes.
}

class Q3_22 {
    // 22. What code change is needed to make the method compile assuming there is no class named T?

    // public static T identity(T t) {
    // return t;
    //}

    // A. Add <T> after the public keyword.
    // B. Add <T> after the static keyword. дженерик в методе <T> ставят перед return type
    // C. Add <T> after T.
    // D. Add <?> after the public keyword.
    // E. Add <?> after the static keyword.
    // F. No change required. The code already compiles.
}

class Q3_23 {
    // Which of the answer choices make sense to implement with a lambda? (Choose all that apply.)

    // A. Comparable interface
        //  Это интерфейс, но Comparable is intended to be used on the object being compared
    // B. Comparator interface      // Correct
    // C. remove method on a Collection
        //  takes an instance of an object to look for in the Collection to remove.
    // D. removeAll method on a Collection
        // takes a Collection of objects to look for in the Collection to remove.
    // E. removeIf method on a Collection       // Correct
        // allows specifying the lambda to check when removing elements
}

class Q3_24 {
    // 24. Which of the following compiles and prints out the entire set? (Choose all that apply.)

    // Set<?> set = Set.of("lion", "tiger", "bear");
    // var s = Set.copyOf(set);
    // s.forEach(______________________);

    // A. () -> System.out.println(s)   // нужен 1 параментр для forEach
    // B. s -> System.out.println(s)    // s уже определена
    // C. (s) -> System.out.println(s)  // s уже определена
    // D. System.out.println(s)         // s уже определена
    // E. System::out::println          // некорректный синтаксис
    // F. System.out::println           // Correct
    // G. None of the above
}

class Q3_25 {
    // 25. What is the result of the following?

    // var map = new HashMap<Integer, Integer>();
    // map.put(1, 10);
    // map.put(2, 20);
    // map.put(3, null);
    // map.merge(1, 3, (a,b) -> a + b); // к 1му ключу, value3 - a+b  {1=13, 2=20, 3=null}
    // map.merge(3, 3, (a,b) -> a + b); // к 3му ключу, value3 - a+b  {1=13, 2=20, 3=3}
    // System.out.println(map);

    // A. {1=10, 2=20}
    // B. {1=10, 2=20, 3=null}
    // C. {1=10, 2=20, 3=3}
    // D. {1=13, 2=20}
    // E. {1=13, 2=20, 3=null}
    // F. {1=13, 2=20, 3=3}         // Correct
    // G. The code does not compile.
    // H. An exception is thrown.
}