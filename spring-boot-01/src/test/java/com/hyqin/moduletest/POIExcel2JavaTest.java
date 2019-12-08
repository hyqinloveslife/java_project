/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: POIExcel2JavaTest
 * Author:   hyqin
 * Date:     2019-10-09 19:09
 * Description: Java操作excel的测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.moduletest;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈Java操作excel的测试〉
 *
 * @author hyqin
 * @create 2019-10-09
 * @since 1.0.0
 */
public class POIExcel2JavaTest {
    private static final String in_path = "d:\\test.xls";
    private static final String out_path = "d:\\test_out.xls";

    private static final String person = "d:\\persons.xlsx";

    public static void main(String[] args) throws Exception {
//        Map<String, String> map = new HashMap<>();
//        map.put("${no}", "1");
//        map.put("${aac001}", "12312");
//        map.put("${aac002}", "389384938493894343");
//        map.put("${aac003}", "李四");
//        map.put("${aac004}", "女");
//        new ExcelUtils().replaceExcel(in_path,out_path,map);

//        POIUtils poiUtils = new POIUtils();
//        poiUtils.copySheet("sheet1","叶问",out_path);


        Excel2007 excel2007 = new Excel2007();
        excel2007.getExcelContents(new FileInputStream(person));


    }
}
