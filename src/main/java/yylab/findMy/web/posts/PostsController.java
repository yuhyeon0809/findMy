package yylab.findMy.web.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yylab.findMy.domain.posts.Posts;
import yylab.findMy.service.PostsService;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/posts/post")
    public Long save(@RequestBody PostsDto requestDto) {
        Posts posts = new Posts();
        posts.setTitle(requestDto.getTitle());
        posts.setContent(requestDto.getContent());
        posts.setAuthor(requestDto.getAuthor());
        return postsService.save(posts);
    }
}
