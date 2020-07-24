package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.events.Event;
import com.booster.demos.sbbankaccount.events.UnknownEvent;
import com.booster.demos.sbbankaccount.infra.EntityReducer;
import com.booster.demos.sbbankaccount.infra.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventStore {
    private final EventsRepository repository;
    private final EntityReducer entityReducer;

    @Autowired
    public EventStore(EventsRepository repository, EntityReducer entityReducer) {
        this.repository = repository;
        this.entityReducer = entityReducer;
    }

    public void append(Event event) throws UnknownEvent {
        repository.insert(event);
        entityReducer.reduce(event);
    }
}
