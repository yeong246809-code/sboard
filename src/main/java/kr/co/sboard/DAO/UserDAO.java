package kr.co.sboard.DAO;


import kr.co.sboard.DTO.ArticleDTO;
import kr.co.sboard.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    public void insert(UserDTO dto);
    public UserDTO select(String userid);
    public List<UserDTO> selectAll();
    public void update(UserDTO dto);
    public void delete(String userid);
}
