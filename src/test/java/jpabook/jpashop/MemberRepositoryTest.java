package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {
//        //given
//        Member member = new Member();
//        member.setUsername("MemberA2");
//
//        System.out.println("member : " + member);
//        //when
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//
//        System.out.println("savedId : " + savedId);
//        System.out.println("findMember : " + findMember);
//
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member);
//
//        System.out.println("member : " + member);
//        System.out.println("findMember : " + findMember);
//        System.out.println("findMember == member : " + (findMember == member));


    }
}