package com.dev_akash.carousellnews.viewmodel

import com.dev_akash.carousellnews.model.NewsHomeResponse
import com.dev_akash.carousellnews.repo.NewsHomeRepo
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NewsViewModelTest {

    @Mock
    lateinit var repo: NewsHomeRepo
    private lateinit var viewModel: NewsViewModel


    @Test
    fun sortNewsByRecent() {
        var res = true
        val expectedOrderOfId = listOf("122", "121", "123", "125", "126", "124")
        val sortedList = viewModel.getPostSortedByRecent(mockDataList())
        sortedList?.let { list ->
            for (i in list.indices) {
                if (sortedList[i].id != expectedOrderOfId[i]) {
                    res = false
                    break
                }
            }

            assertEquals(true, res)
        }
    }

    @Test
    fun sortNewsByPopular() {
        val expectedOrderOfId = listOf("123", "124", "121", "122", "125", "126")

        var res = true
        val sortedList = viewModel.getPostSortedByPopular(mockDataList())
        sortedList?.let { list ->
            for (i in list.indices) {
                if (sortedList[i].id != expectedOrderOfId[i]) {
                    res = false
                    break
                }
            }

            assertEquals(true, res)
        }
    }

    @Before
    fun prepareMockViewModel() {
        MockitoAnnotations.openMocks(this)
        viewModel = NewsViewModel(repo)

    }

    private fun mockDataList() = listOf(
        NewsHomeResponse(
            id = "121",
            title = "Carousell is launching its own digital wallet to improve payments for its users",
            description = "Due to launch next month in Singapore, CarolPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash. CarouPay will be a digital wallet within the Carousell app. \"More than half of our sellers will end up buying items as well, so maybe it makes sense to have that money in the wallet for purchases\" - Quek tells Tech in Asia.",
            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg",
            timeCreated = 1532853058,
            rank = 2
        ),
        NewsHomeResponse(
            id = "122",
            title = "Southeast Asia-based mobile listings startup Carousell raises $85M",
            description = "Carousell, the Singapore-based mobile listing service that operates across Southeast Asia, has pulled in an $85 million Series C fund as it seeks to strengthen its business among the region's competitive e-commerce landscape before expanding globally.",
            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-hero-image_10june.png",
            timeCreated = 1532939458,
            rank = 5
        ),
        NewsHomeResponse(
            id = "123",
            title = "Carousell is launching its own digital wallet to improve payments for its users",
            description = "Due to launch next month in Singapore, CarouPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash. CarouPay will be a digital wallet within the Carousell app. \"More than half of our sellers will end up buying items as well, so maybe it makes sense to have that money in the wallet for purchases\" - Quek tells Tech in Asia.",
            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg",
            timeCreated = 1530322670,
            rank = 1
        ),
        NewsHomeResponse(
            id = "124",
            title = "Carousell is launching its own digital wallet to improve payments for its users",
            description = "Due to launch next month in Singapore, CarouPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash. CarouPay will be a digital wallet within the Carousell app. \"More than half of our sellers will end up buying items as well, so maybe it makes sense to have that money in the wallet for purchases\" - Quek tells Tech in Asia.",
            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg",
            timeCreated = 1519983341,
            rank = 1
        ),
        NewsHomeResponse(
            id = "125",
            title = "Carousell is launching its own digital wallet to improve payments for its users",
            description = "Due to launch next month in Singapore, CarouPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash. CarouPay will be a digital wallet within the Carousell app. \"More than half of our sellers will end up buying items as well, so maybe it makes sense to have that money in the wallet for purchases\" - Quek tells Tech in Asia.",
            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg",
            timeCreated = 1527672941,
            rank = 5
        ),
        NewsHomeResponse(
            id = "126",
            title = "Carousell is launching its own digital wallet to improve payments for its users",
            description = "Due to launch next month in Singapore, CarouPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash. CarouPay will be a digital wallet within the Carousell app. \"More than half of our sellers will end up buying items as well, so maybe it makes sense to have that money in the wallet for purchases\" - Quek tells Tech in Asia.",
            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg",
            timeCreated = 1527672941,
            rank = 7
        ),
    )
}