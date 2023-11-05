// Visitor, foi exemplificado através do jogo da forca.

import java.util.ArrayList;
import java.util.List;

// Interface Visitor
interface Visitor {
    void visit(Word word, char letter);
}

// Classe Word (Element)
abstract class Word {
    private String value;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract void accept(Visitor visitor, char letter);
}

// Palavra Concreta (Concrete Element)
class SecretWord extends Word {
    public SecretWord(String value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor, char letter) {
        visitor.visit(this, letter);
    }
}

// Classe Game (Object Structure)
class Game {
    private List<Word> words = new ArrayList<>();

    public void addWord(Word word) {
        words.add(word);
    }

    public void guessLetter(char letter) {
        for (Word word : words) {
            word.accept(new LetterGuesser(), letter);
        }
    }
}

// Visitor Concreto
class LetterGuesser implements Visitor {
    @Override
    public void visit(Word word, char letter) {
        if (word instanceof SecretWord) {
            SecretWord secretWord = (SecretWord) word;
            String value = secretWord.getValue();
            if (value.contains(String.valueOf(letter))) {
                System.out.println("Letra '" + letter + "' encontrada em '" + value + "'.");
            } else {
                System.out.println("Letra '" + letter + "' não encontrada em '" + value + "'.");
            }
        }
    }
}

public class HangmanGame {
    public static void main(String[] args) {
        Game game = new Game();

        Word word1 = new SecretWord("programming");
        Word word2 = new SecretWord("java");

        game.addWord(word1);
        game.addWord(word2);

        game.guessLetter('a');
        game.guessLetter('m');
    }
}