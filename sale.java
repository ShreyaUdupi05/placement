public class sale {

    public static int findHighestSalesDay(int[] sales) {
        // Initialize variables to keep track of the highest sales and the corresponding day
        int highestSales = Integer.MIN_VALUE;
        int dayWithHighestSales = -1;
        
        // Iterate through the sales array to find the highest sales
        for (int day = 0; day < sales.length; day++) {
            if (sales[day] > highestSales) {
                highestSales = sales[day];
                dayWithHighestSales = day;
            }
        }
        
        return dayWithHighestSales;
    }

    public static void main(String[] args) {
        int[] sales = {1200, 4500, 2300, 5200, 6100, 3050, 7100};
        int highestSalesDay = findHighestSalesDay(sales);
        System.out.println("The day with the highest sales is: Day " + (highestSalesDay + 1));
    }
}
