package com.example.Day4_Spring.Security.Config;

import com.example.Day4_Spring.Security.Modellor.AppUser;
import com.example.Day4_Spring.Security.Repository.UserRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service



    public class CustomUserDetailsService implements UserDetailsService {



        @Autowired
        private UserRepoJPA repo;

        @Override
        public UserDetails loadUserByUsername(String username) {
            AppUser user = repo.findByUsername(username);
            if (user == null) throw new UsernameNotFoundException("User not found");

            return User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole().replace("ROLE_", ""))
                    .build();

        }

        @Bean

        public static PasswordEncoder passwordEncoder() {
            return NoOpPasswordEncoder.getInstance();

            // NOT SAFE — for practice only



        }
    }



