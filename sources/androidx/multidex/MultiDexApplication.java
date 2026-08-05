package androidx.multidex;

import android.app.Application;
import android.content.Context;

/* loaded from: classes.dex */
public class MultiDexApplication extends Application {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
