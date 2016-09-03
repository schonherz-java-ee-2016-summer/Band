package hu.schonherz.training.band.service;

import hu.schonherz.training.band.vo.BandVo;

import java.util.Collection;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.service.BandService}
 * Service for BandVo class.
 */
public interface BandService {

    Collection<BandVo> getAllBand();

    BandVo getBandById(Long id);

    BandVo getBandByName(String name);

    void createBand(BandVo bandVo);

    void deleteBand(BandVo bandVo);
}
