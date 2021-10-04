package step1;

import exercise.Pizza;

public interface IDiscountStrategy {
	double apply(final Pizza pizza);
}
