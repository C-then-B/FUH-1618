public class WunderTest {
    public static void main(String[] args) {
        // Besser so als static
        WunderTest obj = new WunderTest();

        System.out.println("a.)");
        // Assert
        System.out.println(obj.wunder(5) == 5);
        System.out.println(obj.wunder(22) == 15);
        System.out.println(obj.wunder(1) == 0);

        System.out.println("b.)");
        int max = 1;
        int steps = 0;
        for (int i = max; i < 101; i++) {
            // Zwischenspeichern um doppelte Berechnung zu vermeiden
            int compare = obj.wunder(i);
            if (compare > steps) {
                max = i;
                steps = compare;
            }
        }
        System.out.println("Die Zahl " + max + " benötigt die meisten Schritte: " + steps);

        System.out.println("c.)");
        // Assert against wunder()
        System.out.println(obj.wunderRek(5) == obj.wunder(5));
        System.out.println(obj.wunderRek(22) == obj.wunder(22));
        System.out.println(obj.wunderRek(1) == obj.wunder(1));
    }

    private int wunder(int n) {
        CheckArgRange(n);

        int steps = 0;
        while (n != 1) {
            n = n % 2 == 0 ? n / 2 : n * 3 + 1;
            steps++;
        }
        return steps;
    }

    private int wunderRek(int n) {
        CheckArgRange(n);

        if (n == 1)
            return 0;

        n = n % 2 == 0 ? n / 2 : n * 3 + 1;
        return 1 + wunderRek(n);
    }

    private void CheckArgRange(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Nur natürliche Zahlen!");
    }
}