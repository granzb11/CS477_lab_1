package com.example.gustavoranz.lab_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    private int base;
    private String binaryNum, octalNum, decimalNum, hexNum;
    private String inputString;
    private int inputNum = 2;
    private EditText inputText;
    private TextView binaryView, octalView, decimalView, hexView;
    private Button cancelButton;
    private Button convertButton;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //creating the EditText object so that I can change the keyboard layout depending on which radioButton the user chooses
        inputText = (EditText) findViewById(R.id.editText_input);

        //creating the RadioGroup object so that I can then creater a listener for the specific radioButton group
        rg = (RadioGroup) findViewById(R.id.radioGroup);

        //RadioGroup event listener to see which of the radio buttons is checked
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //Actual function which checks which radioButton is checked
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    //if binary button is chosen, base is 2 and the keyboard layout is of type number
                    case R.id.radioButton_binary:
                        base = 2;
                        inputText.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;

                    case R.id.radioButton_octal:
                        base = 8;
                        inputText.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;

                    case R.id.radioButton_decimal:
                        base = 10;
                        inputText.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;

                    case R.id.radioButton_hex:
                        base = 16;
                        inputText.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                }//end of switch
            }//end of onCheckedChanged
        });//end of radiogroup event listener


        //creating the button objects for when the user clicks on the cancel or convert buttons
        cancelButton = (Button) findViewById(R.id.button_cancel);
        convertButton = (Button) findViewById(R.id.button_convert);

        //Event Listener for the Convert Button which does all of the conversions
        convertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                // Getting the string that the user types in to be converted
                inputString = inputText.getText().toString();

                //Try catch for illegal numbers depending on base picked
                //NumberFormatException is very smart, it knows what to catch depending on the base
                try {
                    inputNum = Integer.parseInt(inputString, base); //Converting the original number to decimal
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Illegal Number (" + inputString + ") for base " + base, Toast.LENGTH_SHORT).show();
                }

                /*This is where all of the conversions happen */
                binaryNum = Integer.toBinaryString(inputNum);
                octalNum = Integer.toOctalString(inputNum);
                hexNum = Integer.toHexString(inputNum);
                decimalNum = Integer.toString(inputNum);

                /*Linking textView variables with the right textViews from the layout*/
                binaryView = (TextView) findViewById(R.id.textView_binaryOutput);
                octalView = (TextView) findViewById(R.id.textView_octalOutput);
                decimalView = (TextView) findViewById(R.id.textView_decimalOutput);
                hexView = (TextView) findViewById(R.id.textView_hexOutput);

                /*Assigning the correct output strings to the textViews*/
                binaryView.setText(binaryNum);
                octalView.setText(octalNum);
                decimalView.setText(decimalNum);
                hexView.setText(hexNum);

            }//end of onClick method
        });//end of convert button event listener

        //Event Listener for the Cancel Button which closes down app
        cancelButton.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
