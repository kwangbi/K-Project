package com.kwang.initialize;

import java.io.FileInputStream;
import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {

	@PostConstruct
	public void initialize() {

		try {
			
			ClassPathResource refreshToken = new ClassPathResource("/firebase\\\\kwang-f2253-firebase-adminsdk-fgnwm-7281959a3d.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(refreshToken.getInputStream()))
					  .build();			

			FirebaseApp.initializeApp(options);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
