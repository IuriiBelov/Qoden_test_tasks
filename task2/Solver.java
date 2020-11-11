package task2;

import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solver {
    private static final int NUM_OF_DOTS = 10;

    public static void main(String[] args) {
        List<Word> list = initList();
        Collections.sort(list);
        printList(list);
    }

    private static List<Word> initList() {
        List<Word> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        String[] words = setUnderscores(in.nextLine().split(" "));

        outer:
        for (String word : words) {
            for (Word w : list) {
                if (w.getWord().equals(word)) {
                    w.increaseQuantity();
                    continue outer;
                }
            }
            list.add(new Word(word));
        }

        in.close();
        return list;
    }

    private static String[] setUnderscores(String[] words) {
        int maxLength = getMaxLength(words);
        for (int i = 0; i < words.length; ++i) {
            words[i] = getUnderscores(maxLength - words[i].length()) + words[i];
        }
        return words;
    }

    private static int getMaxLength(String[] words) {
        int maxLength = words[0].length();
        for (int i = 1; i < words.length; ++i) {
            if (words[i].length() > maxLength) {
                maxLength = words[i].length();
            }
        }
        return maxLength;
    }

    private static String getUnderscores(int n) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; ++i) {
            sb.append("_");
        }
        return new String(sb);
    }

    static void printList(List<Word> list) {
        int maxQuantity = list.get(list.size() - 1).getQuantity();
        for (Word w: list) {
            System.out.print(w.getWord() + " ");
            for (int i = 0; i < (Math.round((double)w.getQuantity() * NUM_OF_DOTS / maxQuantity)); ++i) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}