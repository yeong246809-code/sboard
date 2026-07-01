package kr.co.sboard.service;

import kr.co.sboard.DTO.ArticleDTO;
import kr.co.sboard.DTO.PageRequestDTO;
import kr.co.sboard.DTO.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Log4j2
@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private ArticleService service;


    @Test
    void findAll() {
    }
}