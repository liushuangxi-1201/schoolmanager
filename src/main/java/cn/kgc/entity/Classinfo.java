package cn.kgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Classinfo {

  private Integer classid;
  private String classname;
  private Date begintime;
  private Date endtime;
  private Integer ccount;
  private Integer gid;
  private Integer isDel;

  private Integer mid;
  private String mname;

  private Integer did;
  private String dname;

  private String gname;



}
