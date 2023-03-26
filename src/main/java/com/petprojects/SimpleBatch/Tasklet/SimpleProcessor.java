package com.petprojects.SimpleBatch.Tasklet;

import org.springframework.batch.item.ItemProcessor;

class Human{
    String name;
    int age;
    Human(String name,int age){
        this.name=name;
        this.age=age;
    }
}
public class SimpleProcessor implements ItemProcessor<Student,Human> {

    @Override
    public Human process(Student item) throws Exception {
        System.out.println("Inside processor");
        System.out.println("COnverting student into Human");
        return new Human(item.name,item.age);
    }
}
