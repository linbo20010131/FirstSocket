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
			serverSocket = new ServerSocket(15222);// 创建端口为15222的serverSocket
			socket = serverSocket.accept();// 监听客户端,监听过程中处于阻塞状态,直到客户端连接
			System.out.println("客户端" + socket.getInetAddress() + "连接成功");// 得到客户端的ip
			while (true) {// 循环接收
				// 接收从客户端输入的信息
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String mass = br.readLine();// 读取一行
				System.out.println("客户端发送的消息:" + mass + "\n");// 打印
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