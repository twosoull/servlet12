package hi.servlet.web.frontcontroller.v3;

import hi.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String,String> paramMap) throws ServletException, IOException;
}
