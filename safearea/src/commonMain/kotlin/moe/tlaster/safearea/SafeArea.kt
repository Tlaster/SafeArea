package moe.tlaster.safearea

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.remember

@Immutable
data class SafeAreaBehavior(
    val extendToTop: Boolean = false,
    val extendToBottom: Boolean = false,
    val extendToStart: Boolean = false,
    val extendToEnd: Boolean = false,
)

@Immutable
data class SafeAreaColors(
    val top: Color = Color.Transparent,
    val bottom: Color = Color.Transparent,
    val start: Color = Color.Transparent,
    val end: Color = Color.Transparent,
)

@get:Composable
@get:NonRestartableComposable
expect val WindowInsets.Companion.topBar: WindowInsets
@get:Composable
@get:NonRestartableComposable
expect val WindowInsets.Companion.startBar: WindowInsets
@get:Composable
@get:NonRestartableComposable
expect val WindowInsets.Companion.endBar: WindowInsets
@get:Composable
@get:NonRestartableComposable
expect val WindowInsets.Companion.bottomBar: WindowInsets

@Composable
fun SafeArea(
    behavior: SafeAreaBehavior = remember { SafeAreaBehavior() },
    color: SafeAreaColors = remember { SafeAreaColors() },
    content: @Composable () -> Unit,
) {
    Row {
        if (!behavior.extendToStart) {
            Spacer(
                modifier = Modifier
                    .windowInsetsStartWidth(WindowInsets.startBar)
                    .zIndex(999F)
                    .fillMaxHeight()
                    .background(color.start)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f),
        ) {
            if (!behavior.extendToTop) {
                Spacer(
                    modifier = Modifier
                        .windowInsetsTopHeight(WindowInsets.topBar)
                        .zIndex(999F)
                        .fillMaxWidth()
                        .background(color.top)
                )
            }
            Box(
                modifier = Modifier.weight(1f),
            ) {
                content()
            }
            if (!behavior.extendToBottom) {
                Spacer(
                    modifier = Modifier
                        .windowInsetsBottomHeight(WindowInsets.bottomBar)
                        .zIndex(999F)
                        .fillMaxWidth()
                        .background(color.bottom)
                )
            }
        }
        if (!behavior.extendToEnd) {
            Spacer(
                modifier = Modifier
                    .windowInsetsEndWidth(WindowInsets.endBar)
                    .zIndex(999F)
                    .fillMaxHeight()
                    .background(color.end)
            )
        }
    }
}