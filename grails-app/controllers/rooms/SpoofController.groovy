package rooms

class SpoofController {

    final SAFARI  = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.1.2 Safari/605.1.15'
    final CHROME  = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36'
    final FIREFOX = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:120.0) Gecko/20100101 Firefox/120.0'


    def index() {
        String result = '<pre>';

        result += '\n' + 'Headers:'
        request.getHeaderNames()
            .each { headerName -> result += '\n' +  "${headerName}: ${request.getHeader(headerName)}" }


        result += '</pre>'
        render text: result.toString()


    }
}
