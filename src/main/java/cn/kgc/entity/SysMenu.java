package cn.kgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysMenu {

  private String id;
  private String name;
  private String parentId;
  private Integer level;
  private String parentIds;
  private Integer sort;
  private String href;
  private String target;
  private String icon;
  private String bgColor;
  private Integer isShow;
  private String permission;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;
  private String remarks;
  private Integer delFlag;

}
