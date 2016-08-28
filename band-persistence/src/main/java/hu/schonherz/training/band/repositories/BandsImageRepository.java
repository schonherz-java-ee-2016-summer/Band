package hu.schonherz.training.band.repositories;

import hu.schonherz.training.band.entities.BandsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Lenovo on 2016.08.28..
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface BandsImageRepository extends JpaRepository<BandsImage, Long>{

    Collection<BandsImage> findAllBandsImage();

    Collection<BandsImage> findBandsImageByBandId(Long bandId);

    BandsImage findByName(String name);

    BandsImage findByFilename(String filename);

    BandsImage findById(Long id);
}
