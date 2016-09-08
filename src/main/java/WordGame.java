import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class WordGame {
  String mWord;
  ArrayList<String> mGuesses;
  String[] mWordList = {"test", "cat", "dog", "programming"};

  public WordGame(String word) {
    mWord = word;
    mGuesses = new ArrayList<String>();
  }

  public WordGame() {
    mGuesses = new ArrayList<String>();
    Random myRandomGenerator = new Random();
    Integer randomNumber = myRandomGenerator.nextInt(mWordList.length);
    mWord = mWordList[randomNumber];
  }

  public Integer getGameOver() {
    Integer status = 0;
    if (getHiddenWord().indexOf("_") == -1) {
      status = 1;
    } else if (getWrongLetterCount() == 6) {
      status = 2;
    }
    return status;
  }

  public String getWord() {
    return mWord;
  }

  public ArrayList<String> getGuesses() {
    return mGuesses;
  }

  public String getHiddenWord() {
    String output = "";
    for (int i = 0; i < mWord.length(); i++) {
      if (mGuesses.contains(Character.toString(mWord.charAt(i)))) {
        output += mWord.charAt(i);
      } else {
        output += "_";
      }
    }
    return output;
  }

  public void guessLetter(String guess) {
    mGuesses.add(guess);
  }

  public Integer getWrongLetterCount() {
    Integer count = 0;
    for (String letter: mGuesses) {
      if (mWord.indexOf(letter) == -1) {
        count ++;
      }
    }
    return count;
  }
}
