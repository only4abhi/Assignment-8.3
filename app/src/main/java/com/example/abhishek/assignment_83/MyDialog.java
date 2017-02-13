package com.example.abhishek.assignment_83;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MyDialog extends DialogFragment implements OnClickListener {

    Button yes , no;
    Communicator communicator;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        communicator = (Communicator) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_dialog,null);
        yes = (Button)view.findViewById(R.id.yes);
        no = (Button)view.findViewById(R.id.no);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.yes){
            communicator.onDialogMessage("Yes button is clicked");
            dismiss();
        }else{
            communicator.onDialogMessage("No button is clicked");
            dismiss();
            //Toast.makeText(getActivity(),"No Button Clicked", Toast.LENGTH_LONG).show();
        }
    }

    interface Communicator{
        public void onDialogMessage(String msg);
    }
}
