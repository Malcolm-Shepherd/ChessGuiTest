package com.example.chessgui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ChessConroller {
    @FXML
    private Label welcomeText;
    @FXML private GridPane Board;
    @FXML private Button button;
    @FXML private ImageView wPawn4;
    @FXML private ImageView wRook1;
    @FXML private ImageView wKnight1;
    @FXML private ImageView wBishop1;
    @FXML private ImageView wKing;
    @FXML private ImageView wQueen;
    @FXML private ImageView selectedPiece;

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
        selectedPiece = piece;

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
        /*System.out.println(Board.getColumnIndex(knight));
        System.out.println(Board.getRowIndex(knight));*/
        createMoveButton(Board.getColumnIndex(knight)+1, Board.getRowIndex(knight)-2);
        /*Board.setColumnIndex(knight, Board.getColumnIndex(knight)-1);
        Board.setRowIndex(knight, Board.getRowIndex(knight)-2);*/
    }

    private void createMoveButton(int col, int row){
        Button moveButton = new Button();
        moveButton.setMinHeight(50);
        moveButton.setMinWidth(50);
        moveButton.setOnMouseClicked(movePiece());
        Board.add(moveButton, col, row);
    }

    @FXML
    private EventHandler movePiece(){
        Board.setColumnIndex(selectedPiece, Board.getColumnIndex(selectedPiece)+1);
        Board.setRowIndex(selectedPiece, Board.getRowIndex(selectedPiece)-2);
        return null;
    }
}