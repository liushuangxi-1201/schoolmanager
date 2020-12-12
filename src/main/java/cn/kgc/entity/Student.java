package cn.kgc.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
  private Integer sid;
  private String stuid;
  private String sname;
  private String sgender;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sbirthday;
  private Integer pid;
  private String snation;
  private String scardid;
  private String sphone;
  private String saddress;
  private Date entertime;
  private Date leavetime;
  private Integer stustate;
  private Integer classid;
  private Integer isDel;
  private String mim;
}
