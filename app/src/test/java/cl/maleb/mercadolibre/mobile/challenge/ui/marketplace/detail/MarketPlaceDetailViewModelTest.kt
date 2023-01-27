package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail

import androidx.lifecycle.Observer
import app.cash.turbine.test
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.events.MarketPlaceDetailEvent
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.viewmodel.MarketPlaceDetailViewModel
import cl.maleb.mercadolibre.mobile.challenge.utils.BaseUnitTest
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.empty
import cl.maleb.mercadolibre.mobile.challenge.utils.getOrAwaitValueTest
import cl.maleb.mercadolibre.mobile.challenge.utils.network.Resource
import cl.maleb.mercadolibre.mobile.challenge.utils.repositories.MarketPlaceFakeRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.refEq
import org.mockito.kotlin.verify

class MarketPlaceDetailViewModelTest : BaseUnitTest() {

    private lateinit var viewModel: MarketPlaceDetailViewModel
    private lateinit var repository: MarketPlaceFakeRepository

    @Mock
    lateinit var marketPlaceDetailObserver: Observer<Resource<MarketPlaceDetailViewData>>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarketPlaceFakeRepository()
        viewModel = MarketPlaceDetailViewModel(repository)
        viewModel.marketPlaceDetailLiveData.observeForever(marketPlaceDetailObserver)
    }

    @Test
    fun `should change to loading state - when get marketplace detail is called`() =
        runTest {
            repository.setWillReturnError(false)
            viewModel.getMarketPlaceDetail(String.empty())

            verify(marketPlaceDetailObserver).onChanged(refEq(Resource.Loading()))
        }

    @Test
    fun `should change to error state - when get marketplace detail is called`() =
        runTest {
            repository.setWillReturnError(true)
            viewModel.getMarketPlaceDetail(String.empty())

            val value = viewModel.marketPlaceDetailLiveData.getOrAwaitValueTest()

            Truth.assertThat(value is Resource.Error).isTrue()
        }

    @Test
    fun `should change to success state - when get marketplace detail is called`() =
        runTest {
            repository.setWillReturnError(false)
            viewModel.getMarketPlaceDetail(String.empty())

            val value = viewModel.marketPlaceDetailLiveData.getOrAwaitValueTest()

            Truth.assertThat(value is Resource.Success).isTrue()
        }

    @Test
    fun `should emit get market detail event`() =
        runTest {
            viewModel.getMarketDetailEvent(String.empty())

            viewModel.marketPlaceDetailEvent.test {
                Truth.assertThat(awaitItem() is MarketPlaceDetailEvent.GetMarketDetail).isTrue()
                cancelAndIgnoreRemainingEvents()
            }
        }

}