package com.apps.pickup_lines;

import android.app.Application;
import android.content.Context;

public class ApplicationClass extends Application {
   static private Context context;

   public ApplicationClass() {
        this.context = this;
    }

    static  public Context getContext() {
        return context;
    }
}
