package app.service;

import app.entity.User;
import app.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final User user;

    public UserService(UserRepo userRepo, User user) {
        this.userRepo = userRepo;
        this.user = user;
    }


    public void register(User user){
        userRepo.save(user);
    }

    public boolean isLoginTrue(User auth){
        if (auth.getEmail().equals(user.getEmail()) && auth.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
