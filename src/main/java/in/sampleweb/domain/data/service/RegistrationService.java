package in.sampleweb.domain.data.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.sampleweb.domain.data.entity.UserEntity;

@Service
public class RegistrationService {

    @Autowired
    private JavaMailSender mailSender;

    public String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        while (password.length() < length) {
            int index = (int) (rnd.nextFloat() * chars.length());
            password.append(chars.charAt(index));
        }
        return password.toString();
    }

    public void sendPasswordEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your Registration Password");
        message.setText("Your generated password is: " + password);
        mailSender.send(message);
    }

    public void registerUser(UserEntity user) {
        String password = generateRandomPassword(8);
        user.setPwd(password);
        // save user to database
        sendPasswordEmail(user.getEmail(), password);
    }
}
