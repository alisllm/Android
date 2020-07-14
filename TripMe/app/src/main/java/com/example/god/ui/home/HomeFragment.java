package com.example.god.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.god.CreateAkk;
import com.example.god.Createtrip;
import com.example.god.MainActivity;
import com.example.god.R;
import com.example.god.Spisok;

public class HomeFragment extends Fragment implements View.OnClickListener
{

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        rootView.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(getActivity(), Spisok.class));
                    }
                });
        rootView.findViewById(R.id.button5)
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(getActivity(), Createtrip .class));
                    }

                });
        return rootView;
    }

    @Override
    public void onClick(View v) {

    }
}

