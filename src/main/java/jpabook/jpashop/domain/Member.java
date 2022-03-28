package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded       //여기에 내장을 할꺼다
    private Address address;


    @OneToMany(mappedBy = "member")      // 1 : 다
//    mappedBy = 읽기전용
    private List<Order> orders = new ArrayList<>();

}
