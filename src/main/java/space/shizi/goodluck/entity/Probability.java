package space.shizi.goodluck.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "probability")
public class Probability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private Date date;

    // *********************** red ********************************
    @Column(name = "blue_01", precision = 19, scale = 2)
    private BigDecimal blue01;
    @Column(name = "blue_02", precision = 19, scale = 2)
    private BigDecimal blue02;
    @Column(name = "blue_03", precision = 19, scale = 2)
    private BigDecimal blue03;
    @Column(name = "blue_04", precision = 19, scale = 2)
    private BigDecimal blue04;
    @Column(name = "blue_05", precision = 19, scale = 2)
    private BigDecimal blue05;
    @Column(name = "blue_06", precision = 19, scale = 2)
    private BigDecimal blue06;
    @Column(name = "blue_07", precision = 19, scale = 2)
    private BigDecimal blue07;
    @Column(name = "blue_08", precision = 19, scale = 2)
    private BigDecimal blue08;
    @Column(name = "blue_09", precision = 19, scale = 2)
    private BigDecimal blue09;
    @Column(name = "blue_10", precision = 19, scale = 2)
    private BigDecimal blue10;
    @Column(name = "blue_11", precision = 19, scale = 2)
    private BigDecimal blue11;
    @Column(name = "blue_12", precision = 19, scale = 2)
    private BigDecimal blue12;
    @Column(name = "blue_13", precision = 19, scale = 2)
    private BigDecimal blue13;
    @Column(name = "blue_14", precision = 19, scale = 2)
    private BigDecimal blue14;
    @Column(name = "blue_15", precision = 19, scale = 2)
    private BigDecimal blue15;
    @Column(name = "blue_16", precision = 19, scale = 2)
    private BigDecimal blue16;

    // *********************** red ********************************
    @Column(name = "red_01", precision = 19, scale = 2)
    private BigDecimal red01;
    @Column(name = "red_02", precision = 19, scale = 2)
    private BigDecimal red02;
    @Column(name = "red_03", precision = 19, scale = 2)
    private BigDecimal red03;
    @Column(name = "red_04", precision = 19, scale = 2)
    private BigDecimal red04;
    @Column(name = "red_05", precision = 19, scale = 2)
    private BigDecimal red05;
    @Column(name = "red_06", precision = 19, scale = 2)
    private BigDecimal red06;
    @Column(name = "red_07", precision = 19, scale = 2)
    private BigDecimal red07;
    @Column(name = "red_08", precision = 19, scale = 2)
    private BigDecimal red08;
    @Column(name = "red_09", precision = 19, scale = 2)
    private BigDecimal red09;
    @Column(name = "red_10", precision = 19, scale = 2)
    private BigDecimal red10;
    @Column(name = "red_11", precision = 19, scale = 2)
    private BigDecimal red11;
    @Column(name = "red_12", precision = 19, scale = 2)
    private BigDecimal red12;
    @Column(name = "red_13", precision = 19, scale = 2)
    private BigDecimal red13;
    @Column(name = "red_14", precision = 19, scale = 2)
    private BigDecimal red14;
    @Column(name = "red_15", precision = 19, scale = 2)
    private BigDecimal red15;
    @Column(name = "red_16", precision = 19, scale = 2)
    private BigDecimal red16;
    @Column(name = "red_17", precision = 19, scale = 2)
    private BigDecimal red17;
    @Column(name = "red_18", precision = 19, scale = 2)
    private BigDecimal red18;
    @Column(name = "red_19", precision = 19, scale = 2)
    private BigDecimal red19;
    @Column(name = "red_20", precision = 19, scale = 2)
    private BigDecimal red20;
    @Column(name = "red_21", precision = 19, scale = 2)
    private BigDecimal red21;
    @Column(name = "red_22", precision = 19, scale = 2)
    private BigDecimal red22;
    @Column(name = "red_23", precision = 19, scale = 2)
    private BigDecimal red23;
    @Column(name = "red_24", precision = 19, scale = 2)
    private BigDecimal red24;
    @Column(name = "red_25", precision = 19, scale = 2)
    private BigDecimal red25;
    @Column(name = "red_26", precision = 19, scale = 2)
    private BigDecimal red26;
    @Column(name = "red_27", precision = 19, scale = 2)
    private BigDecimal red27;
    @Column(name = "red_28", precision = 19, scale = 2)
    private BigDecimal red28;
    @Column(name = "red_29", precision = 19, scale = 2)
    private BigDecimal red29;
    @Column(name = "red_30", precision = 19, scale = 2)
    private BigDecimal red30;
    @Column(name = "red_31", precision = 19, scale = 2)
    private BigDecimal red31;
    @Column(name = "red_32", precision = 19, scale = 2)
    private BigDecimal red32;
    @Column(name = "red_33", precision = 19, scale = 2)
    private BigDecimal red33;
}