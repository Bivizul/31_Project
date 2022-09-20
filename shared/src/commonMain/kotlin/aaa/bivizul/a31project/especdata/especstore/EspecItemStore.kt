package aaa.bivizul.a31project.especdata.especstore

import aaa.bivizul.a31project.especdata.especmodel.EspecItem
import aaa.bivizul.a31project.especdata.especnet.EspecApi
import aaa.bivizul.a31project.especdata.especutil.especIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EspecItemStore {

    private val especApi = EspecApi()
    private val job = SupervisorJob()
    private val scope = CoroutineScope(especIoDispatcher + job)

    private val _especItem = MutableStateFlow<List<EspecItem>?>(null)
    val especItem: StateFlow<List<EspecItem>?> = _especItem.asStateFlow()

    init {
        getEspecItem()
    }

    private fun getEspecItem() {
        scope.launch {
            val response = especApi.getEspecItem()
            _especItem.emit(response)
        }
    }

}