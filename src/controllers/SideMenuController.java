package controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXToolbar;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SideMenuController implements Initializable {


    //Methods that executes on clickButtons Event
    @FXML
    private void addImmobilier(ActionEvent event){
        //Add page immobilier
        switchPane("/views/addImmobilier.fxml ");
    }
    @FXML
    private void updateImmobilier(ActionEvent event){
        //Add page update
        switchPane("/views/updateImmobilier.fxml");
    }
    @FXML
    private void deleteImmobilier(ActionEvent event){
        //Add page delete
    }
    @FXML
    private void logOut(ActionEvent event){
        //Add page logOut
    }
    @FXML
    private void exit(ActionEvent event){
        //Add page exit
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void switchPane(String pane){
        //Clearing the temporaryPane
        try {
            MainViewController.temporaryPane.getChildren().clear();
            StackPane pane2 = FXMLLoader.load(getClass().getResource(pane));
            ObservableList<Node> elements = pane2.getChildren();
            MainViewController.temporaryPane.getChildren().setAll(elements);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
