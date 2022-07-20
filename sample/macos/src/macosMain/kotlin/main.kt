import moe.tlaster.common.App
import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication
import moe.tlaster.safearea.ProvideSafeArea

fun main() {
    NSApplication.sharedApplication()
    Window("PreComposeSample") {
        ProvideSafeArea {
            App()
        }
    }
    NSApp?.run()
}
