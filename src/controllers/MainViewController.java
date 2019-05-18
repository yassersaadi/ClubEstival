package controllers;

import Utils.Constants;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXToolbar;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private StackPane maninStackPane;
    @FXML
    private JFXToolbar toolbar;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private StackPane mainPane;

    public static AnchorPane temporaryPane;

    public static StackPane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pane = mainPane;
        temporaryPane = contentPane;
        initDrawer();
    }

    private void initDrawer(){
        try {
            VBox menu = FXMLLoader.load(getClass().getResource(Constants.SIDEMENUVIEW));
            //check if admin SIDEMENUADMIN
            //else sideMenu user
            drawer.setSidePane(menu);
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition((hamburger));
            transition.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED,(Event event) -> {
                transition.setRate(transition.getRate() * -1);
                transition.play();
                if(drawer.isClosed()){
                    drawer.open();
                }else{
                    drawer.close();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
