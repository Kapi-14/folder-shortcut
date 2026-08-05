package com.foldershortcut.app.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.foldershortcut.app.R;
import com.foldershortcut.app.ShortcutLauncherActivity;
import com.foldershortcut.app.model.ShortcutModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShortcutHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/foldershortcut/app/utils/ShortcutHelper;", "", "()V", "pinShortcutToHomeScreen", "", "context", "Landroid/content/Context;", "model", "Lcom/foldershortcut/app/model/ShortcutModel;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ShortcutHelper {
    public static final ShortcutHelper INSTANCE = new ShortcutHelper();

    private ShortcutHelper() {
    }

    public final boolean pinShortcutToHomeScreen(Context context, ShortcutModel model) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Bitmap bitmap = ImageUtils.INSTANCE.createShortcutBitmap(context, model, 192);
        Intent launchIntent = new Intent(context, (Class<?>) ShortcutLauncherActivity.class);
        launchIntent.setAction("android.intent.action.VIEW");
        launchIntent.putExtra("extra_shortcut_id", model.getId());
        launchIntent.putExtra("extra_folder_path", model.getFolderPath());
        launchIntent.putExtra("extra_folder_uri", model.getFolderUri());
        launchIntent.setFlags(335544320);
        if (Build.VERSION.SDK_INT >= 26 && ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
            ShortcutInfoCompat pinShortcutInfo = new ShortcutInfoCompat.Builder(context, model.getId()).setShortLabel(model.getLabel()).setLongLabel(model.getLabel()).setIcon(IconCompat.createWithBitmap(bitmap)).setIntent(launchIntent).build();
            Intrinsics.checkNotNullExpressionValue(pinShortcutInfo, "build(...)");
            return ShortcutManagerCompat.requestPinShortcut(context, pinShortcutInfo, null);
        }
        try {
            Intent legacyIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            legacyIntent.putExtra("android.intent.extra.shortcut.INTENT", launchIntent);
            legacyIntent.putExtra("android.intent.extra.shortcut.NAME", model.getLabel());
            legacyIntent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            legacyIntent.putExtra("duplicate", false);
            context.sendBroadcast(legacyIntent);
            Toast.makeText(context, context.getString(R.string.shortcut_created_legacy), 0).show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
