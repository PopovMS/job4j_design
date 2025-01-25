package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {

    }

    public final V get(K key) {
        if (!cache.containsKey(key)) {
            cache.put(key, new SoftReference(load(key)));
        }
        V v = (V) cache.get(key);
        return v;
    }

    protected abstract V load(K key);

}