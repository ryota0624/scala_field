package com.github.ryota0624.field

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class FieldSpec extends AnyWordSpecLike with Matchers {
  case class Data(a: Int)
  "Field.of" should {
    "field name a" in {
      val data = Data(100)
      val field = Field.of(data.a)
      field should be(Field(100, "a"))
    }

    "field name fieldA" in {
      val data = Data(100)
      val fieldA = data.a
      val field = Field.of(fieldA)
      field should be(Field(100, "fieldA"))
    }

    "field name apply" in {
      val field = Field.of(Data(100))
      field should be(Field(Data(100), "apply"))
    }
  }
}
