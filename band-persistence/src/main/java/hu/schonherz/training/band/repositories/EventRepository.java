package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Repository for the EventEntity class.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Collection<EventEntity> findByBandId(Long bandId);

    Collection<EventEntity> findByVenueId(Long venueId);

    Collection<EventEntity> findByStart(LocalDateTime date);

    Collection<EventEntity> findEByFinish(LocalDateTime date);

    EventEntity findById(Long id);

    EventEntity findByName(String name);
}
