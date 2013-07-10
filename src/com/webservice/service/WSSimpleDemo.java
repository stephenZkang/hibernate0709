package com.webservice.service;

/**
 * @author QIAOK
 * @see 基于Axis的WebService
 * @see 需要导入9个jar包
 * @since 2013/07/10
 */
public class WSSimpleDemo {
	
	/**
	 * 客户端传来的参数
	 * @param name
	 * @param age
	 * @return
	 */
	public String helloworld(String name,String age) {
		System.out.println(age);
		if(name!=null) {
			System.out.println("hello world," +name+" !");
		}else {
			System.out.println("hello world,Sir !");
		}
		return "hello"; //向客户端返回的值
	}
	
}
