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
import javafx.scene.control.CheckBox;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author mdsho
 */
public class SubjectInfoController implements Initializable {
    private static int subjectInputNumber=1;
    URL url;
    ResourceBundle rb;
    @FXML
    private TextField subjectNameTextField;
    @FXML
    private ChoiceBox<String> teacherChoiceBox;
    @FXML
    private TextField numberOfClassNeededTextField;
    @FXML
    private Label Errorlabel;
    @FXML
    private Label subjectLabel;
    @FXML
    private CheckBox alternatingCheakbox;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url=url;
        this.rb=rb;
        subjectLabel.setText("Enter Name of subject number "+subjectInputNumber);
        teacherChoiceBox.getItems().clear();
        for(int i=0;i<App.OutputRoutine.teacherNumber;i++)
        {
            teacherChoiceBox.getItems().add(App.OutputRoutine.TeacherList[i]);
        }
        subjectNameTextField.setText("");
        numberOfClassNeededTextField.setText("");
        Errorlabel.setText("");
        alternatingCheakbox.setOnAction(e->cheakboxClicked());
    }    
    
    @FXML
    private void submitClicked(ActionEvent event) throws IOException {
        String subjectName=subjectNameTextField.getText();
        if(subjectName.length()==0)
        {
            Errorlabel.setText("Please Enter a Subject name");
            return;
        }
        String chosenTeacher=teacherChoiceBox.getValue();
        if(chosenTeacher==null)
        {
            Errorlabel.setText("Please Select Teacher for this subject");
            return;
        }
        String classNeeded=numberOfClassNeededTextField.getText();
        if(!isNumber(classNeeded))
        {
            Errorlabel.setText("Please enter a number in Class needed field");
            return;
        }
        App.OutputRoutine.SubjectList[subjectInputNumber-1]=subjectName;
        App.OutputRoutine.ChosenTeacherofSubject[subjectInputNumber-1]=getTeacherIndex(chosenTeacher);
        App.OutputRoutine.ClassNeededofSubject[subjectInputNumber-1]=Double.parseDouble(classNeeded);
        
        subjectInputNumber++;
        if(subjectInputNumber>App.OutputRoutine.subjectNumber)
        {
            App.setRoot("LoadingScreen");
            
            App.OutputRoutine.makeRoutine(0, 0);
            if(App.OutputRoutine.RoutineGenerationSuccessful)
            {
                App.setRoot("OutputScreen");
            }
            else
            {
                App.setRoot("SorryScreen");
            }
            return;
        }
        initialize(url, rb);
        
    }
    void cheakboxClicked()
    {
        App.OutputRoutine.isAlternating[subjectInputNumber-1]=!App.OutputRoutine.isAlternating[subjectInputNumber-1];
    }
    int getTeacherIndex(String s)
    {
        for(int i=0;i<App.OutputRoutine.teacherNumber;i++)
        {
            if(App.OutputRoutine.TeacherList[i].equals(s))
            {
                return i;
            }
        }
        return -1;
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
