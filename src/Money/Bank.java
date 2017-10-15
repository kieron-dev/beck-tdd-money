package Money;

import java.util.Hashtable;

public class Bank {
    private Hashtable<Pair, Integer> rates = new Hashtable<>();

    public Money reduce(Expression expr, String currency) {
        return expr.reduce(this, currency);
    }

    int rate(String from, String to) {
        if (from.equals(to)) return 1;
        Integer rate = rates.get(new Pair(from, to));
        return rate.intValue();
    }

    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), new Integer(rate));
    }

    private class Pair {
        private String from;
        private String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            return other.to.equals(to) && other.from.equals(from);
        }

        public int hashCode() {
            return 0;
        }
    }
}
