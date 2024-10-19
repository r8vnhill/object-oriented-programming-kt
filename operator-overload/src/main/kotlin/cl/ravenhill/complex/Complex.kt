package cl.ravenhill.complex

class Complex(val real: Double, val imaginary: Double) {

    operator fun plus(other: Complex) =
        Complex(real + other.real, imaginary + other.imaginary)
}

operator fun Complex.plus(value: Double) = Complex(real + value, imaginary)
