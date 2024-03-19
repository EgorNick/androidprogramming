package com.example.notetoself;
import androidx.fragment.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;



public class DialogNewNote extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // All the rest of the code goes here
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        LayoutInflater inflater =
                getActivity().getLayoutInflater();

        View dialogView =
                inflater.inflate(R.layout.dialog_new_note, null);

        final EditText editTitle = dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = dialogView.findViewById(R.id.checkBoxImportant);
        Button btnCancel =  dialogView.findViewById(R.id.btnCancel);
        Button btnOK = dialogView.findViewById(R.id.btnOK);

        builder.setView(dialogView).setMessage("Add a new note");


        btnCancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Note newNote = new Note();

                newNote.setTitle(editTitle.
                        getText().toString());

                newNote.setDescription(editDescription.
                        getText().toString());

                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.
                        isChecked());

                MainActivity callingActivity = (
                        MainActivity) getActivity();

                callingActivity.createNewNote(newNote);

                dismiss();
            }
        });

        return builder.create();



    }
}
