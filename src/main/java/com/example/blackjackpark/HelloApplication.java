package com.example.blackjackpark;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {
    public static Label label2 = new Label("");
    BlackJack bj = new BlackJack();

    public static Stage window;
    Scene scene1, scene2, scene3;
    Button button, button2, hit, stand;
    TextField input, balance;
    TextField player_hand, dealer_hand, outcome;
    int player_balance=100;
    int bet=0;
    @Override
    public void start(Stage stage) throws IOException {
        window=stage;
        Label label1 = new Label("Welcome to BlackJackPark. Have fun!");


        button = new Button();
        button.setText("Start Game");

        button.setOnAction(this); //handle method is in "this" class
        //button.setOnAction(e -> System.out.println("sdf")); alt way for newer java

        button2=new Button();
        button2.setText("Bet");
        button2.setOnAction(this);

        input = new TextField();
        balance= new TextField();
        balance.setText("Player balance: "+ player_balance);
        balance.setEditable(false);
        //label2.setText(""); ? needed

        VBox layout = new VBox();
        layout.setPadding(new Insets(5, 20, 20, 5));
        layout.getChildren().addAll(label1, button);

        scene1 = new Scene(layout, 320, 240);
        window.setTitle("BlackJackPark ver1.");
        window.setScene(scene1);
        window.show();

        VBox layout2 = new VBox();
        layout2.getChildren().addAll(input,button2, label2,balance);
        scene2 = new Scene(layout2,320,240);

        player_hand= new TextField();
        player_hand.setEditable(false);
        dealer_hand= new TextField();
        dealer_hand.setEditable(false);
        outcome = new TextField();
        outcome.setEditable(false);
        hit = new Button();
        hit.setText("Hit");
        hit.setOnAction(this);
        stand = new Button();
        stand.setText("Stand");
        stand.setOnAction(this);

        VBox layout3= new VBox();
        layout3.getChildren().addAll(dealer_hand,player_hand,hit,stand,outcome);
        scene3 = new Scene(layout3, 320, 240);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()==button){
            window.setScene(scene2);
        }
        else if (actionEvent.getSource()==button2){
            try {
                int nput = Integer.parseInt(input.getText());
                if (nput<0){
                    label2.setText("Bet is less than 0");
                } else {
                    bet = nput;
                    window.setScene(scene3);
                }
            } catch (NumberFormatException e){
                label2.setText("Bet is not a Number");
            }
            //inp1.checkAnswer(input.getText());
        } else if (actionEvent.getSource()==hit){

        } else if (actionEvent.getSource()==stand){

        }
    }
    public static void main(String[] args) {
        launch();
    }
}