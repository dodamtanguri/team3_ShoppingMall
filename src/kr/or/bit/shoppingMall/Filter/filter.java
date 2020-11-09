package kr.or.bit.shoppingMall.Filter;

import com.google.gson.JsonElement;
import org.apache.tomcat.dbcp.dbcp2.Utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class filter implements Filter {


        public filter() {
            // TODO Auto-generated constructor stub
        }

        public void init(FilterConfig fConfig) throws ServletException {
            // TODO Auto-generated method stub
        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpReq = (HttpServletRequest)request;
            // set UTF-8
            httpReq.setCharacterEncoding("UTF-8");

            // set urlCommand
            String requestURI = httpReq.getRequestURI();
            String contextPath = httpReq.getContextPath();
            String urlCommand = requestURI.substring(contextPath.length());
            httpReq.setAttribute("urlCommand", urlCommand);
            String method = httpReq.getMethod();
            System.out.println(method + " " + urlCommand);

            // parse json in body
//            if(method.equals("POST") && request.getContentType().equals("application/json")) {
//                String body = getBody(httpReq);
//                JsonElement jsonBody = Utils.parseStringToJson(body);
//                request.setAttribute("jsonBody", jsonBody);
//            }

            chain.doFilter(request, response);
        }

        private static String getBody(HttpServletRequest request) throws IOException {

            String body = null;
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = null;

            try {
                InputStream inputStream = request.getInputStream();
                if (inputStream != null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    char[] charBuffer = new char[128];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                        stringBuilder.append(charBuffer, 0, bytesRead);
                    }
                }
            } catch (IOException ex) {
                throw ex;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        throw ex;
                    }
                }
            }

            body = stringBuilder.toString();
            return body;
        }

        public void destroy() {
            // TODO Auto-generated method stub
        }
}
