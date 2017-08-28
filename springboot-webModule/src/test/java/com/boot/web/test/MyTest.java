package com.boot.web.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.fc.http.core.HttpConnectFacory;
import com.fc.http.core.HttpMethordEnum;
import com.fc.http.core.HttpConnectFacory.HttpConnect;

public class MyTest {

	CountDownLatch latch=new CountDownLatch(1);
	/**
	 * 请求测试
	 */
	@Test
	public void testCheck(){
		HttpConnect connect;
		try {
			connect = HttpConnectFacory.getHttpConnect("http","localhost","8011","/test/mybatis");
			connect.setHeader("Cookie","jeesite.session.id=c5e6909ff5f841c4bffd3fdbecf772b9");
			connect.setConnectTimeout(60000);     //超时设置
			connect.openConnect(HttpMethordEnum.POST);
			connect.sendRequest(null);
			connect.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		latch.countDown();
	}
	/**并发请求测试
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(50);
		for (int i = 0; i < 50; i++) {
			new Thread(new task(latch)).start();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
/**
 * 单个请求任务
 * @author fengchao
 *
 */
class task implements Runnable {

	private CountDownLatch latch;

	public task(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.latch = latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			HttpConnect connect = HttpConnectFacory.getHttpConnect("http", "127.0.0.1", "8011",
					"/test/mybatis");
			/*connect.setHeader("cookie",
					"JSESSIONID=A3CE96AE2C478B0AB21D14924D3813F8; jeesite.session.id=91ed9bd0604b46119ea71d78cd7dbc29");*/
			connect.openConnect(HttpMethordEnum.POST);
			latch.countDown();
			latch.await();
			connect.sendRequest(null);
			connect.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}