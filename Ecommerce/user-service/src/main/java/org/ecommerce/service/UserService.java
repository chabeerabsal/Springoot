package org.ecommerce.service;



import org.ecommerce.dto.UserDto;
import org.ecommerce.entity.User;

import java.util.UUID;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(UUID id);
}