package aaa.bivizul.a31project.especdata.especutil

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val especIoDispatcher: CoroutineContext = Dispatchers.Main
actual val especUiDispatcher: CoroutineContext = Dispatchers.IO