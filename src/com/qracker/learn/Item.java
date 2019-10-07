package com.qracker.learn;


import java.util.Objects;

public class Item implements Comparable<Item> {

    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber){
        this.description = aDescription;
        this.partNumber = aPartNumber;
    }

    public String getDescription(){
        return description;
    }

    public String toString() {
        return "[description=" + description + ",partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject){
        if(this == otherObject)
            return true;
        if(otherObject == null)
            return false;
        if(this.getClass() != otherObject.getClass())
            return false;
        Item other = (Item) otherObject;
        return this.description.equals(other.description) && partNumber == other.partNumber;
    }

    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(this.partNumber,o.partNumber);
        return diff !=0 ? diff : description.compareTo(o.description);
    }
}
