package Chapter1;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q {
}
/*
Review Questions
1. Which of the following are true statements? (Choose all that apply.)
    A. Java allows operator overloading.                                // нельзя перегружать переменные
    B. Java code compiled on Windows can run on Linux.       (Correct)  // скомпилированный на винде код можно запустить на линунсе
    C. Java has pointers to specific locations in memory.               // ссылки в джава - это ссылка на адрес памяти, но не на точный адрес памяти
    D. Java is a procedural language.
    E. Java is an object-oriented language.                  (Correct)       // джава объектно ориетированный язык
    F. Java is a functional programming language.

2. Which of the following are true? (Choose all that apply.) // Java puts source code in .java files and bytecode in .class files
    A. javac compiles a .class file into a .java file.
    B. javac compiles a .java file into a .bytecode file.
    C. javac compiles a .java file into a .class file.          (Correct)
    D. java accepts the name of the class as a parameter.       (Correct) // When running a Java program, you pass just
                                    // the name of the class without the .class extension.
    E. java accepts the filename of the .bytecode file as a parameter.
    F. java accepts the filename of the .class file as a parameter.

3. Which of the following are true if this command completes successfully? (Choose all that apply.) java MyProgram.java

// using the single-file source-code launcher. It compiles in memory rather than creating a .class file
// To use this launcher, programs can only reference classes built into the JDK

    A. A .class file is created.   // файл .class создается через javac
    B. MyProgram can reference classes in the package com.sybex.book. // пакет недоступен
    C. MyProgram can reference classes in the package java.lang.        (Correct)  // этот пакет доступен по умолчанию
    D. MyProgram can reference classes in the package java.util.        (Correct)  // этот пакет доступен по умолчанию
    E. None of the above. The program needs to be run as java MyProgram.

4. Given the following classes, which of the following can independently replace INSERT IMPORTS HERE to make the code compile? (Choose all that apply.)
    package aquarium;
    public class Tank { }
    package aquarium.jellies;
    public class Jelly { }
    package visitor;
    INSERT IMPORTS HERE
    public class AquariumVisitor {
    public void admire(Jelly jelly) { } }
    A. import aquarium.*;
    B. import aquarium.*.Jelly;
    C. import aquarium.jellies.Jelly;               (Correct)   // импортируем класс, который используется в методе
    D. import aquarium.jellies.*;                   (Correct)   // импортируем класс, который используется в методе
    E. import aquarium.jellies.Jelly.*;
    F. None of these can make the code compile.

5. Which are included in the JDK? (Choose all that apply.)
    A. javac            (Correct)
    B. Eclipse
    C. JVM              (Correct)
    D. javadoc          (Correct)
    E. jar              (Correct)
    F. None of the above

6. Given the following classes, what is the maximum number of imports that can be removed and have the code still compile?
// Можно удалить все импорты, т.к. оба класса в одном пакете
package aquarium;
public class Water { }
package aquarium;
import java.lang.*;         // 1
import java.lang.System;    // 2
import aquarium.Water;      // 3
import aquarium.*;          // 4
public class Tank {
public void print(Water water) {
System.out.println(water); } }
A. 0
B. 1
C. 2
D. 3
E. 4               (Correct)
F. Does not compile

7. Given the following classes, which of the following snippets can
independently be inserted in place of INSERT IMPORTS HERE and
have the code compile? (Choose all that apply.)
package aquarium;
public class Water {
boolean salty = false;
}
package aquarium.jellies;
public class Water {
boolean salty = true;
}
package employee;
INSERT IMPORTS HERE
public class WaterFiller {
Water water;
}
A. import aquarium.*;               (Correct)
B.  import aquarium.Water;          (Correct)   // Явное указание и через звездочку - ок
    import aquarium.jellies.*;
C.  import aquarium.*;              (Correct)   // Явное указание и через звездочку - ок
    import aquarium.jellies.Water;
D.  import aquarium.*;                          // Обе звездочки - непонятно какой Water использовать
    import aquarium.jellies.*;
E.  import aquarium.Water;                      // Оба Water - непонятно какой Water использовать
    import aquarium.jellies.Water;
A. None of these imports can make the code compile.

8. Given the following command, which of the following classes would be included for compilation? (Choose all that apply.) javac *.java
A. Hyena.java           (Correct)
B. Warthog.java         (Correct)
C. land/Hyena.java      // так нельзя
D. land/Warthog.java    // так нельзя
E. Hyena.groovy         // нужно .java
F. Warthog.groovy       // нужно .java

9. Given the following class, which of the following calls print out Blue Jay? (Choose all that apply.)
public class BirdDisplay {
public static void main(String[] name) {
System.out.println(name[1]);
} }
A. java BirdDisplay Sparrow Blue Jay
B. java BirdDisplay Sparrow "Blue Jay"  (Correct) // Пишем java Имя класса и переменные для args
C. java BirdDisplay Blue Jay Sparrow
D. java BirdDisplay "Blue Jay" Sparrow
E. java BirdDisplay.class Sparrow "Blue Jay"  // .class не надо писать
F. java BirdDisplay.class "Blue Jay" Sparrow

10. Which of the following are legal entry point methods that can be run from the command line? (Choose all that apply.)
A. private static void main(String[] args)
B. public static final main(String[] args)
C. public void main(String[] args)
D. public static void test(String[] args)
E. public static void main(String[] args)   (Correct) - только так можно печатать
F. public static main(String[] args)

11. Which of the following are true statements about Java? (Choose all that apply.)
A. Bug-free code is guaranteed.             // не гарантирует
B. Deprecated features are never removed.   // убирают фичи
C. Multithreaded code is allowed.           (Correct)
D. Security is a design goal.               (Correct)
E. Sideways compatibility is a design goal. // нет такой

12. Which options are valid on the javac command without considering module options? (Choose all that apply.)
A. -c
B. -C
C. -cp  (Correct) - specify classpath for javac
D. -CP
E. -d   (Correct)   -specify directory for javac
F. -f
G. -p


13. Which options are valid on the java command without considering module options? (Choose all that apply.)
A. -c           -c          Jar. Create a new JAR file
B. -C           -C          откуда берем данные для упаковки JAR
C. -cp    (Correct) - specify classpath
D. -d       // use for modules,  описывает модуль  jar --file mods/zoo.animal.feeding.jar --describe-module
E. -f       // use for modules, описывает модуль jar -f mods/zoo.animal.feeding.jar -d
F. -p       // use for modules, компиляция и запуск модуля javac -p *moduleFolderName*

14. Which options are valid on the jar command without considering module options? (Choose all that apply.)

***
// Options you need to know for the exam: jar
/*
-c          Create a new JAR file
--create

-v          Prints details when working with JAR files
--verbose

-f          JAR filename
--file

-C                  Directory containing files to be used to create the JAR

-d                 Describes the details of a module
--describemodule
***


A. -cf  (Correct)
B. -c   (Correct)
C. -cp  // используется только в java и javac
D. -d       // модуль
E. -cvf (Correct)
F. -p       // модуль


15. What does the following code output when run as java Duck Duck Goose?
public class Duck {
public void main(String[] args) {           // WRONG!!!
for (int i = 1; i <= args.length; i++)
System.out.println(args[i]);
} }
A. Duck Goose
B. Duck ArrayIndexOutOfBoundsException
C. Goose
D. Goose ArrayIndexOutOfBoundsException
E. None of the above                    (Correct) main is not static

16. Suppose we have the following class in the file
/my/directory/named/A/Bird.java. Which of the answer options
replaces INSERT CODE HERE when added independently if we
compile from /my/directory? (Choose all that apply.)
INSERT CODE HERE
public class Bird { }
A. package my.directory.named.a;
B. package my.directory.named.A;
C. package named.a;
D. package named.A;     (Correct)  - только с этого уровня можно
E. package a;
F. package A;

17. Which of the following are true? (Choose all that apply.)
public class Bunny {
public static void main(String[] x) {
Bunny bun = new Bunny();
} }
A. Bunny is a class.                    (Correct)
B. bun is a class.
C. main is a class.
D. Bunny is a reference to an object.
E. bun is a reference to an object.     (Correct)
F. main is a reference to an object.
G. The main() method doesn’t run because the parameter name is incorrect.


18. Which answer options represent the order in which the following statements can be
assembled into a program that will compile successfully? (Choose all that apply.)

X: class Rabbit {}
Y: import java.util.*;
Z: package animals;

A. X, Y, Z
B. Y, Z, X
C. Z, Y, X  (Correct)
D. Y, X     (Correct)
E. Z, X     (Correct)
F. X, Z

19. Which are not available for download from Oracle for Java 11?
(Choose all that apply.)
A. JDK
B. JRE                                          (Correct) // no longer a download option for Java 11.
C. Eclipse                                      (Correct)
D. All of these are available from Oracle.

20. Which are valid ways to specify the classpath when compiling? (Choose all that apply.)
A. -cp              (Correct)
B. -classpath       (Correct)
C. --classpath
D. -class-path
E. --class-path     (Correct)

 */

