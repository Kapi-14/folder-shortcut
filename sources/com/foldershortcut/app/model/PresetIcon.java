package com.foldershortcut.app.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PresetIcon.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/foldershortcut/app/model/PresetIcon;", "", "id", "", "name", "drawableName", "resId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDrawableName", "()Ljava/lang/String;", "getId", "getName", "getResId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class PresetIcon {
    private final String drawableName;
    private final String id;
    private final String name;
    private final int resId;

    public static /* synthetic */ PresetIcon copy$default(PresetIcon presetIcon, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = presetIcon.id;
        }
        if ((i2 & 2) != 0) {
            str2 = presetIcon.name;
        }
        if ((i2 & 4) != 0) {
            str3 = presetIcon.drawableName;
        }
        if ((i2 & 8) != 0) {
            i = presetIcon.resId;
        }
        return presetIcon.copy(str, str2, str3, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDrawableName() {
        return this.drawableName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    public final PresetIcon copy(String id, String name, String drawableName, int resId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(drawableName, "drawableName");
        return new PresetIcon(id, name, drawableName, resId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PresetIcon)) {
            return false;
        }
        PresetIcon presetIcon = (PresetIcon) other;
        return Intrinsics.areEqual(this.id, presetIcon.id) && Intrinsics.areEqual(this.name, presetIcon.name) && Intrinsics.areEqual(this.drawableName, presetIcon.drawableName) && this.resId == presetIcon.resId;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.drawableName.hashCode()) * 31) + this.resId;
    }

    public String toString() {
        return "PresetIcon(id=" + this.id + ", name=" + this.name + ", drawableName=" + this.drawableName + ", resId=" + this.resId + ")";
    }

    public PresetIcon(String id, String name, String drawableName, int resId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(drawableName, "drawableName");
        this.id = id;
        this.name = name;
        this.drawableName = drawableName;
        this.resId = resId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDrawableName() {
        return this.drawableName;
    }

    public final int getResId() {
        return this.resId;
    }
}
