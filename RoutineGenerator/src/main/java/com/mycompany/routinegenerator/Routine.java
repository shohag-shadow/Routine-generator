/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.routinegenerator;

/**
 *
 * @author mdsho
 */
public class Routine {
    int [][] output=new int[7][24];
    Boolean RoutineGenerationSuccessful=false;
    
    String institutinName;
    double workingHour;
    double teacherNumber;
    double subjectNumber;
    String [] TeacherList=new String[100];
    Boolean [][][] TeacherSchedule=new Boolean[100][7][24];
    String [] SubjectList=new String[100];
    int [] ChosenTeacherofSubject=new int[100];
    double [] ClassNeededofSubject=new double[100];
    double [] ClassTakenofSubject=new double[100];
    Boolean [][] IsClassTakenofDay=new Boolean[100][7];
    Boolean [] isAlternating=new Boolean[100];
    public Routine()
    {
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<7;j++)
            {
                for(int k=0;k<24;k++)
                {
                    TeacherSchedule[i][j][k]=false;
                }
            }
        }
        for(int i=0;i<100;i++)
        {
            ClassTakenofSubject[i]=0;
        }
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<7;j++)
            {
                IsClassTakenofDay[i][j]=false;
            }
        }
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<24;j++)
            {
                output[i][j]=-1;
            }
        }
        for(int i=0;i<100;i++)
        {
            isAlternating[i]=false;
        }
    }
    
    boolean isGenerationSuccess()
    {
        for(int i=0;i<subjectNumber;i++)
        {
            if(ClassNeededofSubject[i]>ClassTakenofSubject[i])
            {
                return false;
            }
        }
        RoutineGenerationSuccessful=true;
        return true;
    }
    void makeRoutine(int day,int hour)
    {
        if(hour==workingHour)
        {
            makeRoutine(day+1,0);
            return;
        }
        if(day==5)
        {
            isGenerationSuccess();
            return;
        }
        boolean possible=false;
        for(int i=0;i<subjectNumber;i++)
        {
            if(TeacherSchedule[ChosenTeacherofSubject[i]][day][hour]==true&&ClassNeededofSubject[i]>ClassTakenofSubject[i]&&IsClassTakenofDay[i][day]==false&&output[day][hour]==-1)
            {
                possible=true;
                TeacherSchedule[ChosenTeacherofSubject[i]][day][hour]=false;
                ClassTakenofSubject[i]++;
                IsClassTakenofDay[i][day]=true;
                output[day][hour]=i;
                makeRoutine(day,hour+1);
                if(!RoutineGenerationSuccessful)
                {
                    TeacherSchedule[ChosenTeacherofSubject[i]][day][hour]=true;
                    ClassTakenofSubject[i]--;
                    IsClassTakenofDay[i][day]=false;
                    output[day][hour]=-1;
                }
                else
                {
                    return;
                }
            }
        }
        if(!possible)
        {
            makeRoutine(day,hour+1);
        }
        
    }
}
