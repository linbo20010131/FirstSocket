package com.yr.socketTcp;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 客户端
 * 
 * @author Administrator
 *
 */
public class SocketClient {
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// 创建客户端Socket,指定服务器地址和端口,端口必须和服务端一致
			socket = new Socket("192.168.1.55", 15222);
			// 设值超时时间,如果过了这个时间,自动关闭连接
			socket.setSoTimeout(10000);
			// 由系统输入并构造BufferedReader对象
			br = new BufferedReader(new InputStreamReader(System.in));
			// 由Socket对象得到输入流,并构造相应的BufferedReader对象
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 循环输入
			while (true) {
				System.out.println("请输入消息：");
				// 将从系统输入读入的字符输出到Service
				bw.write(br.readLine());
				// 写入一个换行空格
				bw.newLine();
				// 刷新
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 当不等于空的时候关闭连接
			if (null != bw) {
				bw.close();
			}
			if (null != br) {
				br.close();
			}
			if (null != socket) {
				socket.close();
			}
		}
	}
}