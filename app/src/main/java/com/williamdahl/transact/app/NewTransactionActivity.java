package com.williamdahl.transact.app;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.Calendar;

/**
 * An activity representing a list of TransactionAttributes.
 */
public class NewTransactionActivity extends FragmentActivity
        implements NewTransactionFragment.Callbacks {


    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_new);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }
    @Override
    public void onItemSelected(String id) {


        if(id == "1"){
            // Date

            // Show as dialog
            /*
            DialogFragment picker = new DatePickerFragment();
            picker.show(getFragmentManager(), "datePicker");
            */

            //add to view hierarchy
            /*
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            DialogFragment picker = DatePickerFragment.newInstance();
            ft.add(R.id.embedded, picker);

            ft.commit();
            */
            showDialog(4,4);

        } else if(id == "2"){
            // Category
            showDialog(4,3);

        } else if(id == "3"){
            // Other
            showDialog(4,2);

        }

        //populateListView
    }
    void showDialog(int style, int theme) {
        //mStackLevel++;

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        android.app.Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = MyDialogFragment.newInstance(style,theme);
        newFragment.show(ft, "dialog");
    }
}
