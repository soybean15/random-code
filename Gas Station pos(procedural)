from prettytable import PrettyTable
import datetime

inventory = []


def add_item():
    inventory.append(["Regular", 1500, 32.0])
    inventory.append(["Diesel", 1500, 50.0])
    inventory.append(["Unleaded", 1500, 40.50])

    # add total
    for row in inventory:
        qty = row[1]
        price = row[2]
        total = float(qty) * float(price)
        row.append(total)


def print_inventory(title):
    ptable = PrettyTable()
    ptable.title = title
    ptable.field_names = ["Product", "QTY", "Price", "Total"]
    for row in inventory:
        ptable.add_row(row)
    print(ptable)


def check_user(username, password):
    users = [["user1", "user01"], ["user2", "user2"], ["user3", "user3"]]
    for row in users:
        if row[0] == username:
            if row[1] == password:
                return True


def log_in_page():
    tries = 4
    while tries >= 0:
        print("Enter Username:", end="")
        username = input()
        print("Enter Password:", end="")
        password = input()

        if check_user(username, password):
            main_menu(username)
        else:
            print("Wrong Username and Password!")
            print("You have", tries, "left!")
            tries -= 1
    print("Too many attempt, the program will shutdown!")


def print_receipt(item_name, amount, litre, price, total_cash_amount):
    print("-----------------------------")
    print("  IT-GASOLINE TAKAL TAKAL")
    print("CALLOS PEÑARANDA NUEVA ECIJA")
    print("    Contact: 095744889")
    print("      SALES INVOICE")
    date = datetime.datetime.now()
    print("DATE:" + str(date))
    print("-----------------------------")
    litrestr = "%.2f" % litre
    print("%-8s" % "Pump", "%-12s" % "Litre", "Price")
    print("%-8s" % "01", "%-12s" % litrestr, "P%.3f" % price)
    print()
    print("%-12s" % "Product", "%-12s" % "Amount")
    change = total_cash_amount - amount
    amountstr = "P%.2f" % amount
    print("%-12s" % item_name, "%-12s" % amountstr)
    print()
    cashstr = "P%.2f" % total_cash_amount
    changestr = "P%.2f" % change
    print("Cash Amount:%-12s" % cashstr)
    print("Change:%-12s" % changestr)
    print()
    print()
    print("-----------------------------")
    print("         Thank you!")
    prompt = input("press any key to continue")


def sales_page():
    exit = 0
    print_inventory("Sales Page")
    select_item = int(input("Select item:"))

    item_name = inventory[select_item - 1][0]
    print("Item name: ", item_name)
    while exit <= 0:

        amount = int(input("Enter Amount to fill(minimum of 50):"))
        if amount < 50:
            print("minimum Amount is P50.00")
        else:
            price = inventory[select_item - 1][2]
            litre = amount / price

            print("Amount to fill:", amount)
            print("Volume: %.2f" % litre + "(litre)")

            print()
            total_cash = int(input("Enter Cash amount: "))
            print_receipt(item_name, amount, litre, price, total_cash)
            exit += 1


def add_product():
    try:
        name = input("Enter Product Name")
        qty = int(input("Enter Stock/litre"))
        price = int(input("Enter Price"))
        total = qty * price
        inventory.append([name, qty, float(price), float(total)])
        title = "New Product Added"
        print_inventory(title)
    except:
        print("Invalid Input! Try again!")


def update_stock():
    try:
        option = int(input("Select Product"))
        update_stock = int(input("Input updated Stocks"))
        price = inventory[option - 1][2]
        newtotal = update_stock * price
        inventory[option - 1][1] = update_stock
        inventory[option - 1][3] = newtotal
        print_inventory("Stock Updated!")
    except:
        print("Invalid Input! Try again!")


def update_price():
    try:
        option = int(input("Select Product"))
        update_stock = float(input("Input updated Price"))
        qty = inventory[option - 1][1]
        newtotal = update_stock * qty
        inventory[option - 1][2] = update_stock
        inventory[option - 1][3] = newtotal
        print_inventory("Price Updated!")
    except:
        print("Invalid Input! Try again!")


def inventory_page():
    print_inventory("Inventory")
    print("[1]Add Product")
    print("[2]Update Stocks")
    print("[3]Update Price")

    option = int(input("Select Option"))
    if option == 1:
        add_product()
    elif option == 2:
        update_stock()
    elif option == 3:
        update_price()


def main_menu(username):
    while True:
        try:
            print()
            print("___________________")
            print("Hello", username)
            print("___________________")
            print("Select Transaction")
            print("[1]Sales")
            print("[2]Inventory")
            option = int(input("Select Option"))
            if option == 1:
                sales_page()
            elif option == 2:
                inventory_page()
        except:
            print()
            print("Invalid Option!")


def main_page():
    add_item()
    log_in_page()


main_page()
