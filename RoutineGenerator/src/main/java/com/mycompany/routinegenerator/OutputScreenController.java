/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.routinegenerator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author mdsho
 */
public class OutputScreenController implements Initializable {


    @FXML
    private Label institutionName;
    @FXML
    private HBox HBox1;
    @FXML
    private HBox HBox2;
    @FXML
    private HBox HBox3;
    @FXML
    private HBox HBox4;
    @FXML
    private HBox HBox5;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        institutionName.setText(App.OutputRoutine.institutinName);
        Label day1=new Label("SUN:");
        HBox1.getChildren().add(day1);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            Label lb=new Label(getName(App.OutputRoutine.output[0][i]));
            HBox1.getChildren().add(lb);
        }
        
        Label day2=new Label("MON:");
        HBox2.getChildren().add(day2);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            Label lb=new Label(getName(App.OutputRoutine.output[1][i]));
            HBox2.getChildren().add(lb);
        }
        
        Label day3=new Label("TUE:");
        HBox3.getChildren().add(day3);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            Label lb=new Label(getName(App.OutputRoutine.output[2][i]));
            HBox3.getChildren().add(lb);
        }
        
        Label day4=new Label("WED:");
        HBox4.getChildren().add(day4);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            Label lb=new Label(getName(App.OutputRoutine.output[3][i]));
            HBox4.getChildren().add(lb);
        }
        
        Label day5=new Label("THU:");
        HBox5.getChildren().add(day5);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            Label lb=new Label(getName(App.OutputRoutine.output[4][i]));
            HBox5.getChildren().add(lb);
        }
    }    
    
    String getName(int i)
    {
        if(i==-1)
        {
            return "  None  ";
        }
        else
        {
            if(App.OutputRoutine.isAlternating[i])
            {
                return "  "+App.OutputRoutine.SubjectList[i]+"  "+"\n"+"  Alternating  ";
            }
            else
            {
                return "  "+App.OutputRoutine.SubjectList[i]+"  ";
            }
            
            
        }
    }
    @FXML
    private void closeButtonClicked(ActionEvent event) {
        System.exit(0);
    }

}
