package com.example.beer_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TutorialFragment extends Fragment {
    int state = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tutorial_fragment, container, false);

    }
    public void InstructionStage(int state)
    {
        if(state==1)
        {
            //display brewing instructions
            state++;
        }
        else if(state ==2)
        {
            //display fermenting instructions
            state++;
        }
        else
        {
            //display bottling instructions
        }

    }



}



