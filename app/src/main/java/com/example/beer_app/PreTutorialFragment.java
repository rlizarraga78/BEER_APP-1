package com.example.beer_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PreTutorialFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pretutorial_fragment, container, false);

        //Button goToTutorial = (Button) findViewById(R.id.toTutorialButton);
        //Intent intent = new Intent(PreTutorialFragment.this, TutorialFragment.class);
        //startActivity(intent);
        //This doesn't work inside fragments and I'm not sure what needs to be changed -Devin
    }
}
