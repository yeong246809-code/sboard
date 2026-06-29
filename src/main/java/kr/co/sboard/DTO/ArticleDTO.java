package kr.co.sboard.DTO;

import kr.co.sboard.entity.ArticleEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private int ano;
    private String category;
    private String title;
    private String content;
    private int comment;
    private int file;
    private int hit;
    private String writer;
    private String regip;
    private String wdate;
    public ArticleEntity toEntity(){
        return ArticleEntity.builder()
                .ano(ano)
                .category(category)
                .title(title)
                .content(content)
                .comment(comment)
                .file(file)
                .hit(hit)
                .writer(writer)
                .regip(regip)
                .build();

    }
}
