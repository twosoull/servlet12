package hi.servlet.web.frontcontroller.v4.controller;

import hi.servlet.domain.memberr.Member;
import hi.servlet.domain.memberr.MemberRepository;
import hi.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        List<Member> members = memberRepository.findAll();

        model.put("members",members);
        return "members";
    }
}
