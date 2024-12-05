package com.example.foodicsandroidtask.model

val SampleProducts = listOf(
    Product(
        id = "p1",
        name = "Pancakes",
        description = "Fluffy pancakes with syrup",
        image = "https://drive.google.com/uc?id=1MnxWm74GP3BW_qO3kEBqjoIZjkPckvLv",
        price = 5.0,
        category = Category("1", "Breakfast")
    ),
    Product(
        id = "p2",
        name = "Burger",
        description = "Juicy beef burger with cheese",
        image = "https://drive.google.com/uc?id=1kgSYBqCBvLBjdmIR25Ox7pzbwJ_0eKPB",
        price = 8.0,
        category = Category("2", "Lunch")
    ),
    Product(
        id = "p3",
        name = "Caesar Salad",
        description = "Fresh lettuce with Caesar dressing",
        image = "https://drive.google.com/uc?id=1ES_o6HcPcLl4kSWPVrNAHWx6AFLVBUen",
        price = 6.5,
        category = Category("3", "Salad")
    ),
    Product(
        id = "p4",
        name = "Grilled Chicken",
        description = "Tender grilled chicken with herbs",
        image = "https://drive.google.com/uc?id=1KJ7YvHWkVvbPmlIFii7YgHSGEnuVn_PO",
        price = 10.0,
        category = Category("2", "Lunch")
    ),
    Product(
        id = "p5",
        name = "Margarita Pizza",
        description = "Classic pizza with fresh basil",
        image = "https://drive.google.com/uc?id=1OudOIeA3kJ-5X91G-tplKpJy5B-Dus49",
        price = 9.0,
        category = Category("2", "Lunch")
    ),
    Product(
        id = "p6",
        name = "Chocolate Cake",
        description = "Rich chocolate cake slice",
        image = "https://drive.google.com/uc?id=17wJ1JrlblhMKRIMiuU0laXNOEUPJ38t2",
        price = 4.5,
        category = Category("4", "Dessert")
    ),
    Product(
        id = "p7",
        name = "French Fries",
        description = "Crispy golden fries",
        image = "https://drive.google.com/uc?id=1cITj5SKdM9GRF-Vy27QGC6HaV9ikX50C",
        price = 3.0,
        category = Category("5", "Sides")
    ),
    Product(
        id = "p8",
        name = "Espresso",
        description = "Strong and bold espresso shot",
        image = "https://drive.google.com/uc?id=1Xv2qSiRXW9QMoqj21QsdnWQyz66iwSIu",
        price = 2.5,
        category = Category("6", "Beverages")
    ),
    Product(
        id = "p9",
        name = "Ice Cream",
        description = "Vanilla ice cream with chocolate sauce",
        image = "https://drive.google.com/uc?id=1zl8qkZeSyZJJsrtpK1kA3rwrBcbgXEA4",
        price = 4.0,
        category = Category("4", "Dessert")
    ),
    Product(
        id = "p10",
        name = "Smoothie",
        description = "Fresh fruit smoothie",
        image = "https://drive.google.com/uc?id=1QGolYaf-xskOM4Hudtf81i000c-dwwyp",
        price = 5.0,
        category = Category("6", "Beverages")
    ),
    Product(
        id = "p11",
        name = "Veggie Wrap",
        description = "Whole grain wrap with fresh vegetables",
        image = "https://drive.google.com/uc?id=1h0dQrsnbePudnZ2iaKEnSiLEr3B-M2HT",
        price = 7.5,
        category = Category("2", "Lunch")
    ),
    Product(
        id = "p12",
        name = "Waffles",
        description = "Golden waffles with syrup",
        image = "https://drive.google.com/uc?id=11qDjauR_uNmu3NlGlR1JOGDDGZGX90dH",
        price = 6.0,
        category = Category("1", "Breakfast")
    ),
    Product(
        id = "p13",
        name = "Grilled Salmon",
        description = "Perfectly grilled salmon fillet",
        image = "https://drive.google.com/uc?id=1JetHcS1qTl-wht9MoxuDEY0X8BqWEoBs",
        price = 12.0,
        category = Category("2", "Lunch")
    ),
)


val SampleCategories = listOf(
    Category("1", "Breakfast"),
    Category("2", "Lunch"),
    Category("3", "Salad"),
    Category("4", "Dessert"),
    Category("5", "Sides"),
    Category("6", "Beverages")
)
