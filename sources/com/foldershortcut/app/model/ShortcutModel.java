package com.foldershortcut.app.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ShortcutModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 A2\u00020\u0001:\u0001AB}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\u0085\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u000bHÖ\u0001J\u0006\u0010>\u001a\u00020?J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015¨\u0006B"}, d2 = {"Lcom/foldershortcut/app/model/ShortcutModel;", "", "id", "", "label", "folderPath", "folderUri", "iconType", "presetIconName", "personalImageBase64", "iconBgColor", "", "iconTintColor", "shapeMask", "clickAction", "createdTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;J)V", "getClickAction", "()Ljava/lang/String;", "setClickAction", "(Ljava/lang/String;)V", "getCreatedTimestamp", "()J", "getFolderPath", "setFolderPath", "getFolderUri", "setFolderUri", "getIconBgColor", "()I", "setIconBgColor", "(I)V", "getIconTintColor", "setIconTintColor", "getIconType", "setIconType", "getId", "getLabel", "setLabel", "getPersonalImageBase64", "setPersonalImageBase64", "getPresetIconName", "setPresetIconName", "getShapeMask", "setShapeMask", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final /* data */ class ShortcutModel {
    public static final String ACTION_BUILT_IN_BROWSER = "BUILT_IN_BROWSER";
    public static final String ACTION_FILE_MANAGER = "FILE_MANAGER";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ICON_TYPE_PERSONAL = "PERSONAL";
    public static final String ICON_TYPE_PRESET = "PRESET";
    public static final String SHAPE_CIRCLE = "CIRCLE";
    public static final String SHAPE_HEXAGON = "HEXAGON";
    public static final String SHAPE_ORIGINAL = "ORIGINAL";
    public static final String SHAPE_ROUNDED = "ROUNDED";
    public static final String SHAPE_SQUIRCLE = "SQUIRCLE";
    public static final String SHAPE_STAR = "STAR";
    private String clickAction;
    private final long createdTimestamp;
    private String folderPath;
    private String folderUri;
    private int iconBgColor;
    private int iconTintColor;
    private String iconType;
    private final String id;
    private String label;
    private String personalImageBase64;
    private String presetIconName;
    private String shapeMask;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getShapeMask() {
        return this.shapeMask;
    }

    /* renamed from: component11, reason: from getter */
    public final String getClickAction() {
        return this.clickAction;
    }

    /* renamed from: component12, reason: from getter */
    public final long getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFolderPath() {
        return this.folderPath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFolderUri() {
        return this.folderUri;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIconType() {
        return this.iconType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPresetIconName() {
        return this.presetIconName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPersonalImageBase64() {
        return this.personalImageBase64;
    }

    /* renamed from: component8, reason: from getter */
    public final int getIconBgColor() {
        return this.iconBgColor;
    }

    /* renamed from: component9, reason: from getter */
    public final int getIconTintColor() {
        return this.iconTintColor;
    }

    public final ShortcutModel copy(String id, String label, String folderPath, String folderUri, String iconType, String presetIconName, String personalImageBase64, int iconBgColor, int iconTintColor, String shapeMask, String clickAction, long createdTimestamp) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        Intrinsics.checkNotNullParameter(presetIconName, "presetIconName");
        Intrinsics.checkNotNullParameter(shapeMask, "shapeMask");
        Intrinsics.checkNotNullParameter(clickAction, "clickAction");
        return new ShortcutModel(id, label, folderPath, folderUri, iconType, presetIconName, personalImageBase64, iconBgColor, iconTintColor, shapeMask, clickAction, createdTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShortcutModel)) {
            return false;
        }
        ShortcutModel shortcutModel = (ShortcutModel) other;
        return Intrinsics.areEqual(this.id, shortcutModel.id) && Intrinsics.areEqual(this.label, shortcutModel.label) && Intrinsics.areEqual(this.folderPath, shortcutModel.folderPath) && Intrinsics.areEqual(this.folderUri, shortcutModel.folderUri) && Intrinsics.areEqual(this.iconType, shortcutModel.iconType) && Intrinsics.areEqual(this.presetIconName, shortcutModel.presetIconName) && Intrinsics.areEqual(this.personalImageBase64, shortcutModel.personalImageBase64) && this.iconBgColor == shortcutModel.iconBgColor && this.iconTintColor == shortcutModel.iconTintColor && Intrinsics.areEqual(this.shapeMask, shortcutModel.shapeMask) && Intrinsics.areEqual(this.clickAction, shortcutModel.clickAction) && this.createdTimestamp == shortcutModel.createdTimestamp;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.id.hashCode() * 31) + this.label.hashCode()) * 31) + this.folderPath.hashCode()) * 31) + (this.folderUri == null ? 0 : this.folderUri.hashCode())) * 31) + this.iconType.hashCode()) * 31) + this.presetIconName.hashCode()) * 31) + (this.personalImageBase64 != null ? this.personalImageBase64.hashCode() : 0)) * 31) + this.iconBgColor) * 31) + this.iconTintColor) * 31) + this.shapeMask.hashCode()) * 31) + this.clickAction.hashCode()) * 31) + FolderItem$$ExternalSyntheticBackport1.m(this.createdTimestamp);
    }

    public String toString() {
        return "ShortcutModel(id=" + this.id + ", label=" + this.label + ", folderPath=" + this.folderPath + ", folderUri=" + this.folderUri + ", iconType=" + this.iconType + ", presetIconName=" + this.presetIconName + ", personalImageBase64=" + this.personalImageBase64 + ", iconBgColor=" + this.iconBgColor + ", iconTintColor=" + this.iconTintColor + ", shapeMask=" + this.shapeMask + ", clickAction=" + this.clickAction + ", createdTimestamp=" + this.createdTimestamp + ")";
    }

    public ShortcutModel(String id, String label, String folderPath, String folderUri, String iconType, String presetIconName, String personalImageBase64, int iconBgColor, int iconTintColor, String shapeMask, String clickAction, long createdTimestamp) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        Intrinsics.checkNotNullParameter(presetIconName, "presetIconName");
        Intrinsics.checkNotNullParameter(shapeMask, "shapeMask");
        Intrinsics.checkNotNullParameter(clickAction, "clickAction");
        this.id = id;
        this.label = label;
        this.folderPath = folderPath;
        this.folderUri = folderUri;
        this.iconType = iconType;
        this.presetIconName = presetIconName;
        this.personalImageBase64 = personalImageBase64;
        this.iconBgColor = iconBgColor;
        this.iconTintColor = iconTintColor;
        this.shapeMask = shapeMask;
        this.clickAction = clickAction;
        this.createdTimestamp = createdTimestamp;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ShortcutModel(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, int r25, int r26, java.lang.String r27, java.lang.String r28, long r29, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L16
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r4 = r1
            goto L18
        L16:
            r4 = r18
        L18:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L1f
            r7 = r2
            goto L21
        L1f:
            r7 = r21
        L21:
            r1 = r0 & 16
            if (r1 == 0) goto L29
            java.lang.String r1 = "PRESET"
            r8 = r1
            goto L2b
        L29:
            r8 = r22
        L2b:
            r1 = r0 & 32
            if (r1 == 0) goto L33
            java.lang.String r1 = "ic_folder"
            r9 = r1
            goto L35
        L33:
            r9 = r23
        L35:
            r1 = r0 & 64
            if (r1 == 0) goto L3b
            r10 = r2
            goto L3d
        L3b:
            r10 = r24
        L3d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L48
            r1 = -10262799(0xffffffffff6366f1, float:-3.0226926E38)
            r11 = -10262799(0xffffffffff6366f1, float:-3.0226926E38)
            goto L4a
        L48:
            r11 = r25
        L4a:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L51
            r1 = -1
            r12 = -1
            goto L53
        L51:
            r12 = r26
        L53:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L5b
            java.lang.String r1 = "ROUNDED"
            r13 = r1
            goto L5d
        L5b:
            r13 = r27
        L5d:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L65
            java.lang.String r1 = "FILE_MANAGER"
            r14 = r1
            goto L67
        L65:
            r14 = r28
        L67:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L71
            long r0 = java.lang.System.currentTimeMillis()
            r15 = r0
            goto L73
        L71:
            r15 = r29
        L73:
            r3 = r17
            r5 = r19
            r6 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.foldershortcut.app.model.ShortcutModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.label = str;
    }

    public final String getFolderPath() {
        return this.folderPath;
    }

    public final void setFolderPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.folderPath = str;
    }

    public final String getFolderUri() {
        return this.folderUri;
    }

    public final void setFolderUri(String str) {
        this.folderUri = str;
    }

    public final String getIconType() {
        return this.iconType;
    }

    public final void setIconType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconType = str;
    }

    public final String getPresetIconName() {
        return this.presetIconName;
    }

    public final void setPresetIconName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.presetIconName = str;
    }

    public final String getPersonalImageBase64() {
        return this.personalImageBase64;
    }

    public final void setPersonalImageBase64(String str) {
        this.personalImageBase64 = str;
    }

    public final int getIconBgColor() {
        return this.iconBgColor;
    }

    public final void setIconBgColor(int i) {
        this.iconBgColor = i;
    }

    public final int getIconTintColor() {
        return this.iconTintColor;
    }

    public final void setIconTintColor(int i) {
        this.iconTintColor = i;
    }

    public final String getShapeMask() {
        return this.shapeMask;
    }

    public final void setShapeMask(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shapeMask = str;
    }

    public final String getClickAction() {
        return this.clickAction;
    }

    public final void setClickAction(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clickAction = str;
    }

    public final long getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    public final JSONObject toJson() {
        JSONObject $this$toJson_u24lambda_u240 = new JSONObject();
        $this$toJson_u24lambda_u240.put("id", this.id);
        $this$toJson_u24lambda_u240.put("label", this.label);
        $this$toJson_u24lambda_u240.put("folderPath", this.folderPath);
        String str = this.folderUri;
        if (str == null) {
            str = "";
        }
        $this$toJson_u24lambda_u240.put("folderUri", str);
        $this$toJson_u24lambda_u240.put("iconType", this.iconType);
        $this$toJson_u24lambda_u240.put("presetIconName", this.presetIconName);
        String str2 = this.personalImageBase64;
        $this$toJson_u24lambda_u240.put("personalImageBase64", str2 != null ? str2 : "");
        $this$toJson_u24lambda_u240.put("iconBgColor", this.iconBgColor);
        $this$toJson_u24lambda_u240.put("iconTintColor", this.iconTintColor);
        $this$toJson_u24lambda_u240.put("shapeMask", this.shapeMask);
        $this$toJson_u24lambda_u240.put("clickAction", this.clickAction);
        $this$toJson_u24lambda_u240.put("createdTimestamp", this.createdTimestamp);
        return $this$toJson_u24lambda_u240;
    }

    /* compiled from: ShortcutModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/foldershortcut/app/model/ShortcutModel$Companion;", "", "()V", "ACTION_BUILT_IN_BROWSER", "", "ACTION_FILE_MANAGER", "ICON_TYPE_PERSONAL", "ICON_TYPE_PRESET", "SHAPE_CIRCLE", "SHAPE_HEXAGON", "SHAPE_ORIGINAL", "SHAPE_ROUNDED", "SHAPE_SQUIRCLE", "SHAPE_STAR", "fromJson", "Lcom/foldershortcut/app/model/ShortcutModel;", "json", "Lorg/json/JSONObject;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShortcutModel fromJson(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String optString = json.optString("id", UUID.randomUUID().toString());
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            String optString2 = json.optString("label", "Folder Shortcut");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
            String optString3 = json.optString("folderPath", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
            String it = json.optString("folderUri", "");
            Intrinsics.checkNotNull(it);
            if (!(it.length() > 0)) {
                it = null;
            }
            String optString4 = json.optString("iconType", ShortcutModel.ICON_TYPE_PRESET);
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
            String optString5 = json.optString("presetIconName", "ic_folder");
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(...)");
            String it2 = json.optString("personalImageBase64", "");
            Intrinsics.checkNotNull(it2);
            String str = it2.length() > 0 ? it2 : null;
            int optInt = json.optInt("iconBgColor", -10262799);
            int optInt2 = json.optInt("iconTintColor", -1);
            String optString6 = json.optString("shapeMask", ShortcutModel.SHAPE_ROUNDED);
            Intrinsics.checkNotNullExpressionValue(optString6, "optString(...)");
            String optString7 = json.optString("clickAction", ShortcutModel.ACTION_FILE_MANAGER);
            Intrinsics.checkNotNullExpressionValue(optString7, "optString(...)");
            return new ShortcutModel(optString, optString2, optString3, it, optString4, optString5, str, optInt, optInt2, optString6, optString7, json.optLong("createdTimestamp", System.currentTimeMillis()));
        }
    }
}
