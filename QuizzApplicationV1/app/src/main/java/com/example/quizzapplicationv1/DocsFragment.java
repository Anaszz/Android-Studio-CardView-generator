package com.example.quizzapplicationv1;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapplicationv1.adapter.docsFragmentAdapter;
import com.example.quizzapplicationv1.helper.DatabaseHelper;
import com.example.quizzapplicationv1.models.DocsItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class DocsFragment extends Fragment {


    private DatabaseHelper mDatabase;
    private ArrayList<DocsItems> allContacts=new ArrayList<>();
    private docsFragmentAdapter mAdapter;
    Dialog myDialog;
    CustomPopup customPopup;
    private DrawerLayout drawer;
    FloatingActionButton actionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_docs, container, false);

        myDialog = new Dialog(getActivity());
        final FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.floating_action_button);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        ShowPopup(floatingActionButton);
                                                    }
                                                }

        );

        FrameLayout fLayout = (FrameLayout) rootView.findViewById(R.id.activity_to_do);

        RecyclerView contactView = (RecyclerView) rootView.findViewById(R.id.product_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        contactView.setLayoutManager(linearLayoutManager);
        contactView.setHasFixedSize(true);
        mDatabase = new DatabaseHelper(getActivity());
        allContacts = mDatabase.listContacts();

        if(allContacts.size() > 0){
            contactView.setVisibility(View.VISIBLE);
            mAdapter = new docsFragmentAdapter(getActivity(), allContacts);
            contactView.setAdapter(mAdapter);

        }else {
            contactView.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }

        return rootView;
    }

    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.activity_custompopup);
        txtclose =(TextView) myDialog.findViewById(R.id.quitIcon);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

}