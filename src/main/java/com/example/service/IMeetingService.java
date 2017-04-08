package com.example.service;

import com.example.model.Meeting;

/**
 * Created by ozgen on 06.04.2017.
 */
public interface IMeetingService {
    
    Iterable<Meeting> findAll();

    Meeting findById(Long id);

    void save(Meeting employee);

    void update(Meeting employee);

    boolean remove(Long id);

}
