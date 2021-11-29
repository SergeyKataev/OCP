package Chapter4;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q {
}

class Q1 {
    // 1. Which of the following data types can be used in a switch statement? (Choose all that apply.)
    // Можно все примитивы до int и обертки над ними + String + var(если он соотвествует ожиданиям свича).
    // Главное, чтобы в самом энаме все значения были указаны до компиляции. т.е. все поля final и без переменных, которые приходят в методе.
    //        A. enum       (Correct)
    //        B. int        (Correct)
    //        C. Byte       (Correct)
    //        D. long
    //        E. String     (Correct)
    //        F. char       (Correct)
    //        G. var        (Correct)
    //        H. double
}

class Q2 {
    // 2. What is the output of the following code snippet? (Choose all that apply.)
    //        int temperature = 4;                                  // 4
    //        long humidity = -temperature + temperature * 3;       // -4 + 12
    //        if (temperature>=4)
    //        if (humidity < 6) System.out.println("Too Low");
    //        else System.out.println("Just Right");
    //        else System.out.println("Too High");
    //
    //        A. Too Low
    //        B. Just Right                                     // Correct
    //        C. Too High
    //        D. A NullPointerException is thrown at runtime.
    //        E. The code will not compile because of line 7.
    //        F. The code will not compile because of line 8.

    public static void main(String[] args) {
        int t = 4;
        long h = t-- + t*3;
        System.out.println(h);
    }
}


class Q3 {
    // 3. What is the output of the following code snippet?

//    public static void main(String[] args) {
//                List<Integer> myFavoriteNumbers = new ArrayList<>();
//                myFavoriteNumbers.add(10);
//                myFavoriteNumbers.add(14);
//                for (var a : myFavoriteNumbers) {
//                System.out.print(a + ", ");
//                break;
//                }                                     // 10,
//                for (int b : myFavoriteNumbers) {
//                continue;
//                System.out.print(b + ", ");          // недоступный код
//                }
//                for (Object c : myFavoriteNumbers)
//                System.out.print(c + ", ");           // 10, 10, 14,
//    }


    //        A. It compiles and runs without issue but does not produce any
    //        output.
    //        B. 10, 14,
    //        C. 10, 10, 14,
    //        D. 10, 10, 14, 10, 14,
    //        E. Exactly one line of code does not compile.             // Correct
    //        F. Exactly two lines of code do not compile.
    //        G. Three or more lines of code do not compile.
    //        H. The code contains an infinite loop and does not terminate.
}

class Q4{
    // 4. Which statements about decision structures are true? (Choose all that apply.)
    //        A. A for-each loop can be executed on any Collections Framework object.       // кроме Мар
    //        B. The body of a while loop is guaranteed to be executed at least once.       // do{} while гарантированно один раз отрабатывает
    //        C. The conditional expression of a for loop is evaluated before the first execution of the loop body.     Correct
    //        D. A switch statement with no matching case statement requires a default statement. // default не обязательный
    //        E. The body of a do/while loop is guaranteed to be executed at least once.                                Correct
    //        F. An if statement can have multiple corresponding else statements. // у if только один else

    // Пояснения к С:
// The conditional expression of for loops is evaluated at the start of the loop
// execution, meaning the for loop may execute zero or more times,
// making option C correct.
}


class Q5{
    // 5. Assuming weather is a well-formed nonempty array, which code snippet, when inserted independently into the blank in the
    //        following code, prints all of the elements of weather? (Choose all that apply.)
    //        private void print(int[] weather) {
    //        for(____________) {
    //        System.out.println(weather[i]);
    //        }
    //        }
    //        A. int i=weather.length; i>0; i--                 weather[weather.length]
    //        B. int i=0; i<=weather.length-1; ++i              Correct ++i и i++ все равно отработают после первого прохода по кода
    //        C. var w : weather                                i не определена для печати
    //        D. int i=weather.length-1; i>=0; i--              Correct
    //        E. int i=0, int j=3; i<weather.length; ++i        нельзя дважды объявить переменную через int int. Так мжно int i=0, j=3;
    //        F. int i=0; ++i<10 && i<weather.length;           первый элемент будет пропущен, т.к. ++i у ословии отработает
    //        G. None of the above


                private static void print(int[] weather) {
                    for (int i=0; ++i<10 && i<weather.length; ) {
                        System.out.println(weather[i]);
                    }
                }

    public static void main(String[] args) {
        print(new int[]{1,2,3,4,5});
    }
}

class Q6{
//     6. Which statements, when inserted independently into the following blank, will cause the code to print 2 at runtime? (Choose all that apply.)
//            int count = 0;
//            BUNNY: for(int row = 1; row <=3; row++)            row1
//            RABBIT: for(int col = 0; col <3 ; col++) {         col0
//            if((col + row) % 2 == 0)
//
//            ;
//            count++;
//            }
//            System.out.println(count);
    //        A. break BUNNY
    //        B. break RABBIT               Correct
    //        C. continue BUNNY             Correct
    //        D. continue RABBIT
    //        E. break                      Correct
    //        F. continue
    //        G. None of the above, as the code contains a compiler error


    public static void main(String[] args) {
        if (true);
    }
}

class Q7 {
    // 7. Given the following method, how many lines contain compilation errors? (Choose all that apply.)
      private DayOfWeek getWeekDay(int day, final int
            thursday) {
            int otherDay = day;
            int Sunday = 0;
            switch(otherDay) {
      default:                                                          // пустой дефолт вначе можно
//            case 1: continue;                                         // ERROR  - в свиче нельзя континуе
//            case thursday: return DayOfWeek.THURSDAY;                 // ERROR не заасайниная переменная в свиче
            case 2: break;
//            case Sunday: return DayOfWeek.SUNDAY;                     // ERROR - не финальная переменная в свиче
//            case DayOfWeek.MONDAY: return DayOfWeek.MONDAY;           // ERROR  - нельзя день, когда ожидается инт
            }
            return DayOfWeek.FRIDAY;
            }
    //        A. None, the code compiles without issue.
    //        B. 1
    //        C. 2
    //        D. 3
    //        E. 4                                                  Correct
    //        F. 5
    //        G. 6
    //        H. The code compiles but may produce an error at runtime.
}

class Q8 {
    //         8. What is the result of the following code snippet?
    //        int sing = 8, squawk = 2, notes = 0;
    //        while(sing > squawk) {
    //        sing--;                          sing = 6
    //        squawk += 2;                      squawk = 6
    //        notes += sing + squawk;           notes = notes + 6 + 6 = 23
    //        }
    //        System.out.println(notes);

    //        A. 11
    //        B. 13
    //        C. 23                         Correct
    //        D. 33
    //        E. 50
    //        F. The code will not compile because of line 7.
}

class Q9 {
    // 9. What is the output of the following code snippet?

    //        boolean keepGoing = true;
    //        int result = 15, meters = 10;
    //        do {
    //        meters--;
    //        if(meters==8) keepGoing = false;
    //        result -= 2;
    //        } while keepGoing;                 // нужны скобки
    //        System.out.println(result);
    //        A. 7
    //        B. 9
    //        C. 10
    //        D. 11
    //        E. 15
    //        F. The code will not compile because of line 6.
    //        G. The code does not compile for a different reason.      Correct
}

class Q10{
    // 10. Which statements about the following code snippet are correct? (Choose all that apply.)
    //        for(var penguin : new int[2])
    //        System.out.println(penguin);      // 00
    //        var ostrich = new Character[3];
    //        for(var emu : ostrich)            // null null null
    //        System.out.println(emu);
    //        List parrots = new ArrayList();
    //        for(var macaw : parrots)
    //        System.out.println(macaw);
    //        A. The data type of penguin is Integer.
    //        B. The data type of penguin is int.               Correct
    //        C. The data type of emu is undefined.
    //        D. The data type of emu is Character.             Correct
    //        E. The data type of macaw is undefined.
    //        F. The data type of macaw is Object.              Correct     List по дефолту Object
    //        G. None of the above, as the code does not compile
}

class Q11{
    // 11. What is the result of the following code snippet?
    //  final char a = 'A', e = 'E';
    //        char grade = 'B';
    //        switch (grade) {
    //  default:
    //        case a:
    //        case 'B': 'C': System.out.print("great ");     // перед 'С' отсутствует case
    //        case 'D': System.out.print("good "); break;
    //        case e:
    //        case 'F': System.out.print("not good ");
    //        }
    //        A. great
    //        B. great good
    //        C. good
    //        D. not good
    //        E. The code does not compile because the data type of one or
    //        more case statements does not match the data type of the
    //        switch variable.
    //        F. None of the above                Correct
}

class Q12 {
    // 12. Given the following array, which code snippets print the elements in reverse order from how they are declared? (Choose all that apply.)
    //        char[] wolf = {'W', 'e', 'b', 'b', 'y'};
    //        A.                                    // Correct
    //        int q = wolf.length;
    //        for( ; ; ) {
    //        System.out.print(wolf[--q]);
    //        if(q==0) break;
    //        }
    //        B.                                    // Correct
    //        for(int m=wolf.length-1; m>=0; --m)
    //        System.out.print(wolf[m]);
    //        C.                                // wolf[wolf.length-z] = 5 - 0
    //        for(int z=0; z<wolf.length; z++)
    //        System.out.print(wolf[wolf.length-z]);
    //        D.                                // Correct
    //        int x = wolf.length-1;
    //        for(int j=0; x>=0 && j==0; x--)
    //        System.out.print(wolf[x]);
    //        E.                                // бесконечная петля
    //        final int r = wolf.length;
    //        for(int w = r-1; r>-1; w = r-1)   // тут всегда будет 4
    //        System.out.print(wolf[w]);
    //        F.                                // wolf[wolf.length-z]
    //        for(int i=wolf.length; i>0; --i)
    //        System.out.print(wolf[i]);
    //        G. None of the above
}

class Q13 {
    // 13. What distinct numbers are printed when the following method is executed? (Choose all that apply.)
    //  private void countAttendees() {
    //        int participants = 4, animals = 2, performers = -1;
    //        while((participants = participants+1) < 10) {}
    //        do {} while (animals++ <= 1);             participants = 10, animals = 3, performers = -1
    //        for( ; performers<2; performers+=2) {}    participants = 10, animals = 3, performers = 3
    //        System.out.println(participants);
    //        System.out.println(animals);
    //        System.out.println(performers);
    //        }
    //        A. 6
    //        B. 3                  Correct
    //        C. 4
    //        D. 5
    //        E. 10                  Correct
    //        F. 9
    //        G. The code does not compile.
    //        H. None of the above
}

class Q14 {
    // 14. What is the output of the following code snippet?
    //        2: double iguana = 0;
    //        3: do {
    //        4: int snake = 1;
    //        5: System.out.print(snake++ + " ");
    //        6: iguana--;
    //        7: } while (snake <= 5);                  // нет доступа к переменной snake
    //        8: System.out.println(iguana);
    //        A. 1 2 3 4 -4.0
    //        B. 1 2 3 4 -5.0
    //        C. 1 2 3 4 5 -4.0
    //        D. 0 1 2 3 4 5 -5.0
    //        E. The code does not compile.                 Correct
    //        F. The code compiles but produces an infinite loop at runtime.
    //        G. None of the above
}

class Q15{
    // 15. Which statements, when inserted into the following blanks, allow the code to compile and run without entering an infinite loop? (Choose all that apply.)
    //        4: int height = 1;
    //        5: L1: while(height++ <10) {
    //        6: long humidity = 12;
    //        7: L2: do {
    //        8: if(humidity-- % 12 == 0) ____________;
    //        9: int temperature = 30;
    //        10: L3: for( ; ; ) {
    //        11: temperature++;
    //        12: if(temperature>50) ____________;
    //        13: }
    //        14: } while (humidity > 4);
    //        15: }
    //        A. break L2 on line 8; continue L2 on line 12        Correct
    //        B. continue on line 8; continue on line 12        // на второй итерации попадем в бесконечную лупу
    //        C. break L3 on line 8; break L1 on line 12        // L3 не виден на строке 8
    //        D. continue L2 on line 8; continue L3 on line 12  //
    //        E. continue L2 on line 8; continue L2 on line 12      Correct
    //        F. None of the above, as the code contains a compiler error.
}

class Q16{
    // 16. What is the output of the following code snippet? (Choose all that apply.)
    //        2: var tailFeathers = 3;
    //        3: final var one = 1;
    //        4: switch (tailFeathers) {
    //        5: case one: System.out.print(3 + " ");
    //        6: default: case 3: System.out.print(5 + " ");
    //        7: }
    //        8: while (tailFeathers > 1) {
    //        9: System.out.print(--tailFeathers + " "); }
    //        A. 3
    //        B. 5 1
    //        C. 5 2
    //        D. 3 5 1
    //        E. 5 2 1                                              Correct
    //        F. The code will not compile because of lines 3–5.
    //        G. The code will not compile because of line 6.
}

class Q17 {
    //         17. What is the output of the following code snippet?
    //        int penguin = 50, turtle = 75;
    //        boolean older = penguin >= turtle;                    //false
    //        if (older = true) System.out.println("Success");      //order = true , sout(Success)
    //        else System.out.println("Failure");
    //        else if(penguin != 50) System.out.println("Other");   // лишнее else
    //        A. Success
    //        B. Failure
    //        C. Other
    //        D. The code will not compile because of line 17.
    //        E. The code compiles but throws an exception at runtime.
    //        F. None of the above                              // Correct
}


class Q18{
    // 18. Which of the following are possible data types for olivia that would allow the code to compile? (Choose all that apply.)
    //        for(var sophia : olivia) {
    //        System.out.println(sophia);
    //        }
    //        A. Set                Correct
    //        B. Map
    //        C. String
    //        D. int[]              Correct
    //        E. Collection          Correct Коллекцию можно
    //        F. StringBuilder
    //        G. None of the above
    public static void main(String[] args) {
        Collection olivia = new ArrayList<>();
        for(var sophia : olivia) {
                    System.out.println(sophia);
                    }
    }
}

class Q19{
    // 19. What is the output of the following code snippet?
    //        6: String instrument = "violin";
    //        7: final String CELLO = "cello";
    //        8: String viola = "viola";
    //        9: int p = -1;
    //        10: switch(instrument) {
    //        11: case "bass" : break;
    //        12: case CELLO : p++;
    //        13: default: p++;
    //        14: case "VIOLIN": p++;
    //        15: case "viola" : ++p; break;
    //        16: }
    //        17: System.out.print(p);
    //        A. -1
    //        B. 0
    //        C. 1
    //        D. 2                      // Correct
    //        E. 3
    //        F. The code does not compile.
}

class Q20 {
    //         20. What is the output of the following code snippet? (Choose all that apply.)
    //        9: int w = 0, r = 1;
    //        10: String name = "";
    //        11: while(w < 2) {
    //        12: name += "A";    name = A
    //        13: do {
    //        14: name += "B";                      name = AB
    //        15: if(name.length()>0) name += "C";  name = ABC - бесконечное условие
    //        16: else break;
    //        17: } while (r <=1);
    //        18: r++; w++; }
    //        19: System.out.println(name);
    //        A. ABC
    //        B. ABCABC
    //        C. ABCABCABC
    //        D. Line 15 contains a compilation error.
    //        E. Line 18 contains a compilation error.
    //        F. The code compiles but never terminates at runtime.     // Correct
    //        G. The code compiles but throws a NullPointerException at
    //        runtime.
}
