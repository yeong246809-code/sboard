package kr.co.sboard.service;

import kr.co.sboard.DAO.ArticleDAO;
import kr.co.sboard.DTO.ArticleDTO;
import kr.co.sboard.DAO.ArticleDAO;
import kr.co.sboard.DTO.ArticleDTO;
import kr.co.sboard.entity.ArticleEntity;
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

    public int getLastPageNum(int total) {

        // 마지막 페이지 번호
        int lastPageNum = 0;

        if(total % 10 == 0){
            lastPageNum = total / 10;
        }else {
            lastPageNum = total / 10 + 1;
        }

        return lastPageNum;
    }

    public int getStart(int page){
        // 목록 LIMIT 시작값
        int start = (page - 1) * 10;
        return start;
    }

    public int getTotal(){
        return dao.selectCountAll();
    }

    public List<ArticleDTO> getAll(int start){

        // Mybatis
        List<ArticleDTO> dtoList = dao.selectAll(start);



        return dtoList;
    }

    public List<ArticleDTO> findAll(){

        // JPA
        List<ArticleEntity> entityList = rep.findAll();

        List<ArticleDTO> dtoList = entityList
                .stream()
                .map(entity -> entity.toDTO())
                .toList();
        return dtoList;
    }

    public void register(ArticleDTO dto){
        dao.insert(dto);
    }

    public int getPageGroupStart(int page){
        return ((page - 1) / 10) * 10 + 1;
    }
    public int getPageGroupEnd(int page, int lastPageNum){
        int end = getPageGroupStart(page) + 9;
        if(end > lastPageNum){
            end = lastPageNum;
        }
        return end;
    }

    public void modify(ArticleDTO dto){

    }
    public void remove(int ano){

    }
}