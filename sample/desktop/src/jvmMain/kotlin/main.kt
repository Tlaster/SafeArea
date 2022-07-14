
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import moe.tlaster.common.App
import moe.tlaster.safearea.ProvideSafeArea

fun main() {
    application {
        Window(
            title = "SafeArea",
            onCloseRequest = {
                exitApplication()
            },
        ) {
            ProvideSafeArea {
                App()
            }
        }
    }
}
