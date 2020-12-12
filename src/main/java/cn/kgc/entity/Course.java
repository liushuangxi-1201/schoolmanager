package cn.kgc.entity;

import lombok.Data;

@Data
public class Course {

  private Integer cid;
  private String cname;
  private double ccredit;
  private double cperiod;
  private Integer cstate;
  private Integer cselcount;
  private Integer cmaxcount;
  private String studytype;
  private Integer ctid;
  private Integer mid;
  private Integer isDel;

}
