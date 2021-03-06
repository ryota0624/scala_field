package com.github.ryota0624.field

import scala.reflect.macros.whitebox

object Field {
  def of[E](expr: E): Field[E] = macro FieldOfMacroImpl.fieldOf[E]
}

case class Field[V](value: V, name: String)

object FieldOfMacroImpl {
  def fieldOf[E](c: whitebox.Context)(expr: c.Expr[Any]): c.Expr[E] = {
    import c.universe._
    import com.github.dwickern.macros.NameOfImpl
    val nameExpr = NameOfImpl.nameOf(c)(expr)
    c.Expr(q"""
         import com.github.ryota0624.field.Field
         Field(${expr}, ${nameExpr})
       """)
  }
}
