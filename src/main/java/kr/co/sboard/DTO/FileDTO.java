package kr.co.sboard.DTO;

import kr.co.sboard.entity.FileEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDTO {

    private int fno;
    private int ano;
    private String ofname;
    private String sfname;
    private int download;
    private String rdate;
    public FileEntity toEntity(){
        return FileEntity.builder()
                .fno(fno)
                .ano(ano)
                .ofname(ofname)
                .sfname(sfname)
                .download(download)
                .build();


    }
}
