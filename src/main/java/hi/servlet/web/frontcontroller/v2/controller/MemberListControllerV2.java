package hi.servlet.web.frontcontroller.v2.controller;

import hi.servlet.domain.memberr.Member;
import hi.servlet.domain.memberr.MemberRepository;
import hi.servlet.web.frontcontroller.MyView;
import hi.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
   MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members",members);
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
