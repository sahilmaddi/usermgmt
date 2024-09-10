package in.sampleweb.domain.data.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.sampleweb.domain.data.dto.LoginFormDTO;
import in.sampleweb.domain.data.dto.RegisterFormDTO;
import in.sampleweb.domain.data.dto.UserDTO;
import in.sampleweb.domain.data.entity.ResetPasswordForm;
import in.sampleweb.domain.data.entity.UserEntity;
import in.sampleweb.domain.data.service.UserService;
import jakarta.validation.Valid;

@Controller
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(Model model) {
	LoginFormDTO loginFormDTO = new LoginFormDTO();
	model.addAttribute("loginForm",loginFormDTO);
	return "login";
    }
    
    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("loginForm") LoginFormDTO loginFormDTO,
                            BindingResult bindingResult, Model model) {
       UserDTO userDTO = userService.login(loginFormDTO); 
        
        if (userDTO == null) {
            model.addAttribute("error", "Invalid credentials");
        }else {
            String pwdUpdated = userDTO.getPwdUpdated();
            
            if("Yes".equals(pwdUpdated)) {
        	return "redirect:dashboard";
            }else {
        	return "redirect:reset-password?email="+userDTO.getEmail();
            }
        }

        // Redirect on successful login
        return "redirect:/dashboard";
    }
    
    @GetMapping("/reset-pwd")
    public String showResetPasswordForm(Model model) {
        // Add any model attributes if needed (e.g. a message)
        model.addAttribute("email", new String());
        model.addAttribute("resetPasswordForm", new ResetPasswordForm());
        return "reset-password";  // Name of the Thymeleaf template for the reset form
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginFormDTO());
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        Map<Integer,String> countriesMap = userService.getCountries();
        model.addAttribute("countries",countriesMap);
        
        RegisterFormDTO registerFormDTO = new RegisterFormDTO();
        model.addAttribute("registerForm",registerFormDTO);
        
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(@Valid @ModelAttribute("registerForm") RegisterFormDTO regFormDTO, 
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("countries", userService.getCountries());
            return "register";
        }
        
        boolean status = userService.duplicateEmailCheck(regFormDTO.getEmail());
        if (status) {
            model.addAttribute("emsg", "Duplicate Email Found");
        } else {
            boolean saveUser = userService.saveUser(regFormDTO);
            if (saveUser) {
                model.addAttribute("smsg", "Registration Success, Please check your email..!!");
                return "success";
            } else {
                model.addAttribute("emsg", "Registration Failed!");
            }
        }
        model.addAttribute("countries", userService.getCountries());
        return "register";
    }


    @GetMapping("/states/{countryId}")
    @ResponseBody
    public Map<Integer, String> getStates(@RequestParam  @PathVariable Integer countryId) {
        return userService.getStates(countryId);
    }

    @GetMapping("/cities/{stateId}")
    @ResponseBody
    public Map<Integer, String> getCities(@RequestParam @PathVariable Integer stateId) {
        return userService.getCities(stateId);
    }
}
