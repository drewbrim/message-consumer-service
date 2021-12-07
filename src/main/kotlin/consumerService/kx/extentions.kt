package consumerService.kx

import java.util.*


fun String.uuid(): String =
    UUID.nameUUIDFromBytes(this.encodeToByteArray()).toString()