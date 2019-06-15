package org.dimigo.gui.Stack;

public class SearchType {
    private String text;
    private String value;

    public SearchType(String text, String value){
        this.text = text;
        this.value = value;
    }

    public SearchType(String text){
        this.text = text;
        this.value = text;
    }


    public String getValue(){
        return value;
    }

    public String toString(){
        return text;
    }


}
