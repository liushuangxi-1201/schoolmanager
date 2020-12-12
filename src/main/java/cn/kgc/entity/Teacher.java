package cn.kgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Teacher {

  private Integer tid;
  private String tchid;
  private String tname;
  private String tgender;
  private Date tbirthday;
  private Integer pid;
  private String tnation;
  private String tcardid;
  private String tphone;
  private String taddress;
  private Date entertime;
  private Date leavetime;
  private Integer tchstate;
  private Integer isDel;


}
