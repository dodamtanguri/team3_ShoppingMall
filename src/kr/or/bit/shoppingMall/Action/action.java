package kr.or.bit.shoppingMall.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}
