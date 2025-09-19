package com.example.Cache.Service;

import com.example.Cache.Modellor.User;
import com.example.Cache.Repository.UserDAU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class UserService {

    @Autowired
    private UserDAU userDAU;

    @Cacheable(value = "User", key = "10")
    public User getUserBYID(int id) {
       return userDAU.findById(id).orElse(null);
    }

    public User create(User user) {
        return userDAU.save(user);
    }

    @CachePut(value="User", key = "10")
    public User update(User user, int id) {
        if(userDAU.findById(id).isPresent()){
            return userDAU.save(user);
        }
        return null;
    }

    @CacheEvict(value = "User", key = "10")
    public void delete(int id) {
        if(userDAU.findById(id).isPresent()){
            userDAU.deleteById(id);

        }
    }
}
