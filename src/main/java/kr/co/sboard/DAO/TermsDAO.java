package kr.co.sboard.DAO;


import kr.co.sboard.DTO.ArticleDTO;
import kr.co.sboard.DTO.TermsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TermsDAO {

    public void insert(TermsDTO dto);
    public TermsDTO select(int no);
    public List<TermsDTO> selectAll();
    public void update(TermsDTO dto);
    public void delete(int no);
}
