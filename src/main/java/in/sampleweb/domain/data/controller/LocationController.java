package in.sampleweb.domain.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sampleweb.domain.data.entity.CityEntity;
import in.sampleweb.domain.data.entity.CountryEntity;
import in.sampleweb.domain.data.entity.StateEntity;
import in.sampleweb.domain.data.service.LocationService;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/countries")
    public List<CountryEntity> getAllCountries() {
        return locationService.getAllCountries();
    }

    @GetMapping("/states/{countryId}")
    public List<StateEntity> getStatesByCountry(@PathVariable Integer countryId) {
        return locationService.getStatesByCountry(countryId);
    }

    @GetMapping("/cities/{stateId}")
    public List<CityEntity> getCitiesByState(@PathVariable Integer stateId) {
        return locationService.getCitiesByState(stateId);
    }
}
