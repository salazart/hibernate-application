package com.sz.ha.report.services;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsCreator {

    private String fileName;
    private Workbook wb;
    private int rowCounter;
    private int cellCounter;
    private Integer groupColumn;
    private String tempGroupValue;

    private Sheet sheet;

    public XlsCreator(String fileName) {
        this.fileName = fileName;
        this.wb = fileName.endsWith(".xlsx") ? new XSSFWorkbook() : new HSSFWorkbook();
    }

    public void createWorkBook(List<List<String>> rows){
        sheet = wb.createSheet();
        fillData(sheet, rows);
        saveWorkBook();
    }

    private void fillData(Sheet sheet, List<List<String>> rows){
        rows.stream().forEach(valuesRow -> {
            Row row = sheet.createRow(rowCounter);
            cellCounter = 0;
            valuesRow.stream().forEach(valueCell -> {
                Cell cell = row.createCell(cellCounter++);
                cell.setCellValue(valueCell);
                checkGroupValue(valueCell);
            });
            rowCounter++;
        });
    }

    private void checkGroupValue(String value){
        if (cellCounter !=  groupColumn)
            return;

        if (tempGroupValue == null) {
            tempGroupValue = value;
            return;
        }

        if(tempGroupValue.equals(value)){
            tempGroupValue = value;
        } else {
            sheet.groupRow( rowCounter - 1, rowCounter);
        }
    }

    private void saveWorkBook(){
        try (FileOutputStream out = new FileOutputStream(new File(fileName))){
            wb.write(out);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void setGroupColumn(Integer groupColumn) {
        this.groupColumn = groupColumn;
    }
}
