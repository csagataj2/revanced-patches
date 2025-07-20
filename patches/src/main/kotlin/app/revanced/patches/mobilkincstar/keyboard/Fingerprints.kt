package app.revanced.patches.mobilkincstar.keyboard

import com.android.tools.smali.dexlib2.Opcode
import com.android.tools.smali.dexlib2.AccessFlags
import app.revanced.patcher.fingerprint

internal val isEmulatorSyncFingerprint = fingerprint {
    returns("Z;")
    custom { (method, classDef) -> method == "isEmulatorSync"}
}
