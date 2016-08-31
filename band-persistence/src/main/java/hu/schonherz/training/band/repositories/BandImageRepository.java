package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.BandImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository for the BandsImageEntity class.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface BandImageRepository extends JpaRepository<BandImageEntity, Long>{

    Collection<BandImageEntity> findByBandId(Long bandId);

    BandImageEntity findByName(String name);

    BandImageEntity findByFilename(String filename);

    BandImageEntity findById(Long id);
}
