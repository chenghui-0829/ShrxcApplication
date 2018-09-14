package com.ch.print;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PrintHelper printHelper;
    private List<FoodChoose> foodChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.but);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                testPrint();
            }
        });
    }


    /**
     * 直接连接网络打印机打印，不需要tomcat,暂时不用
     */
    public void testPrint() {
        System.out.println("测试打印");
        // 开启一个子线程
        new Thread() {
            public void run() {
                try {
                    printHelper = new PrintHelper("192.168.1.58", 9100, "GBK"); // 第一个参数是打印机网口IP

                    // 初始化打印机
                    printHelper.initPos();

                    System.out.println("----->" + printHelper);

                    //printHelper.printLocation(1);
                    //printHelper.printLine(2);
                    // 打印二维码
                    printHelper.qrCode("http://blog.csdn.net/haovip123");

                    // 切纸
                    //printHelper.feedAndCut();

                    printHelper.closeIOAndSocket();
                    printHelper = null;
                } catch (UnknownHostException e) {
                    System.out.println("UnknownHostException======》" + e);
                } catch (IOException e) {
                    System.out.println("IOException======》" + e);
                }
            }

        }.start();

    }

    private void initData() {
        foodChoose = new ArrayList<FoodChoose>();

        for (int i = 0; i < 4; i++) {
            FoodChoose fb = new FoodChoose();
            fb.setFoodname("测试菜品" + i);
            fb.setFoodunitprice(90);
            fb.setFoodnum(2);
            foodChoose.add(fb);
        }
    }


//
//    private void PrintTask() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Looper.prepare();
//                    //这里直接输入ip地址和端口号
//                    Socket socket = new Socket("192.168.1.58", 9100);
//                    //当前已经连接成功，并且是处于活跃状态
//                    if (socket.isConnected() && socket.getKeepAlive()) {
//                        System.out.println("连接cg=============");
//                        //获取服务端的输入流,这里可用可不用，主要看产品
//                        InputStream inputStream = socket.getInputStream();
//                        //获取服务端的输出流，这个就一定要取到，因为这个关系到能不能向服务端发送出消息的操作
//                        OutputStream os = socket.getOutputStream();
//
//
//                        os.write(0x1B);
//                        os.write(0x40);
//                        os.flush();
//
//
//                        String text = "测试客户端和服务器通信";
//                        byte[] data = text.getBytes("GB2312");
//                        os.write(data, 0, data.length);
//                        os.flush();
//
//
////                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
////                        //向服务器端发送一条消息，在打印机里面，\n的动作是必要的，如果没有\n的动作，打印机是不会打印出任何东西的
////                        bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
////                        bw.flush();
////                        //读取服务器返回的消息
////                        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
////                        String mess = br.readLine();
////                        Log.d("TAG", "服务器：" + mess);
//                    } else {
//                        System.out.println("client 连接失败===================");
//                    }
//                } catch (IOException e) {
//                    System.out.println("client IOException：=================" + e);
//                }
//            }
//        }).start();
//
//
//    }

}
