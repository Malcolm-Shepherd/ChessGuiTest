package com.example.chessgui;

import core.classes.*;
import core.enums.Color;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.text.ParseException;
import java.util.Scanner;

public class ChessConroller {
    Scanner kb = new Scanner(System.in);
    core.classes.Board b = new Board();
    Move m;
    String input;

    @FXML private TextField moveInput;
    @FXML private Button moveButton;
    @FXML private GridPane BoardPane;
    @FXML private Button button;
    @FXML private ImageView a1;
    @FXML private ImageView a2;
    @FXML private ImageView a3;
    @FXML private ImageView a4;
    @FXML private ImageView a5;
    @FXML private ImageView a6;
    @FXML private ImageView a7;
    @FXML private ImageView a8;
    @FXML private ImageView b1;
    @FXML private ImageView b2;
    @FXML private ImageView b3;
    @FXML private ImageView b4;
    @FXML private ImageView b5;
    @FXML private ImageView b6;
    @FXML private ImageView b7;
    @FXML private ImageView b8;
    @FXML private ImageView c1;
    @FXML private ImageView c2;
    @FXML private ImageView c3;
    @FXML private ImageView c4;
    @FXML private ImageView c5;
    @FXML private ImageView c6;
    @FXML private ImageView c7;
    @FXML private ImageView c8;
    @FXML private ImageView d1;
    @FXML private ImageView d2;
    @FXML private ImageView d3;
    @FXML private ImageView d4;
    @FXML private ImageView d5;
    @FXML private ImageView d6;
    @FXML private ImageView d7;
    @FXML private ImageView d8;
    @FXML private ImageView e1;
    @FXML private ImageView e2;
    @FXML private ImageView e3;
    @FXML private ImageView e4;
    @FXML private ImageView e5;
    @FXML private ImageView e6;
    @FXML private ImageView e7;
    @FXML private ImageView e8;
    @FXML private ImageView f1;
    @FXML private ImageView f2;
    @FXML private ImageView f3;
    @FXML private ImageView f4;
    @FXML private ImageView f5;
    @FXML private ImageView f6;
    @FXML private ImageView f7;
    @FXML private ImageView f8;
    @FXML private ImageView g1;
    @FXML private ImageView g2;
    @FXML private ImageView g3;
    @FXML private ImageView g4;
    @FXML private ImageView g5;
    @FXML private ImageView g6;
    @FXML private ImageView g7;
    @FXML private ImageView g8;
    @FXML private ImageView h1;
    @FXML private ImageView h2;
    @FXML private ImageView h3;
    @FXML private ImageView h4;
    @FXML private ImageView h5;
    @FXML private ImageView h6;
    @FXML private ImageView h7;
    @FXML private ImageView h8;
    private ImageView[][] images = new ImageView[8][8];

    protected void imageArraySetup(){
        Integer row = 0;
        Integer col = 0;
        int count = 0;
        for(Node n : BoardPane.getChildren()){
            if(count < 64) {
                row = BoardPane.getRowIndex(n);
                col = BoardPane.getColumnIndex(n);
                if (row == null) row = 0;
                if (col == null) col = 0;
                images[7-row][col] = (ImageView) n;
                System.out.println(n.toString()+ ": " + n.getId());
                count++;
            }
        }
    }

    @FXML
    protected void sendInput(){
        //System.out.println(b.toString());
        input = moveInput.getText().trim();
        imageArraySetup();
        moveInput.setText("");
        try {
            m = Move.parse(input);
        } catch (ParseException e) {
            System.out.println("Could not parse notation, please try again (q to quit).\n");
        }
        if (!b.move(m)) {
            System.out.println("Could not move the peice, please try again (q to quit).\n");
        }
        updateBoard();
        System.out.println(b.toString());
    }

    @FXML
    protected void updateBoard(){
        BasePiece[][] pieces = b.getBoard();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                if(pieces[7-i][j] == null){
                    images[i][j].setImage(null);
                }
                else{
                    String color;
                    if(pieces[7-i][j].getColor() == Color.BLACK){
                        color = "b";
                    }
                    else color = "w";
                    if(pieces[7-i][j] instanceof King){
                        images[i][j].setImage(new Image("images/" + color + "King.png"));
                    }
                    else if(pieces[7-i][j] instanceof Queen){
                        images[i][j].setImage(new Image("images/" + color + "Queen.png"));
                    }
                    else if(pieces[7-i][j] instanceof Bishop){
                        images[i][j].setImage(new Image("images/" + color + "Bishop.png"));
                    }
                    else if(pieces[7-i][j] instanceof Knight){
                        images[i][j].setImage(new Image("images/" + color + "Knight.png"));
                    }
                    else if(pieces[7-i][j] instanceof Rook){
                        images[i][j].setImage(new Image("images/" + color + "Rook.png"));
                    }
                }
            }
        }
    }
}