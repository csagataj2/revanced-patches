package app.revanced.patches.mobilkincstar.keyboard

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions
import app.revanced.patches.all.misc.minSdk.SetMinSdkVersion28
import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val KeyboardCheckPatch = bytecodePatch(
    name = "Keyboard Check Patch",
) {
    dependsOn(
        setMinSdkVersion28
    )

    compatibleWith("hu.dorsum.clavis.kincstar.mobile"("8.3.2-2", "8.3.2-1"))

    execute {
        isEmulatorSyncFingerprint.method.replaceInstructions(
            0,
            """
                const/4 v0, 0x0
                return v0
            """,
        )
    }
}
