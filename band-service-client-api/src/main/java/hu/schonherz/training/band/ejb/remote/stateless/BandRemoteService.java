package hu.schonherz.training.band.ejb.remote.stateless;

import hu.schonherz.training.band.vo.BandVo;

import java.util.List;

/**
 * Created by Mindfield on 2016. 09. 14..
 */
public interface BandRemoteService {

    List<BandVo> getAllBands();

    List<BandVo> getBandsWithPaging(int page, int pageSize);
}
