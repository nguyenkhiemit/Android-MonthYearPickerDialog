package com.newgate.datepickerexample;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements MonthYearPickerDialog.OnDateSetListener {

    private Button displayDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayDialogButton = (Button)findViewById(R.id.btn_display_dialog);

        displayDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonthYearPickerDialog pd = new MonthYearPickerDialog();
                pd.setListener(MainActivity.this);
                pd.show(getSupportFragmentManager(), "MonthYearPickerDialog");
            }
        });
    }

    @Override
    public void onDateSet(int i, int i1) {

    }
}
