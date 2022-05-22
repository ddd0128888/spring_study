package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션의 설정정보 파일이란 것을 알려주는 어노테이션
@Configuration
public class AppConfig {

    // @Bean -> memberService -> memberRepository -> MemoryMemberRepository
    // @Bean -> orderService -> memberRopository -> MemoryMemberRepository
    // 생성자가 2번 호출됨 -> singleton pattern에 어긋나지 않나?

    // Bean 어노테이션을 붙이면 해당 메서드가 스프링 컨테이너에 등록이 됨
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }

    @Bean
    public RateDiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}