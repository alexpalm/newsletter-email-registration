package com.apalm.ner.dao;

import com.apalm.ner.entities.Subscriber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriberDAO extends CrudRepository<Subscriber, Long> {

    List<Subscriber> findAll();

}
