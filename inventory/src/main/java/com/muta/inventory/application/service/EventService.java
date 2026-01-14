package com.muta.inventory.application.service;

import com.muta.inventory.application.dto.EventDto;
import com.muta.inventory.domain.model.OperationalEvent;
import com.muta.inventory.infrastructure.persistence.repository.OperationalEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    private final OperationalEventRepository repository;

    public EventService(OperationalEventRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OperationalEvent createEvent(EventDto dto) {
        OperationalEvent event = EventFactory.createEvent(dto);
        return repository.save(event);
    }
}
