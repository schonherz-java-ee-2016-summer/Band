package hu.schonherz.training.band.service.mapper;

import hu.schonherz.training.band.entities.BandEntity;
import hu.schonherz.training.band.vo.BandVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author Norbert Barocsi.
 * {@link hu.schonherz.training.band.service.mapper.BandMapper}
 * Mapper for BandEntity and BandVo class.
 */
public class BandMapper  {

    private static Mapper mapper = new DozerBeanMapper();

    public static BandVo toVo(BandEntity bandEntity){
        if(bandEntity == null){
            return null;
        }
        return mapper.map(bandEntity, BandVo.class);
    }

    public static BandEntity toDto(BandVo bandVo){
        if(bandVo == null){
            return null;
        }
        return mapper.map(bandVo, BandEntity.class);
    }

    public static List<BandVo> toVo(List<BandEntity> bandEntities){
        List<BandVo> bandVos = new ArrayList<>();
        for (BandEntity bandEntity : bandEntities) {
            bandVos.add(toVo(bandEntity));
        }
        return bandVos;
    }

    public static List<BandEntity> toDto(List<BandVo> bandVos){
        List<BandEntity> bandEntities = new ArrayList<>();
        for(BandVo bandVo : bandVos){
            bandEntities.add(toDto(bandVo));
        }
        return bandEntities;
    }
}
