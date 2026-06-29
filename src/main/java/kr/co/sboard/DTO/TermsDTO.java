package kr.co.sboard.DTO;

import kr.co.sboard.entity.TermsEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TermsDTO {

    private int no;
    private String basic;
    private String privacy;
    public TermsEntity toEntity(){

        return TermsEntity.builder()
                .no(no)
                .basic(basic)
                .privacy(privacy)
                .build();


    }
}
