package com.fizzbuzz;

public final class FizzBuzzStage1 {

	private static final int FIZZ_DIGIT = 3;
	private static final int BUZZ_DIGIT = 5;

	public boolean isFizz(int number) {
		return number % FIZZ_DIGIT == 0;
	}

	public boolean isBuzz(int number) {
		return number % BUZZ_DIGIT == 0;
	}

	private void print(Object o) {
		System.out.println(o);
	}

	public void playFizzBuzz(int playTo) {

		if (playTo < 1) {
			throw new IllegalArgumentException("playTo must be greater than 0");
		}

		for (int n = 1; n <= playTo; n++) {

			boolean fizz = isFizz(n);
			boolean buzz = isBuzz(n);

			if (fizz && buzz) {
				print("FizzBuzz");
			} else if (fizz) {
				print("Fizz");
			} else if (buzz) {
				print("Buzz");
			} else {
				print(n);
			}
		}
	}

	public static void main(String[] args) {
		new FizzBuzzStage1().playFizzBuzz(100);
	}

}
