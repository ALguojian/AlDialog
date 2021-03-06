package com.alguojian.example;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alguojian.aldialog.adapter.ShareAdapter;
import com.alguojian.aldialog.dialog.FailDialog;
import com.alguojian.aldialog.dialog.InfoDialog;
import com.alguojian.aldialog.dialog.LoadingDialog;
import com.alguojian.aldialog.dialog.ShareDialog;
import com.alguojian.aldialog.dialog.ShowDialog;
import com.alguojian.aldialog.dialog.SuccessDialog;
import com.alguojian.aldialog.dialog.TakePhotoDialog;
import com.alguojian.aldialog.dialog.UpDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button button1;
    protected Button button2;
    protected Button button3;
    protected Button button4;
    protected Button button5;
    protected Button button6;
    protected Button button7;
    protected Button button8;
    protected Button button10;
    protected Button button11;
    protected Button button9;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        initView();
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(MainActivity.this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(MainActivity.this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(MainActivity.this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(MainActivity.this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(MainActivity.this);
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(MainActivity.this);
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(MainActivity.this);
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(MainActivity.this);
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(MainActivity.this);
        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(MainActivity.this);
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {

            new ShowDialog(this)
                    .setMessage("快快来快快来访问我吧快快来访问我吧快快来访问我吧访问我吧", Color.BLACK)
                    .setTitle("提示", Color.parseColor("#57caa1"))
                    .setYesColor("确定", Color.parseColor("#57caa1"))
                    .setCancleColor("取消", Color.parseColor("#555555"))
                    .setYesOnclickListener(new ShowDialog.onYesOnclickListener() {
                        @Override
                        public void onYesClick() {

                            toast("点击确定了哦");
                        }
                    })
                    .setNoOnclickListener(new ShowDialog.onNoOnclickListener() {
                        @Override
                        public void onNoClick() {
                            toast("点击取消了哦");
                        }
                    })
                    .show();

        } else if (view.getId() == R.id.button2) {

            new ShareDialog(MainActivity.this)

                    .setOnListItemClick(new ShareDialog.OnListItemClick() {
                        @Override
                        public void onListItemClick(int position) {

                            switch (position) {

                                case ShareAdapter.ZERO:
                                    toast("微信分享");
                                    break;

                                case ShareAdapter.ONE:
                                    toast("QQ分享");
                                    break;
                                default:
                                    break;
                            }
                        }
                    }).show();

        } else if (view.getId() == R.id.button3) {

            new LoadingDialog(this, 1).show();

        } else if (view.getId() == R.id.button4) {

            new UpDialog(this)
                    .show();

        } else if (view.getId() == R.id.button5) {

            new LoadingDialog(this, 2).show();

        } else if (view.getId() == R.id.button6) {

            new SuccessDialog(this, "提交成功").show();

        } else if (view.getId() == R.id.button7) {

            new InfoDialog(this, "提交失败").show();
        } else if (view.getId() == R.id.button8) {

            new FailDialog(this, "提交中...").show();

        } else if (view.getId() == R.id.button10) {

            new LoadingDialog(this, 1
                    , true).show();

        } else if (view.getId() == R.id.button11) {

            new LoadingDialog(this, 2
                    , true).show();
        } else if (view.getId() == R.id.button9) {

            TakePhotoDialog takePhotoDialog = new TakePhotoDialog(this)
                    .setOnTakePhotoListener(new TakePhotoDialog.TakePhoto() {
                        @Override
                        public void takePhoto() {
                            System.out.println("------点击拍照");
                        }

                        @Override
                        public void searchPhoto() {
                            System.out.println("-------d打开相册");
                        }
                    });
            takePhotoDialog.show();

        }
    }

    public void toast(String string) {

        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}

