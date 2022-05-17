package com.example.chessgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ChessConroller {
    @FXML
    private Label welcomeText;
    @FXML private ImageView wPawn4;
    @FXML private ImageView wRook1;
    @FXML private ImageView wKnight1;
    @FXML private ImageView wBishop1;
    @FXML private ImageView wKing;
    @FXML private ImageView wQueen;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void selectWP4(){
        selectPiece(wPawn4);
    }
    @FXML
    protected void selectWQ(){
        selectPiece(wQueen);
    }
    @FXML
    protected void selectWK(){
        selectPiece(wKing);
    }
    @FXML
    protected void selectWB1(){
        selectPiece(wBishop1);
    }
    @FXML
    protected void selectWKn1(){
        selectPiece(wKnight1);
    }
    @FXML
    protected void selectWR1(){
        selectPiece(wRook1);
    }

    @FXML
    protected void selectPiece(ImageView piece){
        /*System.out.println(piece.getImage());
        System.out.println(piece.getImage().getUrl());
        System.out.println(piece.getImage().getUrl().contains("wPawn.png"));*/

        if(piece.getImage().getUrl().contains("wPawn.png")){
            pawnMove(piece);
        }
        else if(piece.getImage().getUrl().contains("wKnight.png")){
            knightMove(piece);
        }
    }

    private void pawnMove(ImageView pawn){
        pawn.setY(pawn.getY() - 50);
    }
    private void knightMove(ImageView knight){
        knight.setY(knight.getY()-100);
        knight.setX(knight.getX()+50);
    }
}