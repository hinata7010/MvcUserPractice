package controller;

import dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "memberRegisterController", urlPatterns = "/member/register")
public class MemberRegisterController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("register call");
        req.getRequestDispatcher("/WEB-INF/member/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        String mname = req.getParameter("mname");
        String email = req.getParameter("email");
        MemberDTO memberDTO = MemberDTO.builder().mid(mid).mpw(mpw).mname(mname).email(email).build();
        System.out.println(memberDTO);
        try {
            memberService.register(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(memberDTO);
        resp.sendRedirect("/login");
    }
}