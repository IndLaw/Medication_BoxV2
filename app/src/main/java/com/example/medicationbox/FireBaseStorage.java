package com.example.medicationbox;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;


public class FireBaseStorage {

    private FirebaseFirestore mFirestore;
    private DocumentReference docRef;

    public FireBaseStorage()
    {
        mFirestore = FirebaseFirestore.getInstance();
    }

    /********
     * Adds User object to Firestore
     * @param user
     * @param userUID
     */
   public void addUser(User user, String userUID)
   {
        mFirestore.collection("Users").document(userUID).set(user);
   }

   public User retrieveUser()
   {
       docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
           @Override
           public void onSuccess(DocumentSnapshot documentSnapshot) {
               User user = documentSnapshot.toObject(User.class);
               if (user != null) {
                   return user;
               }
               else
                   return null;
           }
       });
       return null;
   }

    /************
     *  This method adds new information about the User onto the Firebase Database. If the
     *  field name already exists, it will update the value.
     *
     * @param userUID - Document that stores user information of specific user
     * @param field - Name of category (like Address)
     * @param value - Value of the category
     */

    public void addToCollection(String userUID, String field, String value )
    {
        docRef = mFirestore.collection("Users").document(userUID);
        Map<String, Object> update = new HashMap<>();
        update.put(field, value);

        docRef.set(update, SetOptions.merge());

    }

    /*****
     * This method, like the previous, adds information to the database. It adds entire
     * hashmap full of data instead of individually, unlike the previous addToCollection.
     * @param userUID
     * @param data
     */

    public void addToCollection(String userUID, HashMap data)
    {
        docRef = mFirestore.collection("Users").document(userUID);
        docRef.set(data,SetOptions.merge());
    }

    /******
     * Updates a specific field. It is mandatory for the field to exist within the database.
     * @param userUID
     * @param field
     * @param value
     */
    public void updateDocument(String userUID, String field, String value)
    {
        docRef = mFirestore.collection("Users").document(userUID);
        docRef.update(field, value);
    }

    public void retrieveCollection(String userUID)
    {
        docRef = mFirestore.collection("Users").document(userUID);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful())
                {
                    DocumentSnapshot doc = task.getResult();
                    if (doc.exists())
                    {
                        Log.d("retrieval", "DocumentSnapshot data" + doc.getData());
                    }
                    else
                        Log.d("retrieval", "Document does not exist");
                }
                else
                    Log.d("retrieval", "Failed");
            }
        });
    }

}
