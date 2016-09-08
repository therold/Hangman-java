import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class WordGame {
  String mWord;
  ArrayList<String> mGuesses;
  String[] mWordList = {"test", "jaguar", "ceiling", "programming"};
  String[] easy = {"sportscar", "jacket", "entertainment", "hotdog"};
  String[] medium = {"test", "programming", "report", "football"};
  String[] hard = {"ceiling", "apartment", "jaguar", "repartee"};



  public WordGame(String word) {
    mWord = word;
    mGuesses = new ArrayList<String>();
  }

  public WordGame(Integer difficulty) {
    mGuesses = new ArrayList<String>();
    Random myRandomGenerator = new Random();
    Integer randomNumber;
    switch(difficulty){
      case 0:
        randomNumber = myRandomGenerator.nextInt(easy.length);
        mWord = easy[randomNumber];
        break;
      case 1:
        randomNumber = myRandomGenerator.nextInt(medium.length);
        mWord = medium[randomNumber];
        break;
      case 2:
        randomNumber = myRandomGenerator.nextInt(hard.length);
        mWord = hard[randomNumber];
        break;
    }
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
    if (guess.length() == 1 && !mGuesses.contains(guess)){
      mGuesses.add(guess);
    }
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
