package in.sampleweb.domain.data.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sampleweb.domain.data.dto.RegisterFormDTO;
import in.sampleweb.domain.data.entity.CountryEntity;
import in.sampleweb.domain.data.entity.UserEntity;
import in.sampleweb.domain.data.service.UserService;

@Controller
@CrossOrigin("*")
public class RegistrationController {

    @Autowired
    private UserService userService;
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new UserEntity());
//        model.addAttribute("countries", getCountries());
//        return "register"; 
//    }
//
//    // Method to fetch countries (mock or from database)
//    private List<CountryEntity> getCountries() {
//        // Replace with real data retrieval
//        return Arrays.asList(
//            new CountryEntity(1, "India"),
//            new CountryEntity(2, "USA")
//        );
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") RegisterFormDTO regFormDTO) {
//        userService.saveUser(regFormDTO);
//        return "redirect:/register?success";
//    }
    
   

}
