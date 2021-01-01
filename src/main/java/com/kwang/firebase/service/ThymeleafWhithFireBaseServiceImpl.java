package com.kwang.firebase.service;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.kwang.firebase.vo.Member;

@Service
public class ThymeleafWhithFireBaseServiceImpl implements ThymeleafWhithFireBaseService {

	public static final String COLLECTION_NAME = "member";
	
	/*
	 * cloud firestore 
	 */
	
    @Override
    public Member getMemberDetail(String id) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
           ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
           DocumentSnapshot documentSnapshot = apiFuture.get();
           Member member = null;
           if(documentSnapshot.exists()) {
                   member = documentSnapshot.toObject(Member.class);
                   return member;
           } else {
                   return null;
           }
    }
}
