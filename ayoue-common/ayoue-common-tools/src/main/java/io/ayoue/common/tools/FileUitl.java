package io.ayoue.common.tools;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @category 文件工具类
 */
public class FileUitl {
	public static final String UTF_8 = "UTF-8";
	public static final String GBK = "GBK";
	public static final String UNICODE = "Unicode";
	public static final String UTF_16BE = "UTF-16BE";
	/**
	 * 追加文件
	 * @param file
	 * @param conent
	 */
	public static void fileAppend(String file, String conent) {
		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));){
			out.write(conent + "\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重写文件
	 * @param file
	 * @param conent
	 */
	public static void fileReplaceAll(String file, String conent) {
		try(FileOutputStream in  = new FileOutputStream(file);) {
			in.write(conent.getBytes(), 0, conent.length());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 读取文件
	 * @param file
	 * @return
	 */
	public static String readerFile(String file) {
		File fileByte = new File(file);
		StringBuffer sb = new StringBuffer();
		try (FileInputStream out = new FileInputStream(fileByte); 
				InputStreamReader isr = new InputStreamReader(out, codeString(file));){
			int ch = 0;
			while ((ch = isr.read()) != -1) {
				sb.append((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 判断文件的编码格式
	 * @param fileName
	 * @return 文件编码格式
	 * @throws Exception
	 */
	public static String codeString(String fileName) throws Exception {
		try(BufferedInputStream bin =  new BufferedInputStream(new FileInputStream(fileName))) {
			int p = (bin.read() << 8) + bin.read();
			String code = null;
			switch (p) {
			case 0xefbb:
				code = UTF_8;
				break;
			case 0xfffe:
				code = UNICODE;
				break;
			case 0xfeff:
				code = UTF_16BE;
				break;
			default:
				code = GBK;
			}
			bin.close();
			return code;
		} catch (Exception e) {
			e.printStackTrace();
			return UTF_8;
		}
	}

	public static void setUp() throws Exception {
		File programRootDir = new File("./");
		URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
		add.setAccessible(true);
		add.invoke(classLoader, programRootDir.toURI().toURL());
	}

	/**
	 * <p>
	 * Title: saveFiles
	 * </p>
	 * <p>
	 * Description: 该方法主要用于存放申请和返回的报文文件
	 * </p>
	 * @param str 数据流
	 * @param codeType 编码格式，主要是GBK，UTF-8等
	 * @param filePath 文件路径
	 * @param fileName 文件名
	 * @throws IOException
	 */
	public static String saveFiles(String str, String codeType, String filePath, String fileName) {
		File fw = new File(filePath);
		if (!fw.exists()) {
			fw.mkdirs();
		}
		filePath += fileName + ".xml";
		fw = new File(filePath);
		try (FileOutputStream fos = new FileOutputStream(fw);
				OutputStreamWriter osw = new OutputStreamWriter(fos, codeType);
				BufferedWriter bw = new BufferedWriter(osw);){
			bw.write(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	/**
	 * 判断文件编码
	 * @param file
	 * @return
	 */
	public static String codeString(byte... bytes) {
		int b1 = bytes[0];
		int b2 = bytes[1];
		int b3 = bytes[2];
		if (b1 == -17 && b2 == -69 && b3 == -65) {
			return "UTF-8";
		} else if (b1 == 60 && b2 == 33 && b3 == 45) {
			return "GBK";
		} else if (b1 == 92 && b2 == 117 && b3 == 70) {// Unicode
			return "UTF-8";// 这里是被编码过的要转码
		} else if (b1 == 104 && b2 == 101 && b3 == 108) {// ASCII
			return "GBK";// 返GBK才能正确读取
		}
		return "UTF-8";
	}
	
	/**
	 * NIO读取文件
	 * @param file文件路径
	 * @param tmp 缓冲区1024的倍数
	 * @return string
	 */
	public static byte[] readBytesByNIO(String file, int tmp) {
		try (
				RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
				// 第一步 获取通道
				FileChannel channel = randomAccessFile.getChannel();){
			// 文件内容的大小
			int size = (int) channel.size();
			// 第二步 指定缓冲区
			ByteBuffer buffer = ByteBuffer.allocate(1024 * tmp);
			// 第三步 将通道中的数据读取到缓冲区中
			// channel.read(buffer);
			byte[] bt = new byte[size];
			int x = 0;
			while (channel.read(buffer) > 0) {
				int pos = buffer.position();
				buffer.rewind();// 将position设回0
				// buffer.get(pos);
				System.arraycopy(buffer.array(), 0, bt, x, pos);
				x += pos;
			}
			// Buffer bf = buffer.flip();
			buffer.clear();
			buffer = null;
			return bt;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 读取文件返回字符串
	 * @param file
	 * @param tmp
	 * @return
	 */
	public static String readStringByNIO(String file, int tmp) {
		byte[] bt = readBytesByNIO(file, tmp);
		String str = null;
		try {
			if(bt != null){
				str = new String(bt, 0, bt.length, codeString(bt));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 判断文件是否存在
	 * @param path
	 * @return
	 */
	public static boolean exists(String path) {
		if (path == null || path.equals("")) {
			return false;
		}
		try {
			Path p = Paths.get(path);
			return p.toFile().exists();
			// return Files.exists(p, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
		} catch (Exception e) {
			return false;
		}
	}

	public static String read(String path, int tmp) {
		ByteBuffer buffer = ByteBuffer.allocate(tmp);
		AsynchronousFileChannel fileChannel = null;
		String str = null;
		try {
			Path p = Paths.get(path);
			fileChannel = AsynchronousFileChannel.open(p, StandardOpenOption.READ);
			int size = (int) fileChannel.size();
			int position = 0;
			byte[] bt = new byte[size];
			while (position < size) {
				Future<Integer> operation = fileChannel.read(buffer, position);
				if (operation.get() > 0) {
					int pos = buffer.position();
					buffer.rewind();
					System.arraycopy(buffer.array(), 0, bt, position, pos);
					position += buffer.limit();
				}
			}
			// buffer.flip();
			str = new String(bt, 0, size, codeString(bt));
			buffer.clear();
			buffer = null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		    Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileChannel != null)
					fileChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	/**
	 * nio写文件，覆盖
	 * @param path
	 * @param bytes
	 * @return
	 */
	public static boolean writeByNio(String path, byte[] bytes) {
		AsynchronousFileChannel fileChannel = null;
		try {
			Path p = Paths.get(path);
			if (!Files.exists(p)) {
				Files.createFile(p);
			}
			//System.out.println(Files.isWritable(p));
			fileChannel = AsynchronousFileChannel.open(p, StandardOpenOption.WRITE);
			ByteBuffer buffer = ByteBuffer.wrap(bytes);
			Future<Integer> operation = fileChannel.write(buffer, 0);
			/*while (!operation.isDone()) {
				System.out.println("ok");
			}*/
			if (operation.get() > 0) {
				return true;
			}
			buffer.clear();
			buffer = null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileChannel != null)
					fileChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	/**
     * nio写文件，覆盖,带创建目录
     * @param path
     * @param bytes
     * @return
     */
	public static boolean writeByNioDes(String path, byte[] bytes) {
	    String des = path.substring(0, path.lastIndexOf("/"));
	    if(path.contains("/")){//D:/Interface/test/test/test.txt
	        des = path.substring(0, path.lastIndexOf("/"));
	    }else if(path.contains("\\")){//D:\\Interface\\test\\test\\test.txt
	        des = path.substring(0, path.lastIndexOf("\\"));
	    }
	    Path p = Paths.get(des);
	    if(!p.toFile().exists()){
	        try {
                Files.createDirectories(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
	    }
	    return writeByNio(path, bytes);
	}
	
	public static void main(String[] args) {
		writeByNioDes("D:/Interface/test/test/test.txt",
				read("D:\\Interface\\makePremium\\20170929\\7dfbabbee5ee46609d2d92adb233229c_request.xml",6).getBytes());
	}
	
}
