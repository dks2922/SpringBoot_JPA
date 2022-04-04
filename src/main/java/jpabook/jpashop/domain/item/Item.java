package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughtStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//JOINED : 정교화 된 테이블
//SINGLE_TABLE : 한 테이블에 다 넣는 것
//TABLE_PER_CLASS : 3개의 테이블만 나오는 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직 ==//
    /**
     * statk 증가
     * */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * statk 감소
    * */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity -quantity;
        if (restStock < 0) {
            throw new NotEnoughtStockException("need more stock");
        }
        this.stockQuantity = restStock;

    }
}

