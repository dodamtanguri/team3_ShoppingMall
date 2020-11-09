package kr.or.bit.shoppingMall.Controller;

import kr.or.bit.shoppingMall.Action.ActionForward;
import kr.or.bit.shoppingMall.Action.action;
import kr.or.bit.shoppingMall.Service.SignUpMemberService;
import kr.or.bit.shoppingMall.Service.deleteMemberService;
import kr.or.bit.shoppingMall.Service.mainService;
import kr.or.bit.shoppingMall.Service.signUpPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; UTF-8");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String urlCommand = requestURI.substring(contextPath.length());
        String method = request.getMethod();


        action action = null;
        ActionForward forward = new ActionForward();
        //ActionForward 초기화 해주기 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        if (urlCommand.equals("/main.do")) { // 메인 페이지
            action = new mainService();
            forward = action.execute(request, response);
        } else if (urlCommand.equals("/signUpPage.do")) {
            System.out.println("2");
            assert forward != null;
            forward.setRedirect(false);
            System.out.println("2-1");
            forward.setPath("/WEB-INF/views/SignUp.jsp");
        } else if (urlCommand.equals("/SignUp.do")) {
            System.out.println("4");
            action = new SignUpMemberService();
            forward = action.execute(request, response);

        } else if (urlCommand.equals("/deleteMember.do")) {
            System.out.println("urlCommand : " + urlCommand);
            action = new deleteMemberService();
            System.out.println("action : " + "deleteMemberService");
            forward = action.execute(request, response);
        }


        if (forward.isRedirect()) {
            response.sendRedirect(forward.getPath());
        } else {
            RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
            dis.forward(request, response);

        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        try {
            this.doProcess(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        try {
            this.doProcess(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

