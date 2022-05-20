package hi.servlet.web.springmvc.v3;

import hi.servlet.domain.memberr.Member;
import hi.servlet.domain.memberr.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("new-form")
    public String newForm(){

        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username")String username,
                       @RequestParam("age")int age, Model model) throws ServletException, IOException {
        Member member = new Member(username,age);
        memberRepository.save(member);

        model.addAttribute("member",member);
        return "save-result";
    }


    @GetMapping
    public String members(Model model) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);

        return "members";

    }

}
