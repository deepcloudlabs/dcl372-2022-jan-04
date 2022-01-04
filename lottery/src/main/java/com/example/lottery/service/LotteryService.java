package com.example.lottery.service;

import java.util.List;

public interface LotteryService {
	List<Integer> draw(int max,int size);
}
