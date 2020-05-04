package com.example.beer_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class BrewingTutorialFragment extends Fragment {
    TextView brewing_instructions;
    Button End;
    DatabaseReference ref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.brewing_tutorial_fragment, container, false);
        return v;

    }
    /*written by Devin*/
    public void InstructionStage(int state) {


        brewing_instructions = (TextView) getView().findViewById(R.id.brew_tutorial);
        End =(Button) getView().findViewById(R.id.FinishButton);
        End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference().child("Instructions").child("Brewing");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String step0 =dataSnapshot.child("step_0").getValue().toString();
                        brewing_instructions.setText(step0);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        //display brewing instructions

    }
}



