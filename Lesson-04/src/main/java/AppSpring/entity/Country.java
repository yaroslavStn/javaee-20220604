package AppSpring.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;

    @Column(name = "country")
    private String name;

    @OneToMany(mappedBy = "country", cascade =
            CascadeType.ALL)
    private final List<Region> regions = new ArrayList<>();


    public Country(String name) {
        this.name = name;

    }

    public Country() {
    }



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}