package hi.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" +
                req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");

        String[] usernames = req.getParameterValues("username");
        for (String name : usernames){
            System.out.println("name = " + name);
        }
        resp.getWriter().write("ok");
    }
}
