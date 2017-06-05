package edu.njit.arp226.uservalidationandroidapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button bValidate;
    private EditText etName, etAge, etSales;

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
                   if (isValidName(name) && isValidAge(age) && isValidSales(sales)) {
                       AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                       alert.setMessage("Name: " + name + "\nAge: " + age + "\nSales: $" + sales);
                       alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                           }
                       });
                       alert.show();
                   }
                   etName.requestFocus();
               }
           }
        );
    }

    private boolean isValidSales(String sales) {
        // TODO add validations of Sales field
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        return true;
    }

    private boolean isValidAge(String age) {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        if (age.trim().equals("") || age.isEmpty() ) {
            alert.setMessage("Age cannot be blank.");
        } else if (Integer.parseInt(age) == 0) {
            alert.setMessage("Age cannot be 0.");
        } else if (Integer.parseInt(age) < 0) {
            alert.setMessage("Age cannot be negative.");
        } else {
            return true;
        }
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
        return false;
    }

    private boolean isValidName(String name) {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        if(name.trim().equals("") || name.isEmpty()) {
            alert.setMessage("Name is mandatory");
        } else if (name.length() == 1) {
            alert.setMessage("Name is just 1 character long!");
        } else {
            return true;
        }
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
        return false;
    }

}
