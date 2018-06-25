package br.com.stant.libraries.stantuiandroid.testutils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;

public class IntentFactory {

    public static Intent createIntentWithBundle(Class targetClass, Bundle bundle){
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                    .getTargetContext();
        Intent intent = new Intent(targetContext, targetClass);
        intent.putExtras(bundle);
        return intent;
    }

    public static Intent createIntentWithoutBundle(Class targetClass){
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        return new Intent(targetContext, targetClass);
    }
}
