import java.util.HashMap;
import java.util.Map;

public class MostFrequentRating {

    public static int findMostFrequentRating(int[] ratings) {
        // Create a HashMap to store the frequency of each rating
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Iterate through the array and count the frequency of each rating
        for (int rating : ratings) {
            frequencyMap.put(rating, frequencyMap.getOrDefault(rating, 0) + 1);
        }
        
        // Find the rating with the highest frequency
        int mostFrequentRating = -1;
        int maxFrequency = 0;
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentRating = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        
        return mostFrequentRating;
    }

    public static void main(String[] args) {
        int[] ratings = {4, 2, 5, 4, 3, 4, 2, 5, 5, 2, 4};
        int mostFrequentRating = findMostFrequentRating(ratings);
        System.out.println("The most frequent rating is: " + mostFrequentRating);
    }
}
