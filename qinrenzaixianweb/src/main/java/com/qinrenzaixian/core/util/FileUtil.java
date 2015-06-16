package com.qinrenzaixian.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件工具类
 * @author xiaoyang
 *
 */
public class FileUtil {
	
	 /**
	  * 复制文件
	  * @param sourceFile
	  * @param targetFile
	  * @throws IOException
	  */
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
    
    /**
	  * 复制文件
	  * @param sourceFile
	  * @param targetFile
	  * @throws IOException
	  */
  public static void copyFile(InputStream sourceFile, String path ) throws IOException {
	  File file  = new File(path);
	  if(!file.exists()){
		  file.createNewFile();
	  }
	  copyFile( sourceFile, file);
  }
    /**
	  * 复制文件
	  * @param sourceFile
	  * @param targetFile
	  * @throws IOException
	  */
   public static void copyFile(InputStream sourceFile, File targetFile) throws IOException {
       BufferedInputStream inBuff = null;
       BufferedOutputStream outBuff = null;
       try {
           // 新建文件输入流并对它进行缓冲
           inBuff = new BufferedInputStream(sourceFile);

           // 新建文件输出流并对它进行缓冲
           outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

           // 缓冲数组
           byte[] b = new byte[1024 * 5];
           int len;
           while ((len = inBuff.read(b)) != -1) {
               outBuff.write(b, 0, len);
           }
           // 刷新此缓冲的输出流
           outBuff.flush();
       } finally {
           // 关闭流
           if (inBuff != null)
               inBuff.close();
           if (outBuff != null)
               outBuff.close();
       }
   }
}
