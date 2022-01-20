package Chapter5;

public class ExceptionsAssertionsAndLocalization {
}
/*
Handling Exceptions

A try statement is used to handle exceptions. It consists of a try clause, zero or more catch clauses to
handle the exceptions that are thrown, and an optional finally clause, which runs regardless of whether an
exception is thrown.
A traditional try statement must have at least one of the following: a catch block or a finally block. It
can have more than one catch block, including multi‐catch blocks, but at most one finally block.

You can also create a try‐with‐resources statement to handle exceptions. A try‐with‐resources statement
looks a lot like a try statement, except that it includes a list of resources inside a set of parentheses, ().

Like a regular try statement, a try‐with‐resources statement can include optional catch and finally
blocks. Unlike a try statement, though, neither is required.


try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
    writer.println("Hello World");
}

try-with-resouces с несколькоими ресурсами пример
try (Scanner scanner = new Scanner(new File("testRead.txt"));
    PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
    while (scanner.hasNext()) {
	writer.print(scanner.nextLine());
    }
}



// Distinguishing between throw and throws
The throw keyword means an exception is actually being thrown, while the throws
keyword indicates that the method merely has the
potential to throw that exception. The following example uses both:

10: public String getDataFromDatabase() throws SQLException {
11: throw new UnsupportedOperationException();
12: }

Line 10 declares that the method might or might not throw a SQLException. Since this is a checked
exception, the caller needs to handle or declare it. Line 11 actually does throw an
UnsupportedOperationException. Since this is a runtime exception, it does not need to be declared on
line 10.


Examining Exception Categories

The ZooMaintenance class shows an example of a method that handles an exception,
and one that declares an exception.

public class ZooMaintenance {
 public void open() {
 try {
    throw new Exception();
 } catch (Exception e) {
    // Handles exception
 }
 }

 public void close() throws Exception { // Declares exceptions
 throw new Exception();
 }
}

Unchecked exceptions

ArithmeticException         ArrayIndexOutOfBoundsException
ArrayStoreException         ClassCastException
IllegalArgumentException    IllegalStateException
MissingResourceException    NullPointerException
NumberFormatException       UnsupportedOperationException

Checked exceptions

FileNotFoundException       IOException
NotSerializableException    ParseException
SQLException


Inheriting Exception Classes
why does the following not compile?

try {
 throw new IOException();
} catch (IOException | FileNotFoundException e) {} // DOES NOT COMPILE

Since FileNotFoundException is a subclass of IOException, listing both in a multi‐ catch expression is
redundant, resulting in a compilation error.

еще пример

try {
 throw new IOException();
} catch (IOException e) {
} catch (FileNotFoundException e) {} // DOES NOT COMPILE
For the exam, remember that trying to catch a more specific exception (after already catching a broader
exception) results in unreachable code and a compiler error.

 */

/*
Creating Custom Exceptions

Declaring Exception Classes

When creating your own exception, you need to decide whether it should be a checked
or unchecked exception. While you can extend any exception class, it is most common
to extend Exception (for checked) or RuntimeException (for unchecked).
Creating your own exception class is really easy. Can you figure out whether
the exceptions are checked or unchecked in this example?

1: class CannotSwimException extends Exception {}       //  checked exception
2: class DangerInTheWater extends RuntimeException {}   //  unchecked exception
3: class SharkInTheWaterException extends DangerInTheWater {}   //  unchecked exception
4: class Dolphin {
5: public void swim() throws CannotSwimException {
6: // logic here
7: }
8: }



Adding Custom Constructors

The following example shows the three most common constructors defined by the Exception class:

public class CannotSwimException extends Exception {
     public CannotSwimException() {
     super(); // Optional, compiler will insert automatically
     }
     public CannotSwimException(Exception e) {
     super(e);
     }
     public CannotSwimException(String message) {
     super(message);
     }
}

The first constructor is the default constructor with no parameters. The second
constructor shows how to wrap another exception inside yours. The third constructor
shows how to pass a custom error message.

For example, the following constructor takes an Exception and calls the parent constructor
that takes a String:
public CannotSwimException(Exception e) {
 super("Cannot swim because: " + e.toString());
 }


We can even pass another exception, if there is an underlying cause
for the exception. Take a look at this version of our main() method:

15: public static void main(String[] unused) throws Exception {
16: throw new CannotSwimException(
17: new FileNotFoundException("Cannot find shark file"));
18: }

This would yield the longest output so far:
Exception in thread "main" CannotSwimException:
 java.io.FileNotFoundException: Cannot find shark file
 at CannotSwimException.main(CannotSwimException.java:16)
Caused by: java.io.FileNotFoundException: Cannot find shark file
 … 1 more


 Printing Stack Traces

try {
    throw new CannotSwimException();
} catch (CannotSwimException e) {
    e.printStackTrace();
}

Automating Resource Management
Constructing Try‐With‐Resources Statements

1) try‐with‐resources statements require resources that implement the AutoCloseable interface.

try (String reptile = "lizard") { // DOES NOT COMPILED, String не имплементит AutoCloseable
}

Inheriting AutoCloseable requires implementing a compatible close() method.
interface AutoCloseable {
 public void close() throws Exception;
}

Let's define our own custom resource class for use in a try‐with‐resources statement.

public class MyFileReader implements AutoCloseable {
     private String tag;
     public MyFileReader(String tag) { this.tag = tag;}

     @Override public void close() {
     System.out.println("Closed: "+tag);
     }
}


The following code snippet makes use of our custom reader class:
try (var bookReader = new MyFileReader("monkey")) {
 System.out.println("Try Block");
} finally {
 System.out.println("Finally Block");
}

The code prints the following at runtime:
Try Block
Closed: monkey
Finally Block

As you can see, the resources are closed at the end of the try statement,
before any catch or finally blocks are executed.


2) a try‐with‐resources statement can include multiple
resources, which are closed in the reverse order in which they are declared.
Resources are terminated by a semicolon (;), with the last one being optional.

Consider the following code snippet:

try (var bookReader = new MyFileReader("1");
     var movieReader = new MyFileReader("2");
     var tvReader = new MyFileReader("3");) {
     System.out.println("Try Block");
} finally {
    System.out.println("Finally Block");
}

When executed, this code prints the following:
Try Block
Closed: 3
Closed: 2
Closed: 1
Finally Block


3) resources declared within a try‐with‐resources statement are in scope
only within the try block.

This is another way to remember that the resources are closed before any catch
or finally blocks are executed, as the resources are no longer available.

3: try (Scanner s = new Scanner(System.in)) {
4: s.nextLine();
5: } catch(Exception e) {
6: s.nextInt(); // DOES NOT COMPILE
7: } finally {
8: s.nextInt(); // DOES NOT COMPILE
9: }

The problem is that Scanner has gone out of scope at the end of the try clause.
Lines 6 and 8 do not have access to it. This is actually a nice feature. You can't accidentally
use an object that has been closed.


Learning the New Effectively Final Feature
Starting with Java 9, it is possible to use resources declared prior to the
try‐with‐resources statement, provided they are marked final or effectively final.
The syntax is just to use the resource name in place of
the resource declaration, separated by a semicolon (;).

11: public void relax() {
12:   final var bookReader = new MyFileReader("4");     // a final variable variable
13:   MyFileReader movieReader = new MyFileReader("5"); // effectively final variable - local variable
                                                                that is assigned a value only once
14:   try (bookReader;          // новый способ указать ресурс в try‐with‐resources
15:   var tvReader = new MyFileReader("6");
16:   movieReader) {            // новый способ указать ресурс в try‐with‐resources
17: System.out.println("Try Block");
18:   } finally {
19:     System.out.println("Finally Block");
20:   }
21: }

On execution, the code prints the following:
Try Block
Closed: 5
Closed: 6
Closed: 4
Finally Block


The following does not compile:
31: var writer = Files.newBufferedWriter(path);
32: try(writer) { // DOES NOT COMPILE - не effectively final
33: writer.append("Welcome to the zoo!");
34: }
35: writer = null;

Использование ресурса после его закрытия
41: var writer = Files.newBufferedWriter(path);
42: writer.append("This write is permitted but a really bad idea!");
43: try(writer) {
44: writer.append("Welcome to the zoo!");
45: }
46: writer.append("This write will fail!"); // IOException


Плохая практика определять ресурс до try-with-resources

 51: var reader = Files.newBufferedReader(path1);
 52: var writer = Files.newBufferedWriter(path2); // Don’t do this!
 53: try (reader; writer) {}

 If line 52 throws an exception, such as the file cannot be found, then the
resource declared on line 51 will never be closed.


// Understanding Suppressed Exceptions

What happens if the close() method throws an exception? Let's try an illustrative example:
public class TurkeyCage implements AutoCloseable {
     public void close() {
        System.out.println("Close gate");
     }
     public static void main(String[] args) {
         try (var t = new TurkeyCage()) {
            System.out.println("Put turkeys in");
         }
     }
}

Попробуем перехватить исключение из close()

1: public class JammedTurkeyCage implements AutoCloseable {
2: public void close() throws IllegalStateException {
3:  throw new IllegalStateException("Cage door does not close");
4: }
5: public static void main(String[] args) {
6: try (JammedTurkeyCage t = new JammedTurkeyCage()) {
7:  System.out.println("Put turkeys in");
8: } catch (IllegalStateException e) {
9:  System.out.println("Caught: " + e.getMessage());
10: }
11: }
12: }

Вывод: Caught: Cage door does not close

This seems reasonable enough. What happens if the try block also throws an exception?
When multiple exceptions are thrown, all but the first are called suppressed exceptions.
The idea is that Java treats the first
exception as the primary one and tacks on any that come up while automatically closing.

5: public static void main(String[] args) {
6:  try (JammedTurkeyCage t = new JammedTurkeyCage()) {
7:      throw new IllegalStateException("Turkeys ran off");
8:  } catch (IllegalStateException e) {
9:      System.out.println("Caught: " + e.getMessage());
10:     for (Throwable t: e.getSuppressed())
11:         System.out.println("Suppressed: "+t.getMessage());
12:     }
13: }

Line 7 throws the primary exception. At this point, the try clause ends, and Java
automatically calls the close() method. Line 3 of JammedTurkeyCage throws an IllegalStateException,
which is added as a suppressed exception. Then line 8 catches the primary exception.
Line 9 prints the message for the primary exception. Lines 10–11 iterate through any
suppressed exceptions and print them. The program prints the following:

Caught: Turkeys ran off
Suppressed: Cage door does not close


Keep in mind that the catch block looks for matches on the primary exception.
What do you think this code prints?

5: public static void main(String[] args) {
6:  try (JammedTurkeyCage t = new JammedTurkeyCage()) {
7:      throw new RuntimeException("Turkeys ran off");
8:  } catch (IllegalStateException e) {
9:          System.out.println("caught: " + e.getMessage());
10:     }
11: }

Line 7 again throws the primary exception. Java calls the close() method and adds
a suppressed exception. Line 8 would catch the IllegalStateException.
However, we don't have one of those. The primary exception is a RuntimeException.


Запомни: If more than two resources throw an exception, the first one to be thrown
becomes the primary exception, with the rest being grouped as suppressed exceptions.
And since resources are closed in reverse order in which they are declared,
the primary exception would be on the last declared resource that throws an exception.

Keep in mind that suppressed exceptions apply only to exceptions thrown in the try clause. The following
example does not throw a suppressed exception:
5: public static void main(String[] args) {
6: try (JammedTurkeyCage t = new JammedTurkeyCage()) {
7: throw new IllegalStateException("Turkeys ran off");
8: } finally {
9: throw new RuntimeException("and we couldn't find them");
10: }
11: }

Line 7 throws an exception. Then Java tries to close the resource and adds a suppressed
exception to it. Now we have a problem. The finally block runs after all this. Since
line 9 also throws an exception, the previous exception from line 7 is lost, with the code
printing the following:

Exception in thread "main" java.lang.RuntimeException:
 and we couldn't find them
 at JammedTurkeyCage.main(JammedTurkeyCage.java:9)


Declaring Assertions
Validating Data with the assert Statement

The syntax for an assert statement has two forms
* assert test_value;
* assert test_value: message;  (message - optional)

When assertions are enabled and the boolean expression evaluates to false, then an
AssertionError will be thrown at runtime. Since programs aren't supposed to catch an Error,
this means that assertion failures are fatal and end the program!

assert is a keyword

Assertions may include optional parentheses and a message. For example,
each of the following is valid:

assert 1 == age;
assert(2 == height);
assert 100.0 == length : "Problem with length";
assert ("Cecelia".equals(name)): "Failed to verify user data";


Recognizing Assertion Syntax Errors

 assert(1);         // должен быть boolean
 assert x -> true;  // должен быть boolean
 assert 1==2 ? "Accept" : "Error";  // должен быть boolean
 assert.test(5> age);   // некорректный синтаксис

The three possible outcomes of an assert statement are as follows:
* If assertions are disabled, Java skips the assertion and goes on in the code.
* If assertions are enabled and the boolean expression is true, then our assertion
has been validated and nothing happens. The program continues to execute in its normal manner.
* If assertions are enabled and the boolean expression is false, then our assertion is
invalid and an AssertionError is thrown.

Let's try an example. Consider the following:
1: public class Party {
2:  public static void main(String[] args) {
3:      int numGuests = -5;
4:      assert numGuests> 0;
5:      System.out.println(numGuests);
6:  }
7: }

We can enable assertions by executing it using the single‐file source‐code command, as shown here:
java –ea Party.java

If we run the same program using the command line java Party, we get a different result. The program
prints ‐5.


Enabling Assertions
By default, assert statements are ignored by the JVM at runtime.
To enable assertions, use the ‐enableassertions flag on the command line.
java -enableassertions Rectangle

You can also use the shortcut ‐ea flag.
java -ea Rectangle

Using the ‐enableassertions or ‐ea flag without any arguments enables assertions in all classes
(except system classes). You can also enable assertions for a specific class or package.

For example, the following command enables assertions only for classes in the
com.demos package and any subpackages:

java -ea:com.demos… my.programs.Main

The ellipsis (…) means any class in the specified package or subpackages.
You can also enable assertions for a specific class.
java -ea:com.demos.TestColors my.programs.Main


Disabling Assertions

Sometimes you want to enable assertions for the entire application but disable it for
select packages or classes. Java offers the ‐disableassertions or ‐da flag for
just such an occasion. The following command enables assertions for the com.demos package
but disables assertions for the TestColors class:

java -ea:com.demos… -da:com.demos.TestColors my.programs.Main

For the exam, make sure you understand how to use the ‐ea and ‐da flags in conjunction with each other.

By default, all assertions are disabled. Then, those items marked with ‐ea are
enabled. Finally, all of the remaining items marked with ‐da are disabled.


Writing Assertions Correctly

One of the most important rules you should remember from this section is: assertions
should never alter outcomes. This is especially true because assertions can, should,
and probably will be turned off in a production environment.
For example, the following assertion is not a good design
because it alters the value of a variable:

int x = 10;
assert ++x> 10; // Not a good design!

When assertions are turned on, x is incremented to 11; but when assertions are turned off,
the value of x is 10. This is not a good use of assertions because the outcome of the code
will be different depending on whether assertions are turned on.


Working with Dates and Times

Java includes numerous classes to model the examples in the previous paragraph.

Class                       Description                     Example

java.time.LocalDate         Date with day, month, year      Birth date

java.time.LocalTime         Time of day                     Midnight

java.time.LocalDateTime     Day and time with no time zone  10 a.m. next Monday

java.time.ZonedDateTime     Date and time with a            9 a.m. EST on 2/20/2021
                            specific time zone

Each of these types contains a static method called now() that allows you to get
the current value.

System.out.println(LocalDate.now());        // 2020-10-14
System.out.println(LocalTime.now());        // 12:45:20.854
System.out.println(LocalDateTime.now());    // 2020-10-14T12:45:20.854
System.out.println(ZonedDateTime.now());    // 2020-10-14T12:45:20.854-04:00[America/New_York]


Using the of() Methods

LocalDate date1 = LocalDate.of(2020, Month.OCTOBER, 20);
LocalDate date2 = LocalDate.of(2020, 10, 20);

LocalTime time1 = LocalTime.of(6, 15); // hour and minute
LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

LocalTime time1 = LocalTime.of(6, 15); // hour and minute
LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

Можно комбинировать

var dt1 = LocalDateTime.of(2020, Month.OCTOBER, 20, 6, 15, 30);
LocalDate date = LocalDate.of(2020, Month.OCTOBER, 20);
LocalTime time = LocalTime.of(6, 15);
var dt2 = LocalDateTime.of(date, time); // на вход подаем date и time


Formatting Dates and Times

The date and time classes support many methods to get data out of them.

LocalDate date = LocalDate.of(2020, Month.OCTOBER, 20);
System.out.println(date.getDayOfWeek()); // TUESDAY
System.out.println(date.getMonth()); // OCTOBER


Java provides a class called DateTimeFormatter to display standard formats.

LocalDate date = LocalDate.of(2020, Month.OCTOBER, 20);
LocalTime time = LocalTime.of(11, 12, 34);
LocalDateTime dt = LocalDateTime.of(date, time);
System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

The code snippet prints the following:
2020-10-20
11:12:34
2020-10-20T11:12:34

The DateTimeFormatter will throw an exception if it encounters an incompatible type.
For example, each of the following will produce an exception at runtime since it attempts
to format a date with a time value, and vice versa:

System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_TIME)); в дату - время
System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_DATE)); во время - дату

If you don't want to use one of the predefined formats, DateTimeFormatter supports
a custom format using a date format String.

var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
System.out.println(dt.format(f)); // October 20, 2020 at 11:12


The Date and SimpleDateFormat Classes

DateFormat s = new SimpleDateFormat("MMMM dd, yyyy 'at' hh:mm");
System.out.println(s.format(new Date())); // October 20, 2020 at 06:15


Learning the Standard Date/Time Symbols

Common date/time symbols

Symbol  Meaning             Examples
y       Year                20, 2020
M       Month               1, 01, Jan, January
d       Day                 5, 05
h       Hour                9, 09
m       Minute              45
s       Second              52
a       a.m./p.m.           AM, PM
z       Time Zone Name      Eastern Standard Time, EST
Z       Time Zone Offset    ‐0400


What do you think the following prints?

var dt = LocalDateTime.of(2020, Month.OCTOBER, 20, 6, 15, 30);
var formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
System.out.println(dt.format(formatter1));          // 10/20/2020 06:15:30

var formatter2 = DateTimeFormatter.ofPattern("MM_yyyy_-_dd");
System.out.println(dt.format(formatter2));          // 10_2020_-_20
var formatter3 = DateTimeFormatter.ofPattern("h:mm z");
System.out.println(dt.format(formatter3));   // Exception in thread "main" java.time.DateTimeException:
                                                Unable to extract ZoneId from temporal 2020-10-20T06:15:30

If ZonedDateTime was used instead, then the code would have completed successfully
and printed something like 06:15 EDT, depending on the time zone.


Supported date/time symbols

Symbol      LocalDate       LocalTime       LocalDateTime       ZonedDateTime
y               √                               √                   √
M               √                               √                   √
d               √                               √                   √
h                               √               √                   √
m                               √               √                   √
s                               √               √                   √
a                               √               √                   √
z                                                                   √
Z                                                                   √


Selecting a format() Method

The date/time classes contain a format() method that will take a formatter,
while the formatter classes contain a format() method that will take a date/time value.

var dateTime = LocalDateTime.of(2020, Month.OCTOBER, 20, 6, 15, 30);
var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
System.out.println(dateTime.format(formatter)); // 10/20/2020 06:15:30
System.out.println(formatter.format(dateTime)); // 10/20/2020 06:15:30

Adding Custom Text Values

var dt = LocalDateTime.of(2020, Month.OCTOBER, 20, 6, 15, 30);
var f1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy ");
var f2 = DateTimeFormatter.ofPattern(" hh:mm");
System.out.println(dt.format(f1) + "at" + dt.format(f2));

This prints October 20, 2020 at 06:15 at runtime.

можно так экранировать текст
var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
System.out.println(dt.format(f)); // October 20, 2020 at 06:15

экранирование символа '

var g1 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
System.out.println(dt.format(g1)); // October 20, Party's at 06:15
var g2 = DateTimeFormatter.ofPattern("'System format, hh:mm: 'hh:mm");
System.out.println(dt.format(g2)); // System format, hh:mm: 06:15
var g3 = DateTimeFormatter.ofPattern("'NEW! 'yyyy', yay!'");
System.out.println(dt.format(g3)); // NEW! 2020, yay!


Without escaping the text values with single quotes, an exception will be thrown
at runtime if the text cannot be interpreted as a date/time symbol.

DateTimeFormatter.ofPattern("The time is hh:mm"); // Exception thrown


This line throws an exception since T is an unknown symbol. The exam might
also present you with an incomplete escape sequence.

DateTimeFormatter.ofPattern("'Time is: hh:mm: "); // Exception thrown



// Supporting Internationalization and Localization
Picking a Locale

The Locale class is in the java.util package. The first useful Locale to find
is the user's current locale. Try running the following code on your computer:

Locale locale = Locale.getDefault();
System.out.println(locale);

When we run it, it prints en_US. First comes the lowercase language code. The language is
always required. Then comes an underscore followed by the uppercase country code.
The country is optional.

As practice, make sure that you understand why each of these Locale identifiers is invalid:
US // Cannot have country without language
enUS // Missing underscore
US_en // The country and language are reversed
EN // Language must be lowercase

The corrected versions are en and en_US.


As a developer, you often need to write code that selects a locale other than the default one.
There are three common ways of doing this.
1)
System.out.println(Locale.GERMAN); // de
System.out.println(Locale.GERMANY); // de_DE

2)
System.out.println(new Locale("fr")); // fr
System.out.println(new Locale("hi", "IN")); // hi_IN

Java will let you create a Locale with an invalid language or country, such as xx_XX.
However, it will not match the Locale that you want to use, and your program will not behave as expected.

3)
Locale l1 = new Locale.Builder()
 .setLanguage("en")
 .setRegion("US")
 .build();
Locale l2 = new Locale.Builder()
 .setRegion("US")
 .setLanguage("en")
 .build();



When testing a program, you might need to use a Locale other than the default of your computer.
System.out.println(Locale.getDefault()); // en_US
Locale locale = new Locale("fr");
Locale.setDefault(locale); // change the default
System.out.println(Locale.getDefault()); // fr


Localizing Numbers
Factory methods to get a NumberFormat

Description                     Using default Locale and a specified Locale
A general‐purpose formatter     NumberFormat.getInstance()
                                NumberFormat.getInstance(locale)

Same as getInstance             NumberFormat.getNumberInstance()
                                NumberFormat.getNumberInstance(locale)

For formatting monetary         NumberFormat.getCurrencyInstance()
amounts                         NumberFormat.getCurrencyInstance(locale)


For formatting percentages      NumberFormat.getPercentInstance()
                                NumberFormat.getPercentInstance(locale)

Rounds decimal values before    NumberFormat.getIntegerInstance()
displaying                      NumberFormat.getIntegerInstance(locale)



// Formatting Numbers

int attendeesPerYear = 3_200_000;
int attendeesPerMonth = attendeesPerYear / 12;
var us = NumberFormat.getInstance(Locale.US);
System.out.println(us.format(attendeesPerMonth));

var gr = NumberFormat.getInstance(Locale.GERMANY);
System.out.println(gr.format(attendeesPerMonth));

var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
System.out.println(ca.format(attendeesPerMonth));


The output looks like this:
266,666
266.666
266 666


Formatting currency works the same way.
double price = 48;
var myLocale = NumberFormat.getCurrencyInstance();
System.out.println(myLocale.format(price));

When run with the default locale of en_US for the United States, it outputs $48.00.
On the other hand, when run with the default locale of en_GB for Great Britain, it outputs £48.00.


// Parsing Numbers
The parse() method, found in various types, declares a checked exception
ParseException that must be handled or declared in the method in which they are called.

Let's look at an example. The following code parses a discounted ticket price with
different locales. The parse() method actually throws a checked ParseException, so make sure
to handle or declare it in your own code.

String s = "40.45";
var en = NumberFormat.getInstance(Locale.US);
System.out.println(en.parse(s)); // 40.45
var fr = NumberFormat.getInstance(Locale.FRANCE);
System.out.println(fr.parse(s)); // 40

String income = "$92,807.99";
var cf = NumberFormat.getCurrencyInstance();
double value = (Double) cf.parse(income);
System.out.println(value); // 92807.99


Writing a Custom Number Formatter

Like you saw earlier when working with dates, you can also create your own number
format strings using the DecimalFormat class, which extends NumberFormat.

Symbol          Meaning                                             Examples
#               Omit the position if no digit exists for it.        $2.2
0               Put a 0 in the position if no digit exists for it.  $002.20

These examples should help illuminate how these symbols work:
12: double d = 1234567.467;
13: NumberFormat f1 = new DecimalFormat("###,###,###.0");
14: System.out.println(f1.format(d)); // 1,234,567.5
15:
16: NumberFormat f2 = new DecimalFormat("000,000,000.00000");
17: System.out.println(f2.format(d)); // 001,234,567.46700
18:
19: NumberFormat f3 = new DecimalFormat("$#,###,###.##");
20: System.out.println(f3.format(d)); // $1,234,567.47


// Localizing Dates
Like numbers, date formats can vary by locale.

Table shows methods used to retrieve an instance of a DateTimeFormatter using the default locale.

Description                         Using default Locale
For formatting dates                DateTimeFormatter.ofLocalizedDate(dateStyle)

For formatting times                DateTimeFormatter.ofLocalizedTime(timeStyle)

For formatting dates and times      DateTimeFormatter.ofLocalizedDateTime(dateStyle, timeStyle)
                                    DateTimeFormatter.ofLocalizedDateTime(dateTimeStyle)

Each method in the table takes a FormatStyle parameter, with possible values
SHORT, MEDIUM, LONG, and FULL.

What if you need a formatter for a specific locale? Easy enough—just append
withLocale(locale) to the method call.

public static void print(DateTimeFormatter dtf, LocalDateTime dateTime, Locale locale) {
 System.out.println(dtf.format(dateTime) + ", " + dtf.withLocale(locale).format(dateTime));
}
public static void main(String[] args) {
 Locale.setDefault(new Locale("en", "US"));
 var italy = new Locale("it", "IT");
 var dt = LocalDateTime.of(2020, Month.OCTOBER, 20, 15, 12, 34);

 // 10/20/20, 20/10/20
 print(DateTimeFormatter.ofLocalizedDate(SHORT),dt,italy);

 // 3:12 PM, 15:12
 print(DateTimeFormatter.ofLocalizedTime(SHORT),dt,italy);

 // 10/20/20, 3:12 PM, 20/10/20, 15:12
 print(DateTimeFormatter.ofLocalizedDateTime(SHORT,SHORT),dt,italy);
}



// Creating a Resource Bundle
For now, we need English and French properties files for our Zoo resource bundle.
First, create two properties files.

Zoo_en.properties
hello=Hello
open=The zoo is open

Zoo_fr.properties
hello=Bonjour
open=Le zoo est ouvert

The filenames match the name of our resource bundle, Zoo. They are then followed
by an underscore (_), target locale, and .properties file extension. We can write our
very first program that uses a resource bundle to print this information.

10: public static void printWelcomeMessage(Locale locale) {
11: var rb = ResourceBundle.getBundle("Zoo", locale);
12: System.out.println(rb.getString("hello")
13: + ", " + rb.getString("open"));
14: }
15: public static void main(String[] args) {
16:     var us = new Locale("en", "US");
17:     var france = new Locale("fr", "FR");
18:     printWelcomeMessage(us); // Hello, The zoo is open
19:     printWelcomeMessage(france); // Bonjour, Le zoo est ouvert
20: }

Since a resource bundle contains key/value pairs, you can even loop through them to
list all of the pairs. The ResourceBundle class provides a keySet() method to get a set of all keys.

var us = new Locale("en", "US");
ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
rb.keySet().stream()
 .map(k -> k + ": " + rb.getString(k))
 .forEach(System.out::println);

Будет напечатано:
hello: Hello
open: The zoo is open



// Picking a Resource Bundle
There are two methods for obtaining a resource bundle that you should be familiar with for the exam.
ResourceBundle.getBundle("name");  // использует дефолтную локацию
ResourceBundle.getBundle("name", locale);


// Formatting Messages

For example, suppose that we had this property defined:
helloByName=Hello, {0} and {1}

Given a resource bundle rb:
String format = rb.getString("helloByName");
System.out.print(MessageFormat.format(format, "Tammy", "Henry"));

Будет напечатано:
Hello, Tammy and Henry


// Using the Properties Class

It functions like the HashMap class, except that it uses String values for
the keys and values. Let's create one and set some values.

import java.util.Properties;
public class ZooOptions {
 public static void main(String[] args) {
     var props = new Properties();
     props.setProperty("name", "Our zoo");
     props.setProperty("open", "10am");
 }
}

The Properties class is commonly used in handling values that may not exist.
System.out.println(props.getProperty("camel")); // null
System.out.println(props.getProperty("camel", "Bob")); // Bob

The Properties class also includes a get() method, but only getProperty() allows for a default value.
For example, the following call is invalid since get() takes only a single parameter:
props.get("open"); // 10am
props.get("open", "The zoo will be open soon"); // DOES NOT COMPILE


A Properties object isn't just similar to a Map; it actually inherits Map<Object,Object>.
Но надо пользоваться методами getProperty() и setProperty()

var props = new Properties();
 props.put("tigerAge", "4");
 props.put("lionAge", 5);
 System.out.println(props.getProperty("tigerAge")); // 4
 System.out.println(props.getProperty("lionAge")); // null





















































































































































































































































































 */
