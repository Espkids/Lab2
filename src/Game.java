import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col;
    private static int row;
    private static String answer;
    public static void main(String[] args) {
        ox = new OX() ;
        while (true) {
            printTable();
            input();
            if (ox.checkWin(col,row)) {
                printTable();
                System.out.println(ox.getCurrentPlayer() + " Win:");
                printScore();
                ox.reset();
                System.out.println("Do you want to continue Y|N ");
                answer = sc.next() ;
                if (answer.equals("Y")) {
                    continue;
                } else {
                    break;
                }
            }
            if (ox.isDraw()) {
                printTable();
                System.out.println("Draw");
                printScore();
                ox.reset();
                System.out.println("Do you want to continue Y|N ");
                answer = sc.next() ;
                if (answer.equals("Y")) {
                    continue;
                } else {
                    break;
                }
            }
            ox.switchPlayer();
        }
    }

    private static void printScore() {
        System.out.println("Score X: " + ox.getScoreX());
        System.out.println("Score O: " + ox.getScoreO());
        System.out.println("Score Draw: " + ox.getScoreDraw());
    }

    private static void input() {
        boolean canPut = true ;
        do {
            System.out.print(ox.getCurrentPlayer() + " Col :");
            col = sc.nextInt();
            System.out.print(ox.getCurrentPlayer() + " Row :");
            row = sc.nextInt();
            canPut = ox.put(col,row);
            if (!canPut) {
                if (col>2 || col<0 || row>2 || row<0) {
                    System.out.println("Please input number between 0-2 ");
                } else {
                    System.out.println("Please choose empty box ");
                }
            }
        } while (!canPut);
    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }
}
