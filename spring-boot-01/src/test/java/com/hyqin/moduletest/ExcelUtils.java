/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExcelUtils
 * Author:   hyqin
 * Date:     2019-10-09 19:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.moduletest;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉<br>
 * 〈操作excel的工具类〉
 *
 * @author hyqin
 * @create 2019-10-09
 * @since 1.0.0
 */
public class ExcelUtils {

    /**
     * 替换excel中的内容
     * @param inPath 模板文件
     * @param outPath  替换后的文件
     * @throws Exception
     */
    public void replaceExcel(String inPath,String outPath,Map<String,String> params) throws Exception{
        InputStream in = new FileInputStream(new File(inPath));

        Workbook workbook = WorkbookFactory.create(in);

        Sheet sheet = workbook.getSheetAt(0);
        this.replaceExcelValue(sheet,params);
        OutputStream os = new FileOutputStream(new File(outPath));
        workbook.write(os);
        in.close();
        os.close();
    }

    /**
     * 仅仅在一个sheet中替换内容
     * @param sheet
     * @param param
     */
    public void replaceExcelValue(Sheet sheet, Map<String,String> param){
        int trLength = sheet.getLastRowNum();
        for (int i = 0; i < trLength; i++) {
            Row row = sheet.getRow(i);
            if (row == null){
                continue;
            }
            int minCol = row.getFirstCellNum();
            int maxCol = row.getLastCellNum();
            for (int colIndex = minCol;colIndex<maxCol;colIndex++){
                Cell cell = row.getCell(colIndex);   //获取每一个单元格
                String runText = cell.getStringCellValue();
                if ("".equals(runText)){
                    continue;
                }
                System.out.println(runText);

                if (null!=param.get(runText)){
                    cell.setCellValue(param.get(runText));
                }
            }
        }
    }


    /**
     * 这种正则表达式看不懂
     * @param str
     * @return
     */
    private Matcher matcher(String str){
        Pattern pattern = Pattern.compile("\\{(.+?)\\}",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

}
