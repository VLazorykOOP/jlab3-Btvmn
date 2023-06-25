public class SecondTask {
}
// Інтерфейс Pair
interface Pair {
    // Абстрактні арифметичні операції
    Pair add(Pair other);
    Pair subtract(Pair other);
    Pair multiply(Pair other);
}

// Похідний клас Complex
class Complex implements Pair {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Реалізація арифметичних операцій для комплексних чисел
    @Override
    public Pair add(Pair other) {
        if (other instanceof Complex) {
            Complex complex = (Complex) other;
            double sumReal = this.real + complex.real;
            double sumImaginary = this.imaginary + complex.imaginary;
            return new Complex(sumReal, sumImaginary);
        }
        return null;
    }

    @Override
    public Pair subtract(Pair other) {
        if (other instanceof Complex) {
            Complex complex = (Complex) other;
            double diffReal = this.real - complex.real;
            double diffImaginary = this.imaginary - complex.imaginary;
            return new Complex(diffReal, diffImaginary);
        }
        return null;
    }

    @Override
    public Pair multiply(Pair other) {
        if (other instanceof Complex) {
            Complex complex = (Complex) other;
            double prodReal = this.real * complex.real - this.imaginary * complex.imaginary;
            double prodImaginary = this.real * complex.imaginary + this.imaginary * complex.real;
            return new Complex(prodReal, prodImaginary);
        }
        return null;
    }

    // Перевантажений метод toString
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    // Перевантажений метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Complex complex = (Complex) obj;
        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.imaginary, imaginary) == 0;
    }
}

// Похідний клас Rational
class Rational implements Pair {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Реалізація арифметичних операцій для раціональних дробів
    @Override
    public Pair add(Pair other) {
        if (other instanceof Rational) {
            Rational rational = (Rational) other;
            int commonDenominator = this.denominator * rational.denominator;
            int sumNumerator = this.numerator * rational.denominator + rational.numerator * this.denominator;
            return new Rational(sumNumerator, commonDenominator);
        }
        return null;
    }

    @Override
    public Pair subtract(Pair other) {
        if (other instanceof Rational) {
            Rational rational = (Rational) other;
            int commonDenominator = this.denominator * rational.denominator;
            int diffNumerator = this.numerator * rational.denominator - rational.numerator * this.denominator;
            return new Rational(diffNumerator, commonDenominator);
        }
        return null;
    }

    @Override
    public Pair multiply(Pair other) {
        if (other instanceof Rational) {
            Rational rational = (Rational) other;
            int prodNumerator = this.numerator * rational.numerator;
            int prodDenominator = this.denominator * rational.denominator;
            return new Rational(prodNumerator, prodDenominator);
        }
        return null;
    }

    // Перевантажений метод toString
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Перевантажений метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rational rational = (Rational) obj;
        return numerator == rational.numerator &&
                denominator == rational.denominator;
    }
}
