package com.example.administrator.toast;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
    }
    public void b1(View view){
        Toast.makeText(this,"haha,我早就会了",Toast.LENGTH_SHORT).show();
    }
    public void b2(View view){
        // 通过LayoutInflater来将toastroot,toastinfo这两个布局添加到主布局文件的LinearLayout中
        // 先获取到LayoutInflater的实例
        LayoutInflater layoutInflater = getLayoutInflater();
        // 调用inflate()方法来加载toastroot这个布局,第二个参数是指给该布局的外部再嵌套一层父布局
        View vroot = layoutInflater.inflate(R.layout.toastroot,null);
        // 获取toastroot布局中的clayout(LinearLayout)布局
        LinearLayout linearLayout = (LinearLayout) vroot.findViewById(R.id.clayout);
        // 调用inflate()方法来加载toastinfo这个布局,第二个参数是指给该布局的外部再嵌套一层父布局(clayout)
        layoutInflater.inflate(R.layout.toastinfo,linearLayout);
        // 在当前对象中创建一个土司
        Toast toast = new Toast(this);
        toast.setView(vroot);
        toast.show();
    }
    public void b3(View view){
        // 声明一个土司
        Toast toast = Toast.makeText(this,"小黄人图文显示",Toast.LENGTH_SHORT);
        // 在当前对象中声明一个线性布局
        LinearLayout linearLayout = new LinearLayout(this);
        // 设置线性布局为垂直方向
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        // 在当前对象中声明一个ImageView对象
        ImageView imageView  = new ImageView(this);
        // 引用ImageView资源文件
        imageView.setImageResource(R.drawable.yellowman);

        View toastView = toast.getView();
        linearLayout.addView(imageView);
        linearLayout.addView(toastView);

        toast.setView(linearLayout);
        toast.show();
    }

}
