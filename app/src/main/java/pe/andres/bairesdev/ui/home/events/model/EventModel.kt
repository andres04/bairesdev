package pe.andres.bairesdev.ui.home.events.model

data class EventModel (val topLabel: String,
                       val middleLabel: String,
                       val bottomLabel: String,
                       val eventCount: Int,
                       val image: String,
                       val targetId: Int,
                       val targetType: String,
                       val entityId: Int,
                       val entityType: String,
                       val startDate: Long,
                       val rank: Int)