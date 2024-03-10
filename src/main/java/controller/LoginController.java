package controller;

import dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        log.info("login get...");
        request.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        log.info("login post called");

        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");
        try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo",memberDTO);

            response.sendRedirect("/member/list");
        }catch (Exception e){
            response.sendRedirect("/login?result=error");
        }
    }
}
