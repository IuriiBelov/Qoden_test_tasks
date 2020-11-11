package task1;

import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        HashTable hashTable = initHashTable();
        printHashTable(hashTable);
    }

    private static HashTable initHashTable() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashTable hashTable = new HashTable(n);
        String[] values = in.nextLine().split(" ");
        in.close();

        for (String value: values) {
            hashTable.insert(Integer.parseInt(value));
        }

        return hashTable;
    }

    private static void printHashTable(HashTable hashTable) {
        for (int i = 0; i < hashTable.values.getCapacity(); ++i) {
            System.out.print(i + ": ");
            ListNode<Integer> node = hashTable.values.get(i);
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
