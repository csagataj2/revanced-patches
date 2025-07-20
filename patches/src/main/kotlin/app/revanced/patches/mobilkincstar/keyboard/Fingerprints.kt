package app.revanced.patches.mobilkincstar.keyboard

import com.android.tools.smali.dexlib2.Opcode
import com.android.tools.smali.dexlib2.AccessFlags
import app.revanced.patcher.fingerprint

internal val isEmulatorSyncFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC)
    returns("Z")
    parameters()
    custom { _, classDef -> classDef.endsWith("/RNDeviceModule;") }
    
}
