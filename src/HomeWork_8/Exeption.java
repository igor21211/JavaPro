package HomeWork_8;

public class Exeption {
    public static void main(String[] args) throws Throwable {
        try {
            int a = 0;
            int b = 5;
            System.out.println(b / a);
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            int a = 0;
            int b = 5;
            System.out.println(b / a);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        Error ref = new Error(); // создаем экземпляр
        //   throw ref;               // "бросаем" его


// //       2. Почему используем System.err, а не System.out
//        System.out.println("sout");
//        throw new Error();

//
//        System.err.println("sout");//err обогнало out при выводе в консоль
//        throw new Error();
//
//
//    }
        //   3. Компилятор требует вернуть результат (или требует молчать)
//    public static void Ex1(String[] args) {
//        double d = sqr(10.0);  // sqr - навсегда "повиснет", и
//        System.out.println(d); // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
//    }
//    public static double sqr1(double arg) {
//        while (true); // Вот тут мы на века "повисли"
//    }
//    public static double sqr2(double arg) {
//        while (true); // Удивительно, но КОМПИЛИРУЕТСЯ!
//    }
//
//    public static double sqr3(double arg) {
//        if (System.currentTimeMillis() % 2 == 0) {
//            return arg * arg; // если currentTimeMillis() - четное число, то все ОК
//        }
//      //   а если нечетное, что нам возвращать?
//    }

//    public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
//        long time = System.currentTimeMillis();
//        if (time % 2 == 0) {
//            return arg * arg;             // ок, вот твой double
//        } else if (time % 2 == 1) { {
//            while (true);                 // не, я решил "повиснуть"
//    //    } else if (){
//            throw new RuntimeException(); // или бросить исключение
//        }
//        }
//    }
//    //Но КАКОЙ ЖЕ double вернет функция, бросающая RuntimeException?
//    //А НИКАКОЙ!
//
//    public static void main2(String[] args) {
//        // sqr - "сломается" (из него "выскочит" исключение),
//        double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
//        // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
//        System.out.println(d); // и печатать нам ничего не придется!
//    }
//    public static double sqr(double arg) {
//        throw new RuntimeException(); // "бросаем" исключение
//    }

//    public static int area(int width, int height) {
//        if (width < 0 || height < 0) {
//            return -1; // специальное "неправильное" значение площади
//        } else {
//            return width * height;
//        }
//    }
////Правильное обработка ошибки
//    public static int area2(int width, int height) {
//        if (width < 0 || height < 0) {
//            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
//        }
//        return width * height;
//    }

    }
}

