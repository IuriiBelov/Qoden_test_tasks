package task2;

public class Word implements Comparable<Word> {
    private String word;
    private int quantity;

    public Word(String word) {
        this.word = word;
        this.quantity = 1;
    }

    public String getWord() {
        return word;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        ++quantity;
    }

    public int compareTo(Word w) {
        if (this.quantity == w.quantity) {
            return this.word.compareTo(w.word);
        }
        return (this.quantity - w.quantity);
    }
}
