package kr.co.sboard.DAO;


import kr.co.sboard.DTO.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {

    public void insert(CommentDTO dto);
    public CommentDTO select(int cno);
    public List<CommentDTO> selectAll();
    public void update(CommentDTO dto);
    public void delete(int cno);
}
