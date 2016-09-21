package hu.schonherz.training.band.impl;

import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.band.entities.DemoEntity;
import hu.schonherz.training.band.mapper.DemoMapper;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.repositories.DemoRepository;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.vo.DemoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Collection;
import java.util.List;

/**
 * @author Armin Veress
 * {@link DemoService}
 * The implementation of the DemoService interface.
 */
@Stateless(name = "DemoService", mappedName = "DemoService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(DemoService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private BandRepository bandRepository;

    @Override
    public DemoVo getDemoById(Long id) {
        return DemoMapper.toVo(demoRepository.findById(id));
    }

    @Override
    public Collection<DemoVo> getDemosByBand(BandVo band) {
        return DemoMapper.toVo((List<DemoEntity>) demoRepository.findByBandId(band.getId()));
    }

    @Override
    public DemoVo getDemoByName(String name) {
        return DemoMapper.toVo(demoRepository.findByName(name));
    }

    @Override
    public DemoVo getDemoByFilename(String filename) {
        return DemoMapper.toVo(demoRepository.findByFilename(filename));
    }

    @Override
    public void createDemo(DemoVo demoVo) {
        DemoEntity demoEntity = DemoMapper.toEntity(demoVo);
        demoEntity.setBand(bandRepository.findById(demoVo.getBandId()));
        demoRepository.save(demoEntity);
    }

    @Override
    public void deleteDemo(DemoVo demoVo) {
        demoRepository.delete(DemoMapper.toEntity(demoVo));
    }

    @Override
    public void updateDemo(DemoVo demoVo) {
        demoRepository.save(DemoMapper.toEntity(demoVo));
    }
}
