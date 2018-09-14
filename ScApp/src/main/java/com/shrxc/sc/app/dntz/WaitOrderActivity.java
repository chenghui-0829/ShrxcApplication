package com.shrxc.sc.app.dntz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ZoomControls;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.shrxc.sc.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WaitOrderActivity extends AppCompatActivity {

    @BindView(R.id.wait_order_activity_fresh_icon)
    ImageView orderFreshIcon;
    @BindView(R.id.wait_order_activity_sd_time_layout)
    LinearLayout orderSdTimeLayout;
    @BindView(R.id.wait_order_activity_content_layout)
    LinearLayout orderContentLayout;
    @BindView(R.id.wait_order_activity_scrollView)
    ScrollView orderScrollView;

    private Context context = WaitOrderActivity.this;
    @BindView(R.id.wait_order_activity_mapview)
    MapView mMapView;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    private int mCurrentDirection = 0;
    private double mCurrentLat = 0.0;
    private double mCurrentLon = 0.0;
    private float mCurrentAccracy;
    private MyLocationData locData;
    boolean isFirstLoc = true; // 是否首次定位

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_order);
        ButterKnife.bind(this);

        initView();
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);


        // 隐藏logo
        View child = mMapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
        //地图上比例尺
        mMapView.showScaleControl(false);
        // 隐藏缩放控件
        mMapView.showZoomControls(false);


        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        mLocationClient = new LocationClient(this);
        mLocationClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    private void initView() {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final int wh = wm.getDefaultDisplay().getHeight();

        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        orderSdTimeLayout.measure(w, h);
        int vh = orderSdTimeLayout.getMeasuredHeight();
        int marginTop = wh - vh;
        System.out.println("------->" + (wh - vh));
//        AppUtil.setViewMargin(orderScrollView, 0, 1000, 0, 0);


//        orderScrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
//            @Override
//            public void onScrollListener(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY > 10) {
////                    AppUtil.setViewMargin(orderScrollView, 0, 1000 - scrollY, 0, 0);
//                }
//            }
//        });
    }

    @OnClick({R.id.wait_order_activity_fresh_icon})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wait_order_activity_fresh_icon:
                LatLng ll = new LatLng(mCurrentLat,
                        mCurrentLon);
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                break;
        }
    }


    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
//            // 此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
//            // 以下只列举部分获取地址相关的结果信息
//            // 更多结果信息获取说明，请参照类参考中BDLocation类中的说明
//
//            String addr = location.getAddrStr(); // 获取详细地址信息
//            // String country = location.getCountry(); // 获取国家
//            String province = location.getProvince(); // 获取省份
//            String city = location.getCity(); // 获取城市
//            String district = location.getDistrict(); // 获取区县
//            // String street = location.getStreet(); // 获取街道信息
//            System.out.println("-----------address------->" + addr);
//            mLocationClient.stop();


            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            mCurrentLat = location.getLatitude();
            mCurrentLon = location.getLongitude();
            mCurrentAccracy = location.getRadius();
            locData = new MyLocationData.Builder()
                    .accuracy(0)
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }


            //定义用于显示该InfoWindow的坐标点
            LatLng pt = new LatLng(location.getLatitude(),
                    location.getLongitude());

            View view = LayoutInflater.from(context).inflate(R.layout.wait_order_window_layout, null);

            //创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
            InfoWindow mInfoWindow = new InfoWindow(view, pt, 0);

            //显示InfoWindow
            mBaiduMap.showInfoWindow(mInfoWindow);

        }
    }

}

