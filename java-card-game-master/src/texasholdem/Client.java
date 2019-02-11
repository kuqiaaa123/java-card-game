package texasholdem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author jiach
 */
public class Client extends Application {

    @Override
    public void start(Stage primaryStage) { 
        BackGroundMusic bgm=new BackGroundMusic();
        SettingPane settingPane=new SettingPane(bgm);
        Scene settingScene=new Scene(settingPane,300,400);
        Stage settingStage=new Stage();
        settingStage.setScene(settingScene);
        settingStage.setTitle("Texas Hold'em");
        settingStage.setAlwaysOnTop(true);
        settingStage.setResizable(false);
        
        GamePane gamePane=new GamePane();
        Scene gameScene=new Scene(gamePane,1210,800);
        gameScene.setFill(Color.BLACK);
        primaryStage.setScene(gameScene);
        primaryStage.setTitle("Texas Hold'em");
        primaryStage.setMaxHeight(800);
        primaryStage.setMaxWidth(1210);
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(1210);
        //primaryStage.show();
        
        RegisterPane registerPane=new RegisterPane();
        Scene registerScene=new Scene(registerPane,335,230);
        Stage registerStage=new Stage();
        registerStage.setScene(registerScene);
        registerStage.setMaxHeight(230);
        registerStage.setMaxWidth(335);
        registerStage.setMinHeight(230);
        registerStage.setMinWidth(335);
        registerStage.setTitle("Texas Hold'em");
        //registerStage.show();
        
        LoginPane loginPane=new LoginPane();
        Scene loginScene=new Scene(loginPane,500,400);
        Stage loginStage=new Stage();
        loginStage.setScene(loginScene);
        loginScene.setFill(Color.BLACK);
        loginStage.setMaxHeight(400);
        loginStage.setMaxWidth(500);
        loginStage.setMinHeight(400);
        loginStage.setMinWidth(500);
        loginStage.setTitle("Texas Hold'em");
        loginStage.show();
        
        Card card1,card2;
        card1=new Card();
        card2=new Card();
        
        ChipImage c=new ChipImage(1);
        
        gamePane.getSelfHoleCards().getChildren().addAll(card1.getImage().getImageView(),card2.getImage().getImageView());
        gamePane.getLeftHoleCards().getChildren().addAll(new BackOfTheCardImage().getImageView(),new BackOfTheCardImage().getImageView());
        gamePane.getTopHoleCards().getChildren().addAll(new BackOfTheCardImage().getImageView(),new BackOfTheCardImage().getImageView());
        gamePane.getRightHoleCards().getChildren().addAll(new BackOfTheCardImage().getImageView(),new BackOfTheCardImage().getImageView());
        gamePane.getCommunityCards().getChildren().addAll(new Rectangle(72,98),new Rectangle(72,98),new Rectangle(72,98),new Rectangle(72,98),new Rectangle(72,98));
        
        PlayerBank a=new PlayerBank(1000);
        
        gamePane.addBlackChips(0,55);
        gamePane.addGreenChips(0,80);
        gamePane.addBlueChips(0,80);
        gamePane.addRedChips(0,80);
        gamePane.addWhiteChips(0,80);

        gamePane.addBlackChips(4,55);
        gamePane.addGreenChips(4,80);
        gamePane.addBlueChips(4,80);
        gamePane.addRedChips(4,80);
        gamePane.addWhiteChips(4,80);
        
        HoldemPlayer b=new HoldemPlayer();
        
        loginPane.getLoginBtm().setOnAction(e-> {loginStage.close(); primaryStage.show();});
        registerPane.getDoneBtm().setOnAction(e-> {registerStage.close(); loginStage.show();});
        settingPane.getDoneBtm().setOnAction(e->{settingStage.close();});
        gamePane.getSettingIcon().setOnMouseClicked(e-> {settingStage.show();});
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
