from basket import add_item, view_basket, delete_even_items, update_item, delete_even_items
from bill_manager import generate_bill, search_bill, get_bills
from tax_file_generator import export_tax_file_csv

def main():
    while True:
        print("\n--- POS SYSTEM MENU ---")
        print("1. Add Item")
        print("2. View Basket")
        print("3. Delete Item")
        print("4. Update Item")
        print("5. Generate Bill")
        print("6. Search Bill")
        print("7. Export Tax Transaction File (CSV)")
        print("8. Exit")

        choice = input("Choose an option: ")
        if choice == '1':
            add_item()
        elif choice == '2':
            view_basket()
        elif choice == '3':
            delete_even_items()
        elif choice == '4':
            update_item()
        elif choice == '5':
            generate_bill()
        elif choice == '6':
            search_bill()
        elif choice == '7':
            export_tax_file_csv(get_bills())
        elif choice == '8':
            print("Exiting...")
            break
        else:
            print("Invalid option. Try again.")

if __name__ == "__main__":
    main()
