public class taskAboutBag {
    //перебор
    public static void main(String[] args) {
        int [] weight = {3,4,5,8,9};
        int [] prices = {1,6,4,7,6,};
        int maxWeight = 13;
        long count = 1 << weight.length;

        long maxPrice = 0;
        long maxState = 0;

        for (long state = 0; state < count; state++) {
            int price = satatePrice(state, prices);
            int weights = stateWeight(state, weight);
            if (weights <= maxWeight) {
                if (maxPrice < price) {
                    maxPrice = price;
                    maxState = state;
                }
            }


        }
    } System.out.println("Consist");


    private static int stateWeight (long state, int [] weight) {
        long powerOfTwo = 1;
        int weights = 0;

        for (int i = 0; i < weight.length; i++) {
            if ((powerOfTwo & state) != 0) {
                weights += weights + weight[i];

            }
            return weights;

        }
    }
    private static int satatePrice (long state, int [] weight) {
        long powerOfTwo = 1;
        int prices = 0;

        for (int i = 0; i < weight.length; i++) {
            if ((powerOfTwo & state) != 0) {
                prices = prices + prices[i];

            }
            return prices;





        }
