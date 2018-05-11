package com.starwars.starwarsbatch.processor;

import com.starwars.starwarsbatch.model.people;
import org.springframework.batch.item.ItemProcessor;

public class GenderProc implements ItemProcessor<people, people> {

    @Override
    public people process(people people) throws Exception {
        if (people.getGender().equals("n/a"))
            people.setGender("droid");

        return people;
    }
}
