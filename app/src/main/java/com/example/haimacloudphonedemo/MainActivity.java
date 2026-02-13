package com.example.haimacloudphonedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.haima.hmcp.widgets.*;
import com.haima.hmcp.listeners.*;
import com.haima.hmcp.enums.*;
import com.haima.hmcp.beans.*;
import com.haima.hmcp.utils.*;

public class MainActivity extends AppCompatActivity implements HmcpPlayerListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private CloudPhoneVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取组件
        videoView = (CloudPhoneVideoView) this.findViewById(R.id.gameView);

        //云手机参数
        final String accessKeyId = "488f45e2556";
        final String accessKey = "9c5b34666637896730eb6457f24fcabc";
        final String packageName = "com.haima.cloudphone.phone";
        final String phoneId = "165933107";
        String raw = accessKeyId + packageName + phoneId;
        final String token = CryptoUtils.generateCToken(raw, accessKey);

        //启动云手机
        UserInfo userInfo = new UserInfo();
        userInfo.userId = "HMTester";
        userInfo.userToken = "HMTesterToken";
        videoView.setUserInfo(userInfo);

        Bundle bundle = new Bundle();
        bundle.putString(CloudPhoneVideoView.PHONE_ID, phoneId);
        bundle.putString(CloudPhoneVideoView.ACCESS_KEY_ID, accessKeyId);
        bundle.putString(HmcpVideoView.EXTRA_ID, "cloudPhoneDemo");
        bundle.putSerializable(CloudPhoneVideoView.SCREEN_ORITENTION, ScreenOrientation.PORTRAIT);
        bundle.putString(CloudPhoneVideoView.TOKEN, token);

        Log.e(TAG, "connect started.");

        videoView.connect(getApplicationContext(), bundle, new OnInitCallBackListener() {
            @Override
            public void success()
            {
                Log.d(TAG, "connect InitCallback success");
            }

            @Override
            public void fail(String msg)
            {
                Log.e(TAG, "connect InitCallback fail: " + msg);
            }
        });
    }

    //Activity需要implements HmcpPlayerListener接口
    @Override
    public void onError(ErrorType errorType, String s) { // 出错信息回调
    }

    @Override
    public void onSuccess() { // SDK启动成功并且开始播流的回调
    }

    @Override
    public void onExitQueue() {
        this.finish(); // 内部弹窗退出回调
    }

    @Override
    public void onMessage(Message message) { // 收到退出登录消息回调
    }

    @Override
    public void onSceneChanged(String s) { // 收到场景切换的回调
    }

    @Override
    public void onNetworkChanged(NetWorkState state) { // ⽹络发⽣变化时的回调。
    }

    @Override
    public void onPlayerError(String errorCode, String errorMsg) {
    }

    @Override
    public void onPlayStatus(int status, long value, String data) {
    }

    @Override
    public void HmcpPlayerStatusCallback(String callback) {
    }

    @Override
    public void onInputMessage(String msg) {
    }

    //Activity部分方法的重写
    @Override
    protected void onResume()
    {
        super.onResume();
        videoView.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        videoView.onPause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (videoView != null) {
            videoView.disconnect();
        }
    }
}
