package Chapter11;

public class Modules {
}

/**
Чтобы скомпилировать файлы модуля, нужно использовать:

 javac --module-path mods -d feeding feeding/zoo/animal/feeding/*.java feeding/module-info.java


--module-path - (кратко: -p) - показывает на директорию с кастомными модулями

-d директория куда положим скомпилированные .class

после указываются файлы, которые нужно скомпилировать (через пробел)



 Чтобы запустить модуль, нужно использовать: (пути через точку)
 java --module-path feeding --module feeding/zoo.animal.feeding.Task

 --module-path - (кратко: -p) - показывает на директорию с скомпилированными модулями
 + ВАЖНО, что тут лежит module-info и там прописано имя модуля

 --module - (кратко: -m) - путь до скомпилированного модуля

 до слеша - zoo.animal.feeding: имя модуля ( в нашем случае просто feeding )
 после слеша - zoo.animal.feeding.Task - пакет.исполняемый класс


 Чтобы запустить модуль из архива
 java -p mods -m feeding/zoo.animal.feeding.Task

 - указываем, что папка mods
 - указываем, что в mods берем feeding/zoo.animal.feeding.Task

 */

/*
// Packaging Our First Module

jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .

// mods/zoo.animal.feeding.jar - куда положим jar
-С  - откуда берем данные для упаковки


сохраняем все по пути feeding/
в архив в папку mods/zoo.animal.zoo.animal.feeding.jar

 */


// Updating Our Example for Multiple Modules
/*
The exports keyword is used to indicate that a module intends for
those packages to be used by Java code outside the module.

Пример:
module zoo.animal.feeding {
    exports zoo.animal.feeding;
}
 */



// Ключевые слова module-info
// exports - экспертируются только public переменные классы
//          - protected только в рамках пакета и подпакета

/*
module zoo.animal.talks {
    exports zoo.animal.talks.content to zoo.animal.staff; - доступ только для одного модуля
    exports zoo.animal.talks.media;
    exports zoo.animal.talks.schedule;
}
 */

// require transitive module2
// Если кто то зависит от этого модуля, то он зависит так же от модуля2
/*
There’s also a requires transitive moduleName, which means that any module that requires
this module will also depend on moduleName.
 */

/*  Ошибка компиляции, Java не даст одинавый модуль в requires
module bad.module {
    requires zoo.animal.talks;
    requires transitive zoo.animal.talks;
}

// Keep in mind that requires transitive is like requires plus some extra behavior.
 */


// provides
// The provides keyword specifies that a class provides an implementation of a service.
// provides zoo.staff.ZooApi with zoo.staff.ZooImpl

// uses
// The uses keyword specifies that a module is relying on a service. To code it, you supply the API you want to call:
// uses zoo.staff.ZooApi

// opens
// opens zoo.animal.talks.schedule; - рефлексия доступна любым модулям
// opens zoo.animal.talks.media to zoo.staff;   - рефлексия доступна только одному модулю




// The java Command (Describing a Module, Listing Available Modules, Showing Module Resolution)
/*

// Describing a Module - показывает структуру модуля

java -p mods -d zoo.animal.feeding
(аналогично: java -p mods --describe-module zoo.animal.feeding)
->
zoo.animal.feeding file:///Users/kataev-ss/Downloads/OCP/mods/zoo.animal.feeding.jar
exports zoo.animal.feeding
requires java.base mandated
contains zoo
contains zoo.animal

 */


/*  Listing Available Modules - показывает все доступные модули
 java --list-modules     : все доступные built-in  модули

java -p mods --list-modules : все доступные built-in  модули + кастомные из папки mods


 */




/* Showing Module Resolution - дебаг модулей

java --show-module-resolution -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task


//jdk.management.jfr requires jdk.jfr jrt:/jdk.jfr
//java.management.rmi requires java.management jrt:/java.management
//java.management.rmi requires java.naming jrt:/java.naming
//java.management.rmi requires java.rmi jrt:/java.rmi
//java.rmi requires java.logging jrt:/java.logging
//BOOOMMMM!!!

 */


/* The jar Command - описывает модуль

Both of these commands are equivalent:
jar -f mods/zoo.animal.feeding.jar -d
jar --file mods/zoo.animal.feeding.jar --describe-module


it outputs the following:

zoo.animal.feeding
jar:file:///absolutePath/mods/zoo.animal.feeding.jar /!moduleinfo.class
exports zoo.animal.feeding
requires java.base mandated


 */


/* The jdeps Command  - gives you information about dependencies within a module.
         jdeps -s mods/zoo.animal.feeding.jar
(аналог) jdeps -summary mods/zoo.animal.feeding.jar


output:
zoo.animal.feeding -> java.base


// long form
jdeps mods/zoo.animal.feeding.jar

output:
[file:///absolutePath/mods/zoo.animal.feeding.jar]
requires mandated java.base (@11.0.2)
zoo.animal.feeding -> java.base
zoo.animal.feeding -> java.io
java.base
zoo.animal.feeding -> java.lang
java.base



// возьмем модуль, который зависит от другого модуля и укажем --module-path
jdeps -s --module-path mods mods/zoo.animal.care.jar
jdeps -summary --module-path mods mods/zoo.animal.care.jar

output:
zoo.animal.care -> java.base
zoo.animal.care -> zoo.animal.feeding

полная форма
jdeps --module-path mods mods/zoo.animal.care.jar

output:
zoo.animal.care
[file:///absolutePath/mods/zoo.animal.care.jar]
requires mandated java.base (@11.0.2)
requires transitive zoo.animal.feeding
zoo.animal.care -> java.base
zoo.animal.care -> zoo.animal.feeding
zoo.animal.care.details -> java.lang
java.base
zoo.animal.care.details -> zoo.animal.feeding
zoo.animal.feeding
zoo.animal.care.medical -> java.lang
java.base


// As before, there are three sections. The first section is the filename and
// required dependencies. The second section is the summary showing
// the two module dependencies with an arrow. The last six lines show
// the package-level dependencies.


 */



/* The jmod Command
JMOD files are recommended only when you have native libraries or something that can’t go inside a JAR file.
The most important thing to remember is that jmod is only for working with the JMOD files.


create: Creates a JMOD file.
extract: Extracts all files from the JMOD. Works like unzipping.
describe :Prints the module details such as requires.
list: Lists all files in the JMOD file.
hash: Shows a long string that goes with the file
 */



// Reviewing Command-Line Options


// Compile nonmodular code:
/*
javac -cp classpath -d directory classesToCompile
javac --class-path classpath -d directory classesToCompile
javac -classpath classpath -d directory classesToCompile

-classpath setting for javac is for finding other libraries and classes while compiling your .java files.
-d указываем в какую директорию будет компиляция

Находимся в директории и вызываем
javac Example.java
 */


// Run nonmodular code
/*
java -cp classpath *package.className*
java -classpath classpath *package.className*
java --class-path classpath *package.className*

-classpath setting for javac is for finding other libraries and classes while compiling your .java files.
-d указываем в какую директорию будет компиляция

Находимся в директории и вызываем
javac Example.java
 */


// Compile a module
/*
javac -p *moduleFolderName* -d *directory* *classesToCompileIncludingModuleInfo*
javac --module-path *moduleFolderName* -d *directory* *classesToCompileIncludingModuleInfo*

--module-path - (кратко: -p) - показывает на директорию с кастомными модулями

-d директория куда положим скомпилированные .class

Находимся в директории и вызываем
javac --module-path mods -d feeding feeding/zoo/animal/feeding/*.java feeding/module-info.java
 */

// Run a module
/*
java -p *moduleFolderName* -m *moduleName/package.className*
java --module-path *moduleFolderName* --module *moduleName/package.className*

 --module-path - (кратко: -p) - показывает на директорию с скомпилированными модулями
 + ВАЖНО, что тут лежит module-info и там прописано имя модуля

 --module - (кратко: -m) - путь до скомпилированного модуля

 до слеша - zoo.animal.feeding: имя модуля ( в нашем случае просто feeding )
 после слеша - zoo.animal.feeding.Task - пакет.исполняемый класс
 */

// Describe a module
/*
java -p *moduleFolderName* -d *moduleName*
java --module-path *moduleFolderName* --describe-module *moduleName*
jar --file *jarName* --describe-module
jar -f *jarName* -d

Например так
jar -f mods/zoo.animal.feeding.jar -d
jar --file mods/zoo.animal.feeding.jar --describe-module


it outputs the following:

zoo.animal.feeding
jar:file:///absolutePath/mods/zoo.animal.feeding.jar /!moduleinfo.class
exports zoo.animal.feeding
requires java.base mandated

 */


// List available modules
/*
Выводит список модулей

java --module-path *moduleFolderName* --listmodules
java -p *moduleFolderName* --list-modules
java --list-modules


java --list-modules     : все доступные built-in  модули
java -p mods --list-modules : все доступные built-in  модули + кастомные из папки mods

it outputs the following:

jdk.security.jgss@16.0.1
jdk.unsupported@16.0.1
jdk.unsupported.desktop@16.0.1
jdk.xml.dom@16.0.1
jdk.zipfs@16.0.1

 */

// View dependencies
/* - gives you information about dependencies within a module.
         jdeps -s mods/zoo.animal.feeding.jar
(аналог) jdeps -summary mods/zoo.animal.feeding.jar


output:
zoo.animal.feeding -> java.base


// long form
jdeps mods/zoo.animal.feeding.jar

output:
[file:///absolutePath/mods/zoo.animal.feeding.jar]
requires mandated java.base (@11.0.2)
zoo.animal.feeding -> java.base
zoo.animal.feeding -> java.io
java.base
 */

//Show module resolution - дебаг модулей
/*
java --show-module-resolution -p *moduleFolderName* -d *moduleName*
java --show-module-resolution --module-path *moduleFolderName* --describe-module *moduleName*


java --show-module-resolution -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task


//jdk.management.jfr requires jdk.jfr jrt:/jdk.jfr
//java.management.rmi requires java.management jrt:/java.management
//java.management.rmi requires java.naming jrt:/java.naming
//java.management.rmi requires java.rmi jrt:/java.rmi
//java.rmi requires java.logging jrt:/java.logging
//BOOOMMMM!!!
 */

// Options you need to know for the exam: javac
/*
-cp <classpath>             Location of JARs in a nonmodular program
-classpath <classpath>
--class-path <classpath>

-d <dir>                    Directory to place generated class files

-p <path>                   Location of JARs in a modular program
--module-path <path>
 */

// Options you need to know for the exam: java
/*
-p <path>               Location of JARs in a modular program
--module-path <path>

-m <name>               Module name to run
--module <name>

-d                      Describes the details of a module
--describe-module

--list-modules Lists observable modules without running a program

--show-moduleresolution Shows modules when running program
 */

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
 */

// jdeps
/*
--module-path <path>    Location of JARs in a modular program

-s                      Summarizes output
-summary
 */






