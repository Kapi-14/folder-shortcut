package com.foldershortcut.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.foldershortcut.app.model.ShortcutModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ShortcutStore.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/foldershortcut/app/utils/ShortcutStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "deleteShortcut", "", "id", "", "getAllShortcuts", "", "Lcom/foldershortcut/app/model/ShortcutModel;", "getShortcutById", "saveAll", "shortcuts", "saveShortcut", "shortcut", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ShortcutStore {
    private static final String KEY_SHORTCUTS = "shortcuts_list";
    private static final String PREF_NAME = "folder_shortcuts_pref";
    private final SharedPreferences prefs;

    public ShortcutStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getSharedPreferences(PREF_NAME, 0);
    }

    public final List<ShortcutModel> getAllShortcuts() {
        List list = new ArrayList();
        String string = this.prefs.getString(KEY_SHORTCUTS, "[]");
        String jsonString = string != null ? string : "[]";
        try {
            JSONArray array = new JSONArray(jsonString);
            int length = array.length();
            for (int i = 0; i < length; i++) {
                JSONObject obj = array.getJSONObject(i);
                ShortcutModel.Companion companion = ShortcutModel.INSTANCE;
                Intrinsics.checkNotNull(obj);
                list.add(companion.fromJson(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List $this$sortedByDescending$iv = list;
        return CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.foldershortcut.app.utils.ShortcutStore$getAllShortcuts$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ShortcutModel it = (ShortcutModel) t2;
                ShortcutModel it2 = (ShortcutModel) t;
                return ComparisonsKt.compareValues(Long.valueOf(it.getCreatedTimestamp()), Long.valueOf(it2.getCreatedTimestamp()));
            }
        });
    }

    public final void saveShortcut(ShortcutModel shortcut) {
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        List shortcuts = CollectionsKt.toMutableList((Collection) getAllShortcuts());
        int index$iv = 0;
        Iterator<ShortcutModel> it = shortcuts.iterator();
        while (true) {
            if (!it.hasNext()) {
                index$iv = -1;
                break;
            }
            Object item$iv = it.next();
            ShortcutModel it2 = (ShortcutModel) item$iv;
            if (Intrinsics.areEqual(it2.getId(), shortcut.getId())) {
                break;
            } else {
                index$iv++;
            }
        }
        int index = index$iv;
        if (index >= 0) {
            shortcuts.set(index, shortcut);
        } else {
            shortcuts.add(0, shortcut);
        }
        saveAll(shortcuts);
    }

    public final void deleteShortcut(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Iterable $this$filter$iv = getAllShortcuts();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ShortcutModel it = (ShortcutModel) element$iv$iv;
            if (!Intrinsics.areEqual(it.getId(), id)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List shortcuts = (List) destination$iv$iv;
        saveAll(shortcuts);
    }

    public final ShortcutModel getShortcutById(String id) {
        Object obj;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = getAllShortcuts().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ShortcutModel it2 = (ShortcutModel) obj;
            if (Intrinsics.areEqual(it2.getId(), id)) {
                break;
            }
        }
        return (ShortcutModel) obj;
    }

    private final void saveAll(List<ShortcutModel> shortcuts) {
        JSONArray array = new JSONArray();
        for (ShortcutModel item : shortcuts) {
            array.put(item.toJson());
        }
        this.prefs.edit().putString(KEY_SHORTCUTS, array.toString()).apply();
    }
}
