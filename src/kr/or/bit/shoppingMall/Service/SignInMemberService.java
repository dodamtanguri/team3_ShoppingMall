package kr.or.bit.shoppingMall.Service;

import kr.or.bit.shoppingMall.Action.ActionForward;
import kr.or.bit.shoppingMall.Action.action;
import kr.or.bit.shoppingMall.Model.DAO.MemberDAO;
import kr.or.bit.shoppingMall.Model.DTO.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInMemberService implements action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("여기까지는 들어오나욤???");
        ActionForward forward = new ActionForward();
        int loginResult = 0;
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        System.out.println("id :" + id + " pwd :" + pwd);

        MemberDTO dto = new MemberDTO(id,pwd);
        MemberDAO dao = new MemberDAO();
       loginResult = dao.getMember(id,pwd);
        System.out.println("loginResult :" +loginResult);

        if (loginResult == 1) {
            request.setAttribute("loginResult", loginResult);
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", id);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("loginResult", loginResult);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SignInPage.jsp");
            rd.forward(request, response);
        }

    return forward;
    }
}
