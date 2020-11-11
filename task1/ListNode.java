package task1;

public class ListNode<T> {
    T value;
    ListNode next;

    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }

    public void insert(T newValue) {
        ListNode newNode = new ListNode(newValue);
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }
}
