package com.amazon.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static void setCellData(Sheet Sheet, String value, int rowNum, int colNum) {
        Cell cell;
        Row row;

        try {
            row = Sheet.getRow(rowNum);
            cell = row.getCell(colNum);

            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCellData(Sheet workSheet, String value, String columnName, int row) {
        int column = getColumnsNames(workSheet).indexOf(columnName);
        setCellData(workSheet,value, row, column);
    }

    public static List<String> getColumnsNames(Sheet workSheet) {
        List<String> columns = new ArrayList<>();

        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

}
