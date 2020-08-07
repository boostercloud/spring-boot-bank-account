package com.booster.demos.sbbankaccount.infrastructure.mongo;

import com.booster.demos.sbbankaccount.events.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventsRepository extends MongoRepository<Event, String> {
}
