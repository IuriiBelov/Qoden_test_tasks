package task1;

public class HashTable {
    private int N;

    public Array<ListNode<Integer>> values;

    public HashTable(int n) {
        N = n;
        values = new Array<>(N);
    }

    public void insert(int newValue) {
        int hashcode = newValue % N;
        try {
            ListNode<Integer> value = values.get(hashcode);
            if (value == null) {
                try {
                    values.add(new ListNode<>(newValue), hashcode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                value.insert(newValue);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
