package mydemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hp0331.mydemo.R;

import mydemo.bluetooth.BluetoothChat;
import mydemo.finger.FingertestActivity;
import mydemo.flowlayout.FlowlayoutActivity;
import mydemo.guaguaka.GuaGuaKaActivity;
import mydemo.language.MultiLanguageActivity;

import mydemo.sideslip.CoordinatorActivity;
import mydemo.wuziqi.WuZiQiActivity;


/**
 * Created by hp0331 on 2016/12/8.
 */

public class WelcomeActivity extends Activity {
    private ListView mListview;
    private MyAdapter adapter;
    private String[] demolist=new String[]{"ËøÆÁ","Îå×ÓÆå","¹Î¹Î¿¨","Á÷Ê½²¼¾Ö","Í¼Æ¬ÇÐ»»","À¶ÑÀÁÄÌì","ÓïÑÔÇÐ»»","Ö¸ÎÆ½âËø","QQ²à»¬",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mListview=(ListView)findViewById(R.id.lv_list);
        adapter=new MyAdapter(this,demolist);
        mListview.setAdapter(adapter);
       mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position){
                   case 0:
                       startActivity(new Intent(WelcomeActivity.this, LockActivity.class));
                       break;
                   case 1:
                       startActivity(new Intent(WelcomeActivity.this,WuZiQiActivity.class));
                       break;
                   case 2:
                       startActivity(new Intent(WelcomeActivity.this,GuaGuaKaActivity.class));
                       break;
                   case 3:
                       startActivity(new Intent(WelcomeActivity.this,FlowlayoutActivity.class));
                       break;
                   case 4:

                       break;
                   case 5:
                       startActivity(new Intent(WelcomeActivity.this,BluetoothChat.class));
                       break;
                   case 6:
                       startActivity(new Intent(WelcomeActivity.this,MultiLanguageActivity.class));
                       break;
                   case 7:
                       startActivity(new Intent(WelcomeActivity.this, FingertestActivity.class));
                       break;
                   case 8:
                       startActivity(new Intent(WelcomeActivity.this, CoordinatorActivity.class));
               }
           }
       });
    }

    public class MyAdapter extends BaseAdapter {
        private String[] data;
        private Context mContext;
        private LayoutInflater inflater;

        public MyAdapter(Context mContext, String[] data) {
            this.mContext = mContext;
            this.data = data;
            inflater= LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
                viewHolder=new ViewHolder();
                convertView=inflater.inflate(R.layout.item_welconelist,null);
                viewHolder.tv_demoname=(TextView)convertView.findViewById(R.id.tv_demoname);

                convertView.setTag(viewHolder);
            }else {
                viewHolder=(ViewHolder) convertView.getTag();
            }
            viewHolder.tv_demoname.setText(data[position]);

            return convertView;
        }
    }
    class ViewHolder{
        private TextView tv_demoname;
    }
}
