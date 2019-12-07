 package com.DemoAll.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 * 
 * @author Lychie Fan
 */
public class IOToFileUtils {

	private static final int EOF = -1;
	private static final int INDEX_NOT_FOUND = -1;
	private static final int BUFFER_SIZE = 1024 * 1024 / 2;
	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * 写出
	 * 
	 * @param src
	 *            源文件
	 * @param out
	 *            输出流
	 * @throws Exception
	 */
	public static void write(File src, OutputStream out) {

		try {
			InputStream in = new FileInputStream(src);
			write(in, out, BUFFER_SIZE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 写出
	 * 
	 * @param in
	 *            输入流
	 * @param dest
	 *            目标文件
	 */
	public static void write(InputStream in, File dest) {
		try {
			OutputStream out = new FileOutputStream(dest);
			write(in, out, BUFFER_SIZE);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 写出
	 * 
	 * @param in
	 *            输入流
	 * @param out
	 *            输出流
	 * @throws IOException 
	 */
	public static void write(InputStream in, OutputStream out) throws IOException {
		write(in, out, BUFFER_SIZE);
	}

	/**
	 * 写出
	 * 
	 * @param in
	 *            输入流
	 * @param out
	 *            输出流
	 * @param bufferSize
	 *            缓冲字节数大小
	 * @throws IOException 
	 */
	public static void write(InputStream in, OutputStream out, int bufferSize) throws IOException {
		try {
			int read;
			byte[] buffer = new byte[bufferSize];
			while ((read = in.read(buffer)) != EOF) {
				out.write(buffer, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
	}

	/**
	 * 写出文本内容
	 * 
	 * @param text
	 *            文本内容
	 * @param out
	 *            输出流
	 * @throws Exception 
	 */
	public static void write(String text, OutputStream out) throws Exception {
		Writer writer = new OutputStreamWriter(out);
		write(text, new BufferedWriter(writer));
	}

	/**
	 * 写出文本内容
	 * 
	 * @param text
	 *            文本内容
	 * @param file
	 *            目标文件
	 */
	public static void write(String text, File file) {
		try {
			Writer writer = new FileWriter(file);
			write(text, new BufferedWriter(writer));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取文件内容, 使用UTF-8字符集编码
	 * 
	 * @param file
	 *            文件
	 * @return
	 * @throws Exception
	 */
	public static String readAsString(File file) throws Exception {
		try {
			return readAsString(new FileInputStream(file), DEFAULT_CHARSET);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * 读取文件内容
	 * 
	 * @param file
	 *            文件
	 * @param charset
	 *            使用的字符集编码
	 * @return
	 * @throws Exception 
	 */
	public static String readAsString(File file, String charset) throws Exception {
		try {
			return readAsString(new FileInputStream(file), charset);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	 /**
     * 以字节为单位读取文件，常用于读取二进制文件，如：图片、声音、影像等
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByBytes(String fileName){
        File file = new File(fileName);
        InputStream in = null;
        try{
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            //一次读取一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while((tempbyte=in.read())!= -1){
                System.out.write(tempbyte);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
        try{
            System.out.println("以字节为单位读取文件内容，一次读取多个字节：");
            //一次读取多个字节
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            in = new FileInputStream(fileName);
            showAvailableBytes(in);
            //读入多个字节到字节数组中，byteread为一次读入的字节数
            while((byteread=in.read(tempbytes))!= -1){
                System.out.write(tempbytes, 0, byteread);;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 以字符为单位读取文件，常用于读取文本，数字等类型的文件
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByChars(String fileName){
        File file = new File(fileName);
        Reader reader = null;
        try{
            System.out.println("以字符为单位读取文件内容，一次读取一个字符：");
            //一次读取一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while((tempchar=reader.read())!= -1){
                //对于window下，/r/n这两个字符在一起时，表示一个换行。
                //但如果这两个字符分开显示是，会换两次行。
                //因此，屏蔽掉/r,或者屏蔽/n。否则，将会多出很多空行
                if(((char)tempchar)!= '\r'){
                    System.out.print((char)tempchar);
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();  
        }
        try{
            System.out.println("以字符为单位读取文件内容，一次读取多个字符：");
            //一次读取多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            //读取多个字符到字符数组中，charread为一次读取字符数
            while((charread=reader.read(tempchars))!=-1){
                //屏蔽掉/r不显示
                if((charread == tempchars.length) && (tempchars[tempchars.length-1]!='\r')){
                    System.out.print(tempchars);
                }else{
                    for(int i=0;i<charread;i++){
                        if(tempchars[i] == '\r'){
                            continue;
                        }else{
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读取面向行的格式化文件
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        try{
            System.out.println("以行为单位读取文件内容，一次读取一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //一次读入一行，直到读入null为文件结束
            while((tempString = reader.readLine())!=null){
                //显示行号
                System.out.println("line "+line+":"+tempString);
                line++;
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static List<String> readFileByLinesList(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> list=new ArrayList<String>();
        try{
            System.out.println("以行为单位读取文件内容，一次读取一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
           // int line = 1;
            //一次读入一行，直到读入null为文件结束
            while((tempString = reader.readLine())!=null){
                //显示行号
               // System.out.println("line "+line+":"+tempString);
               // line++;
            	list.add(tempString);
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
		return list;
    }

    /**
     * 随机读取文件内容
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByRandomAccess(String fileName){
        RandomAccessFile randomFile = null;
        try{
            System.out.println("随机读取一段文件内容：");
            //打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName,"r");
            //文件长度，字节数
            long fileLength = randomFile.length();
            //读文件的起始位置
            int beginIndex = (fileLength>4)?4:0;
            //将读取文件的开始位置移到beginIndex的位置上
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //一次读取10个字节，如果文件内容不足10个字节，则读取剩下的字节。
            //将一次读取的字节数赋给byteread
            while((byteread = randomFile.read(bytes))!= -1){
                System.out.write(bytes,0,byteread);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(randomFile!=null){
                try {
                    randomFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param in
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void showAvailableBytes(InputStream in){
        try{
            System.out.println("当前字节输入流中的字节数为："+in.available());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将内容追加到文件尾部  A方法：使用RandomAccessFile
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName 包含完整路径的文件名
     * @param content 要追加的内容
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void appendToFile_A(String fileName,String content){
        try{
            //打开一个随机访问的文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName,"rw");
            //文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾部
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将内容追加到文件尾部  B方法：使用FileWriter
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void appendToFile_B(String fileName,String content){
        try{
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName,true);            
            writer.write(content);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将内容追加到文件尾部 C方法：使用BufferedWriter
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月10日]
     */
    public static void appendToFile_C(String fileName,String content){

        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true)));
            out.write(content);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                out.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

	/**
	 * 读取输入流内容, 使用UTF-8字符集编码
	 * 
	 * @param in
	 *            输入流
	 * @return
	 * @throws Exception 
	 */
	public static String readAsString(InputStream in) throws Exception {
		return readAsString(in, DEFAULT_CHARSET);
	}

	/**
	 * 读取输入流内容
	 * 
	 * @param in
	 *            输入流
	 * @param charset
	 *            使用的字符集编码
	 * @return
	 * @throws Exception 
	 */
	public static String readAsString(InputStream in, String charset) throws Exception {
		try {
			return readAsString(new InputStreamReader(in, charset));
		} catch (Throwable e) {
			throw new Exception(e);
		}
	}

	/**
	 * 逐行读取整个文件内容, 使用UTF-8字符集编码
	 * 
	 * @param file
	 *            文件
	 * @return
	 * @throws Exception 
	 */
	public static String[] read(File file) throws Exception {
		try {
			return read(new FileInputStream(file), DEFAULT_CHARSET);
		} catch (Throwable e) {
			throw new Exception(e);
		}
	}

	/**
	 * 逐行读取整个文件内容
	 * 
	 * @param file
	 *            文件
	 * @param charset
	 *            使用的字符集编码
	 * @return
	 * @throws Exception 
	 */
	public static String[] read(File file, String charset) throws Exception {
		try {
			return read(new FileInputStream(file), charset);
		} catch (Throwable e) {
			throw new Exception(e);
		}
	}

	/**
	 * 逐行读取输入流内容, 使用UTF-8字符集编码
	 * 
	 * @param in
	 *            输入流
	 * @return
	 * @throws Exception 
	 */
	public static String[] read(InputStream in) throws Exception {
		return read(in, DEFAULT_CHARSET);
	}

	/**
	 * 逐行读取输入流内容
	 * 
	 * @param in
	 *            输入流
	 * @param charset
	 *            使用的字符集编码
	 * @return
	 * @throws Exception 
	 */
	public static String[] read(InputStream in, String charset) throws Exception {
		try {
			return read(new InputStreamReader(in, charset));
		} catch (Throwable e) {
			throw new Exception(e);
		}
	}

	/**
	 * 获取文件总行数
	 * 
	 * @param file
	 *            文件
	 * @return
	 * @throws Exception 
	 */
	public static int getLineNumber(File file) throws Exception {
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(new FileReader(file));
			reader.skip(Long.MAX_VALUE);
			int lines = reader.getLineNumber() + 1;
			return lines;
		} catch (Throwable e) {
			throw new Exception(e);
		} finally {
			reader.close();
		}
	}

	/**
	 * 获取目录下含参数指定的文件扩展名的文件列表
	 * 
	 * @param dir
	 *            目录
	 * @param extensions
	 *            文件扩展名
	 * @return
	 */
	public static List<File> list(File dir, String... extensions) {
		return list(dir, new ExtensionFilenameFilter(extensions));
	}

	/**
	 * 删除目录或文件
	 * 
	 * @param src
	 *            文件或目录
	 */
	public static void delete(File src) {
		if (!src.exists()) {
			System.out.println(" file dose not exist");
		}
		if (src.isFile()) {
			src.delete();
		} else if (src.isDirectory()) {
			File[] files = src.listFiles();
			for (File item : files) {
				delete(item);
			}
		}
		src.delete();
	}

	/**
	 * 重命名目录名或文件名
	 * 
	 * @param src
	 *            文件或目录
	 * @param newName
	 *            新的名称
	 * @return
	 */
	public static File rename(File src, String newName) {
		if (!src.exists()) {

			System.out.println("file dose not exist");
		}
		String oldName = src.getName();
		int oldIndex = oldName.lastIndexOf(".");
		if (oldIndex != INDEX_NOT_FOUND) {
			int newIndex = newName.lastIndexOf(".");
			if (newIndex == INDEX_NOT_FOUND) {
				newName += oldName.substring(oldIndex);
			}
		}
		String pathname = src.toString();
		pathname = pathname.substring(0, pathname.length() - oldName.length());
		pathname += newName;
		File newFile = new File(pathname);
		if (newFile.exists()) {
			System.out.println("file already exists");
		}
		src.renameTo(newFile);
		return newFile;
	}

	/**
	 * 创建目录
	 * 
	 * @param dir
	 *            目录
	 * @return
	 */
	public static File mkdir(File dir) {
		return mkdir(dir, false);
	}

	/**
	 * 创建目录
	 * 
	 * @param parent
	 *            父目录
	 * @param child
	 *            子目录名称
	 * @return
	 */
	public static File mkdir(File parent, String child) {
		return mkdir(parent, child, false);
	}

	/**
	 * 拷贝文件或目录
	 * 
	 * @param src
	 *            源文件或目录
	 * @param destDir
	 *            目的目录
	 * @throws Exception 
	 */
	public static void copy(File src, File destDir) throws Exception {
		List<File> record = new ArrayList<File>();
		try {
			if (src.isFile()) {
				copyFileToDirectory(src, destDir, record);
			} else if (src.isDirectory()) {
				copyDirectorToDirector(src, destDir, record);
			}
		} catch (Throwable e) {
			rollback(record);
			throw new Exception(e);
		}
	}

	/**
	 * 强行拷贝文件或目录
	 * 
	 * @param src
	 *            源文件或目录
	 * @param destDir
	 *            目的目录
	 * @param overwrite
	 *            存在是否覆盖
	 * @throws Exception 
	 */
	public static void forceCopy(File src, File destDir, boolean overwrite) throws Exception {
		try {
			if (src.isFile()) {
				forceCopyFileToDirectory(src, destDir, overwrite);
			} else if (src.isDirectory()) {
				forceCopyDirectorToDirector(src, destDir, overwrite);
			}
		} catch (Throwable e) {
			throw new Exception(e);
		}
	}

	/**
	 * 剪切文件或目录
	 * 
	 * @param src
	 *            源文件或目录
	 * @param destDir
	 *            目的目录
	 * @throws Exception 
	 */
	public static void move(File src, File destDir) throws Exception {
		copy(src, destDir);
		delete(src);
	}

	/**
	 * 强行剪切文件或目录
	 * 
	 * @param src
	 *            源文件或目录
	 * @param destDir
	 *            目的目录
	 * @param overwrite
	 *            存在是否覆盖
	 * @throws Exception 
	 */
	public static void forceMove(File src, File destDir, boolean overwrite) throws Exception {
		forceCopy(src, destDir, overwrite);
		delete(src);
	}

	/**
	 * 清空目录
	 * 
	 * @param dir
	 *            目录
	 */
	public static void cleanDirectory(File dir) {
		if (!dir.exists()) {
			System.err.println(" does not exist"); 
		}
		if (!dir.isDirectory()) {
			System.err.println("is not a directory"); 
		}
		File[] list = dir.listFiles();
		if (list != null && list.length > 0) {
			for (File item : list) {
				delete(item);
			}
		}
	}

	/**
	 * 获取文件名称, 不包含文件扩展名
	 * 
	 * @param file
	 *            文件
	 * @return
	 */
	public static String getFileName(File file) {
		if (file.isFile()) {
			String filename = file.getName();
			int index = filename.lastIndexOf(".");
			if (index != INDEX_NOT_FOUND) {
				filename = filename.substring(0, index);
			}
			return filename.trim();
		} else if (file.isDirectory()) {
			return file.getName();
		}
		System.err.println("is not a file or directory");
		return null; 
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param file
	 *            文件
	 * @return
	 */
	public static String getFileExtension(File file) {
		if (file.isFile()) {
			String filename = file.getName();
			int index = filename.lastIndexOf(".");
			if (index != INDEX_NOT_FOUND) {
				return filename.substring(index + 1);
			}
			return "";
		}
		System.err.println("is not a file");
		return null; 
	}

	/**
	 * 创建目录
	 * 
	 * @param dir
	 *            目录
	 * @param skip
	 *            若目录已存在, 是否跳过
	 * @return
	 */
	public static File mkdir(File dir, boolean skip) {
		String empty = "";
		return mkdir(dir, empty, skip);
	}

	/**
	 * 创建目录
	 * 
	 * @param parent
	 *            父目录
	 * @param child
	 *            子目录名称
	 * @param skip
	 *            若目录已存在, 是否跳过
	 * @return
	 */
	public static File mkdir(File parent, String child, boolean skip) {
		File dir = new File(parent, child);
		if (dir.exists()) {
			if (!skip) {
				System.err.println(" directory already exists");
			}
		} else {
			dir.mkdirs();
		}
		return dir;
	}

	/**
	 * 获取与系统文件分隔符统一的路径
	 * 
	 * @param path
	 *            源路径
	 * @return
	 */
	public static String getUniformPath(String path) {
		if (File.separator.equals("/")) {
			int index = path.indexOf("\\");
			if (index != INDEX_NOT_FOUND) {
				path = path.replace("\\", File.separator);
			}
		} else if (File.separator.equals("\\")) {
			int index = path.indexOf("/");
			if (index != INDEX_NOT_FOUND) {
				path = path.replace("/", File.separator);
			}
		}
		return path;
	}

	/**
	 * 写出文本内容
	 * 
	 * @param text
	 *            文本内容
	 * @param writer
	 *            Writer
	 * @throws Exception 
	 */
	private static void write(String text, Writer writer) throws Exception {
		BufferedReader reader = null;
		try {
			int read;
			char[] buffer = new char[BUFFER_SIZE];
			reader = new BufferedReader(new StringReader(text));
			while ((read = reader.read(buffer)) != EOF) {
				writer.write(buffer, 0, read);
			}
		} catch (Throwable e) {
			throw new Exception(e);
		} finally {
			reader.close();
			writer.close();
		}
	}

	/**
	 * 逐行读取
	 * 
	 * @param r
	 *            Reader
	 * @return
	 * @throws Exception 
	 */
	private static String[] read(Reader r) throws Exception {
		BufferedReader reader = null;
		try {
			String read;
			reader = new BufferedReader(r);
			List<String> contents = new ArrayList<String>();
			while ((read = reader.readLine()) != null) {
				contents.add(read);
			}
			return CollectionUtil.asArray(contents);
		} catch (Throwable e) {
			throw new Exception(e);
		} finally {
			reader.close();
		}
	}

	/**
	 * 读取内容
	 * 
	 * @param r
	 *            Reader
	 * @return
	 * @throws Exception 
	 */
	private static String readAsString(Reader r) throws Exception {
		String[] result = read(r);
		int size = result.length - 1;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(result[i]).append("\r\n");
		}
		builder.append(result[size]);
		return builder.toString();
	}

	/**
	 * 目录下的文件列表
	 * 
	 * @param dir
	 *            目录
	 * @param filters
	 *            FilenameFilter
	 * @return
	 */
	private static List<File> list(File dir, FilenameFilter filters) {
		if (dir.isFile()) {
			System.err.println( " is not a directory");
		}
		File[] files = dir.listFiles(filters);
		List<File> list = new ArrayList<File>();
		for (File file : files) {
			if (file.isFile()) {
				list.add(file);
			} else if (file.isDirectory()) {
				list.addAll(list(file, filters));
			}
		}
		return list;
	}

	/**
	 * 拷贝文件到目录
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destDir
	 *            目的目录
	 * @param record
	 *            记录列表
	 * @throws Throwable
	 */
	private static void copyFileToDirectory(File srcFile, File destDir,
			List<File> record) throws Throwable {

		File destFile = new File(destDir, srcFile.getName());
		if (destFile.exists()) {
			System.err.println(" file already exists");
		}
		record.add(destFile);
		write(new FileInputStream(srcFile), new FileOutputStream(destFile));
	}

	/**
	 * 拷贝目录到目录
	 * 
	 * @param srcDir
	 *            源目录
	 * @param destDir
	 *            目的目录
	 * @param record
	 *            记录列表
	 * @throws Throwable
	 */
	private static void copyDirectorToDirector(File srcDir, File destDir,
			List<File> record) throws Throwable {

		destDir = new File(destDir, srcDir.getName());
		if (!destDir.exists()) {
			destDir.mkdir();
			record.add(destDir);
		}
		File[] files = srcDir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				copyFileToDirectory(file, destDir, record);
			} else if (file.isDirectory()) {
				copyDirectorToDirector(file, destDir, record);
			}
		}
	}

	/**
	 * 强行拷贝文件到目录
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destDir
	 *            目的目录
	 * @param overwrite
	 *            存在是否覆盖
	 * @throws Throwable
	 */
	private static void forceCopyFileToDirectory(File srcFile, File destDir,
			boolean overwrite) throws Throwable {

		File destFile = new File(destDir, srcFile.getName());
		if (!destFile.exists() || (destFile.exists() && overwrite)) {
			write(new FileInputStream(srcFile), new FileOutputStream(destFile));
		}
	}

	/**
	 * 强行拷贝目录到目录
	 * 
	 * @param srcDir
	 *            源目录
	 * @param destDir
	 *            目的目录
	 * @param overwrite
	 *            存在是否覆盖
	 * @throws Throwable
	 */
	private static void forceCopyDirectorToDirector(File srcDir, File destDir,
			boolean overwrite) throws Throwable {

		destDir = new File(destDir, srcDir.getName());
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		File[] files = srcDir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				forceCopyFileToDirectory(file, destDir, overwrite);
			} else if (file.isDirectory()) {
				forceCopyDirectorToDirector(file, destDir, overwrite);
			}
		}
	}

	/**
	 * 回滚
	 * 
	 * @param record
	 *            记录列表
	 */
	private static void rollback(List<File> record) {
		try {
			for (File item : record) {
				delete(item);
			}
		} catch (Throwable e) {
			/* ignore */
		}
	}

	/**
	 * 文件扩展名过滤器
	 */
	private static class ExtensionFilenameFilter implements FilenameFilter {

		private String[] extensions;

		public ExtensionFilenameFilter(String[] extensions) {
			this.extensions = extensions;
		}

		@Override
		public boolean accept(File dir, String name) {
			if (new File(dir, name).isDirectory()) {
				return true;
			}
			if (extensions.length == 0) {
				return true;
			}
			int index = name.lastIndexOf(".");
			if (index != INDEX_NOT_FOUND) {
				name = name.substring(index + 1);
				if (CollectionUtil.contains(extensions, name)) {
					return true;
				}
			}
			return false;
		}

	}

}