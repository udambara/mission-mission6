package com.example.android.ex6_fab;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Krivnon on 2016-07-15.
 */
public class EditDialog extends Dialog implements View.OnClickListener {
    EditText etinput;
    Button btnadd;
    Button btncancel;
    String inputvalue;

    public EditDialog(MainActivity mainActivity) {
        super(mainActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmldialog); //xml과 연결
        init();
    }
    void init(){
        etinput = (EditText)findViewById(R.id.et_input);
        btnadd = (Button)findViewById(R.id.add);
        btncancel = (Button)findViewById(R.id.cancel);

        btnadd.setOnClickListener(this); //각각 listener를 통해 버튼인식하도록
        btncancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add :
                String inputtext = etinput.getText().toString();
                setValue(inputtext);//text를 저장하고 사라지는데 MainActivity에서 사라짐에 따른 결과를 처리함.
                                    //이 경우에는 text가 있는 경우 이므로 메인의 value가 바뀜
                dismiss();
                etinput.setText("");
                break;

            case R.id.cancel :

                dismiss();//이 경우에는 text가 없는 경우 이므로 메인의 value가 바뀌지 않음
                etinput.setText("");
                break;
        }
    }
    public String getValue(){
        return inputvalue;
    }
    public void setValue(String value){
        inputvalue = value;
    }
}
