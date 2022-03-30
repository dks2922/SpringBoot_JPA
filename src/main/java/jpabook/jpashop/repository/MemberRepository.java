package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    //spring이 Entity Manager를 만들어서 걔를 em이란 변수명에 주입(injection)한다.
    @PersistenceContext
    private EntityManager em;


    public void save (Member member){
        System.out.println("MemberRepository.member : " + member);
        em.persist(member);
        System.out.println("MemberRepository.em : " + em);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m ", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select  m from Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();
    }
}
