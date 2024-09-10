package in.sampleweb.domain.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sampleweb.domain.data.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    List<CityEntity> findByStateStateId(Integer stateId);
}