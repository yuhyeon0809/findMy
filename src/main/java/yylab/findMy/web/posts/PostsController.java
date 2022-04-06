package yylab.findMy.web.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yylab.findMy.domain.posts.Posts;
import yylab.findMy.service.PostsService;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @GetMapping("/posts/post")
    public String post() {
        return "posts/postsForm";
    }

    @PostMapping("/posts/post")
    public String save(PostsDto requestDto) {
        Posts posts = new Posts();
        posts.setTitle(requestDto.getTitle());
        posts.setContent(requestDto.getContent());
        posts.setAuthor(requestDto.getAuthor());
        postsService.save(posts);

        return "redirect:/";
    }


}
