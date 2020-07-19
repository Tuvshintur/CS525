package customers;

import java.util.Iterator;
import java.util.List;

public class SkipIterator<T> implements Iterator<T> {

    private List<T> list;
    private int position;

    public SkipIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position+2 < list.size();
    }

    @Override
    public T next() {
        T nextElement = list.get(position);
        this.position +=2;
        return nextElement;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
