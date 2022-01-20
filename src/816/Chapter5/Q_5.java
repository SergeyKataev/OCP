package Chapter5;

public class Q_5 {
}

/*
Which of the following classes contain at least one compiler error? (Choose all that apply.)
*/
 class Danger extends RuntimeException {
     public Danger(String message) {
     super();
 }
 public Danger(int value) {
    super((String) null);
 }
 }
 class Catastrophe extends Exception {
     public Catastrophe(Throwable c) throws RuntimeException {  // конструктор может выбрасывать
     super(new Exception());
     c.printStackTrace();
 }
 }
/*
 class Emergency extends Danger {

     public Emergency() {
         super("");
     }

     public Emergency() {}  // внутри неявно будет создан super(), а такой сигнатуры в Danger нет
     public Emergency(String message) {
     super(message);
 }
 }
 */

/*
A. Danger
B. Catastrophe
C. Emergency   // Correct
D. All of these classes compile correctly.
E. The answer cannot be determined from the information given.
 */

/*
2. Which of the following are common types to localize? (Choose all that apply.)
A. Dates                // Correct
B. Lambda expressions
C. Class names
D. Currency             // Correct
E. Numbers              // Correct
F. Variable names
 */

/*
3. What is the output of the following code?

The method close() in Closeable interfaces throws IOException
and AutoCloseable.close() method throws Exception class.

A try-with-resources statement uses parentheses, (), rather than braces, {}, for the try section.
Если скобки поменять на нормальные - то  TWDF

import java.io.*;
 public class EntertainmentCenter {
    static class TV implements AutoCloseable {
        public void close() {
        System.out.print("D");
 } }
 static class MediaStreamer implements Closeable {
    public void close() {
        System.out.print("W");
 } }
 public static void main(String[] args) {
    var w = new MediaStreamer();
    try {
        TV d = new TV(); w;
        }
 {
    System.out.print("T");
 } catch (Exception e) {
    System.out.print("E");
 } finally {
    System.out.print("F");
 }
 }
 }



A. TWF
B. TWDF
C. TWDEF
D. TWF followed by an exception.
E. TWDF followed by an exception.
F. TWEF followed by an exception.
G. The code does not compile.      // Correct
 */

/*
4. Which statement about the following class is correct?
The code does not compile because the throw and throws keywords are incorrectly
used on lines 6, 7, and 9.
If the keywords were fixed, then the rest of the code would compile and print a stack track
with YesProblem at runtime.

 1: class Problem extends Exception {
 2:     public Problem() {}
 3: }
 4: class YesProblem extends Problem {}
 5: public class MyDatabase {
 6: public static void connectToDatabase() throw Problem {
 7:     throws new YesProblem();
 8: }
 9: public static void main(String[] c) throw Exception {
 10:    connectToDatabase();
 11: }
 12: }


A. The code compiles and prints a stack trace for YesProblem at runtime.
B. The code compiles and prints a stack trace for Problem at runtime.
C. The code does not compile because Problem defines a constructor.
D. The code does not compile because YesProblem does not define a constructor.
E. The code does not compile but would if Problem and YesProblem were switched on lines 6 and
7. F. None of the above         // Correct


5. What is the output of the following code?

 LocalDate date = LocalDate.parse("2020–04–30",
 DateTimeFormatter.ISO_LOCAL_DATE_TIME);  // тут ошибется, если будет ISO_LOCAL_DATE, то ответ B
 System.out.println(date.getYear() + " "
 + date.getMonth() + " "+ date.getDayOfMonth());

A. 2020 APRIL 2
B. 2020 APRIL 30
C. 2020 MAY 2
D. The code does not compile.
E. A runtime exception is thrown.

A LocalDate does not have a time element. Therefore, a Date/Time formatter is not appropriate.


6. Assume that all of the files mentioned in the answer choices exist and define the same keys.
Which one will be used to find the key in line 8?

 6: Locale.setDefault(new Locale("en", "US"));
 7: var b = ResourceBundle.getBundle("Dolphins");
 8: System.out.println(b.getString("name"));

A. Dolphins.properties
B. Dolphins_US.properties
C. Dolphins_en.properties  // Correct
D. Whales.properties
E. Whales_en_US.properties
F. The code does not compile.

Java will first look for the most specific matches it can find, starting with
Dolphins_en_US.properties. Since that is not an answer choice, it drops the country and looks for
Dolphins_en.properties, making option C correct. Option B is incorrect because a country without
a language is not a valid locale.

7. For what value of pattern will the following print <005.21> <008.49> <1,234.0>?

 String pattern = "__________________";
 var message = DoubleStream.of(5.21, 8.49, 1234)
 .mapToObj(v -> new DecimalFormat(pattern).format(v))
 .collect(Collectors.joining("> <"));
 System.out.println("<"+message+">");

A. ##.#
B. 0,000.0#
C. #,###.0
D. #,###,000.0#   // Correct
E. The code does not compile regardless of what is placed in the blank.
F. None of the above

When working with a custom number formatter, the 0 symbol displays the digit as 0,
even if it's not present, while the # symbol omits the digit from the start or end
of the String if it is not present.


8. Which of the following prints OhNo with the assertion failure when the number magic is positive?
(Choose all that apply.)
A. assert magic < 0: "OhNo";   // Correct
B. assert magic < 0, "OhNo";
C. assert magic < 0 ("OhNo");
D. assert(magic < 0): "OhNo"; // Correct
E. assert(magic < 0, "OhNo");

An assertion consists of a boolean expression followed by an optional colon (:) and message.
The boolean expression is allowed to be in parentheses, but this is not required.



9. Which of the following exceptions must be handled or declared in the method in which they are
thrown? (Choose all that apply.)

 class Apple extends RuntimeException{}  // RuntimeException - unchecked
 class Orange extends Exception{}       // checked
 class Banana extends Error{}           // unchecked
 class Pear extends Apple{}             // unckecked
 class Tomato extends Orange{}          // checked
 class Peach extends Banana{}           // unchecked

A. Apple
B. Orange   // Correct
C. Banana
D. Pear
E. Tomato  // Correct
F. Peach

Checked: Throwable, Exception, IOException, SQLException, FileNotFoundException



10. Which of the following changes when made independently would make this code compile?
(Choose all that apply.)

 1: import java.io.*;
 2: public class StuckTurkeyCage implements AutoCloseable {
 3:     public void close() throws IOException {
 4:         throw new FileNotFoundException("Cage not closed");
 5:     }
 6: public static void main(String[] args) {
 7:     try (StuckTurkeyCage t = new StuckTurkeyCage()) {
 8:         System.out.println("put turkeys in");
 9: }
 10: } }

A. Remove throws IOException from the declaration on line 3.    //  causes a compilation error on line 4
B. Add throws Exception to the declaration on line 6.   // Correct
C. Change line 9 to } catch (Exception e) {}.           // Correct
D. Change line 9 to } finally {}. // неправильно, нужно обрабатывать исключение
E. The code compiles as is.
F. None of the above


11. What is the result of running java EnterPark bird.java sing with the following code?
 public class EnterPark extends Exception {
    public EnterPark(String message) {
    super();
 }
 private static void checkInput(String[] v) {
     if (v.length <= 3)
     assert(false) : "Invalid input";
 }
 public static void main(String… args) {
     checkInput(args);
     System.out.println(args[0] + args[1] + args[2]); // 2 аргумента на входе,
                                                      // при попытке args[2] -> exception
 }
 }

A. birdsing
B. The assert statement throws an AssertionError.
C. The code throws an ArrayIndexOutOfBoundsException.
D. The code compiles and runs successfully, but there is no output.
E. The code does not compile.




12. Which of the following are true statements about exception handling in Java? (Choose all that apply.)
A. A traditional try statement without a catch block requires a finally block. // Correct
B. A traditional try statement without a finally block requires a catch block. // Correct
C. A traditional try statement with only one statement can omit the {}.
D. A try‐with‐resources statement without a catch block requires a finally block.
E. A try‐with‐resources statement without a finally block requires a catch block.
F. A try‐with‐resources statement with only one statement can omit the {}.


A try-with-resources statement does not require a catch or finally block.
A traditional try statement requires at least one of the two. Neither statement can be
written without a body encased in braces, {}.


13. Which of the following, when inserted independently in the blank, use locale parameters that are
properly formatted? (Choose all that apply.)

 import java.util.Locale;
 public class ReadMap implements AutoCloseable {
     private Locale locale;
     private boolean closed = false;
     void check() {
        assert !closed;
    }

 @Override public void close() {
    check();
    System.out.println("Folding map");
    locale = null;
    closed = true;
    }
    public void open() {
        check();
        this.locale = _______________;
 }
    public void use() {
    // Implementation omitted
    }
 }


A. new Locale("xM"); // нужно 2 параметра
B. new Locale("MQ", "ks");  // неверный формат
C. new Locale("qw");        // Correct
D. new Locale("wp", "VW");  // Correct
E. Locale.create("zp");     // нет такого метода, Locale задается через билдер
F. Locale.create("FF");     // нет такого метода, Locale задается через билдер
G. The code does not compile regardless of what is placed in the blank.

A locale consists of a required lowercase language code and optional uppercase country code.
 In the Locale() constructor, the language code is provided first.
Например new Locale("hi", "IN")


14. Which of the following is true when creating your own exception class?
A. One or more constructors must be coded.        // может и не быть конструтора, будет дефолтный
B. Only custom checked exception classes may be created.    // Можно и checked и unchecked классы
C. Only custom unchecked exception classes may be created.  // Можно и checked и unchecked классы
D. Custom Error classes may be created.                     // Correct
E. The toString() method must be coded.                     // нет
F. None of the above

You can create custom checked, unchecked exceptions, and even errors. The default constructor is
used if one is not supplied. There is no requirement to implement any specific methods.


15. Which of the following can be inserted into the blank to allow the code to compile and run without
throwing an exception? (Choose all that apply.)

 var f = DateTimeFormatter.ofPattern("hh o'clock");
 System.out.println(f.format(__________________.now()));

A. ZonedDateTime
B. LocalDate
C. LocalDateTime
D. LocalTime
E. The code does not compile regardless of what is placed in the blank.
F. None of the above // Correct

The code compiles, but the first line produces a runtime exception regardless of
what is inserted into the blank.

If the properly escaped value of "hh' o''clock'" was used, then the correct answers
would be ZonedDateTime, LocalDateTime, and LocalTime. Только те ответы, где есть время



16. Which of the following command lines cause this program to produce an error when executed?
(Choose all that apply.)

public class On {
    public static void main(String[] args) {
        String s = null;
        int check = 10;
        assert s != null : check++;
    }
 }

A. java –da On
B. java –ea On   // Сorrect
C. java ‐da ‐ea:On On // Correct, сначала все отключил, потом включил только On
D. java ‐ea ‐da:On On
E. The code does not compile.


17. Which of the following statements about resource bundles are correct? (Choose all that apply.)
A. All keys must be in the same resource bundle to be used.
B. A resource bundle is loaded by calling the new ResourceBundle() constructor.
C. Resource bundle values are always read using the Properties class.
D. Changing the default locale lasts for only a single run of the program.  // Corect
E. If a resource bundle for a specific locale is requested, then the resource bundle for the default
locale will not be used.
F. It is possible to use a resource bundle for a locale without specifying a default locale.  // Correct


Option A is incorrect because Java will look at parent bundles if a key is not found in a specified
resource bundle. Option B is incorrect because resource bundles are loaded from static factory
methods. In fact, ResourceBundle is an abstract class, so calling that constructor is not even
possible. Option C is incorrect, as resource bundle values are read from the ResourceBundle object
directly. Option D is correct because the locale is changed only in memory. Option E is incorrect, as
the resource bundle for the default locale may be used if there is no resource bundle for the specified
locale (or its locale without a country code). Finally, option F is correct. The JVM will set a default
locale automatically, making it possible to use a resource bundle for a locale, even if a locale was not
explicitly set.



18. What is the output of the following code?
 import java.io.*;
 public class FamilyCar {
     static class Door implements AutoCloseable {
         public void close() {
         System.out.print("D");
 } }
 static class Window implements Closeable {
     public void close() {
         System.out.print("W");
         throw new RuntimeException();
 } }
 public static void main(String[] args) {
     var d = new Door();
    try (d; var w = new Window()) {
        System.out.print("T");
    } catch (Exception e) {
        System.out.print("E");
    } finally {
        System.out.print("F");
 } } }

 // TWDEF



A. TWF
B. TWDF
C. TWDEF        // Correct
D. TWF followed by an exception.
E. TWDF followed by an exception.
F. TWEF followed by an exception.
G. The code does not compile.


After both resources are declared and created in the try-with-resources statement, T is printed as
part of the body. Then the try-with-resources completes and closes the resources in reverse order from
which they were declared. After W is printed, an exception is thrown. However, the remaining resource
still needs to be closed, so D is printed. Once all the resources are closed, the exception is thrown and
swallowed in the catch block, causing E to be printed. Last, the finally block is run, printing F.
Therefore, the answer is TWDEF.


19. Suppose that we have the following three properties files and code.
Which bundles are used on lines 8 and 9, respectively?

 Dolphins.properties
 name=The Dolphin
 age=0

 Dolphins_en.properties
 name=Dolly
 age=4

 Dolphins_fr.properties
 name=Dolly

 5: var fr = new Locale("fr");
 6: Locale.setDefault(new Locale("en", "US"));
 7: var b = ResourceBundle.getBundle("Dolphins", fr);
 8: b.getString("name");
 9: b.getString("age");


A. Dolphins.properties and Dolphins.properties
B. Dolphins.properties and Dolphins_en.properties
C. Dolphins_en.properties and Dolphins_en.properties
D. Dolphins_fr.properties and Dolphins.properties   // Correct
E. Dolphins_fr.properties and Dolphins_en.properties
F. The code does not compile.
G. None of the above

 Java will use Dolphins_fr.properties as the matching resource bundle on line 7 because it is an
exact match on the language of the requested locale. Line 8 finds a matching key in this file. Line 9
does not find a match in that file; therefore, it has to look higher up in the hierarchy. Once a bundle is
chosen, only resources in that hierarchy are allowed. It cannot use the default locale anymore, but it
can use the default resource bundle specified by Dolphins.properties.



20. Fill in the blanks: When formatting text data, the _________________ class supports parametrized
String values, while the _________________ class has built‐in support for missing values.

A. TextFormat, Properties
B. MessageFormat, Properties   // Correct
C. Properties, Formatter
D. StringFormat, Properties
E. Properties, TextFormat
F. Properties, TextHandler
G. None of the above


The MessageFormat class supports parametrized String values that take input values, while the
Properties class supports providing a default value if the property is not set.

MessageFormat -
int planet = 7;
String event = "a disturbance in the Force";
String result = MessageFormat.format(
        "At {0, time, medium} on {0, date}, there was {1} on planet {2, number, integer}.",
        new Date(), event, planet);
System.out.println(result);

Propertiest -

Properties capitals = new Properties();
      Set states;
      String str;

      capitals.put("Иллинойс", "Спрингфилд");
      capitals.put("Миссури", "Джефферсон-Сити");
      capitals.put("Вашингтона", "Олимпия");
      capitals.put("Калифорнии", "Сакраменто");
      capitals.put("Индианы", "Индианаполис");

      // Показывает все штаты и столицы в хэш-таблицы.
      states = capitals.keySet();   // Получить набор ключей
      Iterator itr = states.iterator();

      while(itr.hasNext()) {
         str = (String) itr.next();
         System.out.println("Столицей " + str + " является " +
            capitals.getProperty(str) + ".");
      }
      System.out.println();

      // При нахождении штата вне списка –– указать значение по умолчания.
      str = capitals.getProperty("Флорида", "Не Найдена");
      System.out.println("Столица Флориды " + str + ".");



21. Which changes, when made independently, allow the following program to compile? (Choose all that
apply.)
 1: public class AhChoo {
 2:     static class SneezeException extends Exception {}
 3:     static class SniffleException extends SneezeException {}
 4:     public static void main(String[] args) {
 5:         try {
 6:             throw new SneezeException();
 7:         } catch (SneezeException | SniffleException e) {  // нельзя и супер класс и подкласс
 8:         } finally {}
 9: } }

A. Add throws SneezeException to the declaration on line 4.
B. Add throws Throwable to the declaration on line 4.
C. Change line 7 to } catch (SneezeException e) {.  // Correct
D. Change line 7 to } catch (SniffleException e) {. // Нельзя, т.к.
    // new SneezeException() проверяемое и его обязательно надо ловить в catch
E. Remove line 7.
F. The code compiles correctly as is.
G. None of the above


22. What is the output of the following code?
 LocalDateTime ldt = LocalDateTime.of(2020, 5, 10, 11, 22, 33);
 var f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
 System.out.println(ldt.format(f));

A. 3/7/19 11:22 AM
B. 5/10/20 11:22 AM
C. 3/7/19
D. 5/10/20
E. 11:22 AM   // Correct
F. The code does not compile.
G. A runtime exception is thrown.

Even though ldt has both a date and time, the formatter outputs only time.


23. Fill in the blank: A class that implements _________________ may be in a try‐with‐resources
statement. (Choose all that apply.)
A. AutoCloseable    // Correct
B. Resource
C. Exception
D. AutomaticResource
E. Closeable        // Correct
F. RuntimeException
G. Serializable


Resources must inherit AutoCloseable to be used in a try-with-resources block. Since
Closeable, which is used for I/O classes, extends AutoCloseable, both may be used.



24. What is the output of the following method if props contains {veggies=brontosaurus,
meat=velociraptor}?
 private static void print(Properties props) {
 System.out.println(props.get("veggies", "none")
 + " " + props.get("omni", "none"));
 }
A. brontosaurus none
B. brontosaurus null
C. none none
D. none null
E. The code does not compile.   // Correct
F. A runtime exception is thrown.


The Properties class defines a get() method that does not allow for a default value.
It also has a getProperty() method, which returns the default value if the key is not provided.




25. What is the output of the following program?
 public class SnowStorm {
     static class WalkToSchool implements AutoCloseable {
     public void close() {
     throw new RuntimeException("flurry");
     }
     }
     public static void main(String[] args) {
     WalkToSchool walk1 = new WalkToSchool();
     try (walk1; WalkToSchool walk2 = new WalkToSchool()) {
     throw new RuntimeException("blizzard");
     } catch(Exception e) {
     System.out.println(e.getMessage()
     + " " + e.getSuppressed().length);
     }
     walk1 = null;
     }
 }


A. blizzard 0
B. blizzard 1
C. blizzard 2
D. flurry 0
E. flurry 1
F. flurry 2
G. None of the above


The code does compile because the resource walk1 is not final or effectively final
and cannot be used in the declaration of a try-with-resources statement. If the line
that set walk1 to null was removed, then the code would compile and print blizzard 2 at runtime,
with the exception inside the try block being the primary exception since it is thrown first.
Then two suppressed exceptions would be added to it when trying to close the AutoCloseable resources.




26. Which of the following are true of the code? (Choose all that apply.)
 4: private int addPlusOne(int a, int b) {
 5: boolean assert = false;
 6: assert a++> 0;
 7: assert b> 0;
 8: return a + b;
 9: }

A. Line 5 does not compile.         // Correct
B. Lines 6 and 7 do not compile because they are missing the String message.
C. Lines 6 and 7 do not compile because they are missing parentheses.
D. Line 6 is an appropriate use of an assertion.
E. Line 7 is an appropriate use of an assertion.        // Correct


Line 5 does not compile because assert is a keyword, making option A correct. Options B and
C are both incorrect because the parentheses and message are both optional. Option D is incorrect
because assertions should never alter outcomes, as they may be disabled at runtime. Option E is
correct because checking an argument passed from elsewhere in the program is an appropriate use of
an assertion.


27. What is the output of the following program?
 import java.text.NumberFormat;
 import java.util.Locale;
 import java.util.Locale.Category;

 public class Wallet {
 private double money;
 // Assume getters/setters/constructors provided

 private String openWallet() {
    Locale.setDefault(Category.DISPLAY,
        new Locale.Builder().setRegion("us"));
        Locale.setDefault(Category.FORMAT,
        new Locale.Builder().setLanguage("en"));
        return NumberFormat.getCurrencyInstance(Locale.GERMANY)
        .format(money);
    }
 public void printBalance() {
     System.out.println(openWallet());
     }
     public static void main(String… unused) {
     new Wallet(2.4).printBalance();
     }
 }


A. 2,40 €
B. $2.40
C. 2.4
D. The output cannot be determined without knowing the locale of the system where it will be run.
E. The code does not compile.   // Correct
F. None of the above


The Locale.Builder class requires that the build() method be called to actually create the
Locale object. For this reason, the two Locale.setDefault() statements do not compile because the
input is not a Locale, making option E the correct answer. If the proper build() calls were added,
then the code would compile and print the value for Germany, 2,40 €. As in the exam, though, you
did not have to know the format of currency values in a particular locale to answer the question. Note
that the default locale category is ignored since an explicit currency locale is selected.


 */