package rooms

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import spock.lang.Ignore

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Ignore
@Integration
class TodaySpec extends GebSpec {


    void "today is shown"() {
        when:
            go '/today/show'
        then:
        	title == "Today"
            $("output").text().startsWith("2023")
    }
}
