package hi.servlet.web.frontcontroller.v3.controller;

import hi.servlet.domain.memberr.Member;
import hi.servlet.domain.memberr.MemberRepository;
import hi.servlet.web.frontcontroller.ModelView;
import hi.servlet.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);

        return mv;
    }
}
