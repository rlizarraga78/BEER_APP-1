package com.example.beer_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.beer_app.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    DatabaseReference mUsernameReference;
    FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            final String uid = user.getUid();
            mUsernameReference = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
            mUsernameReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String name = (String) dataSnapshot.child("username").getValue();
                    TextView tv1 = (TextView) getView().findViewById(R.id.textView10);
                    tv1.setText(name);

                    String brewsMaking = (String) dataSnapshot.child("beersInMaking").getValue();
                    TextView tv4 = (TextView) getView().findViewById(R.id.textView21);
                    tv4.setText(brewsMaking);

                    String brewsFinished = (String) dataSnapshot.child("beersMade").getValue();
                    TextView tv5 = (TextView) getView().findViewById(R.id.textView13);
                    tv5.setText(brewsFinished);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
