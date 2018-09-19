package fo.auto.manager.service.impl;

import com.mysql.jdbc.StringUtils;
import fo.auto.manager.dto.RestMessageDTO;
import fo.auto.manager.dto.UserDTO;
import fo.auto.manager.entity.User;
import fo.auto.manager.repository.UserRepository;
import fo.auto.manager.service.UserService;
import fo.auto.manager.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private ObjectMapperUtils modelMapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ObjectMapperUtils modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public RestMessageDTO saveUser(UserDTO userDto) {
        if(StringUtils.isNullOrEmpty(userDto.getFirstName())||
        StringUtils.isNullOrEmpty(userDto.getSecondName())||
        StringUtils.isNullOrEmpty(userDto.getUserROLE().toString())||
        userDto.getId() <= 0){
            throw new RuntimeException("Invalid data");
        }
        User entity=modelMapper.map(userDto,User.class);
        userRepository.save(entity);
        return RestMessageDTO.createCorrectMessage("Save user");
    }

    @Override
    public RestMessageDTO<UserDTO> getUserById(Long id) {
        if(id <= 0) {
            throw new RuntimeException("Invalid data");
        }
        Optional<User> entity=userRepository.findById(id);
        if (!entity.isPresent()){
            throw new RuntimeException("Invalid data");
        }
        UserDTO userDTO=modelMapper.map(entity.get(),UserDTO.class);
        return new RestMessageDTO<>(userDTO,true);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> carEntities = userRepository.findAll();
        List<UserDTO> userDtos = modelMapper.mapAll(carEntities, UserDTO.class);
        return userDtos;
    }

    @Override
    public RestMessageDTO deleteUser(Long id)
    {
        if(id <= 0){
            throw new RuntimeException("Invalid data");
        }
        userRepository.deleteById(id);
        return RestMessageDTO.createCorrectMessage("Delete user");
    }

    @Override
    public RestMessageDTO<UserDTO> updateUser(UserDTO userDto) {
        if(userDto.getId() <= 0){
            throw new RuntimeException("Invalid data");
        }
        Optional<User> entity=userRepository.findById(userDto.getId());
        User user;
        if(!entity.isPresent()){
            throw new RuntimeException("Invalid data");
        }else{
            user=entity.get();
        }
        if(!StringUtils.isNullOrEmpty(userDto.getFirstName())){
            user.setFirstName(userDto.getFirstName());
        }
        if(!StringUtils.isNullOrEmpty(userDto.getSecondName())){
            user.setSecondName(userDto.getSecondName());
        }
        if(!StringUtils.isNullOrEmpty(userDto.getUserROLE().toString())){
            user.setUserRole(userDto.getUserROLE());
        }

        return null;
    }
}
