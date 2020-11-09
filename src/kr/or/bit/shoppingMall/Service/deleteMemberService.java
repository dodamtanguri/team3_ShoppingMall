package kr.or.bit.shoppingMall.Service;

import kr.or.bit.shoppingMall.Action.ActionForward;
import kr.or.bit.shoppingMall.Action.action;
import kr.or.bit.shoppingMall.Model.DTO.MemberDTO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteMemberService implements action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = new ActionForward();

        //세션에서 값을 에 담았다는 가정하에
        MemberDTO dto = new MemberDTO();
        dto.setId(dto.getId());
        dto.setPwd(dto.getPwd());
        HttpSession session = request.getSession(false);
        //request의 getSession()메서드의 파라미터로 false를 전달하면, 이미 생성된 세션이 있을 때 그 세션을 반환하고, 없으면 null을 반환한다.
        //하단부에서 비밀번호 확인을 할때 필요
        session.setAttribute("name",dto);

        //세션값 조회
        String value = (String)session.getAttribute("name");
        System.out.println(value);



        //세션에 담긴 값을 가져오면
        //
        String id = session.getAttribute("name").toString();
        System.out.println(id);
        return forward;
    }
}
