package kr.or.bit.shoppingMall.Controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AjaxController() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {

    }

    protected void Service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; UTF-8");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String urlCommand = requestURI.substring(contextPath.length());
        String method = request.getMethod();


    }
}
