import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EventObject;
import javafx.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Labeled;
import javafx.stage.*;
import javafx.application.*;
import javafx.event.Event;

public class JavaImages extends Application {

    private Label investAmt;
    private Label numYears;
    private Label annIntRate;
    private Label futVal;
    private TextField text1;
    private TextField text2;
    private TextField text3;
    private TextField text4;
    private Button calculate;


    @Override
    public void start(Stage myStage) {

        myStage.setTitle ( "Future Value Calculator" );
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene ( rootNode, 300, 200 );

        //creates all the labels and text fields
        investAmt = new Label ( "Investment Amount: " );
        text1 = new TextField();
        numYears = new Label ( "Number of Years: " );
        text2 = new TextField();
        annIntRate = new Label ( "Annual Interest Rate: " );
        text3 = new TextField();
        futVal = new Label ( "Future Value: " );
        text4 = new TextField();

        //adds a Calculate button
        calculate = new Button ( "Calculate" );

        //sets the on action for the calculate button so that it will calculate the value when the button is pressed
        calculate.setOnAction ( new ButtonHandler () );

        rootNode.getChildren().addAll ( investAmt, text1, numYears, text2, annIntRate, text3, futVal, text4, calculate );
        myStage.setScene ( myScene );
        myStage.show();

    }

    class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle ( ActionEvent e ) {
            //converts the user input to type double so they can be plugged into the equation
            Double P = Double.valueOf(text1.getText() );
            System.out.println(P);
            Double n = Double.valueOf(text2.getText() );
            Double i = Double.valueOf(text3.getText() );

            //code for the calculation (exponent was calculated separately)
            Double FVPow = Math.pow (( 1 + i/12 ), (12 * n));
            Double FV = P * FVPow;


            //rounds to the nearest hundredth
            BigDecimal FutureVal = BigDecimal.valueOf(FV);
            FutureVal = FutureVal.setScale(2, RoundingMode.HALF_UP);


            //converts to string so it can be put into the text field
            text4.setText ( FutureVal.toString() );
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}
