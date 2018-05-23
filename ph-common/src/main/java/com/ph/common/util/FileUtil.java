package com.ph.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	/**
	 * 得到某一目录下的所有文件夹
	 * @param root
	 * @return
	 */
	public static List<File> listAllDir(File root) {
		List<File> list = new ArrayList<File>();
		File[] dirs = root.listFiles();
		if (dirs != null) {
			for (int i = 0; i < dirs.length; i++) {
				if (dirs[i].isDirectory()) {
					list.add(dirs[i]);
				}
				listAllDir(dirs[i]);
			}
		}
		return list;
	}
	
	/**
	   * 删除指定目录下的所有的"空文件夹"
	   * @param pathname	
	   */
	public static void deleteEmptyDirectory(String pathname) {
		List<File> list = listAllDir(new File(pathname));
		for (int i = 0; i < list.size(); i++) {
			File temp = list.get(i);
			// 是目录且为空
			if (temp.isDirectory() && temp.listFiles().length <= 0) {
				temp.delete();
			}
		}
	}
}