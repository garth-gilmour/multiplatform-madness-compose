package desktop.model

data class Employee(val id: String, val name: String, val dept: Department) {
    override fun toString() = "$id - $name working in $dept"
}