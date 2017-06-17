package com.kapil.Anagram;

/**
 * Created by kapilsharma on 17/06/17.
 */
public class AnagramDTO implements Cloneable, Comparable<AnagramDTO> {
    private int index;
    private String data;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public AnagramDTO() {
    }

    public AnagramDTO(int index, String data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public int compareTo(AnagramDTO otherObject) {
        return data.compareTo(otherObject.data);
    }

    @Override
    protected AnagramDTO clone() {
        try {
            return (AnagramDTO) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}


