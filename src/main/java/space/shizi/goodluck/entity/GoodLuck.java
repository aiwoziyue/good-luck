package space.shizi.goodluck.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "good_luck")
public class GoodLuck {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "date")
    private String date;

    @Column(name = "week")
    private String week;

    @Column(name = "red")
    private String red;

    @Column(name = "blue")
    private String blue;

    @Column(name = "sales")
    private String sales;

    @Column(name = "poolmoney")
    private String poolmoney;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "goodLuck", fetch = FetchType.EAGER)
    private List<PrizeGrade> prizeGrades = new ArrayList<>();

}