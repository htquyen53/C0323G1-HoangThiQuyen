package ss8.bai_tap;

import java.util.Scanner;

public class TestGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the score of first player: ");
        int firstPlayerScore = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the score of second player: ");
        int secondPlayerScore = Integer.parseInt(scanner.nextLine());
        System.out.println(TennisGame.getScore(firstPlayerScore,secondPlayerScore));
    }
}
