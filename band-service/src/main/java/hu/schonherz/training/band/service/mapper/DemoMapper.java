package hu.schonherz.training.band.service.mapper;

import hu.schonherz.training.band.entities.DemoEntity;
import hu.schonherz.training.band.vo.DemoVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Armin Veress
 * Mapper for DemoEntity and DemoVo classes.
 */
public final class DemoMapper {

    private DemoMapper() {
    }

    private static Mapper mapper = new DozerBeanMapper();

    public static DemoVo toVo(DemoEntity demoEntity) {
        if (demoEntity == null){
            return null;
        }
        return mapper.map(demoEntity, DemoVo.class);
    }

    public static DemoEntity toDto(DemoVo demoVo) {
        if (demoVo == null){
            return null;
        }
        return mapper.map(demoVo, DemoEntity.class);
    }

    public static List<DemoVo> toVo(List<DemoEntity> demoEntityList){
        List<DemoVo> demoVoList = new ArrayList<>();
        for (DemoEntity demoEntity : demoEntityList) {
            demoVoList.add(toVo(demoEntity));
        }
        return demoVoList;
    }

    public static List<DemoEntity> toDto(List<DemoVo> demoVoList){
        List<DemoEntity> demoEntityList = new ArrayList<>();
        for (DemoVo demoVo : demoVoList){
            demoEntityList.add(toDto(demoVo));
        }
        return demoEntityList;
    }
}
