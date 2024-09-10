package in.sampleweb.domain.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sampleweb.domain.data.entity.CityEntity;
import in.sampleweb.domain.data.entity.CountryEntity;
import in.sampleweb.domain.data.entity.StateEntity;
import in.sampleweb.domain.data.repository.CityRepository;
import in.sampleweb.domain.data.repository.CountryRepository;
import in.sampleweb.domain.data.repository.StateRepository;

@Service
public class LocationService {

    @Autowired
    private CountryRepository countryRepository;
    
    @Autowired
    private StateRepository stateRepository;
    
    @Autowired
    private CityRepository cityRepository;

    public List<CountryEntity> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<StateEntity> getStatesByCountry(Integer countryId) {
        return stateRepository.findByCountryCountryId(countryId);
    }

    public List<CityEntity> getCitiesByState(Integer stateId) {
        return cityRepository.findByStateStateId(stateId);
    }
}
