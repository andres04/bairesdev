package pe.andres.bairesdev.data.entities

import pe.andres.bairesdev.domain.dtos.EventDTO

data class EventEntity(val topLabel: String,
                       val middleLabel: String,
                       val bottomLabel: String,
                       val eventCount: Int,
                       val image: String,
                       val targetId: Int,
                       val targetType: String,
                       val entityId: Int,
                       val entityType: String,
                       val startDate: Long,
                       val rank: Int) {



    companion object {

        fun toDTO(entity: EventEntity): EventDTO {
            entity.run {
                 return EventDTO(topLabel,
                        middleLabel,
                        bottomLabel,
                        eventCount,
                        image,
                        targetId,
                        targetType,
                        entityId,
                        entityType,
                        startDate,
                        rank)
            }
        }

        fun toDTOList(eventEntities: List<EventEntity>): List<EventDTO> {
            return mutableListOf<EventDTO>().apply {
                eventEntities.forEach {
                    add(toDTO(it))
                }
            }
        }

    }



}