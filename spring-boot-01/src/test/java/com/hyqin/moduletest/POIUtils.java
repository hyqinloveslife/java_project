/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: POIUtils
 * Author:   hyqin
 * Date:     2019-10-09 21:38
 * Description: 用来复制excel的sheet
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.moduletest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈用来复制excel的sheet〉
 *
 * @author hyqin
 * @create 2019-10-09
 * @since 1.0.0
 */
public class POIUtils {
    public void copySheet(String fromSheetName, String newSheetName, String targetFilePath) {
        String sheetArray[] = {"成龙", "李连杰", "甄子丹", "洪金宝", "元彪"};
        HSSFWorkbook workbook = null;
        try {
            InputStream is = new FileInputStream(new File(targetFilePath));
            workbook = new HSSFWorkbook(is);
            HSSFSheet fromSheet;
            if (null == fromSheetName) {
                fromSheet = workbook.getSheetAt(0);//如果没有指定sheet的名字，就复制第一个
            } else {
                fromSheet = workbook.getSheet(fromSheetName);
            }

            if (null != fromSheet) {

                for (int n = 0; n < sheetArray.length; n++) {

                    //在我自己的项目中，可以在这里写一个循环。
                    HSSFSheet newSheet = workbook.createSheet(sheetArray[n]);
                    //设置打印参数
                    newSheet.setMargin(HSSFSheet.TopMargin, fromSheet.getMargin(HSSFSheet.TopMargin));// 页边距（上）
                    newSheet.setMargin(HSSFSheet.BottomMargin, fromSheet.getMargin(HSSFSheet.BottomMargin));// 页边距（下）
                    newSheet.setMargin(HSSFSheet.LeftMargin, fromSheet.getMargin(HSSFSheet.LeftMargin));// 页边距（左）
                    newSheet.setMargin(HSSFSheet.RightMargin, fromSheet.getMargin(HSSFSheet.RightMargin));// 页边距（右

                    HSSFPrintSetup ps = newSheet.getPrintSetup();
                    ps.setLandscape(false); // 打印方向，true：横向，false：纵向(默认)
                    ps.setVResolution((short) 600);
                    ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); //纸张类型

                    File file = new File(targetFilePath);
                    if (file.exists() && (file.renameTo(file))) {
                        //复制sheet
                        this.copyRows(workbook, fromSheet, newSheet, fromSheet.getFirstRowNum(), fromSheet.getLastRowNum());

                        Map<String,String> param = new HashMap<>();
                        param.put("${no}", "1"+sheetArray[n]);
                        param.put("${aac001}", "12312"+sheetArray[n]);
                        param.put("${aac002}", "131231242352"+sheetArray[n]);
                        param.put("${aac003}", sheetArray[n]);
                        param.put("${aac004}", "男"+sheetArray[n]);
                        //替换新的sheet中的指定内容
                        this.replaceExcelValue(newSheet,param);
                    } else {
                        System.out.println("文件不存在或文件正在被使用");
                    }
                }
                workbook.removeSheetAt(0);
                FileOutputStream out = new FileOutputStream(targetFilePath);
                workbook.write(out);
                out.flush();
                out.close();

            }
            is.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void copyRows(HSSFWorkbook workbook, HSSFSheet fromSheet, HSSFSheet newSheet, int firstRow, int lastRow) {
        if ((firstRow == -1) || (lastRow == -1) || lastRow < firstRow) {
            return;
        }
        //拷贝合并的单元格
        Region region = null;
        for (int i = 0; i < fromSheet.getNumMergedRegions(); i++) {
            region = fromSheet.getMergedRegionAt(i);
            if ((region.getRowFrom() >= firstRow) && (region.getRowTo()) < lastRow) {
                newSheet.addMergedRegion(region);
            }
        }

        HSSFRow fromRow = null;
        HSSFRow newRow = null;
        HSSFCell fromCell = null;
        HSSFCell newCell = null;

        //设置列宽
        for (int i = firstRow; i <= lastRow; i++) {
            fromRow = fromSheet.getRow(i);
            if (fromRow != null) {
                for (int j = fromRow.getLastCellNum(); j >= fromRow.getFirstCellNum(); j--) {
                    int column = fromSheet.getColumnWidth(j);
                    if (column > 100) {
                        newSheet.setColumnWidth((short) j, (short) column);
                    }
                    if (column == 0) {
                        newSheet.setColumnHidden((short) j, true);
                    } else {
                        newSheet.setColumnHidden((short) j, false);
                    }
                }
                break;
            }
        }

        //拷贝并填充数据
        for (int i = 0; i < lastRow; i++) {
            fromRow = fromSheet.getRow(i);
            if (null == fromRow) {
                continue;
            }
            newRow = newSheet.createRow(i - firstRow);
            newRow.setHeight(fromRow.getHeight());
            for (int j = fromRow.getFirstCellNum(); j < fromRow.getPhysicalNumberOfCells(); j++) {
                fromCell = fromRow.getCell(j);
                if (null == fromCell) {
                    continue;
                }

                newCell = newRow.createCell(j);
                newCell.setCellStyle(fromCell.getCellStyle());
                int cType = fromCell.getCellType();
                newCell.setCellType(cType);
                switch (cType) {
                    case HSSFCell.CELL_TYPE_STRING:
                        newCell.setCellValue(fromCell.getRichStringCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        newCell.setCellValue(fromCell.getCellFormula());
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        newCell.setCellValue(fromCell.getNumericCellValue());
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

}
