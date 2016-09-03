package hu.schonherz.training.band.service;

import hu.schonherz.training.band.entities.BandEntity;
import hu.schonherz.training.band.vo.DemoVo;

import java.util.Collection;

/**
 * @author Armin Veress
 * {@link hu.schonherz.training.band.vo.DemoVo}
 * The interface containing the methods for saving, updating, querying and removing band demos.
 */
public interface DemoService {

    DemoVo getDemoById(Long id);

    Collection<DemoVo> getDemosByBand(BandEntity band);

    DemoVo getDemoByName(String name);

    DemoVo getDemoByFilename(String filename);

    void createDemo(DemoVo demoVo);

    void deleteDemo(DemoVo demoVo);

    void updateDemo(DemoVo demoVo);
}
