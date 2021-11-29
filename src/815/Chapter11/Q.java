package Chapter11;

public class Q {
}

class Q1 {
    // Which of the following is an advantage of the Java Platform Module System?
    //A. A central repository of all modules
    //B. Encapsulating packages     // Correct
    //C. Encapsulating objects
    //D. No defined types
    //E. Platform independence
}

class Q2 {
    //Which statement is true of the following module?
    //   zoo.staff
    //   |---zoo
    //   |-- staff
    //   |-- Vet.java

    // A. The directory structure shown is a valid module.
    // B. The directory structure would be a valid module if module.java were added directly underneath zoo.staff.
    //C. The directory structure would be a valid module if module.java were added directly underneath zoo.
    //D. The directory structure would be a valid module if moduleinfo.java were added directly underneath zoo.staff.   // Correct
            // Modules are required to have a module-info.java file at the root directory of the module.
    //E. The directory structure would be a valid module if moduleinfo.java were added directly underneath zoo.
    //F. None of these changes would make this directory structure a valid module.
}

class Q3 {
    // Suppose module puppy depends on module dog and module dog depends on module animal. Fill in the blank so that code in
    //module dog can access the animal.behavior package in module animal.
    //module animal {
    //___________ animal.behavior;
    //}
    //A. export     // нет такого
    //B. exports        // Correct - The exports keyword is used when allowing a package to be called by code outside of the module,
    //C. require    // нет такого
    //D. requires       //  incorrect because requires uses module names and not package names.
    //E. require transitive // нет такого
    //F. requires transitive    //  incorrect because requires uses module names and not package names.
    //G. None of the above
}

class Q4 {
    // Fill in the blanks so this command to run the program is correct:

// -m or --module option is used to specify the module and class name.
// The -p or -module-path option is used to specify the location of the modules.

    // java
    // _______ zoo.animal.talks/zoo/animal/talks/Peacocks // тут должны быть точки
    // _______ modules

    // A. -d and -m
    // B. -d and -p
    // C. -m and -d
    // D. -m and -p
    // E. -p and -d
    // F. -p and -m
    // G. None of the above // Correct
}

class Q5 {
    // Which of the following statements are true in a module-info.java file? (Choose all that apply.)
    //A. The opens keyword allows the use of reflection.        // Correct
    //B. The opens keyword declares an API is called.
    //C. The use keyword allows the use of reflection.          // нет слова use
    //D. The use keyword declares an API is called.             // нет слова use
    //E. The uses keyword allows the use of reflection.
    //F. The uses keyword declares an API is called.                // Correct
    //G. The file can be empty (zero bytes).                        // Correct
}
/*

// provides
// The provides keyword specifies that a class provides an implementation of a service.
// provides zoo.staff.ZooApi with zoo.staff.ZooImpl

// uses
// The uses keyword specifies that a module is relying on a service. To code it, you supply the API you want to call:
// uses zoo.staff.ZooApi

// opens
// opens zoo.animal.talks.schedule; - рефлексия доступна любым модулям
// opens zoo.animal.talks.media to zoo.staff;   - рефлексия доступна только одному модулю
 */


class Q6 {
    // What is true of a module containing a file named module-info.java with the following contents? (Choose all that apply.)

    // module com.food.supplier {}

    //A. All packages inside the module are automatically exported.  // нет, все закрыто
    //B. No packages inside the module are automatically exported.  // Correct
    //C. A main method inside the module can be run.                // Correct
    //D. A main method inside the module cannot be run since the
        //class is not exposed.
    //E. The module-info.java file contains a compiler error.       // нет
    //F. The module-info.java filename is incorrect.                // нет
}

class Q7 {
    // Suppose module puppy depends on module dog and module dog depends on module animal. Which two lines allow module puppy
    //to access the animal.behavior package in module animal? (Choose two.)
    //module animal {
    //exports animal.behavior to dog;
    //}
    //module dog {
    //______ animal; // line S  requires transitive (кто зависит от dog, так же зависит от animal )
                        // это позволит  module puppy to access the animal.behavior
    //}
    //module puppy {
    //______ dog; // line T     requires
    //}


    /*
require transitive module2
Если кто то зависит от этого модуля, то он зависит так же от модуля2
     */

    // A. require on line S     // нет такого
    //B. require on line T      // нет такого
    //C. requires on line S
    //D. requires on line T     // Correct
    //E. require transitive on line S       // нет такого
    //F. require transitive on line T       // нет такого
    //G. requires transitive on line S      // Correct
    //H. requires transitive on line T
}

class Q8 {
    // Which commands take a --module-path parameter? (Choose all that apply.)
    //A. javac      // Correct  javac --module-path *moduleFolderName* -d *directory* *classesToCompileIncludingModuleInfo*
    //B. java       // Correct  java --module-path *moduleFolderName* --module *moduleName/package.className*
    //C. jar
    //D. jdeps      // Correct jdeps -summary --module-path mods mods/zoo.animal.care.jar
    //E. jmod
    //F. None of the above
}

class Q9 {
    // Which of the following are legal commands to run a modular program? (Choose all that apply.)

    //A. java -p x -m x/x       // Correct
    //B. java -p x-x -m x/x     // Correct   -p это просто путь, поэтому x-x  можно
    //C. java -p x -m x-x/x     // -m тут только через "." , разделение через "/"
    //D. java -p x -m x/x-x     // -m тут только через "." , разделение через "/"
    //E. java -p x -m x.x       // -m тут только через "." , разделение через "/"
    //F. java -p x.x -m x.x     // -m тут только через "." , разделение через "/"
    //G. None of the above
}

class Q10{
    // Which would best fill in the blank to complete the following code?
    // module ________ {
    //exports com.unicorn.horn;
    //exports com.unicorn.magic;
    //}

    //A. com                    // Можно, но не хорошая практика
    //B. com.unicorn            // Correct
    //C. com.unicorn.horn
    //D. com.unicorn.magic
    //E. The code does not compile.
    //F. The code compiles, but none of these would be a good choice.
}

class Q11 {
    // Which are valid modes for the jmod command? (Choose all that
    //apply.)
    //A. add
    //B. create     // Correct  Creates a JMOD file.
    //C. delete
    //D. describe   // Correct  Prints the module details such as requires.
    //E. extract    // Correct  Extracts all files from the JMOD. Works like unzipping.
    //F. list       // Correct  Lists all files in the JMOD file.
    //G. show

    // + hash: Shows a long string that goes with the file
}

class Q12 {
    // Suppose you have the commands javac, java, and jar. How many
    //of them support a --show-module-resolution option?
    //A. 0
    //B. 1      // Correct java --show-module-resolution
    //C. 2
    //D. 3

}

class Q13 {
    // Which are true statements about the following module? (Choose all that apply.)
    //class dragon {            // тут слово class, а должно быть module
    //exports com.dragon.fire;
    //exports com.dragon.scales to castle;
    //}

    //A. All modules can reference the com.dragon.fire package.
    //B. All modules can reference the com.dragon.scales package.
    //C. Only the castle module can reference the com.dragon.fire
    //package.
    //D. Only the castle module can reference the com.dragon.scales
    //package.
    //E. None of the above      // Correct - не скомпилируется. Если был бы module, то A,D
}

class Q14 {
    // Which would you expect to see when describing any module?

    //A. requires java.base mandated    // Correct The line ends with mandated
    //B. requires java.core mandated
    //C. requires java.lang mandated
    //D. requires mandated java.base
    //E. requires mandated java.core
    //F. requires mandated java.lang
    //G. None of the above
}

class Q15 {
    // Which of the following statements are correct? (Choose all that apply.)

    //A. The jar command allows adding exports as command-line options.
    //B. The java command allows adding exports as command-line options.        // Correct
    /*java command has an --add-exports option that allows
    exporting a package at runtime.*/
    //C. The jdeps command allows adding exports as command-line options.
    //D. Adding an export at the command line is discouraged.               // Correct
    /* it is not encouraged to use it */
    //E. Adding an export at the command line is recommended.
}

class Q16 {
    // Which are valid calls to list a summary of the dependencies? (Choose all that apply.)
    //A. jdeps flea.jar
    //B. jdeps -s flea.jar          // Correct
    //C. jdeps -summary flea.jar    // Correct
    //D. jdeps --summary flea.jar
    //E. None of the above
}

class Q17 {
    // Which is the first line to contain a compiler error?
    // 1: module snake {
    // 2: exports com.snake.tail;
    // 3: exports com.snake.fangs to bird;
    // 4: requires skin;
    // 5: requires transitive skin; // Дважды
    // 6: }

    //A. Line 1.
    //B. Line 2.
    //C. Line 3.
    //D. Line 4.
    //E. Line 5.            // Correct
    //F. The code does not contain any compiler errors.
}

class Q18 {
    // Which of the following would be a legal module name? (Choose all that apply.)
    //A. com.book   // Correct
    //B. com-book           // "-" нельзя
    //C. com.book$  // Correct
    //D. com-book$      // "-" нельзя
    //E. 4com.book      // нельзя начинать с цифры
    //F. 4com-book      // нельзя начинать с цифры
}

class Q19 {
    // What can be created using the Java Platform Module System that could not be created without it? (Choose all that apply.)

    //A. JAR file                                   // - JAR files have always been available regardless of the JPMS
    //B. JMOD file                                  // Correct
    //C. Smaller runtime images for distribution    // Correct
    //D. Operating system specific bytecode         // - bytecode runs on the JVM and is not operating system specific by definition
    //E. TAR file                                   // jar - команда, не файл
    //F. None of the above
}

class Q20 {
    // Which of the following options does not have a one-character shortcut in any of the commands studied in this chapter? (Choose all that apply.)

    //A. describe-module     // -d
    //B. list-modules        // Correct
    //C. module             // -m
    //D. module-path        // -p
    //E. show-module-resolution // Correct
    //F. summary                // -s
}

class Q21 {
    // Which of the following are legal commands to run a modular program where n is the package name and c is the class name? (Choose all that apply.)
    //A. java –module-path x -m n.c         // не хватает "-"
    //B. java --module-path x -p n.c        // -p это краткая форма --module-path
    //C. java --module-path x -m n/c        // Correct
    //D. java --module-path x -p n/c        // -p это краткая форма --module-path
    //E. java --module-path x -m n c        // отсутствует "/" module name and class name are separated with a slash,
    //F. java --module-path x -p n c        // -p это краткая форма --module-path
}





