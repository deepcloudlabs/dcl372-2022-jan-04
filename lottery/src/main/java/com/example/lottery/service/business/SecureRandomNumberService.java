package com.example.lottery.service.business;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.lottery.service.QualityLevel;
import com.example.lottery.service.RandomNumberService;
import com.example.lottery.service.ServiceQuality;

@Service
@ServiceQuality(QualityLevel.SECURE)
public class SecureRandomNumberService implements RandomNumberService {

	private Random random= new SecureRandom();

	@Override
	public int generate(int min, int max) {
		return random.nextInt(max-min+1)+min;
	}

}
