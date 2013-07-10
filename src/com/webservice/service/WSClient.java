package com.webservice.service;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Service;
import org.junit.Test;

/**
 * @author QIAOK
 * @see 访问webService客户端
 * @since 2013/07/10
 */
public class WSClient {
	
	@Test
	public void request() {
		String url = "http://localhost:8080/hibernate0709/services/WSSimple";
		//客户端
		Service service = new Service();
		try {
			Call call = service.createCall();
			
			//访问WS的地址
			call.setTargetEndpointAddress(url);
			
			String results = (String) call.invoke(
						new QName(null,"helloworld"),	//访问服务的方法
						new Object[] {"Jame","Mack"});  //向服务端传递参数
			
			System.out.println(results);//打印返回结果
			
		} catch (ServiceException e) {
			System.out.println("Service");
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("Connection refused: connect");
		}
	}
}
