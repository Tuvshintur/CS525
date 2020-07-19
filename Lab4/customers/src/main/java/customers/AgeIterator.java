package customers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AgeIterator<T> implements Iterator<T> {

    private List<T> list;
    private int position;
    public AgeIterator(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public T next() {
        return list.get(position++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
