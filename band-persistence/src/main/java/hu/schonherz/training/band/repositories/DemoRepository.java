package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository for the DemoEntity class.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

    Collection<DemoEntity> findByBandId(Long bandId);

    DemoEntity findById(Long id);

    DemoEntity findByName(String name);

    DemoEntity findByFilename(String filename);

    DemoEntity save(DemoEntity demoEntity);
}
