package ru.tbank.education.school.lesson3.accounting

abstract class Category(val name: String, var products: MutableList<Product>) {
    fun findProducts(request: String): MutableList<Product> {
        val result = products
        if (!name.contains(request)) {
            result.filter { it.name.contains(request) }.toMutableList()
        }
        return result
    }

    fun inventoryManagement() {
        this.products =
            this.products
                .groupBy { it.name }
                .map { (_, products) -> products.reduce { p, pn -> p + pn } }
                .toMutableList()
    }
}
