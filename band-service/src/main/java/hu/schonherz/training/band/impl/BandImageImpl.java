package hu.schonherz.training.band.impl;

import hu.schonherz.training.band.entities.BandImageEntity;
import hu.schonherz.training.band.repositories.BandImageRepository;
import hu.schonherz.training.band.repositories.BandRepository;
import hu.schonherz.training.band.service.BandImageService;
import hu.schonherz.training.band.mapper.BandImageMapper;
import hu.schonherz.training.band.vo.BandImageVo;
import hu.schonherz.training.band.vo.BandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Collection;
import java.util.List;

/**
 * @author Attila Holhós
 * Implementation of BandImageService interface
 */
@Stateless(name = "BandImageService", mappedName = "BandImageService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(BandImageService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class BandImageImpl implements BandImageService {

    @Autowired
    private BandImageRepository bandImageRepository;

    @Autowired
    private BandRepository bandRepository;

    @Override
    public Collection<BandImageVo> getImagesByBand(BandVo bandVo) {
        return BandImageMapper.toVo((List<BandImageEntity>) bandImageRepository.findByBandId(bandVo.getId()));
    }

    @Override
    public BandImageVo getImageById(Long id) {
        return BandImageMapper.toVo(bandImageRepository.findById(id));
    }

    @Override
    public void saveBandImage(BandImageVo bandImageVo) {
        BandImageEntity bandImageEntity = BandImageMapper.toEntity(bandImageVo);
        bandImageEntity.setBand(bandRepository.findById(bandImageVo.getBandId()));
        bandImageRepository.save(bandImageEntity);
    }

    @Override
    public void deleteBanImage(BandImageVo bandImageVo) {
        bandImageRepository.delete(BandImageMapper.toEntity(bandImageVo));
    }
}
