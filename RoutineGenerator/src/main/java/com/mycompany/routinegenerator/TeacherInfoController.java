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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author mdsho
 */
public class TeacherInfoController implements Initializable {

    private static int teachernumber=1;
    URL url;
    ResourceBundle rb;
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
    @FXML
    private TextField TeacherNaameTextArea;
    @FXML
    private Label TeacherLabel;
    @FXML
    private Label ErrorLabel;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url=url;
        this.rb=rb;
        // TODO
        TeacherLabel.setText("Enter Information of Teacher number "+teachernumber);
        HBox1.getChildren().clear();
        Label lbl1=new Label();
        lbl1.setText("SUN:");
        HBox1.getChildren().add(lbl1);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            final int j=i;
            CheckBox chk=new CheckBox();
            chk.setText("Hour"+(i+1));
            chk.setOnAction(e->cheakboxClicked(0,j));
            HBox1.getChildren().add(chk);
        }
        HBox2.getChildren().clear();
        Label lbl2=new Label();
        lbl2.setText("MON:");
        HBox2.getChildren().add(lbl2);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            final int j=i;
            CheckBox chk=new CheckBox();
            chk.setText("Hour"+(i+1));
            chk.setOnAction(e->cheakboxClicked(1,j));
            HBox2.getChildren().add(chk);
        }
        HBox3.getChildren().clear();
        Label lbl3=new Label();
        lbl3.setText("TUE:");
        HBox3.getChildren().add(lbl3);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            final int j=i;
            CheckBox chk=new CheckBox();
            chk.setText("Hour"+(i+1));
            chk.setOnAction(e->cheakboxClicked(2,j));
            HBox3.getChildren().add(chk);
        }
        HBox4.getChildren().clear();
        Label lbl4=new Label();
        lbl4.setText("WED:");
        HBox4.getChildren().add(lbl4);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            final int j=i;
            CheckBox chk=new CheckBox();
            chk.setText("Hour"+(i+1));
            chk.setOnAction(e->cheakboxClicked(3,j));
            HBox4.getChildren().add(chk);
        }
        HBox5.getChildren().clear();
        Label lbl5=new Label();
        lbl5.setText("THU:");
        HBox5.getChildren().add(lbl5);
        for(int i=0;i<App.OutputRoutine.workingHour;i++)
        {
            final int j=i;
            CheckBox chk=new CheckBox();
            chk.setText("Hour"+(i+1));
            chk.setOnAction(e->cheakboxClicked(4,j));
            HBox5.getChildren().add(chk);
        }
        ErrorLabel.setText("");
        TeacherNaameTextArea.setText("");
        
    }    
    private void cheakboxClicked(int day,int hour)
    {
        App.OutputRoutine.TeacherSchedule[teachernumber-1][day][hour]=!App.OutputRoutine.TeacherSchedule[teachernumber-1][day][hour];
    }
    @FXML
    private void SubmitButtonClicked(ActionEvent event) throws IOException {
        String s=TeacherNaameTextArea.getText();
        if(s.length()==0)
        {
            ErrorLabel.setText("Enter Teacher name");
            return;
        }
        
        
        App.OutputRoutine.TeacherList[teachernumber-1]=s;
        teachernumber++;
        if(teachernumber>App.OutputRoutine.teacherNumber)
        {
             App.setRoot("SubjectInfo");
            return;
        }
        initialize(url, rb);
    }
    
}
