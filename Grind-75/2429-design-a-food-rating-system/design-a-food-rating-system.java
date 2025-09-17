class FoodRatings {
    Map<String, TreeSet<String>> cuisineToFood;
    Map<String, String> cuisines;
    Map<String, Integer> ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.cuisines = new HashMap<>();
        this.ratings = new HashMap<>();
        cuisineToFood = new HashMap<>();
        for (int i = 0; i < foods.length; ++i) {
            cuisineToFood.putIfAbsent(cuisines[i], new TreeSet<>((f1, f2) -> {
                int cmp = this.ratings.get(f2) - this.ratings.get(f1);
                if (cmp == 0) return f1.compareTo(f2);
                return cmp;
            }));
            this.ratings.put(foods[i], ratings[i]);
            this.cuisines.put(foods[i], cuisines[i]);
            cuisineToFood.get(cuisines[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = cuisines.get(food);
        TreeSet<String> foods = cuisineToFood.get(cuisine);
        foods.remove(food);
        ratings.put(food, newRating);
        foods.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFood.get(cuisine).getFirst();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */