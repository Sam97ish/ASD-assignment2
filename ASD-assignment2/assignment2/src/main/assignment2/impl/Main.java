package main.assignment2.impl;

public class Main {
    public static void main(String[] args) {
        MapEntryImpl[] lol = new MapEntryImpl[10];
        lol[0] = new MapEntryImpl(5,4, true);
        MapEntryImpl a = lol[0];
        System.out.println(a.getValue());
        MapEntryImpl map = lol[0];
        map.setValue(19);
        System.out.println(a.getValue());
    }
}
