package com.example.quizzapplicationv1;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.quizzapplicationv1.helper.DatabaseHelper;
import com.example.quizzapplicationv1.R;
import com.example.quizzapplicationv1.helper.DatabaseHelper;

public class AccountFragment extends Fragment {





    EditText editName, editSurname, editTextId, editTextMnemonic;
    Button btnAddData;
    DatabaseHelper myDb;
    Button btnShowData;
    Button btnUpData;
    Button btnDelData;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_account, container, false);

        myDb = new DatabaseHelper(getActivity());

        editName = (EditText) rootView.findViewById(R.id.editText_name);
        editSurname = (EditText) rootView.findViewById(R.id.editText_surname);
        editTextMnemonic = (EditText) rootView.findViewById(R.id.editText_mnemonic);
        editTextId = (EditText) rootView.findViewById(R.id.editText_id);
        btnAddData = (Button) rootView.findViewById(R.id.btnAddData);
        btnShowData = (Button) rootView.findViewById(R.id.btnShowData);
        btnUpData = (Button) rootView.findViewById(R.id.btnUpData);
        btnDelData = (Button) rootView.findViewById(R.id.btnDelData);
        addData();
        updateData();
        deleteData();
        viewAll();

        return rootView;


    }




    public void addData(){

        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted =  myDb.insertData(editName.getText().toString(), editSurname.getText().toString(), editTextMnemonic.getText().toString());  //Récupérer la partie String des EditText

                        if(isInserted == true)
                            Toast.makeText(getActivity(), "data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "data not inserted", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }

    public void updateData(){

        btnUpData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(), editName.getText().toString(), editSurname.getText().toString(), editTextMnemonic.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(getActivity(), "data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void deleteData(){

        btnDelData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deleteRows = myDb.deleteData(editTextId.getText().toString());
                        if(deleteRows > 0)
                            Toast.makeText(getActivity(), "data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void viewAll(){
        btnShowData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor result = myDb.getAllData();
                        if(result.getCount() == 0){
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (result.moveToNext()){
                            buffer.append("id " + result.getString(0)+"\n");
                            buffer.append("Name : " + result.getString(1)+"\n");
                            buffer.append("Surname : " + result.getString(2)+"\n");
                            buffer.append("Mnemonic : " + result.getString(3)+"\n\n");

                        }

                        //SHOW ALL DATA
                        showMessage("Data", buffer.toString());
                    }

                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
