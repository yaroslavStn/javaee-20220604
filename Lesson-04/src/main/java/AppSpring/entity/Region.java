package AppSpring.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "regions")
public class Region implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Integer id;

    @Column(name = "region")
    private String name;

    @OneToMany(cascade = {
            CascadeType.ALL
    })
    private final List<City> cities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private Country country;


    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
               ", name='" + name + '\'' +
                ", " + country +
                '}';
    }
}