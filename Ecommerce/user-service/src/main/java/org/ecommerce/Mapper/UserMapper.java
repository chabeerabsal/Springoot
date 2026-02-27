package org.ecommerce.Mapper;


import org.ecommerce.dto.UserDto;
import org.ecommerce.entity.User;

public class UserMapper {

    // Entity → DTO
    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    // DTO → Entity
    public static User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId()) // can be null for create
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }
}