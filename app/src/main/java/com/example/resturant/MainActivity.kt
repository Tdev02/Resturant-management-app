package com.example.resturant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val menuItems = listOf(
        MenuItem("Pizza", "Delicious cheese pizza", 10.0),
        MenuItem("Burger", "Juicy beef burger", 8.0),
        MenuItem("Pasta", "Creamy Alfredo pasta", 12.0)
    )

    private val orderItems = mutableListOf<OrderItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuListView: ListView = findViewById(R.id.menu_list_view)
        val orderButton: Button = findViewById(R.id.order_button)

        val menuAdapter = MenuAdapter(this, menuItems)
        menuListView.adapter = menuAdapter

        menuListView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = menuItems[position]
            addItemToOrder(selectedItem)
        }

        orderButton.setOnClickListener {
            showOrder()
        }
    }

    private fun addItemToOrder(menuItem: MenuItem) {
        val existingOrderItem = orderItems.find { it.menuItem == menuItem }
        if (existingOrderItem != null) {
            existingOrderItem.quantity++
        } else {
            orderItems.add(OrderItem(menuItem, 1))
        }
        Toast.makeText(this, "${menuItem.name} added to order", Toast.LENGTH_SHORT).show()
    }

    private fun showOrder() {
        // Show the current order (this can be replaced with a new activity or a dialog)
        val orderSummary = orderItems.joinToString("\n") {
            "${it.menuItem.name} x${it.quantity} - $${it.menuItem.price * it.quantity}"
        }
        Toast.makeText(this, orderSummary, Toast.LENGTH_LONG).show()
    }
}
