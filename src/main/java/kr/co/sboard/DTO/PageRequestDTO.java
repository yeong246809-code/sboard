package kr.co.sboard.DTO;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageRequestDTO {

    @Builder.Default
    private int no = 1;

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    @Builder.Default
    private String type = "free";

    private String searchType;
    private String keyword;

    @Builder.Default
    private int start = 0;

    public int getStart(){
        return (page - 1) * size;
    }

    //JPA 에서 페이징 처리를 위한 pageable 생성
    public Pageable getPageable(String sort){
        return PageRequest.of(this.page - 1, this.size, Sort.by(sort).descending());
    }


}
