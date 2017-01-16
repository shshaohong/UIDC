package com.edu.feicui.uidc.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.edu.feicui.uidc.R;
import com.edu.feicui.uidc.db.DishSQLiteHelp;
import com.edu.feicui.uidc.http.HttpManager;
import com.edu.feicui.uidc.url.Url;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;

    private boolean isfirst;
    private ProgressDialog progressDialog;
    private RequestQueue requestQueue;
    private String mName;
    private String mPassword;

    private DishSQLiteHelp help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        initSQL();
        requestQueue = Volley.newRequestQueue(this);
        SharedPreferences sf = getSharedPreferences("user_isfirst", Context.MODE_PRIVATE);
        isfirst = sf.getBoolean("isfirst",true);

        setUserToken();
    }
    private void setUserToken(){
        SharedPreferences ff = getSharedPreferences("user_token", Context.MODE_PRIVATE);
        String userName = ff.getString("username", mName);
        String userPassword = ff.getString("password", mPassword);
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setText(userName);
            etPassword.setText(userPassword);
        }

    }


    private void initSQL() {
        help = new DishSQLiteHelp(this);
        help.getWritableDatabase();
    }

    //登陆按钮
    @OnClick(R.id.btn_login)
    public void Login(){

        //判断网络是否可用
        boolean isConnect = HttpManager.isNetConnected(this);
        if(!isConnect){
            Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
            return;
        }
        //获取输入框的数据
        mName = etUsername.getText().toString();
        mPassword = etPassword.getText().toString();
        if(TextUtils.isEmpty(mName) || TextUtils.isEmpty(mPassword)){
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressBar();
        String path = Url.LOGIN+ "?category=user&name=" + mName + "&paw=" + mPassword;
        JsonObjectRequest request = new JsonObjectRequest(path,null,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject json) {
                progressDialog.dismiss();
                try {
                    String rt = json.getString("rt");
                    String rtmsg = json.getString("rtmsg");
                    System.out.println(json);

                    if("200".equals(rt)){
                        Toast.makeText(LoginActivity.this, rtmsg, Toast.LENGTH_SHORT).show();

                        SharedPreferences ss = getSharedPreferences("user_token", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor1 = ss.edit();
                        editor1.putString("username", mName);
                        editor1.putString("password", mPassword);
                        editor1.commit();

                        if(isfirst){
                            Intent intent = new Intent(LoginActivity.this,LeadActivity.class);
                            intent.putExtra("name", mName);
                            startActivity(intent);
                            finish();

                        }else {
                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        SharedPreferences sf = getSharedPreferences("user_isfirst",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sf.edit();
                        editor.putBoolean("isfirst",false);
                        editor.commit();


                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, rtmsg, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                Toast.makeText(LoginActivity.this, "服务器异常，请稍后再试", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
    private void showProgressBar(){
        progressDialog = ProgressDialog.show(this,null,"正在登录");
//        progressDialog.setProgressStyle(android.R.style.);
        progressDialog.setCancelable(true);

        progressDialog.show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }
}
