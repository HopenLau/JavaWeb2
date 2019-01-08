package com.javaweb.util.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUtil {
	
	public static final String FILE = "file";
	
	public static final String FOLDER = "folder";
	
	public enum FileType{
		
		FILE(FileUtil.FILE),
		FOLDER(FileUtil.FOLDER);
		
		private FileType(String fileType){
			this.fileType = fileType;
		}
		
		private String fileType;
		
		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		
	}
	
	//递归获得某个文件夹下的所有文件夹和文件名称
	public static List<File> getAllFilesName(File file,List<File> fileList){
		if(file.isDirectory()){
			File files[] = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				fileList.add(files[i]);
				getAllFilesName(files[i],fileList);
			}
		}
		return fileList;
	}
	
    //创建文件或文件夹
    public static void makeFileOrFolder(File file,FileType fileType) throws IOException{
    	if(!file.exists()){
    		if(FileType.FILE==fileType){//文件
    			file.createNewFile();
    		}else{//文件夹
    			file.mkdirs();
    		}
    	}
    }
    
    //创建文件夹
    public static void makeFolder(File file){
    	if(!file.isFile()){
			if(!file.exists()){
				file.mkdirs();
			}
		}
    }
    
    //写文件
    public static void writeFile(InputStream inputStream,byte[] buffer,File file) throws IOException {
    	/**
    	 * 多文件合并写入
    	 * FileOutputStream fos = new FileOutputStream(new File("test.zip"));
    	 * fos.write(new byte[1]);
    	 * fos.write(new byte[2]);
    	 * fos.write(new byte[3]);
    	 * fos.close();
    	 */
		try(OutputStream outputStream = new FileOutputStream(file)) {
			int n = 0;
			while ((n=inputStream.read(buffer)) != -1) {
				outputStream.write(buffer,0,n);
			}
		} catch (IOException e) {
			throw new IOException(e);
		} 
    }
  	
  	//写文件
  	public static void writeFile(InputStream inputStream,byte[] buffer,Path path) throws IOException {
		try(OutputStream outputStream = Files.newOutputStream(path)) {
			int n= 0;
			while ((n=inputStream.read(buffer)) != -1) {
				outputStream.write(buffer,0,n);
			}
		} catch (IOException e) {
			throw new IOException(e);
		}
  	}
  	
	//下文件
	public static void downloadFile(OutputStream outputStream,byte[] buffer,File file) throws IOException{
		/**
    	 * 多文件内容读取
    	 * FileInputStream fis = new FileInputStream(new File("test.zip"));
    	 * fis.read(new byte[1]);
    	 * fis.read(new byte[2]);
    	 * fis.read(new byte[3]);
    	 * fis.close();
    	 */
		try(InputStream inputStream = new FileInputStream(file)) {
			int n=0;
			while ((n=inputStream.read(buffer)) != -1) {
				outputStream.write(buffer,0,n);
			}
		} catch (IOException e) {
			throw new IOException(e);
		} 
	}
	
	//下文件
	public static void downloadFile(OutputStream outputStream,byte[] buffer,Path path) throws IOException{
		try(InputStream inputStream = Files.newInputStream(path)) {
			int n=0;
			while ((n=inputStream.read(buffer)) != -1) {
				outputStream.write(buffer,0,n);
			}
		} catch (IOException e) {
			throw new IOException(e);
		} 
	}
	
	//字节流追加文件并设置编码
	public static void writeFileAppend(File file,String context) throws IOException{
		//字符流
		//Writer out = new FileWriter(f,true);//加true的话,不会替换原来文件的内容,直接追加
 	   	//Reader in = new FileReader(f);
		try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"))) {
			bufferedWriter.write(context);
		} catch (IOException e) {
			throw new IOException(e);
		}
	}
	
	//字节流追加文件并设置编码
	public static void writeFileAppend(Path path,String context) throws IOException{
		//字符流
		//Writer out = new FileWriter(f,true);//加true的话,不会替换原来文件的内容,直接追加
 	   	//Reader in = new FileReader(f);
		try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.toFile(),true),"UTF-8"))) {
			bufferedWriter.write(context);
		} catch (IOException e) {
			throw new IOException(e);
		}
	}
	
	//一行一行读取
	public static List<String> readFileLineByLine(File file,List<String> lineList) throws IOException{
		try(LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))) {
			String eachLine = null;
			while((eachLine=lineNumberReader.readLine())!=null){
				lineList.add(eachLine);
			}
		}catch(IOException e){
			throw new IOException(e);
		}
		return lineList;
	}
	
	//序列化输出
	public static void writeSerialize(String filePath,Object obj) throws IOException{
		Path path = Paths.get(filePath);
		if(Files.isDirectory(path)){
			return;
		}
		if(!Files.exists(path)){
			Files.createFile(path);
		}
		try(BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path));
			ObjectOutputStream oos = new ObjectOutputStream(bos);) {
			oos.writeObject(obj);
			oos.flush();
			bos.flush();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	//序列化读取
	public static Object readSerialize(String filePath) throws IOException,ClassNotFoundException{
		Path path = Paths.get(filePath);
		if(Files.isReadable(path)){
			try(BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(path));
				ObjectInputStream ois = new ObjectInputStream(bis);){
				Object obj = ois.readObject();
				return obj;
			}catch (IOException e) {
				throw new IOException(e);
			}
		}
		return null;
	}
	
	//深克隆
	public static Object deepClone(Object object) throws IOException,ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}
	
	//文件转字节流
	public static byte[] fileToBytes(String filePath,byte[] buffer) throws IOException{
		//final byte b[] = new byte[1024];
		Path path = Paths.get(filePath);
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileInputStream fis = new FileInputStream(path.toFile());){
			int n = 0;
			while((n=fis.read(buffer))!=-1){
				baos.write(buffer,0,n);
			}
			return baos.toByteArray();
		}catch (IOException e) {
			return null;
		}
	}
	
	//获取文件MD5值[最简单的方法:DigestUtils.md5Hex(new FileInputStream(path))]
	public static String getFileMD5(String filePath,byte[] buffer) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		Path path = Paths.get(filePath);
		try(InputStream inputStream = Files.newInputStream(path)){
			int n = 0;
			while((n=inputStream.read(buffer))!=-1){
				messageDigest.update(buffer,0,n);
			}
			BigInteger bigInt = new BigInteger(1,messageDigest.digest());
			return bigInt.toString(16);
		 }catch(Exception e){
			throw new Exception();
		 }
	}
	
	/**
	 * try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("F:\\1.zip"))){
	 *     File file = new File("F:\\1");
	 *	   toZip(file,file.getName(),zos,new byte[1024]);//文件目录可以写成F:/1或F:\\1
	 * }catch(IOException e){
	 *	   throw new IOException(e);
	 * }
	 */
	//压缩文件或目录
	public static void toZip(File file,String name,ZipOutputStream zos,byte buffer[]) throws IOException {
		if(file.isFile()){//文件
			zos.putNextEntry(new ZipEntry(name));
			int n=0;
			InputStream inputStream = Files.newInputStream(Paths.get(file.getPath()));
			while((n=inputStream.read(buffer))!=-1){
				zos.write(buffer,0,n);
			}
			inputStream.close();
		}else{//目录
			 File files[] = file.listFiles();
			 if(files==null||files.length==0){//空文件夹
				 zos.putNextEntry(new ZipEntry(name+File.separator));
				 zos.closeEntry();
			 }else{//非空
				 for(File f:files){
					 toZip(f,name+File.separator+f.getName(),zos,buffer);
				 }
			 }
		}
	}
	
	/**
	 * try(ZipInputStream zis = new ZipInputStream(new FileInputStream("F:\\1.zip"))){
	 *     unZip("F:\\1",zis,new byte[1024]);
	 * }catch(IOException e){
	 *	   throw new IOException(e);
	 * }
	 */
	//解压文件
	public static void unZip(String unZipRootFilePath,ZipInputStream zis,byte buffer[]) throws IOException {
		ZipEntry zipEntry = null;
		int n=0;
		while((zipEntry=zis.getNextEntry())!=null){
			String filePath = unZipRootFilePath+File.separator+zipEntry.getName();
			String fileFolder = filePath.substring(0,filePath.lastIndexOf(File.separator));
			File file = new File(fileFolder);
			if(!file.exists()){
				file.mkdirs();
			}
			file = new File(filePath);
			if(!file.isDirectory()){
				OutputStream outputStream = Files.newOutputStream(file.toPath());
				while((n=zis.read(buffer))!=-1){
					outputStream.write(buffer,0,n);
				}
				outputStream.close();
			}
		}
	}
	
	//图片转Base64字符串
	public static String imageSrcToBase64String(String src) {
	    byte[] data = null;
	    try(InputStream inputStream = new FileInputStream(new File(src))) {
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	    } catch (IOException e) {
	        //do nothing
	    }
	    if(data==null){
	    	return null;
	    }else{
	    	data = Base64.getEncoder().encode(data);
	    	return new String(data);
	    }
	}
	
	//Base64字符串解码
	public static byte[] getBase64Byte(String imageBase64String) {
		try{
			//为了去除data:image/png;base64,
			imageBase64String = imageBase64String.split(",")[1];
		}catch(Exception e){
			//do nothing
		}
		byte[] data = null;
		try{
			data = Base64.getDecoder().decode(imageBase64String.getBytes());
			for(int i=0;i<data.length;++i) {
				if(data[i]<0){
					data[i] += 256;
				}
			}
			//OutputStream out = new FileOutputStream(path);
			//out.write(data);
			//out.close();
		} catch (Exception e){
			//do nothing
		}
		return data;
	}
	
}
