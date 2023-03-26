package com.petprojects.SimpleBatch.Tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.List;

class Student{
    String name;
    int age;
    boolean isTopper;

    Student(String name,int age,boolean isTopper){
        this.name=name;
        this.age=age;
        this.isTopper=isTopper;
    }
}
public class SimpleReader implements ItemReader<Student>, StepExecutionListener {

    private List<Student> studentsList=new ArrayList<>();
    private int index;

    @Override
    public Student read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        try{
            System.out.println("Reading a student"+index);
            return studentsList.get(index++);
        }
        catch(Exception e){
            System.out.println("ENd of read");
            return null;
        }
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Initializing Students list");
        for(int i=0;i<23;i++){
            studentsList.add(new Student("A"+i,i,true));
        }
        index=0;
        StepExecutionListener.super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return StepExecutionListener.super.afterStep(stepExecution);
    }
}
