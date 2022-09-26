package com.example.kerulis_praktinis_2;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class TextCounter implements View.OnClickListener {


    static final int OUT = 0;
    static final int IN = 1;

    Spinner spinner1;
    EditText inputTextWordCounter;
    TextView textView;

    int textCount;
    boolean zodziai_Selected = true;
    String text;

    private Context context;
    public TextCounter(Context context) {
        this.context=context;
    }
    public TextCounter(EditText inputTextWordCounter, Spinner spinner1) {
        // Getting and assigning text, values

        this.inputTextWordCounter = inputTextWordCounter;
        this.spinner1 = spinner1;

    }


    static int countWords(String editTextInput, EditText inputTextWordCounter)
    {
        int state = OUT;
        int count = 0;
        int j = 0;

        while (j < inputTextWordCounter.length())
        {
            if (editTextInput.charAt(j) == ' ' || editTextInput.charAt(j) == ','
            || editTextInput.charAt(j) == '.')
            {
                state = OUT;
                j++;
                if (editTextInput.charAt(j) == ','|| editTextInput.charAt(j) == '.')
                j++;
            }
            else if (state == OUT)
            {
                count++;
                state = IN;
            }
            j++;
        }
        return count;
    }
    static int countCommas(String editTextInput, EditText inputTextWordCounter)
    {
        int count = 0;
        int j = 0;
        while (j < inputTextWordCounter.length())
        {
            if (editTextInput.charAt(j) == ' ' || editTextInput.charAt(j) == ','
                    || editTextInput.charAt(j) == '.')
            {
                count++;
                j++;
                if (editTextInput.charAt(j) == ','|| editTextInput.charAt(j) == '.') j++;
            }
            j++;
        }
        return count;
    }

    @Override
    public void onClick(View view) {
        String selectedSpinnerItem = spinner1.getSelectedItem().toString();
        String editTextInput = inputTextWordCounter.getText().toString();
        if (editTextInput.isEmpty()) {
            Toast.makeText(view.getContext(), "Input is empty!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            textCount = 0;
            char index = 0;
            String result = "";
            String testing = "";


            if (selectedSpinnerItem.equals("Zenklai")) {
                zodziai_Selected = false;
            }

            if (zodziai_Selected) {
                result += "Zodziai: ";
                textCount = countWords(editTextInput, inputTextWordCounter);
            }
            else {
                result += "Zenklai: ";
                textCount = countCommas(editTextInput, inputTextWordCounter);
            }

            Toast.makeText(view.getContext(), result + String.valueOf(textCount), Toast.LENGTH_SHORT).show();
        }


    }


}
