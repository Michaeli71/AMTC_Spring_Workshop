package step2;

import exercise.Pizza;

public interface IDiscountStrategy {
	double apply(final Pizza pizza);
}
