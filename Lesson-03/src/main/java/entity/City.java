package entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "CITIES")
public class City implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String name;

    public City (String s) {
        this.name=s;
    }

    public City() {

    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}