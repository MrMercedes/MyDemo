package mydemo.wuziqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp0331.mydemo.R;


/**
 * Created by hp0331 on 2016/12/8.
 */

public class WuZiQiActivity extends Activity {
    private TextView tv_wuziqi;
    private WuZiQi wuziqi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuziqi);
        wuziqi=(WuZiQi)findViewById(R.id.view_wuziqi);
        tv_wuziqi=(TextView)findViewById(R.id.wuziqi_text);
        wuziqi.setTextView(tv_wuziqi);
    }
}
