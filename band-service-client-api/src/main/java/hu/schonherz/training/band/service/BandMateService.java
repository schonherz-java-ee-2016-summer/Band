package hu.schonherz.training.band.service;

import hu.schonherz.training.band.vo.BandMateVo;
import hu.schonherz.training.band.vo.BandVo;

import java.util.Collection;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.service.BandMateService}
 * Service for BandMateVo class.
 */
public interface BandMateService {

    Collection<BandMateVo> getBandMateVosByBand(BandVo bandVo);

    BandMateVo getBandMateById(Long id);

    BandMateVo getBandMateByFirstName(String firstName);

    BandMateVo getBandMateByLastName(String lastName);

    BandMateVo getBandMateByProfile(boolean profile);

    void createBandMate(BandMateVo bandMateVo);

    void deleteBandMate(BandMateVo bandMateVo);
}
