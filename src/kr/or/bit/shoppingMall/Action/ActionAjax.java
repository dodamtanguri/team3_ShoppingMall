package kr.or.bit.shoppingMall.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface ActionAjax {
        public ActionDataAjax execute (HttpServletRequest request, HttpServletResponse response);
}