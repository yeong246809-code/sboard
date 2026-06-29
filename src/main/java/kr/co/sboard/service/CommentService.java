package kr.co.sboard.service;

import kr.co.sboard.DAO.CommentDAO;
import kr.co.sboard.DTO.CommentDTO;
import kr.co.sboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentDAO dao;
    private final CommentRepository rep;

    public CommentDTO get(int cno){
        return null;
    }
    public List<CommentDTO> getAll(){
        return null;
    }
    public void register(CommentDTO dto){


    }
    public void modify(CommentDTO dto){

    }
    public void remove(int cno){
        
    }


}
