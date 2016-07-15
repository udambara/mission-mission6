package com.example.android.ex6_fab;

import android.content.DialogInterface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnDismissListener {

    TextView tvoutput; //보여줄 텍스트
    FloatingActionButton fab;//floating ActionButton 선언

    private EditDialog editDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){

        tvoutput = (TextView)findViewById(R.id.tv_output);
        fab=(FloatingActionButton)findViewById(R.id.xmlfab);
        fab.setOnClickListener(this); //fab에 클릭 리스터 달아놓기
        editDialog = new EditDialog(this);
        editDialog.setOnDismissListener(this); //dialog의 disiss 리스너 달아놓기
                                                // 입력이 끝난후 리턴값 받기
        editDialog.setTitle("Add new String");
    }



    @Override
    public void onClick(View view) {

        editDialog.show(); //fab를 눌렀을때 dialog띄우기
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        String input = editDialog.getValue(); //dialog가 끝나면 dialog에서 입력된 값을 받아온다.
        if(input != "" && input != null) //받아온 값이 null값이 아닌 경우에만 바꾸기
            tvoutput.setText(input);            //받아온 값으로 텍스트 바꾸기
    }
}
