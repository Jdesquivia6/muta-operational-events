package com.muta.inventory.api.controller;

import com.muta.inventory.application.dto.EventDto;
import com.muta.inventory.application.service.EventService;
import com.muta.inventory.domain.model.OperationalEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<OperationalEvent> createEvent(@RequestBody EventDto dto) {
        try {
            OperationalEvent event = eventService.createEvent(dto);
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
