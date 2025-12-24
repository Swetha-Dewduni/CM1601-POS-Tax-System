from basket import basket

bills = {}
bill_counter = 1

def generate_bill():
    global bill_counter
    if not basket:
        print("Basket is empty.")
        return None
    bill_number = f"BILL{bill_counter:04d}"
    bills[bill_number] = basket.copy()
    total = sum(item['line_total'] for item in basket)
    print(f"\nBill Generated - {bill_number}")
    for item in basket:
        print(item)
    print(f"Grand Total: {total}")
    basket.clear()
    bill_counter += 1
    return bill_number

def search_bill():
    bill_number = input("Enter bill number: ")
    if bill_number in bills:
        print(f"Bill: {bill_number}")
        for item in bills[bill_number]:
            print(item)
    else:
        print("Bill not found.")

def get_bills():
    return bills
