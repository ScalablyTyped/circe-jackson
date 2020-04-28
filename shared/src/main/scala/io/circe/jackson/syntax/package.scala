package io.circe013.jackson

import io.circe013.Json

/**
 * This package provides syntax for Jackson printing via enrichment classes.
 */
package object syntax {
  implicit final class JacksonPrintingOps[A](val json: Json) extends AnyVal {
    final def jacksonPrint: String = io.circe013.jackson.jacksonPrint(json)
  }
}
