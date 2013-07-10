package com.hibernate.test;

import org.junit.Test;

import com.factory.demo.Car;
import com.factory.demo.CarFactory;

/**
 * @author QIAOK
 * @see 测试工厂
 * @since 2013/07/09
 */
public class CarFactoryTest {
	
	@Test
	public void testProduct() {
		CarFactory carFactory = CarFactory.getCarFactory();
		Car productCar = carFactory.productCar("别克");
		if(productCar!=null) {
			productCar.driverCar();
		}
	}
}
