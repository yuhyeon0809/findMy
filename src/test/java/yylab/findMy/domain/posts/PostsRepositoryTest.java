package yylab.findMy.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PostRepositoryTest {

    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void upload_open() {

        //given
        String title = "테스트 게시물";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title("테스트 게시물")
                .content("테스트 본문")
                .author("youhyun")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
    }

}