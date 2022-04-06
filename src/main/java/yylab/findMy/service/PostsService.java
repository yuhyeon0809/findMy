package yylab.findMy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yylab.findMy.domain.posts.Posts;
import yylab.findMy.domain.posts.PostsRepository;
import yylab.findMy.web.posts.PostsDto;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(Posts posts) {
        long start = System.currentTimeMillis();

        try {
            //validateMember(member);
            postsRepository.save(posts);
            return posts.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("save: " + timeMs + "ms");
        }
    }
}
