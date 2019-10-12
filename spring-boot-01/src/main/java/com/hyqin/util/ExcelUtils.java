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
package com.hyqin.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

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
     * 导出excel
     * 经过证实，该方法可以实现生成多个sheet
     * @param workbook
     * @param sheetNum   (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle sheet的名字
     * @param headers    表格的列标题
     * @param result     表格的数据
     * @param out        输出流
     * @throws Exception
     */
    public void exportExcel(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, List<List<String>> result
            , OutputStream out) throws Exception {
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);

        //设置表格的格式
        sheet.setDefaultColumnWidth(20);
        //生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        //设置样式
        style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);

        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);

        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        //产生表格标题行
        HSSFRow row = sheet.createRow(0);

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }

        //遍历数据集合产生数据
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    HSSFCell cell = row.createCell(cellIndex);
                    cell.setCellValue(str);
                    cellIndex++;
                }
                index++;
            }
        }

    }

    /**
     *
     * @param ExcelName
     * @param ModelURl
     * @param dataSource
     * @param response
     * @param sheetNames
     * @param keyNames
     * @param rowNum
     * @throws Exception
     */
    public static void ExcelByModel(String ExcelName, String ModelURl, List<Map<String, String>> dataSource,

                                    HttpServletResponse response, String[] sheetNames, String[] keyNames, int rowNum) throws Exception {

        // 设置导出Excel报表的导出形式

        response.setContentType("application/vnd.ms-excel");

        // 设置导出Excel报表的响应文件名

        String fileName = new String(ExcelName.getBytes("utf-8"), "ISO-8859-1");

        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");

        // 创建一个输出流

        OutputStream fileOut = response.getOutputStream();

        // 读取模板文件路径

        File file = new File(ModelURl);

        FileInputStream fins = new FileInputStream(file);

        POIFSFileSystem fs = new POIFSFileSystem(fins);

        // 读取Excel模板

        HSSFWorkbook wb = new HSSFWorkbook(fs);

        // 设置边框样式

        HSSFCellStyle style = wb.createCellStyle();

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);

        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);

        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        // 设置边框样式的颜色

        style.setBottomBorderColor(HSSFColor.BLACK.index);

        style.setLeftBorderColor(HSSFColor.BLACK.index);

        style.setRightBorderColor(HSSFColor.BLACK.index);

        style.setTopBorderColor(HSSFColor.BLACK.index);

        // 模板页

        HSSFSheet sheetModel = null;

        // 新建的Sheet页

        HSSFSheet newSheet = null;

        // 创建行

        HSSFRow row = null;

        // 创建列

        HSSFCell cell = null;

        // 循环建立Sheet页

        for (int i = 0; i < sheetNames.length; i++) {

            // 读取模板中模板Sheet页中的内容

            sheetModel = wb.getSheetAt(0);

            // 设置新建Sheet的页名

            newSheet = wb.createSheet(sheetNames[i]);

            // 将模板中的内容复制到新建的Sheet页中

            copySheet(wb, sheetModel, newSheet, sheetModel.getFirstRowNum(), sheetModel.getLastRowNum());

            int num = rowNum - 1;

            for (Map<String, String> item : dataSource) {

                // 循环遍历,新建行

                row = newSheet.createRow((short) num);

                //判断有多少列数据

                for (int j = 0; j < keyNames.length; j++) {

                    // 设置每列的数据   设置每列的样式   设置每列的值

                    cell = row.createCell(j); cell.setCellStyle(style); cell.setCellValue(item.get(keyNames[j]));

                }

                num++;

            }

            // break 加break可以测试只添加一个Sheet页的情况

        }

        // 写入流

        wb.write(fileOut);

        // 关闭流

        fileOut.close();

    }

    /**
     * 复制表格
     * @param wb
     * @param fromsheet
     * @param newSheet
     * @param firstrow
     * @param lasttrow
     */
    private static void copySheet(HSSFWorkbook wb, HSSFSheet fromsheet, HSSFSheet newSheet, int firstrow, int lasttrow) {

        // 复制一个单元格样式到新建单元格

        if ((firstrow == -1) || (lasttrow == -1) || lasttrow < firstrow) {

            return;

        }

        // 复制合并的单元格

        Region region = null;

        for (int i = 0; i < fromsheet.getNumMergedRegions(); i++) {

            region = fromsheet.getMergedRegionAt(i);

            if ((region.getRowFrom() >= firstrow) && (region.getRowTo() <= lasttrow)) {

                newSheet.addMergedRegion(region);

            }

        }

        HSSFRow fromRow = null;

        HSSFRow newRow = null;

        HSSFCell newCell = null;

        HSSFCell fromCell = null;

        // 设置列宽

        for (int i = firstrow; i < lasttrow; i++) {

            fromRow = fromsheet.getRow(i);

            if (fromRow != null) {

                for (int j = fromRow.getLastCellNum(); j >= fromRow.getFirstCellNum(); j--) {

                    int colnum = fromsheet.getColumnWidth((short) j);

                    if (colnum > 100) {

                        newSheet.setColumnWidth((short) j, (short) colnum);

                    }

                    if (colnum == 0) {

                        newSheet.setColumnHidden((short) j, true);

                    } else {

                        newSheet.setColumnHidden((short) j, false);

                    }

                }

                break;

            }

        }

        // 复制行并填充数据

        for (int i = 0; i < lasttrow; i++) {

            fromRow = fromsheet.getRow(i);

            if (fromRow == null) {

                continue;

            }

            newRow = newSheet.createRow(i - firstrow);

            newRow.setHeight(fromRow.getHeight());

            for (int j = fromRow.getFirstCellNum(); j < fromRow.getPhysicalNumberOfCells(); j++) {

                fromCell = fromRow.getCell((short) j);

                if (fromCell == null) {

                    continue;

                }

                newCell = newRow.createCell((short) j);

                newCell.setCellStyle(fromCell.getCellStyle());

                int cType = fromCell.getCellType();

                newCell.setCellType(cType);

                switch (cType) {

                    case HSSFCell.CELL_TYPE_STRING:

                        newCell.setCellValue(fromCell.getRichStringCellValue());

                        break;

                    case HSSFCell.CELL_TYPE_NUMERIC:

                        newCell.setCellValue(fromCell.getNumericCellValue());

                        break;

                    case HSSFCell.CELL_TYPE_FORMULA:

                        newCell.setCellValue(fromCell.getCellFormula());

                        break;

                    case HSSFCell.CELL_TYPE_BOOLEAN:

                        newCell.setCellValue(fromCell.getBooleanCellValue());

                        break;

                    case HSSFCell.CELL_TYPE_ERROR:

                        newCell.setCellValue(fromCell.getErrorCellValue());

                        break;

                    default:

                        newCell.setCellValue(fromCell.getRichStringCellValue());

                        break;

                }

            }

        }

    }



}
