package moe.tlaster.safearea

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

actual val WindowInsets.Companion.topBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets.statusBars
actual val WindowInsets.Companion.startBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets.navigationBars
actual val WindowInsets.Companion.endBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets.navigationBars
actual val WindowInsets.Companion.bottomBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsets.navigationBars.union(WindowInsets.ime)