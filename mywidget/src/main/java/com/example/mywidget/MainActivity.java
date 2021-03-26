package com.example.mywidget;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mywidget.view.adapter.MainPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    MainPagerAdapter mMainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("onCreate ", "onCreate() 실행");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout_main);
        tabLayout.addTab(tabLayout.newTab().setText("에너지미터링"));
        tabLayout.addTab(tabLayout.newTab().setText("평균사용량"));
        tabLayout.addTab(tabLayout.newTab().setText("탄소배출량"));

        mViewPager = findViewById(R.id.vp_main);

        assert getFragmentManager() != null;
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMainPagerAdapter);

        // 한 번에 3개까지 미리 생성 default는 1
        mViewPager.setOffscreenPageLimit(mMainPagerAdapter.mFragments.size());

        // Pager가 변경될 때 발생하는 이벤트로 이 때, TabLayout의 탭까지 변경해주어야 함. 이 동작 처리하지 않을 시 Pager는 슬라이딩되어도 탭은 움직이지 않음
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // 반대로 tab이 눌렸을 시 Pager가 같이 변경되게 처리
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            // 탭이 선택될 때 발생하는 이벤트
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*
        //volley를 쓸 때 큐가 비어있으면 새로운 큐 생성하기
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        //시간데이터와 날씨데이터 활용
        CurrentCall();*/

    }

    @Override
    protected void onStart() {
        Log.e("onStart ", "onStart() 실행");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.e("onResume ", "onResume() 실행");
        super.onResume();
        mMainPagerAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onPause() {
        Log.e("onPause ", "onPause() 실행");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.e("onStop ", "onStop() 실행");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.e("onDestroy ", "onDestroy() 실행");
        super.onDestroy();
    }

/*private void CurrentCall(){

    String url = "http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=98b85ea54c7a4da9d617305550013e44";

    Log.e("실행되나요1","네");

    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.e("실행되나요2","네");

            try {
                JSONObject jsonObject = new JSONObject(response);

                // 도시 키값 받기
                String city = jsonObject.getString("name");
                Log.e("도시",city);
                cityView.setText(city);

                //기온 키값 받기
                JSONObject tempK = new JSONObject(jsonObject.getString("main"));

                //기온 받고 켈빈 온도를 섭씨 온도로 변경
                double tempDo = (Math.round((tempK.getDouble("temp")-273.15)*100)/100.0);
                Log.e("날씨",((Double)tempDo).toString());
                tempView.setText(tempDo +  "°C");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("test", error.getMessage());
        }
    }){
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();

            return params;
        }

    };

    request.setShouldCache(false);
    requestQueue.add(request);
}*/
}
