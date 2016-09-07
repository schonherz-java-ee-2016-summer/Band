package hu.schonherz.training.band.service;

import hu.schonherz.training.band.vo.BandImageVo;
import hu.schonherz.training.band.vo.BandVo;

import java.util.Collection;

/**
 * @author Attila Holhós
 * {@link hu.schonherz.training.band.service.BandImageService}
 * This interface contains methods for saving and removing band images.
 */
public interface BandImageService {

    Collection<BandImageVo> getImagesByBand(BandVo bandVo);

    BandImageVo getImageById(Long id);

    void saveBandImage(BandImageVo bandImageVo);

    void deleteBanImage(BandImageVo bandImageVo);
}
