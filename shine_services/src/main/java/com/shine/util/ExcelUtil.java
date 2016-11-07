package com.shine.util;

import com.shine.exception.ExcelException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Excel文件工具
 */
public class ExcelUtil {

    /**
     * excel类型
     */
    public static final String EXCELTYPE_XLSX = "xlsx";
    public static final String EXCELTYPE_XLS = "xls";


    /**
     * 从输入流获取excel数据
     *
     * @param excelType   excel类型
     * @param inputStream 输入流
     * @param columnNames 数据列名(0开始)
     * @param startOffset 起始偏移
     * @return
     */
    public static List<Map<String, String>> getDataFromInputStream(String excelType, InputStream inputStream, Map<Integer, String> columnNames, int startOffset) throws ExcelException {

        //空流判断
        if (inputStream == null) {
            throw new ExcelException("Excel文件不存在");
        }

        //数据列参数检查
        if (columnNames == null) {
            throw new ExcelException("数据列不能为空");
        }


        //根据格式进行读取
        try {
            if (excelType.equals(EXCELTYPE_XLS)) {
                return getDataFromXls(new HSSFWorkbook(inputStream), columnNames, startOffset);
            } else if (excelType.equals(EXCELTYPE_XLSX)) {
                return getDataFromXlsx(new XSSFWorkbook(inputStream), columnNames, startOffset);
            } else {
                throw new ExcelException("EXCEL文件类型不正确");
            }
        } catch (IOException e) {
            throw new ExcelException("Excel文件格式不正确");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 从xlsx读取数据
     *
     * @param xssfWorkbook
     * @param columnNames
     * @param startOffset
     * @return
     * @throws ExcelException
     */
    private static List<Map<String, String>> getDataFromXlsx(XSSFWorkbook xssfWorkbook, Map<Integer, String> columnNames, int startOffset) throws ExcelException {

        //excel一页
        XSSFSheet xssfSheet = null;
        //excel一行
        XSSFRow xssfRow = null;
        //列名序号
        Set<Integer> columnIndexs = columnNames.keySet();
        //结果
        List<Map<String, String>> result = new ArrayList<>();
        //一行记录
        Map<String, String> rowRecord = null;
        //Excel单元格
        XSSFCell xssfCell = null;

        //遍历页
        for (int sheetNum = 0; sheetNum < xssfWorkbook.getNumberOfSheets(); sheetNum++) {
            xssfSheet = xssfWorkbook.getSheetAt(sheetNum);
            if (xssfSheet == null || xssfSheet.getLastRowNum() == 0) {
                continue;
            }

            //遍历行
            for (int rowNum = startOffset; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                xssfRow = xssfSheet.getRow(rowNum);

                rowRecord = new HashMap<>();
                for (int columnIndex : columnIndexs) {
                    xssfCell = xssfRow.getCell(columnIndex);
                    xssfCell.setCellType(XSSFCell.CELL_TYPE_STRING);

                    if (xssfCell == null) {
                        rowRecord.put(columnNames.get(columnIndex), null);
                    } else {
                        rowRecord.put(columnNames.get(columnIndex), xssfCell.getStringCellValue());
                    }
                }

                result.add(rowRecord);
            }
        }

        return result;
    }


    /**
     * 从xls读取数据
     *
     * @param hssfWorkbook
     * @param columnNames
     * @param startOffset
     * @return
     * @throws ExcelException
     */
    public static List<Map<String, String>> getDataFromXls(HSSFWorkbook hssfWorkbook, Map<Integer, String> columnNames, int startOffset) throws ExcelException {


        //excel一页
        HSSFSheet hssfSheet = null;
        //excel一行
        HSSFRow hssfRow = null;
        //列名序号
        Set<Integer> columnIndexs = columnNames.keySet();
        //结果
        List<Map<String, String>> result = new ArrayList<>();
        //一行记录
        Map<String, String> rowRecord = null;
        //Excel单元格
        HSSFCell hssfCell = null;

        //遍历页
        for (int sheetNum = 0; sheetNum < hssfWorkbook.getNumberOfSheets(); sheetNum++) {
            hssfSheet = hssfWorkbook.getSheetAt(sheetNum);
            if (hssfSheet == null || hssfSheet.getLastRowNum() == 0) {
                continue;
            }

            //遍历行
            for (int rowNum = startOffset; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                hssfRow = hssfSheet.getRow(rowNum);

                rowRecord = new HashMap<>();

                for (int columnIndex : columnIndexs) {

                    hssfCell = hssfRow.getCell(columnIndex);
                    hssfCell.setCellType(HSSFCell.CELL_TYPE_STRING);

                    if (hssfCell == null) {
                        rowRecord.put(columnNames.get(columnIndex), null);
                    } else {
                        rowRecord.put(columnNames.get(columnIndex), hssfCell.getStringCellValue());
                    }

                }

                result.add(rowRecord);
            }
        }
        return result;
    }


    private static char[] chars = new char[]{
            'A', 'B',
            'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };


    /**
     * 从数据中获取Excel文件
     *
     * @param columnNames
     * @param values
     */
    public static byte[] getFileFromData(String[] columnNames, String[][] values) {

        // 创建Excel的工作书册 Workbook,对应到一个excel文档
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        // 创建Excel的工作sheet
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet1");

        //第一行 页头
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = null;
        for (int i = 0; i < columnNames.length; i++) {
            hssfCell = hssfRow.createCell(i);
            hssfCell.setCellValue(columnNames[i]);
        }

        //数据
        for (int i = 0; i < values.length; i++) {
            hssfRow = hssfSheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                hssfCell = hssfRow.createCell(j);
                hssfCell.setCellValue(values[i][j]);
            }
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            hssfWorkbook.write(byteArrayOutputStream);
            hssfWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取字节数据
        byte[] data = byteArrayOutputStream.toByteArray();

        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return data;

    }

}
