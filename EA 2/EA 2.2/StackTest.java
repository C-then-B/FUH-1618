import java.util.NoSuchElementException;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        try {
            stack.peek();
        } catch (NoSuchElementException e) {
            System.out.println("obj.peek() exception caught: " + e);
        }
        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("obj.pop() exception caught: " + e);
        }
        System.out.println();

        int nElements = 5;
        for (int i = 1; i < nElements + 1; i++) {
            stack.push("Element " + i);
            System.out.println("Element " + i + " hinzugefügt.");
        }
        System.out.println("Elemente im Stack, nach Reihenfolge der Entnahme: -> " + stack.toString());
        System.out.println();

        for (int i = 1; i < nElements + 1; i++) {
            System.out.println(stack.pop() + " entfernt.");
            System.out.println("Neue Reihenfolge im Stack: -> " + stack.toString());
            System.out.println();
        }

        System.out.println("Der Stack sollte leer sein: " + stack.toString().equals(new Stack().toString()));

        // null tests again for good measure
        try {
            stack.peek();
        } catch (NoSuchElementException e) {
            System.out.println("obj.peek() exception caught: " + e);
        }
        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("obj.pop() exception caught: " + e);
        }
    }
}
