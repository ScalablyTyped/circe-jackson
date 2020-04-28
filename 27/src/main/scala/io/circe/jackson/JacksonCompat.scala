package io.circe013.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.{ DeserializationContext, JsonNode, ObjectMapper, ObjectWriter }
import com.fasterxml.jackson.databind.node.ObjectNode

private[jackson] trait JacksonCompat {
  protected def makeWriter(mapper: ObjectMapper): ObjectWriter = mapper.writerWithDefaultPrettyPrinter()

  protected def handleUnexpectedToken(context: DeserializationContext)(
    klass: Class[_],
    parser: JsonParser
  ): Unit =
    throw context.mappingException(klass)

  protected def objectNodeSetAll(node: ObjectNode, fields: java.util.Map[String, JsonNode]): JsonNode =
    node.setAll(fields)
}
