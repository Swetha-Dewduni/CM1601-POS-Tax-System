basket = []

def calculate_line_total(sale_price, quantity):
    return sale_price * quantity

def add_item():
    item_code = input("Item Code: ")
    price = float(input("Internal Price: "))
    discount = float(input("Discount: "))
    sale_price = float(input("Sale Price: "))
    quantity = int(input("Quantity: "))
    total = calculate_line_total(sale_price, quantity)
    basket.append({
        "item_code": item_code,
        "price": price,
        "discount": discount,
        "sale_price": sale_price,
        "quantity": quantity,
        "line_total": total
    })
    print("Item added.")

def view_basket():
    if not basket:
        print("Basket is empty.")
    else:
        print("\nCurrent Basket:")
        for idx, item in enumerate(basket, start=1):
            print(f"{idx}. {item}")
    print()

# def delete_item():
#     view_basket()
#     line = int(input("Enter line number to delete: ")) - 1
#     if 0 <= line < len(basket):
#         basket.pop(line)
#         print("Item deleted.")
#     else:
#         print("Invalid line number.")

def delete_even_items():
    view_basket()
    global basket

    basket = [item for index, item in enumerate(basket) if index % 2 != 0]
    print("Even line numbered items are deleted.")


def update_item():
    view_basket()
    line = int(input("Enter line number to update: ")) - 1
    if 0 <= line < len(basket):
        item = basket[line]
        item['sale_price'] = float(input(f"New Sale Price (old: {item['sale_price']}): "))
        item['discount'] = float(input(f"New Discount (old: {item['discount']}): "))
        item['quantity'] = int(input(f"New Quantity (old: {item['quantity']}): "))
        item['line_total'] = calculate_line_total(item['sale_price'], item['quantity'])
        print("Item updated.")
    else:
        print("Invalid line number.")


