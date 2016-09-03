package hu.schonherz.training.band.service.impl;

import hu.schonherz.training.band.entities.BandEntity;
import hu.schonherz.training.band.repositories.DemoRepository;
import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.band.vo.DemoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Armin Veress
 * {@link hu.schonherz.training.band.service.DemoService}
 * The implementation of the DemoService interface.
 */
@Stateless(name = "DemoService", mappedName = "DemoService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.BEAN)
@Local(DemoService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoVo getDemoById(Long id) {
        return null;
    }

    @Override
    public List<DemoVo> getDemosByBand(BandEntity band) {
        return null;
    }

    @Override
    public DemoVo getDemoByName(String name) {
        return null;
    }

    @Override
    public DemoVo getDemoByFilename(String filename) {
        return null;
    }

    @Override
    public void createDemo(DemoVo demoVo) {

    }

    @Override
    public void deleteDemo(DemoVo demoVo) {

    }
}
