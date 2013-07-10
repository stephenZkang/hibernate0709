package com.factory.demo;

/**
 * @author QIAOK
 * @see 汽车的类型
 * @since 2013/07/09
 */
public enum CarTypEnum {
	奥迪,别克,宝马,劳斯莱斯,路虎,法拉利;
	
	public static CarTypEnum differByName(String name) {
		if(name == null || "".endsWith(name.trim())) {
			return null;
		}
		if(name.startsWith("奥迪")) {
			return 奥迪;
		}else if(name.startsWith("别克")){
			return 别克;
		}else if(name.startsWith("宝马")){
			return 宝马;
		}else if(name.startsWith("劳斯莱斯")){
			return 劳斯莱斯;
		}else if(name.startsWith("路虎")){
			return 路虎;
		}else if(name.startsWith("法拉利")){
			return 法拉利;
		}
		return null;
	}
}
