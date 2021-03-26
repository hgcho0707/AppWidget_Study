package com.example.mywidget.view.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.mywidget.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TestWidgetProvider extends AppWidgetProvider {

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.e("OnReceive","onReceive 실행 됨");

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, getClass()));
        //for (int i = 0; i < appWidgetIds.length; i++){}
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

        Log.e("onUpdate","onUpdate 실행 됨");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.e("onDeleted","onDeleted 실행 됨");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.e("onEnabled","onEnabled 실행 됨");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.e("onDisabled","onDisabled 실행 됨");
    }

    public static void updateAppWidget(Context context,
                                       AppWidgetManager appWidgetManager, int appWidgetId) {

        // 현재 시간, 날짜, 온도 가져오기
        Calendar mCalendar = Calendar.getInstance();
        SimpleDateFormat mFormat = new SimpleDateFormat("aa hh:mm",
                Locale.getDefault());

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM월 dd일 yyyy년      EE요일",
                Locale.KOREA);

        SimpleDateFormat tempFormat = new SimpleDateFormat(" MM-dd-EE",
                Locale.KOREA);

        // RemoteViews를 이용해 Text설정
        RemoteViews updateViews = new RemoteViews(context.getPackageName(),
                R.layout.mywidget);

        updateViews.setTextViewText(R.id.widget_time, mFormat.format(mCalendar.getTime()));
        updateViews.setTextViewText(R.id.widget_date, dateFormat.format(mCalendar.getTime()));
        updateViews.setTextViewText(R.id.widget_temp, "영상 7.34도");

        // 위젯 업데이트
        appWidgetManager.updateAppWidget(appWidgetId, updateViews);
    }

}
