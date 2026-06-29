package kr.co.sboard.service;

import kr.co.sboard.DAO.ArticleDAO;
import kr.co.sboard.DTO.ArticleDTO;
import kr.co.sboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleDAO dao;
    private final ArticleRepository rep;

    public ArticleDTO get(int ano){
        return null;
    }
    public List<ArticleDTO> getAll(){
        return null;
    }
    public void register(ArticleDTO dto){


    }
    public void modify(ArticleDTO dto){

    }
    public void remove(int ano){

    }


}
