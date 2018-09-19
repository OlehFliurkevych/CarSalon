package fo.auto.manager.controller;

import fo.auto.manager.dto.RestMessageDTO;
import fo.auto.manager.dto.UserDTO;
import fo.auto.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/",method= RequestMethod.POST)
    @ResponseBody
    public RestMessageDTO createUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @RequestMapping(value="/users/{id}",method=RequestMethod.GET)
    @ResponseBody
    public RestMessageDTO<UserDTO> getUserById(@RequestParam("id")Long userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(value="/users/update",method=RequestMethod.PATCH)
    @ResponseBody
    public RestMessageDTO<UserDTO> updateUser(@RequestBody UserDTO userDto){
        return userService.updateUser(userDto);
    }

    @RequestMapping(value="/users",method=RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
    @ResponseBody
    public RestMessageDTO deleteUser(@PathVariable("id")Long userId){
        return userService.deleteUser(userId);
    }


}
