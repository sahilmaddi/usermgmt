package in.sampleweb.domain.data.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import in.sampleweb.domain.data.dto.LoginFormDTO;
import in.sampleweb.domain.data.dto.RegisterFormDTO;
import in.sampleweb.domain.data.dto.ResetPwdFormDTO;
import in.sampleweb.domain.data.dto.UserDTO;

@Service
public interface UserService {
    Map<Integer, String> getCountries();

    Map<Integer, String> getStates(Integer countryId);

    Map<Integer, String> getCities(Integer stateId);

    boolean duplicateEmailCheck(String email);

    boolean saveUser(RegisterFormDTO regFormDTO);

    UserDTO login(LoginFormDTO loginFormDTO);

    boolean resetPwd(ResetPwdFormDTO resetPwdDTO);

    boolean authenticateUser(String email, String password);

    boolean resetPassword(String email);
}
