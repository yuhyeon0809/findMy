package yylab.findMy.web.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yylab.findMy.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
