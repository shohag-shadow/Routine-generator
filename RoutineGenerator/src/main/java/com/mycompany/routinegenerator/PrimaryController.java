/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.routinegenerator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mdsho
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField institutionTxtField;
    @FXML
    private TextField WorkingHourTxtField;
    @FXML
    private Label WarningLabel;
    @FXML
    private TextField teachersNumbers;
    @FXML
    private TextField SubjectNumberTextField;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSubmitted(ActionEvent event) throws IOException {
        String institution=institutionTxtField.getText();
        String WorkingHour=WorkingHourTxtField.getText();
        String techNumber=teachersNumbers.getText();
        String subjectNumber=SubjectNumberTextField.getText();
        if(institution.length()==0)
        {
            WarningLabel.setText("Please Enter your institution Name");
            return;
        }
        if(!isNumber(WorkingHour))
        {
            WarningLabel.setText("Please Enter a valid Working Hour");
            return;
        }
        if(!isNumber(techNumber))
        {
            WarningLabel.setText("Please Enter a Number in your Teachernumber Field");
            return;
        }
        if(!isNumber(subjectNumber))
        {
            WarningLabel.setText("Please Enter a Number in Subject Number field");
            return;
        }
        App.OutputRoutine.institutinName=institution;
        App.OutputRoutine.workingHour=Double.parseDouble(WorkingHour);
        App.OutputRoutine.teacherNumber=Double.parseDouble(techNumber);
        App.OutputRoutine.subjectNumber=Double.parseDouble(subjectNumber);
        App.setRoot("TeacherInfo");
    }
    boolean isNumber(String s)
    {
        if(s.length()==0)return false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
            {
                return false;
            }
        }
        return true;
    }
}
