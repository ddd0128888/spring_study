package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void PrototypeTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototyeBean.class);

        // 프로토타입 빈을 조회하기 직전에 생성됨을 확인
        System.out.println("find PrototypeBean1");
        PrototyeBean prototyeBean1 = ac.getBean(PrototyeBean.class);

        System.out.println("find PrototypeBean2");
        PrototyeBean prototyeBean2 = ac.getBean(PrototyeBean.class);

        System.out.println("prototyeBean1 = " + prototyeBean1);
        System.out.println("prototyeBean2 = " + prototyeBean2);

        assertThat(prototyeBean1).isNotSameAs(prototyeBean2);
        assertThat(prototyeBean1).isNotEqualTo(prototyeBean2);


        ac.close();




    }

    @Scope("prototype")
    static class PrototyeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototyeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototyeBean.destroy");
        }
    }

}
