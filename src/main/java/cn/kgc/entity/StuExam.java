package cn.kgc.entity;

import lombok.Data;

@Data
public class StuExam {

  private Integer seid;
  private Integer sid;
  private Integer scid;
  private double normalexam;
  private double testexam;
  private double sumexam;
  private Integer stime;
  private Integer studynature;
  private Integer isDel;


}
