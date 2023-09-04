package collection;

public class Iter implements Container {
    public String[] names = {"Rahul", "Raj", "Sonam", "Ritik"};

    @Override
    public Iterator getIterator() {
        return new NameIter();
    }

    private class NameIter implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }


    }
}