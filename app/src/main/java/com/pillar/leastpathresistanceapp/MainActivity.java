package com.pillar.leastpathresistanceapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText rowEditTxt;
    private EditText colEditTxt;
    private EditText gridEditTxt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowEditTxt = (EditText) findViewById(R.id.rowEditTxt);
        colEditTxt = (EditText) findViewById(R.id.ColumnEditTxt);
        gridEditTxt = (EditText) findViewById(R.id.gridEditTxt);
        submitBtn = (Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getInput();
            }
        });
    }

    private void getInput() {
        LeastPathResistance leastPathResistance = new LeastPathResistance();

        String noOfRows = rowEditTxt.getText().toString();
        String noOfCols = colEditTxt.getText().toString();
        String gridData = gridEditTxt.getText().toString();

        if (!noOfRows.isEmpty() && !noOfCols.isEmpty() && !gridData.isEmpty()) {
            String result = leastPathResistance.printleastResistancePath(gridEditTxt.getText().toString(),
                    Integer.parseInt(noOfRows),
                    Integer.parseInt(noOfCols));
            showResultAlert(result);
        }
        else{
            showResultAlert("All inputs are mandatory!!");
        }
    }

    public void showResultAlert(String result) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("Result");

        // Setting Dialog Message
        alertDialog.setMessage(result);

        // On pressing Settings button
        alertDialog.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                rowEditTxt.setText("");
                colEditTxt.setText("");
                gridEditTxt.setText("");
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}
