package org.ecommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.ecommerce.Mapper.UserMapper;
import org.ecommerce.constants.UserConstants;
import org.ecommerce.dto.UserDto;
import org.ecommerce.entity.User;
import org.ecommerce.exceptions.EmailAlreadyExistsException;
import org.ecommerce.exceptions.UserNotFoundException;
import org.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        log.info("Creating user with email: {}", userDto.getEmail());

        userRepository.findByEmail(userDto.getEmail())
                .ifPresent(u -> {
                    throw new EmailAlreadyExistsException(
                            String.format(UserConstants.EMAIL_ALREADY_EXISTS, userDto.getEmail()));
                });

        User savedUser = userRepository.save(UserMapper.toEntity(userDto));

        log.info("User created with id: {}", savedUser.getId());

        return UserMapper.toDto(savedUser);
    }

    @Override
    public UserDto getUserById(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format(UserConstants.USER_NOT_FOUND, id)));

        log.info("Fetched user with id: {}", id);

        return UserMapper.toDto(user);
    }
}