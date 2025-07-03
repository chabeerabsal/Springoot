package com.example.Day4_Pagination.Controller;

import com.example.Day4_Pagination.Modellor.Post;
import com.example.Day4_Pagination.Repostiory.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
   private PostRepo postRepo;

    @PostMapping
    public void post(@RequestBody Post post) {
        postRepo.save(post);
    }

    @GetMapping
    public Page<Post> getPosts(   @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "id") String sortBy,
                                  @RequestParam(defaultValue = "asc") String order
    ) {
        Sort sort = order.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return postRepo.findAll(pageable);

    }

    @GetMapping("/filter")
    public List<Post> filterByAuthor(@RequestParam String author) {
        return postRepo.findByAuthor(author);
    }

    // Search by title
    @GetMapping("/search")
    public List<Post> searchByTitle(@RequestParam String keyword) {
        return postRepo.findByTitleContaining(keyword);
    }
}
