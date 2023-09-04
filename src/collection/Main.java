package collection;

public class Main {
    public static void main(String[] args) {
        Iter iter = new Iter();
        Iterator iterator = iter.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
