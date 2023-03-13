package space.shizi.goodluck.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "prize_grade")
public class PrizeGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private Integer type;

    @Column(name = "typenum")
    private String typeNum;

    @Column(name = "typemoney")
    private String typeMoney;

    @ManyToOne
    @JoinColumn(name = "good_luck_id")
    private GoodLuck goodLuck;

}