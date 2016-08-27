package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Lenovo on 2016.08.27..
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface EventRepositroy extends JpaRepository<Event, Long> {

    Collection<Event> findAllEvent();

    Collection<Event> findEventByBandId(Long bandId);

    Collection<Event> findEventByVenueId(Long venueId);

    Collection<Event> findEventByStart(LocalDateTime date);

    Collection<Event> findEventByFinish(LocalDateTime date);

    Event findById(Long id);

    Event findEventByName(String name);
}
