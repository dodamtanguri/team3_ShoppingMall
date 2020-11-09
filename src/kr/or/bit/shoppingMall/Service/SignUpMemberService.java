package kr.or.bit.shoppingMall.Service;

import kr.or.bit.shoppingMall.Action.ActionForward;
import kr.or.bit.shoppingMall.Action.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignUpMemberService implements action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = new ActionForward();
        // 사용자로부터 데이터를 입력받아서 dtd에 저장해야함

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String hp = request.getParameter("hp");
        String card_num = request.getParameter("card_num");
        String address = request.getParameter("address");

        forward.setRedirect(true);
        forward.setPath("Main.do");


        return forward;
    }
}

