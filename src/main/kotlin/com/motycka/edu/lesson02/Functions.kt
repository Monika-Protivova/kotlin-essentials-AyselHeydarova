package com.motycka.edu.lesson02

val coffeeOrders = mutableMapOf<Int, List<String>>()

fun main() {
    // You can write code here to try the functions
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    processOrder(listOf(ESPRESSO, CAPPUCCINO), 10.0)
    processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0) // will fail due to insufficient payment
}

/* Implement the functions below */

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    val change = payment - totalToPay

    if (payment < totalToPay) {
        throw  IllegalStateException("Insufficient payment. Total to pay is $totalToPay, but received $payment.")
    } else {
        completeOrder(orderId)
        println("Payment successful. Total paid: $payment, Total to pay: $totalToPay, change: $change")
    }

    return change
}

fun placerOrder(items: List<String>): Int {
    val orderId = coffeeOrders.size
    coffeeOrders[orderId] = items
    return orderId
}

fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: error("Order ID $orderId not found.")

    var totalPrice = 0.0
    val orderPrices = mutableListOf<Double>()

    items.forEach { item ->
        val price = getPrice(item)
        orderPrices.add(price);
        totalPrice += price
    }

    val discount: Double = if (items.size > 3) {
        println("You ordered 3 or more coffees, you get 1 for free!")
        orderPrices.min()
    } else {
        0.0
    }
    val total: Double = totalPrice - discount
    return total
}

fun completeOrder(orderId: Int) {
    coffeeOrders[orderId] ?: throw IllegalStateException("Order ID $orderId not found.")
    coffeeOrders.remove(orderId)
}

fun getPrice(item: String): Double {
    val price = when (item) {
        ESPRESSO -> ESPRESSO_PRICE
        CAPPUCCINO -> CAPPUCCINO_PRICE
        LATTE -> LATTE_PRICE
        AMERICANO -> AMERICANO_PRICE
        FLAT_WHITE -> FLAT_WHITE_PRICE
        DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
        else -> error("$item is not on the menu!")
    }
    return price
}
