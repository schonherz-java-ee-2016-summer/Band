package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.EventsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Lenovo on 2016.08.28..
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface EventsImageRepository extends JpaRepository<EventsImage, Long>{

    Collection<EventsImage> findAllEventsImage();

    Collection<EventsImage> findEventsImageByEventId();

    EventsImage findByName(String name);

    EventsImage findByFilename(String filename);

    EventsImage finById();
}
