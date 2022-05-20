package hi.servlet.web.springmvc.v1;

import hi.servlet.domain.memberr.Member;
import hi.servlet.domain.memberr.MemberRepository;
import hi.servlet.web.frontcontroller.ModelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class SpringMemberListController {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process(Map<String, String> paramMap) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members",members);

        return mv;

    }
}
