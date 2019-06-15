package org.dimigo.gui.Stack;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Search {
    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect( "https://stackoverflow.com/search?q=nullpointer" ).get();
            doc.select("a");
            Elements contents;
            contents = doc.select( "h3" ).select( "a" );
            int cnt = 1;
            //contents.attr("title");
            for (Element i : contents){
                if(i.attr("title").equals( "" )){

                }
                else {
                    System.out.println( cnt + ". " + i.attr( "title" ) );
                    cnt++;
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}