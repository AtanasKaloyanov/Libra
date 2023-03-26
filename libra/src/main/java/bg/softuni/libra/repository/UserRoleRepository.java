package bg.softuni.libra.repository;


import bg.softuni.libra.model.entity.UserRoleEntity;
import bg.softuni.libra.model.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findByUserRole(UserRoleEnum userRole);
}
