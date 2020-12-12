package cn.kgc.controller;

import cn.kgc.entity.Student;
import cn.kgc.service.StudentService;
import cn.kgc.util.UUIDUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelImportController {

    @Autowired
    private StudentService studentService;

    List<Student> importDatas = new ArrayList<>();

    @GetMapping("/toHtml")
    public String toHtml() {
        return "initialization";
    }
    //处理文件上传
    @ResponseBody//返回json数据
    @RequestMapping(value = "/excelImport", method = RequestMethod.POST)
    @Transactional
    public String upload(@RequestParam("file") MultipartFile file,
                            Integer classid) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            return "文件为空！";
        }
        try {
            //根据路径获取这个操作excel的实例
            //POIFSFileSystem fs  =new POIFSFileSystem(file.getInputStream());
            //HSSFWorkbook wb = new HSSFWorkbook(fs);
            //Workbook wb = WorkbookFactory.create(fs);
            XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
            //根据页面index 获取sheet页
            Sheet sheet = wb.getSheetAt(0);
            //实体类集合
            Row row = null;
            //循环sesheet页中数据从第二行开始，第一行是标题
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                //获取每一行数据
                row = sheet.getRow(i);
                Student data = new Student();
                //data.setId(Integer.valueOf((int) row.getCell(0).getNumericCellValue()));
                //姓名
                data.setSname(row.getCell(0).getStringCellValue());
                //性别
                data.setSgender(row.getCell(1).getStringCellValue());
                //出生年月
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                data.setSbirthday(df.parse(df.format(HSSFDateUtil.getJavaDate(row.getCell(2).getNumericCellValue()))));
                System.out.println("aaaaa:"+df.format(HSSFDateUtil.getJavaDate(row.getCell(2).getNumericCellValue())));
                //政治面貌 先定死都是3，共青团员，后期更改
                data.setPid(3);
                //民族
                data.setSnation(row.getCell(3).getStringCellValue());
                //身份证号
                row.getCell(4).setCellType(CellType.STRING);
                data.setScardid(row.getCell(4).getStringCellValue());
                //手机号
                row.getCell(5).setCellType(CellType.STRING);
                data.setSphone(row.getCell(5).getStringCellValue());
                //家庭住址
                data.setSaddress(row.getCell(6).getStringCellValue());
                data.setStuid(UUIDUtils.getUUIDInOrderId().toString().substring(6));
                data.setClassid(classid);

                importDatas.add(data);
                studentService.add(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导入成功";
    }

}
