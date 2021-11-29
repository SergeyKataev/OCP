package Chapter5;

import java.util.*;

import static java.lang.Boolean.TRUE;

public class CoreApiJava {
}

class CreatingAndManipulatingStrings{
    public static void main(String[] args) {
        System.out.println(1 + 2); // 3
        System.out.println("a" + "b"); // ab
        System.out.println("a" + "b" + 3); // ab3
        System.out.println(1 + 2 + "c"); // 3c
        System.out.println("c" + 1 + 2); // c12

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);  //64

        String s = "1"; // s currently holds "1"
        s += "2"; // s currently holds "12"
        s += 3; // s currently holds "123"
        System.out.println(s); // 123

        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");             // будет создан новый String, который не присвоится s2
        System.out.println("s2 " + s2);  //12
    }
}

class Apis{
    public static void main(String[] args) {
        String string = "animals";
        System.out.println(string.length()); // 7
        System.out.println();

        String string1 = "animals";
        System.out.println(string1.charAt(0)); // a
        System.out.println(string1.charAt(6)); // s
        // System.out.println(string1.charAt(7)); // throws exception
        System.out.println();

        String string2 = "animals";
        System.out.println(string2.indexOf('a')); // 0
        System.out.println(string2.indexOf("al")); // 4
        System.out.println(string2.indexOf('a', 4)); // 4
        System.out.println(string2.indexOf("al", 5)); // -1
        System.out.println();

        String string3 = "animals";
        System.out.println(string3.substring(3)); // mals
        System.out.println(string3.substring(string3.indexOf('m'))); // mals
        System.out.println(string3.substring(3, 4)); // m
        System.out.println(string3.substring(3, 7)); // mals
        System.out.println();

        System.out.println(string.substring(3, 3)); // empty string
//        System.out.println(string.substring(3, 2)); // throws exception
//        System.out.println(string.substring(3, 8)); // throws exception
        System.out.println();

        String string4 = "animals";
        System.out.println(string4.toUpperCase()); // ANIMALS
        System.out.println("Abc123".toLowerCase()); // abc123
        System.out.println();

        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("abc".equalsIgnoreCase("ABC")); // true
        System.out.println();

        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false
        System.out.println("abc".endsWith("c")); // true
        System.out.println("abc".endsWith("a")); // false
        System.out.println();

        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("a", "A")); // AbcAbc
        System.out.println();

        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false
        System.out.println();

        System.out.println("abc".strip()); // abc
        System.out.println("\t a b c\n".strip()); // a b c
        String text = " abc\t ";
        System.out.println(text.trim().length()); // 3
        System.out.println(text.strip().length()); // 3
        System.out.println(text.stripLeading().length()); // 5
        System.out.println(text.stripTrailing().length());// 4

        String a = "abc";
        String b = a.toUpperCase();
        b = b.replace("B", "2").replace('C', '3');
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println();


    }
}

class UsingTheStringBuilderClass {
    public static void main(String[] args) {
        String alpha = "";
        for(char current = 'a'; current <= 'z'; current++)
            alpha += current;
        System.out.println(alpha);  // будет создано 27 объектов

        StringBuilder alpha2 = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++)
            alpha2.append(current);
        System.out.println(alpha2);  // будет создан 1 объект


        StringBuilder sb = new StringBuilder("start");
        sb.append("+middle"); // sb = "start+middle"
        StringBuilder same = sb.append("+end"); // "start+middle+end"

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a); //a=abcdefg
        System.out.println("b=" + b); //b=abcdefg

        // creating StringBuilder
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("animal");
        StringBuilder sb3 = new StringBuilder(10);
    }
}

class StringBuilderMethods{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("animals");
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));       // sb.substring(0, 4); = anim
        int len = sb.length();                                              // 7
        char ch = sb.charAt(6);                                             // s
        System.out.println(sub + " " + len + " " + ch);                     // anim 7 s

        StringBuilder sb1 = new StringBuilder().append(1).append('c');  //1c
        sb1.append("-").append(true);                                   // 1c-true
        System.out.println(sb1); // 1c-true

        StringBuilder sb2 = new StringBuilder("animals");
        sb2.insert(7, "-"); // sb = animals-
        sb2.insert(0, "-"); // sb = -animals
        sb2.insert(4, "-"); // sb = -ani-mals
        System.out.println(sb2);

        StringBuilder sb4 = new StringBuilder("abcdef");
        sb4.delete(1, 3); // sb = adef              удалит 1й идекс и второй. 3й не включая
//        sb4.deleteCharAt(5); // throws an exception

        StringBuilder builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 6, "sty");
        System.out.println(builder); // pigsty dirty


        StringBuilder builder2 = new StringBuilder("pigeon dirty");
        builder2.replace(3, 100, "");
        System.out.println(builder2);

        StringBuilder sb5 = new StringBuilder("ABC");
        sb5.reverse();
        System.out.println(sb5);

        StringBuilder sb6 = new StringBuilder("ABC");
        String s = sb6.toString();

    }
}
 class Equality{
     public static void main(String[] args) {
         StringBuilder one = new StringBuilder();
         StringBuilder two = new StringBuilder();
         StringBuilder three = one.append("a");
         System.out.println(one == two); // false
         System.out.println(one == three); // true

         String x = "Hello World";
         String z = " Hello World".trim();
         System.out.println(x.equals(z)); // true

         class Tiger {
             String name;
         }


         Tiger t1 = new Tiger();
         Tiger t2 = new Tiger();
         Tiger t3 = t1;
         System.out.println(t1 == t3); // true
         System.out.println(t1 == t2); // false
         System.out.println(t1.equals(t2)); // false  equals не определен, поэтому сравниваются ссылки
         System.out.println();

         String string = "a";
         StringBuilder builder = new StringBuilder("a");
//         System.out.println(string == builder); //DOES NOT COMPILE  Компилятор знает, что сравнение идет абсолютно разных классов, поэтому ругаеца


         // String pool
         String x1 = "Hello World";
         String y1 = "Hello World";
         System.out.println(x1 == y1); // true

         String x2 = "Hello World";
         String z2 = " Hello World".trim();
         System.out.println(x2 == z2); // false  у нас нет 2х одинаковых литералов. z2 не поместится в стрингпул


         String singleString = "hello world";
         String oneLine = "hello " + "world";
         String concat = " hello";
         concat += "world";
         System.out.println(singleString == oneLine); // false
         System.out.println(singleString == concat);  // false


         // intern

         String name = "Hello World";
         String name2 = new String("Hello World").intern();
         System.out.println(name == name2); // true


         String first = "rat" + 1;  // first = rat1
         String second = "r" + "a" + "t" + "1";     // поместится в poll rat1
         String third = "r" + "a" + "t" + new String("1");  // не пойдет в pool
         System.out.println(first == second);               // true
         System.out.println(first == second.intern());      // true
         System.out.println(first == third);                // false
         System.out.println(first == third.intern());       // true

     }
 }

 class JavaArrays{
     public static void main(String[] args) {
         String[] strings = { "stringValue" };
         Object[] objects = strings;
         String[] againStrings = (String[]) objects;
//         againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
         objects[0] = new StringBuilder(); // careful! в рантайме будет ошибка, компилятор не будет ругаться

         String[] birds = new String[6];
         System.out.println(birds.length); // 6

// Sort
         int[] numbers = { 6, 9, 1 };
         Arrays.sort(numbers);
         for (int i = 0; i < numbers.length; i++)
             System.out.print(numbers[i] + " ");  // 1 6 9

         // find
         int[] numbers2 = {2,4,6,8};
         System.out.println(Arrays.binarySearch(numbers2, 2)); // 0
         System.out.println(Arrays.binarySearch(numbers2, 4)); // 1
         System.out.println(Arrays.binarySearch(numbers2, 1)); // -1
         System.out.println(Arrays.binarySearch(numbers2, 3)); // -2
         System.out.println(Arrays.binarySearch(numbers2, 9)); // -5
     }
 }

class JavaArraysCompare {
    public static void main(String[] args) {
        System.out.println(Arrays.compare(new int[] {1}, new int[] {2}));   // -1
        // A negative number means the first array is smaller than the second.
        //A zero means the arrays are equal.
        //A positive number means the first array is larger than the second.


        // how to compare arrays of different lengths:
        // If both arrays are the same length and have the same values in each spot in the same order, return zero.
        //If all the elements are the same but the second array has extra elements at the end, return a negative number.
        //If all the elements are the same but the first array has extra elements at the end, return a positive number.
        //If the first element that differs is smaller in the first array, return a negative number.
        //If the first element that differs is larger in the first array, return a positive number.

        // what does smaller mean?
        // null is smaller than any other value.
        // For numbers, normal numeric order applies.
        // For strings, one is smaller if it is a prefix of another.
        // null is smaller than any other value.
        // For numbers, normal numeric order applies.
        // For strings, one is smaller if it is a prefix of another.


        // System.out.println(Arrays.compare(new int[] {1}, new String[] {"a"})); // DOES NOT COMPILE, разные типы


        // mismatch()
        // If the arrays are equal, mismatch() returns -1. Otherwise, it returns the first index where they differ.
        System.out.println();
        System.out.println(Arrays.mismatch(new int[] {1}, new int[] {1}));              // -1
        System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {"A"}));    // 0
        System.out.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1}));           // 1


    }
}



class MultidimensionalArray {
    public static void main(String[] args) {
        int[][] vars1; // 2D array
        int vars2 [][]; // 2D array
        int[] vars3[]; // 2D array
        int[] vars4 [], space [][]; // a 2D AND a 3D array
        String [][] rectangle = new String[3][2];

        int[][] differentSizes = {{1, 4}, {3}, {9,8,7}};
        differentSizes[1][0] = 1;


        int [][] args1 = new int[4][];
        args1[0] = new int[5];
        args1[1] = new int[3];
    }
}

class UsingMultidimensionalArray{
    public static void main(String[] args) {
        // печать 2d массива
        int[][] twoD = new int[3][2];
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++)
                System.out.print(twoD[i][j] + " "); // print element
                System.out.println(); // time for a new row
        }
    }
}

class UnderstandingAnArrayList {
//    three ways to create an ArrayList:
    ArrayList list1 = new ArrayList();
    ArrayList list2 = new ArrayList(10);
    ArrayList list3 = new ArrayList(list2);

    // Generics
    ArrayList<String> list4 = new ArrayList<String>();
    ArrayList<String> list5 = new ArrayList<>();

    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        strings.add("a");
        for (String s: strings) { }

        var list = new ArrayList<>(); // тип var  = ArrayList<Object>
        list.add("a");
        // for (String s: list) { } // DOES NOT COMPILE, разные типы

        List<String> list6 = new ArrayList<>();
//        ArrayList<String> list7 = new List<>(); // DOES NOT COMPILE


        ArrayList list1 = new ArrayList();
        list1.add("hawk"); // [hawk]
        list1.add(TRUE); // [hawk, true]
        System.out.println(list1); // [hawk, true]

        ArrayList<String> safer = new ArrayList<>();
        safer.add("sparrow");
//        safer.add(Boolean.TRUE); // DOES NOT COMPILE


        // add
        List<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add(1, "robin"); // [hawk, robin]
        birds.add(0, "blue jay"); // [blue jay, hawk, robin]
        birds.add(1, "cardinal"); // [blue jay, cardinal, hawk, robin]
        System.out.println(birds); // [blue jay, cardinal, hawk, robin]


        // remove
        System.out.println();
        List<String> birds2 = new ArrayList<>();
        birds2.add("hawk"); // [hawk]
        birds2.add("tonny");
        birds2.add("hawk");
        System.out.println(birds2);// [hawk, tonny, hawk]
        System.out.println(birds2.remove("cardinal")); // prints false
        System.out.println(birds2.remove("hawk")); // prints true
        System.out.println(birds2); // [tonny, hawk]
        System.out.println(birds2.remove(0)); // prints hawk
        System.out.println(birds2); // [hawk]

        // set
        List<String> birds3 = new ArrayList<>();
        birds3.add("hawk"); // [hawk]
        System.out.println(birds3.size()); // 1
        birds3.set(0, "robin"); // [robin]
        System.out.println(birds3.size()); // 1
//        birds3.set(1, "robin"); // IndexOutOfBoundsException


        //isEmpty, size
        List<String> birds4 = new ArrayList<>();
        System.out.println(birds4.isEmpty()); // true
        System.out.println(birds4.size()); // 0
        birds4.add("hawk"); // [hawk]
        birds4.add("hawk"); // [hawk, hawk]
        System.out.println(birds4.isEmpty()); // false
        System.out.println(birds4.size()); // 2

        // contains
        List<String> birds5 = new ArrayList<>();
        birds5.add("hawk"); // [hawk]
        System.out.println(birds5.contains("hawk")); // true
        System.out.println(birds5.contains("robin")); // false

        // equals - contain the same elements in the same order.
        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        System.out.println(one.equals(two)); // true
        one.add("a"); // [a]
        System.out.println(one.equals(two)); // false
        two.add("a"); // [a]
        System.out.println(one.equals(two)); // true
        one.add("b"); // [a,b]
        two.add(0, "b"); // [b,a]
        System.out.println(one.equals(two)); // false
    }
}

class WrapperEx{
    public static void main(String[] args) {
        int primitive = Integer.parseInt("123");
        Integer wrapper = Integer.valueOf("123");
//        int bad1 = Integer.parseInt("a"); // throws NumberFormatException
//        Integer bad2 = Integer.valueOf("123.45"); // throws NumberFormatException

        int i = Integer.parseInt("1"); // => int
        Integer i1 = Integer.valueOf("1"); // => Integer

        List<Integer> weights = new ArrayList<>();
        Integer w = 50;
        weights.add(w); // [50]
        weights.add(Integer.valueOf(60)); // [50, 60]
        weights.remove(Integer.valueOf(50)); // [60]
        double first = weights.get(0); // 60.0
        System.out.println("first = " + first);

        List<Integer> heights = new ArrayList<>();
        heights.add(null);
        //  int h = heights.get(0); // NullPointerException

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2); // [1, 2].
        numbers.add(3);
        numbers.remove(1);  // [1]
        System.out.println(numbers);
        numbers.remove(new Integer(3));
        System.out.println(numbers);


    }
}

class ConvertingBetweenArrayAndList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();     // возращает Object[]
        String[] stringArray = list.toArray(new String[0]); // возращает String[]
        list.clear();
        System.out.println(objectArray.length); // 2
        System.out.println(stringArray.length); // 2


        // List из массива Arrays.asList()
        System.out.println();
        String[] array1 = { "hawk", "robin" }; // [hawk, robin]
        List<String> list1 = Arrays.asList(array1); // returns fixed size list   // Оба массива смотрят друг на друга
        System.out.println(list1.size()); // 2
        System.out.println("list1 = " + list1);
        System.out.println("array1 = " + Arrays.toString(array1));
        list1.set(1, "test"); // [hawk, test]
        System.out.println("list1.set(1, \"test\")");
        System.out.println("list1 = " + list1);
        System.out.println("array1 = " + Arrays.toString(array1));
        array1[0] = "new"; // [new, test]
        System.out.println(" array1[0] = \"new\")");
        System.out.println("list1 = " + list1);
        System.out.println("array1 = " + Arrays.toString(array1));
//        list1.remove(1); // throws UnsupportedOperationException


        // Теперь создадим неизменяемый аррейлист List.of()
        String[] array = { "hawk", "robin" }; // [hawk, robin]
        List<String> list3 = List.of(array); // returns immutable list3
        System.out.println(list3.size()); // 2
        array[0] = "new";
        System.out.println(Arrays.toString(array)); // [new, robin]     - массив изменился
        System.out.println(list3);                  // [hawk, robin]    - лист не изменился
        list3.set(1, "test"); // throws UnsupportedOperationException   - лист изменять нельзя

        // если надо быстро создать лист, который можно менять
        List<String> fixedSizeList = Arrays.asList("a", "b", "c");
        List<String> expandableList = new ArrayList<>(fixedSizeList);


        // Правила:
/*                                          toArray()       Arrays.asList()         List.of()
                                    |                   |                       |                      |
Type converting from                        List            Array (or varargs)      Array (or varargs)

Type created                                Array           List                    List

Allowed to remove values from               No              No                      No
created object

Allowed to change values in                 Yes              No                     No
the created object

Changing values in the created              No               Yes                    N\A
object affects the original or
vice versa.


*/
    }
}

class ArraySorting {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(5);
        numbers.add(81);
        Collections.sort(numbers);
        System.out.println(numbers); // [5, 81, 99]
    }
}


class SetEx {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(66)); // true
        System.out.println(set.add(66)); // false
        System.out.println(set.size()); // 1
        set.remove(66);
        System.out.println(set.isEmpty()); // true
    }
}

class MapEx {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("wolf", "meat");
        map.remove("wolf");
        String food = map.get("koala"); // bamboo
        String other = map.getOrDefault("ant", "leaf"); // leaf
        for (String key : map.keySet())
            System.out.println(key + " " + map.get(key)); // koala bamboo
        System.out.println("values=" + map.values());
        System.out.println("contaisKey koala " + map.containsKey("koala"));
    }
}

class MathEx{
    public static void main(String[] args) {
        // min max
        int first = Math.max(3, 7); // 7
        int second = Math.min(7, -9); // -9

        // round()

        // сигнатура метода
        // long round(double num)
        // int round(float num)

        long low = Math.round(123.45); // 123
        long high = Math.round(123.50); // 124
        int fromFloat = Math.round(123.45f); // 123

        // pow
        // сигнатура метода
        // double pow(double number, double exponent)

        double squared = Math.pow(5, 2); // 25.0

        // random  - double random()  0 <= random() < 1        [0;1)
        double r = Math.random();



    }
}





