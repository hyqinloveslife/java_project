/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExcelHelper
 * Author:   hyqin
 * Date:     2019-10-23 20:02
 * Description: 关于excel的工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.util;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈关于excel的工具类〉
 *
 * @author hyqin
 * @create 2019-10-23
 * @since 1.0.0
 */
public abstract class ExcelHelper {
    public abstract Workbook getWorkBookInstance(InputStream in) throws Exception;
}
