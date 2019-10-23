/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Excel2003Helper
 * Author:   hyqin
 * Date:     2019-10-23 20:04
 * Description: 解析2003版本的excel
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈解析2003版本的excel〉
 *
 * @author hyqin
 * @create 2019-10-23
 * @since 1.0.0
 */
public class Excel2003Helper extends ExcelHelper {
    @Override
    public Workbook getWorkBookInstance(InputStream in)  throws Exception{
        HSSFWorkbook workbook = null;
        try {
             workbook = new HSSFWorkbook(in);
        } catch (IOException e) {
            throw new Exception("读取文件失败");
        }

        return workbook;
    }
}
