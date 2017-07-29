package com.example.tushant.jobscheduler;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {
    private JobParameters param;
    public MyJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        this.param = jobParameters;
        new MyTask().execute();
    //    Toast.makeText(getBaseContext(),"Service Started",Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    class MyTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
           //Do Some Stuff
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            jobFinished(param,false);
            super.onPostExecute(aVoid);
        }
    }

}
