package com.example.quizzapplicationv1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapplicationv1.R;
import com.example.quizzapplicationv1.helper.DatabaseHelper;
import com.example.quizzapplicationv1.models.DocsItems;
import com.example.quizzapplicationv1.models.RecyclerViewHolder;

import java.util.ArrayList;

public class docsFragmentAdapter extends RecyclerView.Adapter<RecyclerViewHolder> implements Filterable {

    private Context context;
    private ArrayList<DocsItems> listContacts;
    private ArrayList<DocsItems> mArrayList;

    private DatabaseHelper mDatabase;

    public docsFragmentAdapter(Context context, ArrayList<DocsItems> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        this.mArrayList=listContacts;
        mDatabase = new DatabaseHelper(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_itemrow, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final DocsItems docsItems = listContacts.get(position);

        String ressourceName = docsItems.getName();
        int resId = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());

        holder.name.setImageResource(resId);
        holder.surname.setText(docsItems.getSurname());
        holder.ph_no.setText(docsItems.getPhno());
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    listContacts = mArrayList;
                } else {

                    ArrayList<DocsItems> filteredList = new ArrayList<>();

                    for (DocsItems contacts : mArrayList) {

                        if (contacts.getName().toLowerCase().contains(charString)) {

                            filteredList.add(contacts);
                        }
                    }

                    listContacts = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listContacts;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listContacts = (ArrayList<DocsItems>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    @Override
    public int getItemCount() {
        return listContacts.size();
    }


}
