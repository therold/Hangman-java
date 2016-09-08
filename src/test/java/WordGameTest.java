import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.ArrayList;

public class WordGameTest {

  @Test
  public void newWordGame_instanceOfWordGame() {
    WordGame testWordGame = new WordGame("test");
    assertEquals(true, testWordGame instanceof WordGame);
  }

  @Test
  public void getWord_returnsOriginalWord() {
    WordGame testWordGame = new WordGame("test");
    String expected = "test";
    assertEquals(expected, testWordGame.getWord());
  }

  @Test
  public void getGuesses_returnsAllGuesses() {
    WordGame testWordGame = new WordGame("test");
    ArrayList<String> expected = new ArrayList<String>();
    expected.add("e");
    testWordGame.guessLetter("e");
    assertEquals(expected, testWordGame.getGuesses());
  }

  @Test
  public void getHiddenWord_returnsSecretWord() {
    WordGame testWordGame = new WordGame("test");
    String expected = "____";
    assertEquals(expected, testWordGame.getHiddenWord());
  }

  @Test
  public void guessLetter_guessLetterCorrectly_returnsSecretWord() {
    WordGame testWordGame = new WordGame("test");
    testWordGame.guessLetter("e");
    String expected = "_e__";
    assertEquals(expected, testWordGame.getHiddenWord());
  }

  @Test
  public void guessLetters_guessLettersCorrectly_returnSecretWord() {
    WordGame testWordGame = new WordGame("test");
    testWordGame.guessLetter("e");
    testWordGame.guessLetter("s");
    testWordGame.guessLetter("t");
    String expected = "test";
    assertEquals(expected, testWordGame.getHiddenWord());
  }

  @Test
  public void guessLetters_guessWrongLetters_returnNumberOfGuesses(){
    WordGame testWordGame = new WordGame("test");
    testWordGame.guessLetter("z");
    Integer expected = 1;
    assertEquals(expected, testWordGame.getWrongLetterCount());
  }

  @Test
  public void getRandomWord_returnDifferentHiddenWords(){
    WordGame testWordGame = new WordGame();
    assertEquals(true, testWordGame.getWord() instanceof String);

  }

  @Test
  public void finishGame_guessWord_getGameNotOver(){
    WordGame testWordGame = new WordGame();
    Integer gameNotOver = 0;
    assertEquals(gameNotOver, testWordGame.getGameOver());
  }

  @Test
  public void finishGame_guessWord_getGameOverPlayerWin(){
    WordGame testWordGame = new WordGame("test");
    Integer gameOverPlayerWin = 1;
    testWordGame.guessLetter("e");
    testWordGame.guessLetter("s");
    testWordGame.guessLetter("t");
    assertEquals(gameOverPlayerWin, testWordGame.getGameOver());
  }

  @Test
  public void finishGame_guessWord_getGameOverPlayerLose(){
    WordGame testWordGame = new WordGame("test");
    Integer gameOverPlayerLost = 2;
    testWordGame.guessLetter("z");
    testWordGame.guessLetter("f");
    testWordGame.guessLetter("g");
    testWordGame.guessLetter("k");
    testWordGame.guessLetter("l");
    testWordGame.guessLetter("n");
    testWordGame.guessLetter("o");
    assertEquals(gameOverPlayerLost, testWordGame.getGameOver());
  }
}
