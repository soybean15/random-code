import datetime
class Users:
    def __init__(self, username, password):
        self.username = username
        self.password = password

    def check_user(self, username, password):
        return self.username == username and self.password == password

class Item:
    def __init__(self, item, type, qty, price):
        self.item = item
        self.qty = qty
        self.price = price
        self.type = type
        self.total = price*qty

    def get_name(self):
        return self.item


    def print_receipt(self):
        qtystr = int(self.qty)
        totalprice = self.qty * self.price
        itemstr = str(qtystr)+"pcs "'%-16s' % self.item

        pricestr ='%-4s' % int(self.price)
        totalpricestr =str(totalprice)

        print(itemstr,pricestr, totalpricestr)

    def print_item(self, index):
        totalprice = self.qty * self.price
        itemstr = str(index) + "." + '%-20s' % self.item
        typestr = "|  " + '%-10s' % self.type
        qtystr = "|" + '%-3s' % int(self.qty)
        pricestr = "|" + '%-6s' % self.price
        totalpricestr = "|" + str(totalprice)

        print(itemstr, typestr, qtystr, pricestr, totalpricestr)


    def get_total(self):
        return self.total


def add_user():
    admin = Users("admin", "admin")
    user1 = Users("User1", "user1")
    user2 = Users("User2", "user123")
    users = [admin, user1, user2]
    return users


def check_user_pass(users, username, password):
    for i in users:
        if i.check_user(username, password):
            return True


def log_in_menu():
    users = add_user()

    while True:
        print("Enter UserName: ", end="")
        username = input()
        print("Enter Password: ", end="")
        password = input()

        if check_user_pass(users, username, password):
            show_transactions(username)

        else:
            print("Invalid User and Password")


items = []


def add_item():
    item_name = ["Nova", "V-Cut", "Mang Juan", "Coke", "Sprite", "Royal", "Gatorade", "Yakult"]
    type = ["Junkfood", "Junkfood", "Junkfood", "Beverage", "Beverage", "Beverage", "Beverage", "Beverage"]
    qty = [10, 10, 10, 10, 10, 10, 5, 12]
    price = [15.50, 15.00, 15.00, 15.00, 15.00, 15.00, 32.00, 12.00]

    for i in range(8):
        items.append(Item(item_name[i], type[i], float(qty[i]), price[i]))


def show_inventory():
    itemstr = '%-22s' % "Item Name"
    typestr = "|  " + '%-10s' % "Type"
    qtystr = "|" + '%-3s' % "QTY"
    pricestr = "|" + '%-6s' % "Price"
    totalpricestr = "|" + "Total"
    print()
    print("Inventory")
    print(itemstr, typestr, qtystr, pricestr, totalpricestr)
    print('{:-^56}'.format("-"))
    index = 1
    for i in items:
        i.print_item(index)
        index += 1
    print('{:-^56}'.format("-"))


def show_transactions(username):
    exit = 0
    while exit<=0:
        try:
            print("-------------------")
            print("Welcome", username)
            print("-------------------")
            print("1.Point of Sales")
            print("2.Inventory")
            print("3.Back to Log in")

            print("-------------------")
            choice = int(input("Select Transaction: "))

            if choice == 1:
                point_of_sales_page()
            elif choice == 2:
                inventory_page()
            elif choice == 3:
                exit+=1
        except:
            print()
            print("Invalid Selection")


def point_of_sales_page():
    print("Point of Sales")

    show_inventory()

    exit = 0
    while exit <= 0:

        try:
            option = int(input("Select Item: "))

            if option > len(items):
                print("Invalid Item Selection")
            else:
                if option <= 0:
                    menustr = '%-45s' % "[0]Remove[1]Clear[2]Receipt[3]Back"
                    cart_table(menustr)
                    submenu = int(input("Select Option:"))
                    if submenu == 0:
                        removeoption = int(input("Remove Item: "))
                        cart.pop(removeoption - 1)

                        cart_table('%-45s' % "[0]View Option")
                    elif submenu == 1:
                        cart.clear()

                        cart_table('%-45s' % "[0]View Option")
                    elif submenu == 2:
                        print_receipt()
                        exit += 1
                    elif submenu == 3:
                        exit += 1
                    else:
                        print("Invalid Input")
                else:
                    qty = int(input("Quantity "))
                    show_inventory()
                    print()
                    print()
                    add_to_cart(option, qty)
        except:
            print("Invalid Item Try again")


cart = []


def print_receipt():
    date = datetime.datetime.now()
    print()
    print()
    print("     Elena Sari Sari Store")
    print("Purok 1, Sinasajan, Peñaranda, N.E")
    print("        Tel: 0923734245")
    print("Date: " + str(date))
    line = '{:-^31}'.format("-")
    print(line)

    itemstr = '%-16s' % "Name"
    pricestr = '%-4s' % "Price"
    totalpricestr = "Total"

    print(itemstr, pricestr, totalpricestr)
    for c in cart:
        c.print_receipt()
    total = get_total()
    print(line)
    print('%25s' % "Total:" + str(total))
    print()
    print()
    print()
    print("          Thank You!")
    print()
    print()
    print()


def get_total():
    total = 0
    for c in cart:
        total = total + c.get_total()
    return total


def cart_table(menustr):
    count = 0
    total = 0
    print("Cart: ")
    itemstr = '%-22s' % "Item Name"
    typestr = "|  " + '%-10s' % "Type"
    qtystr = "|" + '%-3s' % "QTY"
    pricestr = "|" + '%-6s' % "Price"
    totalpricestr = "|" + "Total"

    print(itemstr, typestr, qtystr, pricestr, totalpricestr)
    print('{:-^56}'.format("-"))
    for c in cart:
        total = total + c.get_total()
        c.print_item(count + 1)
        count += 1

    print('{:-^56}'.format("-"))

    totalstr = "Total:" + str(total)
    print(menustr + totalstr)
    print()


def inventory_page():
    show_inventory()
    print("[1]Add")
    print("[2]Edit")
    print("[3]Delete")
    try:

        opt = int(input("Select Option"))

        if opt == 1:
            inventory_add()
        elif opt==2:
            inventory_edit()
        elif opt==3:
            inventory_delete()
    except:
        print("Invalid Selection")


def inventory_add():
    print('{:-^56}'.format("-"))
    print("ADD ITEM")
    print('{:-^56}'.format("-"))
    name = input("Add Item Name:")
    type = input("Type:")
    qty = int(input("QTY:"))
    price = int(input("Price:"))
    items.append(Item(name, type, float(qty), price))
    print('{:-^56}'.format("-"))
    print("Item Successfully Added")
    print('{:-^56}'.format("-"))
    show_inventory()


def inventory_edit():
    print('{:-^56}'.format("-"))
    print("Edit Item")
    print('{:-^56}'.format("-"))
    try:

        option = int(input("Select Item to edit:"))
        print("Edit name of (", getattr(items[option - 1], 'item'), ')to: ', end="")
        new_name = input()
        items[option - 1].item = new_name
        print("Edit type of(", getattr(items[option - 1], 'type'), ')to:', end="")
        new_type = input()
        items[option - 1].type = new_type
        print("Edit price of(", int(getattr(items[option - 1], 'price')), ')to:', end="")
        new_price = int(input())
        items[option - 1].price = float(new_price)
        print("Edit qty of(", getattr(items[option - 1], 'qty'), ')to:', end="")
        new_qty = int(input())
        items[option - 1].qty = new_qty
        show_inventory()
        print('{:-^56}'.format("-"))
        print("Item Successfully Updated")
        print('{:-^56}'.format("-"))
    except:
        print("Invalid Data, Try Again")


def inventory_delete():

    print('{:-^56}'.format("-"))
    print("Delete Item")
    print('{:-^56}'.format("-"))

    try:
        option = int(input("Select Item to Delete: "))
        print("Do you want to delete",getattr(items[option - 1], 'item'),"? y/n")
        tobedeleted = getattr(items[option - 1],'item')
        yn = input()
        if yn=='y':
            items.pop(option-1)
            print('{:-^56}'.format("-"))
            print(tobedeleted,"was deleted!")
            print('{:-^56}'.format("-"))
            show_inventory()
        else:
            print("Canceled")
    except:
        print("Invalid Option")


def add_to_cart(option, qty):
    cart.append(Item(items[option - 1].item, items[option - 1].type, float(qty), items[option - 1].price))
    cart_table('%-45s' % "[0]View Option")


def main_menu():
    add_item()
    log_in_menu()


main_menu()
