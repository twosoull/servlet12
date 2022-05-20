package hi.servlet.web.frontcontroller.v4.controller;

import hi.servlet.domain.memberr.Member;
import hi.servlet.domain.memberr.MemberRepository;
import hi.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);

        model.put("member",member);

        return "save-result";
    }
}
