package gad.doublehashing;

public final class Main {
    private Main() {

    }

    public static void main(String[] args) {
        DoubleHashTable<Integer, String> table = new DoubleHashTable<>(17, new IntHashableFactory());

        table.insert(42, "Hallo");
        table.insert(69, "Welt");

        System.out.println(table.find(42));
    }
}
