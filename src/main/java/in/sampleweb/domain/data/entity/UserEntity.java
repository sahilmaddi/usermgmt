package in.sampleweb.domain.data.entity;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "USER_MASTER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String uname;
    private String email;
    private Long phno;
    private String pwd;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private StateEntity state;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private CityEntity city;

    private String pwdReset;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    // Getters and setters
}

