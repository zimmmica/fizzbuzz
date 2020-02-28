package com.fizzbuzz.service;

import java.util.Objects;
import java.util.Optional;

import com.fizzbuzz.FizzBuzzStage;

public class FizzBuzzFactory {

	private static final FizzBuzzFactory instance = new FizzBuzzFactory();

	public static final FizzBuzzFactory getInstance() {
		return instance;
	}

	public FizzBuzzService createFizzBuzzService(final FizzBuzzStage stage) {

		Objects.requireNonNull(stage);

		return new FizzBuzzService() {

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

			private boolean isFizzStage1(int number) {
				return number % FIZZ_DIGIT == 0;
			}

			private boolean isBuzzStage1(int number) {
				return number % BUZZ_DIGIT == 0;
			}

			private boolean isFizzStage2(int number) {
				return isFizzStage1(number) || containsDigit(number, FIZZ_DIGIT);
			}

			private boolean isBuzzStage2(int number) {
				return isBuzzStage1(number) || containsDigit(number, BUZZ_DIGIT);
			}

			@Override
			public Optional<String> evaluateFizzBuzz(int number) {

				boolean fizz = false;
				boolean buzz = false;

				if (stage == FizzBuzzStage.STAGE1) {
					fizz = isFizzStage1(number);
					buzz = isBuzzStage1(number);
				}
				if (stage == FizzBuzzStage.STAGE2) {
					fizz = isFizzStage2(number);
					buzz = isBuzzStage2(number);
				}

				if (fizz && buzz) {
					return Optional.of("FizzBuzz");
				} else if (fizz) {
					return Optional.of("Fizz");
				} else if (buzz) {
					return Optional.of("Buzz");
				} else {
					return Optional.empty();
				}

			}

		};
	}
}
