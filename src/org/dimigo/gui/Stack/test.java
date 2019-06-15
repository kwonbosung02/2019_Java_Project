package org.dimigo.gui.Stack;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String a = "hello";
        TranslatorText.giveText( a );
        System.out.println(TranslatorText.giveText( a ));
        String b =  TranslatorText.giveText( a );
        try {
            System.out.println( TranslatorText.show( b ) );
        }
        catch (Exception e){

        }
    }
}
