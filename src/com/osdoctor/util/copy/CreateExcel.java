package com.osdoctor.util.copy;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateExcel {
	public HSSFWorkbook createExcel(List<Map<String, Object>> list) {
		HSSFWorkbook wb = null;
		try {
			wb = null;
			// 第一步，创建一个webbook，对应一个Excel文件
			wb = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet("报酬支付信息表");
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = sheet.createRow((int) 0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("项目名称");
			cell.setCellStyle(style);
			cell = row.createCell(1);
			cell.setCellValue("部门");
			cell.setCellStyle(style);
			cell = row.createCell(2);
			cell.setCellValue("创建时间");
			cell.setCellStyle(style);
			cell = row.createCell(3);
			cell.setCellValue("开始时间");
			cell.setCellStyle(style);
			cell = row.createCell(4);
			cell.setCellValue("结束时间");
			cell.setCellStyle(style);
			cell = row.createCell(5);
			cell.setCellValue("规模");
			cell.setCellStyle(style);
			cell = row.createCell(6);
			cell.setCellValue("预测报酬");
			cell.setCellStyle(style);
			cell = row.createCell(7);
			cell.setCellValue("支付类型");
			cell.setCellStyle(style);
			cell = row.createCell(8);
			cell.setCellValue("日均报酬");
			cell.setCellStyle(style);
			sheet.setColumnWidth(0, 12000);
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 8000);
			sheet.setColumnWidth(3, 8000);
			sheet.setColumnWidth(4, 8000);
			sheet.setColumnWidth(5, 6000);
			sheet.setColumnWidth(6, 6000);
			sheet.setColumnWidth(7, 5000);
			sheet.setColumnWidth(8, 5000);
			// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
			int i = 1;
			for (Map<String, Object> m : list) {
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(m.get("name").toString());
				row.createCell(1).setCellValue(m.get("department").toString());
				row.createCell(2).setCellValue(m.get("createtime").toString());
				row.createCell(3).setCellValue(m.get("start_time").toString());
				row.createCell(4).setCellValue(m.get("end_time").toString());
				row.createCell(5).setCellValue(m.get("size").toString());
				row.createCell(6).setCellValue(m.get("paysum").toString());
				row.createCell(7).setCellValue(m.get("paytype").toString());
				row.createCell(8).setCellValue(m.get("pay").toString());
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb;
	}
}