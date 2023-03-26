package space.shizi.goodluck.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
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
    private String typenum;

    @Column(name = "typemoney")
    private String typemoney;

    @Column(name = "good_luck_id")
    private Long goodLuckId;

}