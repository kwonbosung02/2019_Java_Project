package org.dimigo.gui.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.jsoup.nodes.Element;

import java.net.URL;

import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ComboBox<SearchType> cbSearch;
    @FXML
    TextField txtSearch;
    @FXML
    ListView<String> list = new ListView<String>();

    public int cnt = 1;

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

    }

    public void hadleSearchAction(ActionEvent event){

        SearchType item = cbSearch.getSelectionModel().getSelectedItem();
        String type = item.getValue();
        String text = txtSearch.getText();

        System.out.printf("%s , %s \n",type, text);
        SearchTitle tit = new SearchTitle( type,text );

        for (Element i : tit.SearchYourTitle( type, text )){
            if(i.attr("title").equals( "" )){

            }
            else {
                System.out.println( cnt + ". " + i.attr( "title" ) );
                list.getItems().add( cnt + "."+ i.attr( "title") );
                cnt++;
            }
        }
        list.getItems().add("=========================");
        list.setOnMouseClicked( (MouseEvent) -> {
            Object obj = list.getSelectionModel().getSelectedItem();

            System.out.println(obj);
        } );
       // lbl.setText( "hejerh" );

    }



}