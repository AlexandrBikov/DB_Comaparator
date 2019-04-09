package com.example.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.db.DBManagers.ObjectBoxManager;
import com.example.db.DBManagers.RoomManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button objectBoxButton;
    private Button roomButton;
    private TextView roomTextView;
    private TextView objectBoxTextView;
    private RoomManager roomManager;
    private ObjectBoxManager objectBoxManager;
    private Button amountButton;
    private EditText amountEditText;
    private int amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDbManagers();
        initViewFields();
        setOnClickListeners();

    }

    private void initDbManagers(){
        roomManager = new RoomManager(this);
        objectBoxManager = new ObjectBoxManager(this);
    }

    private void initViewFields(){
        objectBoxButton = findViewById(R.id.objectbox_button);
        objectBoxTextView = findViewById(R.id.objectbox_text_view);

        roomButton = findViewById(R.id.room_button);
        roomTextView = findViewById(R.id.room_text_view);

        amountButton = findViewById(R.id.amount_button);
        amountEditText = findViewById(R.id.amount_edit_text);
    }

    private void setOnClickListeners(){
        roomButton.setOnClickListener(this);
        objectBoxButton.setOnClickListener(this);
        amountButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.room_button:
                roomManager.start(amount);
                setRoomTextView("working");
                break;
            case R.id.objectbox_button:
                objectBoxManager.start(amount);
                setObjectBoxTextView("working");
                break;
            case R.id.amount_button:
                amount = Integer.parseInt(amountEditText.getText().toString());
                setRoomTextView("0");
                setObjectBoxTextView("0");
                break;
        }
    }

//    private void initSpinner(){
//        ArrayAdapter<String> adapter = ArrayAdapter
//    }

    public void setRoomTextView(String time) {
        roomTextView.setText(time);
    }

    public void setObjectBoxTextView(String time) {
        objectBoxTextView.setText(time);
    }
}
