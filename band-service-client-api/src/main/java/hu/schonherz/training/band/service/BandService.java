package hu.schonherz.training.band.service;

import hu.schonherz.training.band.vo.BandVo;

import java.util.Collection;

/**
 * @author Norbert Barocsi
 * {@link BandService}
 * Service for BandVo class.
 */
public interface BandService {

    Collection<BandVo> getAllBand();

    BandVo getBandById(Long id);

    BandVo getBandByName(String name);

    BandVo getBandbyOwnerid(Long Ownerid);

    BandVo getBandByDisabled(boolean disabled);

    void updateDisabledAttribute(BandVo bandVo);

    void createBand(BandVo bandVo);

    void deleteBand(BandVo bandVo);
}
