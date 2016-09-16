package hu.schonherz.training.band.impl;

import hu.schonherz.training.band.entities.EventEntity;
import hu.schonherz.training.band.mapper.EventMapper;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.repositories.EventRepository;
import hu.schonherz.training.band.service.EventService;
import hu.schonherz.training.band.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;

/**
 * @author Armin Veress
 * The implementations of the abstract methods in the BandService interface.
 */
@Stateless(name = "EventService", mappedName = "EventService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(EventService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BandRepository bandRepository;

    @Override
    public void createEvent(EventVo eventVo) {
        EventEntity eventEntity = EventMapper.toEntity(eventVo);
        eventEntity.setBand(bandRepository.findById(1L));
        eventEntity.setVenueId(1L);
        eventRepository.save(eventEntity);
    }
}
