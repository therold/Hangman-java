import java.io.Console;

public class App {
  public static void main(String[] args){
    Console myConsole = System.console();
    System.out.println("Would you like to use your own word or a random word? (Press Enter to use a Random Word.)");
    String word = myConsole.readLine();
    WordGame game;
    if(word.equals("")){
      game = new WordGame();
    } else {
      game = new WordGame(word);
    }
    while (game.getGameOver() == 0) {
      System.out.println(game.getHiddenWord());
      System.out.println("Guess a letter.");
      String pickedLetter = myConsole.readLine();
      game.guessLetter(pickedLetter);
    }
    if(game.getGameOver() == 1) {
      System.out.println("You Win.");
    } else if (game.getGameOver() == 2) {
      System.out.println("Sorry, you're a loser.");
    }
  }
}
