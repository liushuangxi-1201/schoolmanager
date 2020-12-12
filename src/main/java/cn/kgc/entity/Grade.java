package cn.kgc.entity;

import lombok.Data;

@Data
public class Grade {

  private Integer gid;
  private String gname;
  private Integer gcount;
  private Integer mid;
  private Integer isDel;

  private String dname;
  private String mname;
  private Integer did;
}
