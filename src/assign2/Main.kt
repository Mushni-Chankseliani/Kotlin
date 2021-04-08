package assign2

fun main() {
    var f1 = Fraction()
    f1.numerator = 6F
    f1.demonimator = 2F

    var f2 = Fraction()
    f2.numerator = 5F
    f2.demonimator = 3F

    println(f1.sum(f2))
    println(f1.mult(f2))
    println(f1.divider())


}

class Fraction {
    var numerator: Float = 0F
    var demonimator: Float = 1F

    fun divider() {
        var gcd = 1.0;
        var i = 1.0;

        if (numerator < demonimator) {

            while (i <= numerator && i <= demonimator) {
                if (numerator % i == 0.0 && demonimator % i == 0.0) {
                    gcd = i
                }
                ++i
            }
        } else {
            while (i <= demonimator && i <= numerator) {
                if (demonimator % i == 0.0 && numerator % i == 0.0) {
                    gcd = i
                }
                ++i
            }
        }
        var dividedNum = numerator / gcd;
        var dividedDem = demonimator / gcd;
        println("amis $numerator / $demonimator shekvecili aris $dividedNum / $dividedDem")
    }

    fun mult(value: Any?) {
        var localNum: Float;
        var localDem: Float;

        if (value is Fraction) {
            localNum = numerator * value.numerator;
            localDem = demonimator * value.demonimator;

            println("namravli aris $localNum / $localDem");
        }
    }

    fun sum(value: Any?) {
        var localDem: Float;
        var sumOfNums: Float;

        if (value is Fraction) {
            localDem = demonimator * value.demonimator;
            sumOfNums = (numerator * value.demonimator) + (value.numerator * demonimator);

            println("jami aris $sumOfNums / $localDem");
        }
    }


}
