/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Excel2007Helper
 * Author:   hyqin
 * Date:     2019-10-23 20:05
 * Description: 解析2007版本的excel
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.util;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈解析2007版本的excel〉
 *
 * @author hyqin
 * @create 2019-10-23
 * @since 1.0.0
 */
public class Excel2007Helper extends ExcelHelper{
    @Override
    public Workbook getWorkBookInstance(InputStream in) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        return workbook;
    }
}
