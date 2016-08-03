package com.feicui.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.pb) ProgressBar mPb;
    @Bind(R.id.download) Button download;
    @Bind(R.id.tv) TextView mTv;
//    private Button mDownload;
//    private TextView mTv;
//    private ProgressBar mPb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mPb = (ProgressBar) findViewById(R.id.pb);
//        mTv = (TextView) findViewById(R.id.tv);
//        mDownload = (Button) findViewById(R.id.download);
//        mDownload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DownloadTask dTask = new DownloadTask();
//                dTask.execute(100);
//
//            }
//        });
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    @OnClick(R.id.download)
    public void onClick() {

        Log.d(">>>>?",">>>>>");
        DownloadTask dTask = new DownloadTask();
        dTask.execute(100);

    }
    class DownloadTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... params) {
            //第二个执行方法,onPreExecute()执行完后执行
            for (int i = 0; i <= 100; i++) {
               mPb.setProgress(i);
                publishProgress(i);
                try {
                    Thread.sleep(params[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "执行完毕";
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            mTv.setText(progress[0]+"%");
        }

        @Override
        protected void onPostExecute(String result) {
            setTitle(result);

          //  finish();
            super.onPostExecute(result);


        }
    }
}
