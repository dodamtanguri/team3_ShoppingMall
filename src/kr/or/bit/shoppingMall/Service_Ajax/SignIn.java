package kr.or.bit.shoppingMall.Service_Ajax;

import com.google.gson.JsonObject;
import kr.or.bit.shoppingMall.Action.ActionAjax;
import kr.or.bit.shoppingMall.Action.ActionDataAjax;
import kr.or.bit.shoppingMall.Model.DAO.MemberDAO;
import kr.or.bit.shoppingMall.Model.DTO.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignIn implements ActionAjax {
    @Override
    public ActionDataAjax execute(HttpServletRequest request, HttpServletResponse response) {
        JsonObject body = (JsonObject)request.getAttribute("body");
        String id = body.get("id").getAsString();
        String pwd = body.get("pwd").getAsString();
        MemberDTO dto = MemberDAO.getMember(id);


        ActionDataAjax dataAjax = new ActionDataAjax();
        dataAjax.setContentType("text/plain");
        if(dto == null || !pwd.equals(dto.getPwd())) {
            dataAjax.setData("fail");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("userId", dto.getId());
            session.setMaxInactiveInterval(15 * 60);

            dataAjax.setData("success");
        }

        return dataAjax;
    }
}
