package moe.tlaster.safearea

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProvideSafeArea(
    top: Dp = 0.dp,
    bottom: Dp = 0.dp,
    left: Dp = 0.dp,
    right: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    val safeArea = remember {
        SafeArea(
            top = top,
            bottom = bottom,
            left = left,
            right = right
        )
    }
    CompositionLocalProvider(
        LocalSafeAreaProvider provides safeArea
    ) {
        content.invoke()
    }
}

val LocalSafeAreaProvider = staticCompositionLocalOf<SafeArea> { error("No SafeArea") }

data class SafeArea(val top: Dp, val bottom: Dp, val left: Dp, val right: Dp)

actual val WindowInsets.Companion.topBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets(
        left = 0.dp,
        top = LocalSafeAreaProvider.current.top,
        right = 0.dp,
        bottom = 0.dp,
    )
actual val WindowInsets.Companion.startBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets(
        left = LocalSafeAreaProvider.current.left,
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
        right = LocalSafeAreaProvider.current.right,
        bottom = 0.dp,
    )
actual val WindowInsets.Companion.bottomBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets(
        left = 0.dp,
        top = 0.dp,
        right = 0.dp,
        bottom = LocalSafeAreaProvider.current.bottom,
    )
