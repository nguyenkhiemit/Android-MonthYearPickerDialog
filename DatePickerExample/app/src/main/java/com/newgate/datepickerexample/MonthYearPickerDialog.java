package com.newgate.datepickerexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.util.Calendar;

public class MonthYearPickerDialog extends DialogFragment {

    private NumberPicker monthPicker;

    private NumberPicker yearPicker;

    private DatePicker datePicker;

    private LinearLayout numberPicker;

    private Button changeFilterButton;

    private static final int MAX_YEAR = 2099;

    private OnDateSetListener listener;

    public void setListener(OnDateSetListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getActivity().getLayoutInflater().inflate(R.layout.date_picker_dialog, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Calendar cal = Calendar.getInstance();

        //ngày, tháng, năm
        datePicker = (DatePicker) view.findViewById(R.id.date_picker);

        //tháng, năm
        numberPicker = (LinearLayout) view.findViewById(R.id.number_picker);
        changeFilterButton = (Button) view.findViewById(R.id.btn_change_filter);
        monthPicker = (NumberPicker) view.findViewById(R.id.picker_month);
        yearPicker = (NumberPicker) view.findViewById(R.id.picker_year);
        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        monthPicker.setValue(cal.get(Calendar.MONTH) + 1);
        int year = cal.get(Calendar.YEAR);
        yearPicker.setMinValue(year);
        yearPicker.setMaxValue(MAX_YEAR);

        //click button change 2 picker
        changeFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datePicker.getVisibility() == View.VISIBLE) {
                    datePicker.setVisibility(View.GONE);
                    numberPicker.setVisibility(View.VISIBLE);
                    changeFilterButton.setText("Lọc theo tháng");
                } else {
                    datePicker.setVisibility(View.VISIBLE);
                    numberPicker.setVisibility(View.GONE);
                    changeFilterButton.setText("Lọc theo ngày");
                }
            }
        });
    }

    public interface OnDateSetListener {
        void onDateSet(int var2, int var3);
    }
}