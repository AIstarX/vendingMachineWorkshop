package vendingmachineOption2;

import modelOption2.Product;

public class App {
    public static void main(String[] args) {
        VendingMachine vm = new CandyVendingMachine();

        vm.addCurrency(50);
        System.out.println("Balance: " + vm.getBalance());

        for (String product : vm.getProducts()) {
            System.out.println(product);
        }

        Product purchasedProduct = vm.request(1);
        System.out.println("Purchased: " + purchasedProduct.examine());

        int change = vm.endSession();
        System.out.println("Change returned: " + change);
    }
}
