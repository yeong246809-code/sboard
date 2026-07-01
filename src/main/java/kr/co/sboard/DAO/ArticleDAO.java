package kr.co.sboard.DAO;


import kr.co.sboard.DTO.ArticleDTO;
import kr.co.sboard.DTO.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {

    public void insert(ArticleDTO dto);
    public ArticleDTO select(int ano);
    public List<ArticleDTO> selectAll(PageRequestDTO pageRequestDTO);

    public int selectCountAll();

    public void update(ArticleDTO dto);
    public void delete(int ano);
}
