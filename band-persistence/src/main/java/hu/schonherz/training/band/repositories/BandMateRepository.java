package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.BandMateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository for the BandMateRepository class.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface BandMateRepository extends JpaRepository<BandMateEntity, Long> {

    BandMateEntity findById(Long id);

    BandMateEntity findByFirstName(String firstName);

    BandMateEntity findByLastName(String lastName);

    BandMateEntity findByProfile(boolean profile);

    Collection<BandMateEntity> findByBandId(Long bandId);
}
