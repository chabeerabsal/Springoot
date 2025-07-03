package com.example.Day4_Pagination.Repostiory;

import com.example.Day4_Pagination.Modellor.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByAuthor(String author);

    // Search
    List<Post> findByTitleContaining(String keyword);
}
