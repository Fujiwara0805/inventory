package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        userRepository.insert(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User authenticateUser(User user){
        User foundUser = userRepository.findByUsername(user.getUsername());
        if(foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser;
        } else {
            return null;
        }
    }

    public User findById(long id){
        return userRepository.findById(id);
    }

    public User updateUser(User user){
        userRepository.update(user);
        return user;
    }

    public void deleteUser(long id){
        userRepository.delete(id);
    }
}
