package hu.schonherz.training.band.service;

import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.vo.EventVo;

import java.util.Collection;

/**
 * @author Armin Veress
 * Service interface for the EventVo class.
 */
public interface EventService {

    void createEvent(EventVo eventVo);

    EventVo getEventById(Long id);

    void deleteVo(EventVo eventVo);

    Collection<EventVo> getEventsByBand(BandVo bandVo);
}
