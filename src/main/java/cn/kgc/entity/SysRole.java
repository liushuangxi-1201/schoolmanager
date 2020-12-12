package cn.kgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {

  private String id;
  private String name;
  private Date createDate;
  private String createBy;
  private Date updateDate;
  private String updateBy;
  private String remarks;
  private Integer delFlag;

}
