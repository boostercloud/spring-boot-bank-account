package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.events.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventsStore extends MongoRepository<Event, String> {
}
