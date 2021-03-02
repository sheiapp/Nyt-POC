package com.example.nytpoc.repository

import com.example.nytpoc.model.ApiResponse
import com.example.nytpoc.model.Media
import com.example.nytpoc.model.MediaMetadata
import com.example.nytpoc.model.Results
import com.example.nytpoc.utils.Resource

class RepoTest : Repository {
    private var shouldReturnNetworkError = false
    private val results = mutableListOf<Results>()


    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getApiResponse(): Resource<ApiResponse<List<Results>>> {
        return if (shouldReturnNetworkError) {
            Resource.error("Error", null)
        } else {
            Resource.success(
                ApiResponse(
                    results = results.toList(),
                    copyright = "test",
                    num_results = 3,
                    status = "200"
                )
            )
        }

    }


    init {
        results.add(
            Results(
                abstract = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                adx_keywords = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                asset_id = 23,
                byline = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                column = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                des_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                eta_id = 2,
                geo_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                id = 3,
                media = listOf(
                    Media(
                        approved_for_syndication = 2,
                        caption = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        copyright = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        media = listOf(
                            MediaMetadata(
                                format = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                                height = 4,
                                url = "www.sdks.com",
                                width = 4
                            )
                        ),
                        subtype = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
                    )
                ),
                nytdsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                org_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                per_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                published_date = "23/1/2021",
                section = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                source = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                subsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                title = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                updated = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                uri = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                url = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
            )
        )
        results.add(
            Results(
                abstract = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                adx_keywords = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                asset_id = 23,
                byline = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                column = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                des_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                eta_id = 2,
                geo_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                id = 3,
                media = listOf(
                    Media(
                        approved_for_syndication = 2,
                        caption = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        copyright = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        media = listOf(
                            MediaMetadata(
                                format = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                                height = 4,
                                url = "www.sdks.com",
                                width = 4
                            )
                        ),
                        subtype = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
                    )
                ),
                nytdsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                org_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                per_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                published_date = "23/1/2021",
                section = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                source = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                subsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                title = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                updated = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                uri = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                url = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
            )
        )
        results.add(
            Results(
                abstract = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                adx_keywords = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                asset_id = 23,
                byline = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                column = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                des_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                eta_id = 2,
                geo_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                id = 3,
                media = listOf(
                    Media(
                        approved_for_syndication = 2,
                        caption = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        copyright = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        media = listOf(
                            MediaMetadata(
                                format = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                                height = 4,
                                url = "www.sdks.com",
                                width = 4
                            )
                        ),
                        subtype = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
                    )
                ),
                nytdsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                org_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                per_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                published_date = "23/1/2021",
                section = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                source = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                subsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                title = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                updated = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                uri = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                url = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
            )
        )
        results.add(
            Results(
                abstract = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                adx_keywords = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                asset_id = 23,
                byline = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                column = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                des_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                eta_id = 2,
                geo_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                id = 3,
                media = listOf(
                    Media(
                        approved_for_syndication = 2,
                        caption = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        copyright = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        media = listOf(
                            MediaMetadata(
                                format = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                                height = 4,
                                url = "www.sdks.com",
                                width = 4
                            )
                        ),
                        subtype = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
                    )
                ),
                nytdsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                org_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                per_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                published_date = "23/1/2021",
                section = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                source = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                subsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                title = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                updated = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                uri = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                url = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
            )
        )
        results.add(
            Results(
                abstract = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                adx_keywords = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                asset_id = 23,
                byline = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                column = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                des_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                eta_id = 2,
                geo_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                id = 3,
                media = listOf(
                    Media(
                        approved_for_syndication = 2,
                        caption = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        copyright = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        media = listOf(
                            MediaMetadata(
                                format = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                                height = 4,
                                url = "www.sdks.com",
                                width = 4
                            )
                        ),
                        subtype = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                        type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
                    )
                ),
                nytdsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                org_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                per_facet = listOf("Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"),
                published_date = "23/1/2021",
                section = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                source = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                subsection = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                title = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                type = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                updated = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                uri = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job",
                url = "Dismemberment of Tech C.E.O. Fahim Saleh Looks Like ‘Professional Job"
            )
        )
    }
}