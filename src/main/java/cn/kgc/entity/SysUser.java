package cn.kgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {

  private String id;
  private String loginName;
  private String nickName;
  private String icon;
  private String password;
  private String salt;
  private String tel;
  private String email;
  private Integer locked;
  private Date createDate;
  private String createBy;
  private Date updateDate;
  private String updateBy;
  private String remarks;
  private Integer delFlag;
  private Integer isAdmin;


}
