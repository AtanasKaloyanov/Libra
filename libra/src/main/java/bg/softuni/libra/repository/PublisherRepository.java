package bg.softuni.libra.repository;


import bg.softuni.libra.model.entity.PublisherEntity;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
}
