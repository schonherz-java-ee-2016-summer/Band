package hu.schonherz.training.band.repository;

import hu.schonherz.training.band.entities.BandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Mindfield on 2016. 08. 28..
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface BandRepository extends JpaRepository<BandEntity, Long>{

    BandEntity findById(Long id);

    BandEntity findByName(String name);

    Collection<BandEntity> findAllBand();

}
