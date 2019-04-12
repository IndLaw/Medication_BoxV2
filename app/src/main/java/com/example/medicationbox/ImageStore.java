package com.example.medicationbox;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;



public class ImageStore {

    private FirebaseStorage storage;
    private StorageReference storageRef;

    public ImageStore()
    {
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference("gs://medication-box.appspot.com");
    }


    public void uploadImage(String userUID, Uri filePath)
    {
        StorageReference childRef = storageRef.child(userUID+ ".jpg");
        UploadTask uploadTask = childRef.putFile(filePath);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Log.e("image Upload: ", "Successfully uploaded" );
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("image Upload: ", "Failed to upload" );

            }
        });
    }
}
