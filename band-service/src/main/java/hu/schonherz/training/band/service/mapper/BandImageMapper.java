package hu.schonherz.training.band.service.mapper;

import hu.schonherz.training.band.entities.BandImageEntity;
import hu.schonherz.training.band.vo.BandImageVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Attila Holhós
 * {@link hu.schonherz.training.band.service.mapper.BandImageMapper}
 * A mapper class to BandImageVo and BandImageEntity classes.
 */
public final class BandImageMapper {

    private static Mapper mapper = new DozerBeanMapper();

    public BandImageMapper() {
    }

    public static BandImageVo toVo(BandImageEntity bandImageEntity){
        if (bandImageEntity == null){
            return null;
        }
        return mapper.map(bandImageEntity, BandImageVo.class);
    }

    public static BandImageEntity toEntity(BandImageVo bandImageVo){
        if (bandImageVo == null){
            return  null;
        }
        return mapper.map(bandImageVo, BandImageEntity.class);
    }

    public static List<BandImageVo> toVo(List<BandImageEntity> bandImageEntities){
        List<BandImageVo> bandImageVos = new ArrayList<BandImageVo>();
        for (BandImageEntity bandImageEntity: bandImageEntities){
            bandImageVos.add(toVo(bandImageEntity));
        }
        return bandImageVos;
    }

    public static List<BandImageEntity> toEntity(List<BandImageVo> bandImageVos){
        List<BandImageEntity> bandImageEntities = new ArrayList<BandImageEntity>();
        for (BandImageVo bandImageVo: bandImageVos){
            bandImageEntities.add(toEntity(bandImageVo));
        }
        return bandImageEntities;
    }
}
