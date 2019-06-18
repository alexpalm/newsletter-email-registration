package com.apalm.ner.init;

import com.apalm.ner.dao.SubscriberDAO;
import com.apalm.ner.entities.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private SubscriberDAO subscriberDAO;

    @Autowired
    public DataInit(SubscriberDAO subscriberDAO) {
        this.subscriberDAO = subscriberDAO;
    }

    @Override
    public void run(ApplicationArguments args) {
        long countOfSubscribers = subscriberDAO.count();

        if (countOfSubscribers == 0) {
            Subscriber subscriber1 = new Subscriber();
            subscriber1.setFullName("John Smith");
            subscriber1.setEmail("john.smith@gmail.com");
            subscriberDAO.save(subscriber1);

            Subscriber subscriber2 = new Subscriber();
            subscriber2.setFullName("Alice Newton");
            subscriber2.setEmail("alice.newton@gmail.com");
            subscriberDAO.save(subscriber2);
        }
    }

}
