package bg.softuni.libra.service;

import bg.softuni.libra.mapper.UserMapper;
import bg.softuni.libra.model.dto.UserDTO;
import bg.softuni.libra.model.dto.UserRegisterDTO;
import bg.softuni.libra.model.entity.UserEntity;
import bg.softuni.libra.model.entity.UserRoleEntity;
import bg.softuni.libra.model.entity.enums.UserRoleEnum;
import bg.softuni.libra.repository.UserRepository;
import bg.softuni.libra.repository.UserRoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserDetailsService userDetailsService;


    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userDetailsService = userDetailsService;
    }
    public void usersInit() {
        // admin
        UserEntity admin = new UserEntity();
        admin.setEmail("atanas.kaloyanov@yahoo.com");
        admin.setPassword(this.passwordEncoder.encode("55555"));
        admin.setFirstName("Atanas");
        admin.setLastName("Kaloyanov");
        admin.setActive(true);

        UserRoleEnum adminEnum = UserRoleEnum.ADMIN;
        UserRoleEntity adminRoleEntity = this.userRoleRepository.findByUserRole(adminEnum).orElseThrow();

        UserRoleEnum secondAdminEnum = UserRoleEnum.USER;
        UserRoleEntity adminSecondRoleEntity = this.userRoleRepository.findByUserRole(secondAdminEnum).orElseThrow();

        List<UserRoleEntity> adminList = new ArrayList<>();
        adminList.add(adminRoleEntity);
        adminList.add(adminSecondRoleEntity);
        admin.setUserRoles(adminList);

        this.userRepository.save(admin);

        // moderator
        UserEntity moderator = new UserEntity();
        moderator.setEmail("ivan.ivanov@yahoo.com");
        moderator.setPassword(this.passwordEncoder.encode("55555"));
        moderator.setFirstName("Ivan");
        moderator.setLastName("Ivanov");
        moderator.setActive(true);

        UserRoleEnum moderatorEnum = UserRoleEnum.MODERATOR;
        UserRoleEntity moderatorRoleEntity = this.userRoleRepository.findByUserRole(moderatorEnum).orElseThrow();
        moderatorRoleEntity.setUserRole(moderatorEnum);

        List<UserRoleEntity> moderatorList = new ArrayList<>();
        moderatorList.add(moderatorRoleEntity);
        moderator.setUserRoles(moderatorList);

        this.userRepository.save(moderator);

        // firstUser
        UserEntity firstUser = new UserEntity();
        firstUser.setEmail("maria.georgieva@yahoo.com");
        firstUser.setPassword(this.passwordEncoder.encode("55555"));
        firstUser.setFirstName("Maria");
        firstUser.setLastName("Georgieva");
        firstUser.setActive(true);

        UserRoleEnum firstUserEnum = UserRoleEnum.USER;
        UserRoleEntity firstUserRoleEntity = this.userRoleRepository.findByUserRole(firstUserEnum).orElseThrow();
        firstUserRoleEntity.setUserRole(firstUserEnum);

        List<UserRoleEntity> firstUserList = new ArrayList<>();
        firstUserList.add(firstUserRoleEntity);
        firstUser.setUserRoles(firstUserList);

        this.userRepository.save(firstUser);

        // secondUser
        UserEntity secondUser = new UserEntity();
        secondUser.setEmail("sofia.ivanova@yahoo.com");
        secondUser.setPassword(this.passwordEncoder.encode("55555"));
        secondUser.setFirstName("Sofia");
        secondUser.setLastName("Ivanova");
        secondUser.setActive(true);

        UserRoleEnum secondUserEnum = UserRoleEnum.USER;
        UserRoleEntity secondUserRoleEntity = this.userRoleRepository.findByUserRole(secondUserEnum).orElseThrow();
        secondUserRoleEntity.setUserRole(secondUserEnum);

        List<UserRoleEntity> secondUserList = new ArrayList<>();
        secondUserList.add(secondUserRoleEntity);
        secondUser.setUserRoles(secondUserList);

        this.userRepository.save(secondUser);

        // thirdUser
        UserEntity thirdUser = new UserEntity();
        thirdUser.setEmail("dimitar.dimitrov@yahoo.com");
        thirdUser.setPassword(this.passwordEncoder.encode("55555"));
        thirdUser.setFirstName("Dimitar");
        thirdUser.setLastName("Dimitrov");
        thirdUser.setActive(true);

        UserRoleEnum thirdUserEnum = UserRoleEnum.USER;
        UserRoleEntity thirdUserRoleEntity = this.userRoleRepository.findByUserRole(thirdUserEnum).orElseThrow();
        secondUserRoleEntity.setUserRole(thirdUserEnum);

        List<UserRoleEntity> thirdUserList = new ArrayList<>();
        thirdUserList.add(thirdUserRoleEntity);
        thirdUser.setUserRoles(thirdUserList);

        this.userRepository.save(thirdUser);
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);
    }

    private void login(UserEntity userEntity) {
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }

    private UserDTO mapUserDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());

        return userDTO;
    }

    public UserDTO findUserByEmail(String email) {
        UserEntity user = this.userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return null;
        }

        return mapUserDTO(user);
    }

}
