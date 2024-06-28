package org.example.workshopmongodb.resources;

import org.example.workshopmongodb.domain.Post;
import org.example.workshopmongodb.resources.util.URL;
import org.example.workshopmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "v1/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "v1/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "v1/titlesearch")
    public ResponseEntity<List<Post>> getPostByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        List<Post> posts = postService.findByTitle(title);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "v1/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text") String text,
                                                 @RequestParam(value = "minDate") String minDate,
                                                 @RequestParam(value = "maxDate") String maxDate) {

        text = URL.decodeParam(text);
        Date min = URL.coonvertDate(minDate, new Date(0L));
        Date max = URL.coonvertDate(maxDate, new Date(0L));
        List<Post> posts = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(posts);
    }
}