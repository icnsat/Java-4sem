package pract_3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class SyhchronizedSet<T> implements Set<T> {
    private Set<T> set = new HashSet<>();

    @Override
    public synchronized boolean add(T element){
        return set.add(element);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public synchronized int size() {
        return set.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return set.toArray();
    }

    @Override
    public synchronized <T1> T1[] toArray(T1[] a) {
        return set.toArray(a);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends T> c) {
        return set.addAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    public synchronized void clear() {
        set.clear();
    }

}
