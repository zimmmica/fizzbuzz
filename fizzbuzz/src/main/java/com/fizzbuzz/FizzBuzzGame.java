package com.fizzbuzz;

import java.util.Optional;

import com.fizzbuzz.service.FizzBuzzFactory;
import com.fizzbuzz.service.FizzBuzzService;

public class FizzBuzzGame {

	private void print(String o) {
		System.out.println(o);
	}

	public void playFizzBuzz(int playTo, FizzBuzzStage stage) {

		if (playTo < 1) {
			throw new IllegalArgumentException("playTo must be greater than 0");
		}

		if (stage == null) {
			throw new IllegalArgumentException("stage must not be null");
		}

		FizzBuzzService service = FizzBuzzFactory.getInstance().createFizzBuzzService(stage);
		for (int n = 1; n <= playTo; n++) {
			final int currentNumber = n;
			Optional<String> fizzBuzzing = service.evaluateFizzBuzz(currentNumber);
			print(fizzBuzzing.orElseGet(() -> String.valueOf(currentNumber)));
		}
	}

}
