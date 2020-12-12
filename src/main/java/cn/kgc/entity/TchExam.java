package cn.kgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TchExam {

  private Integer teid;
  private Integer tid;
  private double exam;
  private Integer pcount;
  private Date tetime;
  private Integer semester;
  private Integer isDel;

}
