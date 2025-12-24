import csv
from datetime import datetime

def calculate_checksum(line: str):
    uppercase = sum(1 for c in line if c.isupper())
    lowercase = sum(1 for c in line if c.islower())
    numbers = sum(1 for c in line if c.isdigit() or c == '.')
    return uppercase + lowercase + numbers


def export_tax_file_csv(bills):
    if not bills:
        print("No bills to export.")
        return

    now = datetime.now().strftime("%Y%m%d_%H%M%S")
    filename = f"tax_export_{now}.csv"
    with open(filename, mode='w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['bill_no', 'item_code', 'sale_price', 'quantity', 'line_total', 'checksum'])
        for bill_no, items in bills.items():
            for item in items:
                line = f"{bill_no},{item['item_code']},{item['sale_price']},{item['quantity']},{item['line_total']}"
                checksum = calculate_checksum(line)
                writer.writerow([
                    bill_no,
                    item['item_code'],
                    item['sale_price'],
                    item['quantity'],
                    item['line_total'],
                    checksum
                ])
    print(f"CSV tax file exported as '{filename}'")
