package rooms

class TodayController {
    def show(int offset) {
        def today = new Date()
        def offsetIsWrong = ""
        if (offset < 0 ) {
            offsetIsWrong = "error"
        } else {
            today.setHours(offset)
        }
        render view:"TodayView", model: [day: today.toString(), offsetClass: offsetIsWrong]
    }
}
