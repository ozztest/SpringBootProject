package com.example.service.impl;

import com.example.exception.CustomException;
import com.example.model.Meeting;
import com.example.repository.MeetingRepository;
import com.example.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ozgen on 06.04.2017.
 */
@Transactional
@Service
public class MeetingService implements IMeetingService{

    @Autowired
    MeetingRepository meetingRepository;

    @Override
    public Iterable<Meeting> findAll() {
        return this.meetingRepository.findAll();
    }

    @Override
    public Meeting findById(Long id) {
        return this.meetingRepository.findOne(id);
    }

    @Override
    public void save(Meeting meeting) {
        this.meetingRepository.save(meeting);
    }

    @Override
    public void update(Meeting meeting) {
        if (this.meetingRepository.exists(meeting.getId())) {
            this.meetingRepository.save(meeting);
        } else {
            throw new CustomException("Guncellenecek Kayit Bulunamadi");
        }

    }

    @Override
    public boolean remove(Long id) {
        if (this.meetingRepository.exists(id)) {
            this.meetingRepository.delete(id);
            return true;
        } else {
            throw new CustomException("Silinecek Kayit Bulunamadi");
        }


    }
}
