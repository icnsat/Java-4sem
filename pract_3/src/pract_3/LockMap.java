package pract_3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMap<K,V> implements Map<K, V> {
    private Map<K,V> map = new HashMap<>();
    private static final Lock lock = new ReentrantLock();
    @Override
    public int size() {
        lock.lock();
        try{
            return map.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try{
            return map.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        try{
            return map.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        try{
            return map.containsValue(value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        lock.lock();
        try{
            return map.get(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        try{
            return map.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        try{
            return map.remove(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        map.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        map.clear();
        lock.unlock();
    }

    @Override
    public Set<K> keySet() {
        lock.lock();
        try{
            return map.keySet();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Collection<V> values() {
        lock.lock();
        try{
            return map.values();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        lock.lock();
        try{
            return map.entrySet();
        } finally {
            lock.unlock();
        }
    }
}
