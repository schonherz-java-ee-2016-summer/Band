package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.BandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository for the BandEntity class.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface BandRepository extends JpaRepository<BandEntity, Long> {

    BandEntity findById(Long id);

    BandEntity findByName(String name);

    BandEntity findByOwnerid(Long id);

    BandEntity findByDisabled(boolean disabled);

    @Modifying
    @Query("UPDATE BandEntity b SET b.disabled = :disabledValue WHERE b.id = :idValue")
    void updateDisabledAttribute(@Param("disabledValue")boolean disabled, @Param("idValue")Long id);
}
