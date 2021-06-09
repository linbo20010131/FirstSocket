package com.yr.socketTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 
 * @author Administrator
 *
 */
public class SocketServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader br = null;
		try {
			// 创建端口为15222的serverSocket
			serverSocket = new ServerSocket(15222);
			// 监听客户端,监听过程中处于阻塞状态,直到客户端连接
			socket = serverSocket.accept();
			// 得到客户端的ip
			System.out.println("客户端" + socket.getInetAddress() + "连接成功");
			// 循环接收
			while (true) {
				// 接收从客户端输入的信息
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 读取一行
				String mass = br.readLine();
				// 打印
				System.out.println("客户端发送的消息:" + mass + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 当不等于空的时候关闭连接
			if (null != br) {
				br.close();
			}
			if (null != socket) {
				socket.close();
			}
			if (null != serverSocket) {
				serverSocket.close();
			}
		}
	}
}