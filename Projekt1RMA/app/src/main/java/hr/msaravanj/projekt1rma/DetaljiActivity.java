package hr.msaravanj.projekt1rma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetaljiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        Intent intent = getIntent();
        Holiday holiday = (Holiday) intent.getSerializableExtra("Holiday");

        TextView localName = findViewById(R.id.localName);
        localName.setText(String.valueOf(holiday.getLocalName()));

        TextView date = findViewById(R.id.date);
        date.setText(String.valueOf(holiday.getDate()));

        Button nazad = findViewById(R.id.nazad);
        nazad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
