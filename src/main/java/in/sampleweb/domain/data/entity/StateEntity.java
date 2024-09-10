package in.sampleweb.domain.data.entity;

import jakarta.persistence.Column;
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
@Table(name = "STATES_MASTER")
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATE_ID")
    private Integer stateId;

    @Column(name = "STATE_NAME", nullable = false)
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false) 
    private CountryEntity country;
}
