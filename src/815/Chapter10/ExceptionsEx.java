package Chapter10;

import java.io.IOException;

public class ExceptionsEx {
    void fall(int distance) throws IOException {
        if (distance > 10) {
            throw new IOException();
        }
    }
    // метод с обработкой исключения
    void fall_with_handle(int distance) {
        try {
            if(distance > 10) {
                throw new IOException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // можно так выбрасывать исключения
/*
        throw new Exception();
        throw new Exception("Ow! I fell.");
        throw new RuntimeException();
        throw new RuntimeException("Ow! I fell.");
    */
}

// Эксепш это объект, поэтому с ним можно работать так
// Exception e = new RuntimeException();
// throw e;


// без new не полетит
//throw RuntimeException(); // DOES NOT COMPILE

// еще ошибки
// 3: try {
// 4: throw new RuntimeException();
// 5: throw new ArrayIndexOutOfBoundsException(); // DOES NOT COMPILE - unreacheble, компилятор это понимает и ошибается
// 6: } catch (Exception e) {
// 7: }


// Types of exceptions and errors

// Runtime exception (Subclass of RuntimeException) - можно ловить, unchecked
//Checked exception  (Subclass of Exception but not subclass of RuntimeException) - можно ловить, checked
// Error (Subclass of Error) - не надо ловить, unchecked

/*
Common RuntimeException classes include the following:

ArithmeticException Thrown when code attempts to divide by zero (int answer = 11 / 0;)

ArrayIndexOutOfBoundsException Thrown when code uses an illegal index to access an array
int[] countsOfMoose = new int[3];
System.out.println(countsOfMoose[-1]);

ClassCastException Thrown when an attempt is made to cast an object to a class of which it is not an instance
String type = "moose";
Integer number = (Integer) type; // DOES NOT COMPILE - компилятор знает, что String нельзя привести к Integer
// ошибка в рантайме
String type = "moose";
Object obj = type;
Integer number = (Integer) obj; // компилятор будем, что кастануть Object в Integer можно. но он не знает, что там String

NullPointerException Thrown when there is a null reference where an object is required
String name;
public void printLength() {
    System.out.println(name.length());
}


IllegalArgumentException Thrown by the programmer to indicate that a method has been passed an illegal or inappropriate argument
public void setNumberEggs(int numberEggs) {
    if (numberEggs < 0)
        throw new IllegalArgumentException("# eggs must not be negative");
    this.numberEggs = numberEggs;
}


NumberFormatException Subclass of IllegalArgumentException thrown when an attempt is made to convert a string to a numeric type but the
    string doesn’t have an appropriate format
Integer.parseInt("abc");
 */

// Checked Exception Classes
/*
Common checked exceptions include the following:
IOException Thrown programmatically when there’s a problem reading or writing a file
FileNotFoundException Subclass of IOException thrown programmatically when code tries to reference a file that does not exist
FileNotFoundException is a subclass of IOException.
 */

// Error Classes (unchecked exceptions)
/*
ExceptionInInitializerError - Thrown when a static initializer throws an exception and doesn’t handle it
static {
    int[] countsOfMoose = new int[3];
    int num = countsOfMoose[-1];
}
public static void main(String... args) { }

StackOverflowError - Thrown when a method calls itself too many times (This is called infinite recursion because the method typically calls itself without end.)
public static void doNotCodeThis(int num) {
    doNotCodeThis(1);
}

NoClassDefFoundError - Thrown when a class that the code uses is available at compile time but not runtime
 */


// Handling Exceptions - Using try and catch Statements
class HandlingExeptionsEx {
    public static void main(String[] args) {
        try {
            int a = 30, b = 0;
            int c = a / b;  // cannot divide by zero
            System.out.println("Result = " + c);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide a number by 0");
        }
    }
}

/* Ошибки
1) Отсутствуют {}
    try // DOES NOT COMPILE
    fall();
    catch (Exception e)
    System.out.println("get up");

2) Нет ничего после try
    try { // DOES NOT COMPILE
        fall();
    }
    3) Сначала обрабатывается исключение суперкласса, а затем подкласса - unreacheble state
        public void visitMonkeys() {
        try {
            seeAnimal();
        } catch (ExhibitClosed e) {
            System.out.print("not today");
        } catch (ExhibitClosedForLunch e) { // DOES NOT COMPILE
            System.out.print("try back later");
            }
        }
        // Так норм:

        The following example shows exception types that do inherit from each other:
        public void visitMonkeys() {
            try {
                seeAnimal();
                } catch (ExhibitClosedForLunch e) { // subclass exception
                    System.out.print("try back later");
                } catch (ExhibitClosed e) { // superclass exception
                    System.out.print("not today");
                }
        }

4) Еще пример ошибки компиляции
public void visitSnakes() {
    try {
        } catch (IllegalArgumentException e) {
        } catch (NumberFormatException e) { // DOES NOT COMPILE
        }
}

5) Ошибка находится только в своем скоупе
public void visitManatees() {
try {
    } catch (NumberFormatException e1) {
        System.out.println(e1);
    } catch (IllegalArgumentException e2) {
        System.out.println(e1); // DOES NOT COMPILE
    }
}
 */

// A multi-catch block allows multiple exception types to be caught by the same catch block.
class Ex1 {
    public static void main(String[] args) {
        try {
            System.out.println(Integer.parseInt(args[1])); } catch
        (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Missing or invalid input");
        }
    }

    /*
catch(Exception1 e | Exception2 e | Exception3 e) // DOES NOT COMPILE - должна быть только одна переменная с ошибкой
catch(Exception1 e1 | Exception2 e2 | Exception3 e3) // DOES NOT COMPILE - должна быть только одна переменная с ошибкой
catch(Exception1 | Exception2 | Exception3 e)     - скомпилируется
     */


    /*
    try {
        throw new IOException();
        } catch (FileNotFoundException | IOException p) {} // DOES NOT COMPILE - лишний IOException, FileNotFoundException is a subclass of IOException
     */
}


// Adding a finally Block

class Ex2 {
    public static void main(String[] args) {
//            try { // DOES NOT COMPILE  - сначала catch потом finally
//            } finally {
//            System.out.println("all better");
//            } catch (Exception e) {
//            System.out.println("get up");
//            }

//            try { // DOES NOT COMPILE  - отсутствует catch
//            }

            try {        // catch может отсутствовать, если есть finally
            } finally {
            System.out.println("all better");
            }
    }
}

class Ex3 {
    public static void main(String[] unused) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("t");
        } catch (Exception e) {
            sb.append("c");
        } finally {
            sb.append("f");
        }
        sb.append("a");
        System.out.print(sb.toString());    // tfa.
    }
}

// еще одно важное правило, finally всегда выполняется и обрывает другие ветки
class Ex4{
    public static void main(String[] args) {
        System.out.println("doIt = " + doIt()); // всегда будет возвращать, независимо от блоков try/catch
    }
    static int doIt() {
        try {
            // Optionally throw an exception here
            System.out.print("1");
            return -1;
        } catch (Exception e) {
            System.out.print("2");
            return -2;
        } finally {
            System.out.print("3");
            System.out.println();
            return -3;
        }
    }
}

// еще пример
/*
    } finally {
    32: info.printDetails();
    33: System.out.print("Exiting");
    34: return "zoo";
    35: }

    Если на 32 строке получим npe - то получаем эксепш и код дальше 32й строки не идет
 */

// еще пример когда finally не выполнится
/*
try {
    System.exit(0);
} finally {
    System.out.print("Never going to get here"); // Not printed
}
 */


// Finally Closing Resources ( try-with-resources )
// Let’s take a look at our same example using a try-with-resources statement:
/*
    public void readFile(String file) {
        try (FileInputStream is = new FileInputStream("myfile.txt")) {  // тут может быть несколько файлов. Должны быть разделены ;. Последняя ;  не обязатально
        // Read file data
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
 */
// try-with-resources - может быть без catch и finally блока, т.к. finally блок неявно пишется

/*
try (MyFileClass is = new MyFileClass(1), // DOES NOT COMPILE - через запятую ресурсы нельзя
os = new MyFileClass(2)) {
}
try (MyFileClass ab = new MyFileClass(1), // DOES NOT COMPILE - через запятую ресурсы нельзя
MyFileClass cd = new MyFileClass(2)) {
}
 */

// var можно использовать, т.к. это локальная переменная
/*
try (var f = new BufferedInputStream(new FileInputStream("it.txt"))) {
// Process file
}
 */


// Scope of Try-with-Resources

/*
    try (Scanner s = new Scanner(System.in)) {
        s.nextLine();
    } catch(Exception e) {
        s.nextInt(); // DOES NOT COMPILE - s за скоупом
    } finally {
        s.nextInt(); // DOES NOT COMPILE - s за скоупом
    }
 */

class HandlingExeptionsEx2 {
    public static void main(String[] args) {
        int aaaa = 0;

        try {
            int a = 30, b = 0;
            int c = a / b;  // cannot divide by zero
            System.out.println("Result = " + c);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide a number by 0");
            System.out.println(aaaa);                           // тут есть доступ
        } finally {
            System.out.println(aaaa);                           // тут есть доступ
        }
    }
}

/* Правила try-with-resources
Resources are closed after the try clause ends and before any catch/finally clauses.
Resources are closed in the reverse order from which they were created.
 */

class MyFileClass implements AutoCloseable {
    private final int num;
    public MyFileClass(int num) { this.num = num; }
    public void close() {
        System.out.println("Closing: " + num);
    }
}

class Ex6 {
    public static void main(String... xyz) {
        try (MyFileClass a1 = new MyFileClass(1);
             MyFileClass a2 = new MyFileClass(2)) {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("ex");
        } finally {
            System.out.println("finally");
        }
        // Closing: 2
        // Closing: 1
        // ex
        // finally
    }
}

// Throwing Additional Exceptions
class Ex7 {
    public static String exceptions() {
        StringBuilder result = new StringBuilder();
        String v = null;
        try {
            try {
                result.append("before_");
                v.length();
                result.append("after_");
                } catch (NullPointerException e) {
                result.append("catch_");
                throw new RuntimeException();
                } finally {
                result.append("finally_");
                throw new Exception();
                }
            } catch (Exception e) {
            result.append("done");
            }
        return result.toString();
        }

    public static void main(String[] args) {
        System.out.println(exceptions());  // before_catch_finally_done
    }
}


// Calling Methods That Throw Exceptions
class NoMoreCarrotsException extends Exception {}

class Bunny {
    public static void main(String[] args) {
//        eatCarrot(); // DOES NOT COMPILE - вызываем метод, который может! выбросить экспешн. Этого достаточно, чтобы компилятор требовал обработать его
    }
    private static void eatCarrot() throws NoMoreCarrotsException {}
}

/* 1. или мы декларируем эксепшн - пробрасываем
public static void main(String[] args) throws NoMoreCarrotsException { // declare exception
eatCarrot();
}

2. или мы обрабатываем исключение
public static void main(String[] args) {
    try {
        eatCarrot();
    } catch (NoMoreCarrotsException e ) { // handle exception
        System.out.print("sad rabbit");
    }
}
 */


// еще пример
class Bunny2 {
    public void bad() {
//        try {
//            eatCarrot();
//        } catch (NoMoreCarrotsException e ) { // DOES NOT COMPILE - Java знает, что eatCarrot() не выбросит исключение, поэтому код unreachable - ошибка
//            System.out.print("sad rabbit");
//        }
    }
    public void good() throws NoMoreCarrotsException {
        eatCarrot();
    }
    private void eatCarrot() { }
}

// Declaring and Overriding Methods with Exceptions
//When a class overrides a method from a superclass or implements a method from an interface, it’s not allowed to add new checked exceptions to
//the method signature

class CanNotHopException extends Exception { }
class Hopper {
    public void hop() { }
}
class Bunny3 extends Hopper {
//    public void hop() throws CanNotHopException { } // DOES NOT COMPILE - нельзя добавлять новые checked эксепшены
}

// в подклассе можно указывать меньше эксепшенов, т.к. супер класс/интерфейс уже их определил
class Hopper2 {
    public void hop() throws CanNotHopException { }
}
class Bunny4 extends Hopper2 {
    public void hop() { }   // тут можно не указывать эксепшен
}

// a class is allowed to declare a subclass of an CHECKED exception type.
class Hopper5 {
    public void hop() throws Exception { }
}
class Bunny5 extends Hopper5 {
    public void hop() throws CanNotHopException { }
}

// declare new UNCHECKED exceptions in a subclass method is that the declaration is redundant.
class Hopper6 {
    public void hop() { }
}
class Bunny6 extends Hopper6 {
    public void hop() throws IllegalStateException { }
}


// Printing an Exception
// You can let Java print it out, print just the message, or print where the stack trace comes from.

// System.out.println(e);   // - java.lang.RuntimeException: cannot hop
// System.out.println(e.getMessage());  // - cannot hop
// e.printStackTrace();       // - java.lang.RuntimeException: cannot hop
                              //   at Handling.hop(Handling.java:15)
                              //   at Handling.main(Handling.java:7)


