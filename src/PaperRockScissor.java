import java.util.Scanner;
import java.util.Random;


public class PaperRockScissor {
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);
    static boolean run = false;
    static String[] hands = new String[6];
    static String player1 = "You";
    static String player2 = "Computer";
    static int[] playerWin = new int[3];
    static int selectGameMode;

    public static void selectGameMode() {
        do {
            run = false;
            try {
                selectGameMode = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Illegal value! You must insert an integer (1 or 2). Try again..");
                run = true;
            }
            if (selectGameMode == 1) {
                singleplayer();
            } else if (selectGameMode == 2) {
                multiplayer();
            } else {
                System.out.println("Illegal value! It must be a decimal of even 1 or 2. Try again.");
                run = true;
            }
        } while (run);
    }

    public static void multiplayer () {
        System.out.print("Insert the name of player 1: ");
        player1 = scanner.nextLine();
        System.out.print("Insert the name of player 2: ");
        player2 = scanner.nextLine();
        gameTurns();
        findTheWinner();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Paper Rock Scissor the game!\nSelect game mode:\n1. Singleplayer\n2. Multiplayer");
        selectGameMode();
    }

    public static void gameTurns() {
        String tempHand;
        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < 5; i += 2) {
            for (int u = 2; u < 4; u++) {
                if (u % 2 == 0) {
                    System.out.println("Insert \"p\" for paper, \"r\" for rock, \"s\" for scissor");
                    if (i == 0) {
                        System.out.println(player1 + " starts");
                    } else {
                        System.out.println(player1 + "'s turn");
                    }
                    tempHand = selectHand(scanner.nextLine());
                } else {
                    System.out.println(player2 + "'s turn");
                    tempHand = selectHand(scanner.nextLine());
                }
                hands[counter] = tempHand;
                counter++;
            }
            int win = compareAndJudge(i);
            playerWin[counter2] = win;
            counter2++;
        }
    }

    public static String selectHand(String hand) {
        System.out.println("***********************************************************");
        System.out.println("***********************************************************");
        System.out.println("***********************************************************");
        System.out.println("***********************************************************");
        System.out.println("***********************************************************");
        System.out.println("***********************************************************");
        System.out.println("***********************************************************");
        return hand;
    }

    public static int compareAndJudge(int i) {
        int points;
        if (hands[i].equals("r") && hands[i + 1].equals("r")) {
            System.out.println("Draw..");
            points = 0;
        } else if (hands[i].equals("r") && hands[i + 1].equals("p")) {
            if (selectGameMode == 1) {
                System.out.println(player2 + " wins!");
            } else {
                System.out.println(player2 + " wins!");
            }
            points = 2;
        } else if (hands[i].equals("r") && hands[i + 1].equals("s")) {
            if (selectGameMode == 1) {
                System.out.println(player1 + " win!");
            } else {
                System.out.println(player1 + " wins!");
            }
            points = 1;
        } else if (hands[i].equals("s") && hands[i + 1].equals("s")) {
            System.out.println("Draw!");
            points = 0;
        } else if (hands[i].equals("s") && hands[i + 1].equals("p")) {
            if (selectGameMode == 1) {
                System.out.println(player1 + " win!");
            } else {
                System.out.println(player1 + " wins!");
            }
            points = 1;
        } else if (hands[i].equals("s") && hands[i + 1].equals("r")) {
            System.out.println(player2 + " wins!");
            points = 2;
        } else if (hands[i].equals("p") && hands[i + 1].equals("r")) {
            if (selectGameMode == 1) {
                System.out.println(player1 + " win!");
            } else {
                System.out.println(player1 + " wins!");
            }
            points = 1;
        } else if (hands[i].equals("p") && hands[i + 1].equals("p")) {
            System.out.println("Draw!!");
            points = 0;
        } else {
            System.out.println(player2 + " wins!");
            points = 2;
        }
        return points;
    }

    public static void findTheWinner() {
        int player1Points = 0;
        int player2Points = 0;
        for (int i = 0; i < 3; i++) {
            if (playerWin[i] == 1) {
                player1Points++;
            } else if (playerWin[i] == 2) {
                player2Points++;
            }
        }
        if (player1Points > player2Points) {
            if (selectGameMode == 1) {
                System.out.println(player1 + " are the ultimate winner!");
            } else {
                    System.out.println(player1 + " is the ultimate winner!");
                }
            } else if (player1Points < player2Points) {
                System.out.println(player2 + " is the ultimate winner!");
            }
            System.out.println("Winner winner chicken dinner!");
        }

    public static void singleplayer() {

        int counter2 = 0;

        for (int i = 0; i < 5; i += 2) {
            int random = rand.nextInt(3);
            System.out.println("Insert \"p\" for paper, \"r\" for rock, \"s\" for scissor");
            hands[i] = scanner.nextLine();
            if (random == 0) {
                hands[i + 1] = "r";
            } else if (random == 1) {
                hands[i + 1] = "p";
            } else {
                hands[i + 1] = "s";
            }

            int win = compareAndJudge(i);
            playerWin[counter2] = win;
            counter2++;
        }
        findTheWinner();
    }
}
