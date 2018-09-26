package comq.example.raymond.quadraticsolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuadraticActivity extends AppCompatActivity {
    private EditText editTextA, editTextB, editTextC;
    private Button buttonFindRoots;
    private TextView tv_result;

    double value_of_a;
    double value_of_b;
    double value_of_c;
    double discriminant;
    double root1, root2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);


        editTextB = findViewById(R.id.valueOfB);
        editTextA = findViewById(R.id.valueOfA);
        editTextC = findViewById(R.id.valueOfC);
        tv_result = findViewById(R.id.tv_result);
        buttonFindRoots = findViewById(R.id.buttonFindRoots);


        //setOnclickListener
        buttonFindRoots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextA.getText().toString().equals("") && !editTextB.getText().toString().equals("") &&
                        !editTextC.getText().toString().equals("") ){

                    value_of_a = Double.parseDouble(editTextA.getText().toString());
                    value_of_b = Double.parseDouble(editTextB.getText().toString());
                    value_of_c = Double.parseDouble(editTextC.getText().toString());

                    discriminant = Math.pow(value_of_b, 2) - 4*value_of_a*value_of_c;

                    //check the value of discriminant
                    if (discriminant == 0){
                        root1 = -value_of_b/(2*value_of_a);
                        root2 = root1;
                        tv_result.setText("Discriminant = " + discriminant +  "\nthe quadratic equation has equal roots " + "\nroot1 = " + root1 +
                                "\nroot2 = " + root2);
                    }else if (discriminant < 0 ){
                        tv_result.setText("The quadratic equation has no roots!");
                    }else if (discriminant > 0){
                        root1 = (-value_of_b + Math.sqrt(discriminant)/(2*value_of_a));
                        root2 = (-value_of_b - Math.sqrt(discriminant)/(2*value_of_a));

                        tv_result.setText("Discriminant = " + discriminant + "\nthe quadratic equation has two unequal roots  " +  "\nroot1 = "+  root1
                        + "\nroo2 = " + root2);
                    }


                }else {
                    Toast.makeText(QuadraticActivity.this, "Coefficients of X cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
