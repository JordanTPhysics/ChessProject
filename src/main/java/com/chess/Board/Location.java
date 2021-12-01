package com.chess.Board;

import java.util.Objects;

public class Location {

    private final File file;
    private final Integer rank;


    public Location(File file, int rank) {
        this.file = file;
        this.rank = rank;
    }
    public int getRank(){
        return rank;
    }
    public File getFile(){
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return rank == location.rank && file == location.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
