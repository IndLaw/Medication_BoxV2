package com.example.medicationbox;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;


public class FireBaseStorage {

    private FirebaseFirestore mFirestore;
    private DocumentReference docRef;
    private User user = null;

    FireBaseStorage()
    {
        mFirestore = FirebaseFirestore.getInstance();
    }

    /********
     * Adds User object to Firestore
     * @param user - User object
     * @param userUID - userUID to navigate Firestore files
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
               if (documentSnapshot.exists()) {
                  user = documentSnapshot.toObject(User.class);
               }
           }
       });
       return user;
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
     * @param userUID - To navigate Firestore files
     * @param data - Data you want to add, in the form of a Hashmap
     */

    public void addMapToCollection(String userUID, Map data)
    {
        docRef = mFirestore.collection("Users").document(userUID);
        docRef.set(data,SetOptions.merge());
    }

    /******
     * Updates a specific field. It is mandatory for the field to exist within the database.
     * @param userUID - Used to find file in Firestore
     * @param field - field in you want to change
     * @param value - value of the field you want to change
     */
    public void updateDocument(String userUID, String field, String value)
    {
        docRef = mFirestore.collection("Users").document(userUID);
        docRef.update(field, value);
    }

    /****
     *  This method searches through the Firestore files for the specific document you are looking
     *  for and returns it.
     * @param userUID - Navigate Firebase files
     */
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
