package Chapter10;

public class Q {
}

class Q1 {
    // Which of the following statements are true? (Choose all that apply.)  // Correct
    //A. Exceptions of type RuntimeException are unchecked. // Correct
    //B. Exceptions of type RuntimeException are checked.
    //C. You can declare unchecked exceptions.              // Correct
    //D. You can declare checked exceptions.                // Correct
    //E. You can handle only Exception subclasses.          // Throwable состоит из Error и Exception
    //F. All exceptions are subclasses of Throwable.        // Correct
}

class Q2 {
    // Which of the following pairs fill in the blanks to make this code compile? (Choose all that apply.)
    //6: public void ohNo(ArithmeticException ae) _______
    //Exception {
    //7: if(ae==null) ______________ Exception();
    //8: else ______________ ae;
    //9: }

    //A. On line 6, fill in throw
    //B. On line 6, fill in throws      // Correct
    //C. On line 7, fill in throw
    //D. On line 7, fill in throw new   // Correct
    //E. On line 8, fill in throw       // Correct
    //F. On line 8, fill in throw new
    //G. None of the above
}

class Q3 {
    // What is printed by the following? (Choose all that apply.)
    // 1: public class Mouse {
    // 2: public String name;
    // 3: public void findCheese() {
    // 4: System.out.print("1");
    // 5: try {
    // 6: System.out.print("2");
    // 7: name.toString();          // тут ошибка
    // 8: System.out.print("3");
    // 9: } catch (NullPointerException e | ClassCastException  - только одна переменная должна быть объявлена
    // e) {
    // 10: System.out.print("4");
    // 11: throw e;
    // 12: }
    // 13: System.out.print("5");
    // 14: }
    // 15: public static void main(String... tom) {
    // 16: Mouse jerry = new Mouse();   // не указали name -> npe
    // 17: jerry.findCheese();
    // 18: } }

    // A. 1
    // B. 2
    // C. 3
    // D. 4
    // E. 5
    // F. The stack trace for a NullPointerException
    // G. None of the above
}
// Если убрать ошибку
class Mouse {
    public String name;

    public void findCheese() {
        System.out.print("1");
        try {
            System.out.print("2");
            name.toString();          // тут ошибка
            System.out.print("3");
        } catch (NullPointerException | ClassCastException  // - только одна переменная должна быть объявлена
                e) {
            System.out.print("4");
            throw e;
        }
        System.out.print("5");
    }

    public static void main(String... tom) {
        Mouse jerry = new Mouse();   // 124 NullPointerException
        jerry.findCheese();
    }
}

class Q4 {
    // Which of the following statements about finally blocks are true? (Choose all that apply.)
    //A. A finally block is never required with a regular try statement.
    //B. A finally block is required when there are no catch blocks in a regular try statement. // Correct - требуется или catch или finally, или оба
    //C. A finally block is required when the program code doesn’t terminate on its own.
    //D. A finally block is never required with a try-with-resources statement. // Correct - try-with-resources может существовать только с одним try
    //E. A finally block is required when there are no catch blocks in a try-with-resources statement.
    //F. A finally block is required in order to make sure all resources are closed in a try-with-resources statement.
    //G. A finally block is executed before the resources declared in a try-with-resources statement are closed. // он выполняется после декларирования
}

class Q5 {
    // Which exception will the following method throw?
    //3: public static void main(String[] other) {
    //4: Object obj = Integer.valueOf(3);
    //5: String str = (String) obj;     // попыткаcast an Integer to a String. String не экстендит Integer
    //6: obj = null;
    //7: System.out.println(obj.equals(null));
    //8: }

    //A. ArrayIndexOutOfBoundsException
    //B. IllegalArgumentException
    //C. ClassCastException     // Correct
    //D. NumberFormatException
    //E. NullPointerException
    //F. None of the above
}

class Q6 {
    // What does the following method print?
    // 11: public void tryAgain(String s) {
    // 12: try(FileReader r = null, p = new FileReader("")) {       // Ошибка компиляции,  ;
    // 13: System.out.print("X");
    // 14: throw new IllegalArgumentException();
    // 15: } catch (Exception s) {      // переменная s уже определена - ошибка компиляции
    // 16: System.out.print("A");
    // 17: throw new FileNotFoundException();   // это checked exception и должно быть обработано или проброшено
    // 18: } finally {
    // 19: System.out.print("O");
    // 20: }
    // 21: }

    // A. XAO
    //B. XOA
    //C. One line of this method contains a compiler error.
    //D. Two lines of this method contain compiler errors.
    //E. Three lines of this method contain compiler errors.  // Correct
    //F. The code compiles, but a NullPointerException is thrown at
    //runtime.
    //G. None of the above
}

class Q7 {
    // What will happen if you add the following statement to a working main() method?
    //System.out.print(4 / 0);

    //A. It will not compile.
    //B. It will not run.
    //C. It will run and throw an ArithmeticException.          // Correct
    //D. It will run and throw an IllegalArgumentException.
    //E. None of the above
}


class Q8 {
    // What is printed by the following program?
    //1: public class DoSomething {
    //2: public void go() {
    //3: System.out.print("A");
    //4: try {
    //5: stop();
    //6: } catch (ArithmeticException e) {  // не отрабатывает, т.к. ошибка NullPointerException
    //7: System.out.print("B");
    //8: } finally {
    //9: System.out.print("C");     // и после этого выбрасывается NullPointerException
    //10: }
    //11: System.out.print("D");
    //12: }
    // 13: public void stop() {
    //14: System.out.print("E");
    //15: Object x = null;
    //16: x.toString();                 // NullPointerException
    //17: System.out.print("F");
    //18: }
    //19: public static void main(String n[]) {
    //20: new DoSomething().go();
    //21: }
    //22: }

    //A. AE
    //B. AEBCD
    //C. AEC
    //D. AECD
    //E. AE followed by a stack trace
    //F. AEBCD followed by a stack trace
    //G. AEC followed by a stack trace          // Correct
    //H. A stack trace with no other output
}

class Q9 {
    // What is the output of the following snippet, assuming a and b are both 0?
    // 3: try {
    // 4: System.out.print(a / b);
    // 5: } catch (RuntimeException e) {
    // 6: System.out.print(-1);
    // 7: } catch (ArithmeticException e) {     // unreachable code
    // 8: System.out.print(0);
    // 9: } finally {
    // 10: System.out.print("done");
    // 11: }

    // A. -1
    // B. 0
    // C. done-1
    // D. done0
    // E. The code does not compile.    // Correct
    // F. An uncaught exception is thrown.
    // G. None of the above
}

class Q10 {
    // What is the output of the following program?
    //1: public class Laptop {
    //2: public void start() {
    // 3: try {
    //4: System.out.print("Starting up_");
    //5: throw new Exception();
    //6: } catch (Exception e) {
    //7: System.out.print("Problem_");
    //8: System.exit(0);
    //9: } finally {
    //10: System.out.print("Shutting down");
    //11: }
    //12: }
    //13: public static void main(String[] w) {
    //14: new Laptop().start();
    //15: } }

    //A. Starting up_
    //B. Starting up_Problem_                   // Correct
    //C. Starting up_Problem_Shutting down
    //D. Starting up_Shutting down
    //E. The code does not compile.
    //F. An uncaught exception is thrown.
}


class Q11 {
    // What is the output of the following program?
    // 1: public class Dog {
    // 2: public String name;
    // 3: public void runAway() {
    // 4: System.out.print("1");
    // 5: try {
    // 6: System.out.print("2");
    // 7: int x = Integer.parseInt(name);
    // 8: System.out.print("3");
    // 9: } catch (NumberFormatException e) {
    // 10: System.out.print("4");
    // 11: }
    // 12: }
    // 13: public static void main(String... args) {
    // 14: Dog webby = new Dog();
    // 15: webby.name = "Webby";
    // 16: webby.runAway();
    // 17: System.out.print("5");           // т.к. мы нормально обработали эксепшн, то это напечатается
    // 18: } }

    // A. 1234
    // B. 1235
    // C. 124
    // D. 1245                  // Correct
    //E. The code does not compile.
    //F. An uncaught exception is thrown.
    //G. None of the above
}

class Q12 {
    // What is the output of the following program?
    //1: public class Cat {
    //2: public String name;
    //3: public void knockStuffOver() {
    //4: System.out.print("1");
    //5: try {
    //6: System.out.print("2");
    // 7: int x = Integer.parseInt(name);
    //8: System.out.print("3");
    //9: } catch (NullPointerException e) {
    //10: System.out.print("4");
    //11: }
    //12: System.out.print("5");
    //13: }
    //14: public static void main(String args[]) {
    //15: Cat loki = new Cat();
    //16: loki.name = "Loki";
    //17: loki.knockStuffOver();
    //18: System.out.print("6");
    //19: } }

    // A. The output is 12, followed by a stack trace for a NumberFormatException.      // Correct
    //B. The output is 124, followed by a stack trace for a NumberFormatException.
    //C. The output is 12456.
    //D. The output is 1256, followed by a stack trace for a NumberFormatException.
    //E. The code does not compile.
    //F. An uncaught exception is thrown.
    //G. None of the above

}

class Q13 {
    // Which of the following statements are true? (Choose all that apply.)
    //A. You can declare a method with Exception as the return type.    // Correct - указать можно, но вернется просто объект, а не выбросится исключение
    //B. You can declare a method with RuntimeException as the return type. // Correct - указать можно, но вернется просто объект, а не выбросится исключение
    //C. You can declare any subclass of Error in the throws part of a method declaration.          // Correct
    //D. You can declare any subclass of Exception in the throws part of a method declaration.      // Correct
    //E. You can declare any subclass of Object in the throws part of a method declaration.
    //F. You can declare any subclass of RuntimeException in the throws part of a method declaration.   // Correct
}

class Q14 {
    // Which of the following can be inserted on line 8 to make this code compile? (Choose all that apply.)
    //7: public void whatHappensNext() throws IOException {     // Unchecked ex
    //8: // INSERT CODE HERE
    //9: }

    //A. System.out.println("it's ok");             // Correct
    //B. throw new Exception();                     // нельзя, его придется обрабатывать
    //C. throw new IllegalArgumentException();      // Correct - unchecked можно добавить
    //D. throw new java.io.IOException();           // Correct
    //E. throw new RuntimeException();              // Correct - unchecked можно добавить
    //F. None of the above
}

class Q15 {
    // What is printed by the following program? (Choose all that apply.)
    // 1: public class Help {
    // 2: public void callSuperhero() {
    // 3: try (String raspberry = new String("Olivia")) {       // String does not implement AutoCloseable - не скомпилируется
    // 4: System.out.print("Q");
    // 5: } catch (Error e) {
    // 6: System.out.print("X");
    // 7: } finally {
    // 8: System.out.print("M");
    // 9: }
    // 10: }
    // 11: public static void main(String[] args) {
    // 12: new Help().callSuperhero();
    // 13: System.out.print("S");
    // 14: } }

    // A. SQM
    // B. QXMS
    // C. QSM
    // D. QMS
    // E. A stack trace
    // F. The code does not compile because NumberFormatException is not declared or caught.
    // G. None of the above                 // Correct
}

class Q16 {
    // Which of the following do not need to be handled or declared? (Choose all that apply.)
    //A. ArrayIndexOutOfBoundsException     // Correct - unchecked
    //B. IllegalArgumentException           // Correct - unchecked
    //C. IOException                                                // Checked
    //D. Error                              // Correct - unchecked
    //E. NumberFormatException              // Correct - unchecked
    //F. Any exception that extends RuntimeException    // Correct - unchecked
    //G. Any exception that extends Exception
}

class Q17 {
    // Which lines can fill in the blank to make the following code compile? (Choose all that apply.)

    // void rollOut() throws ClassCastException {}
    //public void transform(String c) {
    //try {
    //rollOut();
    //} catch (IllegalArgumentException | __________________ )  // тут можно только те, которые на одной ветке
    //{
    //}
    //}

    // A. IOException a         - в блоке try нет кода для выбрасывания  IOException, поэтому IOException будет unreachable
    //B. Error b                // Correct unchecked exceptions, которые не наследуются от IllegalArgumentException
    //C. NullPointerException c // переменная c уже определена, но с другим названием можно было бы
    //D. RuntimeException d         // Это родитель, делает первую декларацию недоступной
    //E. NumberFormatException e    // Это наследник, делает вторую декларацию недоступной
    //F. ClassCastException f  // Correct unchecked exceptions, которые не наследуются от IllegalArgumentException
    //G. None of the above. The code contains a compiler error regardless of what is inserted into the blank.
}


class Q18 {
    //Which scenario is the best use of an exception?

    //A. An element is not found when searching a list.
    //B. An unexpected parameter is passed into a method    // Correct.
    //C. The computer caught fire.
    //D. You want to loop through a list.
    //E. You don’t know how to code a method.
}

class Q19 {
    // Which of the following can be inserted into Lion to make this code compile? (Choose all that apply.)
    // class HasSoreThroatException extends Exception {}
    // class TiredException extends RuntimeException {}
    // interface Roar {
    // void roar() throws HasSoreThroatException;
    // }
    // class Lion implements Roar {
    // // INSERT CODE HERE
    // }

    //A. public void roar() {}                          // Correct - меньше эксепшенов можно при overriding
    //B. public int roar() throws RuntimeException {}   // Ошибка, возвращает int, но добавлять новые unchecked можно
    //C. public void roar() throws Exception {}         // Это исключение проверяемое и ШИРЕ!
    //D. public void roar() throws HasSoreThroatException {}    // Correct - как в интерфейсе
    //E. public void roar() throws IllegalArgumentException {}  // Correct  - можно выбрасывать новые uncecked
    //F. public void roar() throws TiredException {}            // Correct  - можно выбрасывать новые uncecked
}


class HasSoreThroatException extends Exception {}
class TiredException extends RuntimeException {}
interface Roar {
void roar() throws HasSoreThroatException;
}
class Lion implements Roar {
    public void roar() {}
 }


 class Q20 {
    // Which of the following are true? (Choose all that apply.)
     //A. Checked exceptions are allowed, but not required, to be handled or declared. // checked обязательно нужно обрабатывать
     //B. Checked exceptions are required to be handled or declared.        // Correct
     //C. Errors are allowed, but not required, to be handled or declared.  // Correct - можно обработать Error - но бесполезно
     //D. Errors are required to be handled or declared.                    // это unchecked
     //E. Unchecked exceptions are allowed, but not required, to be handled or declared.    // Correct
     //F. Unchecked exceptions are required to be handled or declared.          // Uncheced не требуется обрабатывать
 }

 class Q21 {
    // Which of the following pairs fill in the blanks to make this code compile? (Choose all that apply.)
     //6: public void ohNo(IOException ie) ______ Exception {
     //7: ________________ FileNotFoundException();
     //8: ________________ ie;   // эта строка будет всегда недоступна
     //9: }
     //A. On line 6, fill in throw
     //B. On line 6, fill in throws
     //C. On line 7, fill in throw
     //D. On line 7, fill in throw new
     //E. On line 8, fill in throw
     //F. On line 8, fill in throw new
     //G. None of the above             // Correct
 }

 class Q22 {
    // Which of the following can be inserted in the blank to make the code compile? (Choose all that apply.)

     // With multiple catch blocks, the exceptions must be ordered from more
     //specific to broader, or be in an unrelated inheritance tree.

     //public void dontFail() {
     //try {
     //System.out.println("work real hard");
     //} catch (_____________ e) {
     //} catch (RuntimeException e) {}
     //}
     //A. var
     //B. Exception     - нельзя - родитель
     //C. IOException   // Компилятор видит, что в блоке try нет кода, который требует IOException и будет ругаться
     //D. IllegalArgumentException  // Correct - наследник
     //E. RuntimeException
     //F. StackOverflowError    // Correct это Error - можно, другая ветка
     //G. None of the above
 }


 class Q23 {
    // What does the output of the following method contain? (Choose all that apply.)
     // 12: public static void main(String[] args) {
     // 13: System.out.print("a");
     // 14: try {
     // 15: System.out.print("b");
     // 16: throw new IllegalArgumentException();
     // 17: } catch (IllegalArgumentException e) {
     // 18: System.out.print("c");
     // 19: throw new RuntimeException("1");
     // 20: } catch (RuntimeException e) {
     // 21: System.out.print("d");
     // 22: throw new RuntimeException("2");
     // 23: } finally {                         // не забывай, что finally всегда отрабатывает
     // 24: System.out.print("e");
     // 25: throw new RuntimeException("3");
     // 26: }
     // 27: }

     //A. abce                                          // Correct
     //B. abde
     //C. An exception with the message set to "1"
     //D. An exception with the message set to "2"
     //E. An exception with the message set to "3"     // Correct
     //F. Nothing; the code does not compile.
 }

 class Q24 {
    // What does the following class output?
     //1: public class MoreHelp {
     //2: class Sidekick implements AutoCloseable {
     //3: protected String n;
     //4: public Sidekick(String n) { this.n = n; }
     //5: public void close() { System.out.print("L"); }
     //6: }
     //7: public void requiresAssistance() {
     //8: try (Sidekick is = new Sidekick("Adeline")) {
     //9: System.out.print("O");
     //10: } finally {
     //11: System.out.print("K");
     //12: }
     //13: }
     //14: public static void main(String... league) {
     //15: new MoreHelp().requiresAssistance();
     //16: System.out.print("I");
     //17: } }

     //A. LOKI
     //B. OKLI
     //C. OLKI      // Correct - в finally сначала закрываются ресурсы, потом отрабатывает код
     //D. OKIL
     //E. The output cannot be determined until runtime.
     //F. Nothing; the code does not compile.
     //G. None of the above
 }

 class Q25 {
    //  What does the following code snippet return, assuming a and b are both 1?
     //13: try {
     //14: return a / b;            // Этот return не будет отработан, отработает блок finally
     //15: } catch (ClassCastException e) {
     //16: return 10;
     // 17: } catch (RuntimeException e) {
     //18: return 20;
     //19: } finally {
     //20: return 30;
     //21: }

     //A. 1
     //B. 10
     //C. 20
     //D. 30    // Correct
     //E. The code does not compile.
     //F. An uncaught exception is thrown.
     //G. None of the above
 }