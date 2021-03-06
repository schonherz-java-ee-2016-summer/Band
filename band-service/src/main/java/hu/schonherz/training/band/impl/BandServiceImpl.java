package hu.schonherz.training.band.impl;

import hu.schonherz.training.band.ejb.remote.stateless.BandRemoteService;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.mapper.BandMapper;
import hu.schonherz.training.band.vo.BandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Collection;
import java.util.List;

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
    public BandVo getBandbyOwnerid(Long bandOwnerId) {
        return BandMapper.toVo(bandRepository.findByOwnerid(bandOwnerId));
    }

    @Override
    public BandVo getBandByDisabled(boolean disabled) {
        return BandMapper.toVo(bandRepository.findByDisabled(disabled));
    }

    @Override
    public void updateDisabledAttribute(BandVo bandVo) {
        bandRepository.updateDisabledAttribute(bandVo.isDisabled(), bandVo.getId());
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
    public List<BandVo> getAllBands() {
        return BandMapper.toVo(bandRepository.findAll());
    }

    @Override
    public List<BandVo> getBandsWithPaging(int page, int pageSize) {
        Pageable pageable = new PageRequest(page, pageSize);
        return BandMapper.toVo(bandRepository.findAll(pageable).getContent());
    }
}
