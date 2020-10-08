package main.assignment2.impl;

public class Main {
    public static void main(String[] args) {
 /*       MapEntryImpl[] lol = new MapEntryImpl[10];
        lol[0] = new MapEntryImpl(5,4, true);
        MapEntryImpl a = lol[0];
        System.out.println(a.getValue());
        MapEntryImpl map = lol[0];
        map.setValue(19);
        System.out.println(a.getValue());*/

        MyHashTableImpl hash = new MyHashTableImpl(0.98);
        hash.insert(4, 1);
        hash.insert(3, 2);
        //System.out.println(hash);
        hash.insert(2, 15);
        // System.out.println(hash);
        hash.insert(15, 90);
        hash.insert(5, 909);
        hash.insert(26, 2323);
        // System.out.println(hash);
        hash.delete(4);
        //hash.delete(9);
        // System.out.println(hash);
        hash.insert(4, 78);
        hash.insert(60, 600);
        hash.insert(82, 780);
        hash.insert(42, 75558);
        hash.insert(49, 902);
        hash.delete(49);
        System.out.println(hash);
        System.out.println(hash.contains(49));


    }
}
