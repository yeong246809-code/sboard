package kr.co.sboard.DTO;

import kr.co.sboard.entity.CommentEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {

    private int cno;
    private int parent;
    private String content;
    private String writer;
    private String regip;
    private String wdate;

    public CommentEntity toEntity(){

        return CommentEntity.builder()
                .cno(cno)
                .parent(parent)
                .content(content)
                .writer(writer)
                .regip(regip)
                .build();


    }
}
