package com.fizzbuzz.service;

import java.util.Optional;

public interface FizzBuzzService {

	final int FIZZ_DIGIT = 3;
	final int BUZZ_DIGIT = 5;

	Optional<String> evaluateFizzBuzz(int number);

}
