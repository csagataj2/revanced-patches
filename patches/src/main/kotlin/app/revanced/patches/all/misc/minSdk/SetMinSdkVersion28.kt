package app.revanced.patches.all.misc.minSdk

import app.revanced.patcher.patch.resourcePatch
import app.revanced.util.getNode
import org.w3c.dom.Element
import java.util.logging.Logger

@Suppress("unused")
val setMinSdkVersion28 = resourcePatch(
    name = "Set target SDK version 28",
    description = "Changes the target SDK to version 28 (Android 9). ",
    use = false,
) {
    execute {
        val minSdkOverride = 28 // Android 9.

        document("AndroidManifest.xml").use { document ->
            fun getLogger() = Logger.getLogger(this::class.java.name)

            // Change minSdkVersion to override value.
            document.getElementsByTagName("manifest").item(0).let {
                var element = it.ownerDocument.createElement("uses-sdk")
                element.setAttribute("android:minSdkVersion", minSdkOverride.toString())

                it.appendChild(element)
            }
        }
    }
}
