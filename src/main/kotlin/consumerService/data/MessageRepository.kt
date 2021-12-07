package consumerService.data


import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface MessageRepository : CrudRepository<Message, String> {
    // language=SQL
    @Query("""insert into messages (id, content, content_type, sent, username, user_avatar_image_link, created_on) 
        values (:id, :content, :content_type, :sent, :username, :user_avatar_image_link, :created_on)""")
    fun insertNew(@Param("id") id: String, @Param("content") content: String, @Param("content_type") content_type: String,
                  @Param("sent") sent: Long, @Param("username") username: String, @Param("user_avatar_image_link") user_avatar_image_link: String,
                  @Param("created_on") created_on: Long)
}