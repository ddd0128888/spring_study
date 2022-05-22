package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiceImpl();

        // ApplicationContext - 스프링 컨테이너라고 보면 됨 (모든 객체를 관리해줌)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 스프링 컨테이너에서 memberService라는 메서드를 찾아! 그리고 반환 타입은 MemberService.class 객체야!
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);



        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("newMember = " + member.getName());

    }

}
