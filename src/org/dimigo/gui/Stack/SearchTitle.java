package org.dimigo.gui.Stack;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import java.io.IOException;


public class SearchTitle {
    protected String key;
    protected String text;

    protected Document p;
    protected Elements ele;
    protected Elements ele_link;
    public SearchTitle(String key, String text)
    {
        this.key = key;
        this.text = text;
    }

    public Elements SearchYourTitle(String key, String text)
    {
        try{
            p = Jsoup.connect( "https://stackoverflow.com/search?q="+key+"+"+text ).get();

            ele = p.select( "h3" ).select( "a" );


        }catch(IOException e){
            e.printStackTrace();

    }

        return ele;
    }


}

