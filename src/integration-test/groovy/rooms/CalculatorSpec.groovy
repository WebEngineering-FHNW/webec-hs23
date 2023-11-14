package rooms

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import spock.lang.Ignore

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class CalculatorSpec extends GebSpec {


    void "Basic calculation - expected to fail when security is on"() {
        when:
            go '/static/GradeCalculator.html?lang=en'
        then:
        	title == "Grade Calculator"

        when: "set valid input"
            $("form").en   = 5.0
            $("form").exam = 6.0
            $("input", type: "submit").click()

        then: "Result Page is displayed"
            title == "Average"
            $("output").text() == "5.5"


        when: "click on back link"
            $("a", text: "calculator").click()
        then:
            title == "Grade Calculator"
    }
    void "Basic calculation with secured access"() {
         when:
             go '/static/GradeCalculator.html?lang=en'

         then: "static entry point is unsecured"
            title == "Grade Calculator"

         when: "set valid input"
            $("form").en = 5.0
            $("form").exam = 6.0
            $("input", type: "submit").click()

         then: "security leads us to login" // uncomment if security is set to guest access
             title == "Anmeldung"

         when:
             $("form").username = "guest"
             $("form").password = "guest"
             $("input", type: "submit").click()

         then: "Result Page is displayed"
             title == "Average"
             $("output").text() == "5.5"

         when: "click on back link"
             $("a", text: "calculator").click()
         then:
             title == "Grade Calculator"

         when:
             go '/logout'
         then:
             title == 'Welcome to Grails'
     }

}
