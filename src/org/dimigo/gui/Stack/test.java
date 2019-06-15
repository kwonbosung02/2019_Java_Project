package org.dimigo.gui.Stack;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class test {
    public static void main(String[] args) {
        int cnt = 1;
        SearchTitle t = new SearchTitle( "java","nullpointer" );
        for(Element i : t.SearchYourTitle("java","nullpointer"  )){
            if(i.attr("title").equals( "" )){

            }
            else {
                System.out.println( cnt + ". "+"https://stackoverflow.com" + i.attr( "href" ) );
                cnt++;
            }
        }
        }

    }

