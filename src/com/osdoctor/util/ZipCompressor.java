package com.osdoctor.util;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipCompressor {

	private File zipFile;

	public ZipCompressor(String pathname) {
		zipFile = new File(pathname);
	}

	public void compress(String srcPathName) {
		File srcdir = new File(srcPathName);
		if (!srcdir.exists())
			throw new RuntimeException(srcPathName + "不存在！");

		if (srcdir.isDirectory()) {
			Project project = new Project();
			Zip zip = new Zip();
			zip.setProject(project);
			zip.setDestFile(zipFile);
			FileSet fileSet = new FileSet();
			fileSet.setProject(project);
			fileSet.setDir(srcdir);
			// fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹
			// eg:zip.setIncludes("*.java");
			// fileSet.setExcludes(...); 排除哪些文件或文件夹
			zip.addFileset(fileSet);
			zip.execute();
		}
	}

	public static void main(String[] args) {
		ZipCompressor zc = new ZipCompressor("D:\\test.zip");
		zc.compress("D:\\wordOperate.doc");
	}

}
