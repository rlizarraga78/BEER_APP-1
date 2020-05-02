package com.example.beer_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.beer_app.R;

public class RemindersFragment extends Fragment {
    public boolean beersWaiting = false; //check if there should be a beer reminder -Devin
    public String displayText = "X";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_reminders, container, false);


    }
    public void setReminderText(boolean beersWaiting)
    {
        if(beersWaiting==false) {
            //displayText = displayText.findViewById(R.id.ReminderText);
            //doesnt work
        }

        else
        {
            //displayText = getView().findViewById(R.id.ReminderText);
            //doesnt work
        }
    }
}
