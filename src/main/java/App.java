import java.io.Console;

public class App {
  public static void main(String[] args){
    Console myConsole = System.console();
    resetScreen();
    System.out.println("Would you like to use your own word or a random word? (Press Enter to use a Random Word.)");
    String word = myConsole.readLine();
    WordGame game;
    if (word.equals("")){
      game = new WordGame();
    } else {
      game = new WordGame(word);
    }
    boolean running = true;
    while (running) {
      while (game.getGameOver() == 0) {
        resetScreen();
        displayHangman(game.getWrongLetterCount());
        System.out.println(game.getHiddenWord());
        System.out.println();
        System.out.print("Letters used: ");
        for (String letter : game.getGuesses()) {
          System.out.print(ConsoleUtils.underline(letter) + " ");
        }
        System.out.println();
        System.out.println();
        System.out.print("Guess a letter: ");
        String pickedLetter = myConsole.readLine();
        game.guessLetter(pickedLetter);
      }
      ConsoleUtils.clearConsole();
      ConsoleUtils.setTitle("Hangman");
      if(game.getGameOver() == 1) {
        displayWin(game.getWrongLetterCount());
      } else if (game.getGameOver() == 2) {
        displayLose(game.getWrongLetterCount());
      }
      System.out.println("Do you want to play again? [Y/N]");
      String choice = myConsole.readLine();
      resetScreen();
      if (choice.equals("N")) {
        running = false;
        System.out.println("Goodbye!");
      } else {
        System.out.println("Would you like to use your own word or a random word? (Press Enter to use a Random Word.)");
        word = myConsole.readLine();
        if (word.equals("")){
          game = new WordGame();
        } else {
          game = new WordGame(word);
        }
      }
    }
  }

  public static void displayWin(Integer wrongGuesses) {
    System.out.println("\033[44;37m");
    for (int i = 0; i < 22; i++) {
      for (int j = 0; j < 80; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.print("\033[H");
    ConsoleUtils.setTitle("Hangman");
    System.out.println("\033[44;37m");

    System.out.println("  _______________");
    System.out.println(" |@@@@|     |####|");
    System.out.println(" |@@@@|     |####|");
    System.out.println(" |@@@@|     |####|");
    System.out.println(" \\@@@@|     |####/");
    System.out.println("  \\@@@|     |###/");
    System.out.println("  ` @@|_____|##'");
    System.out.println("        (O)");
    System.out.println("     .-'''''-.");
    System.out.println("   .'  * * *  `.");
    System.out.println("  :  *       *  :");
    System.out.println(" : ~   Y O U   ~ :");
    System.out.println(" : ~   W I N   ~ :");
    System.out.println("  :  *       *  :");
    System.out.println("   `.  * * *  .'");
    System.out.println("     `-.....-'");
    // System.out.println("You Win.");
  }

  public static void displayLose(Integer wrongGuesses) {
    System.out.println("\033[41;37m");
    for (int i = 0; i < 22; i++) {
      for (int j = 0; j < 80; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.print("\033[H");
    ConsoleUtils.setTitle("Hangman");
    System.out.println("\033[41;37m");
    displayHangman(wrongGuesses);
    System.out.println("You Lose!");
  }

  public static void resetScreen() {
    ConsoleUtils.clearConsole();
    ConsoleUtils.setTitle("Hangman");
  }

  public static void displayHangman(Integer wrongGuesses) {
    switch (wrongGuesses) {
      case 0:
        System.out.println("  | .__________))______| ");
        System.out.println("| | / /      ||          ");
        System.out.println("| |/ /       ||          ");
        System.out.println("| | /        ||     ");
        System.out.println("| |/         ");
        System.out.println("| |          ");
        System.out.println("| |           ");
        System.out.println("| |            ");
        System.out.println("| |           ");
        System.out.println("| |          ");
        System.out.println("| |         ");
        System.out.println("| |                       ");
        System.out.println("| |                      ");
        System.out.println("| |                     ");
        System.out.println("| |                      ");
        System.out.println("| |                      ");
        System.out.println("| |                       ");
        break;
      case 1:
        System.out.println("  | .__________))______| ");
        System.out.println("| | / /      ||          ");
        System.out.println("| |/ /       ||          ");
        System.out.println("| | /        ||.-''.     ");
        System.out.println("| |/         |/  _  \\    ");
        System.out.println("| |          ||  `/,|    ");
        System.out.println("| |          (\\\\`_.'     ");
        System.out.println("| |               ");
        System.out.println("| |             ");
        System.out.println("| |           ");
        System.out.println("| |         ");
        System.out.println("| |       ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |               ");
        break;
      case 2:
        System.out.println("  | .__________))______| ");
        System.out.println("| | / /      ||          ");
        System.out.println("| |/ /       ||          ");
        System.out.println("| | /        ||.-''.     ");
        System.out.println("| |/         |/  _  \\    ");
        System.out.println("| |          ||  `/,|    ");
        System.out.println("| |          (\\\\`_.'     ");
        System.out.println("| |         .-`--'.      ");
        System.out.println("| |           . .      ");
        System.out.println("| |          |   |    ");
        System.out.println("| |          | . |   ");
        System.out.println("| |          |   |     ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                ");
        System.out.println("| |               ");
        break;
      case 3:
        System.out.println("  | .__________))______| ");
        System.out.println("| | / /      ||          ");
        System.out.println("| |/ /       ||          ");
        System.out.println("| | /        ||.-''.     ");
        System.out.println("| |/         |/  _  \\    ");
        System.out.println("| |          ||  `/,|    ");
        System.out.println("| |          (\\\\`_.'     ");
        System.out.println("| |         .-`--'.      ");
        System.out.println("| |        /Y . .      ");
        System.out.println("| |       // |   |     ");
        System.out.println("| |      //  | . |     ");
        System.out.println("| |     ')   |   |     ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |               ");
        break;
      case 4:
        System.out.println("  | .__________))______| ");
        System.out.println("| | / /      ||          ");
        System.out.println("| |/ /       ||          ");
        System.out.println("| | /        ||.-''.     ");
        System.out.println("| |/         |/  _  \\    ");
        System.out.println("| |          ||  `/,|    ");
        System.out.println("| |          (\\\\`_.'     ");
        System.out.println("| |         .-`--'.      ");
        System.out.println("| |        /Y . . Y\\     ");
        System.out.println("| |       // |   | \\\\    ");
        System.out.println("| |      //  | . |  \\\\   ");
        System.out.println("| |     ')   |   |   (`  ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |                 ");
        System.out.println("| |               ");
        break;
      case 5:
        System.out.println("  | .__________))______| ");
        System.out.println("| | / /      ||          ");
        System.out.println("| |/ /       ||          ");
        System.out.println("| | /        ||.-''.     ");
        System.out.println("| |/         |/  _  \\    ");
        System.out.println("| |          ||  `/,|    ");
        System.out.println("| |          (\\\\`_.'     ");
        System.out.println("| |         .-`--'.      ");
        System.out.println("| |        /Y . . Y\\     ");
        System.out.println("| |       // |   | \\\\    ");
        System.out.println("| |      //  | . |  \\\\   ");
        System.out.println("| |     ')   |   |   (`  ");
        System.out.println("| |          ||'       ");
        System.out.println("| |          ||        ");
        System.out.println("| |          ||       ");
        System.out.println("| |          ||       ");
        System.out.println("| |         / |       ");
        break;
      case 6:
        System.out.println("  | .__________))______| ");
        System.out.println("| | / /      ||          ");
        System.out.println("| |/ /       ||          ");
        System.out.println("| | /        ||.-''.     ");
        System.out.println("| |/         |/  _  \\    ");
        System.out.println("| |          ||  `/,|    ");
        System.out.println("| |          (\\\\`_.'     ");
        System.out.println("| |         .-`--'.      ");
        System.out.println("| |        /Y . . Y\\     ");
        System.out.println("| |       // |   | \\\\    ");
        System.out.println("| |      //  | . |  \\\\   ");
        System.out.println("| |     ')   |   |   (`  ");
        System.out.println("| |          ||'||       ");
        System.out.println("| |          || ||       ");
        System.out.println("| |          || ||       ");
        System.out.println("| |          || ||       ");
        System.out.println("| |         / | | \\      ");
        break;
    }
  }
}
