package hu.schonherz.training.band.service;

import hu.schonherz.training.band.vo.EventVo;

/**
 * @author Armin Veress
 * Service interface for the EventVo class.
 */
public interface EventService {

    void createEvent(EventVo eventVo);

}
