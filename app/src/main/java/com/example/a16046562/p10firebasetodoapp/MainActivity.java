package com.example.a16046562.p10firebasetodoapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    // Declare variable
    private TextView tvitemdate, tvitemtitle,tvitemdays, tvitemcompleted;
    private EditText etitemdate, etitemtitle, etitemnumofdays;
    private Button btnadditem;
    private CheckBox cbcompleted;

    // TODO: Task 1 - Declare Firebase variables
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference itemPOJOReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvitemtitle = (TextView) findViewById(R.id.textViewItemTitle);
        tvitemdate = (TextView) findViewById(R.id.textViewItemDate);
        tvitemdays = (TextView) findViewById(R.id.textViewItemNumOfDays);
        tvitemcompleted = (TextView) findViewById(R.id.textViewItemCompleted);

        etitemtitle = (EditText) findViewById(R.id.editTextItemTitle);
        etitemdate = (EditText) findViewById(R.id.editTextItemDate);
        etitemnumofdays = (EditText) findViewById(R.id.editTextItemNumOfDays);

        btnadditem = (Button) findViewById(R.id.buttonAdd);
        cbcompleted = (CheckBox) findViewById(R.id.checkBoxItemCompleted);

        // TODO: Task 2 - Get Firebase database instance and reference
        firebaseDatabase = FirebaseDatabase.getInstance();
        itemPOJOReference = firebaseDatabase.getReference("messagePOJO");

        // TODO: Task 3 - Add a value event listener to the "message" node
        itemPOJOReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Item message = dataSnapshot.getValue(Item.class);
                if (message != null) {
                    //tvMessageText.setText(message.getText());
                    tvitemtitle.setText("Title: " + message.getTitle());
                    tvitemdate.setText("Date: " + message.getDate());
                    tvitemdays.setText("NumOfDays: " + message.getNumOfDays());
                    tvitemcompleted.setText("Completed? " + message.getCompleted());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "Database error occurred", databaseError.toException());
            }
        });

        // TODO: Task 5 - Update UI elements, and then include OnClickListener for Send Message button
        btnadditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Note: We're not directly updating the text view, but calling setValue() to update the data in the database instead
                int num = Integer.parseInt(etitemnumofdays.getText().toString());
                Item message = new Item(cbcompleted.isChecked(), etitemdate.getText().toString(),num,etitemtitle.getText().toString());
                itemPOJOReference.setValue(message);
            }
        });
    }
}
