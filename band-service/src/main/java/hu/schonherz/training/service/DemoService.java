package hu.schonherz.training.service;

import hu.schonherz.training.vo.DemoVo;

import java.util.List;

/**
 * Created by Lenovo on 2016.09.03..
 */
public interface DemoService {

    List<DemoVo> getAllDemos();

    DemoVo getDemoById(Long id);

    List<DemoVo> getDemosByBandId(Long bandId);

    DemoVo getDemoByName(String name);

    DemoVo getDemoByFilename(String filename);

    void createDemo(DemoVo demoVo);

    void deleteDemo(DemoVo demoVo);
}
