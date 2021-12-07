package consumerService.services


import consumerService.data.MessageRepository
import consumerService.data.Message
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

import com.google.gson.Gson


@Service
class KafkaService {

    @Autowired
    lateinit var messageRepository: MessageRepository

    private val logger = LoggerFactory.getLogger(javaClass)


    @KafkaListener(topics = ["message.example"], groupId = "group-message-example-test-1", autoStartup = "true")
    fun processMessage(@Payload jsonMessage: String, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) key: String) {

        val gson = Gson()
        val message = gson.fromJson(jsonMessage, Message::class.java)
        val isNew = !messageRepository.existsById(key)
        if (isNew) {
            val (content, content_type, sent, username, user_avatar_image_link, created_on, id) = message
            messageRepository.insertNew(id, content, content_type.toString(), sent, username, user_avatar_image_link, created_on)
        } else {
            messageRepository.save(message)
        }

        logger.debug("$key was inserted")

    }
}