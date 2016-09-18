package hu.schonherz.training.band.mapper;

import hu.schonherz.training.band.entities.EventEntity;
import hu.schonherz.training.band.vo.EventVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Armin Veress
 * Mapper for the EventEntity and EventVo classes.
 */
public final class EventMapper {

    private static Mapper mapper = new DozerBeanMapper();

    private EventMapper() {
    }

    public static EventVo toVo(EventEntity eventEntity){
        if (eventEntity == null) {
            return null;
        }
        return mapper.map(eventEntity, EventVo.class);
    }

    public static EventEntity toEntity(EventVo eventVo){
        if (eventVo == null) {
            return null;
        }
        return mapper.map(eventVo, EventEntity.class);
    }

    public static List<EventVo> toVo(List<EventEntity> eventEntityList){
        List<EventVo> eventVoList = new ArrayList<>();
        for (EventEntity eventEntity : eventEntityList) {
            eventVoList.add(toVo(eventEntity));
        }
        return eventVoList;
    }

    public static List<EventEntity> toEntity(List<EventVo> eventVoList){
        List<EventEntity> eventEntityList = new ArrayList<>();
        for (EventVo eventVo : eventVoList) {
            eventEntityList.add(toEntity(eventVo));
        }
        return eventEntityList;
    }
}
