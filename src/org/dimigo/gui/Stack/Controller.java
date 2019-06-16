package org.dimigo.gui.Stack;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import org.jsoup.nodes.Element;

import java.net.URL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable {
    @FXML
    ComboBox<SearchType> cbSearch;
    @FXML
    TextField txtSearch;
    @FXML
    ListView<String> list = new ListView<String>();
    @FXML
    Label time1;
    @FXML
    WebView webView;
    @FXML
    TextArea givetext;
    @FXML
    TextArea returntext;


    public int cnt = 1;
    private int minute, hour, second;

    Date dt = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss", Locale.KOREA);
    private String prev_date = sdf.format(dt).toString();

    HashMap<String,String> map = new HashMap<String, String>( );
    @Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<SearchType> comboItems = FXCollections.observableArrayList();
        ObservableList<String> listItmes = FXCollections.observableArrayList();


        list.setItems( listItmes );
        comboItems.add(new SearchType("asp"));
        comboItems.add(new SearchType("assembly"));
        comboItems.add(new SearchType("bash"));
        comboItems.add(new SearchType("basic"));
        comboItems.add(new SearchType("CQL"));
        comboItems.add(new SearchType("C","c" ));
        comboItems.add(new SearchType("C#","c#" ));
        comboItems.add(new SearchType("C++","c++" ));
        comboItems.add(new SearchType("cython","cython" ));
        comboItems.add(new SearchType("dart","c++" ));
        comboItems.add(new SearchType("doker"));
        comboItems.add(new SearchType("django"));
        comboItems.add(new SearchType("ejs"));
        comboItems.add(new SearchType("go"));
        comboItems.add(new SearchType("haskell"));
        comboItems.add(new SearchType("jade"));
        comboItems.add(new SearchType("java" ));
        comboItems.add(new SearchType("javascript"));
        comboItems.add(new SearchType("kotlin"));
        comboItems.add(new SearchType("lisp"));
        comboItems.add(new SearchType("lua"));
        comboItems.add(new SearchType("livescript"));
        comboItems.add(new SearchType("matlab"));
        comboItems.add(new SearchType("mysql"));
        comboItems.add(new SearchType("nginx"));
        comboItems.add(new SearchType("objc"));
        comboItems.add(new SearchType("objective-c"));
        comboItems.add(new SearchType("pascal"));
        comboItems.add(new SearchType("python"));
        comboItems.add(new SearchType("perl"));
        comboItems.add(new SearchType("PHP"));
        comboItems.add(new SearchType("R"));
        comboItems.add(new SearchType("ruby"));
        comboItems.add(new SearchType("react"));
        comboItems.add(new SearchType("scala"));
        comboItems.add(new SearchType("sql"));
        comboItems.add(new SearchType("vue"));
        comboItems.add(new SearchType("vbscript"));
        comboItems.add(new SearchType("none",""));
        cbSearch.setItems( comboItems );

        Timeline clock = new Timeline(new KeyFrame( Duration.ZERO, e -> {
            Calendar cal = Calendar.getInstance(  );
            second = cal.get(Calendar.SECOND);
            minute = cal.get(Calendar.MINUTE);
            hour = cal.get(Calendar.HOUR);
            try {
                Date dt_now = sdf.parse( hour + ":" + minute + ":" + second );
                Date dt_prev = sdf.parse(prev_date);
                long diff = dt_now.getTime() - dt_prev.getTime();
                //time1.setText(diff+"");
                long sec = (diff / 1000) % 60;
                long min = (diff / (60 * 1000) % 60);
                long hou = (diff / (60 * 1000 *1000)) ;
                //if(min >= 60)min = 0;

                //if(sec >= 60)sec = 0;

               time1.setText( "Your Coding time "+String.format("%02d",hou)+":"+String.format("%02d",min)+":"+String.format("%02d",sec));
            }catch (ParseException pe){

            }

            //time1.setText("coding Time "+ hour+":"+(minute)+":"+second );

        } ),
                new KeyFrame( Duration.seconds( 1 ) )
        );
        clock.setCycleCount( Animation.INDEFINITE );
        clock.play();
    }

    public void hadleSearchAction(ActionEvent event){
        String type;
        SearchType item = cbSearch.getSelectionModel().getSelectedItem();
        try{
            item.getValue();
            type = item.getValue();
        }catch (NullPointerException npe){
            type ="";
        }

        String text = txtSearch.getText();

        System.out.printf("%s , %s \n",type, text);
        SearchTitle tit = new SearchTitle( type,text );
        //-------------------------------------------------------------
        for (Element i : tit.SearchYourTitle( type, text )){
            if(i.attr("title").equals( "" )){

            }
            else {
                System.out.println( cnt + ". " + i.attr( "title" ) );
                System.out.println( cnt + ". " +"https://stackoverflow.com"+ i.attr( "href" ) );

                list.getItems().add( cnt + "."+ i.attr( "title") );
                map.put(cnt + "."+i.attr( "title" ),"https://stackoverflow.com"+ i.attr( "href" ));
                cnt++;

            }
        }
        //-------------------------------------------------------------


        list.getItems().add("=========================");
        list.setOnMouseClicked( (MouseEvent) -> {
            Object obj = list.getSelectionModel().getSelectedItem();

            System.out.println(obj);
            System.out.println(map.get(obj));

            WebEngine webEngine = webView.getEngine();
            webEngine.load(map.get(obj));

        } );

       // lbl.setText( "hejerh" );

    }
    public void handleTranslate(ActionEvent event){
        String give_text = givetext.getText();
        //System.out.println(give_text);
        String a = TranslatorText.giveText( give_text );
        String b ="";
        try {
            b = String.valueOf( TranslatorText.show( a ));
        }catch (Exception e){

        }
        returntext.setText( b );

    }



}