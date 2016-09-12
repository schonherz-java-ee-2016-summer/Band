package hu.schonherz.training.band.impl;

import hu.schonherz.training.band.entities.BandMateEntity;
import hu.schonherz.training.band.mapper.BandMateMapper;
import hu.schonherz.training.band.repositories.BandMateRepository;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.service.BandMateService;
import hu.schonherz.training.band.vo.BandMateVo;
import hu.schonherz.training.band.vo.BandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Collection;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.impl.BandMateServiceImpl}
 *  The implementation of the BandMateService interface.
 */
@Stateless(name = "BandMateService", mappedName = "BandMateService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(BandMateService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class BandMateServiceImpl implements BandMateService {

    @Autowired
    private BandMateRepository bandMateRepository;

    @Autowired
    private BandRepository bandRepository;

    @Override
    public Collection<BandMateVo> getBandMateVosByBand(BandVo bandVo) {
        return BandMateMapper.toVo(bandMateRepository.findAll());
    }

    @Override
    public BandMateVo getBandMateById(Long id) {
       return BandMateMapper.toVo(bandMateRepository.findById(id));
    }

    @Override
    public BandMateVo getBandMateByFirstName(String firstName) {
        return BandMateMapper.toVo(bandMateRepository.findByFirstName(firstName));
    }

    @Override
    public BandMateVo getBandMateByLastName(String lastName) {
        return BandMateMapper.toVo(bandMateRepository.findByLastName(lastName));
    }

    @Override
    public BandMateVo getBandMateByProfile(boolean profile) {
        return BandMateMapper.toVo(bandMateRepository.findByProfile(profile));
    }

    @Override
    public void createBandMate(BandMateVo bandMateVo) {
        BandMateEntity bandMateEntity = BandMateMapper.toEntity(bandMateVo);
        bandMateEntity.setBand(bandRepository.findById(bandMateVo.getBandId()));
        bandMateRepository.save(bandMateEntity);
    }

    @Override
    public void deleteBandMate(BandMateVo bandMateVo) {
        bandMateRepository.delete(BandMateMapper.toEntity(bandMateVo));
    }
}
