package fo.auto.manager.service;

import fo.auto.manager.dto.RestMessageDTO;
import fo.auto.manager.dto.UserDTO;

import java.util.List;

public interface UserService {

    RestMessageDTO saveUser(UserDTO userDto);
    RestMessageDTO<UserDTO> getUserById(Long id);
    List<UserDTO> getAllUsers();
    RestMessageDTO deleteUser(Long id);
    RestMessageDTO<UserDTO> updateUser(UserDTO userDto);

}
