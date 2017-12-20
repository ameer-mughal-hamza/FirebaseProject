package com.firebase.ameerhamza.firebaseproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordResetDialog extends DialogFragment {
    private static final String TAG = "PasswordResetDialog";

    //widgets
    private EditText mConfirmEmail;

    //vars
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.password_reset_dialog, container, false);
        mConfirmEmail = view.findViewById(R.id.confirm_email);
        mContext = getActivity();


        TextView confirmDialog = (TextView) view.findViewById(R.id.dialogConfirm);
        confirmDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: attempting to send password reset email.");
               if(!isEmpty(mConfirmEmail.getText().toString())){
                    resetPasswordEmail(mConfirmEmail.getText().toString());
                }else{
                    Toast.makeText(mContext, "Field must be filled out", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Cancel button for closing the dialog
        TextView cancelDialog = (TextView) view.findViewById(R.id.dialogCancel);
        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    private void resetPasswordEmail(String email)
    {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(mContext,"Password reset link is sent",Toast.LENGTH_SHORT).show();
                            getDialog().dismiss();
                        }
                        else
                        {
                            Toast.makeText(mContext,"Unable to send Password reset link",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    /**
     * Return true if the @param is null
     * @param string
     * @return
     */
    private boolean isEmpty(String string){
        return string.equals("");
    }
}
