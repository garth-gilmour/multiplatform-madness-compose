package desktop.model

data class Person(var name: String, var age: Int) {
    override fun toString() = "$name aged $age"
}