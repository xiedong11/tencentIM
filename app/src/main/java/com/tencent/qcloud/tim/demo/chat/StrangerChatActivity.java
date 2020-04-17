package com.tencent.qcloud.tim.demo.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tencent.imsdk.TIMConversationType;
import com.tencent.qcloud.tim.demo.BaseActivity;
import com.tencent.qcloud.tim.demo.DemoApplication;
import com.tencent.qcloud.tim.demo.R;
import com.tencent.qcloud.tim.demo.utils.Constants;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;

public class StrangerChatActivity extends BaseActivity {

    private EditText etUserNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stranger_chat);


        etUserNumber = ((EditText) findViewById(R.id.et_number));
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userNumber = etUserNumber.getText().toString();
                if (TextUtils.isEmpty(userNumber)){
                    Toast.makeText(StrangerChatActivity.this, "请输入对方账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                ChatInfo chatInfo = new ChatInfo();
                chatInfo.setType(TIMConversationType.C2C);
                chatInfo.setId(userNumber);
                chatInfo.setChatName("测试陌生人聊天");
                Intent intent = new Intent(DemoApplication.instance(), ChatActivity.class);
                intent.putExtra(Constants.CHAT_INFO, chatInfo);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                DemoApplication.instance().startActivity(intent);
            }
        });
    }
}
