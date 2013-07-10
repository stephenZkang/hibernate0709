package com.factory.demo;

/**
 * @author QIAOK
 * @see 生产汽车的工厂(简单工厂模型)
 * @see 工厂被设计为单例
 * @since 2013/07/09
 */
public class CarFactory {
	
	private static CarFactory carFactory = new CarFactory();
	private CarFactory() {
	}
	
	public static CarFactory getCarFactory() {
		return carFactory;
	}
	
	public  Car productCar(String name) {
		CarTypEnum carType = CarTypEnum.differByName(name);
		
		if(carType ==null) {
			System.out.println("不能生产这种品牌的车..");
			return null;
		}
		
		if(carType.compareTo(CarTypEnum.别克) == 0) {
			return new BuickCar();
		}else if (carType.compareTo(CarTypEnum.劳斯莱斯) == 0) {
			return new Rolls_RoyceCar();
		}else if (carType.compareTo(CarTypEnum.奥迪) == 0) {
			return new AudiCar();
		}else if (carType.compareTo(CarTypEnum.宝马) == 0) {
			return new BMWCar();
		}else if (carType.compareTo(CarTypEnum.法拉利) == 0) {
			return new FerrariCar();
		}else if (carType.compareTo(CarTypEnum.路虎) == 0) {
			return new LandRoverCar();
		}
		
		return null;
	}
}
