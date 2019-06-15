module ProjectFX {
    requires  javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires jsoup;
    requires javafx.web;
    opens org.dimigo.gui.Stack;


}