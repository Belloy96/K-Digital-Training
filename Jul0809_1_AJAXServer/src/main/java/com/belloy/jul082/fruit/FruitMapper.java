package com.belloy.jul082.fruit;

import java.util.List;

public interface FruitMapper {

	public abstract List<Fruit> printFruit();
	public abstract List<Fruit> searchFruit(Fruit f); // 파라미터 타입도 일치!(Fruit f)
	
	
}
