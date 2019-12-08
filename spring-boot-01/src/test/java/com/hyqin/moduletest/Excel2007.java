/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Excel2007
 * Author:   hyqin
 * Date:     2019-10-23 15:33
 * Description: 解析excel2007版
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.moduletest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈解析excel2007版〉
 *  在idea上能够解析模板，但是在项目里面就报错，这是为什么？
 *
 * @author hyqin
 * @create 2019-10-23
 * @since 1.0.0
 */
public class Excel2007 {

    public List<Map<String,Object>> list = new ArrayList<>();


    public List<Map<String,Object>> getExcelContents(InputStream in){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(in);

            XSSFSheet sheet = workbook.getSheetAt(0);

            int lastRownum = sheet.getLastRowNum();
            for (int i = 1; i < lastRownum; i++) {
                XSSFRow xssfRow = sheet.getRow(i);
                Map<String,Object> map = new HashMap<>();
                int lastColNum = xssfRow.getLastCellNum();
                for (int column = 0; column < lastColNum; column++) {
                    XSSFCell cell = xssfRow.getCell(column);
                    System.out.println(cell.getStringCellValue().trim());
                    if (column==0){
                        map.put("aac003",cell.getStringCellValue().trim());
                    }
                    if (column==1){
                        map.put("aac002",cell.getStringCellValue().trim());
                    }
                }

                list.add(map);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return list;
    }

}
