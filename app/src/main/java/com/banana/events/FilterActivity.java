package com.banana.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;

import org.greenrobot.eventbus.EventBus;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtr);
        CheckBox costBox = findViewById(R.id.checkBoxCost);
        costBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EventBus.getDefault().postSticky(new OnFilterChangedEvent(isChecked));
            }
        });
    }
    public static class OnFilterChangedEvent {
        boolean onlyFree;

        public OnFilterChangedEvent(boolean onlyFree){
            this.onlyFree = onlyFree;
        }
    }

}
