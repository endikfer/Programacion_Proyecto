package gui;

import java.util.Comparator;

import domain.Cancion;

public class ComparadorDura implements Comparator<Cancion> {
    @Override
    public int compare(Cancion cancion1, Cancion cancion2) {
        return Integer.compare(cancion1.getDuration(), cancion2.getDuration());
    }
}