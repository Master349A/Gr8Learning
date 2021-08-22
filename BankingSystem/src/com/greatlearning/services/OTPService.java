package com.greatlearning.services;

public class OTPService {
	public int generateOTP() {
		int otp = (int)(Math.random() * 9000) + 1000;
		return otp;
	}
}
