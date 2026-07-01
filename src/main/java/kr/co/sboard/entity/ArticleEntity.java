package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.DTO.ArticleDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ano;
    private String category;
    private String title;
    private String content;
    private int comment;
    private int file;
    private int hit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private UserEntity user;

    private String regip;

    @CreationTimestamp
    private LocalDateTime wdate;


    public ArticleDTO toDTO(){

        return ArticleDTO.builder()
                .ano(ano)
                .category(category)
                .title(title)
                .content(content)
                .comment(comment)
                .file(file)
                .hit(hit)
                .nick(user.getNick())
                .regip(regip)
                .wdate(wdate.toString())
                .build();

    }
}
