package kr.co.sboard.controller;

import jakarta.mail.Session;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.sboard.DTO.AppInfoDTO;
import kr.co.sboard.DTO.TermsDTO;
import kr.co.sboard.DTO.UserCheckDTO;
import kr.co.sboard.DTO.UserDTO;
import kr.co.sboard.service.Emailservice;
import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService us;
    private final TermsService ts;
    private final Emailservice es;


    @GetMapping("/user/info")
    public String info(){

        return "/user/info";

    }
    @GetMapping("/user/login")
    public String login(){

        return "/user/login";

    }
    @GetMapping("/user/register")
    public String register(){
        return "/user/register";

    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO, HttpServletRequest req){
        // 클라이언트 IP
        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);

        log.info(userDTO);

        // 등록 서비스 호출
        us.register(userDTO);

        // 로그인 이동
        return "redirect:/user/login?register=success";
    }

    @GetMapping("/user/terms")
    public String terms(Model model){

        TermsDTO tDTO = ts.get(1);
        log.info(tDTO);

        model.addAttribute(tDTO);

        return "/user/terms";

    }

    @ResponseBody
    @GetMapping("/user/check")
    public ResponseEntity<Map<String, Integer>> check(UserCheckDTO dto, HttpSession session){
        log.info(dto);

        int count = us.getCount(dto);

        if(dto.getType().equals("email") && count == 0){
            String code = es.sendcode(dto.getValue());
            session.setAttribute("sesscode", code);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("count", count));


    }

    @ResponseBody
    @PostMapping("/user/check")
    public ResponseEntity<Map<String, Integer>> check(@RequestBody Map<String,String> jsondata, HttpSession session){

        log.info(jsondata.get("code"));
        //세션에 저장된 코드와 클라이언트가 전송한 코드가 일치하는 경우
        String sesscode = (String) session.getAttribute("sesscode");

        String jsoncode = jsondata.get("code");

        if(sesscode.equals(jsoncode)){

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("count", 0));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("count", 1));

    }


}
