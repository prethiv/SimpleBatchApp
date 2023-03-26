package com.petprojects.SimpleBatch.Tasklet;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SimpleWriter implements ItemWriter<Human> {
    @Override
    public void write(Chunk<? extends Human> chunk) throws Exception {
        System.out.println("Inside writer");
        List<Human> humans = (List<Human>) chunk.getItems();
        humans.stream().forEach(human->{
            System.out.println("COnsuming Human");
            System.out.println(human.age+" "+human.name);
        });
    }
}
