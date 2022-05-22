package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class MemoryMemberRepository implements MemberRepository {

    // 사실은 동시성 문제 때문에 Concurrent HaspMap을 사용해야함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
