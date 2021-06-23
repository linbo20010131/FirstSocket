package com.yr.socketUdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client1 {
        public static void main(String[] args) {
            try {
                //DatagramSocket代表声明一个UDP协议的Socket
                DatagramSocket socket = new DatagramSocket(2468);
                //字符串存储人Byte数组
                byte[] car = "UDP协议的Socket请求，有可能失败哟".getBytes();
                //InetSocketAddress类主要作用是封装端口
                InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
                //DatagramPacket 类用来表示数据报包DatagramPacket
                DatagramPacket packet = new DatagramPacket(car, car.length, address);
                //send() 方法发送数据包。
                socket.send(packet);
                System.out.println("UDP协议的Socket发送成功");
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }