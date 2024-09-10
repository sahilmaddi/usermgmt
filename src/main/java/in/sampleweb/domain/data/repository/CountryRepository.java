package in.sampleweb.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sampleweb.domain.data.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {}