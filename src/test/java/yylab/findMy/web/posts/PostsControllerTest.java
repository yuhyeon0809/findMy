package yylab.findMy.web.posts;

import org.aspectj.lang.annotation.AfterThrowing;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import yylab.findMy.domain.posts.Posts;
import yylab.findMy.domain.posts.PostsRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 호스트가 사용하지 않는 랜덤 port 사용
class PostsControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterThrowing
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void post_등록() throws Exception {
        //given
        String title = "test title";
        String content = "test content";

        PostsDto requestDto = PostsDto.builder()
                .title(title)
                .content(content)
                .author("youhyun")
                .build();

        String url = "/posts/post";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }
}