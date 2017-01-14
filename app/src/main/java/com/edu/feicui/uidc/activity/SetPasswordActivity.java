package com.edu.feicui.uidc.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.feicui.uidc.R;
import com.edu.feicui.uidc.url.Url;

import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2016-12-26.
 */

public class SetPasswordActivity extends Activity {

    @BindView(R.id.et_oldpassword)
    EditText etOldPassword;
    @BindView(R.id.et_newpassword)
    EditText etNewPassword;
    @BindView(R.id.et_confrmpassword)
    EditText etConfrmPassword;
    @BindView(R.id.login_name)
    TextView tvName;


    private ProgressDialog progressDialog;

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvName.setText(name);

    }

    @OnClick(R.id.btn_newPassword)
    public void newPassword(){
        System.out.println("++++++++++++++++++++");
        String oldPassword = etOldPassword.getText().toString();
        String newPassword = etNewPassword.getText().toString();
        String confrmPassword = etConfrmPassword.getText().toString();

        if(oldPassword == null || oldPassword.equals("")){
            Toast.makeText(this, "原密码不能为空", Toast.LENGTH_SHORT).show();
        }
        if(newPassword == null || newPassword.equals("")){
            Toast.makeText(this, "新密码不能为空", Toast.LENGTH_SHORT).show();
        }
        if(!newPassword.equals(confrmPassword)){
            Toast.makeText(this, "新密码和确认密码不相同", Toast.LENGTH_SHORT).show();
        }

        showPreage();
        RequestBody requestBody = new FormBody.Builder()
                .add("name","login03")
                .add("opaw",oldPassword)
                .add("npaw",newPassword)
                .build();
        final Request request = new Request.Builder()
                .url(Url.LOGIN)
                .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        Toast.makeText(SetPasswordActivity.this,"网络异常",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();

                        try {
                            ResponseBody body = response.body();
                            JSONObject json = new JSONObject(body.string());
                            String rt1 = json.getString("rt");
                            String rtmsg = json.getString("rtmsg");

                            Log.e("aaa+---------------",rtmsg);
                            Log.e("aaa+---------------",rt1);
                            if("200".equals(rt1)){
                                Toast.makeText(SetPasswordActivity.this,rtmsg,Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SetPasswordActivity.this,LeadActivity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(SetPasswordActivity.this,rtmsg,Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });

            }
        });


    }

    private void showPreage(){
        progressDialog = ProgressDialog.show(this, null, "正在修改");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }

}
