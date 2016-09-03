package hu.schonherz.training.band.service.impl;

import hu.schonherz.training.band.entities.BandEntity;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.service.mapper.BandMapper;
import hu.schonherz.training.band.vo.BandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Collection;
import java.util.List;

/**
 * @author Norbert Barocsi.
 * {@link hu.schonherz.training.band.service.impl.BandServiceImpl}
 *  The implementation of the BandService interface.
 */

@Stateless(name = "BandService", mappedName = "BandService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.BEAN)
@Local(BandService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class BandServiceImpl implements BandService{

    @Autowired
    private BandRepository bandRepository;

    @Override
    public Collection<BandVo> getAllBand() {
        List<BandEntity> bandEntities = null;

        bandEntities = bandRepository.findAll();

        return BandMapper.toVo(bandEntities);
    }

    @Override
    public BandVo getBandById(Long id) {
        BandEntity bandEntity = null;

        bandEntity = bandRepository.findById(id);

        return BandMapper.toVo(bandEntity);
    }

    @Override
    public BandVo getBandByName(String name) {
        BandEntity bandEntity = null;

        bandEntity = bandRepository.findByName(name);

        return BandMapper.toVo(bandEntity);
    }

    @Override
    public void createBand(BandVo bandVo) {
        bandRepository.save(BandMapper.toDto(bandVo));
    }

    @Override
    public void deleteBand(BandVo bandVo) {
        bandRepository.delete(BandMapper.toDto(bandVo));
    }
}
