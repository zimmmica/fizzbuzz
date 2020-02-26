package com.fizzbuzz;

public final class FizzBuzzStage2 {

	private static final int FIZZ_DIGIT = 3;
	private static final int BUZZ_DIGIT = 5;

	private boolean containsDigit(int number, int digit) {
		for (int left; number > 0;) {
			left = number % 10;
			if (left == digit) {
				return true;
			}
			number = number / 10;
		}
		return false;
	}

	public boolean isFizz(int number) {
		return number % FIZZ_DIGIT == 0 || containsDigit(number, FIZZ_DIGIT);
	}

	public boolean isBuzz(int number) {
		return number % BUZZ_DIGIT == 0 || containsDigit(number, BUZZ_DIGIT);
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
		new FizzBuzzStage2().playFizzBuzz(100);
	}

}
