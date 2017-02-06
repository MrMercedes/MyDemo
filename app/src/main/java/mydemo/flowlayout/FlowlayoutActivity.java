package mydemo.flowlayout;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.hp0331.mydemo.R;

import java.util.Random;

/**
 * Created by hp0331 on 2016/12/8.
 */

public class FlowlayoutActivity extends Activity {
    /**
     * ��ʾ������
     */
    private String[] mDatas = new String[]{
            "QQ",
            "��Ƶ",
            "�ſ�������",
            "������",
            "�Ƶ�",
            "����",
            "С˵",
            "������",
            "�ſ�",
            "����",
            "WIFI����Կ��",
            "������",
            "�������2",
            "��Ʊ",
            "��Ϸ",
            "�ܳ�û֮�ܴ����",
            "��ͼ����",
            "�����",
            "������Ϸ",
            "�ҵ�����",
            "��Ӱ����",
            "QQ�ռ�",
            "����",
            "�����Ϸ",
            "2048",
            "��������",
            "��ֽ",
            "�����ʦ",
            "����",
            "װ���ر�",
            "�޵�",
            "���춯��",
            "����",
            "����",
            "������",
            "���ڵ���",
            "��������Ƶ",
            "��Ѷ�ֻ��ܼ�",
            "�ٶȵ�ͼ",
            "�Ա������ʦ",
            "�ȸ��ͼ",
            "hao123��������",
            "����",
            "����",
            "������-ũ������",
            "֧����Ǯ��"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        Random random = new Random();

        // ѭ�����TextView������
        for (int i = 0; i < mDatas.length; i++) {
            final TextView view = new TextView(this);
            view.setText(mDatas[i]);
            view.setTextColor(Color.WHITE);
            view.setPadding(5, 5, 5, 5);
            view.setGravity(Gravity.CENTER);
            view.setTextSize(14);

            // ���õ���¼�
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (view.getText().toString().equals("�޵�")){
                        Toast.makeText(FlowlayoutActivity.this,"���ҵ�����", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(FlowlayoutActivity.this, view.getText().toString(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

            // ���ò�ɫ����
            GradientDrawable normalDrawable = new GradientDrawable();
            normalDrawable.setShape(GradientDrawable.RECTANGLE);
            int a = 255;
            int r = 50 + random.nextInt(150);
            int g = 50 + random.nextInt(150);
            int b = 50 + random.nextInt(150);
            normalDrawable.setColor(Color.argb(a, r, g, b));

            // ���ð��µĻ�ɫ����
            GradientDrawable pressedDrawable = new GradientDrawable();
            pressedDrawable.setShape(GradientDrawable.RECTANGLE);
            pressedDrawable.setColor(Color.GRAY);

            // ����ѡ����
            StateListDrawable stateDrawable = new StateListDrawable();
            stateDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
            stateDrawable.addState(new int[]{}, normalDrawable);

            // ���ñ���ѡ������TextView��
            view.setBackground(stateDrawable);

            flowLayout.addView(view);
        }
    }
}
