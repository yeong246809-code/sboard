package kr.co.sboard.service;

import kr.co.sboard.DAO.UserDAO;
import kr.co.sboard.DTO.UserCheckDTO;
import kr.co.sboard.DTO.UserDTO;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDAO dao;
    private final UserRepository rep;
    private final PasswordEncoder passwordEncoder;

    public UserDTO get(String userid){
        return null;
    }
    public List<UserDTO> getAll(){
        return null;
    }
    public int getCount(UserCheckDTO dto){
        int count = 0;
        //jpa
       if(dto.getType().equals("userid")){
           count = rep.countByUserid(dto.getValue());
       }else if(dto.getType().equals("nick")){
           count = rep.countByNick(dto.getValue());
       } else if (dto.getType().equals("hp")) {
           count = rep.countByHp(dto.getValue());
       } else if (dto.getType().equals("email")) {
           count = rep.countByEmail(dto.getValue());
       }

        return count;
    }
    public void register(UserDTO dto){
        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);

        // Mybatis
        dao.insert(dto);

        // JPA
        //repository.save(dto.toEntity());

    }
    public void modify(UserDTO dto){

    }

    public void remove(String userid){

    }


}
