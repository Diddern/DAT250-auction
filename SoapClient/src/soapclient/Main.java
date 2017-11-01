/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapclient;

import client.Auction;
import client.AuctionServerImpl;
import client.AuctionServerImplService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author ady
 */
public class Main extends Application{

    Stage primaryStage;
    AuctionServerImpl server;
    
    public static void main(String[] args) {        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.primaryStage = primaryStage;
        
        showIndex();
        
    }
    
    private void showIndex(){

        Pane root = new Pane();
        VBox box = new VBox();
        
        
        root.getChildren().addAll(box);
               
        AuctionServerImplService service = new AuctionServerImplService();
        server = service.getAuctionServerImplPort();
        for (Auction a : server.getActiveAuctions()) {
            box.getChildren().addAll(new Text(
                    "ID: " + a.getId() + "\n" + 
                    "Name: " + a.getProductName() + "\n"+
                    "Description: "+ a.getDescription()+ "\n"+
                    "Minimum price: " + a.getMinPrice() + "\n" + 
                    "Time left: " + a.getUnixEndTime() + "\n"
            ));
            
            Button bid = new Button("Bid");
            
            box.getChildren().addAll(bid);
            bid.setOnAction((ActionEvent event) -> {
                showBid(a.getId());
            });
            
        }

        
        
        Scene scene = new Scene(root,500,500);
        
        primaryStage.setTitle("FINT.NO");
        primaryStage.setScene(scene);
        primaryStage.show();
                
    }

    private void showBid(Long id) {
        
        
        Pane root = new Pane();
        VBox box = new VBox();
        Alert alert = new Alert(AlertType.INFORMATION);
        
        Text userIDText = new Text("User ID");
        Text bidText = new Text("Bid");
        TextField userID = new TextField();
        TextField bid = new TextField();
        Button accept = new Button("Accept bid");
        accept.setOnAction((ActionEvent event) -> {
            alert.setContentText(server.bidForAuction(Long.valueOf(bid.getText()), Long.valueOf(userID.getText()), id));
            alert.showAndWait();
            showIndex();
        });
        
        root.getChildren().add(box);
        box.getChildren().addAll(userIDText,userID,bidText,bid,accept);
        
        Scene scene = new Scene(root,500,500);
        
        primaryStage.setTitle("FINT.NO");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
    
}
