package com.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/member1/join.do")
public class JoinController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/member1/Join.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 진입 성공!");
        req.setCharacterEncoding("UTF-8");

        String id = (req.getParameter("id"));
        String pw = req.getParameter("pw");
        String email = req.getParameter("email");

        MemberDao mDao = MemberDao.getInstance();
        MemberDTO mDto = new MemberDTO();

        mDto.setUser_id(id);
        mDto.setPassword(pw);
        mDto.setEmail(email);
        System.out.println(pw);
        int joinResult = mDao.join(mDto);

        if (joinResult == 1) {
            req.setAttribute("joinResult", joinResult);
            HttpSession session = req.getSession();
            session.setAttribute("sessionID", id);
            RequestDispatcher rd = req.getRequestDispatcher("/member1/Login.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("joinResult", 0);
            RequestDispatcher rd = req.getRequestDispatcher("../member1/Join.jsp");
            rd.forward(req, resp);
        }
    }
}
