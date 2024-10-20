package cl.ravenhill.staticfn.rectangle

const val DEFAULT_UNIT = "cm²"

fun calculateRectangleArea(width: Int, height: Int) =
    "${width * height} $DEFAULT_UNIT"
