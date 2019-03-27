Add this to activities that will be using Firestore. User needs to be authenticated before storing data into the database. 
This method checks if user is signed in. 

FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            // User is signed in
            Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
        } else {
            // User is signed out
            Log.d(TAG, "onAuthStateChanged:signed_out");
        }
        // ...
    }
});

Or you can use this if the user is already signed in:

FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
