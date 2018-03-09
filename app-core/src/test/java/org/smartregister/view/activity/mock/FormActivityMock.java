package org.smartregister.view.activity.mock;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.smartregister.Context;
import org.smartregister.R;
import org.smartregister.view.activity.FormActivity;

/**
 * Created by kaderchowdhury on 11/11/17.
 */

public class FormActivityMock extends FormActivity {

    static Context mockactivitycontext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); //we need this here
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Context context() {
        return mockactivitycontext;
    }

    public static void setContext(Context context) {
        mockactivitycontext = context;
    }


}
