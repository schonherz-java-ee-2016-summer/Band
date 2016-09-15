package hu.schonherz.training.band.mapper;

import hu.schonherz.training.band.entities.BandMateEntity;
import hu.schonherz.training.band.vo.BandMateVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author Norbert Barocsi
 * {@link hu.schonherz.training.band.mapper.BandMateMapper}
 * Mapper for BandMateEntity and BandMateVo class.
 */
public final class BandMateMapper {

    private static Mapper mapper = new DozerBeanMapper();

    private BandMateMapper() {
    }

    public static BandMateVo toVo(BandMateEntity bandMateEntity){
        if (bandMateEntity == null) {
            return null;
        }
        return mapper.map(bandMateEntity, BandMateVo.class);
    }

    public static BandMateEntity toEntity(BandMateVo bandMateVo){
        if (bandMateVo == null) {
            return null;
        }
        return mapper.map(bandMateVo, BandMateEntity.class);
    }

    public static List<BandMateVo> toVo(List<BandMateEntity> bandMateEntities){
        List<BandMateVo> bandVos = new ArrayList<>();
        for (BandMateEntity bandMateEntity : bandMateEntities) {
            bandVos.add(toVo(bandMateEntity));
        }
        return bandVos;
    }

    public static List<BandMateEntity> toEntity(List<BandMateVo> bandMateVos){
        List<BandMateEntity> bandEntities = new ArrayList<>();
        for (BandMateVo bandMateVo : bandMateVos) {
            bandEntities.add(toEntity(bandMateVo));
        }
        return bandEntities;
    }
}
