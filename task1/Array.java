package task1;

public class Array<T> {
    private int capacity;
    private int lastElemIndex;

    private T[] data;

    public Array(int capacity) {
        this.data = (T[])(new Object[capacity]);
        this.capacity = capacity;
    }

    public void add(T elem, int position) throws Exception {
        if (position < 0 || position >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        if (data[position] != null) {
            throw new Exception("The position is already occupied");
        }
        data[position] = elem;
    }

    public T get(int position) throws IndexOutOfBoundsException {
        if (position < 0 || position >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        return data[position];
    }

    public int getCapacity() {
        return capacity;
    }
}
