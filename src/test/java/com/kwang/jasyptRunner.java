package com.kwang;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class jasyptRunner {

	@Test
	void contextLoads() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword("yangkwangmo"); //2번 설정의 암호화 키를 입력
		
		String enc = pbeEnc.encrypt("rkskek1"); //암호화 할 내용
		System.out.println("enc = " + enc); //암호화 한 내용을 출력
		
		//테스트용 복호화
		String des = pbeEnc.decrypt(enc);
		System.out.println("des = " + des);		
	}

}
