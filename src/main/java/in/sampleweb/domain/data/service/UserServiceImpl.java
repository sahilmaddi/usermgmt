package in.sampleweb.domain.data.service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sampleweb.domain.data.dto.LoginFormDTO;
import in.sampleweb.domain.data.dto.RegisterFormDTO;
import in.sampleweb.domain.data.dto.ResetPwdFormDTO;
import in.sampleweb.domain.data.dto.UserDTO;
import in.sampleweb.domain.data.entity.CityEntity;
import in.sampleweb.domain.data.entity.CountryEntity;
import in.sampleweb.domain.data.entity.StateEntity;
import in.sampleweb.domain.data.entity.UserEntity;
import in.sampleweb.domain.data.repository.CityRepository;
import in.sampleweb.domain.data.repository.CountryRepository;
import in.sampleweb.domain.data.repository.StateRepository;
import in.sampleweb.domain.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CountryRepository countryRepo;

    @Autowired
    private StateRepository stateRepo;

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Map<Integer, String> getCountries() {
        return countryRepo.findAll().stream()
            .collect(Collectors.toMap(CountryEntity::getCountryId, CountryEntity::getCountryName));
    }

    @Override
    public Map<Integer, String> getStates(Integer countryId) {
        return stateRepo.findByCountryCountryId(countryId).stream()
            .collect(Collectors.toMap(StateEntity::getStateId, StateEntity::getStateName));
    }

    @Override
    public Map<Integer, String> getCities(Integer stateId) {
        return cityRepo.findByStateStateId(stateId).stream()
            .collect(Collectors.toMap(CityEntity::getCityId, CityEntity::getCityName));
    }

    @Override
    public boolean duplicateEmailCheck(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    @Override
    public boolean saveUser(RegisterFormDTO regFormDTO) {
        UserEntity user = new UserEntity();
        // Map regFormDTO fields to user entity and save
        userRepo.save(user);
        return true;
    }

    @Override
    public UserDTO login(LoginFormDTO loginFormDTO) {
        // Implement login logic
        return null;
    }

    @Override
    public boolean resetPwd(ResetPwdFormDTO resetPwdDTO) {
        // Implement reset password logic
        return false;
    }
    
    public boolean authenticateUser(String email, String password) {
        // Implement authentication logic, e.g., check email and password against the database
        UserEntity user = userRepo.findByEmail(email).get();
        return user != null && user.getPwd().equals(password);
    }

    public boolean resetPassword(String email) {
        // Implement password reset logic, e.g., generate a reset token and send an email
        Optional<UserEntity> user = userRepo.findByEmail(email);
        if (user != null) {
            // Generate reset token, send email, etc.
            return true;
        }
        return false;
    }
}
