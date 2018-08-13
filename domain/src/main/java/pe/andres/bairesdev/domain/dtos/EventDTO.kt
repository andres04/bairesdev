package pe.andres.bairesdev.domain.dtos

data class EventDTO (val topLabel: String,
                     val middleLabel: String,
                     val bottomLabel: String,
                     val eventCount: Int,
                     val image: String,
                     val targetId: Int,
                     val targetType: String,
                     val entityId: Int,
                     val entityType: String,
                     val startDate: Long,
                     val rank: Int,
                     var visible: Boolean = true)