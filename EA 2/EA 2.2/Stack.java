public class Stack {
    private static class Entry {
        String value;
        Entry next;

        Entry(String value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

    private Entry head = new Entry("", null);
    private int size;

    public Stack() {
        head.next = head;
    }

    private void checkValidity() {
        if (size == 0)
            throw new java.util.NoSuchElementException();
    }

    public void push(String s) {
        Entry newEntry = new Entry(s, head);
        head = newEntry;
        size++;
    }

    public String peek() {
        checkValidity();

        return head.value;
    }

    public String pop() {
        checkValidity();

        Entry popped = head;
        head = popped.next;
        size--;
        return popped.value;
    }

    public String toString() {
        String out = "[";
        Entry curr = head;
        for (int i = 0; i < size; i++) {
            out = i + 1 == size ? out + curr.value : out + curr.value + ", ";
            curr = curr.next;
        }

        return out + "]";
    }
}