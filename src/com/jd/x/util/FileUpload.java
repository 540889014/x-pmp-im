package com.jd.x.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

public class FileUpload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileUpload() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String realDir = request.getSession().getServletContext()
				.getRealPath("");
		/*
		 * String contextpath = request.getContextPath(); String basePath =
		 * request.getScheme() + "://" + request.getServerName() + ":" +
		 * request.getServerPort() + contextpath + "/";
		 */
		try {
			String realPath = realDir + "/upload/file/";
			File dir = new File(realPath);
			if (!dir.isDirectory())
				dir.mkdir();
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory dff = new DiskFileItemFactory();
				dff.setRepository(dir);
				dff.setSizeThreshold(1024000);
				ServletFileUpload sfu = new ServletFileUpload(dff);
				FileItemIterator fii = null;
				fii = sfu.getItemIterator(request);
				String url = "";
				String fileName = "";
				String realFileName = UUID.randomUUID().toString();
				while (fii.hasNext()) {
					FileItemStream fis = fii.next();
					try {
						if (!fis.isFormField() && fis.getName().length() > 0) {
							fileName = fis.getName();
							Pattern reg = Pattern.compile("[.]xls$");
							Matcher matcher = reg.matcher(fileName);
							if (!matcher.find()) {
								response.getWriter().print("文件格式有误！");
								return;
							}
							url = realPath
									+ "\\"
									+ realFileName
									+ fileName.substring(fileName
											.lastIndexOf("."));
							BufferedInputStream in = new BufferedInputStream(
									fis.openStream());
							FileOutputStream a = new FileOutputStream(new File(
									url));
							BufferedOutputStream output = new BufferedOutputStream(
									a);
							Streams.copy(in, output, true);
						}
					} catch (Exception e) {
						response.getWriter().print("上传失败！"+e.getMessage());
						return;
					}
				}
				response.setStatus(200);
				String value = this.importExcel(realPath
						+ "\\"
						+ realFileName
						+ fileName.substring(fileName.lastIndexOf(".")));
				
				response.getWriter().print(value);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public String importExcel(String path) {
		Workbook book = null;
		try {
			book = Workbook.getWorkbook(new File(path));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			int rows = sheet.getRows();
			// 遍历每行每列的单元格
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("date", sheet.getCell(0, 0).getContents());
			String a,b;
			for (int i = 1; i < rows; i++) {
				a = sheet.getCell(1, i).getContents();
				if(a.startsWith("("))
					a="-"+a.replace("(", "").replace(")", "");
				b = sheet.getCell(2, i).getContents();
				if(b.startsWith("("))
					b="-"+b.replace("(", "").replace(")", "");
				jsonobj.put(StringUtil.filterSymbol(sheet.getCell(0, i).getContents()),a+"|"+b);
			}
			return jsonobj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (book != null) {
				book.close();
			}
		}
		return null;
	}
}
