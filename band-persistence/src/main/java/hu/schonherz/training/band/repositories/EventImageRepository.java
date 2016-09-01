package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.EventImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository for the BandImageEntity class.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface EventImageRepository extends JpaRepository<EventImageEntity, Long> {

    Collection<EventImageEntity> findByEventId();

    EventImageEntity findByName(String name);

    EventImageEntity findByFilename(String filename);

    EventImageEntity finById();
}
