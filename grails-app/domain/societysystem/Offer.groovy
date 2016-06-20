package societysystem

class Offer {
    String description
    boolean activated

    def select() {
        if (activated) {
                return
        } else {
            activated = !activated
        }
    }
    static constraints = {
    }
}
