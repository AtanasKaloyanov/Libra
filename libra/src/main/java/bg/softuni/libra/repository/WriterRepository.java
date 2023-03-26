package bg.softuni.libra.repository;


import bg.softuni.libra.model.entity.WriterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<WriterEntity, Long> {
}
