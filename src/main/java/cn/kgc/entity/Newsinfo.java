package cn.kgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Newsinfo {

  private Integer nid;
  private String ntitle;
  private String ncontent;
  private String nauthor;
  private Date ntime;
  private String nimg;


}
