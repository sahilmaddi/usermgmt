package in.sampleweb.domain.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CITIES_MASTER")
@Data
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private StateEntity state;

    // Getters and setters
}
