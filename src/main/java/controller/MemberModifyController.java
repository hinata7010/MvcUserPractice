package controller;

import dto.MemberDTO;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "memberModifyController", urlPatterns = "/member/modify")
public class MemberModifyController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("todo modify call");
        String mid = req.getParameter("mid");
        System.out.println(mid);
        MemberDTO memberDTO = null;
        try {
            memberDTO = memberService.selectOne(mid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("dto", memberDTO);
        req.getRequestDispatcher("/WEB-INF/member/modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HTML 폼에서 전송된 데이터 가져오기
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        String mname = req.getParameter("mname");
        String email = req.getParameter("email");


        // DTO 객체 생성
        MemberDTO memberDTO = MemberDTO.builder().mid(mid).mpw(mpw).mname(mname).email(email).build();


        // DTO 객체 출력 (디버깅용)
        System.out.println(memberDTO);

        // TodoService를 사용하여 DTO 객체 수정
        try {
            memberService.modify(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 수정된 결과를 리스트 페이지로 리다이렉트
        resp.sendRedirect("/member/list");
    }


}