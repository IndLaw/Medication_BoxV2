package com.example.medicationbox;

import java.util.*;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;


public class FireBaseStorage {

    private FirebaseFirestore mFirestore;
    private DocumentReference docRef;

    public FireBaseStorage()
    {
        mFirestore = FirebaseFirestore.getInstance();
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
    public void updateDocument(String userUID, String field, String value )
    {
        docRef = mFirestore.collection("Users").document(userUID);
        docRef.update(field, value);
    }

}
