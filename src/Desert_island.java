
import java.util.ArrayList;
import java.util.Scanner;

public class Desert_island {
    static Scanner scanner = new Scanner(System.in);
    static String[] options = {"Jukebox", "DVD-player", "Guitar", "Regular guy", "Regular woman", "Axe", "Knife", "Candy", "Bear Grylls", "Jimi Hendrix"};
    static ArrayList<String> insertOptions = new ArrayList<>();
    static ArrayList<String> pickOptionsDynamic = new ArrayList<>();
    static boolean run = false;
    static int pickOptions[];
    static int scn;
    static int picks;
    static int players;
    static int amountOfStaticOptions;

    public static void main(String[] args) {
        gameInitialization();
        gameLaunch();
    }

    public static void gameInitialization() {
        do {
            run = false;
            try {

                System.out.println("Welcome to Desert Island the game!");
                System.out.println("How many players are you?");
                players = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Do you want your options served, or do you want to insert your own?\n1. have options served\n2. insert your own ");
                scn = scanner.nextInt();
                scanner.nextLine();
                System.out.println("How many picks does the player, or each player have?");
                picks = scanner.nextInt();
                scanner.nextLine();

                if (scn == 1) {
                    do {
                        run = false;
                        System.out.println("How many options do you want? (1-10)");
                        try {
                            amountOfStaticOptions = scanner.nextInt();
                            scanner.nextLine();
                            if (scn >= 1 && scn <= 10) {
                                staticOptions(amountOfStaticOptions);
                            } else {
                                System.out.println("Illegal value! Enter a value between 1-10! Try again.");
                                run = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Illegal value! Enter a value between 1-10! Try again.");
                            run = true;
                        }
                    } while (run);
                } else if (scn == 2) {
                    System.out.println("Insert your own options (no limit)! End with \"0\".");
                    insertOptions();
                } else if (players == 0) {
                    System.out.println("Game over!");
                } else {
                    System.out.println("Illegal value! Try again. ");
                    run = true;
                }
            } catch (Exception e) {
                System.out.println("Illegal value! Try again.");
                run = true;
            }
        } while (run);
    }

    public static void staticOptions(int scn) {
        for (int i = 1; i <= scn; i++) {
            System.out.println(i + ". " + options[i]);
        }
    }

    public static void insertOptions() {
        while (!insertOptions.contains("0")) {
            try {
                insertOptions.add(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("You need to insert something!");
            }
        }
        System.out.println("The following options are available: ");
        for (int i = 0; i < insertOptions.size() - 1; i++) {
            System.out.println(i + 1 + ". " + insertOptions.get(i));
        }
    }

    public static void gameLaunch() {
        if (players > 1) {
            for (int player = 1; player <= players; player++) {
                if (scn == 1) {
                    if(player == 1) {
                        System.out.print("So, which of the things above, would you rather have on a desert island?\nPlayer " + player + " starting. Insert the corresponding decimal value (1-" + amountOfStaticOptions + "):");
                    } else {
                        System.out.println("Player " + player + "'s turn!");
                    }
                } else if (scn == 2) {
                    int value = insertOptions.size() - 1;
                    if (player == 1) {
                        System.out.print("So, which of the things above, would you rather have on a desert island?\nPlayer " + player + " starting. Insert the corresponding decimal value (1-" + value + "):");
                        pickOptions();
                    } else {
                        pickOptions();
                    }
                }
            }
        } else {
            if (scn == 1) {
                System.out.print("So, which of the things above, would you rather have on a desert island? Insert the corresponding decimal value (1-" + amountOfStaticOptions + "):");
            } else if (scn == 2) {
                int value = insertOptions.size() - 1;
                System.out.print("So, which of the things above, would you rather have on a desert island? Insert the corresponding decimal value (1-" + value + "):");
                pickOptions();
            }
        }
    }

    public static void pickOptions() {
            if (players > 1) {
                for (int player = 0; player < players; player++) {
                    System.out.println("Player " + player + ", please make " + picks + " picks.");
                    numberOfPicks();
                }
            } else {
                System.out.println("Please make " + picks + " picks.");
                numberOfPicks();
            }
    }

    public static void numberOfPicks() {
        int choice;
        if (scn == 1) {
            for (int i = 0; i < picks; i++) {
                System.out.println("Insert option: ");
                do {
                    run = false;
                    try {
                        choice = scanner.nextInt();
                        pickOptions[i] = choice;
                        String temporary = options[choice];
                        System.out.println(temporary);
                    } catch (Exception e) {
                        System.out.println("You must insert something or an integer!");
                        run = true;
                    }
                } while (run);
            }
        } else {
            for (int i = 0; i < picks; i++) {
                System.out.println("Insert option: ");
                do {
                    run = false;
                    try {
                        pickOptionsDynamic.add(i, scanner.nextLine());
                        if (Integer.parseInt(pickOptionsDynamic.get(i)) < 0 || Integer.parseInt(pickOptionsDynamic.get(i)) > 9) {
                            System.out.println("You must insert an integer!");
                            run = true;
                        }
                    } catch (Exception e) {
                        System.out.println("You must insert something!");
                        run = true;
                    }
                } while (run);
            }
        }
    }
}

