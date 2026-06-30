package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.DTO.CommentDTO;
import kr.co.sboard.DTO.FileDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;
    private int ano;
    private String ofname;
    private String sfname;
    private int download;

    @CreationTimestamp
    private LocalDateTime rdate;

    public FileDTO toDTO(){
        return FileDTO.builder()
                .fno(fno)
                .ano(ano)
                .ofname(ofname)
                .sfname(sfname)
                .download(download)
                .rdate(rdate.toString())
                .build();


    }
}
