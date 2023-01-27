package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list

import app.cash.turbine.test
import cl.maleb.mercadolibre.mobile.challenge.paging.marketplace.MarketPlacePagingSource
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.events.MarketPlaceListEvent
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.viewmodel.MarketPlaceListViewModel
import cl.maleb.mercadolibre.mobile.challenge.utils.BaseUnitTest
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.empty
import cl.maleb.mercadolibre.mobile.challenge.utils.mapper.MarketPlaceMapperFakeFacade
import cl.maleb.mercadolibre.mobile.challenge.utils.remotedatasource.RemoteFakeDataSource
import cl.maleb.mercadolibre.mobile.challenge.utils.repositories.MarketPlaceFakeRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class MarketPlaceListViewModelTest : BaseUnitTest() {

    private lateinit var viewModel: MarketPlaceListViewModel
    private lateinit var repository: MarketPlaceFakeRepository
    private lateinit var remoteDataSource: RemoteFakeDataSource
    private lateinit var mapperFacade: MarketPlaceMapperFakeFacade

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarketPlaceFakeRepository()
        remoteDataSource = RemoteFakeDataSource()
        mapperFacade = MarketPlaceMapperFakeFacade()
        viewModel = MarketPlaceListViewModel(repository)
    }

    @Test
    fun `should emit search by query event`() =
        runTest {
            viewModel.searchByQueryEvent(String.empty())

            viewModel.marketPlaceListEvent.test {
                Truth.assertThat(awaitItem() is MarketPlaceListEvent.SearchByQuery).isTrue()
                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `should emit navigate to detail screen event`() =
        runTest {
            viewModel.navigateToDetailScreenEvent(String.empty())

            viewModel.marketPlaceListEvent.test {
                Truth.assertThat(awaitItem() is MarketPlaceListEvent.NavigateToDetailScreen)
                    .isTrue()
                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun loadReturnsPageWhenOnSuccessfulLoadOfItemKeyedData() = runTest {
        val pagingSource = MarketPlacePagingSource(remoteDataSource, mapperFacade, String.empty())
    }
}