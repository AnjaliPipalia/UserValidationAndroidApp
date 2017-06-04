package edu.njit.arp226.uservalidationandroidapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private static Button bValidate;
    private static EditText etName;
    private static EditText etAge;
    private static EditText etSales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bValidate = (Button)findViewById(R.id.bValidate);
         etName = (EditText)findViewById(R.id.etName);
         etAge =  (EditText)findViewById(R.id.etAge);
         etSales = (EditText)findViewById(R.id.etSales);
        bValidate.setOnClickListener( new View.OnClickListener(){
                                           public void onClick(View v)
                                           {

                                               String name = etName.getText().toString();
                                               String age = etAge.getText().toString();
                                               String sales = etSales.getText().toString();
                                               AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                               if(name.equals(""))
                                               {
                                                   alert.setMessage("Name field is mandatory");
                                                   alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                       public void onClick(DialogInterface dialog, int which) {
                                                           dialog.dismiss();


                                                       }
                                                   });
                                                   alert.show();
                                                   etName.requestFocus();

                                               } else if (age.equals("")) {
                                                   alert.setMessage("Age field is mandatory & Age cannot be zero");
                                                   alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                       public void onClick(DialogInterface dialog, int which) {
                                                           dialog.dismiss();
                                                       }
                                                   });
                                                   alert.show();
                                                   etAge.requestFocus();
                                               }
                                               else if(sales.equals("")){
                                                   alert.setMessage("Sales field is mandatory");
                                                   alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                       public void onClick(DialogInterface dialog, int which) {
                                                           dialog.dismiss();
                                                       }
                                                   });
                                                   alert.show();
                                                  etSales.requestFocus();
                                               }
                                               else {

                                                   alert.setMessage("Name: " + name + "\nAge: " + age + "\nSales: $" + sales);
                                                   alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                       public void onClick(DialogInterface dialog, int which) {
                                                           dialog.dismiss();
                                                       }
                                                   });
                                                   alert.show();
                                                   etName.requestFocus();
                                               }

                                           }

                                       }

        );
    }

}
