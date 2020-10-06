package main.assignment2.impl;

import main.assignment2.ArrayWithPublishedSize;
import main.assignment2.MyMap;

public class MyHashTableImpl<K, V> implements MyMap<K, V>, ArrayWithPublishedSize {

    private MapEntryImpl<K, V>[] array;
    private double MAXIMUM_ALLOWED_LOAD_FACTOR; // This is the load factor that the table can never exceed. However, it
						// may happen that an insertion fails before reaching this load factor.
						// the internal rehash() function should be called when either the load
						// factor is higher than a limit passed as an argument in the
						// constructor of MyHashTable or when an insertion fails (this is, when
						// an insertion does not find an empty cell

    public MyHashTableImpl(double MAX_LOAD_FACTOR) {
	MAXIMUM_ALLOWED_LOAD_FACTOR = MAX_LOAD_FACTOR;
	// Here you need to create the array. It is not possible to create a new array
	// of generic type in Java. You can use any of the methods to simulate the
	// generic-like array; this assignment does not restrict the method to use for that. 
    }

    @Override
    public int getLengthOfArray() {
	return array.length;
    }

    @Override
    public void insert(K key, V value) {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(K key) {
	// TODO Auto-generated method stub

    }

    @Override
    public V contains(K key) {
	// TODO Auto-generated method stub
	return null;
    }

}
