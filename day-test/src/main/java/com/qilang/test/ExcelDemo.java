package com.qilang.test;

import cn.hutool.core.util.NumberUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author huql
 **/
public class ExcelDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/huqilang/Desktop/aa.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        //读第一个sheet
        Sheet sheet = workbook.getSheetAt(2);

        Row row0 = sheet.getRow(0);
        Row row1 = sheet.getRow(1);
        String str = "update t_data_template_element set sort=%s  where template_id=1685408540370512489 and alive_flag='1' and name='%s' and table_name='t_data_task_shipment_not_received';";
        for (int i = 0; i< row0.getLastCellNum(); i++) {
            //输出sql
            System.out.println(String.format(str, NumberUtil.parseInt(String.valueOf(row0.getCell(i).getNumericCellValue())), row1.getCell(i).getStringCellValue()));
        }
    }
}
