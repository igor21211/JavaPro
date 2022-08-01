package HomeWork_8;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exeption_2 {

    public class App {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) { // перехватили RuntimeException
                System.err.print(" 2.1");
                try {
                    System.err.print(" 2.2");
                    if (true) {
                        throw new Error();
                    } // и бросили новый Error
                    System.err.print(" 2.3");
                } catch (Throwable t) {            // перехватили Error
                    System.err.print(" 2.4");
                }
                System.err.print(" 2.5");
            } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
                System.err.print(" 3");
            }
            System.err.println(" 4");
        }
    }

    public class App1 {
        public static void main(String[] args) throws Exception { // пока игнорируйте 'throws'
            try {
                System.err.print(" 0");
                if (true) {
                    throw new Exception();
                }
                System.err.print(" 1");
            } catch (RuntimeException e) {
                System.err.print(" 2");
            }
            System.err.print(" 3");
        }
    }


    public class App2 {
        public static void main(String[] args) {
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    RuntimeException re = (RuntimeException) e;
                    System.err.print("Это RuntimeException на самом деле!!!");
                } else {
                    System.err.print("В каком смысле не RuntimeException???");
                }
            }
        }
    }

    public class App3 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 1");
            } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
                System.err.print(" 2");
            }
            System.err.println(" 3");
        }
    }

    public static void main(String[] args) {
        System.err.println("#1.in");
        try {
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println("#1.CATCH");  // и работаем
        }
        System.err.println("#1.out");  // работаем дальше

    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }


    public class App5 {
        public static void main(String[] args) {
            System.err.println("#1.in");
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println("#1.out"); // ПРОПУСТИЛИ!
        }

        public static void f() {
            System.err.println(".   #2.in");
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
        }

        public static void g() {
            System.err.println(".   .   #3.in");
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
        }

        public static void h() {
            System.err.println(".   .   .   #4.in");
            if (true) {
                System.err.println(".   .   .   #4.THROW");
                throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
            }
            System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
        }
    }

    //finally
    public class App6 {
        public static void main(String[] args) {
            System.err.println(f());
        }

        public static int f() {
            long rnd = 123999999L;
            boolean finished = false;
            try {
                if (rnd % 3 == 0) {
                    throw new Error();
                } else if (rnd % 3 == 1) {
                    throw new RuntimeException();
                } else {
                    // nothing
                }
                finished = true;
            } finally {
                if (finished) {
                    // не было исключений
                } else {
                    // было исключение, но какое?
                }
            }
            return (int) rnd;
        }
    }
//видим проблемное место кидай исключение
    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }

    //finally-секция получает управление, если try-блок завершился успешно
    public class App23 {
        public static void main(String[] args) {
            try {
                System.err.println("try");
            } finally {
                System.err.println("finally");
            }
        }
    }

    //finally-секция получает управление, даже если try-блок завершился исключением
    public class App24 {
        public static void main(String[] args) {
            try {
                throw new RuntimeException();
            } finally {
                System.err.println("finally");
            }
        }
    }

    //finally-секция получает управление, даже если try-блок завершился директивой выхода из метода
    public class App35 {
        public static void main(String[] args) {
            try {
                return;
            } finally {
                System.err.println("finally");
            }
        }
    }

  //  finally-секция НЕ вызывается только если мы «прибили» JVM
    public class App37 {
        public static void main(String[] args) {
            try {
                System.exit(42);
            } finally {
                System.err.println("finally");
            }
        }
    }

   // System.exit(42) и Runtime.getRuntime().exit(42) — это синонимы
    public class App38 {
        public static void main(String[] args) {
            try {
                Runtime.getRuntime().exit(42);
            } finally {
                System.err.println("finally");
            }
        }
    }

    //Трюк с «if (true) {...}» требуется, так как иначе компилятор обнаруживает недостижимый код (последняя строка) и отказывается его компилировать
    public class App19 {
        public static void main(String[] args) {
            try {
                System.err.println("try");
                throw new RuntimeException();
            } finally {
                System.err.println("finally");
            }
            //System.err.println("more");
        }
    }

   // И finally-секция не может «предотвратить» выход из метода, если try-блок вызвал return («more» — не выводится в консоль)
    public class App50 {
        public static void main(String[] args) {
            try {
                System.err.println("try");
                if (true) {return;}
            } finally {
                System.err.println("finally");
            }
            System.err.println("more");
        }
    }


   // Есть исключение и есть подходящий catch
    public class App70 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {throw new Error();}
                System.err.print(" 1");
            } catch(Error e) {
                System.err.print(" 2");
            } finally {
                System.err.print(" 3");
            }
            System.err.print(" 4");
        }
    }

  //  Вложенный try-catch-finally без исключения
    public class App78 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    // НИЧЕГО
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // НЕ заходим - нет исключения
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // заходим - выполнение в норме
            } catch (Exception e) {
                System.err.print(" 6");     // НЕ заходим - нет исключения
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // заходим - выполнение в норме
        }
    }

   // Вложенный try-catch-finally с исключением, которое ПЕРЕХВАТИТ ВНУТРЕННИЙ catch
    public class App90 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    if (true) {throw new RuntimeException();}
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // ЗАХОДИМ - есть исключение
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // заходим - выполнение УЖЕ в норме
            } catch (Exception e) {
                System.err.print(" 6");     // не заходим - нет исключения, УЖЕ перехвачено
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
        }
    }


   // Вложенный try-catch-finally с исключением, которое ПЕРЕХВАТИТ ВНЕШНИЙ catch
    public class App92 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    if (true) {throw new Exception();}
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // не заходим - выполнение НЕ в норме
            } catch (Exception e) {
                System.err.print(" 6");     // ЗАХОДИМ - есть подходящее исключение
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
        }
    }

    public class App230 {
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                try {
                    System.err.print(" 1");
                    if (true) {throw new Error();}
                    System.err.print(" 2");
                } catch (RuntimeException e) {
                    System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
                } finally {
                    System.err.print(" 4"); // заходим всегда
                }
                System.err.print(" 5");     // НЕ заходим - выполнение НЕ в норме
            } catch (Exception e) {
                System.err.print(" 6");     // не заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {
                System.err.print(" 7");     // заходим всегда
            }
            System.err.print(" 8");         // не заходим - выполнение НЕ в норме
        }
    }


 //   Мы можем предупредить точно о том, что бросаем
    public class App121 {
        public static void main(String[] args) throws Exception { // предупреждаем о Exception
            throw new Exception(); // и кидаем Exception
        }
    }

   // Мы можем предупредить о большем, чем мы бросаем
    public class App222 {
        public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
            throw new Exception(); // а кидаем только Exception
        }
    }


    //Можем даже предупредить о том, чего вообще нет
    public class App333 {
        public static void main(String[] args) throws Exception { // пугаем
            // но ничего не бросаем
        }
    }

  //  Мы можем точно указать, что выбрасываем

    public class App3323 {
        // пугаем ОБОИМИ исключениями
        public static void main(String[] args) throws EOFException, FileNotFoundException {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        }
    }

  //  А можем «испугать» сильнее (предком обоих исключений)


    public class App4545 {
        // пугаем ПРЕДКОМ исключений
        public static void main(String[] args) throws IOException {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        }
    }

    public class App2323 {
        public static void main(String[] args) throws Exception {
            Object ref = "Hello!";  // ref указывает на строку
            char c = ((String) ref).charAt(0); // но тут ошибка компиляции
        }
    }

    public class App1212 {
        // ТЕПЕРЬ пугаем Throwable
        public static void main(String[] args) throws Throwable {
            try {
                Throwable t = new Exception(); // а лететь будет Exception
                throw t;
            } catch (Exception e) { // и мы перехватим Exception
                System.out.println("Перехвачено!");
            }
        }
    }
}