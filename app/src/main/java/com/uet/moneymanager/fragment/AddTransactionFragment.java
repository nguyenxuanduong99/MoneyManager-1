package com.uet.moneymanager.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.uet.moneymanager.R;
import com.uet.moneymanager.database.DatabaseAccess;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Date;

public class AddTransactionFragment extends Fragment implements View.OnClickListener{

    TextView tvDatePickerValue, tvSaveTransaction, tvSelectedGroup;
    ImageView imgTransactionGroupIcon;
    EditText etAmountOfMoney, etTransactionNote;
    DatePickerDialog datePickerDialog;
    DatabaseAccess databaseAccess;
    Date selectedDate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_transaction, container, false);

        tvDatePickerValue = view.findViewById(R.id.tvDatePickerValue);
        tvSaveTransaction = view.findViewById(R.id.tvSaveTransaction);
        tvSelectedGroup = view.findViewById(R.id.tvSelectedGroup);
        imgTransactionGroupIcon = view.findViewById(R.id.imgTransactionGroupIcon);
        etAmountOfMoney = view.findViewById(R.id.etAmountOfMoney);
        etTransactionNote = view.findViewById(R.id.etTransactionNote);


        init();

        return view;
    }

    private void init() {
        databaseAccess = new DatabaseAccess(getActivity());
        etAmountOfMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etAmountOfMoney.removeTextChangedListener(this);
                try {
                    String givenString = editable.toString();
                    Long longAmount;
                    if (givenString.contains(",")){
                        givenString = givenString.replaceAll(",","");
                    }
                    longAmount = Long.parseLong(givenString);
                    DecimalFormat formattedDecimal = new DecimalFormat("#,###,###");
                    String formattedString = formattedDecimal.format(longAmount);
                    etAmountOfMoney.setText(formattedString);
                    etAmountOfMoney.setSelection(etAmountOfMoney.getText().length());
                } catch (Exception e){
                    e.printStackTrace();
                }
                etAmountOfMoney.addTextChangedListener(this);
            }
        });
        tvSaveTransaction.setOnClickListener(this);
        tvSelectedGroup.setOnClickListener(this);
    }

    private void addEvents() {
        tvDatePickerValue.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        Intent returnIntent = new Intent();
        switch (view.getId()){
            case  R.id.btnCancel:

        }
    }
}
