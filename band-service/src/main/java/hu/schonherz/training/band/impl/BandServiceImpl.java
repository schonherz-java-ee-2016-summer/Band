package hu.schonherz.training.band.impl;

import hu.schonherz.training.band.ejb.remote.stateless.BandRemoteService;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.mapper.BandMapper;
import hu.schonherz.training.band.vo.BandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Collection;

/**
 * @author Norbert Barocsi
 * {@link BandServiceImpl}
 *  The implementation of the BandService interface.
 */

@Stateless(name = "BandService", mappedName = "BandService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(BandService.class)
@Remote(BandRemoteService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class BandServiceImpl implements BandService, BandRemoteService {

    @Autowired
    private BandRepository bandRepository;

    @Override
    public Collection<BandVo> getAllBand() {
        return BandMapper.toVo(bandRepository.findAll());
    }

    @Override
    public BandVo getBandById(Long id) {
        return BandMapper.toVo(bandRepository.findById(id));
    }

    @Override
    public BandVo getBandByName(String name) {
        return BandMapper.toVo(bandRepository.findByName(name));
    }

    @Override
    public void createBand(BandVo bandVo) {
        bandRepository.save(BandMapper.toEntity(bandVo));
    }

    @Override
    public void deleteBand(BandVo bandVo) {
        bandRepository.delete(BandMapper.toEntity(bandVo));
    }

    @Override
    public String getAllBands() {
        return "Valami tök mindegy!";
    }
}
