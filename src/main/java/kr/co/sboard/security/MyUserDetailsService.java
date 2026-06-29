package kr.co.sboard.security;

import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository usrep;

    //UserdetailsService 호출하는 AuthenticationProvider에서 username(사용자아이디)를 전달
    //AuthenticationProvider 에서 실제 사용자 아이디, 비밀번호 인증을 수행
    //인증 성공 후 loadUserByusername메서드와매개변수 username 으로 인증된 사용자 아이디 전달
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //사용자 조회 후 시큐리티 인증객체(UserDetails) 반환
        Optional<UserEntity> optuser =  usrep.findById(username);
        if(optuser.isPresent()){
            MyUserDetails det = MyUserDetails.builder()
                    .user(optuser.get())
                    .build();
            return det;
        }
        return null;
    }
}
