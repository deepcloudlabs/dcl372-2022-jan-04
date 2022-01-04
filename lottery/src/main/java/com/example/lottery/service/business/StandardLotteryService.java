package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;

public class StandardLotteryService implements LotteryService {
	private RandomNumberService randomNumberService;

	public StandardLotteryService(RandomNumberService randomNumberService) {
		this.randomNumberService = randomNumberService;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate(
				() -> randomNumberService.generate(1, max))
				.distinct()
				.limit(size)
				.sorted()
				.boxed()
				.toList();
	}

}
