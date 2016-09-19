package hu.schonherz.training.band.impl;

import hu.schonherz.training.band.entities.EventEntity;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.repositories.EventRepository;
import hu.schonherz.training.band.service.EventService;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        EventEntity eventEntity = new EventEntity();
        eventEntity.setName(eventVo.getName());
        eventEntity.setStart(eventVo.getStart());
        eventEntity.setFinish(eventVo.getFinish());
        eventEntity.setDescription(eventVo.getDescription());
        eventEntity.setBand(bandRepository.findById(eventVo.getBandId()));
        eventEntity.setVenueId(1L);
        eventRepository.save(eventEntity);
    }

    @Override
    public Collection<EventVo> getEventsByBand(BandVo bandVo) {
        Collection<EventVo> eventVos = new ArrayList<>();
        List<EventEntity> eventEntities = (List<EventEntity>) eventRepository.findByBandId(bandVo.getId());
        for (EventEntity i : eventEntities) {
            EventVo eventVo = new EventVo();
            eventVo.setId(i.getId());
            eventVo.setVenueId(i.getVenueId());
            eventVo.setBandId(i.getBand().getId());
            eventVo.setName(i.getName());
            eventVo.setStart(i.getStart());
            eventVo.setFinish(i.getFinish());
            eventVo.setDescription(i.getDescription());
            eventVos.add(eventVo);
        }
        return eventVos;
    }
}
