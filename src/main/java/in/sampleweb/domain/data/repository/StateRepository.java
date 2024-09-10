package in.sampleweb.domain.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sampleweb.domain.data.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {
    List<StateEntity> findByCountryCountryId(Integer countryId);
}