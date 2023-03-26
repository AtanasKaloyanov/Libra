package bg.softuni.libra.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher")
public class PublisherEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<WriterEntity> writers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WriterEntity> getWriters() {
        return writers;
    }

    public void setWriters(List<WriterEntity> writers) {
        this.writers = writers;
    }

    @Override
    public String toString() {
        return "PublisherEntity{" +
                "name='" + name + '\'' +
                ", writers=" + writers +
                '}';
    }
}
