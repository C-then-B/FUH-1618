public class Fraction {
    private int numerator, denominator;

    public static void main(String[] args) {
        Fraction a = new Fraction(2, 4);
        Fraction b = new Fraction(3, 3);
        Fraction c = a.getProductOfThisAnd(b);

        System.out.println(c.toString());

        // Other tests
        System.out.println(new Fraction(2, 4).getProductOfThisAnd(new Fraction(3, 3)).toString().equals("1/2"));
        System.out.println(new Fraction(5, 10).getProductOfThisAnd(new Fraction(-2, 10)).toString().equals("-1/10"));
        // ..
    }

    public Fraction(int p, int q) {
        if (q == 0)
            throw new IllegalArgumentException("I should study math instead of procrastinating.");

        numerator = p;
        denominator = q;
    }

    public Fraction getProductOfThisAnd(Fraction other) {
        return simplifyFrac(numerator * other.numerator, denominator * other.denominator);

        // Alternative, ohne kürzen!
        // return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    // #region OPTIONAL: Kürzt den Bruch
    private Fraction simplifyFrac(int p, int q) {
        int d = findGcd(p, q);
        d = Math.max(d, -d); // oops
        return new Fraction(p / d, q / d);
    }

    private int findGcd(int p, int q) {
        return q == 0 ? p : findGcd(q, p % q);
    }
    // #endregion
}