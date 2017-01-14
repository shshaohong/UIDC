package com.edu.feicui.uidc.utils;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017-1-9.
 */

public abstract class UICallback implements Callback {

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onUIFailure(call, e);
            }
        });

    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        handler.post(new Runnable() {
            @Override
            public void run() {
                    onUIResponse(call, response);
            }
        });
    }
    public abstract void onUIFailure(Call call, IOException e);

    public abstract void onUIResponse(Call call, Response response);

}
