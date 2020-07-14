package com.example.god.ui.gallery;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.god.MainActivity;
import com.example.god.R;

import java.io.File;

public class GalleryFragment extends Fragment implements View.OnClickListener{

    private static final int RESULT_LOAD_IMAGE = 1 ;
    private static final int RESULT_OK = 1 ;
    private static final int GALLERY_KITKAT_INTENT_CALLED = 1;
    private static final int GALLERY_INTENT_CALLED = 1;
    private GalleryViewModel galleryViewModel;
    ImageView imageView;
 Button button;
    static final int GALLERY_REQUEST = 1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        button = (Button) root.findViewById(R.id.button4);
        button.setOnClickListener((View.OnClickListener) this); // присвоение кнопки листенеру


        return root;
    }
    @Override
    public void onClick(View v)
    {
        //startActivity(new Intent(getActivity(), MainActivity.class));
        //Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI); startActivityForResult(i, RESULT_LOAD_IMAGE);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_INTENT_CALLED);
        } else {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_KITKAT_INTENT_CALLED);
        }
        /*
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);*/
    }

}


