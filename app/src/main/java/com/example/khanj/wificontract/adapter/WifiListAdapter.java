package com.example.khanj.wificontract.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.khanj.wificontract.R;
import com.example.khanj.wificontract.model.WifiListModel;

import java.util.ArrayList;


public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.ItemViewHolder> {



    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    public ArrayList<WifiListModel> mItems = new ArrayList<>();
    private WifiListAdapter.OnItemClickListener mListener;

    // ListViewAdapter의 생성자
    public WifiListAdapter(ArrayList<WifiListModel> mitem) {
        mItems = mitem;
    }

    @Override
    public WifiListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f1_listview_custom, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WifiListAdapter.ItemViewHolder viewHolder, int position) {

        // Data Set(listViewItemRecycler)에서 position에 위치한 데이터 참조 획득
        WifiListModel wifiListModel = mItems.get(position);

        if(wifiListModel.getAvai()) {
            // 아이템 내 각 위젯에 데이터 반영
            viewHolder.iconImageView.setImageDrawable(wifiListModel.getIcon());
            viewHolder.titleTextView.setText(wifiListModel.getSsid());

            viewHolder.descTextView.setText(wifiListModel.getSsid());
        }else{
            viewHolder.iconImageView.setImageDrawable(wifiListModel.getIcon());
            viewHolder.titleTextView.setText(wifiListModel.getSsid());
            viewHolder.descTextView.setText(wifiListModel.getSsid());
        }

        if(wifiListModel.getAvai()) {
            viewHolder.titleTextView.setTextColor(Color.BLACK);
            viewHolder.background.setBackgroundColor(Color.parseColor("#cc99ff"));
        }else{
            viewHolder.titleTextView.setTextColor(Color.BLACK);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descTextView;
        public ImageView iconImageView;
        public LinearLayout background;

        public ItemViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.ssid);
            descTextView = itemView.findViewById(R.id.price);
            iconImageView = itemView.findViewById(R.id.icon);
            background = itemView.findViewById(R.id.itembackground);
        }

    }


    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    public int getItemCount() {
        return mItems.size();
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    public WifiListModel getObject(int position) {
        return mItems.get(position);
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(WifiListAdapter.OnItemClickListener listener){
        mListener = listener;
    }



//    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능. (와이파이 상태)
//    public void addItem(String ssid, String bssid, int rssi, Drawable icon, String securityMode) {
//        WifiListModel item = new WifiListModel();
//        boolean available = true;
//        for (int i = 0; i < mItems.size(); i++) {
//            WifiListModel items = mItems.get(i);
//
//            if (items.getSsid() != null) {
//                if (items.getSsid().equals(ssid)) {
//                    available = false;
//                }
//                // ssid는 같지만 rssi가 다를 때
//                if (items.getSsid().equals(ssid) && items.getRssi() != rssi) {
//                    available = true;
//                    mItems.remove(i);
//                }
//            }
//
//        }
//        if (available) {
//            item.setRssi(rssi);
//            item.setSsid(ssid);
//            item.setPrice(bssid);
//            item.setIcon(icon);
//            item.setSecurityMode(securityMode);
//            mItems.add(item);
//        }
//    }


//    public void itemSort() {
//        Collections.sort(mItems, new Comparator<WifiListModel>() {
//            @Override
//            public int compare(WifiListModel o1, WifiListModel o2) {
//                if (o1.getRssi() > o2.getRssi()) {
//                    return 1;
//                } else if (o1.getRssi() < o2.getRssi()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });
//        Collections.reverse(mItems);
//        this.notifyDataSetChanged();
//
//    }


}
