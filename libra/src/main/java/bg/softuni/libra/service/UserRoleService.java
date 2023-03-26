package bg.softuni.libra.service;


import bg.softuni.libra.model.entity.UserRoleEntity;
import bg.softuni.libra.model.entity.enums.UserRoleEnum;
import bg.softuni.libra.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void userRolesInit() {
        Arrays.stream(UserRoleEnum.values()).forEach(
                role -> {
                    UserRoleEntity currentEntity = new UserRoleEntity();
                    currentEntity.setUserRole(role);
                    this.userRoleRepository.save(currentEntity);
                }
        );
    }
}
