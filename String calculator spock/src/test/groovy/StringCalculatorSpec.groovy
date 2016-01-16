import de.oetting.stringcalculator.NegativeNumberException
import de.oetting.stringcalculator.StringCalculator
import spock.lang.Specification

/**
 * Created by Hinnerk on 16.01.2016.
 */


class StringCalculatorSpec extends Specification  {

    def classUnderText = new StringCalculator()

    def "add with empty input returns 0"() {
        when:
            def result = classUnderText.add("");
        then:
            result == 0
    }

   def "add with one number as input returns this number"() {
        when:
            def result = classUnderText.add(input);
        then:
            result == output
        where:
            input << ["1",  "2"]
            output << [1 ,   2]
    }

   def "add with two numbers as input returns sum of numbers"() {
        when:
            def result = classUnderText.add(input);
        then:
            result == output
        where:
            input << ["1,2", "2,3"]
            output << [3   , 5]
    }

    def "add with two numbers split by newline returns sum of numbers"() {
        when:
            def result = classUnderText.add("1\n2");
        then:
            result == 3
    }

    def "add with custom delimiter returns sum of numbers"() {
        when:
            def result = classUnderText.add("//;\n1;2");
        then:
            result == 3
    }

   def "add with multiple numbers as input returns sum of numbers"() {
        when:
            def result = classUnderText.add(input);
        then:
            result == output
        where:
            input << ["1,2,3,4,5"]
            output << [15]
    }

    def "add with negative number throws exception"() {
        when:
            def result = classUnderText.add("-2");
        then:
            thrown(NegativeNumberException)
    }

    def "add with negative number shows number in exception"() {
        when:
            def result = classUnderText.add("-2");
        then:
            def e = thrown(NegativeNumberException)
            e.message.contains("-2");
    }

    def "add with multiple negative numbers shows all negative numbers in exception"() {
        when:
            def result = classUnderText.add("-1,-2");
        then:
            def e = thrown(NegativeNumberException)
            e.message.contains("-1");
            e.message.contains("-2");
    }

}
