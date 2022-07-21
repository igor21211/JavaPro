package HomeWork_6.ErorrFix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static class Ball {

    }

    private static class Board {
        private List balls ;

        public Board() {
            //Было List balls = new ArrayList<>();
            //так как лист уже обьявлен и тут мы второй рас пытались обьявить лист с том же названием вылетала ошибка
            balls = new ArrayList<>();
            balls.add(new Ball());
            balls.add(new Ball());
            balls.add(new Ball());
        }

        public int count() {
            return balls.size();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.count());
    }
}