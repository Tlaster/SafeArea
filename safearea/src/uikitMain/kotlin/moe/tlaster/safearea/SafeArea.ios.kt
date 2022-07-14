package moe.tlaster.safearea

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.useContents
import platform.UIKit.UIWindow
import platform.UIKit.safeAreaInsets

@Composable
fun ProvideSafeArea(
    window: UIWindow,
    content: @Composable () -> Unit,
) {
    val safeArea = remember {
        window.safeAreaInsets().useContents {
            SafeArea(
                top = top.toFloat(),
                bottom = bottom.toFloat(),
                left = left.toFloat(),
                right = right.toFloat(),
            )
        }
    }
    CompositionLocalProvider(
        LocalSafeAreaProvider provides safeArea
    ) {
        content.invoke()
    }
}

val LocalSafeAreaProvider = staticCompositionLocalOf<SafeArea> { error("No SafeArea") }

data class SafeArea(val top: Float, val bottom: Float, val left: Float, val right: Float)

actual val WindowInsets.Companion.topBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets(
        left = 0.dp,
        top = LocalSafeAreaProvider.current.top.dp,
        right = 0.dp,
        bottom = 0.dp,
    )
actual val WindowInsets.Companion.startBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets(
        left = LocalSafeAreaProvider.current.left.dp,
        top = 0.dp,
        right = 0.dp,
        bottom = 0.dp,
    )
actual val WindowInsets.Companion.endBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets(
        left = 0.dp,
        top = 0.dp,
        right = LocalSafeAreaProvider.current.right.dp,
        bottom = 0.dp,
    )
actual val WindowInsets.Companion.bottomBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets(
        left = 0.dp,
        top = 0.dp,
        right = 0.dp,
        bottom = LocalSafeAreaProvider.current.bottom.dp,
    )
