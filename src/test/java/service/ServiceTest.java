package service;

import dto.MemberDTO;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    MemberService memberService = MemberService.INSTANCE;
    @Test
    public void insertTest(){
        MemberDTO memberDTO = new MemberDTO("koo", "admin1234", "구민석", "1234minseok@naver.com", null);
        try {
            memberService.register(memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
