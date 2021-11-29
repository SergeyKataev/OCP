package Chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q {
}

class Q1{
    // What is output by the following code? (Choose all that apply.)
    //1:   public class Fish {
    //2:   public static void main(String[] args) {
    //3:   int numFish = 4;
    //4:   String fishType = "tuna";
    //5:   String anotherFish = numFish + 1;    // ошибка компиляции. В стринг пытаемся закинуть 5 без каста
    //6:   System.out.println(anotherFish + " " + fishType);
    //7:   System.out.println(numFish + " " + 1);
    //8:   } }

    //A. 4 1
    //B. 5
    //C. 5 tuna
    //D. 5tuna
    //E. 51tuna
    //F. The code does not compile.
}

class Q2 {
    // Which of the following are output by this code? (Choose all that apply.)
    // 3: var s = "Hello";
    // 4: var t = new String(s);
    // 5: if ("Hello".equals(s)) System.out.println("one");     // one - Сравнение значений
    // 6: if (t == s) System.out.println("two");                // через new будет новая ссылка
    // 7: if (t.intern() == s) System.out.println("three");     // t.intern - вернет значение, s - указывает на это же значение в стрингпуле
    // 8: if ("Hello" == s) System.out.println("four");         // four
    // 9: if ("Hello".intern() == t)                            // разные ссылки, т.к. t создан через new
    // System.out.println("five");

    //A. one            // Correct
    //B. two
    //C. three          // Correct
    //D. four           // Correct
    //E. five
    //F. The code does not compile.
    //G. None of the above
}

class Q3 {
    // Which statements about the following code snippet are correct? (Choose all that apply.)
    // List<String> gorillas = new ArrayList<>();
    // for(var koko : gorillas)
    // System.out.println(koko);
    // var monkeys = new ArrayList<>();    // Так можно
    // for(var albert : monkeys)
    // System.out.println(albert);
    // List chimpanzees = new ArrayList<Integer>();
    // for(var ham : chimpanzees)
    // System.out.println(ham);

    //A. The data type of koko is String.           // Correct
    //B. The data type of koko is Object.
    //C. The data type of albert is Object.         // Correct
    //D. The data type of albert is undefined.
    //E. The data type of ham is Integer.
    //F. The data type of ham is Object.            // Correct  - правый тип не влияет
    //G. None of the above, as the code does not compile
}

class Q4 {
    // What is the result of the following code?
    // 7: StringBuilder sb = new StringBuilder();
    // 8: sb.append("aaa").insert(1, "bb").insert(4, "ccc"); // abbacccca
    // 9: System.out.println(sb);
    // A. abbaaccc
    // B. abbaccca                                  // Correct
    // C. bbaaaccc
    // D. bbaaccca
    // E. An empty line
    // F. The code does not compile.
}

class Q5{
    // What is the result of the following code?
    // 12: int count = 0;
    // 13: String s1 = "java";
    // 14: String s2 = "java";
    // 15: StringBuilder s3 = new StringBuilder("java");
    // 16: if (s1 == s2) count++;           count=1
    // 17: if (s1.equals(s2)) count++;      count=2
    // 18: if (s1 == s3) count++;
    // 19: if (s1.equals(s3)) count++;      count=3
    // 20: System.out.println(count);

    // A. 0
    // B. 1
    // C. 2
    // D. 3
    // E. 4
    //F. An exception is thrown.
    //G. The code does not compile.     String == StringBuilder - компилятор заругается
}

class Q6 {
    // What is the result of the following code?
    // public class Lion {
    // public void roar(String roar1, StringBuilder roar2) {
    // roar1.concat("!!!");
    // roar2.append("!!!");
    // }
    // public static void main(String[] args) {
    // String roar1 = "roar";
    // StringBuilder roar2 = new StringBuilder("roar");
    // new Lion().roar(roar1, roar2);
    // System.out.println(roar1 + " " + roar2);
    // } }

    // A. roar roar
    // B. roar roar!!!              // Correct
    // C. roar!!! roar
    // D. roar!!! roar!!!
    // E. An exception is thrown.
    // F. The code does not compile.
}

class Q7 {
    // Which of the following return the number 5 when run independently? (Choose all that apply.)
    // var string = "12345";
    // var builder = new StringBuilder("12345");

    // A. builder.charAt(4)                          // Correct
    // B. builder.replace(2, 4, "6").charAt(3)       // 1265 =>      Correct
    // C. builder.replace(2, 5, "6").charAt(2)       // 1265   - 6
    // D. string.charAt(5)                           // Exception
    // E. string.length                              // Error - .length()
    // F. string.replace("123", "1").charAt(2)       // Correct
    // G. None of the above
}

class Q8 {
    // What is output by the following code? (Choose all that apply.)
    // String numbers = "012345678";
    // System.out.println(numbers.substring(1, 3));  // 12
    // System.out.println(numbers.substring(7, 7));  // ""
    // System.out.println(numbers.substring(7));    //  78
    // A. 12                        // Correct
    // B. 123
    // C. 7
    // D. 78                        // Correct
    // E. A blank line              // Correct
    // F. The code does not compile.
    // G. An exception is thrown.
}

class Q9 {
    // What is the result of the following code? (Choose all that apply.)
    // 14: String s1 = "purr";
    // 15: String s2 = "";
    // 16:
    // 17: s1.toUpperCase();
    // 18: s1.trim();
    // 19: s1.substring(1, 3);
    // 20: s1 += "two";         s1 = purrtwo
    // 21:
    // 22: s2 += 2;             s2 = 2
    // 23: s2 += 'c';           s2 = 2c
    // 24: s2 += false;         s2 = 2cfalse
    // 25:
    // 26: if ( s2 == "2cfalse") System.out.println("==");
    // 27: if ( s2.equals("2cfalse"))
    // System.out.println("equals");            // equals
    // 28: System.out.println(s1.length());     // 7

    // A. 2
    // B. 4
    // C. 7                     // Correct
    // D. 10
    // E. ==
    // F. equals                // Correct
    // G. An exception is thrown.
    // H. The code does not compile.
}

class Q10 {
    // Which of these statements are true? (Choose all that apply.)
    // var letters = new StringBuilder("abcdefg");

    // A. letters.substring(1, 2) returns a single character String.  // Correct
    // B. letters.substring(2, 2) returns a single character String.    // ""
    // C. letters.substring(6, 5) returns a single character String. //Exception
    // D. letters.substring(6, 6) returns a single character String.    // ""
    // E. letters.substring(1, 2) throws an exception.
    // F. letters.substring(2, 2) throws an exception.
    // G. letters.substring(6, 5) throws an exception.              // Correct
    // H. letters.substring(6, 6) throws an exception.
}

class Q11 {
    // What is the result of the following code?
    // StringBuilder numbers = new StringBuilder("0123456789");
    // numbers.delete(2, 8);  // 0189
    // numbers.append("-").insert(2, "+");  // 01+89-
    // System.out.println(numbers);

    // A. 01+89–        // Correct
    // B. 012+9–
    // C. 012+–9
    // D. 0123456789
    // E. An exception is thrown.
    // F. The code does not compile.
}

class Q12 {
    // What is the result of the following code?
    // StringBuilder b = "rumble";          // Так нельзя создавать StringBuilder
    // b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
    // System.out.println(b);

    // A. rum
    // B. rum4
    // C. rumb4
    // D. rumble4
    // E. An exception is thrown.
    // F. The code does not compile.
}

class Q13 {
    // Which of the following can replace line 4 to print "avaJ"? (Choose all that apply.)
    // 3: var puzzle = new StringBuilder("Java");
    // 4: // INSERT CODE HERE
    // 5: System.out.println(puzzle);

    // A. puzzle.reverse();                         // Correct, SB имеет такой метод
    // B. puzzle.append("vaJ$").substring(0, 4);    // JavavaJ$ -> Java
    // C. puzzle.append("vaJ$").delete(0, 3).deleteCharAt(puzzle.length() - 1);        // JavavaJ$ -> avaJ  // Correct
    // D. puzzle.append("vaJ$").delete(0, 3).deleteCharAt(puzzle.length());   // Exception
    // E. None of the above
}

class Q14 {
    // Which of these array declarations is not legal? (Choose all that apply.)
    // A. int[][] scores = new int[5][];
    // B. Object[][][] cubbies = new Object[3][0][5];
    // C. String beans[] = new beans[6];            // Correct
    // D. java.util.Date[] dates[] = new java.util.Date[2][];
    // E. int[][] types = new int[];                // Correct  - в многомерном массиве нужно указать первый уровень
    // F. int[][] java = new int[][];               // Correct  - в многомерном массиве нужно указать первый уровень
}

class Q15 {
    // Which of the following can fill in the blanks so the code compiles? (Choose two.)
    // 6: char[]c = new char[2];
    // 7: ArrayList l = new ArrayList();
    // 8: int length = __________ + ______________;
    // A. c.length    // Correct
    // B. c.length()
    // C . c.size       // у массива нет size
    // D. c.size()
    // E. l.length
    // F. l.length()    // length - у строки
    // G. l.size
    // H. l.size()    // Correct
}

class Q16 {
    // Which of the following are true? (Choose all that apply.)
    // A. An array has a fixed size.             // Correct
    // B. An ArrayList has a fixed size.
    // C. An array is immutable.        // массив изменяемый
    // D. An ArrayList is immutable.    // лист изменяемый
    // E. Calling equals() on two arrays returns true.  - используеся equals по дефолту
    // F. Calling equals() on two ArrayList objects returns true.  // Correct - same elements in the same order,
    // G. If you call remove(0) using an empty ArrayList object, it will compile successfully.  // Correct
    //H. If you call remove(0) using an empty ArrayList object, it will run successfully.
}

class Q17 {
    // What is the result of the following statements?
    // 6: var list = new ArrayList<String>();
    // 7: list.add("one");
    // 8: list.add("two");
    // 9: list.add(7);      // Нельзя добавить int - Лист ждет только String
    // 10: for(var s : list) System.out.print(s);
    // A. onetwo
    // B. onetwo7
    // C. onetwo followed by an exception
    // D. Compiler error on line 6
    // E. Compiler error on line 7
    // F. Compiler error on line 9              // Correct
    // G. Compiler error on line 10
}

class Q18 {
    // Which of the following pairs fill in the blanks to output 6?
    // 3: var values = new ___________<Integer>();
    // 4: values.add(4);
    // 5: values.add(4);
    // 6: values. ___________;
    // 7: values.remove(0);
    // 8: for (var v : values) System.out.print(v);

    // A. ArrayList and put(1, 6)           // put только в Map
    // B. ArrayList and replace(1, 6)    // replace нет в этом интерфейсе
    // C. ArrayList and set(1, 6)        // Correct
    // D. HashSet and put(1, 6)             // put только в Map
    // E. HashSet and replace(1, 6)      //  replace нет в этом интерфейсе
    // F. HashSet and set(1, 6)         // в HashSet нет Set.т.к. нет порядка
    // G. The code does not compile with any of these options.
}

class Q19 {
    // What is output by the following? (Choose all that apply.)

    // 8:  List<Integer> list = Arrays.asList(10, 4, -1, 5);
    // 9:  int[] array = { 6, -4, 12, 0, -10 };   // -10 -4 0 6 12
    // 10: Collections.sort(list);
    // 11:
    // 12: Integer converted[] = list.toArray(new Integer[4]);  // -1 4 5 10
    // 13: System.out.println(converted[0]);        // -1
    // 14: System.out.println(Arrays.binarySearch(array, 12));  // -5

    // A. -1   // Correct
    // B. 2    // Correct
    // C. 4
    // D. 6
    // E. 10
    // F. One of the outputs is undefined.
    // G. An exception is thrown.
    // H. The code does not compile.

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 4, -1, 5);
        int[] array = { 6, -4, 12, 0, -10 };   // -10 -4 0 6 12
        Collections.sort(list);

        Integer converted[] = list.toArray(new Integer[4]);  // -1 4 5 10
        System.out.println(converted[0]);        // -1
        System.out.println(Arrays.binarySearch(array, 12));  // array must be sorted for binarySearch()
    }
}
class Q20 {
    // Which of the lines contain a compiler error? (Choose all that apply.)
    // 23: double one = Math.pow(1, 2);
    // 24: int two = Math.round(1.0);  - вернет int если параметр (float) , вернет long если параметр (double) - будет ошибка
    // 25: float three = Math.random();     // return double - будет ошибка каста float = double
    // 26: var doubles = new double[] { one, two, three};
    // 27:
    // 28: String [] names = {"Tom", "Dick", "Harry"};
    // 29: List<String> list = names.asList(); - у массива нет .asList(). Можно только Arrays.asList()
    // 30: var other = Arrays.asList(names);
    // 31: other.set(0, "Sue");

    // A. Line 23
    // B. Line 24       // Corrrect
    // C. Line 25       // Corrrect
    // D. Line 26
    // E. Line 29       // Corrrect
    // F. Line 30
    // G. Line 31

    public static void main(String[] args) {
        String [] names = {"Tom", "Dick", "Harry"};
        var other = List.of(names);
        // other.set(0, "Sue");    // так нельзя

        String [] names1 = {"Tom", "Dick", "Harry"};
        var other1 = Arrays.asList(names1);
        other1.set(0, "Sue");    // так можно
    }
}

class Q21 {
    // What is the result of the following?
    // List<String> hex = Arrays.asList("30", "8", "3A", "FF");  // [30, 3A, 8, FF].
    // Collections.sort(hex);
    // int x = Collections.binarySearch(hex, "8");  // 2
    // int y = Collections.binarySearch(hex, "3A"); // 1
    // int z = Collections.binarySearch(hex, "4F"); // -3
    // System.out.println(x + " " + y + " " + z);
    // A. 0 1 –2
    // B. 0 1 –3
    // C. 2 1 –2
    // D. 2 1 –3                 // Correct
    // E. None of the above
    // F. The code doesn’t compile.

    public static void main(String[] args) {
        List<String> hex = Arrays.asList("30", "8", "3A", "FF");
        Collections.sort(hex);  // так можно

        List<String> hex2 = List.of("30", "8", "3A", "FF");
        // Collections.sort(hex2);  // так нельзя ImmutableCollections
    }
}

class Q22 {
    // Which of the following are true statements about the following code? (Choose all that apply.)
    // 4: List<Integer> ages = new ArrayList<>();
    // 5: ages.add(Integer.parseInt("5")); // 5
    // 6: ages.add(Integer.valueOf("6"));  // 5 6
    // 7: ages.add(7);                      // 5 6 7
    // 8: ages.add(null);                   // 5 6 7 null
    // 9: for (int age : ages) System.out.print(age); // тут упадет, когда дойдет до null

    // A. The code compiles.                                    // Correct
    // B. The code throws a runtime exception.                  // Correct
    // C. Exactly one of the add statements uses autoboxing.
    // D. Exactly two of the add statements use autoboxing.     // Correct
    // E. Exactly three of the add statements use autoboxing.

    public static void main(String[] args) {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("5")); // 5
        ages.add(Integer.valueOf("6"));  // 5 6
        ages.add(7);                      // 5 6 7
        ages.add(null);                   // 5 6 7 null
        for (int age : ages) System.out.print(age);
    }
}

class Q23 {
    // What is the result of the following?
    // List<String> one = new ArrayList<String>();
    // one.add("abc");
    // List<String> two = new ArrayList<>();
    // two.add("abc");
    // if (one == two)
    // System.out.println("A");
    // else if (one.equals(two))
    // System.out.println("B");     // B
    // else
    // System.out.println("C");

    // A. A
    // B. B                     // Correct - same elements in the same order.
    // C. C
    // D. An exception is thrown.
    // E. The code does not compile.
}

class Q24 {
    // Which statements are true about the following code? (Choose all that apply.)
    // public void run(Integer[] ints, Double[] doubles) {
    // List<Integer> intList = Arrays.asList(ints);
    // List<Double> doubleList = List.of(doubles);
    // // more code
    // }

    // A. Adding an element to doubleList is allowed.                                       // нельзя добавлять fixed-size.
    // B. Adding an element to intList is allowed.                                          // нельзя добавлять fixed-size.
    // C. Changing the first element in doubleList changes the first element in doubles.    // нельзя менять doubleList
    // D. Changing the first element in intList changes the first element in ints.          // Correct
    // E. doubleList is immutable.                                                          // Correct
    // F. intList is immutable.
}

class Q25 {
    // Which of the following statements are true of the following code? (Choose all that apply.)
    //String[] s1 = { "Camel", "Peacock", "Llama"};
    //String[] s2 = { "Camel", "Llama", "Peacock"};
    //String[] s3 = { "Camel"};
    //String[] s4 = { "Camel", null};


    //A. Arrays.compare(s1, s2) returns a positive integer.    // Correct Дальше по алфавиту = больше. Если больше - позитивное число.
    //B. Arrays.mismatch(s1, s2) returns a positive integer.    //Correct возврщает индекс первого несовпадения // 1
    //C. Arrays.compare(s3, s4) returns a positive integer.     // -1 - разные длины. A null array is lexicographically less than a non-null array.
    //D. Arrays.mismatch(s3, s4) returns a positive integer.    // Correct1 - индекс несовпадающего индекса
    //E. Arrays.compare(s4, s4) returns a positive integer.     // 0
    //F. Arrays.mismatch(s4, s4) returns a positive integer.    // -1 mismatch() returns -1 if there is no mismatch.

    public static void main(String[] args) {
        String[] s1 = { "Camel", "Peacock", "Llama"};
        String[] s2 = { "Camel", "Llama", "Peacock"};
        String[] s3 = { "Camel"};
        String[] s4 = { "Camel", null};
        System.out.println(Arrays.mismatch(s4, s4));


        // Compare
        // A null array is lexicographically less than a non-null array.
        // Two arrays are considered equal if both are null.
        // If first array and second array are equal then compare() returns zero;
        // If the first array (or slice) is lexicographically less than the second array (or slice) returns -ve (negative value).
        // If the first array (or slice) is lexicographically greater than the second array (or slice) returns +ve (positive value).
    }
}

