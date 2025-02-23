package com.example.springfirebase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.annotations.Nullable;
import org.apache.commons.logging.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


@Service
public class FireBaseService {

    @org.springframework.context.event.EventListener(ApplicationReadyEvent.class)
    public void get() throws ExecutionException, InterruptedException, IOException {

        FileInputStream serviceAccount =
                new FileInputStream("E:\\SynologyDrive\\Dokumenty\\BootCamp\\projekty\\Spring Boot2 Course\\SpringFirebase\\src\\main\\resources\\java-c3d78-firebase-adminsdk-fbsvc-ec7dc12fd1.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("firebase-adminsdk-fbsvc@java-c3d78.iam.gserviceaccount.com")
                .build();

        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
        // Read data

        final DocumentReference docRef = db.collection("cities").document("LA");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirestoreException e) {


                if (e != null) {
                    System.out.println("Listen failed: " + e);
                    return;
                }

                if (documentSnapshot != null && documentSnapshot.exists()) {
                    System.out.println("Current data: " + documentSnapshot.getData());
                } else {
                    System.out.println("Current data: null");
                }
            }
        });
    }
}
